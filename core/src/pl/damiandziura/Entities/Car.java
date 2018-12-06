package pl.damiandziura.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Car extends Image {
    private final static int WIDTH = 100;
    private final static int HEIGHT = 200;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 200;

    private static int Speed;

    public Car() {
        super(new Texture("car.png"));

        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setPosition(STARTING_X, STARTING_Y);

        this.setSpeed(5);
    }

    public static void setSpeed(int speed) {
        Speed = speed;
    }

    public static int getSpeed() {
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

}
