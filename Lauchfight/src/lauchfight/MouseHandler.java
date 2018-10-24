package lauchfight;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {
			Screen.MouseBut1 = true;
		}

		if (e.getButton() == MouseEvent.BUTTON2) {
			Screen.MouseBut3 = true;
		}
		
		Screen.MouseX = e.getX();
		Screen.MouseY = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {
			Screen.MouseBut1 = false;
		}

		if (e.getButton() == MouseEvent.BUTTON2) {
			Screen.MouseBut3 = false;
		}

	}

}
