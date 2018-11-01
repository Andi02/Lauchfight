package lauchfight.attacks.soldier;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import client.Client;
import lauchfight.Attack;
import lauchfight.Player;

public class MinigunProjectile extends Attack {

	private float speed = 1f;
	private double angle;
	int dir = 0;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getYPos() + a * speed));
	}

	public MinigunProjectile(Player pSend, int mouseX, int mouseY) {

		speed += ThreadLocalRandom.current().nextFloat() * 0.02f;
		this.setHitBoxHeight(6);
		this.setHitBoxWidth(6);

		double xA = mouseX - pSend.getXPos();
		double yA = mouseY - pSend.getYPos();

		angle = Math.atan(yA / xA);
		if (xA < 0)
			angle += Math.PI;
		angle += ThreadLocalRandom.current().nextGaussian() * 0.05;

		this.setXPos(pSend.getXPos() + 25 - this.getHitBoxWidth() / 2);
		this.setYPos(pSend.getYPos() + 25 - this.getHitBoxHeight() / 2);

		this.setP(pSend);
	}

	@Override
	public void update() {
		addX(speed * Math.cos(angle));
		addY(speed * Math.sin(angle));

		if (this.getXPos() >= Client.screenX || this.getYPos() >= Client.screenY || this.getXPos() <= 0
				|| this.getYPos() <= 0) {
			this.setAlive(false);
		}
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.getP()) {
			playerHit.addHealth(-3);
			this.setAlive(false);
		}

	}

}
