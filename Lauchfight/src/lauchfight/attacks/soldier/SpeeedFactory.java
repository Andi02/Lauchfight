package lauchfight.attacks.soldier;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class SpeeedFactory extends AttackFactory {

	private long COOLDOWN = 7500;
	private long cooldownCounter = 7500;

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

	public SpeeedFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new Speeed(pSend);
	}

}