package com.mystudio.entities;

import org.mini2Dx.core.graphics.Graphics;

import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Camera;
import com.mystudio.utils.Entity;

public class Button extends Entity{

	boolean draw = false;

	public Button(int x, int y, String texturePath) {
		super(x, y, texturePath);
	}

	@Override
	public void update(float delta, Camera camera) {
		//shouldn't need to do anything
	}

	@Override
	public void render(Graphics g, Camera camera) {
		if(draw){
			g.drawSprite(sprite, xPixel - camera.getX(), yPixel - camera.getY());
		}
	}

	public void show(){
		draw = true;
	}

	public void hide(){
		draw = false;
	}
}