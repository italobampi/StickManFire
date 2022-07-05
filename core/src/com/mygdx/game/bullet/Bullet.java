package com.mygdx.game.bullet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Loading;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.inimigos.InimigoController;

public class Bullet extends Sprite {
    float imgX = 0, imgY = 0;
    float x = imgX, y = imgY;
    float ratio;
    boolean c1 = false;
    boolean hited = false;
    float velox = 0, veloy = 0;

    private static final int VELOCITY = 500;
    Arma arma = Arma.ref;
    public static Bullet ref;

    public Bullet() {
        super(MyGdxGame.loading.getManager().get
                        ("bulletarm.png", Texture.class)
                , 0, 14, 8, 6);
        this.setPosition(arma.getCenterX() + 6, arma.getCenterY() + 3);
        ref = this;


    }

    public void draw(final SpriteBatch batch, final float delta) {
        percore(delta);
        this.draw(batch);
    }

    public void setAlvo(int ckx, int cky) {
        this.setPosition(arma.getCenterX() + 6, arma.getCenterY() + 3);
        imgY = getY();
        imgX = getX();
        this.x = ckx;
        this.y = cky;
        float width = (int) (x - imgX), height = (int) (y - imgY);

        if (width != 0 && height != 0)
            ratio = Math.abs(width / height);
        else
            ratio = 1;
        hited = false;
        c1 = false;
    }


    public void percore(float delta) {
        if (!c1) {
            float width = (int) (x - imgX), height = (int) (y - imgY);
            float dX = width / Math.abs(width), dY = height / Math.abs(height);

            if (width == 0) dX = 0;
            if (height == 0) dY = 0;
            if (Float.isNaN(ratio)) ratio = 1;

            imgX += dX * 0.75 * ratio;
            imgY += dY * 0.75;
            veloy = dY * 0.75f;
            velox = dX * 0.75f * ratio;
            c1 = true;
            this.setPosition(imgX, imgY);
        } else {
            this.setPosition(getX() + velox, getY() + veloy);
        }
    }


    public boolean isOutOfscreen() {
        return (this.getX() > Gdx.graphics.getWidth() || this.getX() < 0 ||
                this.getY() > Gdx.graphics.getHeight() || this.getY() < 0);
    }

    public void hasHit() {
        hited = true;
    }

    public float getCenterX() {
        return this.getX() + (this.getWidth() / 2);
    }

    public float getCenterY() {
        return this.getY() + (this.getHeight() / 2);
    }
}
