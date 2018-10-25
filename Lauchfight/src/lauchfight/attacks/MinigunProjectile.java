package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class MinigunProjectile extends Attack {

	private float speed = 1f;
	private double angle;
	int dir = 0;

	public void addX(double a) {
		this.x = (x + a * speed);
	}

	public void addY(double a) {
		this.y = (y + a * speed);
	}

	public MinigunProjectile(Player pSend) {

		speed += ThreadLocalRandom.current().nextFloat() * 0.02f;
		width = 6;
		height = 6;

		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		angle = Math.atan(yA / xA);
		if (xA < 0)
			angle += Math.PI;
		angle += ThreadLocalRandom.current().nextGaussian() * 0.05;

		// the aim position

		this.x = pSend.getX() + 25 - width / 2;
		this.y = pSend.getY() + 25 - height / 2;

		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public void phys(List<Attack> newAttack) {
		addX(speed * Math.cos(angle));
		addY(speed * Math.sin(angle));

		if (this.x >= LauchFight.screenX || this.y >= LauchFight.screenY || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}
	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff

		g.setColor(Color.lightGray);
		g.fillRect((int) x - 5, (int) y - 5, width, height);
		g.fillRect((int) x, (int) y, width, height);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.p) {
			playerHit.addLife(-2);
			this.setAlive(false);
		}

	}

}
