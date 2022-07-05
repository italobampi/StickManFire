package com.mygdx.game.hubtop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.player.Player;

public class PortaE extends Sprite {
    public PortaE(){
        super(MyGdxGame.loading.getManager().get
                        ("portaesquerda.png", Texture.class)
                , 0, 0,200 ,300 );
        this.setSize(150,225);
        this.setPosition(0,0);

    }
    public void draw(final SpriteBatch batch, final float delta) {
        super.draw(batch);
    }



}
