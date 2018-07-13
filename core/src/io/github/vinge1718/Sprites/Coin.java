package io.github.vinge1718.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Scenes.Hud;
import io.github.vinge1718.Screens.PlayScreen;

public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, Rectangle bounds){
        super(screen, bounds);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MyProgrammingMario.COIN_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Coin", "Collision");
//        if(getCell().getTile().getId() == BLANK_COIN)
//            MyProgrammingMario.manager.get("audio/sounds/bump.wav", Sound.class).play();
//        else
//            MyProgrammingMario.manager.get("audio/sounds/coin.wav", Sound.class).play();
        getCell().setTile(tileSet.getTile(BLANK_COIN));
        Hud.addScore(100);
    }
}
