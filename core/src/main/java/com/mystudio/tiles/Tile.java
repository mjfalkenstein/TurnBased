package com.mystudio.tiles;

import java.util.Random;
import java.util.TreeSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.Graphics; 
import org.mini2Dx.core.graphics.Sprite; 
import com.badlogic.gdx.graphics.g2d.TextureRegion; 
import com.mystudio.enums.TileType;
import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.TileMap;
import com.mystudio.utils.Utils;

public class Tile implements Comparable<Tile>{

	Texture spriteSheet;
	int tileSize, spriteSize;
	int spriteX, spriteY, x, y;
	TileType type;
	boolean pathable;
	int shift = 0;
	boolean highlight = false;
	Animation<Sprite> idle;
	
	float movement, cover, protection, concealment, damage, flammability;

	public Tile(TileType type){
		this.type = type;

		idle = new Animation<Sprite>();

		switch(type){
		case TEST:
			createTestTile();
			break;
		case BLANK:
			createBlankTile();
			break;
		case GRASS:
			createGrassTile();
			break;
		case DIRT:
			createDirtTile();
			break;
		case STONE_FLOOR:
			createStoneTile();
			break;
		case GRASSY_MUD:
			createGrassyMudTile();
			break;
			//		case ACID:
			//			break;
			//		case ASH:
			//			break;
			//		case BRUSH:
			//			break;
			//		case CARPET:
			//			break;
			//		case CERAMIC_OBJECT_L:
			//			break;
			//		case CERAMIC_OBJECT_M:
			//			break;
			//		case CERAMIC_OBJECT_S:
			//			break;
			//		case DOOR:
			//			break;
			//		case FOG:
			//			break;
			//		case ICE:
			//			break;
			//		case LAVA:
			//			break;
			//		case METAL_OBJECT_L:
			//			break;
			//		case METAL_OBJECT_M:
			//			break;
			//		case METAL_OBJECT_S:
			//			break;
			//		case MIASMA:
			//			break;
			//		case MUD:
			//			break;
			//		case PAVED_FLOOR:
			//			break;
			//		case PERMAFROST:
			//			break;
			//		case ROOTS:
			//			break;
		case SAND:
			createSandTile();
			break;
			//		case SAPLING:
			//			break;
			//		case SMOKE:
			//			break;
			//		case SNOW:
			//			break;
			//		case STEAM:
			//			break;
			//		case STONE_OBJECT_L:
			//			break;
			//		case STONE_OBJECT_M:
			//			break;
			//		case STONE_OBJECT_S:
			//			break;
			//		case SWAMP:
			//			break;
			//		case TALL_GRASS:
			//			break;
			//		case TREE:
			//			break;
			//		case TUNDRA:
			//			break;
			//		case WATER:
			//			break;
			//		case WOOD_FLOOR:
			//			break;
			//		case WOOD_OBJECT_L:
			//			break;
			//		case WOOD_OBJECT_M:
			//			break;
			//		case WOOD_OBJECT_S:
			//			break;
		default:
			break;
		}
	}

	public Tile(Tile newTile) {
		this(newTile.type);
	}

	public void setCoords(int x, int y){
		this.x = x;
		this.y = y;
	}

	void createTestTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		spriteX = 0;
		spriteY = 0;
		pathable = true;
		
		try{
			spriteSheet = new Texture(Gdx.files.internal("data/testTile.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	void createBlankTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		spriteX = 0;
		spriteY = 0;
		pathable = false;
		
		try{
			spriteSheet = new Texture(Gdx.files.internal("data/blankTile.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	void createGrassTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		spriteX = 0;
		spriteY = r.nextInt(3);
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/grass.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	void createGrassyMudTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		spriteX = r.nextInt(3);
		spriteY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/grassyMud.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	void createDirtTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		spriteX = r.nextInt(3);
		spriteY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/dirt.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	void createSandTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		spriteX = r.nextInt(3);
		spriteY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/sand.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	void createStoneTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		spriteX = r.nextInt(3);
		spriteY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/stoneFloor.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		
		idle.addFrame(Utils.make(tr[spriteX][spriteY]), 1.0f);
	}

	public void draw(Graphics g){
		idle.draw(g, x * TurnBasedDriver.TILESIZE - TurnBasedDriver.TILESIZE * 0.1f, 
				     y * TurnBasedDriver.TILESIZE - TurnBasedDriver.TILESIZE * 0.1f);
		
		if(highlight){
			Color c = Color.WHITE;
			c.a = 0.5f;
			g.setColor(c);
			g.fillRect(x * TurnBasedDriver.TILESIZE, y * TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
			c.a = 1.0f;
			g.setColor(c);
			highlight = false;
		}
	}

	public void highlight(){
		highlight = true;
	}

	public void setSprite(Texture newSprite){
		spriteSheet = newSprite;
	}

	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}

	public boolean pathable(){
		return pathable;
	}

	public void clear(){
		shift = 0;
	}

	public TreeSet<Tile> getPossiblePath(TileMap map, int distance){
		TreeSet<Tile> output = new TreeSet<Tile>();
		if(pathable && (shift <= distance)){
			shift = distance;
			output.add(this);
			output.addAll(map.get(x + 1, y).getPossiblePath(map, distance - 1));
			output.addAll(map.get(x - 1, y).getPossiblePath(map, distance - 1));
			output.addAll(map.get(x, y + 1).getPossiblePath(map, distance - 1));
			output.addAll(map.get(x, y - 1).getPossiblePath(map, distance - 1));
		}
		shift = 0;
		return output;
	}

	public TreeSet<Tile> getPath(TileMap map, Tile destination, TreeSet<Tile> possible){
		TreeSet<Tile> output = new TreeSet<Tile>();
		output.add(this);

		Tile current = this;

		while(current.x != destination.x || current.y != destination.y){
			if(current.x < destination.x){
				current = map.get(current.x + 1, current.y);
			}else if(current.x > destination.x){
				current = map.get(current.x - 1, current.y);
			}
			if(possible.contains(current)){
				output.add(current);
			}
			if(current.y < destination.y){
				current = map.get(current.x, current.y + 1);
			}else if(current.y > destination.y){
				current = map.get(current.x, current.y - 1);
			}
			if(possible.contains(current)){
				output.add(current);
			}
		}
		return output;
	}

	public double getDistance(Tile tile){
		return Math.sqrt((tile.x - x) * (tile.x - x) + (tile.y - y) * (tile.y - y));
	}

	@Override
	public int compareTo(Tile arg0) {
		Tile tile = (Tile) arg0;
		int out = x - tile.x + 10000 * (y - tile.y);
		return out;
	}

	@Override
	public boolean equals(Object arg0){
		return compareTo((Tile) arg0) == 0;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public TileType getType(){
		return type;
	}
}
