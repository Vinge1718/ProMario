package io.github.vinge1718.Sprites;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Screens.PlayScreen;

public class Mario extends Sprite {
    public World world;
    public Body b2body;
    private TextureRegion  marioStand;

    public Mario(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("little_mario"));
        this.world = world;
        defineMario();
        marioStand = new TextureRegion(getTexture(), 0, 0, 16, 16);
        setBounds(0,0,16/MyProgrammingMario.PPM, 16/MyProgrammingMario.PPM);
        setRegion(marioStand);
    }

    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32/ MyProgrammingMario.PPM, 32/ MyProgrammingMario.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/ MyProgrammingMario.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}

