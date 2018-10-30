package lauchfight;

public abstract class Effect {
	
	private boolean active = true;
	
	public abstract void useEffectOn(Player pToUseOn);

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
