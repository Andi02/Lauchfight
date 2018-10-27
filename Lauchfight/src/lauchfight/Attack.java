package lauchfight;



public abstract class Attack extends Object {

	//setters and getters
    private Player p;

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }
    
    //if the attack collieds with a Player
    public abstract void onCollision(Player col);

    
}
