/**
 * Class: TurnBasedDriver
 * 
 * This class initializes everything that the game needs to run
 * including the levels and screens
 */

package com.mystudio.turnbased;

import org.mini2Dx.core.game.ScreenBasedGame;

import com.mystudio.levels.Level0;
import com.mystudio.utils.StatGrowth;
import com.mystudio.utils.Stats;

public class TurnBasedDriver extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "com.mystudio.turnbased";
	public static final int TILESIZE       = 50;
	public static final int SPRITESIZE     = 60;
	public static final int BUTTON_WIDTH   = 100;
	public static final int BUTTON_HEIGHT  = 40;
	public static       int CAMERA_SPEED   = 10;
	public static     Stats DEFAULTSTATS   = new Stats();
	public static StatGrowth DEFAULTGROWTH = new StatGrowth();
	
	Level0 level0 = new Level0(		-1);

	@Override
	public void initialise() {
		
		this.addScreen(level0);
	}

	@Override
	public int getInitialScreenId() {
		return level0.getId();
	}
}