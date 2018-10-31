package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;

import client.Client;
import lauchfight.Attack;
import lauchfight.Player;

public class FrozenBolt extends Attack {

	private float speed = 0.33f;

	private double vX;
	private double vY;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getYPos() + a * speed));
	}

	public FrozenBolt(Player pSend, int mouseX, int mouseY) {

		setHitBoxHeight(30);
		setHitBoxWidth(30);

		double xA = mouseX - pSend.getXPos() - 30;
		double yA = mouseY - pSend.getYPos() - 60;

		this.setXPos(pSend.getXPos() + 10);
		this.setXPos(pSend.getYPos() + 10);

		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		vX = xA * k;
		vY = yA * k;

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

		if (playerHit != this.getP()) {
			playerHit.addHealth(-40);
			this.setAlive(false);
		}

	}

}
