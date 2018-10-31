package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;

import client.Client;
import lauchfight.Attack;
import lauchfight.LauchFightOnline;
import lauchfight.Player;

public class Fireball extends Attack {

	private float speed = 0.42f;
	private FireballExplosionFactory Factory = new FireballExplosionFactory();
	private double vX;
	private double vY;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getYPos() + a * speed));
	}

	public Fireball(Player pSend, int mouseX, int mouseY) {

		setHitBoxWidth(30);
		setHitBoxHeight(30);

		double xA = mouseX - pSend.getXPos() - 30;
		double yA = mouseY - pSend.getYPos() - 60;

		setXPos(pSend.getXPos() + 10);
		setYPos(pSend.getYPos() + 10);

		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		vX = xA * k;
		vY = yA * k;

		setP(pSend);
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

		LauchFightOnline.oR.setNewObjects(Factory.createNew(this.getP(),(int) this.getXPos(),(int) this.getYPos()));
		this.setAlive(false);

	}

}
