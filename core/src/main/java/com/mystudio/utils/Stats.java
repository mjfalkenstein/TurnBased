package com.mystudio.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.graphics.Color;

public class Stats{
	
	LinkedHashMap<String, Integer> statsTable = new LinkedHashMap<String, Integer>();

	public Stats(int maxHealth, int strength, int intellect, 
			     int accuracy, int agility, int atunement, 
			     int humanity, int armor, int resistence, 
			     int movement, int minRange, int maxRange){

		statsTable.put("Health", maxHealth);
		statsTable.put("Max Health", maxHealth);
		statsTable.put("Strength", strength);
		statsTable.put("Intellect", intellect);
		statsTable.put("Accuracy", accuracy);
		statsTable.put("Agility", agility);
		statsTable.put("Atunement", atunement);
		statsTable.put("Humanity", humanity);
		statsTable.put("Armor", armor);
		statsTable.put("Resistence", resistence);
		statsTable.put("Movement", movement);
		statsTable.put("Min Range", minRange);
		statsTable.put("Max Range", maxRange);
	}
	
	public Stats() {
		this(10, 1, 1, 1, 1, 1, 1, 1, 1, 5, 0, 1);
	}
	
	public void drawLeft(Graphics g, Camera c){
		g.setColor(Color.WHITE);
		int counter = 0;
		Iterator it = statsTable.entrySet().iterator();
		g.drawString("Attacker Stats: ", g.getCurrentWidth() / 100 - c.getX(), g.getCurrentHeight() / 100 + counter * (g.getFont().getLineHeight() + 10) - c.getY());
		while(it.hasNext()){
			counter++;
			Map.Entry pair = (Map.Entry) it.next();
			g.drawString((String)pair.getKey(), 
						 g.getCurrentWidth() / 100 - c.getX(), 
						 g.getCurrentHeight() / 100 + counter * (g.getFont().getLineHeight() + 10) - c.getY());
			g.drawString("                       " + (Integer)pair.getValue(), 
						 g.getCurrentWidth() / 100 - c.getX(),				
						 g.getCurrentHeight() / 100 + counter * (g.getFont().getLineHeight() + 10) - c.getY());
		}
	}
	
	public void drawRight(Graphics g, Camera c){
		g.setColor(Color.WHITE);
		int counter = 0;
		Iterator it = statsTable.entrySet().iterator();
		g.drawString("Defender Stats: ",  g.getCurrentWidth() / 10 - c.getX(), g.getCurrentHeight() / 100 + counter * (g.getFont().getLineHeight() + 10) - c.getY());
		while(it.hasNext()){
			counter++;
			Map.Entry pair = (Map.Entry) it.next();
			g.drawString((String)pair.getKey(), 
						 g.getCurrentWidth() / 10 - c.getX(), 
						 g.getCurrentHeight() / 100 + counter * (g.getFont().getLineHeight() + 10) - c.getY());
			g.drawString("                       " + (Integer)pair.getValue(), 
						 g.getCurrentWidth() / 10 - c.getX(),				
						 g.getCurrentHeight() / 100 + counter * (g.getFont().getLineHeight() + 10) - c.getY());
		}
	}
	
	public String toString(){
		String output = "";
		
		Iterator it = statsTable.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry) it.next();
			output += pair.getKey() + "\t" + pair.getValue() + "\n";
		}
		
		return output;
	}

	public int getCurrentHealth() {
		return statsTable.get("Health");
	}

	public void setCurrentHealth(int health) {
		statsTable.put("Health", health);
	}
	
	public int getMaxHealth(){
		return statsTable.get("Max Health");
	}
	
	public void setMaxHealth(int maxHealth){
		statsTable.put("Max Health", maxHealth);
	}

	public int getStrength() {
		return statsTable.get("Strength");
	}

	public void setStrength(int strength) {
		statsTable.put("Strength", strength);
	}

	public int getIntellect() {
		return statsTable.get("Intellect");
	}

	public void setIntellect(int intellect) {
		statsTable.put("Intellect", intellect);
	}

	public int getAccuracy() {
		return statsTable.get("Accuracy");
	}

	public void setAccuracy(int accuracy) {
		statsTable.put("Accuracy", accuracy);
	}

	public int getAgility() {
		return statsTable.get("Agility");
	}

	public void setAgility(int agility) {
		statsTable.put("Agility", agility);
	}

	public int getAtunement() {
		return statsTable.get("Atunement");
	}

	public void setAtunement(int atunement) {
		statsTable.put("Atunement", atunement);
	}

	public int getHumanity() {
		return statsTable.get("Humanity");
	}

	public void setHumanity(int humanity) {
		statsTable.put("Humanity", humanity);
	}
	
	public int getArmor() {
		return statsTable.get("Armor");
	}

	public void setArmor(int armor) {
		statsTable.put("Armor", armor);
	}
	
	public int getResistence() {
		return statsTable.get("Resistence");
	}

	public void setResistence(int resistence) {
		statsTable.put("Resistence", resistence);
	}
	
	public int getMovement() {
		return statsTable.get("Movement");
	}
	
	public void setMovement(int movement) {
		statsTable.put("Movement", movement);
	}
	
	public int getMinRange(){
		return statsTable.get("Min Range");
	}
	
	public void setMinRange(int minRange){
		statsTable.put("Min Range", minRange);
	}
	
	public int getMaxRange(){
		return statsTable.get("Max Range");
	}
	
	public void setMaxRange(int maxRange){
		statsTable.put("Max Range", maxRange);
	}
}
