/**
 * Class: Level0
 * 
 * This class is designed as a test level for testing new features in the game
 */

package com.mystudio.levels;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

import com.mystudio.entities.Character;
import com.mystudio.enums.TileType;
import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Level;
import com.mystudio.utils.Stats;
import com.mystudio.utils.StatGrowth;

public class Level0 extends Level{
	
	Character testCharacter, testEnemy;
	
	Stats testCharacterStats, testEnemyStats;

	public Level0(int ID) {
		super(ID, 20, 20);
	}

	@Override
	public void initialise(GameContainer gc) {
		super.initialise(gc);
		
		testCharacterStats = new Stats(15, 8, 3, 7, 2, 6, 2, 5, 1, 6, 0, 2);
		testEnemyStats = new Stats(15, 8, 3, 7, 2, 6, 2, 5, 1, 6, 1, 3);
		
		testCharacter = new Character(6, 6, "test.jpg", testCharacterStats, TurnBasedDriver.DEFAULTGROWTH);
		testEnemy     = new Character(6, 5, "portraitTemplate.png", testEnemyStats, TurnBasedDriver.DEFAULTGROWTH);
		
		for(int i = 0; i < map.getWidth(); i++){
			for(int j = 0; j < map.getHeight(); j++){
				map.set(new Tile(TileType.GRASS), i, j);
				if((i == 3 && j > 2 && j < 7) || (j == 8 && i > 2 && i < 7))
					map.set(new Tile(TileType.BLANK), i, j);
			}
		}
		
		addPlayerCharacter(testCharacter);
		addEnemyCharacter(testEnemy);
	}

	@Override
	public void interpolate(GameContainer gc, float alpha) {
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		super.render(gc, g);
	}

	@Override
	public void update(GameContainer gc, ScreenManager<? extends GameScreen> sm, float delta) {
		super.update(gc, sm, delta);
	}
}