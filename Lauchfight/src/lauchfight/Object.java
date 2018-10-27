package lauchfight;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Object {

    public double xPos;
    public double yPos;

    //the Hit Box
    private int hitBoxWidth = 10;
    private int hitBoxHeight = 10;

    private int r;
    private int g;
    private int b;

    private String shape;

    private boolean alive;

    private double speed;

    public Object(int x, int y, int w, int h, int r, int g, int b, String s) {
        xPos = x;
        yPos = y;
        hitBoxWidth = w;
        hitBoxHeight = h;
        this.r = r;
        this.g = g;
        this.b = b;
        shape = s;
    }

    public Object(String s) {
        this.fromString(s);
    }

    public Object() {
        //set deafult
        xPos = 0;
        yPos = 0;
        this.r = 255;
        this.g = 255;
        this.b = 255;
        shape = "rect";
        alive = true;
    }

    public double getXPos() {
        return xPos;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    public int getHitBoxWidth() {
        return hitBoxWidth;
    }

    public void setHitBoxWidth(int hitBoxWidth) {
        this.hitBoxWidth = hitBoxWidth;
    }

    public int getHitBoxHeight() {
        return hitBoxHeight;
    }

    public void setHitBoxHeight(int hitBoxHeight) {
        this.hitBoxHeight = hitBoxHeight;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getR() {
        return r;
    }

    public int getB() {
        return b;
    }

    public int getG() {
        return g;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //move the object in the X dir
    public void addXPos(double val) {
        setXPos(getXPos() + val * getSpeed());
    }

    //move the object in the Y dir
    public void addYPos(double val) {
        setYPos(getYPos() + val * getSpeed());
    }

    //takes all parameters and returns them in a String seperatet by a " "
    @Override
    public String toString() {
        String ret = "";
        ret += xPos;
        ret += " " + yPos;
        ret += " " + hitBoxWidth;
        ret += " " + hitBoxHeight;
        ret += " " + r;
        ret += " " + g;
        ret += " " + b;
        ret += " " + shape;
        return ret;
    }

    //create a Object from a string
    public void fromString(String t) {
        String[] a = t.split(" ");
        xPos = Double.valueOf(a[0]);
        yPos = Double.valueOf(a[1]);
        hitBoxWidth = Integer.valueOf(a[2]);
        hitBoxHeight = Integer.valueOf(a[3]);
        this.r = Integer.valueOf(a[4]);
        this.g = Integer.valueOf(a[5]);
        this.b = Integer.valueOf(a[6]);
        shape = a[7];
    }

    //update physics
    public abstract void update();

    public void draw(Graphics g) {
        g.setColor(Color.getHSBColor(getR(), getG(), getB()));
        g.fillRect((int) getXPos(), (int) getYPos(), getHitBoxWidth(), getHitBoxHeight());
    }

}
