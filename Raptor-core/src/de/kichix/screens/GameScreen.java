package de.kichix.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import de.kichix.gameworld.GameRenderer;
import de.kichix.gameworld.GameWorld;
import de.kichix.helpers.InputHandler;

public class GameScreen implements Screen {

	private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    // This is the constructor, not the class declaration
    public GameScreen() {

        world = new GameWorld();
        renderer = new GameRenderer(world);
        
        Gdx.input.setInputProcessor(new InputHandler(world.getJet()));
    }

    @Override
    public void render(float delta) {
        runTime += delta;
    	world.update(delta);
        renderer.render(runTime, delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}
