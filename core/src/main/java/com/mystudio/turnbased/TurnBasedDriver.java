/**
 * Class: TurnBasedDriver
 * 
 * This class initializes everything that the game needs to run
 * including the levels and screens
 */

package com.mystudio.turnbased;

import org.mini2Dx.core.game.ScreenBasedGame;

import com.mystudio.levels.Level0;

public class TurnBasedDriver extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "com.mystudio.turnbased";
	public static final int TILESIZE     = 50;
	public static final int SPRITESIZE   = 60;
	public static       int CAMERA_SPEED = 10;
	
	Level0 level0 = new Level0(		-1, 10, 10);

	@Override
	public void initialise() {
		
		this.addScreen(level0);
	}

	@Override
	public int getInitialScreenId() {
		return level0.getId();
	}
}