package lauchfight.attacks;

import lauchfight.Attack;
import lauchfight.AttackFactory;
import lauchfight.Player;

public class TestFactory extends AttackFactory{
    
    private long COOLDOWN = 1000;

    @Override
    public Attack createNew(Player p, int mouseX, int mouseY) {
        //restet the cooldown
        this.setCoolDown(COOLDOWN);
        //return a new attack
        return new Test(p,mouseX,mouseY);
    }
    
    @Override
    public void updateCoolDown() {
        if(this.getCoolDown() > 0) this.setCoolDown(this.getCoolDown()-1);
    }
    
    public TestFactory(){}

    
    
}
