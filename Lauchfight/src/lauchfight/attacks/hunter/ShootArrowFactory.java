package lauchfight.attacks.hunter;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;


public class ShootArrowFactory extends AttackFactory{
    
    private long COOLDOWN = 10;
    private long cooldownCounter = 10;

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
    
    public ShootArrowFactory(){}


    @Override
    public Attack create(Player pSend) {
        return new ShootArrow(pSend);
    }

    
    
}
