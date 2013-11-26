package com.paladin.palmfighter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.paladin.palmfighter.test.GameScreenTest;

public class PalmFighter extends Game {

	private FPSLogger fpsLogger;
	@Override
	public void create() {
		init();
	}
	
	@Override
	public void render(){
		super.render();
//		fpsLogger.log();
	}

	
	private void init(){
		this.fpsLogger = new FPSLogger();
//		ScreenFactory sf = new ScreenFactory(); 
//		this.setScreen(sf.produceScreen(ScreenType.MAIN_GAME_TEST, this));
		this.setScreen(new GameScreenTest(this));
		
	}
}
