package com.paladin.palmfighter.domain;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.paladin.palmfighter.domain.item.GameItem;

public class GameWorld {
	private ArrayList<BaseCharacter> characters;
	private ArrayList<GameItem> items;
	private TemplateMap map;
	
	
	public GameWorld(){
		this.characters = new ArrayList<BaseCharacter>();
		this.items = new ArrayList<GameItem>();
		this.setMap(new TemplateMap());
		initTestingData();
	}
	
	
	public ArrayList<BaseCharacter> getCharacters() {
		return characters;
	}
	public void setCharacters(ArrayList<BaseCharacter> characters) {
		this.characters = characters;
	}
	public ArrayList<GameItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<GameItem> items) {
		this.items = items;
	}
	
	private void initTestingData(){
		this.characters.add(new BaseCharacter(100, 100, null));
		this.characters.get(0).setPosition(new Vector2(40, 40));
	}


	public TemplateMap getMap() {
		return map;
	}


	public void setMap(TemplateMap map) {
		this.map = map;
	}
	
	
}
