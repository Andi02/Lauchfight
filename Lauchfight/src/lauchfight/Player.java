package lauchfight;

import java.util.ArrayList;


public class Player extends Object{
    
    
    //the health of the Player
    private int health;

    //Attacks
    ArrayList<AttackFactory> attackFactorys = new ArrayList<AttackFactory>();
    
    
    //Effects
    
    
    //setters/getters/adders

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
    	//if the health is 0 kill him
        this.health = health;
        if(health <= 0) {
        	setVisible(false);
        }
    }
    
    public void addHealth(int val) {
        setHealth(getHealth()+val);
    }
    public void addAttackFactory(AttackFactory a){
        attackFactorys.add(a);
    }
    
    public AttackFactory getFactory(int in){
        return attackFactorys.get(in);
    }


    
    public Player(double speed){
        this.setSpeed(speed);
        setVisible(true);
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
