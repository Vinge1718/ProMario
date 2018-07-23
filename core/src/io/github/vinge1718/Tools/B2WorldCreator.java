<<<<<<< HEAD
package io.github.vinge1718.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Screens.PlayScreen;
import io.github.vinge1718.Sprites.Brick;
import io.github.vinge1718.Sprites.Coin;
import io.github.vinge1718.Sprites.Enemy;
import io.github.vinge1718.Sprites.Goomba;
import io.github.vinge1718.Sprites.Turtle;

public class B2WorldCreator {
    private Array<Goomba> goombas;
    private Array<Turtle> turtles;


    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth()/2)/ MyProgrammingMario.PPM, (rect.getY()+rect.getHeight()/2)/MyProgrammingMario.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/MyProgrammingMario.PPM, rect.getHeight()/2/MyProgrammingMario.PPM);
            fdef.shape = shape;
//            fdef.filter.categoryBits = MyProgrammingMario.OBJECT_BIT;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth()/2)/MyProgrammingMario.PPM, (rect.getY()+rect.getHeight()/2)/MyProgrammingMario.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/MyProgrammingMario.PPM, rect.getHeight()/2/MyProgrammingMario.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = MyProgrammingMario.OBJECT_BIT;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){

            new Brick(screen, object);
        }

        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){

            new Coin(screen, object);
        }

        goombas = new Array<Goomba>();
        for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            goombas.add(new Goomba(screen, rect.getX() / MyProgrammingMario.PPM, rect.getY() / MyProgrammingMario.PPM));
        }
        turtles = new Array<Turtle>();
        for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            turtles.add(new Turtle(screen, rect.getX() / MyProgrammingMario.PPM, rect.getY() / MyProgrammingMario.PPM));
        }
    }

    public Array<Goomba> getGoombas() {
        return goombas;
    }
    public Array<Enemy> getEnemies(){
        Array<Enemy> enemies = new Array<Enemy>();
        enemies.addAll(goombas);
        enemies.addAll(turtles);
        return enemies;
    }
}
=======
package io.github.vinge1718.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import io.github.vinge1718.MyProgrammingMario;
import io.github.vinge1718.Screens.PlayScreen;
import io.github.vinge1718.Sprites.Brick;
import io.github.vinge1718.Sprites.Coin;
import io.github.vinge1718.Sprites.Enemy;
import io.github.vinge1718.Sprites.Goomba;
import io.github.vinge1718.Sprites.Turtle;

public class B2WorldCreator {
    private Array<Goomba> goombas;
    private Array<Turtle> turtles;


    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth()/2)/ MyProgrammingMario.PPM, (rect.getY()+rect.getHeight()/2)/MyProgrammingMario.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/MyProgrammingMario.PPM, rect.getHeight()/2/MyProgrammingMario.PPM);
            fdef.shape = shape;
//            fdef.filter.categoryBits = MyProgrammingMario.OBJECT_BIT;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth()/2)/MyProgrammingMario.PPM, (rect.getY()+rect.getHeight()/2)/MyProgrammingMario.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth()/2/MyProgrammingMario.PPM, rect.getHeight()/2/MyProgrammingMario.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = MyProgrammingMario.OBJECT_BIT;
            body.createFixture(fdef);
        }

        for (MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){

            new Brick(screen, object);
        }

        for (MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){

            new Coin(screen, object);
        }

        goombas = new Array<Goomba>();
        for (MapObject object : map.getLayers().get(6).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            goombas.add(new Goomba(screen, rect.getX() / MyProgrammingMario.PPM, rect.getY() / MyProgrammingMario.PPM));
        }
        turtles = new Array<Turtle>();
        for (MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            turtles.add(new Turtle(screen, rect.getX() / MyProgrammingMario.PPM, rect.getY() / MyProgrammingMario.PPM));
        }
    }

    public Array<Goomba> getGoombas() {
        return goombas;
    }
    public Array<Enemy> getEnemies(){
        Array<Enemy> enemies = new Array<Enemy>();
        enemies.addAll(goombas);
        enemies.addAll(turtles);
        return enemies;
    }
}
>>>>>>> 9e27586d1baa98fc5feea72bcb6d08330f2204cc
