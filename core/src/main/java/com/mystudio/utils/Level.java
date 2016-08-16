/**
 * Class: Level
 * 
 * An abstract class that handles all background logic for every 
 * playable level in the game. All levels must inherit from this
 * class in order to work properly
 */

package com.mystudio.utils;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.mystudio.entities.Character;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

public abstract class Level extends BasicGameScreen{

	public int ID;
	GameContainer gc;
	ArrayList<Entity> worldEntities;
	ArrayList<Character> playerCharacters;
	ArrayList<Character> enemyCharacters;
	
	int width, height;
	
	Character currentCharacter;
	int currentCharacterIndex = -1;
	
	/**
	 * Constructor
	 * 
	 * @param ID - the unique ID for this level
	 */
	public Level(int ID, int width, int height){
		this.ID = ID;
	}

	/**
	 * Returns the unique ID for this level
	 */
	@Override
	public int getId() {
		return ID;
	}

	/**
	 * This function is called once at the beginning of the game, used to initialise
	 * necessary variables and such
	 * 
	 * @param gc - the game container for this level
	 */
	@Override
	public void initialise(GameContainer gc) {
		this.gc = gc;

		worldEntities = new ArrayList<Entity>();
		playerCharacters = new ArrayList<Character>();
		enemyCharacters = new ArrayList<Character>();
	}

	/**
	 * This function is called to update rendering coordinates and such for everything on the screen
	 * 
	 * @param gc - the game container for this level
	 * @param alpha - how "complete" the current update step is, between 0.0f and 1.0f
	 */
	@Override
	public void interpolate(GameContainer gc, float alpha) {
		
	}

	/**
	 * Renders everything in the world to the screen, draw things on the "bottom" first
	 * 
	 * @param gc - the game container for this level
	 * @param g - the graphics object that we're rendering to
	 */
	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, gc.getWidth(), gc.getHeight());
		
		for(Entity e : worldEntities){
			e.render(g);
		}
	}

	/**
	 * This function, called once every 10th of a second, updates properties about stuff in the world
	 * 
	 * @param gc - the game container for this level
	 * @param sm - the screen manager, updates and renders the game screen
	 * @param delta - the time passed since the last update
	 */
	@Override
	public void update(GameContainer gc, ScreenManager<? extends GameScreen> sm, float delta) {
		for(Entity e : worldEntities){
			e.update(delta);
		}
	}
	
	/**
	 * This function adds a generic entity to the world
	 * 
	 * @param e - the entity to add
	 */
	public void addEntity(Entity e){
		worldEntities.add(e);
	}
	
	/**
	 * This function adds a new player character to the level
	 * 
	 * @param e - the character to add
	 */
	public void addPlayerCharacter(Character c){
		worldEntities.add(c);
		playerCharacters.add(c);
		currentCharacter = c;
		currentCharacterIndex++;
	}
}