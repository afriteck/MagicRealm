package models;

import java.util.ArrayList;
import java.util.LinkedList;

import natives.NativeGroup;

public class Captain extends Things {

	private static final String url = "captain.png";

	static Weapons weapon;
	private static LinkedList<Armor> myArsenal; // the characters arsenal
	private Armor myArmor1, myArmor2, myArmor3;
	private LinkedList<NativeGroup> hiredNatives;
	private NativeGroup hiredNative;
	private LinkedList<Weapons> myweapons; // the characters arsenal

	private ArrayList<Counters> readyCounter;
	private ArrayList<Counters> fatiguedCounter;

	public Captain() {
		setUrl(url);
		setName("Captain");
		weapon = new ShortSword();
		myweapons = new LinkedList<Weapons>();

		setWeapon(weapon);

		myArsenal = new LinkedList<Armor>();
		myArmor1 = new Helmet();
		myArmor2 = new BreastPlates();
		myArmor3 = new Shields();
		hiredNatives = new LinkedList<NativeGroup>();
		hiredNative = new NativeGroup();
		fatiguedCounter = new ArrayList<Counters>();
		readyCounter = new ArrayList<Counters>();

		setHiredNatives(hiredNatives);
		setHiredNative(hiredNative);
		setMyweapons(myweapons);
		setAlert(false);

		if (weapon.getSpeed() < 1)
			weapon.setSpeed(4);
		setGold(10);
		setSpeed(4);
		setPlayerArmoury(myArsenal);

		addArmor(myArmor1);
		addArmor(myArmor2);
		addArmor(myArmor3);
		myweapons.add(weapon);

		setVisibility(true);

		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 5, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 5, 1));

		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 5, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 2));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 3, 2));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 5, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 6, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));

	}

	public static void main(String[] args) {

		Things sm = new Captain();
		System.out.println(sm.getWeapons().getName() + sm.getGold()
				+ sm.getSpeed() + sm.getWeapons().getSharpness()
				+ sm.getWeapons().getSpeed());
	}

}
