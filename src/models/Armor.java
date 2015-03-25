package models;

public class Armor {

	private boolean damaged = false;
	private String name;
	private int damageCounter;
	private boolean destroyed = false;
	private DamageEnum damageLevel;
	private int intactPrice;
	private int damagedPrice;
	private int destroyedPrice;

	public boolean isDamaged() {
		// checkDamage();
		return damaged;
	}

	public boolean isDestroyed() {
		// checkDamage();
		if (damageCounter == 2)
			destroyed = true;
		else
			destroyed = false;
		return destroyed;

	}

	public void setDamage(boolean dmg) {
		this.damaged = dmg;
	}

	public void setDestroyed(boolean dst) {
		this.destroyed = dst;
	}

	public String getName() {
		return name;
	}

	public void setName(String nm) {
		this.name = nm;
	}

	public void checkDamage() {
		// if it is damaged, then damaged = true
		damageCounter++;
		// else damage = false

	}

	public DamageEnum getDamage() {
		return damageLevel;
	}

	public void setDamageLevel(DamageEnum dam) {
		this.damageLevel = dam;
	}

	public int getIntactPrice() {
		return intactPrice;
	}

	public void setIntactPrice(int intactPrice) {
		this.intactPrice = intactPrice;
	}

	public int getDamagedPrice() {
		return damagedPrice;
	}

	public void setDamagedPrice(int damagedPrice) {
		this.damagedPrice = damagedPrice;
	}

	public int getDestroyedPrice() {
		return destroyedPrice;
	}

	public void setDestroyedPrice(int destroyedPrice) {
		this.destroyedPrice = destroyedPrice;
	}

}
