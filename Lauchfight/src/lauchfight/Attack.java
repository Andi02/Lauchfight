package lauchfight;

import java.awt.Graphics;

public abstract class Attack {

	public int width = 10;
	public int height = 10;
	public double x = 0;
	public double y = 0;
	public boolean alive = true;
	public Player p;
	public int playerId;

	public void setPlayer(Player[] players) {
		p = players[playerId];
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// checks if the input touches the attack
	public boolean touch(double x, double y, int w, int h) {

		if (this.x + this.width > x && this.x < x + w) {
			if (this.y + this.height > y && this.y < y + w)
				return true;
		}

		return false;
	}

	public abstract Graphics draw(Graphics g);

	public abstract void onCollision(Player playerHit);

}