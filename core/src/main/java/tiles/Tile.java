package tiles;

import java.util.Random;
import java.util.TreeSet;

import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class Tile implements Comparable<Tile>{

	//SpriteSheet sprite;
	Texture spriteSheet;
	int tileSize, spriteSize;
	int currentX, currentY, x, y;
	TileEnum type;
	boolean pathable;
	//Image image;'
	Sprite sprite;
	int shift = 0;

	float movement, cover, protection, concealment, damage, flammability;

	public Tile(TileEnum type, int tileSize, int spriteSize){
		this.type = type;

		this.tileSize = tileSize;
		this.spriteSize = spriteSize;

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
		currentX = 0;
		currentY = 0;
		pathable = true;

//		try {
//			sprite = new SpriteSheet("Resources/testTile.png" , spriteSize, spriteSize);
//		} catch (SlickException e) {
//			e.printStackTrace();
//		}
//		image = sprite.getSprite(currentX, currentY);
		
		try{
			spriteSheet = new Texture(Gdx.files.internal("data/testTile.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	void createBlankTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		currentX = 0;
		currentY = 0;
		pathable = false;
		
		try{
			spriteSheet = new Texture(Gdx.files.internal("data/blankTile.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	void createGrassTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		currentX = r.nextInt(3);
		currentY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/grass.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	void createGrassyMudTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		currentX = r.nextInt(3);
		currentY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/grassyMud.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	void createDirtTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		currentX = r.nextInt(3);
		currentY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/dirt.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	void createSandTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		currentX = r.nextInt(3);
		currentY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/sand.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	void createStoneTile(){
		movement = 1.0f;
		cover = 0.0f;
		protection = 0.0f;
		concealment = 0.0f;
		damage = 0.0f;
		flammability = 0.0f;
		Random r = new Random();
		currentX = r.nextInt(3);
		currentY = 0;
		pathable = true;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/stoneFloor.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(spriteSheet);
	}

	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.drawSprite(sprite, x * tileSize, y * tileSize);
	}

	public void highlight(Graphics g){
		Color c = Color.WHITE;
		c.a = 0.25f;
		g.setColor(c);
		g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
		c.a = 1.0f;
		g.setColor(c);
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
		if(pathable && (shift < distance)){
			shift = distance;
			output.add(this);
			output.addAll(map.get(x + 1, y).getPossiblePath(map, distance - 1));
			output.addAll(map.get(x - 1, y).getPossiblePath(map, distance - 1));
			output.addAll(map.get(x, y + 1).getPossiblePath(map, distance - 1));
			output.addAll(map.get(x, y - 1).getPossiblePath(map, distance - 1));
		}
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
}
