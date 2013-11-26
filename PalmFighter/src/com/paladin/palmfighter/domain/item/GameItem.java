package com.paladin.palmfighter.domain.item;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameItem {
	private float damage; //How much damage will
	private float weight;
	private float strength;
	private String itemName;
	
	private Vector2 position;
	private Vector2 dimesion;
	private Vector2 origin;
	private float rotation;
	
	private Vector2 velocity;
	private Vector2 terminalVelocity;
	private Vector2 friction;
	private Vector2 accleration;
	private Rectangle bounds;
	
	enum ItemType{
		BOX, BOOMERANG, BAT, BASEBALL, STONE, SICKLE, MILK, BEER
	}

	private ItemType itemType;
	
	public void setItemType(ItemType itemType){
		this.itemType = itemType;
	}
	
	public ItemType getItemType(){
		return this.itemType;
	}
	
	public float getStrength() {
		return strength;
	}


	public void setStrength(float strength) {
		this.strength = strength;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public void update(float deltaTime){
		
	}
	
	public void render(SpriteBatch batch){
		
	}
}
