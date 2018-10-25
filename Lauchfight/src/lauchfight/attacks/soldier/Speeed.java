package lauchfight.attacks.soldier;

import java.awt.Graphics;
import lauchfight.Attack;
import lauchfight.Player;

public class Speeed extends Attack {

	private int counter = 2500;

	public Speeed(Player pSend) {

		// the aim position

		pSend.setSpeed(0.4f);
		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public void phys() {
		if (counter > 0) {
			counter--;
		} else if (counter <= 0) {
			this.p.setSpeed(0.1f);
			counter = 2500;
			setAlive(false);
		}

	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

	}

}
