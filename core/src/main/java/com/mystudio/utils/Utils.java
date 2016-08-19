package com.mystudio.utils;

import org.mini2Dx.core.graphics.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Utils {
	
	public static Sprite make(TextureRegion tr){
		return new Sprite(tr.getTexture(), tr.getRegionX(), tr.getRegionY(), tr.getRegionWidth(), tr.getRegionHeight());
	}
	
	 public static Sprite make(TextureRegion tr, int i) { 
		 return new Sprite(tr.getTexture(),tr.getRegionX(), i-tr.getRegionY(),tr.getRegionWidth(),tr.getRegionHeight()); 
	 }
}