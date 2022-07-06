package com.mygdx.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Loading {

    private AssetManager manager;

    public AssetManager getManager(){return manager;}

    public void create(){
        manager =new AssetManager();
        manager.load("mann1.png", Texture.class);
        manager.load("chao.png", Texture.class);
        manager.load("bulletarm.png", Texture.class);
        manager.load("portadireita.png", Texture.class);
        manager.load("portaesquerda.png", Texture.class);
        manager.load("pngwing.com.png", Texture.class);
        manager.load("stick-sam.png", Texture.class);
        manager.load("7188_newgrounds_stung.mp3", Music.class);
        manager.load("Minecraft Zombie Sound Effect.mp3", Sound.class);
        manager.load("Minecraft-death-sound.mp3", Sound.class);

        manager.finishLoading();
    }
    public void dispose(){
        manager.dispose();
    }
}
