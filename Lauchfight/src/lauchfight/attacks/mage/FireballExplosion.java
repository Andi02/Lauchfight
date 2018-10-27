package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;

import lauchfight.Attack;
import lauchfight.Player;

public class FireballExplosion extends Attack {

	private double count = 0;

	public FireballExplosion(Player pSend, int mouseX, int mouseY) {

		setHitBoxHeight(100);
		setHitBoxWidth(100);

		this.setP(pSend);
	}

	@Override
	public void update() {
	}

	@Override
	public void onCollision(Player playerHit) {

		this.setAlive(false);
	}

}
