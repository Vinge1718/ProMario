package io.github.vinge1718.Sprites;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Screens.PlayScreen;

public class Subject extends Item {
    public Subject(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        setRegion(screen.getAtlas().findRegion("subject"), 0, 0, 32, 32);
        velocity = new Vector2(0, 0);
    }

    @Override
    public void defineItem() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX() , getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(20/ MyProgrammingMario.PPM);


        fdef.shape = shape;
        body.createFixture(fdef).setUserData(this);

    }

    @Override
    public void use(Mario mario) {
        destroy();
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        setPosition(body.getPosition().x - getWidth() /2, body.getPosition().y - getHeight()/2);
//        velocity.y = body.getLinearVelocity().y;
        body.setLinearVelocity(velocity);
    }
}
