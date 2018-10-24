package lauchfight.attacks;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class TeleportFactory extends AttackFactory {

	private long COOLDOWN = 7000;
	private long cooldownCounter = 7000;

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

	public TeleportFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new Teleport(pSend);
	}

}
