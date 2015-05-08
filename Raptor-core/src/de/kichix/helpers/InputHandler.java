package de.kichix.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import de.kichix.gameobjects.Jet;

public class InputHandler implements InputProcessor {

	private Jet myJet;
	
	public InputHandler(Jet jet) {
		myJet = jet;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			myJet.move(-80);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			myJet.move(80);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		if(keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT) {
			myJet.stop();
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			myJet.shoot();
		}
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		myJet.shoot();
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
