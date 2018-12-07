package pl.damiandziura.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.*;

import static pl.damiandziura.FuzzyLogic.DEFAULT_HEIGHT;
import static pl.damiandziura.FuzzyLogic.DEFAULT_WIDTH;

public class Car extends Image {
    private final static int WIDTH = 100;
    private final static int HEIGHT = 200;

    private int STARTING_X = DEFAULT_WIDTH/2;
    private int STARTING_Y = DEFAULT_HEIGHT - HEIGHT;

    private static float Speed;

    private boolean Moving;
    public Car() {
        super(new Texture("car.png"));

        this.setOrigin(WIDTH/2.0f, HEIGHT/2.0f);
        this.setPosition(STARTING_X, STARTING_Y);

        this.setSpeed(5.0f);

        Moving = false;
    }

    public Car(int STARTING_X, int STARTING_Y) {
        super(new Texture("car.png"));

        this.STARTING_X = STARTING_X;
        this.STARTING_Y = STARTING_Y;

        this.setOrigin(WIDTH/2.0f, HEIGHT/2.0f);
        this.setPosition(STARTING_X, STARTING_Y);

        this.setSpeed(5.0f);

        Moving = false;
    }

    public static void setSpeed(float speed) {
        Speed = speed;
    }

    public static float getSpeed() {
        return Speed;
    }

    public void MoveLeft()
    {
        this.setX(this.getX() - getSpeed());
    }

    public void MoveRight()
    {
        this.setX(this.getX() + getSpeed());
    }

    public void MoveDown()
    {
        this.setY(this.getY()-getSpeed());
    }

    public void MoveUp()
    {
        this.setY(this.getY()+getSpeed());
    }

    public void RotateRight()
    {
        this.rotateBy(1);
    }

    public void RotateLeft()
    {
        this.rotateBy(-1);
    }

    public void Move()
    {
        float rotation =  this.getRotation();

            setSpeed(9-(rotation/10));
            this.MoveDown();

            setSpeed(0+(rotation/10));
            this.MoveRight();

        System.out.println("rotation: " + this.getRotation());
        System.out.println("rotation/5.0f: " + rotation/5.0f);
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
    }
}
