package pl.damiandziura.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.damiandziura.Entities.Car;
import pl.damiandziura.Entities.Place;
import pl.damiandziura.FuzzyLogic;


public class MainScreen extends AbstractScreen{

    Image background;
    private Car car;

    private float time = 0.0f;

    public MainScreen(FuzzyLogic game) {
        super(game);

        init();
    }

    private void initCar() {
        car = new Car();
        car.setDebug(true);

        stage.addActor(car);

    }

    private void init() {
        background = new Image(new Texture("background.png"));
        background.setPosition(0,0);
        stage.addActor(background);

        initButtons();

        initCar();

    }



    private void initButtons() {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new BitmapFont();

        TextButton buttonStartMove = new TextButton("Start moving", textButtonStyle);
        buttonStartMove.setWidth(100);
        buttonStartMove.setHeight(30);
        buttonStartMove.setX(10);
        buttonStartMove.setY(500);
        buttonStartMove.setDebug(true);

        buttonStartMove.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.setMoving(true);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonStartMove);


        TextButton buttonStopMove = new TextButton("Stop moving", textButtonStyle);
        buttonStopMove.setWidth(100);
        buttonStopMove.setHeight(30);
        buttonStopMove.setX(10);
        buttonStopMove.setY(465);
        buttonStopMove.setDebug(true);

        buttonStopMove.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                //Logic fuzzyLogic = new Logic();
                //float d = fuzzyLogic.Blurring(20f, 1000f);
                //System.out.println("Rozmycie: " + d);
                car.setMoving(false);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonStopMove);


        TextButton buttonReset = new TextButton("Reset", textButtonStyle);
        buttonReset.setWidth(100);
        buttonReset.setHeight(30);
        buttonReset.setX(10);
        buttonReset.setY(430);
        buttonReset.setDebug(true);

        buttonReset.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.Reset();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonReset);

        TextButton buttonRight = new TextButton("ButtonRight", textButtonStyle);
        buttonRight.setWidth(100);
        buttonRight.setHeight(30);
        buttonRight.setX(10);
        buttonRight.setY(395);
        buttonRight.setDebug(true);

        buttonRight.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
               // car.MoveRight();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonRight);


        TextButton buttonRotateRight = new TextButton("RotateRight", textButtonStyle);
        buttonRotateRight.setWidth(100);
        buttonRotateRight.setHeight(30);
        buttonRotateRight.setX(10);
        buttonRotateRight.setY(360);
        buttonRotateRight.setDebug(true);

        buttonRotateRight.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
               // car.RotateRight();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonRotateRight);

        TextButton buttonRotateLeft = new TextButton("RotateLeft", textButtonStyle);
        buttonRotateLeft.setWidth(100);
        buttonRotateLeft.setHeight(30);
        buttonRotateLeft.setX(10);
        buttonRotateLeft.setY(325);
        buttonRotateLeft.setDebug(true);

        buttonRotateLeft.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
               // car.RotateLeft();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonRotateLeft);


        TextButton buttonMove = new TextButton("Move", textButtonStyle);
        buttonMove.setWidth(100);
        buttonMove.setHeight(30);
        buttonMove.setX(10);
        buttonMove.setY(535);
        buttonMove.setDebug(true);

        buttonMove.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.Move();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonMove);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        batch.begin();
            stage.draw();
        batch.end();

        if (car.isMoving()) {
            time += delta;
            if(time >= 0.5){
                System.out.println("time: " + time);
                time = 0.0f;
                car.Move();
            }
        }

    }

    private void update() {
        stage.act();
    }
}
