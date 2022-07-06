package com.mygdx.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Fundo extends Sprite {
    public Fundo(){
        super(MyGdxGame.loading.getManager().get
                        ("stick-sam.png", Texture.class)
                , 55, 20,781 ,806 );
        this.setSize(640,480);
        this.setPosition(0,0);

    }
    public void draw(final SpriteBatch batch, final float delta) {
        super.draw(batch);
    }
}
