package com.paladin.palmfighter.test;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.paladin.palmfighter.domain.GameWorld;

public class WorldRenderer {

	private final static int CAMERA_WIDTH = 795;
	private final static int CAMERA_HEIGHT = 400;
	private boolean isDebug = false;
	
	private OrthographicCamera camera;

	private GameWorld gameWorld;
	
	
	
	
	public WorldRenderer(GameWorld gameWorld, boolean debug){
		this.gameWorld = gameWorld;
		this.isDebug = debug;
	}
	
	

	
	
}
