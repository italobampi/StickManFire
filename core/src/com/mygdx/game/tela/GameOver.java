package com.mygdx.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class GameOver implements Screen {
    SpriteBatch batch;
    Texture texture;
    MyGdxGame game;

    public GameOver(MyGdxGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        texture = new Texture("Gameover.png");

    }

    @Override
    public void render(float delta) {
        batch.draw(texture,0,0);
        if (Gdx.input.isTouched()){

        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();

    }
}
