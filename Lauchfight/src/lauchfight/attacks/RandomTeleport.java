package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class RandomTeleport extends Attack {
	private int count = 0;
	private boolean teleport;
	private int xT, yT;
	private CardwurfFactory Factory = new CardwurfFactory();

	public RandomTeleport(Player pSend) {
		// save the player that created the attack
		this.p = pSend;
		teleport = true;

	}

	@Override
	public Graphics draw(Graphics g) {
		count++;

		if (teleport) {
			int randX, randY;
			do {
				randX = ThreadLocalRandom.current().nextInt(-200, 200);
			} while (Math.abs(randX) <= 30);
			do {
				randY = ThreadLocalRandom.current().nextInt(-200, 200);
			} while (Math.abs(randY) <= 30);

			xT = (int) (this.p.getX() + randX);
			yT = (int) (this.p.getY() + randY);

			if (xT < 1)
				xT = 1;
			if (xT > 450)
				xT = 450;

			yT = Screen.MouseY - 50;
			if (yT < 1)
				yT = 1;
			if (yT > 420)
				yT = 420;
			teleport = false;
		}

		if (count == 500) {
			count = 0;
			this.p.setX(xT);
			this.p.setY(yT);

			this.setAlive(false);
			this.onCollision(this.p);
		}

		g.setColor(Color.magenta);
		g.fillRect(xT, yT, 50, 50);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		LauchFight.world.add(Factory.create(playerHit));
	}

}
