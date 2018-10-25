package lauchfight;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import lauchfight.attacks.*;

public class LauchFight {

	public Player[] ps;
	public Canvas c;
	private int drawCount = 16;
	// the player you are
	static public int player;
	// the data form online
	static String data = "10 10 _10 10 _";
	// the x and y for the online Thread
	public static int screenX = 1600;
	public static int screenY = 1080;

	public OnlineThread ot;

	public static ArrayList<Attack> world = new ArrayList<>();

	public static void main(String[] args) {
		new LauchFight().core();
	}

	public void core() {

		// set the player you are
		player = 0;
		// every player in one round has a unique number

		// create Players
		Player p1 = new Player(
				new AttackFactory[] { new LauchfeldFactory(), new TestFactory(), new TestFactory(), new TestFactory() },
				0, 0, 100, 0.1f, player);
		Player p2 = new Player(
				new AttackFactory[] { new TestFactory(), new TestFactory(), new TestFactory(), new TestFactory() }, 0,
				0, 100, 0.1f, player);

		ps = new Player[] { p1, p2 };

		// create the Canvas

		c = new Canvas();
		drawCount++;
		// create the Screen
		Screen s = new Screen(screenX, screenY, "hallo");

		s.setCanvas(c);

		// add the KeyHandler
		s.setKeyListener(new KeyHandler());

		// add the MouseHandler
		s.setMouseListener(new MouseHandler());

		// start the online game thread
		// ot = new OnlineThread();
		// ot.start();
		//
		// start the game loop
		gameLoop();

	}

	int counter = 0;

	public void gameLoop() {

		while (true) {
			
			
			Player p = ps[player];
			List<Attack> newAttacks = new ArrayList<>();
			// physic update
			for (Attack a : world) {
				a.phys(newAttacks);
			}
			

			// ------------------------------------------------------------------------------
			// get the data form online and send it as well!

			// set new X Y for the player
			// ot.p = p;

			// split the sring by the _
			String[] playerData = data.split("_");

			// set the position of the other "online" players
			for (int i = 0; i < 2; i++) {
				// if i is the player don't set the Player pos
				if (i != player) {
					// split the array
					String[] XY = playerData[i].split(" ");
					// set the x and y
					ps[i].setX(Double.valueOf(XY[0]));
					ps[i].setY(Double.valueOf(XY[1]));
				}
			}

			// ------------------------------------------------------------------------------
			// move the player
			if (Screen.A) {
				p.addX(-1);
			}
			if (Screen.W) {
				p.addY(-1);
			}
			if (Screen.D) {
				p.addX(+1);
			}
			if (Screen.S) {
				p.addY(+1);
			}

			// ------------------------------------------------------------------------------
			// check if the player has pressed the MouseButton1 and the cooldown of the
			// factory is 0
			if (Screen.MouseBut1 && (p.getFactorys()[0]).cooldownZero()) {
				// if it is generate a new Attack object and save it int the Attack ArrayList
				// get the attack form the 0th factory
				newAttacks.add(p.getAttack(0));
				// reset the cooldown of the factory
				p.getFactorys()[0].resetCooldown();
			}

			// check if the player has pressed the MouseButton2 and the cooldown of the
			// factory is 0
			if (Screen.MouseBut3 && (p.getFactorys()[1]).cooldownZero()) {
				// if it is generate a new Attack object and save it int the Attack ArrayList
				// get the attack form the 0th factory
				newAttacks.add(p.getAttack(1));
				// reset the cooldown of the factory
				p.getFactorys()[1].resetCooldown();
			}

			if (Screen.E && (p.getFactorys()[2]).cooldownZero()) {
				// if it is generate a new Attack object and save it int the Attack ArrayList
				// get the attack form the 0th factory
				newAttacks.add(p.getAttack(2));
				// reset the cooldown of the factory
				p.getFactorys()[2].resetCooldown();
			}

			if (Screen.Q && (p.getFactorys()[3]).cooldownZero()) {
				// if it is generate a new Attack object and save it int the Attack ArrayList
				// get the attack form the 0th factory
				newAttacks.add(p.getAttack(3));
				// reset the cooldown of the factory
				p.getFactorys()[3].resetCooldown();
			}

			// ------------------------------------------------------------------------------
			world.addAll(newAttacks);
			// for every Player

			for (Player currentP : ps) {
				Iterator<Attack> iter = world.iterator();
				// check if the player collieds with any Attack in the attack List(the world)
				while (iter.hasNext()) {
					Attack a = iter.next();
					// check if the current player touches the bullet
					if (a.touch(currentP.getX(), currentP.getY(), 50, 50)) {
						// if it does, than call the Collision function of the Attack and send the
						// current player
						a.onCollision(currentP);
					}

					// despawn Attacks if it's live is false
					// check if the attack is still alive if it is add it to the buffer world
					if (!a.isAlive()) {
						iter.remove();
					}
				}
			}

			// ------------------------------------------------------------------------------
			// update the cooldown of every Factory
			p.getFactorys()[0].addCooldown(-1);
			p.getFactorys()[1].addCooldown(-1);
			p.getFactorys()[2].addCooldown(-1);
			p.getFactorys()[3].addCooldown(-1);

			// ------------------------------------------------------------------------------
			// System.out.println(world.size());
			// ------------------------------------------------------------------------------
			// put data online
			// ------------------------------------------------------------------------------
			// repaint
			drawCount++;
			if (drawCount >= 16) {
				c.repaint();
				drawCount = 0;
			}
			System.out.println(world.size());

			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}

		}

	}

	private class Canvas extends JComponent {

		public void paintComponent(Graphics g) {

			// draw the players
			ps[0].draw(g);
			ps[1].draw(g);
			// draw the attacks
			for (int i = 0; i < world.size(); i++) {
				Attack a = world.get(i);
				if (a != null)
					a.draw(g);

			}

		}

	}

}
