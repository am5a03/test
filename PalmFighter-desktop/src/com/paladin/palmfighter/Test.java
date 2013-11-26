package com.paladin.palmfighter;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Test {
	private static boolean rebuildAtlas = false;
	private static boolean drawDebugline = false;
	
	
	
	public static void main(String[] args) {
		final int WIDTH = 800;
		final int HEIGHT = 480;
		int isCodeTest = 0;
		
		if(rebuildAtlas){
			Settings settings = new Settings();
			settings.maxWidth = 2048;
			settings.maxHeight = 2048;
			settings.debug = false;
			TexturePacker2.process(settings, "asset-raw/images", "../PalmFighter-Android/assets/test", "test.pack");
		}
		if(isCodeTest == 1){
			new LwjglApplication(new PalmFighterTest(), "Game",	WIDTH, HEIGHT, false);
		}else{
			new LwjglApplication(new PalmFighter(), "Game",	WIDTH, HEIGHT, false);
		}
		
	}

}
