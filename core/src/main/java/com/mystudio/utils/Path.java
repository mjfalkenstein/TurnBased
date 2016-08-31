package com.mystudio.utils;

import java.util.TreeSet;

import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.Sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
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

		image = new Sprite(spriteSheet);
		Sprite[][] sprite = (Sprite[][]) image.split(TurnBasedDriver.TILESIZE, TurnBasedDriver.TILESIZE);
		image = sprite[0][3];
		
		int counter = 0;

		for(Tile t : path){
			g.drawString(""+counter, t.getX(), t.getY());
			counter++;
			
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
				image = sprite[2][0];
			}
			if(left && top){
				image = sprite[1][1];
			}
			if(left && bot){
				image = sprite[1][0];
			}
			if(left && !bot && ! top && !right){
				image = sprite[3][2];
			}
			
			if(right && top){
				image = sprite[0][1];
			}
			if(right && bot){
				image = sprite[0][0];
			}
			if(right && !bot && !top && !left){
				image = sprite[3][1];
			}
			
			if(top && bot){
				image = sprite[3][0];
			}
			if(top && !bot && !left && !right){
				image = sprite[2][2];
			}
			if(bot && !top && !left && !right){
				image = sprite[2][1];
			}
			
			if(t.getX() == playerTile.getX() && t.getY() == playerTile.getY()){
				if(left && !bot && ! top && !right){
					image = sprite[1][2];
				}
				if(right && !bot && ! top && !left){
					image = sprite[0][2];
				}
				if(top && !bot && !right && !left){
					image = sprite[0][3];
				}
				if(bot && !top && !right && !left){
					image = sprite[1][3];
				}
			}

			g.setColor(Color.WHITE);
			g.drawSprite(image, t.getX() * TurnBasedDriver.TILESIZE, t.getY() * TurnBasedDriver.TILESIZE);
		}
	}
}
