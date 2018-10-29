package lauchfight.attacks.mage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import lauchfight.Attack;
import lauchfight.Player;

public class FireballExplosion extends Attack {

	private double count = 0;
	private ArrayList<Player> playersHit= new  ArrayList<>();

	public FireballExplosion(Player pSend, int mouseX, int mouseY) {

		setHitBoxHeight(100);
		setHitBoxWidth(100);

		this.setP(pSend);
	}

	@Override
	public void update() {
		count += 0.1;
		setHitBoxHeight(100 - (int) count);
		setHitBoxWidth(100 - (int) count);

		if ((int) count >= 80)
			this.setAlive(false);
	}

	@Override
	public void onCollision(Player playerHit) {
		while(true) {
			if (playersHit.contains(playerHit))break;
			playersHit.add(playerHit);
			playerHit.addHealth(-1);
		}
	}

}
