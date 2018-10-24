package lauchfight;

public abstract class AttackFactory {
    
    public abstract Attack create(Player pSend);
    
    public abstract boolean cooldownZero();
    public abstract void addCooldown(long a);
    public abstract void resetCooldown();

}
