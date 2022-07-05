package com.mygdx.game.bullet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.inimigos.InimigoController;
import com.mygdx.game.input.InputProcessor;
import com.mygdx.game.player.Player;

public class Arma extends Sprite {
    public static Arma ref;

    public Arma(){
        super(MyGdxGame.loading.getManager().get
                    ("bulletarm.png", Texture.class)
            , 0, 0, 16, 12);

        ref = this;

    }
    public void draw(final SpriteBatch batch, final float delta) {
        update(delta);
        super.draw(batch);


    }
    private void update(float delta) {

        Player  player =Player.ref;
        this.setPosition(player.getCenterX()+30, player.getCenterY()+20 );

    }




    public float getCenterX(){
        return this.getX()+(this.getWidth()/2);
    }
    public float getCenterY(){
        return this.getY()+(this.getHeight()/2);
    }
}
