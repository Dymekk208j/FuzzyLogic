package pl.damiandziura.Entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static pl.damiandziura.FuzzyLogic.DEFAULT_WIDTH;

public class Place extends Image {
    private final static int X = 700;
    private final static int Y = 250;

    public Place() {
        super(new Texture("place.png"));
        this.setPosition(X, Y);
        this.setDebug(true);
    }
}
