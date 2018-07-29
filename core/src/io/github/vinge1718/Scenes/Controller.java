package io.github.vinge1718.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import io.github.vinge1718.MyProgrammingMario;

public class Controller {
    Viewport viewport;
    Stage stage;
    boolean upPressed, downPressed, leftPressed, rightPressed;
    OrthographicCamera cam;

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public Controller(){
        cam = new OrthographicCamera();
        viewport = new FitViewport(MyProgrammingMario.V_WIDTH, MyProgrammingMario.V_HEIGHT, cam);
        stage = new Stage(viewport,MyProgrammingMario.batch);

        stage.addListener(new InputListener(){

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch(keycode){
                    case Input.Keys.UP:
                        upPressed = true;
                        break;
                    case Input.Keys.DOWN:
                        downPressed = true;
                        break;
                    case Input.Keys.LEFT:
                        leftPressed = true;
                        break;
                    case Input.Keys.RIGHT:
                        rightPressed = true;
                        break;
                }
                return true;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                switch(keycode){
                    case Input.Keys.UP:
                        upPressed = false;
                        break;
                    case Input.Keys.DOWN:
                        downPressed = false;
                        break;
                    case Input.Keys.LEFT:
                        leftPressed = false;
                        break;
                    case Input.Keys.RIGHT:
                        rightPressed = false;
                        break;
                }
                return true;
            }
        });

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.left().bottom();

        Image upImg = new Image(new Texture("if_up.png"));
        upImg.setSize(30, 30);
        upImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//               super.touchDown(event, x, y, pointer, button);
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                super.touchUp(event, x, y, pointer, button);
                upPressed = false;
            }
        });

//        Image downImg = new Image(new Texture("if_down.png"));
//        downImg.setSize(30,30);
//        downImg.addListener(new InputListener(){
//
//
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                super.touchDown(event, x, y, pointer, button);
//                downPressed = true;
//                return true;
//            }
//
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
////                super.touchUp(event, x, y, pointer, button);
//                downPressed = false;
//            }
//        });

        Image rightImg = new Image(new Texture("if_right.png"));
        rightImg.setSize(30, 30);
        rightImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                return super.touchDown(event, x, y, pointer, button);
                rightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                super.touchUp(event, x, y, pointer, button);
                rightPressed = false;
            }
        });

        Image leftImg = new Image( new Texture("if_left.png"));
        leftImg.setSize(30, 30);
        leftImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                return super.touchDown(event, x, y, pointer, button);
                leftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                super.touchUp(event, x, y, pointer, button);
                leftPressed = false;
            }
        });

        table.add();
        table.add(upImg).size(upImg.getWidth(), upImg.getHeight()).pad(0,0,-10,0);
        table.add();
        table.row().pad(5, 5,5,5);
        table.add(leftImg).size(leftImg.getWidth(), leftImg.getHeight()).pad(0,0,50,320);
        table.add();
        table.add(rightImg).size(rightImg.getWidth(), rightImg.getHeight()).pad(0,-620,50,0);
        table.row().padBottom(5);
        table.add();
//        table.add(downImg).size(downImg.getWidth(), downImg.getHeight());
        table.add();

        stage.addActor(table);
    }

    public void draw(){
        stage.draw();
    }

    public void resize(int width, int height){
        viewport.update(width, height);
    }

}
