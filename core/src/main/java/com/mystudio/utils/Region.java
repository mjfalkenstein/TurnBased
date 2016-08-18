package com.mystudio.utils;


import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.graphics.Color;
import com.mystudio.events.Event;

public class Region extends Entity {
	
	int tileSize;
	Color color;
	Rectangle highlight;
	Event event;
	
	public Region(int x, int y, float width, float height, int tileSize, Color color) {
		super(x, y, "");
		
		this.color = color;
		this.tileSize = tileSize;
		
		highlight = new Rectangle(x * tileSize, y * tileSize, width * tileSize, height * tileSize);
	}
	
	public Region(int x, int y, float width, float height, int tileSize, Color color, Event event) {
		super(x, y, "");
		
		this.color = color;
		this.tileSize = tileSize;
		this.event = event;
		
		highlight = new Rectangle(x * tileSize, y * tileSize, width * tileSize, height * tileSize);
	}

	public void update(GameContainer gc, int delta, TileMap map) {
		//shouldn't need to do anything?
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.drawShape(highlight);
		Color c = new Color(color.r, color.g, color.b, 0.2f);
		g.setColor(c);
		g.drawShape(highlight);
	}
	
	public void doEvent(ScreenBasedGame sbg, Camera camera){
		if(event != null)
			event.act(sbg, camera);
	}
	
	public boolean contains(Entity e){
		return highlight.contains(e.getXTile() + tileSize/2, e.getYTile() + tileSize/2);
	}
	
	public Event getEvent(){
		if(event != null){
			return event;
		}
		return null;
	}

	@Override
	public void update(float delta, Camera camera) {
		// TODO Auto-generated method stub
		
	}

}
