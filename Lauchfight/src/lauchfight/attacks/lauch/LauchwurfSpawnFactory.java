package lauchfight.attacks.lauch;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class LauchwurfSpawnFactory extends AttackFactory {

	private long COOLDOWN = 1500;
	private int count;
	private int lauchfeldX;
	private int lauchfeldY;

	public void setLauchfeldX(int lauchfeldX) {
		this.lauchfeldX = lauchfeldX;
	}

	public void setLauchfeldY(int lauchfeldY) {
		this.lauchfeldY = lauchfeldY;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LauchwurfSpawnFactory() {
	}

	@Override
	public Attack createNew(Player p, int mouseX, int mouseY) {
		// restet the cooldown
		this.setCoolDown(COOLDOWN);
		// return a new attack
		return new Lauchwurf(p, mouseX, mouseY);
	}

	@Override
	public void updateCoolDown() {
		if (this.getCoolDown() > 0)
			this.setCoolDown(this.getCoolDown() - 1);
	}

}
