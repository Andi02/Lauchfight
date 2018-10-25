package lauchfight.attacks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import lauchfight.Attack;
import lauchfight.LauchFight;
import lauchfight.Player;
import lauchfight.Screen;

public class Lauchfeld extends Attack {

	private float speed = 0f;
	private double time;
	private LauchwurfSpawnFactory Factory = new LauchwurfSpawnFactory();

	public void addX(double a) {
		this.x += a * speed;
	}

	public void addY(double a) {
		this.y += a * speed;
	}

	public Lauchfeld(Player pSend) {

		// the aim position
		double xA = Screen.MouseX - pSend.getX() - 25;
		double yA = Screen.MouseY - pSend.getY() - 25;
		height = 40;
		width = 40;

		if (xA >= 0 && xA > Math.abs(yA)) {
			this.x = pSend.getX() + 75;
			this.y = pSend.getY() + 5;
		} else if (xA <= 0 && Math.abs(xA) > Math.abs(yA)) {
			this.x = pSend.getX() - 75;
			this.y = pSend.getY() + 5;
		} else if (yA > 0) {
			this.x = pSend.getX() + 5;
			this.y = pSend.getY() + 75;
		} else {
			this.x = pSend.getX() + 5;
			this.y = pSend.getY() - 75;
		}
		Factory.setLauchfeldX((int) this.x);
		Factory.setLauchfeldY((int) this.y);

		// save the player that created the attack
		this.p = pSend;
	}
	@Override
	public void phys(List<Attack> newAttacks) {
		if (this.x >= LauchFight.screenX || this.y >= LauchFight.screenY || this.x <= 0 || this.y <= 0) {
			this.setAlive(false);
		}
		if (time >= 100)
			time += 0.09143;
		if (time >= 181)
			this.setAlive(false);
		
		if (time <= 10)
			time += 0.004;
		if (time >= 8)
			onCollision(this.p);
		
	}
	@Override
	public Graphics draw(Graphics g) {

		// if the attack is used do stuff
		
		g.setColor(Color.green);
		g.fillRect((int) x, (int) y, width, height);


		return g;
	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!
		if (playerHit == this.p) {
			switch ((int) time) {
			case 8:
				Factory.setCount(7);
				LauchFight.world.add(Factory.create(this.p));
				time = 100;
			case 7:
				Factory.setCount(6);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 110;
			case 6:
				Factory.setCount(5);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 120;
			case 5:
				Factory.setCount(4);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 130;
			case 4:
				Factory.setCount(3);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 140;
			case 3:
				Factory.setCount(2);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 150;
			case 2:
				Factory.setCount(1);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 160;
			case 1:
				Factory.setCount(0);
				LauchFight.world.add(Factory.create(this.p));
				if (time < 100)
					time = 170;
			case 0:
				break;
			}
		}

	}

}
