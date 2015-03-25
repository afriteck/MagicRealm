package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Shields;
import models.Spear;
import models.Weapons;

public class Pikeman extends Native {

	private static Weapons weapon;
	private static LinkedList<Armor> nativeArsenal; // the characters arsenal
	private Armor armor;

	public Pikeman() {

		setName("Pikeman");
		weapon = new Spear();
		armor = new Shields();
		nativeArsenal = new LinkedList<Armor>();
		setNativeArsenal(nativeArsenal);
		nativeArsenal.add(armor);
		setStrikeWeight(DamageEnum.MEDIUM);
		setWage(2);
		setNotoriety(3);
		setWeapon(weapon);

	}

}
