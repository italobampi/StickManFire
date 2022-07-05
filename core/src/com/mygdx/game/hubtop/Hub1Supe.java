package com.mygdx.game.hubtop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Hub1Supe extends Sprite{
    int tamanhoH = Gdx.graphics.getHeight()/5;
    int pX =0;
    int pY = Gdx.graphics.getHeight() - tamanhoH;
    public Hub1Supe ref;
    VidaController vidaController = new VidaController(pX,pY);

    public Hub1Supe() {
        super(MyGdxGame.loading.getManager().get
                        ("chao.png", Texture.class)
                , 0, 0, 800, 100);
        this.setSize(this.getWidth(), this.getHeight());
        this.setPosition(0,pY);
        ref = this;


    }
    public void draw(final SpriteBatch batch, final float delta) {

        this.draw(batch);
        vidaController.render(batch,delta);
    }

}
