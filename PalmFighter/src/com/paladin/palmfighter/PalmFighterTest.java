package com.paladin.palmfighter;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.paladin.palmfighter.test.GameScreen;
import com.paladin.palmfighter.test.WorldController;
import com.paladin.palmfighter.test.WorldRenderer;

public class PalmFighterTest extends Game{

	private WorldController worldController;
	private WorldRenderer worldRenderer;
	
	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);	
		worldController = new WorldController();
//		worldRenderer = new WorldRenderer(this.worldController);
		setScreen(new GameScreen(this));
	}

//	@Override
//	public void resize(int width, int height) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void render() {
//		worldController.update(Gdx.graphics.getDeltaTime());
//		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
//		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		worldRenderer.render();
//	}
//
//	@Override
//	public void pause() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void resume() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void dispose() {
//		// TODO Auto-generated method stub
//		
//	}

}
