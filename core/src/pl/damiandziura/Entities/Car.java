package pl.damiandziura.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.lang.Math.*;
import javax.security.auth.login.LoginContext;
import java.awt.*;

import static pl.damiandziura.FuzzyLogic.DEFAULT_HEIGHT;
import static pl.damiandziura.FuzzyLogic.DEFAULT_WIDTH;

public class Car extends Image {
    public final static int WIDTH = 50;
    public final static int HEIGHT = 100;

    private int STARTING_X = 1000;//DEFAULT_WIDTH/2 - WIDTH/2;
    private int STARTING_Y = 650;
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

    public Car(int STARTING_X, int STARTING_Y, float Rotation) {
        super(new Texture("car.png"));

        this.STARTING_X = STARTING_X;
        this.STARTING_Y = STARTING_Y;

        this.setOrigin(WIDTH/2.0f, HEIGHT/2.0f);
        this.setPosition(STARTING_X, STARTING_Y);
        this.setRotation(Rotation);

        this.setSpeed(5.0f);

        Moving = false;

        logic = new Logic();
    }

    public static void setSpeed(float speed) {
        if(speed <= 0.0f) speed = 0.1f;
        Speed = speed;
    }

    public static float getSpeed() {
        return Speed;
    }

    public float getAngle() {
        float Angle = this.getRotation() * (-1);

        if(Angle >= 360) Angle -= ((int) Angle/360)*360;
        if(Angle <= -360) Angle += ((int) Angle/360)*360;
        if(Angle >= 180) Angle -= 360;
        if(Angle < -180) Angle += 360;

        return Angle;
    }

    public void Move()
    {
        float rotation =  this.getRotation();
        float position = this.getX()-100;
        float Angle = getAngle();



        float blur = logic.Blurring(Angle, (int)position);
        float rotateBy = Math.round(blur);
        double rotateByNew=Math.round(rotation+(Math.toDegrees(Math.asin((2*Math.sin(Math.toRadians(rotateBy))/10)))));

        setRotation((float)rotateByNew);
        double xx=(this.getX()+Speed*(Math.sin(Math.toRadians(rotateBy+(-Angle))-Math.sin(Math.toRadians(rotateBy))*Math.cos(Math.toRadians((-Angle))))));
        this.setX((float)xx);
        double yy=(this.getY()-Speed*(Math.cos(Math.toRadians(rotateBy+(-Angle))-Math.sin(Math.toRadians(rotateBy))*Math.cos(Math.toRadians((-Angle))))));
        this.setY((float)yy);

        if (this.getY()<=247){
            //this.setMoving(false);
        }
    }

    public boolean isMoving() {
        return Moving;
    }

    public void setMoving(boolean moving) {
        Moving = moving;
    }

    public void changePosition(float x, float y)
    {
        if(x > 1200) x = 1200;

        setPosition(x+200, y);
    }

    public void Reset(){
        this.setMoving(false);
        this.setPosition(STARTING_X, STARTING_Y);
        this.setSpeed(5.0f);
        this.setRotation(0);
    }
}
