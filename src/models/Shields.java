package models;

public class Shields extends Armor {

	public Shields() {
		setName("Shields");
		setDamage(isDamaged());
		setDestroyed(isDestroyed());
		setDamageLevel(DamageEnum.MEDIUM);
		setIntactPrice(7);
		setDamagedPrice(5);
		setDestroyedPrice(0);

	}

}
