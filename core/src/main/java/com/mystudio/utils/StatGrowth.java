package com.mystudio.utils;

public class StatGrowth {
	
	double 	stamina,
			strength,
			intellect,
			skill,
			agility,
			atunement,
			humanity;

	public StatGrowth(double stamina, double strength, double intellect, double skill, double agility, double atunement, double humanity) {
		this.stamina = stamina;
		this.strength = strength;
		this.intellect = intellect;
		this.skill = skill;
		this.agility = agility;
		this.atunement = atunement;
		this.humanity = humanity;
	}
	
	public StatGrowth() {
		this(0, 0, 0, 0, 0, 0, 0);
	}

	public double getStamina() {
		return stamina;
	}

	public void setStamina(double stamina) {
		this.stamina = stamina;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public double getIntellect() {
		return intellect;
	}

	public void setIntellect(double intellect) {
		this.intellect = intellect;
	}

	public double getSkill() {
		return skill;
	}

	public void setSkill(double skill) {
		this.skill = skill;
	}

	public double getAgility() {
		return agility;
	}

	public void setAgility(double agility) {
		this.agility = agility;
	}

	public double getAtunement() {
		return atunement;
	}

	public void setAtunement(double atunement) {
		this.atunement = atunement;
	}

	public double getHumanity() {
		return humanity;
	}

	public void setHumanity(double humanity) {
		this.humanity = humanity;
	}
}
