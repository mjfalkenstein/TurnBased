/**
 * Class: Level
 * 
 * An abstract class that handles all background logic for every 
 * playable level in the game. All levels must inherit from this
 * class in order to work properly
 */

package com.mystudio.utils;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.mystudio.entities.Character;
import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;

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
	int mouseX, mouseY;
	int cameraX, cameraY;
	
	Character currentCharacter;
	int currentCharacterIndex = -1;
	
	TileMap map;
	Camera camera;
	
	/**
	 * Constructor
	 * 
	 * @param ID - the unique ID for this level
	 */
	public Level(int ID, int width, int height){
		this.ID = ID;
		this.width = width;
		this.height = height;
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
		
		camera = new Camera(gc, width * TurnBasedDriver.TILESIZE, height * TurnBasedDriver.TILESIZE);
		
		map = new TileMap(width, height);
		
		cameraX = gc.getWidth()/2 - (width * TurnBasedDriver.TILESIZE)/2;
		cameraY = gc.getHeight()/2 - (height * TurnBasedDriver.TILESIZE)/2;
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
		g.translate(-camera.getX(), -camera.getY());
		
		g.setBackgroundColor(Color.GRAY);
		
		map.draw(g);
		
		for(Entity e : worldEntities){
			e.render(g, camera);
		}
		
		map.highlightTile(mouseX - camera.getX(), mouseY - camera.getY(), g);
		if(currentCharacter != null){
			highlightCurrentCharacterMovement();
		}
		
		
		g.translate(camera.getX(), camera.getY());
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
		
		handleMouseInput(gc);
		
		mouseX = Gdx.input.getX();
		mouseY = Gdx.input.getY();
		
		for(Entity e : worldEntities){
			e.update(delta, camera);
			System.out.println(currentCharacter);
		}
		
		if(mouseX <= 10) 				  cameraX += TurnBasedDriver.CAMERA_SPEED;
		if(mouseX >= gc.getWidth() - 10)  cameraX -= TurnBasedDriver.CAMERA_SPEED;
		if(mouseY <= 10) 				  cameraY += TurnBasedDriver.CAMERA_SPEED;
		if(mouseY >= gc.getHeight() - 10) cameraY -= TurnBasedDriver.CAMERA_SPEED;
		
		camera.move(cameraX, cameraY);
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
	}
	
	
	/**
	 * When called during a click, will return the entity that is clicked on
	 * 
	 * Searches for player characters first, then world entities.
	 * 
	 * Return null if no such entity is found
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @return
	 */
	private Object clickedEntity(int mouseX, int mouseY){
		for(Character c : playerCharacters) {
			if(c.mouseoverQ(mouseX, mouseY)) {
				return c;
			}
		}
		for(Entity e : worldEntities) {
			if(e.mouseoverQ(mouseX, mouseY)) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * Function gets the mouse coordinates and if a left click is registered,
	 * it will find the clicked on entity. If it's a player character, it will
	 * set the current character to that.
	 * 
	 * If no entities are clicked on, it will set the current character to
	 * null, effectively deselecting the character.
	 * 
	 * @param gc
	 */
	private void handleMouseInput(GameContainer gc){
		if(Gdx.input.isButtonPressed(0)){
			mouseX = Gdx.input.getX();
			mouseY = Gdx.input.getY();
			Object clickTarget;
			try {
				clickTarget = clickedEntity(mouseX, mouseY);
			}
			catch(Exception e) {
				currentCharacter = null;
				currentCharacterIndex = -1;
				return;
			}
			if(playerCharacters.contains(clickTarget)) {
				currentCharacter = (Character) clickTarget;
				currentCharacterIndex = playerCharacters.indexOf(currentCharacter);
			}
			else {
				currentCharacter = null;
				currentCharacterIndex = -1;
			}
		}
	}

	/**
	 * Loops over the entire tile map and highlights the tiles that 
	 * are within the character's movement range
	 */
	private void highlightCurrentCharacterMovement(){
		for(Tile[] tArray : map.getTiles()) {
			for(Tile t : tArray) {
				if(TileMap.dist(t, 
						map.getTiles()[currentCharacter.getXTile()]
									  [currentCharacter.getYTile()]) 
						<= currentCharacter.getStats().getMovement()) {
					t.highlight();
				}
			}
		}
	}
}
