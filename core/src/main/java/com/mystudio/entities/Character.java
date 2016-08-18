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
import com.mystudio.utils.Stats;

public class Character extends Entity{
	
	int level;
	Stats stats;

	public Character(int x, int y, String texturePath) {
		super(x, y, texturePath);
		sprite.setScale(TurnBasedDriver.TILESIZE / sprite.getWidth(), TurnBasedDriver.TILESIZE / sprite.getWidth());
	}

	@Override
	public void update(float delta) {

	}

	@Override
	public void render(Graphics g) {
		g.drawSprite(sprite, x * TurnBasedDriver.TILESIZE, y * TurnBasedDriver.TILESIZE);
	}
}