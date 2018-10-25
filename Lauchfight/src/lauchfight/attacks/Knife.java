package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import lauchfight.Attack;
import lauchfight.Player;
import lauchfight.Screen;

public class Knife extends Attack {

	private int counter = 0;
	private int width;
	private int height;
	private int rX;
	private int rY;
	private float speedPlayer;

	public Knife(Player pSend) {

		this.playerId = pSend.getId();

		speedPlayer = pSend.getSpeed();

		pSend.setSpeed(0.0f);

		// the aim position
		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		this.x = pSend.getX() + 25;
		this.y = pSend.getY() + 25;

		if (yA <= 0 && Math.abs(yA) > Math.abs(xA)) {
			width = 4;
			height = 50;
			rX = (int) (getX() - 2);
			rY = (int) getY() - 50;
		} else if (xA >= 0 && Math.abs(xA) > Math.abs(yA)) {
			width = 50;
			height = 4;
			rX = (int) getX();
			rY = (int) (getY() - 2);
		} else if (yA > 0 && Math.abs(yA) > Math.abs(xA)) {
			width = 4;
			height = 50;
			rX = (int) (getX() - 2);
			rY = (int) getY();
		} else if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			width = 50;
			height = 4;
			rX = (int) getX() - 50;
			rY = (int) getY();
		}

		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public void phys() {

		if (counter >= 150) {
			this.setAlive(false);
			this.p.setSpeed(speedPlayer);
			counter = 0;
		}

		counter++;

	}

	@Override
	public Graphics draw(Graphics g) {

		g.setColor(Color.lightGray);
		g.fillRect(rX, rY, width, height);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.p) {
			playerHit.addLife(-75);
			this.setAlive(false);
		}

	}

}
