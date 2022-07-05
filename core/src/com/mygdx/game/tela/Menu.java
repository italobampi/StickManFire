package com.mygdx.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

public class Menu implements Screen {
    SpriteBatch batch;
    Texture img;
    MyGdxGame game;
    int indice;
    public Menu( MyGdxGame game){

        this.game=game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("stick-sam.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1 , 1, 1, 1);
        Gdx.graphics.setTitle("teste \t"+String.valueOf(Gdx.graphics.getFramesPerSecond()));
selecao();
        batch.begin();
        batch.draw(img,0,0);
        batch.end();
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
        batch.dispose();
        img.dispose();
    }
    public void selecao(){
        if (Gdx.input.isTouched()){
            if (Gdx.input.getX()<(Gdx.graphics.getWidth())){
                MinhaTela minhaTela = new MinhaTela();
                game.setScreen(minhaTela);

            }            else {
                GameOver gameOver = new GameOver(game);
                game.setScreen(gameOver);
            }

        }

    }
}
