package io.github.vinge1718.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import io.github.vinge1718.Screens.PlayScreen;

public abstract class Enemy extends Sprite {
    protected PlayScreen screen;
    protected World world;
    protected Body b2body;

    public Enemy(PlayScreen screen, float x, float y){
        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x,y);
        definedEnemy();
    }

    protected abstract void definedEnemy();
}
