package lauchfight;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

    private double x;

    private double y;

    private AttackFactory[] factorys;

    private long life;

    public float speed = 0.1f;

    public float getSpeed() {
        return speed;
    }

    private int id;

    // constructor
    public Player(AttackFactory[] factorys, double x, double y, long life, float speed, int id) {

        this.factorys = factorys;

        this.x = x;
        this.y = y;

        this.life = life;

        this.speed = speed;

        this.id = id;

    }

    public AttackFactory[] getFactorys() {
        return factorys;
    }

    public void setFactorys(AttackFactory[] factorys) {
        this.factorys = factorys;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addY(double a) {
        if (this.y + a * speed > 0 && this.y + a * speed < 500 - 80)
            this.y = y + speed * a;
    }

    public void addX(double a) {
        if (this.x + a * speed > 0 && this.x + a * speed < 500 - 50)
            this.x = x + speed * a;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public long getLife() {
        return life;
    }

    public void setLife(long life) {
        this.life = life;
    }

    public void addLife(long life) {
        this.life += life;
    }

    public Attack getAttack(int a) {
        return factorys[a].create(this);
    }

    public Graphics draw(Graphics g) {
        // draw the player


//     if(life <= 0) {
//            this.x=100;
//            this.y=100;
//            setSpeed(0.0f);
//        }

        g.fillRect((int) x, (int) y, 50, 50);

        return g;
    }

}