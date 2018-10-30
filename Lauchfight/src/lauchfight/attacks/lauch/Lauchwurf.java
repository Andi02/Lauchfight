package lauchfight.attacks.lauch;

import java.awt.Color;
import java.awt.Graphics;

import client.Client;
import lauchfight.Attack;
import lauchfight.Player;

public class Lauchwurf extends Attack {

	private float speed = 1f;

	private double vX = 0;
	private double vY = 0;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getYPos() + a * speed));
	}

	public Lauchwurf(Player pSend,int mouseX,int mouseY) {

		// the aim position
		double xA = mouseX - pSend.getXPos() - 25;
		double yA = mouseY - pSend.getYPos() - 25;

		this.setXPos(pSend.getXPos() + 25);
		this.setYPos(pSend.getYPos() + 25);

		if (xA >= 0 && xA > Math.abs(yA)) {
			vX = 1;
			setHitBoxWidth(50);
			setHitBoxHeight(5);
			this.xPos += 25;
			this.yPos -= 2;
		} else if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			vX = -1;
			setHitBoxWidth(50);
			setHitBoxHeight(5);
			this.xPos -= 75;
			this.yPos -= 2;
		} else if (yA > 0) {
			vY = 1;
			setHitBoxWidth(5);
			setHitBoxHeight(50);
			this.yPos += 25;
			this.xPos -= 2;
		} else {
			vY = -1;
			setHitBoxWidth(5);
			setHitBoxHeight(50);
			this.yPos -= 75;
			this.xPos -= 2;
		}

		// save the player that created the attack
		this.setP(pSend);
	}

	@Override
	public void update() {
		addX(vX);
		addY(vY);

		if (this.getXPos() >= Client.screenX || this.getYPos() >= Client.screenY || this.getXPos() <= 0 || this.getYPos() <= 0) {
			this.setAlive(false);
		}

	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!
		if (!(playerHit == this.getP())) {
			playerHit.addHealth(-50);
			this.setAlive(false);
		}

	}

}
