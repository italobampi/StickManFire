package com.mygdx.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

public class Menu implements Screen {
    SpriteBatch batch;
    Fundo fundo;
    MyGdxGame game;
    int indice;
    public Menu( MyGdxGame game){

        this.game=game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        fundo = new Fundo();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1 , 1, 1, 1);
        Gdx.graphics.setTitle("teste \t"+String.valueOf(Gdx.graphics.getFramesPerSecond()));
selecao();
        batch.begin();
        fundo.draw(batch,delta);
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

    }
    public void selecao(){
        if (Gdx.input.isTouched()){
            if (Gdx.input.getX()<(Gdx.graphics.getWidth()/2)){
                MinhaTela minhaTela = new MinhaTela();
                game.setScreen(minhaTela);

            }        else {
                System.exit(0);
            }

        }

    }
}
