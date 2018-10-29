package lauchfight.attacks.soldier;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.util.List;

import lauchfight.Attack;
import lauchfight.Player;

public class Minigun extends Attack {

	private double pSpeed;
	private int count;
	private MinigunProjectileFactory Factory = new MinigunProjectileFactory();

	public Minigun(Player pSend) {

		// save the player that created the attack
		this.setP(pSend);
		pSpeed = pSend.getSpeed();
		this.getP().setSpeed(0f);
	}

	@Override
	public void update() {
		Screen.MouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		Screen.MouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();

		this.x = this.getP().getX() + 13;
		this.y = this.getP().getY() + 13;

		count += 1;
		if (count % 10 == 0) {
			LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
		}
		if (count == 1000) {
			this.setAlive(false);
			this.getP().setSpeed((float) pSpeed);
		}

	}


	@Override
	public void onCollision(Player playerHit) {
	}
}
