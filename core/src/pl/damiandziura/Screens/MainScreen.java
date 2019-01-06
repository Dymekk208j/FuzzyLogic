package pl.damiandziura.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import pl.damiandziura.Entities.Car;
import pl.damiandziura.FuzzyLogic;


public class MainScreen extends AbstractScreen{

    private Slider xPosSlider, yPosSlider, AngleSlider;
    private Label xPosSliderValueLabel, yPosSliderValueLabel, AngleSliderValueLabel;

    private Skin skin;
    private Image background;
    private Image place;
    private Car car;
    private float time = 0.0f;

    public MainScreen(FuzzyLogic game) {
        super(game);

        init();
    }

    private void init() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        initBackground();
        initPlace();
        initButtons();
        initCar();
        initSliders(10, 50, 300);

    }

    private void initSliders(float xPos, float yPos, float width) {

        Label xPosSliderLabel = new Label("Os X", skin);
        xPosSliderLabel.setPosition(xPos,yPos);

        xPosSlider = new Slider(0, 600, 1, false, skin);
        xPosSlider.setWidth(width);
        xPosSlider.setPosition(xPosSliderLabel.getX()+xPosSliderLabel.getWidth()+5, xPosSliderLabel.getY());

        xPosSliderValueLabel = new Label(Float.toString(xPosSlider.getValue()), skin);
        xPosSliderValueLabel.setPosition(xPosSlider.getX()+xPosSlider.getWidth()+10, xPosSlider.getY());

        stage.addActor(xPosSlider);
        stage.addActor(xPosSliderLabel);
        stage.addActor(xPosSliderValueLabel);

        xPosSlider.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                xPosSliderValueLabel.setText(Float.toString(xPosSlider.getValue()));
            }
        });

        //--------------------------------------------------------------------------------------------------------------
        yPos += 30;

        Label yPosSliderLabel = new Label("Os Y", skin);
        yPosSliderLabel.setPosition(xPos,yPos);

        yPosSlider = new Slider(0, 1200, 10, false, skin);
        yPosSlider.setWidth(width);
        yPosSlider.setPosition(yPosSliderLabel.getX()+yPosSliderLabel.getWidth()+5, yPosSliderLabel.getY());

        yPosSliderValueLabel = new Label(Float.toString(yPosSlider.getValue()), skin);
        yPosSliderValueLabel.setPosition(yPosSlider.getX()+yPosSlider.getWidth()+10, yPosSlider.getY());

        stage.addActor(yPosSlider);
        stage.addActor(yPosSliderLabel);
        stage.addActor(yPosSliderValueLabel);

        yPosSlider.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                yPosSliderValueLabel.setText(Float.toString(yPosSlider.getValue()));
            }
        });

        //--------------------------------------------------------------------------------------------------------------
        yPos += 30;

        Label AngleSliderLabel = new Label("Kat ", skin);
        AngleSliderLabel.setPosition(xPos,yPos);

        AngleSlider = new Slider(0, 360, 5, false, skin);
        AngleSlider.setWidth(width);
        AngleSlider.setPosition(AngleSliderLabel.getX()+AngleSliderLabel.getWidth()+5, AngleSliderLabel.getY());

        AngleSliderValueLabel = new Label(Float.toString(AngleSlider.getValue()), skin);
        AngleSliderValueLabel.setPosition(AngleSlider.getX()+AngleSlider.getWidth()+10, AngleSlider.getY());

        stage.addActor(AngleSlider);
        stage.addActor(AngleSliderLabel);
        stage.addActor(AngleSliderValueLabel);

        AngleSlider.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                AngleSliderValueLabel.setText(Float.toString(AngleSlider.getValue()));
            }
        });
    }

    private void initBackground() {
        background = new Image(new Texture("background.png"));
        background.setPosition(0,0);
        stage.addActor(background);
    }

    private void initPlace() {
        place = new Image(new Texture("place.png"));
        place.setSize(Car.WIDTH+5, Car.HEIGHT+5);
        place.setPosition(700,220-place.getHeight());

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

        TextButton buttonStartMove = new TextButton("Start moving", skin);
        buttonStartMove.setWidth(100);
        buttonStartMove.setHeight(30);
        buttonStartMove.setX(10);
        buttonStartMove.setY(500);
        //buttonStartMove.setDebug(true);

        buttonStartMove.addListener(new ClickListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                car.setMoving(true);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
        stage.addActor(buttonStartMove);


        TextButton buttonReset = new TextButton("Reset", skin);
        buttonReset.setWidth(100);
        buttonReset.setHeight(30);
        buttonReset.setX(10);
        buttonReset.setY(430);
        //buttonReset.setDebug(true);

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
