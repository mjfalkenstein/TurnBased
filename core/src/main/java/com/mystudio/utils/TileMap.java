package com.mystudio.utils;

import java.util.ArrayList;
import java.util.TreeSet;
import java.lang.Math;

import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.graphics.Color;
import com.mystudio.enums.TileType;
import com.mystudio.tiles.Tile;
import com.mystudio.turnbased.TurnBasedDriver;

public class TileMap {
	
	Tile[][] tiles;
	private int width, height;
	
	private ArrayList<TileType> groundTiles = new ArrayList<TileType>();
	
	public TileMap(int width, int height){
		this.width = width;
		this.height = height;
		
		tiles = new Tile[width][height];
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				tiles[i][j] = new Tile(TileType.TEST);
				tiles[i][j].setCoords(i, j);
			}
		}
		
		groundTiles.add(TileType.GRASS);
		groundTiles.add(TileType.DIRT);
		groundTiles.add(TileType.GRASSY_MUD);
		groundTiles.add(TileType.SAND);
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
				tiles[i][j].draw(g, this);
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
	
	public void highlightTile(int x, int y, Graphics g){
		Tile tile = get(x / TurnBasedDriver.TILESIZE, y / TurnBasedDriver.TILESIZE);
		tile.highlight(g, Color.WHITE);
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
	
	/**
	 * Finds the distance (L1 norm) between two tiles
	 * 
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static int dist(Tile t1, Tile t2) {
		return Math.abs(t1.getX() - t2.getX()) + 
			   Math.abs(t1.getY() - t2.getY());
	}

	public Tile getWithNull(int x, int y){
		if(x < 0 || x >= width || y < 0 || y >= height){
			return null;
		}
		return tiles[x][y];
	}
}