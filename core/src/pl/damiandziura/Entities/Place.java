package pl.damiandziura.Entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static pl.damiandziura.FuzzyLogic.DEFAULT_WIDTH;

public class Place extends Image {
    private final static int WIDTH = 104;
    private final static int HEIGHT = 155;

    private final static int STARTING_X = 700 - WIDTH/2;
    private final static int STARTING_Y = 200-HEIGHT;

    public Place() {
        super(new Texture("place.png"));
        this.setOrigin(WIDTH/2, 0);
        this.setPosition(STARTING_X, STARTING_Y);
        this.setDebug(true);
    }
}
