package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.inimigos.InimigoController;
import com.mygdx.game.input.InputProcessor;
import com.mygdx.game.tela.GameOver;

public class Player extends Sprite {
    private InputProcessor meuInputProcessor;
    float quantx = 0;
    private float timer;
    private float timerp=0;
    private int idRegionY = 1;
    private int idRegionX = 1;
    private boolean retornoAnimaçao = false;
    public static Player ref;
    private final float GRAVITY = 200.0f;
    private final float INVERSE_GRAVITY = 10.0f;
    private boolean isJumping = false;
    private int health =100;
    private int pulo=0;

    public Player() {
        super(MyGdxGame.loading.getManager().get
                        ("mann1.png", Texture.class)
                , 0, 0, 128, 128);
        meuInputProcessor = InputProcessor.getInstance();
        this.setSize(this.getWidth()/4*3, this.getHeight()/4*3);
        setY(100);
        ref = this;

        MyGdxGame.addInputProcessor(meuInputProcessor);
    }

    public void draw(final SpriteBatch batch, final float delta) {
        update(delta);
        anima(delta);
        this.draw(batch);
    }

    public void update(final float delta) {
        if (meuInputProcessor.isDpres) {
            this.setX(this.getX() + 100 * delta);
        }
        if (meuInputProcessor.isApres) {
            this.setX(this.getX() - 100 * delta);
        }
        if (isJumping) {
               timerp += delta;
               animaPulo();
               this.setY(this.getY() + (INVERSE_GRAVITY));

               if (timerp > 0.2) {
                   timerp -= 0.2;
                   setIsJumping(false);
               }
        }
        hited();
        isOutOfscreen();
    }

    public void anima(final float delta) {
        timer += delta;
        if (meuInputProcessor.isApres ) {
            animaAndando();
        }
        else if (meuInputProcessor.isDpres) {
            animaAndando();
        }else if (meuInputProcessor.isSpres) {
            animaAgachar();
        }  else
            animaParado();
        if (this.getY() > 100)
            this.setY(this.getY() - (GRAVITY * delta));
        else if (this.getY() == 100)
            pulo=0;
        this.setRegion(128 * idRegionX, 128 * idRegionY, 128, 128);

    }

    public void animaPulo() {
        idRegionY = 1;
        idRegionX=3;
    }

    public void animaAgachar() {
        int limite = 4;
        idRegionY = 2;
        if (idRegionX == limite)
            idRegionX = 0;
        if (idRegionX != 1) {
            if (timer > 0.2) {
                timer -= 0.2;
                idRegionX++;
            }
        }
    }

    public void animaAndando() {
        int limite;
        idRegionY = 3;
        limite = 10;
        if (idRegionX == limite)
            idRegionX = 0;
        if (timer > 0.10) {
            timer -= 0.10;
            idRegionX++;
        }
    }

    public void animaParado() {
        idRegionY = 0;
        idRegionX = 1;
    }

    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public void hited() {
        if (InimigoController.verifyPointHit(getX(), getY())) {
            System.out.println("Player morto");
        }
    }



    public float getCenterX() {
        return this.getX() + (this.getWidth() / 2);
    }

    public float getCenterY() {
        return this.getY() + (this.getHeight() / 2);
    }

    public int getHealth() {
        return health;
    }
    public void recebeDano(int dano){
        health-=dano;
        if (health <=0){
            MyGdxGame.ref.setTela(2);
        }
    }
    public void isOutOfscreen() {
       if( getX() > Gdx.graphics.getWidth()){
           this.setX(getX()-Gdx.graphics.getWidth());
           InimigoController.ref.troca(true);
       }

       else if(this.getX() < 0 )
           this.setX(Gdx.graphics.getWidth());
        InimigoController.ref.troca(false);
    }
}
