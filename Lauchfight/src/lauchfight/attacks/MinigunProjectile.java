package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class MinigunProjectile extends Attack {

	private float speed = 1f;
	private int rand;
	private double vX;
	private double vY;
	int dir = 0;

	public void addX(double a) {
		this.x = (x + a * speed);
	}

	public void addY(double a) {
		this.y = (y + a * speed);
	}

	public MinigunProjectile(Player pSend) {
		rand = ThreadLocalRandom.current().nextInt(-100, 100);
		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			if (Math.abs(yA) / Math.abs(xA) > 0.5 && yA >= 0) {
				dir = 5;
			} else if (Math.abs(yA) / Math.abs(xA) > 0.5 && yA < 0) {
				dir = 7;
			} else {
				dir = 6;
			}
		} else if (xA >= 0 && xA > Math.abs(yA)) {
			if (Math.abs(yA) / xA > 0.5 && yA >= 0) {
				dir = 3;
			} else if (Math.abs(yA) / xA > 0.5 && yA < 0) {
				dir = 1;
			} else {
				dir = 2;
			}
		} else if (yA > 0) {
			if (Math.abs(xA) / Math.abs(yA) > 0.5 && xA >= 0) {
				dir = 3;
			} else if (Math.abs(xA) / Math.abs(yA) > 0.5 && xA < 0) {
				dir = 5;
			} else {
				dir = 4;
			}
		} else {
			if (Math.abs(xA) / yA > 0.5 && xA >= 0) {
				dir = 1;
			} else if (Math.abs(xA) / yA > 0.5 && xA < 0) {
				dir = 7;
			} else {
				dir = 0;
			}
		}
		if (dir == 0) {xA =  ((double) rand)/1000; yA = -1;}
		else if (dir == 1);
		else if (dir == 2){xA = 1; yA = ((double) rand)/1000;}
		else if (dir == 3);
			else if (dir == 4){xA =  ((double) rand)/1000; yA = 1;}
				else if (dir == 5);
				else if (dir == 6){xA = -1; yA = ((double) rand)/1000;}
					else if (dir == 7);
			
		// the aim position

		this.x = pSend.getX() + 25 - width / 2;
		this.y = pSend.getY() + 25 - height / 2;

		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		vX = xA * k;
		vY = yA * k;

		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff
		addX(vX);
		addY(vY);
		
		g.setColor(Color.lightGray);
		g.fillRect((int) x, (int) y, width, height);

		if (this.x >= LauchFight.screenX || this.y >= LauchFight.screenY || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.p) {
			playerHit.addLife(-1);
			this.setAlive(false);
		}

	}

}
