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
				randX = ThreadLocalRandom.current().nextInt(-500, 500);
			} while (Math.abs(randX) <= 70);
			do {
				randY = ThreadLocalRandom.current().nextInt(-500, 500);
			} while (Math.abs(randY) <= 70);

			xT = (int) (this.p.getX() + randX);
			yT = (int) (this.p.getY() + randY);

			if (xT < 1)
				xT = 1;
			if (xT > LauchFight.screenX - 50)
				xT = LauchFight.screenX - 50;

			yT = Screen.MouseY - 50;
			if (yT < 1)
				yT = 1;
			if (yT > LauchFight.screenY - 80)
				yT = LauchFight.screenY - 80;
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
