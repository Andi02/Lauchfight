package lauchfight.attacks.trickster;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;
import lauchfight.attacks.Test;

public class CardwurfFactory extends AttackFactory {

	private long COOLDOWN = 1000;

	public CardwurfFactory() {
		this.setCoolDown(1000);
	}

	@Override
    public Attack createNew(Player p, int mouseX, int mouseY) {
        //restet the cooldown
        this.setCoolDown(COOLDOWN);
        //return a new attack
        return new Test(p,mouseX,mouseY);
    }
    
    @Override
    public void updateCoolDown() {
        if(this.getCoolDown() > 0) this.setCoolDown(this.getCoolDown()-1);
    }

}
