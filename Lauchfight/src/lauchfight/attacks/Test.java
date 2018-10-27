package lauchfight.attacks;
import lauchfight.*;
import java.awt.Graphics;

import client.Client;
import client.Screen;

public class Test extends Attack {

	private float speed = 0.5f;

	private double vX;
	private double vY;

	public void addX(double a) {
		this.setXPos((getXPos() + a * speed));
	}

	public void addY(double a) {
		this.setYPos((getXPos() + a * speed));
	}

	public Test(Player pSend,int mouseX,int mouseY) {

		//set the speed
        this.setSpeed(0.5);

        //set the starting pos
        this.setXPos(pSend.getXPos());
        this.setYPos(pSend.getYPos());

        // the aim position
        double xA = mouseX - pSend.getXPos();
        double yA = mouseY - pSend.getYPos();

        double k = Math.sqrt((this.getSpeed() * this.getSpeed()) / (xA * xA + yA * yA));
        vX = xA * k;
        vY = yA * k;

        // save the player that created the attack
        this.setP(pSend);
	}

	@Override
	public void update() {
		addX(vX);
		addY(vY);

		if (this.getXPos() >= Client.screenX || this.getYPos() >= Client.screenY || this.getXPos() <= 0 || this.getYPos() <= 0) {
			this.setAlive(false);
		}

	}

	@Override
	public void onCollision(Player playerHit) {
		// do stuff with the player if it gets hit!

		if (playerHit != this.getP()) {
			playerHit.addHealth(-10);
			this.setAlive(false);
		}

	}

}
