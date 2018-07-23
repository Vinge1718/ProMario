<<<<<<< HEAD
package io.github.vinge1718.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Sprites.Enemy;
import io.github.vinge1718.Sprites.FireBall;
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

        switch (cDef){
            case MyProgrammingMario.MARIO_HEAD_BIT | MyProgrammingMario.BRICK_BIT:
            case MyProgrammingMario.MARIO_HEAD_BIT | MyProgrammingMario.COIN_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.MARIO_HEAD_BIT)
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit((Mario) fixA.getUserData());
                else
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit((Mario) fixB.getUserData());
                break;
            case MyProgrammingMario.ENEMY_HEAD_BIT | MyProgrammingMario.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ENEMY_HEAD_BIT)
                    ((Enemy)fixA.getUserData()).hitOnHead((Mario) fixB.getUserData());
                else
                    ((Enemy)fixB.getUserData()).hitOnHead((Mario) fixA.getUserData());
                break;
            case MyProgrammingMario.ENEMY_BIT | MyProgrammingMario.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ENEMY_BIT)
                    ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyProgrammingMario.MARIO_BIT | MyProgrammingMario.ENEMY_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.MARIO_BIT)
                    ((Mario) fixA.getUserData()).hit((Enemy)fixB.getUserData());
                else
                    ((Mario) fixB.getUserData()).hit((Enemy)fixA.getUserData());
                break;
            case MyProgrammingMario.ENEMY_BIT | MyProgrammingMario.ENEMY_BIT:
                ((Enemy)fixA.getUserData()).onEnemyHit((Enemy) fixB.getUserData());
                ((Enemy)fixB.getUserData()).onEnemyHit((Enemy) fixB.getUserData());
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
//            case MyProgrammingMario.FIREBALL_BIT | MyProgrammingMario.OBJECT_BIT:
//                if(fixA.getFilterData().categoryBits == MyProgrammingMario.FIREBALL_BIT)
//                    ((FireBall)fixA.getUserData()).setToDestroy();
//                else
//                    ((FireBall)fixB.getUserData()).setToDestroy();
//                break;
        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
=======
package io.github.vinge1718.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Sprites.Enemy;
import io.github.vinge1718.Sprites.FireBall;
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

        switch (cDef){
            case MyProgrammingMario.MARIO_HEAD_BIT | MyProgrammingMario.BRICK_BIT:
            case MyProgrammingMario.MARIO_HEAD_BIT | MyProgrammingMario.COIN_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.MARIO_HEAD_BIT)
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit((Mario) fixA.getUserData());
                else
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit((Mario) fixB.getUserData());
                break;
            case MyProgrammingMario.ENEMY_HEAD_BIT | MyProgrammingMario.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ENEMY_HEAD_BIT)
                    ((Enemy)fixA.getUserData()).hitOnHead((Mario) fixB.getUserData());
                else
                    ((Enemy)fixB.getUserData()).hitOnHead((Mario) fixA.getUserData());
                break;
            case MyProgrammingMario.ENEMY_BIT | MyProgrammingMario.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ENEMY_BIT)
                    ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MyProgrammingMario.MARIO_BIT | MyProgrammingMario.ENEMY_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.MARIO_BIT)
                    ((Mario) fixA.getUserData()).hit((Enemy)fixB.getUserData());
                else
                    ((Mario) fixB.getUserData()).hit((Enemy)fixA.getUserData());
                break;
            case MyProgrammingMario.ENEMY_BIT | MyProgrammingMario.ENEMY_BIT:
                ((Enemy)fixA.getUserData()).onEnemyHit((Enemy) fixB.getUserData());
                ((Enemy)fixB.getUserData()).onEnemyHit((Enemy) fixB.getUserData());
                break;
            case MyProgrammingMario.ITEM_BIT | MyProgrammingMario.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MyProgrammingMario.ITEM_BIT)
                    ((Item)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Item)fixB.getUserData()).reverseVelocity(true, false);
                break;

        }

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
>>>>>>> 9e27586d1baa98fc5feea72bcb6d08330f2204cc
