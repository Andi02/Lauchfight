package lauchfight.attacks.soldier;

import java.awt.Color;
import java.awt.Graphics;

import lauchfight.Attack;
import lauchfight.Player;

public class Knife extends Attack {

	private int counter = 0;
	private int rX;
	private int rY;
	private float speedPlayer;

	public Knife(Player pSend,int mouseX,int mouseY) {

		speedPlayer = (float) pSend.getSpeed();

		pSend.setSpeed(0.0f);

		// the aim position
		double xA = mouseX - pSend.getXPos() - 30;
		double yA = mouseY - pSend.getYPos() - 60;

		this.setXPos(pSend.getXPos() + 25);
		this.setYPos(pSend.getYPos() + 25);

		if (yA <= 0 && Math.abs(yA) > Math.abs(xA)) {
			setHitBoxWidth(4);
			setHitBoxHeight(50);
			rX = (int) (getYPos() - 2);
			rY = (int) getYPos() - 50;
		} else if (xA >= 0 && Math.abs(xA) > Math.abs(yA)) {
			setHitBoxWidth(50);
			setHitBoxHeight(4);
			rX = (int) getXPos();
			rY = (int) (getYPos() - 2);
		} else if (yA > 0 && Math.abs(yA) > Math.abs(xA)) {
			setHitBoxWidth(4);
			setHitBoxHeight(50);
			rX = (int) (getXPos() - 2);
			rY = (int) getYPos();
		} else if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			setHitBoxWidth(50);
			setHitBoxHeight(4);
			rX = (int) getXPos() - 50;
			rY = (int) getYPos();
		}

		// save the player that created the attack
		this.setP(pSend);
	}

	@Override
	public void update() {

		if (counter >= 150) {
			this.setAlive(false);
			this.getP().setSpeed(speedPlayer);
			counter = 0;
		}

		counter++;

	}


	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.getP()) {
			playerHit.addHealth(-75);
			this.setAlive(false);
		}

	}

}
