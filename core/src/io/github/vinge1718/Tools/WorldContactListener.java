package io.github.vinge1718.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Sprites.Enemy;
import io.github.vinge1718.Sprites.InteractiveTileObject;
import io.github.vinge1718.Sprites.Item;
import io.github.vinge1718.Sprites.Mario;

import static io.github.vinge1718.MyProgrammingMario.ENEMY_BIT;


public class WorldContactListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        if(fixA.getUserData() == "head" || fixB.getUserData() == "head"){
            Fixture head = fixA.getUserData() == "head" ? fixA : fixB;
            Fixture object = head == fixA ? fixB : fixA;

            if(object.getUserData() instanceof InteractiveTileObject){
                ((InteractiveTileObject) object.getUserData()).onHeadHit();
            }
        }

        switch (cDef){
            case MyProgrammingMario.ENEMY_HEAD_BIT | MyProgrammingMario.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ENEMY_HEAD_BIT)
                    ((Enemy)fixA.getUserData()).hitOnHead();
                else
                    ((Enemy)fixB.getUserData()).hitOnHead();
                break;
            case MyProgrammingMario.ENEMY_BIT | MyProgrammingMario.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ENEMY_BIT)
                    ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyProgrammingMario.MARIO_BIT | MyProgrammingMario.ENEMY_BIT:
                Gdx.app.log("MARIO", "DIED");
                break;
            case MyProgrammingMario.ENEMY_BIT | MyProgrammingMario.ENEMY_BIT:
                ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyProgrammingMario.ITEM_BIT | MyProgrammingMario.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ITEM_BIT)
                    ((Item)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Item)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyProgrammingMario.ITEM_BIT | MyProgrammingMario.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ITEM_BIT)
                    ((Item)fixA.getUserData()).use((Mario) fixB.getUserData());
                else
                    ((Item)fixB.getUserData()).use((Mario) fixA.getUserData());
                break;
        }

    }

    @Override
    public void endContact(Contact contact) {
        Gdx.app.log("End Contact", "");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
