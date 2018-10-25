package lauchfight.attacks.mage;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class FrozenBoltFactory extends AttackFactory {

	private long COOLDOWN = 2000;
	private long cooldownCounter = 2000;

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

	public FrozenBoltFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new FrozenBolt(pSend);
	}

}
