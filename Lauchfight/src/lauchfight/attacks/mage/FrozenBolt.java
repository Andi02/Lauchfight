package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class FrozenBolt extends Attack {

	private float speed = 0.33f;

	private double vX;
	private double vY;

	public void addX(double a) {
		this.x = (x + a * speed);
	}

	public void addY(double a) {
		this.y = (y + a * speed);
	}

	public FrozenBolt(Player pSend) {

		width = 30;
		height = 30;

		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		this.x = pSend.getX() + 10;
		this.y = pSend.getY() + 10;

		double k = Math.sqrt((speed * speed) / (xA * xA + yA * yA));
		vX = xA * k;
		vY = yA * k;

		this.p = pSend;
	}

	@Override
	public void phys() {
		addX(vX);
		addY(vY);

		if (this.x >= LauchFight.screenX || this.y >= LauchFight.screenY || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}

	}

	@Override
	public Graphics draw(Graphics g) {

		g.setColor(Color.magenta);
		g.fillOval((int) x, (int) y, width, height);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {

		if (playerHit != this.p) {
			playerHit.addLife(-40);
			this.setAlive(false);
		}

	}

}