package client;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;
import lauchfight.*;
import lauchfight.Object;


public class Client {

    public static void main(String[] args) {
        new Client().core();
    } 

    //the list of objects to draw
    public static ArrayList<FixObject> obs = new ArrayList<FixObject>();

    public static int screenX = 1600;
    public static int screenY = 1080;
    
    public static int player = 1;

    public Canvas c;

    public void core() {
        //create the Canvas
        c = new Canvas();

        //create the Screen
        Screen s = new Screen(screenX, screenY, "hallo");

        s.setCanvas(c);

        //add the KeyHandler
        s.setKeyListener(new KeyHandler());

        //add the MouseHandler
        s.setMouseListener(new MouseHandler());
        
        //start the input Thread
        InputThread in = new InputThread();
        in.start();
        
        gameLoop();
    }

    public void gameLoop() {

        while(true) {
        	c.repaint();
        	
        	try {
        		Thread.sleep(16);
        	}catch(Exception e) {}
        }

    }

    private class Canvas extends JComponent {

        @Override
		public void paintComponent(Graphics g) {
        	super.paintComponent(g);  
        	
        	//fix the list of objects
        	ArrayList<FixObject> fixObs = obs;

            for (int i = 0; i < fixObs.size(); i++) {
                FixObject a = fixObs.get(i);
                if (a != null) {
                	fixObs.get(i).draw(g);
                }
            }

        }

    }

}
