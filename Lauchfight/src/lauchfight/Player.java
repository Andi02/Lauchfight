package lauchfight;

import java.util.ArrayList;


public class Player extends Object{
    
    
    //the health of the Player
    private int health;
    
    //the speed of the Player
    private double speed;
    


    //Attacks
    ArrayList<AttackFactory> attackFactorys = new ArrayList();
    
    
    //Effects
    
    
    //setters/getters/adders

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public void addHealth(int val) {
        setHealth(getHealth()+val);
    }
    
    @Override
	public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void addAttackFactory(AttackFactory a){
        attackFactorys.add(a);
    }
    
    public Player(double speed){
        this.speed = speed;
    }
    
    public AttackFactory getFactory(int in){
        return attackFactorys.get(in);
    }
    
    
    
    
    
    //create a new Attack
    public Attack useAttack(int index,int mouseX, int mouseY){
        return attackFactorys.get(index).createNew(this,mouseX,mouseY);
    }

    @Override
    public void update() {
        
        //update the coolDown of every Attack
        attackFactorys.forEach((a) -> {
            a.updateCoolDown();
        });
        
        
    }

    
    
    
    
}
