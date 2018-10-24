package lauchfight.attacks;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class LauchfeldFactory extends AttackFactory {

	private long COOLDOWN = 15000;
	private long cooldownCounter = 15000;

	public void addCooldown(long a) {
		if (cooldownCounter > 0)
			cooldownCounter += a;
	}

	public boolean cooldownZero() {
		if (cooldownCounter == 0)
			return true;
		return false;
	}

	@Override
	public void resetCooldown() {
		cooldownCounter = COOLDOWN;
	}

	public LauchfeldFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new Lauchfeld(pSend);
	}

}
