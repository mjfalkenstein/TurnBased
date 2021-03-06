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
import com.mystudio.enums.CharacterType;
import com.mystudio.enums.TileType;
import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Level;
import com.mystudio.utils.Stats;
import com.mystudio.utils.StatGrowth;

public class Level0 extends Level{
	
	Character testCharacter, testEnemy1, testEnemy2, testEnemy3;
	
	Stats testCharacterStats, testEnemyStats;

	public Level0(int ID) {
		super(ID, 20, 20);
	}

	@Override
	public void initialise(GameContainer gc) {
		super.initialise(gc);
		
		testCharacterStats = new Stats(15, 8, 3, 7, 2, 6, 2, 5, 1, 10, 0, 1);
		testEnemyStats = new Stats(15, 8, 3, 7, 2, 6, 2, 5, 1, 6, 1, 3);
		
		testCharacter = new Character(6, 6, CharacterType.FIELD_MEDIC);
		testEnemy1    = new Character(6, 5, "portraitTemplate.png", testEnemyStats, TurnBasedDriver.DEFAULTGROWTH);
		testEnemy2    = new Character(6, 4, "portraitTemplate.png", testEnemyStats, TurnBasedDriver.DEFAULTGROWTH);
		testEnemy3    = new Character(8, 1, "portraitTemplate.png", testEnemyStats, TurnBasedDriver.DEFAULTGROWTH);
		
		for(int i = 0; i < map.getWidth(); i++){
			for(int j = 0; j < map.getHeight(); j++){
				
				if(i < map.getWidth()/2){
					if(j < map.getHeight()/2){
						map.set(new Tile(TileType.GRASS), i, j);
					}else{
						map.set(new Tile(TileType.GRASSY_MUD), i, j);
					}
				}else{
					if(j < map.getHeight()/2){
						map.set(new Tile(TileType.DIRT), i, j);
					}else{
						map.set(new Tile(TileType.SAND), i, j);
					}
				}
				
				if((i == 3 && j > 2 && j < 8) || 
				   (j == 8 && i > 2 && i < 8) ||
				   (i == 8 && j > 2 && j < 8) ||
				   (j == 3 && i > 2 && i < 6))
					map.set(new Tile(TileType.BLANK), i, j);
			}
		}
		
		addPlayerCharacter(testCharacter);
		addEnemyCharacter(testEnemy1);
		addEnemyCharacter(testEnemy2);
		addEnemyCharacter(testEnemy3);
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