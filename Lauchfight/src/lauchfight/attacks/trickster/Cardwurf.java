package lauchfight.attacks.trickster;

import java.awt.Color;
import java.awt.Graphics;

import client.Client;
import lauchfight.Attack;
import lauchfight.Player;

public class Cardwurf extends Attack {

	private float speed = 0.6f;

	private double vX;
	private double vY;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getYPos() + a * speed));
	}

	public Cardwurf(Player pSend, int mouseX, int mouseY) {

		// the aim position
		double xA = mouseX - pSend.getXPos() - 30;
		double yA = mouseY - pSend.getYPos() - 60;

		this.setXPos(pSend.getXPos() + 25);
		this.setYPos(pSend.getYPos() + 25);

		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		vX = xA * k;
		vY = yA * k;

		// save the player that created the attack
		this.setP(pSend);
	}

	@Override
	public void update() {
		addX(vX);
		addY(vY);

		if (this.getXPos() >= Client.screenX || this.getYPos() >= Client.screenY || this.getXPos() <= 0
				|| this.getYPos() <= 0) {
			this.setAlive(false);
		}

	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.getP()) {
			playerHit.addHealth(-30);
			this.setAlive(false);
		}

	}

}
