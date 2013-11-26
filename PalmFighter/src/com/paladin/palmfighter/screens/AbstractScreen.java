package com.paladin.palmfighter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.paladin.palmfighter.PalmFighter;
import com.paladin.palmfighter.assets.Assets;
import com.paladin.palmfighter.utils.PFConstants;

public abstract class AbstractScreen implements Screen{
	
	protected final PalmFighter game;
	protected Stage stage;
	protected final float VIEW_PORT_WIDTH_GUI = 800f;
	protected final float VIEW_PORT_HEGIHT_GUI = 480f;
	protected final float VIEW_PORT_WIDTH = 5.0f;
	protected final float VIEW_PORT_HEGIHT = 5.0f;
	
	
	protected float x;
	protected float y;
	
	private BitmapFont font;
	private SpriteBatch batch;
	private Skin skin;
	private Table table;
	
	protected OrthographicCamera camera;
	
	public AbstractScreen(PalmFighter game){
		this.game = game;
		this.font = new BitmapFont();
		this.batch = new SpriteBatch();
		this.stage = new Stage(VIEW_PORT_WIDTH_GUI, VIEW_PORT_HEGIHT_GUI, false);
		this.camera = new OrthographicCamera(VIEW_PORT_WIDTH_GUI, VIEW_PORT_HEGIHT_GUI);
		this.camera.position.set(VIEW_PORT_WIDTH_GUI/2f, VIEW_PORT_HEGIHT_GUI/2f, 0f);
		Assets.getInstance().init();
	}
	
	protected BitmapFont getFont(){
		if(this.font == null){
			font = new BitmapFont();
		}
		
		return this.font;
	}
	
	protected SpriteBatch getSpriteBatch(){
		if(this.batch == null){
			this.batch = new SpriteBatch();
		}
		return this.batch;
	}
	
	protected Skin getSkin(){
		if(skin == null){
			FileHandle skinFile = Gdx.files.internal(PFConstants.ScreenSkin.SKIN);
            skin = new Skin(skinFile);
		}
		return this.skin;
	}
	
	protected Table getTable(){
		if(table == null){
			table = new Table(getSkin());
			table.setFillParent(true);
			stage.addActor(table);
			
		}
		return table;
	}
	
	protected Stage getStage(){
		return this.stage;
	}
	
	protected String getScreenName(){
		return this.getClass().getSimpleName();
	}
	
	public abstract void render(float delta);
	public void resize(int width, int height){
		float aspectRatio = (float) width / (float) height;
		camera = new OrthographicCamera(2f * aspectRatio, 2f);
		camera.update();
		stage.getCamera().update();
	}
	public abstract void show();
	public abstract void resume();
	public abstract void pause();
	
//	@Override
//	public void render(float delta) {
//		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		table.debug();
//		stage.draw();
//		Table.drawDebug(stage);
//		stage.act(delta);
//		stage.draw();
//	}

//	@Override
//	public void resize(int width, int height) {
//		Gdx.app.log("Resize Screen", this.getScreenName());
//		
//		this.stage.setViewport(width, height, true);
//		
//		this.x = Gdx.graphics.getWidth();
//		this.y = Gdx.graphics.getHeight();
//	}
//
//	@Override
//	public void show() {
//		Gdx.app.log("Show Screen", this.getScreenName());
//		Gdx.input.setInputProcessor(stage);
//	}
//
//	@Override
//	public void hide() {
//		// TODO Auto-generated method stub
//		Gdx.app.log("Hide Screen", this.getScreenName());
//		
//	}
//
//	@Override
//	public void pause() {
//		// TODO Auto-generated method stub
//		Gdx.app.log("Pause Screen", this.getScreenName());
//		
//	}
//
//	@Override
//	public void resume() {
//		// TODO Auto-generated method stub
//		Gdx.app.log("Resume Screen", this.getScreenName());
//	}
//
	@Override
	public void dispose() {
		Gdx.app.log("Disposing Screen", this.getScreenName());
		stage.dispose();
		batch.dispose();
		font.dispose();
		
	}

}
