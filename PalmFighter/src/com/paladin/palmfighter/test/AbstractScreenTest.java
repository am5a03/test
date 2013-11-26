package com.paladin.palmfighter.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreenTest implements Screen {

	protected Game game;
	
	public AbstractScreenTest(Game game) {
		this.game = game;
	}
	
	public abstract void render (float deltaTime);
	public abstract void resize (int width, int height);
	public abstract void show ();
	public abstract void hide ();
	public abstract void pause ();

}
