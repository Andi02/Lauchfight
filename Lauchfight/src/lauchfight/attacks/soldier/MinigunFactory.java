package LauchFightOnline.attacks.soldier;


public class MinigunFactory extends AttackFactory{
    
    private long COOLDOWN = 1000;
    private long cooldownCounter = 1000;

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
    
    public MinigunFactory(){}


    @Override
    public Attack create(Player pSend) {
        return new Minigun(pSend);
    }

    
    
}
