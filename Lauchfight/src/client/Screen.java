package client;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class Screen extends JFrame{
    
    
    public static boolean W = false;
    public static boolean A = false;
    public static boolean S = false;
    public static boolean D = false;
    public static boolean  MouseBut1 = false;
    public static boolean  MouseBut2 = false;
    
    public static int MouseX = 0;
    public static int MouseY = 0;

    
    public Screen(int width, int height,String title){
        
        this.setSize(width,height);
        
        this.setTitle(title);
        
        this.setResizable(false);
        
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.setVisible(true);
        
    }
    
    public void setCanvas(JComponent canvas){
        
        
        this.getContentPane().add(canvas);
    }
    
    public void setKeyListener(KeyListener listener){
    
        this.addKeyListener(listener);
    
    }
    
    public void setMouseListener(MouseListener listener){
        
        this.addMouseListener(listener);
    
    }
    public void setJPanel(JPanel panel){
    
        this.add(panel);
    
    }
    
}
