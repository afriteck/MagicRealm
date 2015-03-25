package models;

public class Weapons {

	private DamageEnum damage;
	private String name;
	private int speed;
	private int sharpness;
	private Things owner;
	private boolean ready = false;
	private int readySpeed;
	private int readySharpness;
	private int weaponLength;
	private boolean missile = false;
	private int hands;
	private int price;

	private DamageEnum readyDamage;

	public DamageEnum getDamage() {
		// damage = new DamageEnum();
		checkReady();
		if (!ready) {
			// setDamage(damage);
			return damage;

		} else {
			// setDamage(readyDamage);
			return readyDamage;

		}
	}

	public int getSpeed() {
		checkReady();
		if (!ready)
			return speed;
		else
			return readySpeed;
	}

	public int getSharpness() {
		checkReady();
		if (!ready)
			return sharpness;
		else
			return readySharpness;
	}

	public String getName() {
		return name;
	}

	public void setName(String myname) {
		this.name = myname;
	}

	public void setDamage(DamageEnum dam) {
		this.damage = dam;
	}

	public void setSpeed(int spd) {

		this.speed = spd;
	}

	public boolean getReady() {
		return ready;
	}

	public void setReadySpeed(int rdspd) {

		this.readySpeed = rdspd;
	}

	public void setReadyDamage(DamageEnum rddmg) {

		this.readyDamage = rddmg;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void setSharpness(int sharp) {
		this.sharpness = sharp;
	}

	public void setReadySharpness(int sharp) {
		this.readySharpness = sharp;
	}

	public int getLength() {

		return weaponLength;
	}

	public int getHands() {

		return hands;
	}

	public int getPrice() {

		return price;
	}

	public void setHands(int hnd) {
		this.hands = hnd;
	}

	public void setPrice(int prc) {
		this.price = prc;
	}

	public void setLength(int len) {
		this.weaponLength = len;
	}

	public void setMissile(boolean foo) {
		missile = foo;
	}

	public void checkReady() {
		// if whatever setReady true
		// else setReady false;

	}

}
