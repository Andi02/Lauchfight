package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import lauchfight.Attack;
import lauchfight.Player;
import lauchfight.Screen;

public class Cardwurf extends Attack {

	private float speed = 0.6f;

	private double vX;
	private double vY;

	public void addX(double a) {
		this.x = (x + a * speed);
	}

	public void addY(double a) {
		this.y = (y + a * speed);
	}

	public Cardwurf(Player pSend) {

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
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff
		addX(vX);
		addY(vY);

		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, 20, 30);

		if (this.x >= 500 || this.y >= 500 || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.p) {
			playerHit.addLife(-30);
			this.setAlive(false);
		}

	}

}
