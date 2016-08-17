package com.mystudio.utils;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.graphics.Graphics;

public class Camera {

	int dX, dY;
	int levelWidth, levelHeight;
	Rectangle view;
	boolean follow = true;

	/**
	 * Constructor
	 * 
	 * @param gc - GameContainer
	 * @param levelWidth - the maximum width of the level in pixels
	 * @param levelHeight - the maximum height of the level in pixels
	 */
	public Camera(GameContainer gc, int levelWidth, int levelHeight) {
		dX = 0;
		dY = 0;
		view = new Rectangle(0, 0, gc.getWidth(), gc.getHeight());
		this.levelWidth = levelWidth;
		this.levelHeight = levelHeight;
	}

	/**
	 * Instructs the camera to follow the given entity
	 * 
	 * @param gc - GameContainer
	 * @param g - the Graphics context
	 * @param e - the Entity to follow
	 */
	public void followCharacter(GameContainer gc, Graphics g, Entity e) {
		if(follow){
			view.setX((e.getX() - gc.getWidth()/2));
			view.setY((e.getY() - gc.getHeight()/2));
		}
	}
	
	public void move(float x, float y){
		view.setX(x);
		view.setY(y);
	}

	public int getX(){
		return (int) view.getX();
	}

	public int getY(){
		return (int) view.getY();
	}

	public void enable(){
		follow = true;
	}
	
	public void disable(){
		follow = false;
	}

	public boolean isActive() {
		return follow;
	}
}