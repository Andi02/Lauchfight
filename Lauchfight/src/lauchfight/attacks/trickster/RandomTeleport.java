package lauchfight.attacks.trickster;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import client.Client;
import lauchfight.Attack;
import lauchfight.LauchFightOnline;
import lauchfight.Player;

public class RandomTeleport extends Attack {
	private int count = 0;
	private int xT, yT;
	private int mouseX, mouseY;
	private CardwurfFactory Factory = new CardwurfFactory();

	public RandomTeleport(Player pSend, int mouseX, int mouseY) {
		// save the player that created the attack
		this.setP(pSend);

		int randX, randY;
		do {
			randX = ThreadLocalRandom.current().nextInt(-500, 500);
		} while (Math.abs(randX) <= 70);
		do {
			randY = ThreadLocalRandom.current().nextInt(-500, 500);
		} while (Math.abs(randY) <= 70);

		xT = (int) (this.getP().getXPos() + randX);
		yT = (int) (this.getP().getYPos() + randY);

		if (xT < 1)
			xT = 1;
		if (xT > Client.screenX - 50)
			xT = Client.screenX - 50;

		if (yT < 1)
			yT = 1;
		if (yT > Client.screenY - 80)
			yT = Client.screenY - 80;

		this.mouseX = mouseX;
		this.mouseY = mouseY;
	}

	@Override
	public void update() {
		count++;

		if (count == 500) {
			count = 0;
			this.getP().setXPos(xT);
			this.getP().setYPos(yT);

			this.setAlive(false);
			this.onCollision(this.getP());
		}

	}

	@Override
	public void onCollision(Player playerHit) {
		LauchFightOnline.oR.setNewObjects(Factory.createNew(playerHit, mouseX, mouseY));
	}

}
