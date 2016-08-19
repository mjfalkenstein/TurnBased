package com.mystudio.utils;

public class Stats {
	
	int stamina,
		strength,
		intellect,
		skill,
		agility,
		atunement,
		humanity,
		movement;

	public Stats(int stamina, int strength, int intellect, 
			     int skill, int agility, int atunement, 
			     int humanity, int movement) {
		this.stamina = stamina;
		this.strength = strength;
		this.intellect = intellect;
		this.skill = skill;
		this.agility = agility;
		this.atunement = atunement;
		this.humanity = humanity;
		this.movement = movement;
	}
	
	public Stats() {
		this(1, 1, 1, 1, 1, 1, 1, 5);
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
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
	
	
}
