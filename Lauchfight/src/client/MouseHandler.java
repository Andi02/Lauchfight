package client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {
        
        Screen.MouseX = me.getX();
        Screen.MouseY = me.getY();
        if(me.getButton() == MouseEvent.BUTTON3){
        	
            Screen.MouseBut2 = true;
        }
        if (me.getButton() == MouseEvent.BUTTON1){

            Screen.MouseBut1 = true;
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1){
            Screen.MouseBut1 = false;
        }else if(me.getButton() == MouseEvent.BUTTON3){
            Screen.MouseBut2 = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    
}
