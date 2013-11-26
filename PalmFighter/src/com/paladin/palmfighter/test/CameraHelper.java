package com.paladin.palmfighter.test;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CameraHelper {
	private final float MAX_ZOOM_IN = 0.25f;
	private final float MAX_ZOOM_OUT = 10.0f;
	
	private Vector2 position;
	private float zoom;
	private Sprite target;
	
	public CameraHelper(){
		this.position = new Vector2();
		this.zoom = 1.0f;
	}
	
	public void update(float deltaTime){
		if(!hasTarget()) return;
		
		this.position.x = target.getX() + target.getOriginX();
		this.position.y = target.getY() + target.getOriginY();
	}
	
	public void setPosition(float x, float y){
		this.position.set(x,y);
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
	
	public void addZoom(float amount){
		setZoom(zoom + amount);
	}
	
	public void setZoom(float zoom){
		this.zoom = MathUtils.clamp(zoom, MAX_ZOOM_IN, MAX_ZOOM_OUT);
	}
	
	public float getZoom(){
		return this.zoom;
	}
	
	public void setTarget(Sprite target){
		this.target = target;
	}
	
	public boolean hasTarget(){
		return target != null;
	}
	
	public boolean hasTarget(Sprite target){
		return hasTarget() && this.target.equals(target);
	}
	
	public void applyTo(OrthographicCamera camera){
		camera.position.x = this.position.x;
		camera.position.y = this.position.y;
		camera.zoom = this.zoom;
		camera.update();
	}
}
