package com.mygdx.game.hubtop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Coracoes extends Sprite {
    public Coracoes(){

        super(MyGdxGame.loading.getManager().get
                        ("pngwing.com.png", Texture.class)
                , 15, 0, 264, 300);
        this.setSize(this.getWidth()/10, this.getHeight()/10);
        setY(100);

    }


    public void draw(final SpriteBatch batch, final float delta) {
        this.draw(batch);
    }

    public  void setCoraçao(int px, int py, int regiao){

        if (regiao==0)
            this.setRegion(15,0,264,300);
        else if (regiao==1)
            this.setRegion(308,0,266,300);
        else
            this.setRegion(601,0,266,300);
        this.setPosition(px,py);



    }
}
