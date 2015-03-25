package models;

public class BroadSword extends Weapons {

	public BroadSword() {

		setName("BroadSword");
		setDamage(DamageEnum.MEDIUM);
		setReadyDamage(DamageEnum.MEDIUM);
		setSharpness(1);
		setSpeed(5);
		setReadySpeed(0);
		setReadySharpness(1);
		setLength(7);
		setPrice(8);
		setHands(1);
		setMissile(false);
		// setReady(true);
	}

}
