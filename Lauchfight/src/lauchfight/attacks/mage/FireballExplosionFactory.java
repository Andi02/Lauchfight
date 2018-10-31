package lauchfight.attacks.mage;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;
import lauchfight.attacks.Test;

public class FireballExplosionFactory extends AttackFactory {

	private int fireballX = 0;
	private int fireballY = 0;

	public void setFireballX(int fireballX) {
		this.fireballX = fireballX;
	}

	public void setFireballY(int fireballY) {
		this.fireballY = fireballY;
	}

	private long COOLDOWN = 1;

	@Override
	public Attack createNew(Player p, int mouseX, int mouseY) {
		// restet the cooldown
		this.setCoolDown(COOLDOWN);
		// return a new attack
		return new FireballExplosion(p, mouseX, mouseY);
	}

	@Override
	public void updateCoolDown() {
		if (this.getCoolDown() > 0)
			this.setCoolDown(this.getCoolDown() - 1);
	}

}
