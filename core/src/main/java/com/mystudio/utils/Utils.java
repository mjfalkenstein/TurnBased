package com.mystudio.utils;

import java.util.Random;

import org.mini2Dx.core.graphics.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mystudio.entities.Character;

public class Utils {

	public static Sprite makeSprite(TextureRegion tr){
		return new Sprite(tr.getTexture(), tr.getRegionX(), tr.getRegionY(), tr.getRegionWidth(), tr.getRegionHeight());
	}

	public static Sprite makeSprite(TextureRegion tr, int i) { 
		return new Sprite(tr.getTexture(),tr.getRegionX(), i-tr.getRegionY(),tr.getRegionWidth(),tr.getRegionHeight()); 
	}
	
	public static void doBattle(Character attacker, Character defender, boolean attackerDamageType, boolean defenderDamageType){
		System.out.println("Simulating Battle\n\n");
		Stats attackerStats = attacker.getStats();
		Stats defenderStats = defender.getStats();

		doHit(attackerStats, defenderStats, attackerDamageType, defenderDamageType);
		doHit(defenderStats, attackerStats, defenderDamageType, attackerDamageType);
		
		if(attackerStats.getAgility() - defenderStats.getAgility() >= 5){
			doHit(attackerStats, defenderStats, attackerDamageType, defenderDamageType);
		}
		
		attacker.setAttacked(true);
		
		System.out.println("Attacker Stats:\n" + attackerStats);
		System.out.println("Defender Stats:\n" + defenderStats);
	}
	
	private static void doHit(Stats attackerStats, Stats defenderStats, boolean attackerDamageType, boolean defenderDamageType){
		int chanceToHit = 50;
		int chanceToCrit = 0;
		int damage = 0;
		
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
		
		Random r = new Random();
		
		int hit = r.nextInt(100) + 1;
		
		if(hit <= chanceToHit){
			System.out.println("Hit!");
			int crit = r.nextInt(100) + 1;
			if(crit <= chanceToCrit){
				System.out.println("Crit!");
				damage *= 2;
			}
			
			defenderStats.setCurrentHealth(defenderStats.getCurrentHealth() - damage);
		}else{
			System.out.println("Miss!");
		}
	}
}