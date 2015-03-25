package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Spear;
import models.Weapons;

public class Lancer extends Native {

	private static Weapons weapon;
	private static LinkedList<Armor> nativeArsenal; // the characters arsenal

	public Lancer() {

		setName("Lancer");
		weapon = new Spear();
		setStrikeWeight(DamageEnum.LIGHT);
		setWage(2);
		setNotoriety(4);
		setWeapon(weapon);

		nativeArsenal = new LinkedList<Armor>();
		setNativeArsenal(nativeArsenal);

	}

}
