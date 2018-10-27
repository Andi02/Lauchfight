package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;

import client.Client;
import lauchfight.Attack;
import lauchfight.Player;

public class Teleport extends Attack {
	private int count = 0;
	private boolean teleport;
	private int xT, yT;

	public Teleport(Player pSend,int mouseX,int mouseY) {
		// save the player that created the attack
		this.setP(pSend);
		xT = mouseX - 25;
		if (xT < 1)
			xT = 1;
		if (xT > Client.screenX - 50)
			xT = Client.screenX - 50;

		yT = mouseY - 50;
		if (yT < 1)
			yT = 1;
		if (yT > Client.screenY - 80)
			yT = Client.screenY - 80;
	}

	@Override
	public void update() {
		count++;

		if (count == 1100) {
			count = 0;
			this.getP().setXPos(xT);
			this.getP().setYPos(yT);

			this.setAlive(false);
		}

	}

	@Override
	public void onCollision(Player col) {
		// TODO Auto-generated method stub
		
	}


}
