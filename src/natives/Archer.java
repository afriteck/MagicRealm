package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.LightBow;
import models.Weapons;

public class Archer extends Native {

	private static Weapons weapon;
	private LinkedList<Armor> nativeArsenal;

	public Archer() {

		setName("Archer");
		weapon = new LightBow();
		setStrikeWeight(DamageEnum.MEDIUM);
		setWage(2);
		setNotoriety(4);
		setWeapon(weapon);

		nativeArsenal = new LinkedList<Armor>();
		setNativeArsenal(nativeArsenal);

	}

}
