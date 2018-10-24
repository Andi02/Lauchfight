package lauchfight.attacks;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;


public class PistolFactory extends AttackFactory{
    
    private long COOLDOWN = 500;
    private long cooldownCounter = 500;

    public void addCooldown(long a){
        if (cooldownCounter > 0) cooldownCounter += a;
    }
   
    public boolean cooldownZero(){
        if (cooldownCounter == 0) return true;
        return false;    
    }
    
    @Override
    public void resetCooldown() {
        cooldownCounter = COOLDOWN;
    }
    
    public PistolFactory(){}


    @Override
    public Attack create(Player pSend) {
        return new Pistol(pSend);
    }

    
    
}
