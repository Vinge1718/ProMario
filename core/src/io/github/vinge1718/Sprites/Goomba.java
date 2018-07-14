package io.github.vinge1718.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Screens.PlayScreen;

public class Goomba extends Enemy {
    private float stateTime;
    private Animation<TextureRegion> walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;

    public Goomba(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        for(int i = 0; i < 2; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("goomba"), i*16, -8, 16,
                    16));
        walkAnimation = new Animation<TextureRegion>(0.4f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 16/MyProgrammingMario.PPM, 16/MyProgrammingMario.PPM);
        setToDestroy = false;
        destroyed = false;
    }

    public void update(float dt){
        stateTime += dt;
        if(setToDestroy && !destroyed){
            world.destroyBody(b2body);
            destroyed = true;
            setRegion(new TextureRegion(screen.getAtlas().findRegion("goomba"), 32, -8, 16,16));
            stateTime = 0;
        } else if(!destroyed){
            b2body.setLinearVelocity(velocity);
            setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2);
            setRegion(walkAnimation.getKeyFrame(stateTime, true));
        }

    }

    @Override
    protected void definedEnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX() , getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6/ MyProgrammingMario.PPM);
        fdef.filter.categoryBits = MyProgrammingMario.ENEMY_BIT;
        fdef.filter.maskBits = MyProgrammingMario.GROUND_BIT |
                MyProgrammingMario.COIN_BIT |
                MyProgrammingMario.BRICK_BIT |
                MyProgrammingMario.ENEMY_BIT |
                MyProgrammingMario.OBJECT_BIT |
                MyProgrammingMario.MARIO_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);

        PolygonShape head = new PolygonShape();
        Vector2[] vertice = new Vector2[4];
        vertice[0] = new Vector2(-5, 8).scl(1/MyProgrammingMario.PPM);
        vertice[1] = new Vector2(5, 8).scl(1/MyProgrammingMario.PPM);
        vertice[2] = new Vector2(-3, 3).scl(1/MyProgrammingMario.PPM);
        vertice[3] = new Vector2(3, 3).scl(1/MyProgrammingMario.PPM);
        head.set(vertice);

        fdef.shape = head;
        fdef.restitution = 0.5f;
        fdef.filter.categoryBits = MyProgrammingMario.ENEMY_HEAD_BIT;
        b2body.createFixture(fdef).setUserData(this);

    }

    public void draw(Batch batch){
        if(!destroyed || stateTime < 1)
            super.draw(batch);
    }

    @Override
    public void hitOnHead() {
        setToDestroy = true;
    }
}
