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
import com.mystudio.utils.Level;
import com.mystudio.utils.Stats;
import com.mystudio.utils.StatGrowth;

public class Level0 extends Level{
	
	Character testCharacter;

	public Level0(int ID, int width, int height) {
		super(ID, width, height);
	}

	@Override
	public void initialise(GameContainer gc) {
		super.initialise(gc);
		
		Stats defaultStats = new Stats();
		StatGrowth defaultGrowth = new StatGrowth();
		
		testCharacter = new Character(6, 6, "test.jpg", defaultStats, 
									  defaultGrowth);
		
		addPlayerCharacter(testCharacter);
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