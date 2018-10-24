package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class Minigun extends Attack {

	private int count;
	private MinigunProjectileFactory Factory = new MinigunProjectileFactory();
	
	public Minigun(Player pSend) {

		// the aim position
		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		this.x = pSend.getX() + 13;
		this.y = pSend.getY() + 13;

		// save the player that created the attack
		this.p = pSend;
	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff
		g.setColor(Color.lightGray);
		g.drawRect((int) x, (int) y, 25, 25);

		count++;
		if (count%50 == 0) {
			LauchFight.world.add(Factory.create(this.p));
		}
		if (count == 5000) this.setAlive(false);
		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
	}

}
