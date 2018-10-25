package lauchfight;

import java.util.List;

public class AttackRegistry {
	private List<Attack> attacks;

	public AttackRegistry(List<Attack> addF) {
		this.attacks = addF;
	}

	public void setNewAttacks(Attack attackFromFactory) {
		this.attacks.add(attackFromFactory);
	}

}
