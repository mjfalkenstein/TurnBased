/**
 * Class: Entity
 * 
 * An abstract class that represents anything that can be on the screen
 * includes buttons, characters, background sprites, etc
 */
package com.mystudio.utils;

import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import com.badlogic.gdx.graphics.Texture;
import com.mystudio.turnbased.TurnBasedDriver;

public abstract class Entity {
	
	protected int xTile, yTile, xPixel, yPixel, width, height;
	protected Sprite sprite;
	protected Texture texture;
	
	/**
	 * Constructor 
	 * 
	 * @param x - the starting X value for this entity
	 * @param y - the starting Y value for this entity
	 * @param texturePath - a string with the file path to the texture for this entity
	 * 						if left empty, the entity will be invisible
	 */
	public Entity(int x, int y){
		this.xTile = x;
		this.xPixel = x*TurnBasedDriver.TILESIZE;
		this.yTile = y;
		this.yPixel = y*TurnBasedDriver.TILESIZE;
	}
	
	/**
	 * Called every 10th of a second, used to update game logic
	 * 
	 * @param delta - time passed, in seconds, since the last update
	 */
	public abstract void update(float delta, Camera camera);
	
	/**
	 * Draws the entity to the screen
	 * 
	 * @param g - the graphics object that we're drawing to
	 */
	public abstract void render(Graphics g, Camera camera);
	
	public void moveByTile(int x, int y){
		this.xTile = x;
		this.xPixel = x*TurnBasedDriver.TILESIZE;
		this.yTile = y;
		this.yPixel = y*TurnBasedDriver.TILESIZE;
	}
	
	/** 
	 * Test if an entity has the mouse hovering over it
	 */
	public boolean mouseoverQ(int mouseX, int mouseY) {
		return mouseX >= this.xPixel && 
			   mouseX <= this.xPixel + this.width &&
			   mouseY >= this.yPixel && 
			   mouseY <= this.yPixel + this.height;
	}
	
	/** Getters and Setters **/
	
	public int getXTile(){
		return xTile;
	}
	
	public int getYTile(){
		return yTile;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getXPixel() {
		return xPixel;
	}

	public int getYPixel() {
		return yPixel;
	}
	
	public void moveByPixel(int x, int y){
		xPixel = x;
		yPixel = y;
	}

}
