package com.paladin.palmfighter.domain;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class TemplateMap {
	
	private ArrayList<Rectangle> rectangles;
	private ArrayList<Vector2> positions;
	private ArrayList<Vector2> dimensions;
	
	private final int NUM_LAYERS = 4;
	
	
	public ArrayList<Rectangle> getRectangles() {
		return rectangles;
	}

	public void setRectangles(ArrayList<Rectangle> rectangles) {
		this.rectangles = rectangles;
	}

	public ArrayList<Vector2> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<Vector2> positions) {
		this.positions = positions;
	}

	public ArrayList<Vector2> getDimensions() {
		return dimensions;
	}

	public void setDimensions(ArrayList<Vector2> dimensions) {
		this.dimensions = dimensions;
	}

	public TemplateMap(){
		this.rectangles = new ArrayList<Rectangle>();
		this.positions = new ArrayList<Vector2>();
		this.dimensions = new ArrayList<Vector2>();
		for(int i = 0; i < NUM_LAYERS; i++){
			this.rectangles.add(new Rectangle());
			this.positions.add(new Vector2());
			this.dimensions.add(new Vector2());
		}
		initLayout();
	}
	
	private void initLayout(){
		//Pic 1 & 2
		this.dimensions.get(0).x = 800 + 167;
		this.dimensions.get(0).y = 145;
		
		//Pic 3 & 4
		this.dimensions.get(1).x = 500 + 500;
		this.dimensions.get(1).y = 150;
		
		//Pic 5 & 6
		this.dimensions.get(2).x = 750 + 750;
		this.dimensions.get(2).y = 66;
		
		//Pic 7 & 8
		this.dimensions.get(3).x = 800 + 800;
		this.dimensions.get(3).y = 115;
		
		for(int i = 0; i < NUM_LAYERS; i++){
			this.rectangles.get(i).width = this.dimensions.get(i).x;
			this.rectangles.get(i).height = this.dimensions.get(i).y;
		}
	}
	
}
