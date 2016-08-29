package com.mystudio.utils;

import org.mini2Dx.core.graphics.Graphics;

import com.mystudio.entities.Character;

public class BattlePrediction {

	Character attacker, defender;
	Stats attackerStats, defenderStats;
	int damage = 0;
	int chanceToHit = 50;
	int chanceToCrit = 0;
	boolean draw = false;

	public BattlePrediction(Character attacker, Character defender, boolean attackerDamageType, boolean defenderDamageType){
		if(attacker != null && defender != null){
			this.attacker = attacker;
			this.defender = defender;

			this.attackerStats = attacker.getStats();
			this.defenderStats = defender.getStats();

			if(attackerStats.getAccuracy() > defenderStats.getAgility()){
				for(int i = 0; i < attackerStats.getAccuracy() - defenderStats.getAgility(); i++){
					chanceToHit += 5;
				}
			}else if(attackerStats.getAccuracy() < defenderStats.getAgility()){
				for(int i = 0; i < defenderStats.getAgility() - attackerStats.getAccuracy(); i++){
					chanceToHit -= 5;
				}
			}

			if(attackerStats.getAtunement() > defenderStats.getHumanity()){
				for(int i = 0; i < attackerStats.getAtunement() - defenderStats.getHumanity(); i++){
					chanceToCrit += 5;
				}
			}else if(attackerStats.getAtunement() < defenderStats.getHumanity()){
				for(int i = 0; i < attackerStats.getHumanity() - defenderStats.getAtunement(); i++){
					chanceToCrit -= 5;
				}
			}

			chanceToCrit = chanceToCrit > 100 ? 100 : chanceToCrit < 0 ? 0 : chanceToCrit;

			if(attackerDamageType){
				damage = attackerStats.getStrength() - attackerStats.getArmor();
			}else{
				damage = attackerStats.getIntellect() - attackerStats.getResistence();
			}

			damage = damage < 0 ? 0 : damage;
		}
	}

	public void renderLeft(Graphics g, Camera c){
		if(draw){
			g.drawString("Attacker Battle Prediction:\n"
					+ "Damage:        " + damage
					+ "\nHit Chance:  " + chanceToHit + "%"
					+ "\nCrit Chance: " + chanceToCrit + "%", 
					g.getCurrentWidth() / 100 - c.getX(), g.getCurrentHeight() / 100 + 14 * (g.getFont().getLineHeight() + 10) - c.getY());
		}
	}
	
	public void renderRight(Graphics g, Camera c){
		if(draw){
			g.drawString("Defender Battle Prediction:\n"
					+ "Damage:        " + damage
					+ "\nHit Chance:  " + chanceToHit + "%"
					+ "\nCrit Chance: " + chanceToCrit + "%", 
					g.getCurrentWidth() / 10 - c.getX(), g.getCurrentHeight() / 100 + 14 * (g.getFont().getLineHeight() + 10) - c.getY());
		}
	}

	public void show(){
		draw = true;
	}

	public void hide(){
		draw = false;
	}

}
