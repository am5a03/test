package com.paladin.palmfighter.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.paladin.palmfighter.PalmFighter;
import com.paladin.palmfighter.assets.Assets;
import com.paladin.palmfighter.utils.PFConstants;

public class ChooseCharacterScreen extends AbstractScreen {
	
	private final int NUM_ROWS = 2;
	private final int NUM_CHARS_PER_ROW = 4;
	private float windowWidth = VIEW_PORT_WIDTH_GUI/1.2f;
	private float windowHeight = VIEW_PORT_HEGIHT_GUI/1.2f;
	
	private ArrayList<String> characterNme;
	private String[] teamStr = { "Independent", "1", "2", "3", "4" };
	private int grpNum = 0;
	private int charNum = 0;
	
	private ImageCharacterGroup[] imageCharacterGrps;
	
	public ChooseCharacterScreen(PalmFighter game) {
		super(game);
		this.characterNme = new ArrayList<String>();
		this.characterNme.add("Random");
		this.characterNme.add("Template");
		this.characterNme.add("Test");
		
		this.imageCharacterGrps = new ImageCharacterGroup[NUM_ROWS * NUM_CHARS_PER_ROW];
		
		for(int i = 0; i < NUM_ROWS * NUM_CHARS_PER_ROW; i++){
			this.imageCharacterGrps[i] = new ImageCharacterGroup();			
			this.imageCharacterGrps[i].setChosenCharacterNme(new Label("", getSkin(), PFConstants.Font.XSMALL));
			this.imageCharacterGrps[i].setChosenCharacterGrp(new Label("", getSkin(), PFConstants.Font.XSMALL));
		}
	}
	
	@Override
	public void show(){
		Gdx.input.setInputProcessor(stage);
		generateMenu();
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0.0f, 0.5f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
//		getTable().debug();
		
//		if(characterWindow != null){
//			characterWindow.debug();
//		}
		
//		Table.drawDebug(stage);
		stage.act(delta);
		stage.draw();
	}
	
	private void generateMenu(){
		getTable().setBounds(0, 0, VIEW_PORT_WIDTH_GUI, VIEW_PORT_HEGIHT_GUI);
		getTable().top();
		getTable().add("Character Selection (選擇角色)").colspan(4).expandX().padBottom(5);
		getTable().row();
		int count = 0;
		for(int i = 0; i < NUM_ROWS; i++){
			for(int j = 0; j < NUM_CHARS_PER_ROW; j++){
				getTable().add(addCharacterGroup(count++)).pad(10);
			}
			getTable().row();
		}
		
		getTable().add(new TextButton("Confirm", getSkin())).colspan(2);
		getTable().add(new TextButton("Cancel", getSkin())).colspan(2);
	}
	
	//Image, group name
	private Table addCharacterGroup(final int windowId){
		Table t = new Table(getSkin());
		Image charImage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("data/join.png")))));
		
		this.imageCharacterGrps[windowId].setCharacterImages(charImage);		
		
		t.add(this.imageCharacterGrps[windowId].getCharacterImages()).size(128, 128).colspan(2);
		t.row();
		t.add("Character (角色):", PFConstants.Font.XSMALL).width(95);
		t.add(this.imageCharacterGrps[windowId].getChosenCharacterNme()).width(90);
		t.row();
		t.add("Group (組別):", PFConstants.Font.XSMALL).width(95);
		t.add(this.imageCharacterGrps[windowId].getChosenCharacterGrp()).width(90);
		
		charImage.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				imageCharacterGrps[windowId].setCharacterWindows(getCharacterWindow(windowId));
				//Get height and width of the window
				float posX = imageCharacterGrps[windowId].getCharacterWindows().getWidth();
				float posY = imageCharacterGrps[windowId].getCharacterWindows().getHeight();
				
				//Put window to center
				imageCharacterGrps[windowId].getCharacterWindows().setPosition((stage.getCamera().viewportWidth - posX)/2,
		 				(stage.getCamera().viewportHeight - posY)/2);
		 		
		 		//Check windows existence, if exist, set it visible again else add a new window to stage
		 		if(stage.getActors().contains(imageCharacterGrps[windowId].getCharacterWindows(), false)){
		 			int windowIdx = stage.getActors().indexOf(imageCharacterGrps[windowId].getCharacterWindows(), false);
		 			stage.getActors().get(windowIdx).setVisible(true);
		 		}else{
		 			stage.addActor(imageCharacterGrps[windowId].getCharacterWindows());
		 		}
		 		
				
		 		
		 		return true;
		 	}
		 
		 	public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		 		Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")");
		 	}

		});
		
		return t;
		
	}
	//Select characters
	private Table getCharacterWindow(final int windowId){
		Table t;
		if(imageCharacterGrps[windowId].getCharacterWindows() == null){
			Window w = new Window("選擇角色", getSkin());
			w.debug();
			w.setSize(windowWidth, windowHeight);
			
			w.add(buildAvatarTbl(windowId)).expand();	
			w.setModal(true);
			w.setMovable(false);
			return w;
		}else{
			t = imageCharacterGrps[windowId].getCharacterWindows();
			return t;
		}		
	}
	
	private Table buildAvatarTbl(final int windowId){
		final Image avatar = new Image(Assets.getInstance().templateGuy.templateGuy);
		
		Table container = new Table(getSkin());
		Table t1 = new Table(getSkin());
		Table t2 = new Table(getSkin());
		TextButton btnConfirm = new TextButton("Confirm", getSkin());
		TextButton btnCancel = new TextButton("Cancel", getSkin());
		TextButton btnPrevChar = new TextButton("<", getSkin());
		TextButton btnPrevGrp = new TextButton("<", getSkin());
		TextButton btnNextGrp = new TextButton(">", getSkin());
		TextButton btnNextChar = new TextButton(">", getSkin());
		
		final Label lblCharNme = new Label(this.characterNme.get(0), getSkin());
		final Label lblgrpNme = new Label(this.teamStr[0], getSkin());
		
		container.setSize(windowWidth, windowHeight);
//		t1.setSize(windowWidth*0.8f, windowHeight);
//		t2.setSize(windowWidth*0.2f, windowHeight);
		t1.add(avatar).pad(50);
		t1.defaults().pad(10).space(20);
		t2.defaults().pad(10).space(20);
		
		t2.add("Character (角色)").size(110, 20);
		t2.add(btnPrevChar);		
		t2.add(lblCharNme).size(90,20);
		t2.add(btnNextChar);
		
		t2.row();
		
		t2.add("Group (組別)").size(110,20);
		t2.add(btnPrevGrp);
		t2.add(lblgrpNme).size(90,20);
		t2.add(btnNextGrp);
		
		t2.row();
		
		t2.add(btnConfirm).colspan(2);
		t2.add(btnCancel).colspan(2);
		
		container.add(t1);
		container.add(t2);
		
		avatar.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("data/face.png")))));
		//Listeners
		btnPrevGrp.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				lblgrpNme.setText(teamStr[Math.abs(--grpNum % teamStr.length)]);
		 		return true;
		 	}
		});
		
		btnNextGrp.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				lblgrpNme.setText(teamStr[Math.abs(++grpNum % teamStr.length)]);
		 		return true;
		 	}
		});
		
		btnNextChar.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				lblCharNme.setText(characterNme.get(Math.abs(--charNum % characterNme.size())));
		 		return true;
		 	}
		});
		
		btnPrevChar.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				lblCharNme.setText(characterNme.get(Math.abs(++charNum % characterNme.size())));
		 		return true;
		 	}
		});
		
		btnConfirm.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				Drawable newCharImg = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("data/face.png"))));
				imageCharacterGrps[windowId].getCharacterImages().setDrawable(newCharImg);
				imageCharacterGrps[windowId].getChosenCharacterNme().setText(lblCharNme.getText());
				imageCharacterGrps[windowId].getChosenCharacterGrp().setText(lblgrpNme.getText());
				imageCharacterGrps[windowId].getCharacterWindows().setVisible(false);
				
//				characterImages[windowId].setDrawable();
//				Label l = (Label)characterWindows[windowId].getCell(chosenCharacterNme[0]).getWidget();
//				chosenCharacterNme[windowId].setText(lblCharNme.getText());
//				chosenCharacterGrp[windowId].setText(lblgrpNme.getText());
//				characterWindows[windowId].setVisible(false);
		 		return true;
		 	}
		});
		
		btnCancel.addListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				imageCharacterGrps[windowId].getCharacterWindows().setVisible(false);
		 		return true;
		 	}
		});
		
		return container;
	}
	

	@Override
	public void hide() {
		
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void pause() {
		
	}
	
	private class ImageCharacterGroup{
		private Table characterWindows;
		private Image characterImages;
		private Label chosenCharacterNme;
		private Label chosenCharacterGrp;
		
		public Table getCharacterWindows() {
			return characterWindows;
		}
		public void setCharacterWindows(Table characterWindows) {
			this.characterWindows = characterWindows;
		}
		public Image getCharacterImages() {
			return characterImages;
		}
		public void setCharacterImages(Image characterImages) {
			this.characterImages = characterImages;
		}
		public Label getChosenCharacterNme() {
			return chosenCharacterNme;
		}
		public void setChosenCharacterNme(Label chosenCharacterNme) {
			this.chosenCharacterNme = chosenCharacterNme;
		}
		public Label getChosenCharacterGrp() {
			return chosenCharacterGrp;
		}
		public void setChosenCharacterGrp(Label chosenCharacterGrp) {
			this.chosenCharacterGrp = chosenCharacterGrp;
		}
		
		
	}

}
