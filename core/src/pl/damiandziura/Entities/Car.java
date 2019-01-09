package pl.damiandziura.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Car extends Image {
    public final static int WIDTH = 50;
    public final static int HEIGHT = 100;

    private int STARTING_X = 1000;
    private int STARTING_Y = 650;
    private static float Speed;
    private static Logic logic;
    private float EndPoint;
    private boolean Moving;

    public Car() {
        super(new Texture("car.png"));

        this.setOrigin(WIDTH/2.0f, HEIGHT/2.0f);
        this.setSize(WIDTH, HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
        this.setSpeed(5.0f);
        this.EndPoint = 200;
        this.Moving = false;
        this.logic = new Logic();
    }

    public static void setSpeed(float speed) {
        if(speed <= 0.0f) speed = 0.1f;
        Speed = speed;
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
        float position = this.getX()-(200-(Car.WIDTH/2));
        float Angle = getAngle();

        float blur = logic.Blurring(Angle, (int)position);
        float rotateBy = Math.round(blur);
        double rotateByNew=Math.round(rotation+(Math.toDegrees(Math.asin((2*Math.sin(Math.toRadians(rotateBy))/50)*Speed))));

        setRotation((float)rotateByNew);
        double xx=(this.getX()+Speed*(Math.sin(Math.toRadians(rotateBy+(-Angle))-Math.sin(Math.toRadians(rotateBy))*Math.cos(Math.toRadians((-Angle))))));
        this.setX((float)xx);
        double yy=(this.getY()-Speed*(Math.cos(Math.toRadians(rotateBy+(-Angle))-Math.sin(Math.toRadians(rotateBy))*Math.cos(Math.toRadians((-Angle))))));
        this.setY((float)yy);

        if (this.getY() <= getEndPoint()){
            this.setMoving(false);
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
        if(!isMoving())setPosition(x+300, y+300);
    }

    public void Reset(){
        this.setMoving(false);
        this.setPosition(STARTING_X, STARTING_Y);
        this.setSpeed(5.0f);
        this.setRotation(0);
    }

    public float getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(float endPoint) {
        EndPoint = endPoint+5;
    }
}
