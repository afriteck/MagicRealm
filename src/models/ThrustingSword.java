package models;

public class ThrustingSword extends Weapons {

	public ThrustingSword() {

		setName("Thrusting Sword");
		setDamage(DamageEnum.LIGHT);
		setReadyDamage(DamageEnum.LIGHT);
		setSharpness(1);
		setReadySpeed(0);
		setReadySharpness(1);
		setSpeed(4);
		setLength(4);
		setPrice(6);
		setHands(1);
		setMissile(false);

	}

}
