package com.mystudio.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.graphics.Color;

public class Stats{
	
	LinkedHashMap<String, Integer> statsTable = new LinkedHashMap<String, Integer>();

	public Stats(int maxHealth, int strength, int intellect, 
			     int accuracy, int agility, int atunement, 
			     int humanity, int armor, int resistence, 
			     int movement, int minRange, int maxRange){

		statsTable.put("Health\t\t", maxHealth);
		statsTable.put("Max Health\t", maxHealth);
		statsTable.put("Strength\t", strength);
		statsTable.put("Intellect\t", intellect);
		statsTable.put("Accuracy\t", accuracy);
		statsTable.put("Agility\t\t", agility);
		statsTable.put("Atunement\t", atunement);
		statsTable.put("Humanity\t", humanity);
		statsTable.put("Armor\t\t", armor);
		statsTable.put("Resistence\t", resistence);
		statsTable.put("Movement\t", movement);
		statsTable.put("Min Range\t", minRange);
		statsTable.put("Max Range\t", maxRange);
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
		return statsTable.get("Health\t\t");
	}

	public void setCurrentHealth(int health) {
		statsTable.put("Health\t\t", health);
	}
	
	public int getMaxHealth(){
		return statsTable.get("Max Health\t");
	}
	
	public void setMaxHealth(int maxHealth){
		statsTable.put("Max Health/t", maxHealth);
	}

	public int getStrength() {
		return statsTable.get("Strength\t");
	}

	public void setStrength(int strength) {
		statsTable.put("Strength\t", strength);
	}

	public int getIntellect() {
		return statsTable.get("Intellect\t");
	}

	public void setIntellect(int intellect) {
		statsTable.put("Intellect\t", intellect);
	}

	public int getAccuracy() {
		return statsTable.get("Accuracy\t");
	}

	public void setAccuracy(int accuracy) {
		statsTable.put("Accuracy\t", accuracy);
	}

	public int getAgility() {
		return statsTable.get("Agility\t\t");
	}

	public void setAgility(int agility) {
		statsTable.put("Agility\t\t", agility);
	}

	public int getAtunement() {
		return statsTable.get("Atunement\t");
	}

	public void setAtunement(int atunement) {
		statsTable.put("Atunement\t", atunement);
	}

	public int getHumanity() {
		return statsTable.get("Humanity\t");
	}

	public void setHumanity(int humanity) {
		statsTable.put("Humanity\t", humanity);
	}
	
	public int getArmor() {
		return statsTable.get("Armor\t\t");
	}

	public void setArmor(int armor) {
		statsTable.put("Armor\t\t", armor);
	}
	
	public int getResistence() {
		return statsTable.get("Resistence\t");
	}

	public void setResistence(int resistence) {
		statsTable.put("Resistence\t", resistence);
	}
	
	public int getMovement() {
		return statsTable.get("Movement\t");
	}
	
	public void setMovement(int movement) {
		statsTable.put("Movement\t", movement);
	}
	
	public int getMinRange(){
		return statsTable.get("Min Range\t");
	}
	
	public void setMinRange(int minRange){
		statsTable.put("Min Range\t", minRange);
	}
	
	public int getMaxRange(){
		return statsTable.get("Max Range\t");
	}
	
	public void setMaxRange(int maxRange){
		statsTable.put("Max Range\t", maxRange);
	}
}
