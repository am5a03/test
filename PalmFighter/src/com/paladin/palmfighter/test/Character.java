package com.paladin.palmfighter.test;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Character {
	public enum State{
		IDLE, WALKING, JUMPING, DYING
	}
	
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 accleration;
	private Rectangle bound;
	private State state;
	
	private final int WIDTH = 80;
	private final int HEIGHT = 80;
	
	public Character(){
		this.position = new Vector2();
		this.velocity = new Vector2();
		this.accleration = new Vector2();
		this.bound = new Rectangle();
		this.bound.width = WIDTH;
		this.bound.height = HEIGHT;
	}
	
	
}
