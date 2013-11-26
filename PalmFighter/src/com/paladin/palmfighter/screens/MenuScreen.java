package com.paladin.palmfighter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.paladin.palmfighter.PalmFighter;

public class MenuScreen extends AbstractScreen {
	Label label;
	public MenuScreen(PalmFighter game) {
		super(game);
		label = new Label("Little Fighter(�p�B�ͻ�����)", getSkin());
	}
	
	@Override
	public void show(){	
		Gdx.input.setInputProcessor(stage);
		Table table = super.getTable();
		table.add("Little Fighter(�p�B�ͻ�����)");
		table.row();
		
		TextButton btnSingleMode = new TextButton("VS Mode (��M�Ҧ�)", getSkin());
		TextButton btnStageMode = new TextButton("Stage Mode (�����Ҧ�)", getSkin());
		TextButton btnOneOnOneMode = new TextButton("1 on 1 Championship (�^�O��)", getSkin());
		TextButton btnTwoOntwoMode = new TextButton("2 on 2 Championship (�^�O��)", getSkin());
		
		table.add(btnSingleMode).size(300, 60).uniform();
		table.row();
		
		table.add(btnStageMode).uniform().fill();
		table.row();
		
		table.add(btnOneOnOneMode).uniform().fill();
		table.row();
		
		table.add(btnTwoOntwoMode).uniform().fill();
		
	}
	
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(0f, 0.035f, 0.35f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		getStage().addActor(getTable());
		getStage().act(delta);
		getStage().draw();
	}

	@Override
	public void hide() {
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

}
