package models;

public class Helmet extends Armor {

	public Helmet() {

		setName("Helmet");
		setDamage(isDamaged());
		setDestroyed(isDestroyed());
		setDamageLevel(DamageEnum.MEDIUM);
		setIntactPrice(5);
		setDamagedPrice(3);
		setDestroyedPrice(0);

	}
}
