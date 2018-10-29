package client;

import java.awt.Color;
import java.awt.Graphics;
import lauchfight.Object;


public class FixObject extends Object{
    
    public FixObject(int x,int y,int w,int h,int r,int g,int b,String s){
        super(x,y,w,h,r,g,b,s);
    }
    
    public FixObject(String s){
        super(s);
    }

    @Override
    public void update() {}
    
    @Override
	public void draw(Graphics g){
    	float[] col = Color.RGBtoHSB(getR(),  getG(), getB(), null);
        g.setColor(Color.getHSBColor(col[0], col[1], col[2]));
        g.fillRect((int)getXPos(),(int) getYPos(), getHitBoxWidth(), getHitBoxHeight());
    }
    
}
