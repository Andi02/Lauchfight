package lauchfight.attacks.hunter;

import lauchfight.*;
import java.awt.Graphics;

import client.Client;
import client.Screen;

public class ShootArrow extends Attack {

	private float speed = 0.5f;

	private double vX;
	private double vY;
	private int dir;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getYPos() + a * speed));
	}

	public ShootArrow(Player pSend, int mouseX, int mouseY) {

		// set the speed
		this.setSpeed(0.5);

		// set the starting pos
		this.setXPos(pSend.getXPos() + 20);
		this.setYPos(pSend.getYPos() + 20);

		// the aim position
		double xA = mouseX - pSend.getXPos() - 30;
		double yA = mouseY - pSend.getYPos() - 60;
		
		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		

		if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			if (Math.abs(yA) / Math.abs(xA) > 0.5 && yA >= 0) {
				dir = 5;
				vY = 1;
				vX = -1;
			} else if (Math.abs(yA) / Math.abs(xA) > 0.5 && yA < 0) {
				dir = 7;
				vX = -1;
				vY = -1;
			} else {
				dir = 6;
				vX = -1.414;
			}
		} else if (xA >= 0 && xA > Math.abs(yA)) {
			if (Math.abs(yA) / xA > 0.5 && yA >= 0) {
				dir = 3;
				vX = 1;
				vY = 1;
			} else if (Math.abs(yA) / xA > 0.5 && yA < 0) {
				dir = 1;
				vY = -1;
				vX = 1;
			} else {
				dir = 2;
				vX = 1.414;
			}
		} else if (yA > 0) {
			if (Math.abs(xA) / Math.abs(yA) > 0.5 && xA >= 0) {
				dir = 3;
				vX = 1;
				vY = 1;
			} else if (Math.abs(xA) / Math.abs(yA) > 0.5 && xA < 0) {
				dir = 5;
				vY = 1;
				vX = -1;
			} else {
				dir = 4;
				vY = 1.414;

			}
		} else {
			if (Math.abs(xA) / yA > 0.5 && xA >= 0) {
				dir = 1;
				vY = -1;
				vX = 1;

			} else if (Math.abs(xA) / yA > 0.5 && xA < 0) {
				dir = 7;
				vX = -1;
				vY = -1;
			} else {
				dir = 0;
				vY = -1.414;
			}
		}

		System.out.println(dir);
		
		

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
			playerHit.addHealth(-10);
			this.setAlive(false);
		}

	}

}
