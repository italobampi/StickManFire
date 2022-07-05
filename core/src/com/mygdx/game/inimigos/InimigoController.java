package com.mygdx.game.inimigos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.bullet.Arma;
import com.mygdx.game.bullet.Bullet;
import com.mygdx.game.bullet.BulletController;
import com.mygdx.game.player.Player;

import java.util.ArrayList;

public class InimigoController {
    public static InimigoController ref;
    static final int INITIAL_CAPACITY = 7;
    static final int DISTANCE = 300;
    static float timer = 0;

    private static ArrayList<Inimigo> activeInimigos, deadInimigos;

    public InimigoController() {
        ref = this;
        init();
    }

    static void init() {
        activeInimigos = new ArrayList<Inimigo>(INITIAL_CAPACITY);
        deadInimigos = new ArrayList<Inimigo>();


    }

    public static void newInimigo() {
        Inimigo inimigo;
        if (deadInimigos.size() > 0) {

            inimigo = deadInimigos.remove(0);
        } else {
            inimigo = new Inimigo();
        }

        inimigo.setPosition(Player.ref.getCenterX() + DISTANCE, 100);

        activeInimigos.add(inimigo);
    }


    static void update(float delta) {

        for (int k = 0; k < activeInimigos.size(); k++) {

            if (verifyHit(BulletController.ref.activeBullets)) {
                activeInimigos.get(k).setReceiveDamage(10);
                if (!activeInimigos.get(k).isLive())
                    deadInimigos.add(activeInimigos.remove(k));
            }
        }
        spawInimigo(delta);


    }


    public static void draw(SpriteBatch batch, float delta) {
        update(delta);
        for (int k = 0; k < activeInimigos.size(); k++) {
            activeInimigos.get(k).draw(batch, delta);
        }

    }

    public static boolean verifyHit(ArrayList<Bullet> bullets) {
        boolean hited = false;
        for (int k = 0; k < bullets.size(); k++) {
            Bullet bullet = bullets.get(k);
            if (verifyPointHit(bullet.getCenterX(), bullet.getCenterY())) {
                hited = true;
                bullet.hasHit();
            }
        }
        return hited;
    }

    public static boolean verifyPointHit(float x, float y) {
        boolean hit = false;
        for (Inimigo inimigo : activeInimigos) {
            hit = inimigo.verifyPointHit(x, y);
        }
        return hit;
    }

    public static void spawInimigo(float delta) {
        timer += delta;
        if (timer > 5) {
            timer -= 5;
            newInimigo();
        }
    }

    public void troca(boolean direita) {
        if (direita) {
            for (Inimigo inimigo : activeInimigos) {
                inimigo.setX(inimigo.getX() - Gdx.graphics.getWidth());
            }
        }



    }
}