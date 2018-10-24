package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;
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
		this.x += a * speed;
	}

	public void addY(double a) {
		this.y += a * speed;
	}

	public LauchwurfSpawn(Player pSend, int count, int lauchfeldX, int lauchfeldY) {

		// the aim position
		xA = ThreadLocalRandom.current().nextInt(-20, 20);
		yA = ThreadLocalRandom.current().nextInt(-20, 20);

		// save the player that created the attack
		this.p = pSend;
		this.count = count;
		this.lauchfeldX = lauchfeldX;
		this.lauchfeldY = lauchfeldY;
	}

	@Override
	public Graphics draw(Graphics g) {
		if (count > -1 && count < 10)
			count -= 0.008;
		// if the attack is used do stuff
		if (count <= 0) {
			this.x = this.lauchfeldX + 20;
			this.y = this.lauchfeldY + 20;

			if (xA >= 0 && xA > Math.abs(yA)) {
				vX = 1;
				width = 50;
				height = 5;
				this.x += 25;
				this.y -= 2;
			} else if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
				vX = -1;
				width = 50;
				height = 5;
				this.x -= 75;
				this.y -= 2;
			} else if (yA > 0) {
				vY = 1;
				width = 5;
				height = 50;
				this.y += 25;
				this.x -= 2;
			} else {
				vY = -1;
				width = 5;
				height = 50;
				this.y -= 75;
				this.x -= 2;
			}
			count = 20;
			created = true;
		}
		if (created) {
			if (this.x >= 500 || this.y >= 500 || this.x <= -50 || this.y <= -50) {
				this.setAlive(false);
			}

			addX(vX);
			addY(vY);
			g.setColor(Color.green);
			g.fillRect((int) x, (int) y, width, height);
		}
		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!
		if (created)
			if (!(playerHit == this.p)) {
				playerHit.addLife(-30);
				this.setAlive(false);
			}

	}

}
