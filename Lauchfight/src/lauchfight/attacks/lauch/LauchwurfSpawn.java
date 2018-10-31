package lauchfight.attacks.lauch;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import client.Client;
import lauchfight.Attack;
import lauchfight.Player;

public class LauchwurfSpawn extends Attack {

	private float speed = 1f;
	private boolean created = false;
	private double xA;
	private double yA;
	private double vX = 0;
	private double vY = 0;
	private double count;
	private int lauchfeldX;
	private int lauchfeldY;

	public void addX(double a) {
		this.xPos += a * speed;
	}

	public void addY(double a) {
		this.yPos += a * speed;
	}

	public LauchwurfSpawn(Player pSend, int count, int lauchfeldX, int lauchfeldY) {

		// the aim position
		xA = ThreadLocalRandom.current().nextInt(-20, 20);
		yA = ThreadLocalRandom.current().nextInt(-20, 20);

		// save the player that created the attack
		this.setP(pSend);
		this.count = count;
		this.lauchfeldX = lauchfeldX;
		this.lauchfeldY = lauchfeldY;
	}

	@Override
	public void update() {
		if (count > -1 && count < 10)
			count -= 0.008;
		if (count <= 0) {
			this.xPos = this.lauchfeldX + 20;
			this.yPos = this.lauchfeldY + 20;

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
			count = 20;
			created = true;
		}
		if (created) {
			if (this.xPos >= Client.screenX || this.yPos >= Client.screenY || this.xPos <= 0 || this.yPos <= 0) {
				this.setAlive(false);
			}

			addX(vX);
			addY(vY);
		}
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!
		if (created)
			if (!(playerHit == this.getP())) {
				playerHit.addHealth(-30);
				this.setAlive(false);
			}

	}

}
