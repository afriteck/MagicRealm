package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.GreatAxe;
import models.Weapons;

public class GreatAxeman extends Native {

	private static Weapons weapon;
	private static LinkedList<Armor> nativeArsenal; // the characters arsenal

	public GreatAxeman() {

		setName("Great Axeman");
		weapon = new GreatAxe();
		setStrikeWeight(DamageEnum.HEAVY);
		setWage(4);
		setNotoriety(6);
		setWeapon(weapon);

		nativeArsenal = new LinkedList<Armor>();
		setNativeArsenal(nativeArsenal);

	}

}
