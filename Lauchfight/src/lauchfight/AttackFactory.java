package lauchfight;

public abstract class AttackFactory {
    
    //time until the AttackFactory can create a new Attack
    private long coolDown;

    public long getCoolDown() {
        return coolDown;
    }
    
    public void setCoolDown(long coolDown) {
        this.coolDown = coolDown;
    }
    
    //to create a new attack
    //p = the Player that created the attack
    public abstract Attack createNew(Player p,int mouseX,int mouseY);
    
    
    //update the cooldown (is diffrent in each factory)
    public abstract void updateCoolDown();
    
}
