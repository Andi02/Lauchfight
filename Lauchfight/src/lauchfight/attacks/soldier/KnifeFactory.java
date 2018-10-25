package lauchfight.attacks.soldier;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;


public class KnifeFactory extends AttackFactory{
    
    private long COOLDOWN = 5000;
    private long cooldownCounter = 5000;

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
    
    public KnifeFactory(){}


    @Override
    public Attack create(Player pSend) {
        return new Knife(pSend);
    }

    
    
}
