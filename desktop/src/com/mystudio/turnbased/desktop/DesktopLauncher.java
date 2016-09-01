/**
 * Class: Desktop Launcher 
 * 
 * This class sets up the window and the relevant settings
 */

package com.mystudio.turnbased.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.mini2Dx.desktop.DesktopMini2DxConfig;

import com.badlogic.gdx.backends.lwjgl.DesktopMini2DxGame;
import com.badlogic.gdx.graphics.Color;
import com.mystudio.turnbased.TurnBasedDriver;

public class DesktopLauncher {
	public static void main (String[] arg) {
		DesktopMini2DxConfig config = new DesktopMini2DxConfig(TurnBasedDriver.GAME_IDENTIFIER);
		
		//setting relevant stuff, like target fps and window properties
		config.foregroundFPS = 60;
		config.backgroundFPS = 0;
		config.resizable = false;
		config.fullscreen = false;
		config.vSyncEnabled = true;
		config.title = "Turn Based Game";
		config.initialBackgroundColor = Color.GRAY;
		
		//setting the window resolution to that of the monitor
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		config.width = d.width;
		config.height = d.height;

		//opening the window
		new DesktopMini2DxGame(new TurnBasedDriver(), config);
	}
}
