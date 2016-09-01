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
	Tile predecessor;

	float cover, protection, concealment, damage, flammability;
	int movement;
	
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
		movement = 1;
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
		tre.setRegion(0, 0, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);

		idle.addFrame(Utils.makeSprite(tr[spriteX][spriteY]), 1.0f);
	}

	void createBlankTile(){
		movement = 1;
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
		tre.setRegion(0, 0, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);

		idle.addFrame(Utils.makeSprite(tr[spriteX][spriteY]), 1.0f);
	}

	void createGrassTile(){
		movement = 1;
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

		Sprite spr = Utils.makeSprite(tr[spriteX][spriteY]);
		spr.flip(r.nextBoolean(), r.nextBoolean());
		
		idle.addFrame(spr, 1.0f);
	}

	void createGrassyMudTile(){
		movement = 1;
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

		Sprite spr = Utils.makeSprite(tr[spriteX][spriteY]);
		spr.flip(r.nextBoolean(), r.nextBoolean());
		
		idle.addFrame(spr, 1.0f);
	}

	void createDirtTile(){
		movement = 1;
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

		Sprite spr = Utils.makeSprite(tr[spriteX][spriteY]);
		spr.flip(r.nextBoolean(), r.nextBoolean());
		
		idle.addFrame(spr, 1.0f);
	}

	void createSandTile(){
		movement = 1;
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

		Sprite spr = Utils.makeSprite(tr[spriteX][spriteY]);
		spr.flip(r.nextBoolean(), r.nextBoolean());
		
		idle.addFrame(spr, 1.0f);
	}

	void createStoneTile(){
		movement = 1;
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

		Sprite spr = Utils.makeSprite(tr[spriteX][spriteY]);
		spr.flip(r.nextBoolean(), r.nextBoolean());
		
		idle.addFrame(spr, 1.0f);
	}

	public void draw(Graphics g, TileMap m){
		idle.draw(g, x * TurnBasedDriver.TILESIZE - (idle.getCurrentFrame().getWidth() - TurnBasedDriver.TILESIZE) * 0.5f, 
				y * TurnBasedDriver.TILESIZE - (idle.getCurrentFrame().getHeight() - TurnBasedDriver.TILESIZE) * 0.5f);
		//Tile destination = m.get(9, 8);
		//g.drawString("" + this.hueristic(destination), x * TurnBasedDriver.TILESIZE - (idle.getCurrentFrame().getWidth() - TurnBasedDriver.TILESIZE) * 0.5f + TurnBasedDriver.TILESIZE * 0.5f, y * TurnBasedDriver.TILESIZE - (idle.getCurrentFrame().getHeight() - TurnBasedDriver.TILESIZE) * 0.5f + TurnBasedDriver.TILESIZE * 0.5f);
		//g.drawString("" + shift, x * TurnBasedDriver.TILESIZE - (idle.getCurrentFrame().getWidth() - TurnBasedDriver.TILESIZE) * 0.5f + TurnBasedDriver.TILESIZE * 0.5f, y * TurnBasedDriver.TILESIZE - (idle.getCurrentFrame().getHeight() - TurnBasedDriver.TILESIZE) * 0.5f + TurnBasedDriver.TILESIZE * 0.5f);
	}

	public void highlight(Graphics g, Color c){
		c.a = 0.5f;
		g.setColor(c);
		g.fillRect(x * TurnBasedDriver.TILESIZE, y * TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
		c.a = 1.0f;
		g.setColor(c);
		highlight = false;
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
		clear();
		TreeSet<Tile> output = new TreeSet<Tile>();
		if(pathable && (shift <= distance)){
			shift = distance;
			output.add(this);
			output.addAll(map.get(x + 1, y).getPossiblePath(map, distance - this.movement));
			output.addAll(map.get(x - 1, y).getPossiblePath(map, distance - this.movement));
			output.addAll(map.get(x, y + 1).getPossiblePath(map, distance - this.movement));
			output.addAll(map.get(x, y - 1).getPossiblePath(map, distance - this.movement));
		}
		return output;
	}

	public TreeSet<Tile> getPath(TileMap map, Tile destination, TreeSet<Tile> possible){
		TreeSet<Tile> frontier = new TreeSet<Tile>();

		frontier.add(this);
		
		for(Tile t : possible){
			t.clear();
		}

		shift = 999999;

		getPathRecur(map, frontier, destination, 1, possible);
		
		return getBackTrace(map, destination, this);
	}
	
	static private TreeSet<Tile> getBackTrace(TileMap map, Tile destination, Tile origin){
		TreeSet<Tile> output = new TreeSet<Tile>();
		
		Tile current = destination;
		
		while(current.predecessor != null && current.predecessor != origin){
			output.add(current);
			current = current.predecessor;
		}
		
		output.add(origin);
		output.add(current);
		return output;
	}

	static private TreeSet<Tile> getPathRecur(TileMap map, TreeSet<Tile> frontier, Tile destination, int distance, TreeSet<Tile> possible){

		TreeSet<Tile> output = new TreeSet<Tile>();

		Tile chosen = null;
		double minDistance = Double.MAX_VALUE;

		for(Tile t : frontier){
			if(t.hueristic(destination) < minDistance){
				minDistance = t.hueristic(destination);
				chosen = t;
			}
		}

		frontier.remove(chosen);
		output.add(chosen);

		Tile lf = map.getWithNull(chosen.x - 1, chosen.y);
		Tile rt = map.getWithNull(chosen.x + 1, chosen.y);
		Tile up = map.getWithNull(chosen.x, chosen.y - 1);
		Tile dn = map.getWithNull(chosen.x, chosen.y + 1);

		if(up != null && up.shift == 0 && possible.contains(up)){
			up.shift = distance;
			up.predecessor = chosen;
			frontier.add(up);
		}
		if(dn != null && dn.shift == 0 && possible.contains(dn)){
			dn.shift = distance;
			dn.predecessor = chosen;
			frontier.add(dn);
		}
		if(lf != null && lf.shift == 0 && possible.contains(lf)){
			lf.shift = distance;
			lf.predecessor = chosen;
			frontier.add(lf);
		}
		if(rt != null && rt.shift == 0 && possible.contains(rt)){
			rt.shift = distance;
			rt.predecessor = chosen;
			frontier.add(rt);
		}

		if(chosen.equals(destination)){
			output.add(destination);
			return output;
		}else{
			output.addAll(getPathRecur(map, frontier, destination, distance+1, possible));
		}

		return output;
	}


	public double getDistance(Tile tile){
		return Math.sqrt((tile.x - x) * (tile.x - x) + (tile.y - y) * (tile.y - y));
	}

	public double hueristic(Tile tile){   
		int dx = tile.getX() - x;
		int dy = tile.getY() - y;
		return shift + Math.sqrt((dx*dx)+(dy*dy));
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
