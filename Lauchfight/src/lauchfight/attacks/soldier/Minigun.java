package lauchfight.attacks.soldier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.List;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class Minigun extends Attack {

	private double pSpeed;
	private int count;
	private MinigunProjectileFactory Factory = new MinigunProjectileFactory();

	public Minigun(Player pSend) {

		// save the player that created the attack
		this.p = pSend;
		pSpeed = p.getSpeed();
		this.p.setSpeed(0f);
	}

	@Override
	public void phys() {
		Screen.MouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		Screen.MouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

		this.x = this.p.getX() + 13;
		this.y = this.p.getY() + 13;

		count += 1;
		if (count % 10 == 0) {
			LauchFight.aR.setNewAttacks(Factory.create(this.p));
		}
		if (count == 1000) {
			this.setAlive(false);
			this.p.setSpeed((float) pSpeed);
		}

	}

	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff
		g.setColor(Color.lightGray);
		g.drawRect((int) x, (int) y, 25, 25);

		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
	}
}
