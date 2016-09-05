package com.mystudio.utils;

import java.util.TreeSet;

import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;

public class Path {

	TreeSet<Tile> path = new TreeSet<Tile>();
	Texture spriteSheet;
	Sprite image;

	public Path(TreeSet<Tile> path){
		this.path = path;

		try{
			spriteSheet = new Texture(Gdx.files.internal("data/pathArrow.png"));
		} catch(Exception e){
			spriteSheet = new Texture(Gdx.files.internal("data/blankTexture.png"));
		}
	}

	public void draw(Graphics g, Tile playerTile, TileMap map){

		TextureRegion tre = new TextureRegion();
		tre.setTexture(spriteSheet);
		tre.setRegion(0, 0, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		TextureRegion[][] tr = Sprite.split(spriteSheet, TurnBasedDriver.SPRITESIZE, TurnBasedDriver.SPRITESIZE);
		image = Utils.makeSprite(tr[0][0]);
		
		for(Tile t : path){
			boolean left = false;
			boolean right = false;
			boolean top = false;
			boolean bot = false;
			
			for(Tile t2 : path){
				if((t2.getX() - t.getX() == -1) && (t2.getY() - t.getY() == 0)){
					left = true;
				}
				if((t2.getX() - t.getX() == 1) && (t2.getY() - t.getY() == 0)){
					right = true;
				}
				if((t2.getX() - t.getX() == 0) && (t2.getY() - t.getY() == -1)){
					top = true;
				}
				if((t2.getX() - t.getX() == 0) && (t2.getY() - t.getY() == 1)){
					bot = true;
				}
			}
			
			if(left && right){
				image = Utils.makeSprite(tr[0][2]);
			}
			if(left && top){
				image = Utils.makeSprite(tr[1][1]);
			}
			if(left && bot){
				image = Utils.makeSprite(tr[0][1]);
			}
			if(left && !bot && ! top && !right){
				image = Utils.makeSprite(tr[2][3]);
			}
			
			if(right && top){
				image = Utils.makeSprite(tr[1][0]);
			}
			if(right && bot){
				image = Utils.makeSprite(tr[0][0]);
			}
			if(right && !bot && !top && !left){
				image = Utils.makeSprite(tr[1][3]);
			}
			
			if(top && bot){
				image = Utils.makeSprite(tr[0][3]);
			}
			if(top && !bot && !left && !right){
				image = Utils.makeSprite(tr[2][2]);
			}
			if(bot && !top && !left && !right){
				image = Utils.makeSprite(tr[1][2]);
			}
			
			if(t.getX() == playerTile.getX() && t.getY() == playerTile.getY()){
				if(left && !bot && ! top && !right){
					image = Utils.makeSprite(tr[2][1]);
				}
				if(right && !bot && ! top && !left){
					image = Utils.makeSprite(tr[2][0]);
				}
				if(top && !bot && !right && !left){
					image = Utils.makeSprite(tr[3][0]);
				}
				if(bot && !top && !right && !left){
					image = Utils.makeSprite(tr[3][1]);
				}
			}
			
			Color c = image.getColor();
			image.setColor(c.r, c.g, c.b, 0.7f);
			
			g.drawSprite(image, t.getX() * TurnBasedDriver.TILESIZE - (TurnBasedDriver.SPRITESIZE - TurnBasedDriver.TILESIZE)/2, 
								t.getY() * TurnBasedDriver.TILESIZE - (TurnBasedDriver.SPRITESIZE - TurnBasedDriver.TILESIZE)/2);
		}
	}
}
