package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class FireballExplosion extends Attack {

 private double count = 0;

	public FireballExplosion(Player pSend) {

		width = 100;
		height = 100;

		this.p = pSend;
	}

	@Override
	public void phys() {


	}

	@Override
	public Graphics draw(Graphics g) {

		g.setColor(Color.magenta);
		g.fillOval((int) x, (int) y, (int) (30+count), (int) (30+count));

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {

			
			this.setAlive(false);
			


	}

}
