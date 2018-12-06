package pl.damiandziura;

import com.badlogic.gdx.Game;
import pl.damiandziura.Screens.MainScreen;

public class FuzzyLogic extends Game {
	public final static int DEFAULT_WIDTH = 1600;
	public final static int DEFAULT_HEIGHT = 900;

	@Override
	public void create () {
		this.setScreen(new MainScreen(this));
	}
}
