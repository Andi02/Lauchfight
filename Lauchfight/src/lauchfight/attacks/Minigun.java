package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class Minigun extends Attack {

	private double pSpeed;
	private int count;
	private MinigunProjectileFactory Factory = new MinigunProjectileFactory();

	public Minigun(Player pSend) {

		// the aim position
		double xA = Screen.MouseX - pSend.getX() - 30;
		double yA = Screen.MouseY - pSend.getY() - 60;

		// save the player that created the attack
		this.p = pSend;
		pSpeed = p.getSpeed();
		this.p.setSpeed(0f);
	}

	@Override
	public Graphics draw(Graphics g) {

		this.x = this.p.getX() + 13;
		this.y = this.p.getY() + 13;

		// if the attack is used do stuff
		g.setColor(Color.lightGray);
		g.drawRect((int) x, (int) y, 25, 25);

		count += 1;
		if (count % 10 == 0) {
			LauchFight.world.add(Factory.create(this.p));
		}
		if (count == 1000) {
			this.setAlive(false);
			this.p.setSpeed((float) pSpeed);
		}
		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
	}

}
