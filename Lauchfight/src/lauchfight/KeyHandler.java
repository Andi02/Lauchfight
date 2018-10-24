package lauchfight;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			Screen.W = true;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			Screen.A = true;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			Screen.S = true;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			Screen.D = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_E) {
			Screen.E = true;
			Screen.MouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
			Screen.MouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
		}

		if (e.getKeyCode() == KeyEvent.VK_Q) {
			Screen.Q = true;
			Screen.MouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
			Screen.MouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_W) {
			Screen.W = false;
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			Screen.A = false;
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			Screen.S = false;
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			Screen.D = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_E) {
			Screen.E = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_Q) {
			Screen.Q = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
