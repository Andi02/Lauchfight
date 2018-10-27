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
        g.setColor(Color.getHSBColor(getR(), getG(), getB()));
        g.fillRect((int)getXPos(),(int) getYPos(), getHitBoxWidth(), getHitBoxHeight());
    }
    
}
