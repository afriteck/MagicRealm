package models;

public class LightBow extends Weapons {

	public LightBow() {

		setName("Light Bow");
		setDamage(DamageEnum.LIGHT);
		setReadyDamage(DamageEnum.LIGHT);
		setSharpness(0);
		setReadySpeed(1);
		setReadySharpness(2);
		setLength(14);
		setPrice(6);
		setHands(2);
		setMissile(true);

	}

}
