/**
 * Class: Character
 * 
 * This class represents any character that can take part in the game
 * includes playable characters, enemies, and NPCs
 */

package com.mystudio.entities;

import java.util.TreeSet;

import org.mini2Dx.core.graphics.Animation;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mystudio.enums.CharacterType;
import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;
import com.mystudio.utils.Camera;
import com.mystudio.utils.Entity;
import com.mystudio.utils.Stats;
import com.mystudio.utils.TileMap;
import com.mystudio.utils.Utils;
import com.mystudio.utils.StatGrowth;
import org.mini2Dx.core.graphics.Sprite; 

public class Character extends Entity{
	
	int level;
	Stats stats;
	StatGrowth growth;
	boolean isAlive = true;
	boolean hasMoved = false;
	boolean hasAttacked = false;
	boolean invisible = false;
	CharacterType type;
	Animation<Sprite> idle, moveUp, moveLeft, moveRight, moveDown, highlighted, current;

	public Character(int x, int y, String texturePath, Stats initialStats, StatGrowth growthChances) {
		super(x, y);
	
		idle = new Animation<Sprite>();
		moveUp = new Animation<Sprite>();
		moveLeft = new Animation<Sprite>();
		moveRight = new Animation<Sprite>();
		moveDown = new Animation<Sprite>();
		highlighted = new Animation<Sprite>();
		current = idle;

		try{
			texture = new Texture(Gdx.files.internal("data/" + texturePath));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
		sprite = new Sprite(texture);
		this.width = texture.getWidth();
		this.height = texture.getHeight();
		
		stats = initialStats;
		growth = growthChances;
		
		// Scales the sprite about the top left corner
		sprite.setOrigin(0, 0);
		sprite.setScale(TurnBasedDriver.TILESIZE / sprite.getWidth(), 
					    TurnBasedDriver.TILESIZE / sprite.getHeight());
		
		current.addFrame(sprite, 1.0f);
	}
	
	public Character(int x, int y, CharacterType type){
		super(x, y);
		
		this.type = type;
		
		idle = new Animation<Sprite>();
		moveUp = new Animation<Sprite>();
		moveLeft = new Animation<Sprite>();
		moveRight = new Animation<Sprite>();
		moveDown = new Animation<Sprite>();
		highlighted = new Animation<Sprite>();
		current = idle;
		
		switch(type){
		case ABERRATION:
			createAberration();
			break;
		case ANDROID:
			createAndroid();
			break;
		case ARCHITECT:
			createArchitect();
			break;
		case BASILISK:
			createBasilisk();
			break;
		case BULWARK:
			createBulwark();
			break;
		case COMMANDER:
			createCommander();
			break;
		case COURIER:
			createCourier();
			break;
		case CYBORG:
			createCyborg();
			break;
		case DRONE:
			createDrone();
			break;
		case ENFORCER:
			createEnforcer();
			break;
		case EXECUTIONER:
			createExecutioner();
			break;
		case FIELD_MEDIC:
			createFieldMedic();
			break;
		case GHOST:
			createGhost();
			break;
		case GUNMAN:
			createGunman();
			break;
		case HARPY:
			createHarpy();
			break;
		case JUGGERNAUT:
			createJuggernaut();
			break;
		case JUNKIE:
			createJunkie();
			break;
		case MIRAGE:
			createMirage();
			break;
		case NEUROMANCER:
			createNeuromancer();
			break;
		case NOVA:
			createNova();
			break;
		case PHANTOM:
			createPhantom();
			break;
		case SCION:
			createScion();
			break;
		case PRODIGY:
			createProdigy();
			break;
		case PURIST:
			createPurist();
			break;
		case RECONSTRUCTOR:
			createReconstructor();
			break;
		case REJECT:
			createReject();
			break;
		case REVENANT:
			createRevenant();
			break;
		case SHARPSHOOPER:
			createSharpshooter();
			break;
		case SNIPER:
			createSniper();
			break;
		case TECHNOBEAST:
			createTechnobeast();
			break;
		case TECHNOHORROR:
			createTechnohorror();
			break;
		case TECHNOMANCER:
			createTechnomancer();
			break;
		default:
			break;
		}
	}
	
	private void createAberration(){
		try{
			texture = new Texture(Gdx.files.internal("data/aberration.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(12, 10, 2, 6, 2, 1, 2, 1, 5, 3, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createAndroid(){
		try{
			texture = new Texture(Gdx.files.internal("data/android.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(15, 8, 1, 9, 2, 4, 0, 8, 3, 4, 0, 2);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createArchitect(){
		try{
			texture = new Texture(Gdx.files.internal("data/architect.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(15, 1, 3, 0, 7, 0, 9, 4, 6, 4, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createBasilisk(){
		try{
			texture = new Texture(Gdx.files.internal("data/basilisk.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(18, 7, 0, 5, 1, 1, 0, 5, 2, 7, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createBulwark(){
		try{
			texture = new Texture(Gdx.files.internal("data/bulwark.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(25, 5, 2, 5, 2, 1, 4, 7, 5, 4, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createCommander(){
		try{
			texture = new Texture(Gdx.files.internal("data/commander.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(27, 12, 8, 9, 7, 9, 8, 7, 7, 6, 0, 2);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createCourier(){
		try{
			texture = new Texture(Gdx.files.internal("data/courier.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(14, 2, 2, 1, 5, 0, 9, 4, 8, 6, 0, 0);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createCyborg(){
		try{
			texture = new Texture(Gdx.files.internal("data/cyborg.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(12, 3, 8, 7, 5, 2, 1, 2, 6, 5, 0, 2);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createDrone(){
		try{
			texture = new Texture(Gdx.files.internal("data/drone.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(5, 9, 1, 7, 7, 1, 0, 6, 4, 7, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createEnforcer(){
		try{
			texture = new Texture(Gdx.files.internal("data/enforcer.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(22, 9, 4, 8, 5, 7, 4, 7, 7, 6, 0, 2);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createExecutioner(){
		try{
			texture = new Texture(Gdx.files.internal("data/executioner.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(22, 15, 4, 12, 10, 10, 4, 6, 4, 6, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createFieldMedic(){
		try{
			texture = new Texture(Gdx.files.internal("data/fieldMedic.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 4, 5, 6, 5, 1, 7, 6, 4, 4, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
		
		TextureRegion tre = new TextureRegion();
		tre.setTexture(texture);
		tre.setRegion(0, 0, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
		TextureRegion[][] tr = Sprite.split(texture, TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
		
		idle.addFrame(Utils.makeSprite(tr[0][0]), 0.5f);
		idle.addFrame(Utils.makeSprite(tr[0][1]), 0.5f);
		idle.addFrame(Utils.makeSprite(tr[0][2]), 0.5f);
		idle.addFrame(Utils.makeSprite(tr[0][1]), 0.5f);
		
		moveDown.addFrame(Utils.makeSprite(tr[1][0]), 0.3f);
		moveDown.addFrame(Utils.makeSprite(tr[1][1]), 0.3f);
		
		moveUp.addFrame(Utils.makeSprite(tr[2][0]), 0.3f);
		moveUp.addFrame(Utils.makeSprite(tr[2][1]), 0.3f);
		
		moveLeft.addFrame(Utils.makeSprite(tr[4][0]), 0.3f);
		moveLeft.addFrame(Utils.makeSprite(tr[4][1]), 0.3f);
		
		moveRight.addFrame(Utils.makeSprite(tr[3][0]), 0.3f);
		moveRight.addFrame(Utils.makeSprite(tr[3][1]), 0.3f);
		
		idle.flip(false, true);
		idle.setLooping(true);
		moveUp.flip(false, true);
		moveUp.setLooping(true);
		moveDown.flip(false, true);
		moveDown.setLooping(true);
		moveLeft.flip(false, true);
		moveLeft.setLooping(true);
		moveRight.flip(false, true);
		moveRight.setLooping(true);
		
		current = idle;
	}
	
	private void createGhost(){
		try{
			texture = new Texture(Gdx.files.internal("data/ghost.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 4, 5, 6, 5, 1, 7, 6, 4, 4, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createGunman(){
		try{
			texture = new Texture(Gdx.files.internal("data/gunman.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(15, 8, 3, 7, 2, 6, 2, 5, 5, 5, 0, 2);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createHarpy(){
		try{
			texture = new Texture(Gdx.files.internal("data/harpy.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 7, 1, 5, 5, 4, 1, 2, 4, 7, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createJuggernaut(){
		try{
			texture = new Texture(Gdx.files.internal("data/juggernaut.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(30, 10, 4, 10, 4, 2, 6, 10, 8, 4, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createJunkie(){
		try{
			texture = new Texture(Gdx.files.internal("data/junkie.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(12, 6, 1, 9, 8, 2, 2, 4, 5, 5, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createMirage(){
		try{
			texture = new Texture(Gdx.files.internal("data/mirage.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 3, 8, 5, 8, 2, 6, 4, 4, 5, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createNeuromancer(){
		try{
			texture = new Texture(Gdx.files.internal("data/neuromancer.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(14, 3, 8, 5, 8, 1, 5, 5, 7, 5, 0, 3);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createNova(){
		try{
			texture = new Texture(Gdx.files.internal("data/nova.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 1, 5, 4, 6, 1, 5, 2, 4, 5, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createPhantom(){
		try{
			texture = new Texture(Gdx.files.internal("data/phantom.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(13, 7, 2, 8, 7, 7, 1, 4, 2, 5, 0, 1);
		growth = new StatGrowth(0.9f, 0.6, 0.1f, 0.5f, 0.3f, 0.3f, 0.2f);
	}
	
	private void createProdigy(){
		try{
			texture = new Texture(Gdx.files.internal("data/prodigy.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(20, 2, 9, 8, 5, 6, 1, 10, 8, 5, 0, 2);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createScion(){
		try{
			texture = new Texture(Gdx.files.internal("data/scion.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(9, 1, 3, 5, 5, 0, 5, 2, 4, 4, 0, 1);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createPurist(){
		try{
			texture = new Texture(Gdx.files.internal("data/purist.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(21, 8, 5, 9, 8, 7, 10, 4, 6, 6, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createReconstructor(){
		try{
			texture = new Texture(Gdx.files.internal("data/reconstructor.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(30, 0, 0, 0, 0, 0, 0, 10, 8, 1, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createReject(){
		try{
			texture = new Texture(Gdx.files.internal("data/reject.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(8, 2, 1, 1, 2, 0, 0, 1, 2, 3, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createRevenant(){
		try{
			texture = new Texture(Gdx.files.internal("data/revenant.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 5, 1, 6, 2, 4, 1, 4, 3, 4, 0, 2);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createSharpshooter(){
		try{
			texture = new Texture(Gdx.files.internal("data/sharpshooter.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(10, 6, 2, 4, 2, 9, 2, 2, 2, 4, 0, 7);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createSniper(){
		try{
			texture = new Texture(Gdx.files.internal("data/sniper.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(16, 10, 2, 8, 4, 12, 4, 4, 4, 4, 0, 9);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createTechnobeast(){
		try{
			texture = new Texture(Gdx.files.internal("data/technobeast.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(12, 8, 1, 5, 5, 2, 2, 5, 2, 7, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createTechnohorror(){
		try{
			texture = new Texture(Gdx.files.internal("data/technohorror.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(45, 20, 4, 8, 2, 1, 1, 6, 4, 3, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}
	
	private void createTechnomancer(){
		try{
			texture = new Texture(Gdx.files.internal("data/technomancer.png"));
		} catch(Exception e){
			texture = new Texture(Gdx.files.internal("data/blankTile.png"));
		}
		sprite = new Sprite(texture);
		this.width = TurnBasedDriver.TILESIZE;
		this.height = TurnBasedDriver.TILESIZE;
		
		stats = new Stats(12, 2, 7, 6, 2, 8, 4, 2, 4, 4, 0, 0);
		growth = new StatGrowth(0.9f, 0.2, 0.2f, 0.1f, 0.6f, 0.1f, 0.2f);
	}

	@Override
	public void update(float delta, Camera camera) {
		xPixel = xTile*TurnBasedDriver.TILESIZE + camera.getX();
		yPixel = yTile*TurnBasedDriver.TILESIZE + camera.getY();
		
		if(stats.getCurrentHealth() <= 0){
			isAlive = false;
		}
		
		current.update(delta);
	}

	@Override
	public void render(Graphics g, Camera camera) {
		if(isAlive){
			if(hasMoved){
				Color c = sprite.getColor();
				float gray = (c.r + c.g + c.b) / 255.0f;
				sprite.setColor(gray, gray, gray, 0.7f);
			}
			current.draw(g, xTile * TurnBasedDriver.TILESIZE, yTile * TurnBasedDriver.TILESIZE);
		}
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public TreeSet<Tile> getTilesInRange(TileMap m){
		TreeSet<Tile> output = new TreeSet<Tile>();
		
		Tile startTile = m.get(xTile, yTile);
		
		for(Tile t : startTile.getPossiblePath(m, stats.getMovement())){
			output.addAll(t.getPossiblePath(m, stats.getMaxRange()));
		}
		
		output.removeAll(startTile.getPossiblePath(m, stats.getMovement()));
		
		return output;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean getHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public boolean getHasAttacked() {
		return hasAttacked;
	}

	public void setHasAttacked(boolean hasAttacked) {
		this.hasAttacked = hasAttacked;
	}

	public boolean getInvisible() {
		return invisible;
	}
}