package com.paladin.palmfighter.domain.abilities;

import java.util.ArrayList;

public abstract class BaseAbility {
	enum AbilityType{
		MATTER, MIND, PHYSICAL
	};
	
	enum AbilityName{
		/*MATTER*/
		CRYOKINESIS,
		PYROKINESIS,
		ELECTRIC_MANIUPLATION,
		HEALING,
		RADIATION,
		MOLECULAR_MANIPULATION,
		TECHNOPATHY,
		POWER_NEGATION,
		
		/*MIND*/
		PRECOGNITION,
		TELEKINESIS,
		TELEPATHY,
		MEM_MANIPULATION,
		TIMESPACE_MANIPULATION,
		INTUTIVE_COMPREHENSION,
		
		/*PHYSICAL*/
		SUPERHUMAN_STRENGTH,
		FLIGHT,
		SUPERHUMAN_SPEED,
		INVSIBILITY,
		SPONTANEOUS_REGENERATION,
		POWER_ABSORPTION
		
	}
	
	AbilityType abilityType;
	AbilityName abilityName;
	ArrayList<AttackStyle> attackStyles;
	
	public BaseAbility(){
		
	}
	
	protected BaseAbility(AbilityType abilityType, AbilityName abilityName){
		this.abilityType = abilityType;
		this.abilityName = abilityName;
		this.attackStyles = new ArrayList<AttackStyle>();
	}
	
	public ArrayList<AttackStyle> getAttackStyles() {
		return attackStyles;
	}

	public void setAtackStyles(ArrayList<AttackStyle> attackStyles) {
		this.attackStyles = attackStyles;
	}

	public void setAbilityName(AbilityName abilityName){
		this.abilityName = abilityName;
	}
	
	public AbilityName getAbilityName(){
		return this.abilityName;
	}
	
	public void setAbilityType(AbilityType abilityType){
		this.abilityType = abilityType;
	}
	
	public AbilityType getAbilityType(){
		return this.abilityType;
	}
}
