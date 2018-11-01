package lauchfight.attacks.soldier;

import lauchfight.Attack;
import lauchfight.LauchFightOnline;
import lauchfight.Player;

public class Minigun extends Attack {

	private double pSpeed;
	private int count;
	private MinigunProjectileFactory Factory = new MinigunProjectileFactory();
	private int mouseX, mouseY;

	public Minigun(Player pSend, int mouseX, int mouseY) {

		// save the player that created the attack
		this.setP(pSend);
		pSpeed = pSend.getSpeed();
		this.getP().setSpeed(0f);

		this.setXPos(pSend.getXPos() + 25 - this.getHitBoxWidth() / 2);
		this.setYPos(pSend.getYPos() + 25 - this.getHitBoxHeight() / 2);
	}

	@Override
	public void update() {

		count += 1;
		if (count % 10 == 0) {
			LauchFightOnline.oR.setNewObjects(Factory.createNew(this.getP(), mouseX, mouseY));
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
