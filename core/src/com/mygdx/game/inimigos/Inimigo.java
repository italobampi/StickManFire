package com.mygdx.game.inimigos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.input.InputProcessor;
import com.mygdx.game.player.Player;

public class Inimigo extends Sprite {
    boolean live;
    private static final int HEALTH = 60;
    private static final int DAMAGE = 5;
    private static final int SPEED = 90;
    private static final int TIME = 7;
    private int idRegionY = 1;
    private int idRegionX = 1;
    private int receiveDamage =0;
    private float timer =0;
    private float timerD =0;
    private Sound grunido = MyGdxGame.loading.getManager()
            .get("Minecraft Zombie Sound Effect.mp3",Sound.class);
    private Sound death = MyGdxGame.loading.getManager()
            .get("Minecraft-death-sound.mp3",Sound.class);

    public Inimigo() {
        super(MyGdxGame.loading.getManager().get
                        ("mann1.png", Texture.class)
                , 128, 0, 128, 128);
        this.setSize(this.getWidth()/4*3, this.getHeight()/4*3);
        setY(70);
        live=true;

    }
//    public void setPosition(Inimigo inimigo, int distance){
//        this.setX(inimigo.getX() + distance);
//    }

    public void draw(SpriteBatch batch,float delta) {
        this.update(delta);
        this.draw(batch);
    }

    private void update(float delta) {
       anda(delta);
        animaAndando();
        this.setRegion(128 * idRegionX, 128 * idRegionY, 128, 128);
        sound(delta);
    }
    public void anda(float delta){
        if (Player.ref.getCenterX()>this.getX()){
            this.setX(this.getX()+SPEED*delta);
        }else if (Player.ref.getCenterX()<this.getX()){
            this.setX(this.getX()-SPEED*delta);
        }
        if ((Player.ref.getCenterX()-this.getX())<10 && (this.getX()-Player.ref.getCenterX())<10){
            timerD+=delta;
           if (timerD>=3){
               timerD-=3;
               Player.ref.recebeDano(5);
           }
        }
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }

    public void setReceiveDamage(int damage) {
        this.receiveDamage += damage;
        if (receiveDamage>=HEALTH) {
            setLive(false);
            death.play();
            receiveDamage=0;

        }

    }

    public void sound(float delta){
        timer+=delta;
        if (timer>=TIME){
            timer-=TIME;
            if (isLive())
                grunido.play();
        }
    }

    public boolean verifyPointHit(float x, float y) {
        return this.getX() < x && this.getY() < y &&
                x < this.getX() + this.getWidth() &&
                y < this.getY() + this.getHeight();
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

}
