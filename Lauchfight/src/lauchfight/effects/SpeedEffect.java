package lauchfight.effects;

import lauchfight.Effect;
import lauchfight.Player;

public class SpeedEffect extends Effect{
	
	int timer = 1000;

	@Override
	public void useEffectOn(Player pToUseOn) {
		
		if(timer >= 0) {
			pToUseOn.setSpeed(2f);
			timer--;
		}else {
			this.setActive(false);
			pToUseOn.setSpeed(0.2f);
		}
		
		
	}

}
