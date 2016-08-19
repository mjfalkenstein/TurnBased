/**
 * Class: Character
 * 
 * This class represents any character that can take part in the game
 * includes playable characters, enemies, and NPCs
 */

package com.mystudio.entities;

import org.mini2Dx.core.graphics.Graphics;

import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Camera;
import com.mystudio.utils.Entity;
import com.mystudio.utils.Stats;
import com.mystudio.utils.StatGrowth;

public class Character extends Entity{
	
	int level;
	Stats stats;
	StatGrowth growth;

	public Character(int x, int y, String texturePath, Stats initialStats, 
					 StatGrowth growthChances) {
		super(x, y, texturePath);
		
		stats = initialStats;
		growth = growthChances;
		
		// Scales the sprite about the top left corner
		sprite.setOrigin(0, 0);
		sprite.setScale(TurnBasedDriver.TILESIZE / sprite.getWidth(), 
					    TurnBasedDriver.TILESIZE / sprite.getHeight());
	}

	@Override
	public void update(float delta, Camera camera) {
		xPixel = xTile*TurnBasedDriver.TILESIZE + camera.getX();
		yPixel = yTile*TurnBasedDriver.TILESIZE + camera.getY();
		
		width = TurnBasedDriver.TILESIZE;
		height = TurnBasedDriver.TILESIZE;
	}

	@Override
	public void render(Graphics g, Camera camera) {
		g.drawSprite(sprite, xTile * TurnBasedDriver.TILESIZE, 
						     yTile * TurnBasedDriver.TILESIZE);
	}
	
	public Stats getStats() {
		return stats;
	}
}