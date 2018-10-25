package lauchfight.attacks.lauch;

import java.awt.Color;
import java.awt.Graphics;
import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class Lauchwurf extends Attack {

	private float speed = 1f;

	private double vX = 0;
	private double vY = 0;

	public void addX(double a) {
		this.x += a * speed;
	}

	public void addY(double a) {
		this.y += a * speed;
	}

	public Lauchwurf(Player pSend) {

		// the aim position
		double xA = Screen.MouseX - pSend.getX() - 25;
		double yA = Screen.MouseY - pSend.getY() - 25;

		this.x = pSend.getX() + 25;
		this.y = pSend.getY() + 25;

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

		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public void phys() {
		if (this.x >= LauchFight.screenX || this.y >= LauchFight.screenY || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}

		addX(vX);
		addY(vY);

	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff

		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, width, height);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!
		if (!(playerHit == this.p)) {
			playerHit.addLife(-50);
			this.setAlive(false);
		}

	}

}
