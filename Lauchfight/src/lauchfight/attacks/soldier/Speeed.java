package lauchfight.attacks.soldier;

import java.awt.Graphics;

import lauchfight.Attack;
import lauchfight.Player;
import lauchfight.effects.SpeedEffect;

public class Speeed extends Attack {

	private int counter = 2500;

	public Speeed(Player pSend, int mouseX, int mouseY) {

		// give the player that created the attack the speed effect
		pSend.addEffect(new SpeedEffect());

	}

	@Override
	public void update() {
	}

	@Override
	public void onCollision(Player playerHit) {
	}

}
