package com.paladin.palmfighter.domain;

import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.paladin.palmfighter.domain.abilities.BaseAbility;

public class BaseCharacter implements Serializable{
	
	public enum Direction{
		LEFT, RIGHT
	}
	
	private final int BASE_ABILITY_POINT = 50;
	private final int BASE_LEVEL = 1;
	private int hp;
	private int mp;
	private int abilityPoint;
	private int lv;
	private int team;
	private int jumpHeight;
	private int walkingSpeed;
	private ArrayList<BaseAbility> bAbilities;
	
	private CharacterState state;
	private Direction direction;
	private Rectangle bound;
	
	private final int WIDTH = 80;
	private final int HEIGHT = 80;
	
	private float stateTime = 0;
	private Vector2 velocity;
	private Vector2 position;
	
	public CharacterState getState() {
		return state;
	}

	public void setState(CharacterState state) {
		this.state = state;
	}

	public BaseCharacter(int hp, int mp, ArrayList<BaseAbility> bAbilities){
		this.hp = hp;
		this.mp = mp;
		this.bAbilities = bAbilities;
		this.state = CharacterState.IDLE;
		this.bound = new Rectangle();
		this.position = new Vector2();
		this.velocity = new Vector2();
		this.bound.width = WIDTH;
		this.bound.height = HEIGHT;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public ArrayList<BaseAbility> getbAbility() {
		return bAbilities;
	}

	public void setbAbility(ArrayList<BaseAbility> bAbilities) {
		this.bAbilities = bAbilities;
	}

	public int getAbilityPoint() {
		return abilityPoint;
	}

	public void setAbilityPoint(int abilityPoint) {
		this.abilityPoint = abilityPoint;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getLevel() {
		return lv;
	}

	public void setLevel(int lv) {
		this.lv = lv;
	}

	public int getJumpHeight() {
		return jumpHeight;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public int getWalkingSpeed() {
		return walkingSpeed;
	}

	public void setWalkingSpeed(int walkingSpeed) {
		this.walkingSpeed = walkingSpeed;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public void update(float delta){
		stateTime += delta;
		position.add(velocity.scl(delta));
	}

	@Override
	public void write(Json json) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		// TODO Auto-generated method stub
		
	}
	
}
