package pl.damiandziura.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import javax.security.auth.login.LoginContext;
import java.awt.*;

import static pl.damiandziura.FuzzyLogic.DEFAULT_HEIGHT;
import static pl.damiandziura.FuzzyLogic.DEFAULT_WIDTH;

public class Car extends Image {
    private final static int WIDTH = 50;
    private final static int HEIGHT = 100;

    private int STARTING_X = 400;//DEFAULT_WIDTH/2 - WIDTH/2;
    private int STARTING_Y = DEFAULT_HEIGHT - HEIGHT;

    private static float Speed;
    private static Logic logic;

    private boolean Moving;
    public Car() {
        super(new Texture("car.png"));

        this.setOrigin(WIDTH/2.0f, 0);

        this.setPosition(STARTING_X, STARTING_Y);

        this.setSpeed(5.0f);

        Moving = false;
this.setDebug(true);
        logic = new Logic();
    }

    public Car(int STARTING_X, int STARTING_Y) {
        super(new Texture("car.png"));

        this.STARTING_X = STARTING_X;
        this.STARTING_Y = STARTING_Y;

        this.setOrigin(WIDTH/2.0f, HEIGHT/2.0f);
        this.setPosition(STARTING_X, STARTING_Y);

        this.setSpeed(5.0f);

        Moving = false;

        logic = new Logic();
    }

    public static void setSpeed(float speed) {
        Speed = speed;
    }

    public static float getSpeed() {
        return Speed;
    }

    public void Move()
    {
        float rotation =  this.getRotation();

        float rotationY = 9-(rotation/10);
        setSpeed(rotationY);
        this.setY(this.getY()-getSpeed());

        float rotationX = 0+(rotation/10);
        setSpeed(rotationX);
        this.setX(this.getX() + getSpeed());

        float position = this.getX()-100;
        float blur = logic.Blurring(rotation, position);
        float rotateBy = Math.round(blur)/2;
        this.rotateBy(rotateBy);

        System.out.println("---------------------------");
        System.out.println("rotation: " + rotation);
        System.out.println("distance: " + position);
        System.out.println("rotation Y: " + rotationY);
        System.out.println("rotation X: " + rotationX);
        System.out.println("blur: " + blur);
        System.out.println("rotateBy: " + rotateBy);
        System.out.println("X: " + this.getX() + " Y:" + this.getY());
        System.out.println("Origin: " + this.getOriginX() + ", " + this.getOriginY());
        System.out.println("---------------------------");

    }

    public boolean isMoving() {
        return Moving;
    }

    public void setMoving(boolean moving) {
        Moving = moving;
    }

    public void Reset(){
        this.setMoving(false);
        this.setPosition(STARTING_X, STARTING_Y);
        this.setSpeed(5.0f);
        this.setRotation(0f);
    }
}
