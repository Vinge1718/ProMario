package io.github.vinge1718.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import io.github.vinge1718.Screens.PlayScreen;

public abstract class Enemy extends Sprite {
    protected PlayScreen screen;
    protected World world;
    protected Body b2body;
    public Vector2 velocity;

    public Enemy(PlayScreen screen, float x, float y){
        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x,y);
        definedEnemy();
        velocity =new Vector2(1,0);
    }

    protected abstract void definedEnemy();
    public abstract void update(float dt);
    public abstract void hitOnHead();

    public void reverseVelocity(boolean x, boolean y){
        if(x)
            velocity.x = -velocity.x;
        if(y)
            velocity.y = velocity.y;
    }
}
