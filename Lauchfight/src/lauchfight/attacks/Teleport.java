package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class Teleport extends Attack {
	private int count = 0;
	private boolean teleport;
	private int xT, yT;

	public Teleport(Player pSend) {
		// save the player that created the attack
		this.p = pSend;
		teleport = true;
	}

	@Override
	public void phys(List<Attack> newAttacks) {
		count++;

		if (teleport) {
			xT = Screen.MouseX - 25;
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

		if (count == 1100) {
			count = 0;
			this.p.setX(xT);
			this.p.setY(yT);

			this.setAlive(false);
		}

	}

	@Override
	public Graphics draw(Graphics g) {

		g.setColor(Color.magenta);
		g.fillRect(xT, yT, 50, 50);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
	}

}
