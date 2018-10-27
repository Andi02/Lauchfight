package client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
       if (ke.getKeyCode() == KeyEvent.VK_A) {
            Screen.A = true;
        } else if (ke.getKeyCode() == KeyEvent.VK_W) {
            Screen.W = true;
        } else if (ke.getKeyCode() == KeyEvent.VK_D) {
            Screen.D = true;
        } else if (ke.getKeyCode() == KeyEvent.VK_S) {
            Screen.S = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            Screen.A = false;
        } else if (ke.getKeyCode() == KeyEvent.VK_W) {
            Screen.W = false;
        } else if (ke.getKeyCode() == KeyEvent.VK_D) {
            Screen.D = false;
        } else if (ke.getKeyCode() == KeyEvent.VK_S) {
            Screen.S = false;
        }
    }
    
    
    
    
}
