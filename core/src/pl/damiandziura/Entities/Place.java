package pl.damiandziura.Entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Place extends Image {

    public Place() {
        super(new Texture("place.png"));
        this.setSize(Car.WIDTH+20, Car.HEIGHT+5);
        this.setPosition(800-this.getWidth()/2,200-this.getHeight());
    }
}
