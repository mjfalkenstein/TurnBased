/**
 * Class: Character
 * 
 * This class represents any character that can take part in the game
 * includes playable characters, enemies, and NPCs
 */

package com.mystudio.entities;

import java.util.ArrayList;

import org.mini2Dx.core.graphics.Graphics;

import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Camera;
import com.mystudio.utils.Entity;
import com.mystudio.utils.Stats;
import com.mystudio.utils.TileMap;
import com.mystudio.utils.StatGrowth;

public class Character extends Entity{
	
	int level;
	Stats stats;
	StatGrowth growth;
	boolean isAlive = true;
	boolean hasMoved = false;
	boolean hasAttacked = false;

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
		
		if(stats.getCurrentHealth() <= 0){
			isAlive = false;
		}
	}

	@Override
	public void render(Graphics g, Camera camera) {
		if(isAlive){
			g.drawSprite(sprite, xTile * TurnBasedDriver.TILESIZE, 
								 yTile * TurnBasedDriver.TILESIZE);
		}
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public ArrayList<Tile> getTilesInRange(TileMap m){
		ArrayList<Tile> output = new ArrayList<Tile>();
		
		Tile startTile = m.get(xTile, yTile);
		output.addAll(startTile.getPossiblePath(m, stats.getMaxRange()));
		output.removeAll(startTile.getPossiblePath(m, stats.getMinRange()));
		
		return output;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean getHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public boolean getHasAttacked() {
		return hasAttacked;
	}

	public void setHasAttacked(boolean hasAttacked) {
		this.hasAttacked = hasAttacked;
	}
}