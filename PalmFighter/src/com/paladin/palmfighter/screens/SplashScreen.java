package com.paladin.palmfighter.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.paladin.palmfighter.PalmFighter;
import com.paladin.palmfighter.screens.factory.ScreenFactory;
import com.paladin.palmfighter.screens.factory.ScreenType;
import com.paladin.palmfighter.utils.PFConstants;


public class SplashScreen extends AbstractScreen {

	private Texture splashTexture;
	private TextureRegion splashTextureRegion;
	
	public SplashScreen(PalmFighter game) {
		super(game);
	}
	
	@Override
	public void show(){	
		this.splashTexture = new Texture(PFConstants.ScreenImg.SPLASH);
		this.splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		stage.clear();
		TextureRegion splashRegion = new TextureRegion(splashTexture, 0, 0, 512, 256);
		
		// here we create the splash image actor and set its size
		Image splashImage = new Image(splashRegion);
		splashImage.setWidth(stage.getWidth());
		splashImage.setHeight(stage.getHeight());
		
		splashImage.getColor().a = 0f;
		splashImage.addAction(Actions.sequence(Actions.fadeIn(0.75f), Actions.delay(1.75f), Actions.fadeOut(0.75f),
	            new Action() {
	                @Override
	                public boolean act(float delta){
	                    // the last action will move to the next screen
	                	ScreenFactory sf = new ScreenFactory();
	                    game.setScreen(sf.produceScreen(ScreenType.MENU, game));
	                    return true;
	                }
	            }));

		
		stage.addActor(splashImage);
		
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void resize(int width, int height){
//		super.resize(width, height);
//		
//		stage.clear();
//		TextureRegion splashRegion = new TextureRegion(splashTexture, 0, 0, 512, 256);
//		
//		// here we create the splash image actor and set its size
//		Image splashImage = new Image(splashRegion);
//		splashImage.setWidth(width);
//		splashImage.setHeight(height);
//		
//		splashImage.getColor().a = 0f;
//		splashImage.addAction(Actions.sequence(Actions.fadeIn(0.75f), Actions.delay(1.75f), Actions.fadeOut(0.75f),
//	            new Action() {
//	                @Override
//	                public boolean act(float delta){
//	                    // the last action will move to the next screen
//	                	ScreenFactory sf = new ScreenFactory();
//	                    game.setScreen(sf.produceScreen(ScreenType.MENU, game));
//	                    return true;
//	                }
//	            }));
//
//		
//		stage.addActor(splashImage);
//
//	}
//	
//	@Override
//	public void render(float delta){
//		super.render(delta);
//		
////		batch.begin();
////		
////		batch.draw(splashTextureRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
////		
////		batch.end();
//	}
}