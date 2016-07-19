/**
 * Class: Character
 * 
 * This class represents any character that can take part in the game
 * includes playable characters, enemies, and NPCs
 */

package com.mystudio.entities;

import org.mini2Dx.core.graphics.Graphics;

import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Entity;

public class Character extends Entity{

	public Character(int x, int y, String texturePath) {
		super(x, y, texturePath);
		sprite.setScale(TurnBasedDriver.TileSize / sprite.getWidth(), TurnBasedDriver.TileSize / sprite.getWidth());
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawSprite(sprite, x * TurnBasedDriver.TileSize, y * TurnBasedDriver.TileSize);
	}
}