package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import lauchfight.Attack;
import lauchfight.Player;

public class FireballExplosion extends Attack {

	private double count = 0;
	private ArrayList<Player> playersHit = new ArrayList<>();
	private double mouseY;
	private double mouseX;
	public FireballExplosion(Player pSend, int mouseX, int mouseY) {

		setHitBoxHeight(100);
		setHitBoxWidth(100);

		this.setXPos(mouseX - 150);
		this.setYPos(mouseY - 170);
		this.mouseX = mouseX;
		this.mouseY = mouseY;
		
		this.setP(pSend);
	}

	@Override
	public void update() {
		count += 2;
		this.setXPos(mouseX - 50 - count/2);
		this.setYPos(mouseY - 70 - count/2);
		setHitBoxHeight(100 + (int) count);
		setHitBoxWidth(100 + (int) count);

		if ((int) count >= 200)
			this.setAlive(false);
	}

	@Override
	public void onCollision(Player playerHit) {
		while (true) {
			if (playersHit.contains(playerHit))
				break;
			playersHit.add(playerHit);
			playerHit.addHealth(-100);
		}
	}

}
