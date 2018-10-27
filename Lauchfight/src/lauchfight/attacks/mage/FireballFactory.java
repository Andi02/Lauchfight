package lauchfight.attacks.mage;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;
import lauchfight.attacks.Test;

public class FireballFactory extends AttackFactory {

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

	public FireballFactory() {
	}

	@Override
    public Attack createNew(Player p, int mouseX, int mouseY) {
        //restet the cooldown
        this.setCoolDown(COOLDOWN);
        //return a new attack
        return new Fireball(p,mouseX,mouseY);
    }
    
    @Override
    public void updateCoolDown() {
        if(this.getCoolDown() > 0) this.setCoolDown(this.getCoolDown()-1);
    }

}
