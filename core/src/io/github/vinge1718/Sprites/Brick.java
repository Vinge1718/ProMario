package io.github.vinge1718.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Scenes.Hud;
import io.github.vinge1718.Screens.PlayScreen;

public class Brick extends InteractiveTileObject{
    public Brick(PlayScreen screen, MapObject object){
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MyProgrammingMario.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if(mario.isBig()) {
            setCategoryFilter(MyProgrammingMario.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MyProgrammingMario.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MyProgrammingMario.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}
