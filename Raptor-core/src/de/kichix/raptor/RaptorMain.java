package de.kichix.raptor;

import com.badlogic.gdx.Game;

import de.kichix.helpers.AssetLoader;
import de.kichix.screens.GameScreen;

public class RaptorMain extends Game {
	
	@Override
	public void create () {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	public void dispose() {
	super.dispose();	
	AssetLoader.dispose();
	}

}
