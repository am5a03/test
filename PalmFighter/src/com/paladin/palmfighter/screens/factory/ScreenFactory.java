package com.paladin.palmfighter.screens.factory;

import com.paladin.palmfighter.PalmFighter;
import com.paladin.palmfighter.screens.*;
import com.paladin.palmfighter.test.MapScreenTest;

public class ScreenFactory {

	public AbstractScreen produceScreen(ScreenType screenName, PalmFighter game) {
		switch(screenName){
		case SPLASH:
			return new SplashScreen(game);
		case MENU:
			return new MenuScreen(game);
		case CHOOSE_CHARACTER:
			return new ChooseCharacterScreen(game);
		case MAIN_GAME_TEST:
			return new MapScreenTest(game);
		}
		return null;
	}

}
