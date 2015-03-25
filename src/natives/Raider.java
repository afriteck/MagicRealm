package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.ShortSword;
import models.Weapons;

public class Raider extends Native {

	private static Weapons weapon;
	private static LinkedList<Armor> nativeArsenal; // the characters arsenal

	public Raider() {

		setName("Raider");
		weapon = new ShortSword();
		setStrikeWeight(DamageEnum.LIGHT);
		setWage(2);
		setNotoriety(4);
		setWeapon(weapon);

		nativeArsenal = new LinkedList<Armor>();
		setNativeArsenal(nativeArsenal);

	}

}
