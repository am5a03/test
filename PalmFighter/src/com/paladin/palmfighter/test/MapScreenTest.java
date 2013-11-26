package com.paladin.palmfighter.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.paladin.palmfighter.PalmFighter;
import com.paladin.palmfighter.screens.AbstractScreen;

public class MapScreenTest extends AbstractScreen implements InputProcessor{

	TextureAtlas atlas;
	TextureAtlas templateGuyAtlas;
	Texture ryu;
	
	protected final int MAX_MAP_WIDTH = 1600;
	protected final int MAX_MAP_HEIGHT = 480;
	protected final float VIRTUAL_ASPECT_RATIO = MAX_MAP_WIDTH/MAX_MAP_HEIGHT;
	Rectangle viewport;
	
	Animation templateGuyAnimation;
	Texture templateTexture;
	TextureRegion[] walkFrames;
	TextureRegion currentFrame;
	float stateTime;
	
	TextureRegion r1;
	TextureRegion r2;
	TextureRegion r3;
	TextureRegion r4;
	TextureRegion r5;
	TextureRegion r6;
	TextureRegion r7;
	TextureRegion r8;
	
	private OrthographicCamera myTestingCamera;
	

	public MapScreenTest(PalmFighter game) {
		super(game);
		this.stage = null;
//		this.stage.setViewport(MAX_MAP_WIDTH, MAX_MAP_HEIGHT);
//		myTestingCamera = new OrthographicCamera(5, 5);
//		this.stage.setCamera(myTestingCamera);
//		this.stage.getCamera().position.set(0, 0, 0);
//		this.myTestingCamera.update();
		Gdx.input.setInputProcessor(stage);
	}


	

	@Override
	public void hide() {

	}

	@Override
	public void render(float delta) {

//		Gdx.graphics.getGL10().glEnable(GL10.GL_BLEND); // Or GL20
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		
		//start draw
//		Gdx.gl.glDisable(GL10.GL_BLEND);
		
		stateTime += Gdx.graphics.getDeltaTime(); 
		
		getSpriteBatch().setProjectionMatrix(camera.combined);
//		this.getSpriteBatch().enableBlending();
		this.getSpriteBatch().begin();
//		this.getSpriteBatch().setColor(1, 1, 1, 1);
//		Gdx.gl.glEnable(GL10.GL_BLEND);
//		Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA,GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		
		getSpriteBatch().draw(r1, 0, 40);
		getSpriteBatch().draw(r2, r1.getRegionWidth(), 40);
		
		getSpriteBatch().draw(r3, 0, r1.getRegionHeight() + 40);
		getSpriteBatch().draw(r4, r3.getRegionWidth(), r1.getRegionHeight() + 40);
		
		getSpriteBatch().draw(r7, 0, r1.getRegionHeight() + r3.getRegionHeight() + r5.getRegionHeight() - 36);
		getSpriteBatch().draw(r8, r7.getRegionWidth(), r1.getRegionHeight() + r3.getRegionHeight() + r5.getRegionHeight() - 36);
		
		getSpriteBatch().draw(r5, 0, r1.getRegionHeight() + r3.getRegionHeight() + 40);
		getSpriteBatch().draw(r6, r5.getRegionWidth(), r1.getRegionHeight() + r3.getRegionHeight() +40);
		
//		getSpriteBatch()
		
		currentFrame = templateGuyAnimation.getKeyFrame(stateTime, true);
//		Color c = getSpriteBatch().getColor();
//		getSpriteBatch().setColor(c.r, c.g, c.b, 0.3f);
		getSpriteBatch().draw(currentFrame, 40, 40);
		
//		getSpriteBatch().setBlendFunction(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//		getSpriteBatch().draw(ryu, 0, 0);
		
		this.getSpriteBatch().end();
		
		float camMoveSpeed = 100* delta;
		float camMoveSpeedAccelerationFactor = 5;
		
		
		
		if (Gdx.input.isKeyPressed(Keys.LEFT)){
			camMoveSpeed = -camMoveSpeed + camera.position.x;
			camera.position.x = camMoveSpeed;
			
			
			
		}else if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			camMoveSpeed = camMoveSpeed + camera.position.x;
			camera.position.x = camMoveSpeed;
		}
		
		camera.update();		
	}

	@Override
	public void resize(int width, int height) {
		float aspectRatio = (float) width / (float) height;
		
//		camera.position.set(MAX_MAP_WIDTH * 0.5f, MAX_MAP_HEIGHT * 0.5f, 0);
//		 Vector2 size = Scaling.fit.apply(800, 480, width, height);
//	        int viewportX = (int)(width - size.x) / 2;
//	        int viewportY = (int)(height - size.y) / 2;
//	        int viewportWidth = (int)size.x;
//	        int viewportHeight = (int)size.y;
//	        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
//	        stage.setViewport(800, 480, true, viewportX, viewportY, viewportWidth, viewportHeight);

//		camera = new OrthographicCamera(1600,480);
//		camera.position.set(0, 0, 0);
//		camera.update();
	}

	@Override
	public void show() {
		
		Gdx.gl10.glEnable(GL11.GL_BLEND);
//		Gdx.gl10.glDisable(GL10.GL_BLEND);
		Gdx.gl11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);
		atlas =  new TextureAtlas(
				Gdx.files.internal("maps/template/1/template1.atlas"));
		templateGuyAtlas =  new TextureAtlas(Gdx.files.internal("characters/template/template.atlas"));
		
		ryu = new Texture(Gdx.files.internal("characters/template/ryu.png"));
		
		r1 = atlas.findRegion("pic7");
		r2 = atlas.findRegion("pic8");
		
		r3 = atlas.findRegion("pic5");
		r4 = atlas.findRegion("pic6");
		
		r5 = atlas.findRegion("pic3");
		r6 = atlas.findRegion("pic4");
		
		r7 = atlas.findRegion("pic1");
		r8 = atlas.findRegion("pic2");
		
		templateTexture = templateGuyAtlas.findRegion("0").getTexture();
		int col = 10, row = 7;
		int width = templateTexture.getWidth();
		int height = templateTexture.getHeight();
		TextureRegion[][] tmp = TextureRegion.split(templateTexture, 80, 80);
		
		walkFrames = new TextureRegion[4];
		
		walkFrames[0] = tmp[0][4];
		walkFrames[1] = tmp[0][5];
		walkFrames[2] = tmp[0][6];
		walkFrames[3] = tmp[0][7];
//		walkFrames[4] = tmp[0][7];
		
		templateGuyAnimation = new Animation(0.125f, walkFrames);
		stateTime = 0;
		
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		
	}
	
	@Override
	public void dispose(){
	}




	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
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
