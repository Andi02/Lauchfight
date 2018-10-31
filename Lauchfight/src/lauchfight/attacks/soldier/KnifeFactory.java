package lauchfight.attacks.soldier;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;
import lauchfight.attacks.Test;

public class KnifeFactory extends AttackFactory {

	private long COOLDOWN = 5000;

	public KnifeFactory() {
	}

	@Override
	public Attack createNew(Player p, int mouseX, int mouseY) {
		// restet the cooldown
		this.setCoolDown(COOLDOWN);
		// return a new attack
		return new Knife(p, mouseX, mouseY);
	}

	@Override
	public void updateCoolDown() {
		if (this.getCoolDown() > 0)
			this.setCoolDown(this.getCoolDown() - 1);
	}

}
