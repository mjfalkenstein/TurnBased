package com.mystudio.utils;

import java.util.ArrayList;
import java.util.TreeSet;

import org.mini2Dx.core.graphics.Graphics;

import com.mystudio.tiles.Tile;
import com.mystudio.tiles.TileEnum;
import com.mystudio.turnbased.TurnBasedDriver;

public class TileMap {
	
	//ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
	Tile[][] tiles;
	private int width, height;
	
	private ArrayList<TileEnum> groundTiles = new ArrayList<TileEnum>();
	
	public TileMap(int width, int height){
		this.width = width;
		this.height = height;
		
//		for(int i = 0; i < width; i++){
//			tiles.add(new ArrayList<Tile>());
//		}
		
		Tile blankTile = new Tile(TileEnum.BLANK);
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				//tiles.get(i).add(j, blankTile);
				//tiles.get(i).get(j).setCoords(i, j);
				tiles[i][j] = new Tile(blankTile);
				tiles[i][j].setCoords(i, j);
			}
		}
		
		groundTiles.add(TileEnum.GRASS);
		groundTiles.add(TileEnum.DIRT);
		groundTiles.add(TileEnum.GRASSY_MUD);
		groundTiles.add(TileEnum.SAND);
	}
	
	public Tile get(int x, int y){
		x = x < 0 ? 0 : x >= width ? width - 1 : x;
		y = y < 0 ? 0 : y >= height ? height - 1 : y;
		return tiles[x][y];
	}
	
	public void set(Tile tile, int x, int y){
		tiles[x][y] = tile;
		tiles[x][y].setCoords(x, y);
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void draw(Graphics g){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				TileEnum type = tiles[i][j].getType();
				if(groundTiles.contains(type)){
					tiles[i][j].draw(g);
				}
			}
		}
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				TileEnum type = tiles[i][j].getType();
				if(!groundTiles.contains(type)){
					tiles[i][j].draw(g);
				}
			}
		}
	}
	
	public void move(int x, int y){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				tiles[i][j].move(i * TurnBasedDriver.TILESIZE, j * TurnBasedDriver.TILESIZE);
			}
		}
	}
	
	public Tile[][] getTiles(){
		return tiles;
	}
	
	public TreeSet<Tile> getPossiblePath(int x, int y, int distance){
		return tiles[x][y].getPossiblePath(this, distance);
	}
	
	public int minX(){
		return 0;
	}
	
	public int minY(){
		return 0;
	}
	
	public int maxX(){
		return width * TurnBasedDriver.TILESIZE;
	}
	
	public int maxY(){
		return height * TurnBasedDriver.TILESIZE;
	}
}