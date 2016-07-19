package events;

import org.mini2Dx.core.game.ScreenBasedGame;

import com.mystudio.utils.Camera;

public abstract class Event {
	
	private EventType type;
	
	public Event(EventType type){
		this.type = type;
	}
	
	public abstract void act(ScreenBasedGame sbg, Camera camera);
	
	public EventType getType(){
		return type;
	}
}
