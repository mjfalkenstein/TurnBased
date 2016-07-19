package events;

import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.screen.transition.FadeInTransition;
import org.mini2Dx.core.screen.transition.FadeOutTransition;

import com.mystudio.utils.Camera;

public class StateSwitchEvent extends Event {
	
	int newState;

	public StateSwitchEvent(int newState) {
		super(EventType.STATE_SWITCH);
		this.newState = newState;
	}

	@Override
	public void act(ScreenBasedGame sbg, Camera camera) {
		sbg.enterGameScreen(newState, new FadeOutTransition(), new FadeInTransition());
	}
}