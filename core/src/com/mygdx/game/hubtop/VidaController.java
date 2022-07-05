package com.mygdx.game.hubtop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.player.Player;

import java.util.ArrayList;

public class VidaController {

    public ArrayList<Coracoes> arrayCoracoes;
    private int posiX , posiY;
    private int distancia = 30;
    public static VidaController ref;
    int health =Player.ref.getHealth();
    int vida =0;
    int zvar;
    int x;


    public VidaController(int posiX,int posiY) {
        ref = this;
        this.posiX = posiX;
        this.posiY =   posiY;
        arrayCoracoes = new ArrayList<Coracoes>(10);
        health = Player.ref.getHealth();

        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        newCoracao();
        init();
    }


    public void init() {



    }

    public void newCoracao() {

        Coracoes coracoes;

            coracoes = new Coracoes();

        setCoracao(coracoes);


        arrayCoracoes.add(coracoes);
    }

    public void render(SpriteBatch batch, float delta) {
        update();

        for (int k = 0; k < arrayCoracoes.size(); k++) {
            arrayCoracoes.get(k).draw(batch, delta);
        }

    }

    public void update() {
        int x = posiX;
        health= Player.ref.getHealth();

        for (int k = 0 , vida =health; k < arrayCoracoes.size(); k++) {
            Coracoes coracoes = arrayCoracoes.get(k);
            //setCoracao( coracoes);
            if (vida > 10) {
                vida= vida- 10;
                coracoes.setCoraçao(x, posiY, 0);
            }  if (vida < 10 && vida > 5) {
                vida = vida-5;
                coracoes.setCoraçao(x, posiY, 1);
            }  if (vida < 5 && vida > 0) {
                coracoes.setCoraçao(x, posiY, 2);
                vida = 0;
            }
            System.out.println( vida);
            x += distancia;
        }







    }
   public void setCoracao( Coracoes coracoes){
int regiao=0;

       if (vida > 10) {
           vida -= 10;
           regiao=0;
       } else if (vida < 10 && vida > 5) {
           vida -= 5;
           regiao=1;
       } else if (vida < 5 && vida > 0) {
           regiao=2;
           vida = 0;
       }
       coracoes.setCoraçao(x, posiY, regiao);
       x += distancia;
    }

    public void setPosiXY(int posiX, int posiY) {
        this.posiX = posiX;
        this.posiY =   posiY;
    }


}

