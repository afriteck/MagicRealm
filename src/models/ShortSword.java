package models;

public class ShortSword extends Weapons {

	public ShortSword() {

		setName("Short Sword");
		setDamage(DamageEnum.LIGHT);
		setReadyDamage(DamageEnum.MEDIUM);
		// setSpeed(7);
		setSharpness(1);
		setReadySharpness(1);
		setLength(3);
		setPrice(4);
		setHands(1);
		setMissile(false);
	}

	public static void main(String[] args) {

		ShortSword ss = new ShortSword();
		System.out.println(ss.getSpeed() + "\n " + ss.getDamage().toString()
				+ ss.getSharpness() + ss.getHands() + ss.getLength()
				+ ss.getPrice() + ss.getReady());

	}

}
