package com.mygdx.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.bullet.BulletController;
import com.mygdx.game.player.Player;

public class InputProcessor extends InputAdapter {
 public boolean isWpres = false;
 public boolean isApres = false;
 public boolean isSpres = false;
 public boolean isDpres = false;

 private static InputProcessor instancia;
 private InputProcessor(){

 }
    public static InputProcessor getInstance(){
     if (instancia== null)
         instancia= new InputProcessor();
     return instancia;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode== Input.Keys.W) {
            isWpres = true;
            Player.ref.setIsJumping(true);
        }
        if (keycode== Input.Keys.A)
            isApres=true;
        if (keycode== Input.Keys.S)
            isSpres=true;
        if (keycode== Input.Keys.D)
            isDpres=true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W)
            isWpres = false;
        if (keycode== Input.Keys.A)
            isApres=false;
        if (keycode== Input.Keys.S)
            isSpres=false;
        if (keycode== Input.Keys.D)
            isDpres=false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        BulletController.ref.newBullet(screenX, Gdx.graphics.getHeight()-screenY);
     return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
