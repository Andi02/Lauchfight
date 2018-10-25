package lauchfight.attacks.mage;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class FireballExplosionFactory extends AttackFactory {

	private int fireballX = 0;
	private int fireballY = 0;

	public void setFireballX(int fireballX) {
		this.fireballX = fireballX;
	}

	public void setFireballY(int fireballY) {
		this.fireballY = fireballY;
	}

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

	public FireballExplosionFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new FireballExplosion(pSend, fireballX, fireballY);
	}

}
