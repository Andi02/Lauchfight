package lauchfight.attacks.trickster;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;
import lauchfight.attacks.Test;

public class RandomTeleportFactory extends AttackFactory {

	private long COOLDOWN = 7000;
	private long cooldownCounter = 7000;

	public RandomTeleportFactory() {
	}

	@Override
	public Attack createNew(Player p, int mouseX, int mouseY) {
		// restet the cooldown
		this.setCoolDown(COOLDOWN);
		// return a new attack
		return new RandomTeleport(p, mouseX, mouseY);
	}

	@Override
	public void updateCoolDown() {
		if (this.getCoolDown() > 0)
			this.setCoolDown(this.getCoolDown() - 1);
	}

}
