package com.mygdx.game.hubtop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class PortaD extends Sprite {
    public PortaD(){
        super(MyGdxGame.loading.getManager().get
                        ("portadireita.png", Texture.class)
                , 0, 0,200 ,300 );
        this.setSize(150,225);
        this.setPosition(Gdx.graphics.getWidth()-this.getWidth(),0);

    }
    public void draw(final SpriteBatch batch, final float delta) {
        super.draw(batch);
    }



}
