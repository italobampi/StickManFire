package com.mygdx.game.tela;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.bullet.Arma;
import com.mygdx.game.bullet.BulletController;
import com.mygdx.game.hubtop.Hub1Supe;
import com.mygdx.game.hubtop.PortaD;
import com.mygdx.game.hubtop.PortaE;
import com.mygdx.game.hubtop.VidaController;
import com.mygdx.game.inimigos.InimigoController;
import com.mygdx.game.player.Player;


public class MinhaTela extends Sprite implements Screen {
    SpriteBatch batch;
    private OrthographicCamera camera;
    public static Player player;
    BulletController bulletController;
    InimigoController inimigoController;
    Arma arma;
    Hub1Supe hub1Supe;
    Texture texture;
    PortaE portaE;//
    PortaD portaD;
    @Override
    public void show() {
        texture = new Texture("chao.png");
        portaE = new PortaE();
        portaD = new PortaD();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        batch = new SpriteBatch();

       player = new Player();
       hub1Supe = new Hub1Supe();


       bulletController = new BulletController();
       inimigoController = new InimigoController();
       inimigoController.newInimigo();

       arma = new Arma();


    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0 , 0, 0, 0);
        Gdx.graphics.setTitle("StickManFire \t"+String.valueOf(Gdx.graphics.getFramesPerSecond()));
        batch.begin();
        portaE.draw(batch,delta);
        portaD.draw(batch,delta);
        batch.draw(texture,0,-2);

        player.draw(batch,delta);
        bulletController.render(batch,delta);
        inimigoController.draw(batch,delta);
        arma.draw(batch,delta);
        hub1Supe.draw(batch,delta);


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
        texture.dispose();
        batch.dispose();
    }
}
