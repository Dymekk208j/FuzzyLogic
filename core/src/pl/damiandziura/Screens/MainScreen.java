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

    private Image background;
    private Image place;
    private Car car;

    private float time = 0.0f;

    public MainScreen(FuzzyLogic game) {
        super(game);

        init();
    }

    private void init() {
        initBackground();
        initPlace();
        initButtons();
        initCar();
    }

    private void initBackground() {
        background = new Image(new Texture("background.png"));
        background.setPosition(0,0);
        stage.addActor(background);
    }

    private void initPlace() {
        place = new Image(new Texture("place.png"));
        place.setSize(Car.WIDTH+5, Car.HEIGHT+5);
        place.setPosition(700,245);

        stage.addActor(place);
    }

    private void initCar() {
        car = new Car();
        car.setDebug(true);
        stage.addActor(car);
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
            if(time >= 0.15){
                time = 0.0f;
                car.Move();
            }
        }

    }

    private void update() {
        stage.act();
    }
}
