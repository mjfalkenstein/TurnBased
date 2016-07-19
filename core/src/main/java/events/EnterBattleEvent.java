package events;

import org.mini2Dx.core.game.ScreenBasedGame;

import com.mystudio.utils.Camera;
import com.mystudio.utils.Region;

import tiles.TileMap;

public class EnterBattleEvent extends Event{
	boolean active;
	Region region;
	TileMap map;

	public EnterBattleEvent(TileMap map){
		super(EventType.BATTLE);
		this.map = map;
		active = true;
	}

	public void act(ScreenBasedGame sbg, Camera camera) {
		if(active){
			active = false;
			camera.disable();
		}
		if(!active){
			camera.enable();
		}
	}
}