package com.mystudio.utils;

public class Stats {
	
	int health,
		strength,
		intellect,
		skill,
		agility,
		atunement,
		humanity,
		movement,
		minRange,
		maxRange;

	public Stats(int stamina, int strength, int intellect, 
			     int skill, int agility, int atunement, 
			     int humanity, int movement, int minRange,
			     int maxRange) {
		this.health = stamina;
		this.strength = strength;
		this.intellect = intellect;
		this.skill = skill;
		this.agility = agility;
		this.atunement = atunement;
		this.humanity = humanity;
		this.movement = movement;
		this.minRange = minRange;
		this.maxRange = maxRange;
	}
	
	public Stats() {
		this(1, 1, 1, 1, 1, 1, 1, 5, 0, 2);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getAtunement() {
		return atunement;
	}

	public void setAtunement(int atunement) {
		this.atunement = atunement;
	}

	public int getHumanity() {
		return humanity;
	}

	public void setHumanity(int humanity) {
		this.humanity = humanity;
	}
	
	public int getMovement() {
		return movement;
	}
	
	public void setMovement(int movement) {
		this.movement = movement;
	}
	
	public int getMinRange(){
		return minRange;
	}
	
	public void setMinRange(int minRange){
		this.minRange = minRange;
	}
	
	public int getMaxRange(){
		return maxRange;
	}
	
	public void setMaxRange(int maxRange){
		this.maxRange = maxRange;
	}
}
