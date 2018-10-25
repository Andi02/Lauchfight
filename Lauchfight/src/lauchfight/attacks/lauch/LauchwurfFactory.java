package lauchfight.attacks.lauch;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class LauchwurfFactory extends AttackFactory {

	private long COOLDOWN = 1500;
	private long cooldownCounter = 1500;

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

	public LauchwurfFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new Lauchwurf(pSend);
	}

}
