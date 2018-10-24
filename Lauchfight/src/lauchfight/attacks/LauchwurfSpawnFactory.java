package lauchfight.attacks;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class LauchwurfSpawnFactory extends AttackFactory {

	private long COOLDOWN = 1500;
	private long cooldownCounter = 1500;
	private int count;
	private int lauchfeldX;
	private int lauchfeldY;

	public void setLauchfeldX(int lauchfeldX) {
		this.lauchfeldX = lauchfeldX;
	}

	public void setLauchfeldY(int lauchfeldY) {
		this.lauchfeldY = lauchfeldY;
	}

	public void addCooldown(long a) {
		if (cooldownCounter > 0)
			cooldownCounter += a;
	}

	public boolean cooldownZero() {
		if (cooldownCounter == 0)
			return true;
		return false;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void resetCooldown() {
		cooldownCounter = COOLDOWN;
	}

	public LauchwurfSpawnFactory() {
	}

	@Override
	public Attack create(Player pSend) {
		return new LauchwurfSpawn(pSend, count, lauchfeldX, lauchfeldY);
	}

}
