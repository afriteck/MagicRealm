package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Shields;
import models.ShortSword;
import models.Weapons;

public class ShortSwordsman extends Native {

	private static Weapons weapon;
	private LinkedList<Armor> nativeArsenal; // the characters arsenal
	private Armor armor;

	public ShortSwordsman() {

		setName("Short SwordsMan");
		weapon = new ShortSword();
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
