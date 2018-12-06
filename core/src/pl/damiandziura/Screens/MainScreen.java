package pl.damiandziura.Screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.damiandziura.Entities.Car;
import pl.damiandziura.FuzzyLogic;


public class MainScreen extends AbstractScreen{

    private Car car;
    private TextButton ButtonUp;
    private TextButton ButtonDown;
    private TextButton ButtonLeft;
    private TextButton ButtonRight;
    private TextButton ButtonRotateRight;
    private TextButton ButtonRotateLeft;


    public MainScreen(FuzzyLogic game) {
        super(game);

        init();
    }

    private void initCar() {
        car = new Car();
        car.rotateBy(2);
        car.setDebug(true);

        stage.addActor(car);

    }

    private void init() {
        initCar();
        initButtons();
    }

    private void initButtons() {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new BitmapFont();

        ButtonUp = new TextButton("Button up", textButtonStyle);
        ButtonUp.setWidth(100);
        ButtonUp.setHeight(30);
        ButtonUp.setX(10);
        ButtonUp.setY(500);
        ButtonUp.setDebug(true);

        ButtonUp.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.MoveUp();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(ButtonUp);


        ButtonDown = new TextButton("ButtonDown", textButtonStyle);
        ButtonDown.setWidth(100);
        ButtonDown.setHeight(30);
        ButtonDown.setX(10);
        ButtonDown.setY(465);
        ButtonDown.setDebug(true);

        ButtonDown.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.MoveDown();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(ButtonDown);


        ButtonLeft = new TextButton("ButtonLeft", textButtonStyle);
        ButtonLeft.setWidth(100);
        ButtonLeft.setHeight(30);
        ButtonLeft.setX(10);
        ButtonLeft.setY(430);
        ButtonLeft.setDebug(true);

        ButtonLeft.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.MoveLeft();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(ButtonLeft);

        ButtonRight = new TextButton("ButtonRight", textButtonStyle);
        ButtonRight.setWidth(100);
        ButtonRight.setHeight(30);
        ButtonRight.setX(10);
        ButtonRight.setY(395);
        ButtonRight.setDebug(true);

        ButtonRight.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.MoveRight();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(ButtonRight);


        ButtonRotateRight = new TextButton("RotateRight", textButtonStyle);
        ButtonRotateRight.setWidth(100);
        ButtonRotateRight.setHeight(30);
        ButtonRotateRight.setX(10);
        ButtonRotateRight.setY(360);
        ButtonRotateRight.setDebug(true);

        ButtonRotateRight.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.RotateRight();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(ButtonRotateRight);

        ButtonRotateLeft = new TextButton("RotateLeft", textButtonStyle);
        ButtonRotateLeft.setWidth(100);
        ButtonRotateLeft.setHeight(30);
        ButtonRotateLeft.setX(10);
        ButtonRotateLeft.setY(325);
        ButtonRotateLeft.setDebug(true);

        ButtonRotateLeft.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.RotateLeft();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(ButtonRotateLeft);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        batch.begin();
            stage.draw();
        batch.end();
    }

    private void update() {
        stage.act();
    }
}
