package io.github.vinge1718;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.github.vinge1718.Screens.PlayScreen;

public class MyProgrammingMario extends Game {
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;

    public static final short GROUND_BIT = 1;
	public static final short MARIO_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short COIN_BIT =8;
	public static final short DESTROYED_BIT = 16;
	public static final short OBJECT_BIT =32;
	public static final short ENEMY_BIT = 64;
    public static final short ENEMY_HEAD_BIT = 128;

	public static AssetManager manager;

	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
		manager = new AssetManager();
//		manager.load("audio/music/mario_music.ogg", Music.class);
//		manager.load("audio/sounds/coin.wav", Sound.class);
//		manager.load("audio/sounds/bump.wav", Sound.class);
//		manager.load("audio/sounds/breakblock.wav", Sound.class);
//		setScreen(new PlayScreen(this));
//		manager.finishLoading();
	}

	@Override
	public void render () {
		super.render();
//manager.update(); to use this remove the `finishLoading()` function in create above then
// move on to the `PlayScreenClass and uncomment the music call in the constructor and finally do
// the same in both the brick class and coin class where music and sound effetcs are finally
// called into action upon collision with mario in gameplay...
	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		manager.dispose();
	}
}
