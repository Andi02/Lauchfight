package lauchfight.attacks.lauch;

import java.awt.Color;
import java.awt.Graphics;

import client.Client;
import lauchfight.Attack;
import lauchfight.LauchFightOnline;
import lauchfight.Player;

public class Lauchfeld extends Attack {

	private float speed = 0f;
	private double time;
	private LauchwurfSpawnFactory Factory = new LauchwurfSpawnFactory();

	public Lauchfeld(Player pSend,int mouseX,int mouseY) {

		// the aim position
		double xA = mouseX - pSend.getXPos() - 25;
		double yA = mouseY - pSend.getYPos() - 25;
		setHitBoxHeight(40);
		setHitBoxWidth(40);

		if (xA >= 0 && xA > Math.abs(yA)) {
			this.setXPos(pSend.getXPos() + 75);
			this.setYPos(pSend.getYPos() + 5);
		} else if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			this.setXPos(pSend.getXPos() - 75);
			this.setYPos(pSend.getYPos() + 5);
		} else if (yA > 0) {
			this.setXPos(pSend.getXPos() + 5);
			this.setYPos(pSend.getYPos() + 75);
		} else {
			this.setXPos(pSend.getXPos() + 5);
			this.setYPos(pSend.getYPos() - 75);
		}
		Factory.setLauchfeldX((int) this.getXPos());
		Factory.setLauchfeldY((int) this.getYPos());

		// save the player that created the attack
		this.setP(pSend);
	}
	@Override
	public void update() {
		if (this.getXPos() >= Client.screenX || this.getYPos() >= Client.screenY || this.getXPos() <= 0 || this.getYPos() <= 0) {
			this.setAlive(false);
		}
		if (time >= 100)
			time += 0.09143;
		if (time >= 181)
			this.setAlive(false);
		
		if (time <= 10)
			time += 0.004;
		if (time >= 8)
			onCollision(this.getP());
		
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!
		if (playerHit == this.getP()) {
			switch ((int) time) {
			case 8:
				Factory.setCount(7);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				time = 100;
			case 7:
				Factory.setCount(6);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 110;
			case 6:
				Factory.setCount(5);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 120;
			case 5:
				Factory.setCount(4);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 130;
			case 4:
				Factory.setCount(3);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 140;
			case 3:
				Factory.setCount(2);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 150;
			case 2:
				Factory.setCount(1);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 160;
			case 1:
				Factory.setCount(0);
				LauchFightOnline.aR.setNewAttacks(Factory.create(this.getP()));
				if (time < 100)
					time = 170;
			case 0:
				break;
			}
		}

	}

}
