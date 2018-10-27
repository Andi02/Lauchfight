package lauchfight.attacks.soldier;

import java.awt.Graphics;

import lauchfight.Attack;
import lauchfight.Player;

public class Speeed extends Attack {

	private int counter = 2500;

	public Speeed(Player pSend,int mouseX,int mouseY) {

		// the aim position

		pSend.setSpeed(0.4f);
		// save the player that created the attack
		this.setP(pSend);
	}

	@Override
	public void update() {
		if (counter > 0) {
			counter--;
		} else if (counter <= 0) {
			this.getP().setSpeed(0.1f);
			counter = 2500;
			setAlive(false);
		}

	}


	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

	}

}
