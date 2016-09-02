/**
 * Class: Level
 * 
 * An abstract class that handles all background logic for every 
 * playable level in the game. All levels must inherit from this
 * class in order to work properly
 */

package com.mystudio.utils;

import java.util.ArrayList;
import java.util.TreeSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.mystudio.entities.Button;
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
	ArrayList<Button> buttons;

	TreeSet<Tile> possibleMoves;
	TreeSet<Tile> pathTiles;
	Path pathHighlight;
	Tile targetTile, oldTargetTile;
	Tile playerTile;

	ArrayList<Tile> tilesInRange;

	int width, height;
	int mouseX, mouseY;
	int cameraX, cameraY;

	Character currentCharacter;
	Character targetCharacter;
	int currentCharacterIndex = -1;

	protected TileMap map;
	Camera camera;

	Button battleConfirmButton;
	Button battleCancelButton;

	boolean inBattle;
	boolean pause = false;
	
	BattlePrediction battlePredictionPlayer;
	BattlePrediction battlePredictionEnemy;

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
		buttons = new ArrayList<Button>();

		camera = new Camera(gc, width * TurnBasedDriver.TILESIZE, height * TurnBasedDriver.TILESIZE);

		map = new TileMap(width, height);
		possibleMoves = new TreeSet<Tile>();
		pathTiles = new TreeSet<Tile>();
		pathHighlight = new Path(pathTiles);

		tilesInRange = new ArrayList<Tile>();

		cameraX = gc.getWidth()/2 - (width * TurnBasedDriver.TILESIZE)/2;
		cameraY = gc.getHeight()/2 - (height * TurnBasedDriver.TILESIZE)/2;

		battleConfirmButton = new Button(0, 0, "battleConfirmButtonSprite.png");
		battleConfirmButton.moveByPixel(gc.getWidth()/2 - TurnBasedDriver.BUTTON_WIDTH/2,
				gc.getHeight()/2 - TurnBasedDriver.BUTTON_HEIGHT/2 - 50);
		battleCancelButton  = new Button(0, 0, "battleCancelButtonSprite.png");
		battleCancelButton.moveByPixel( gc.getWidth()/2 - TurnBasedDriver.BUTTON_WIDTH/2,
				gc.getHeight()/2 - TurnBasedDriver.BUTTON_HEIGHT/2 + 50);

		buttons.add(battleConfirmButton);
		buttons.add(battleCancelButton);

		inBattle = false;
		
		battlePredictionPlayer = new BattlePrediction(null, null, true, true);
		battlePredictionEnemy = new BattlePrediction(null, null, true, true);

		Gdx.input.setInputProcessor(new InputProcessor(){

			@Override
			public boolean keyDown(int keycode) {
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				if(button == Input.Buttons.LEFT){
					mouseX = Gdx.input.getX();
					mouseY = Gdx.input.getY();
					Entity clickTarget;

					if(!pause){
						try {
							clickTarget = clickedEntity(mouseX, mouseY);
						}
						catch(Exception e) {
							currentCharacter = null;
							currentCharacterIndex = -1;
							return false;
						}
						if(playerCharacters.contains(clickTarget)) {
							currentCharacter = (Character) clickTarget;
							currentCharacterIndex = playerCharacters.indexOf(currentCharacter);
						}else if(enemyCharacters.contains(clickTarget)){
							targetCharacter = (Character) clickTarget;
							currentCharacterIndex = enemyCharacters.indexOf(targetCharacter);
							if(currentCharacter != null){
								Tile t = map.get(targetCharacter.getXTile(), targetCharacter.getYTile());
								if(currentCharacter.getTilesInRange(map).contains(t)){
									inBattle = true;
								}
							}
						}else{
							currentCharacter = null;
							targetCharacter = null;
							inBattle = false;
							currentCharacterIndex = -1;
						}
					}else if(inBattle){
						if(battleConfirmButton.mouseoverQ(mouseX, mouseY)){
							Utils.doBattle(currentCharacter, targetCharacter, true, true);
							pause = false;
							targetCharacter = null;
							battlePredictionPlayer.hide();
							battlePredictionEnemy.hide();
							inBattle = false;
							battleConfirmButton.hide();
							battleCancelButton.hide();
						}else if(battleCancelButton.mouseoverQ(mouseX, mouseY)){
							pause = false;
							targetCharacter = null;
							battlePredictionPlayer.hide();
							battlePredictionEnemy.hide();
							inBattle = false;
							battleConfirmButton.hide();
							battleCancelButton.hide();
						}
					}
					return true;
				}
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				return false;
			}

		});
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

		for(Tile t : possibleMoves){
			t.highlight(g, Color.BLUE);
		}

		for(Tile t : tilesInRange){
			t.highlight(g, Color.RED);
		}

		if(!pause) map.highlightTile(mouseX - camera.getX(), mouseY - camera.getY(), g);

		if(pause){
			Color c = Color.BLACK;
			c.a = 0.5f;
			g.setColor(c);
			g.fillRect(-camera.getX(), -camera.getY(), gc.getWidth(), gc.getHeight());
		}

		if(currentCharacter != null){
			currentCharacter.getStats().drawLeft(g, camera);
			if(inBattle){
				battlePredictionPlayer.renderLeft(g, camera);
				battlePredictionEnemy.renderRight(g, camera);
				targetCharacter.getStats().drawRight(g, camera);
				pause = true;
				battleConfirmButton.show();
				battleCancelButton.show();
			}
		}else{
			possibleMoves.clear();
			tilesInRange.clear();
		}
		for(Button b : buttons){
			b.render(g, camera);
		}
		
		for(Tile t : pathTiles){
			t.highlight(g, Color.WHITE);
		}
		
//		pathHighlight.draw(g, playerTile, map);

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

		mouseX = Gdx.input.getX();
		mouseY = Gdx.input.getY();

		if(!pause){
			for(Entity e : worldEntities){
				e.update(delta, camera);
			}

			if(mouseX <= 10) 				  cameraX += TurnBasedDriver.CAMERA_SPEED;
			if(mouseX >= gc.getWidth() - 10)  cameraX -= TurnBasedDriver.CAMERA_SPEED;
			if(mouseY <= 10) 				  cameraY += TurnBasedDriver.CAMERA_SPEED;
			if(mouseY >= gc.getHeight() - 10) cameraY -= TurnBasedDriver.CAMERA_SPEED;

			if(currentCharacter != null){
				tilesInRange = currentCharacter.getTilesInRange(map);
				
				playerTile = map.get(currentCharacter.getXTile(), currentCharacter.getYTile());
				
				possibleMoves = map.getPossiblePath(currentCharacter.getXTile(), currentCharacter.getYTile(), currentCharacter.getStats().getMovement());
				targetTile = map.get((mouseX - camera.getX()) / TurnBasedDriver.TILESIZE, (mouseY - camera.getY()) / TurnBasedDriver.TILESIZE);
				
				if(possibleMoves.contains(targetTile) && oldTargetTile != null && !oldTargetTile.equals(targetTile)){
					
					Tile currentCharacterTile = map.get(currentCharacter.getXTile(), currentCharacter.getYTile());
					
					pathTiles = currentCharacterTile.getPath(map, targetTile, possibleMoves);
					pathHighlight = new Path(pathTiles);
				}
				
				oldTargetTile = targetTile;
			}

			camera.move(cameraX, cameraY);
		}

		battlePredictionPlayer = new BattlePrediction(currentCharacter, targetCharacter, true, true);
		battlePredictionEnemy = new BattlePrediction(targetCharacter, currentCharacter, true, true);
		
		if(inBattle){
			battlePredictionPlayer.show();
			battlePredictionEnemy.show();
		}
		
		Character dead = null;
		
		for(Character c : playerCharacters){
			if(!c.isAlive()){
				dead = c;
			}
		}
		
		if(dead != null){
			playerCharacters.remove(dead);
			worldEntities.remove(dead);
			dead = null;
		}
		
		for(Character c : enemyCharacters){
			if(!c.isAlive()){
				dead = c;
			}
		}
		
		if(dead != null){
			enemyCharacters.remove(dead);
			worldEntities.remove(dead);
			dead = null;
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
	}

	/**
	 * This function adds a new player character to the level
	 * 
	 * @param e - the character to add
	 */
	public void addEnemyCharacter(Character c){
		worldEntities.add(c);
		enemyCharacters.add(c);
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
	private Entity clickedEntity(int mouseX, int mouseY){
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
}
