package lauchfight.attacks;

import java.awt.Graphics;
import java.util.List;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class ShootArrow extends Attack {

	private float speed = 0.5f;

	private double vX;
	private double vY;

	public void addX(double a) {
		this.x = (x + a * speed);
	}

	public void addY(double a) {
		this.y = (y + a * speed);
	}

	public ShootArrow(Player pSend) {

		// the aim position
		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		this.x = pSend.getX() + 25;
		this.y = pSend.getY() + 25;

		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		vX = xA * k;
		vY = yA * k;

		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public void phys(List<Attack> newAttacks) {
		addX(vX);
		addY(vY);

		if (this.x >= LauchFight.screenX || this.y >= LauchFight.screenY || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}

	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff

		g.fillRect((int) x, (int) y, width, height);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.p) {
			playerHit.addLife(-10);
			this.setAlive(false);
		}

	}

}
