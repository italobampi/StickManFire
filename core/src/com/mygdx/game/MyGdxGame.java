package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.tela.GameOver;
import com.mygdx.game.tela.Menu;
import com.mygdx.game.tela.MinhaTela;

public class MyGdxGame extends Game {
    private static InputMultiplexer multiplexer;
    public static Loading loading = new Loading();
    Menu minhaTela;
    private Music music;
     public static MyGdxGame ref;




    public static void addInputProcessor(InputProcessor processor) {
        if (multiplexer == null) {
            multiplexer = new InputMultiplexer();
            Gdx.input.setInputProcessor(multiplexer);
        }
        multiplexer.addProcessor(processor);
    }

    @Override
    public void create() {
        ref=this;
        loading.create();
        minhaTela = new Menu(this);
        this.setScreen(minhaTela);
        music =  loading.getManager().get("7188_newgrounds_stung.mp3", Music.class);
        music.setVolume( 0.2f);
        music.setLooping(true);
        music.play();


    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        minhaTela.dispose();
        loading.dispose();

    }
    public void setTela(int indi){

        if (indi ==0){
            Menu menu = new Menu(this);
            this.setScreen(menu);
        }else if (indi ==1){
            MinhaTela minhaTela = new MinhaTela();
            this.setScreen(minhaTela);
        }else if (indi == 2){
            GameOver gameOver = new GameOver(this);
            this.setScreen(gameOver);
        }
    }

}
