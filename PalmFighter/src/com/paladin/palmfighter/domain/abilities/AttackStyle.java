package com.paladin.palmfighter.domain.abilities;

public class AttackStyle {
	
	private double damage;
	private double powerRequired;
	private String styleName;
	private boolean isEnabled; //Whether the style is enabled
	private boolean isShortRange; //Whether the style is short range or long range
	private float price;
	
	public double getDamage() {
		return damage;
	}
	public double getPowerRequired() {
		return powerRequired;
	}
	public void setPowerRequired(double powerRequired) {
		this.powerRequired = powerRequired;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public boolean isShortRange() {
		return isShortRange;
	}
	public void setShortRange(boolean isShortRange) {
		this.isShortRange = isShortRange;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
