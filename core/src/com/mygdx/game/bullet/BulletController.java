package com.mygdx.game.bullet;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Particula;
import com.mygdx.game.input.InputProcessor;

import java.awt.*;
import java.util.ArrayList;

public class BulletController {
    public static BulletController ref;
    public ArrayList<Bullet> activeBullets, deadBullets;

    public BulletController() {
        init();
        ref = this;
    }

    public void init() {
        activeBullets = new ArrayList<Bullet>(20);
        deadBullets = new ArrayList<Bullet>();
    }

    public void newBullet(int x, int y) {
        Arma arma = Arma.ref;
        Bullet bullet;
        if (deadBullets.size() > 0) {
            bullet = deadBullets.remove(0);
        } else {
            bullet = new Bullet();
        }
        bullet.setAlvo(x, y);
        bullet.setPosition(arma.getCenterX() + 6, arma.getCenterY() + 3);
        activeBullets.add(bullet);
    }

    public void render(SpriteBatch batch, float delta) {
        for (int k = 0; k < activeBullets.size(); k++) {
            activeBullets.get(k).draw(batch, delta);
        }
        update(delta);
    }

    public void update(float delta) {
        for (int k = 0; k < activeBullets.size(); k++) {
            Bullet bullet = activeBullets.get(k);
            if (bullet.isOutOfscreen()) {
                deadBullets.add(activeBullets.remove(k));
            }
            if (bullet.hited)
                deadBullets.add(activeBullets.remove(k));
        }
    }


}
