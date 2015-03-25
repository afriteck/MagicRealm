package models;

import java.util.ArrayList;
import java.util.LinkedList;

import natives.NativeGroup;

public class Swordsman extends Things {

	private static final String url = "swordsman.png";

	static Weapons weapon;
	private static LinkedList<Armor> myArsenal; // the characters arsenal
	private LinkedList<NativeGroup> hiredNatives;
	private NativeGroup hiredNative;
	private LinkedList<Weapons> myweapons; // the characters arsenal

	private ArrayList<Counters> readyCounter;
	private ArrayList<Counters> fatiguedCounter;

	public Swordsman() {
		setUrl(url);
		setName("Swordsman");
		weapon = new ThrustingSword();
		hiredNatives = new LinkedList<NativeGroup>();
		myweapons = new LinkedList<Weapons>();

		hiredNative = new NativeGroup();
		fatiguedCounter = new ArrayList<Counters>();
		readyCounter = new ArrayList<Counters>();
		setHiredNatives(hiredNatives);
		setHiredNative(hiredNative);
		setWeapon(weapon);
		setMyweapons(myweapons);

		if (weapon.getSpeed() < 1)
			weapon.setSpeed(2);

		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(2);
		setPlayerArmoury(myArsenal);
		setAlert(false);

		myweapons.add(weapon);

		setVisibility(true);

		readyCounter.add(new Counters("MOVE", DamageEnum.LIGHT, 4, 0));
		readyCounter.add(new Counters("MOVE", DamageEnum.LIGHT, 3, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.LIGHT, 3, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.LIGHT, 3, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.LIGHT, 2, 2));
		readyCounter.add(new Counters("MOVE", DamageEnum.LIGHT, 2, 2));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 2));
		readyCounter.add(new Counters("FIGHT", DamageEnum.LIGHT, 4, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 5, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.LIGHT, 2, 2));

		setReadyCounter(readyCounter);
		setFatiguedCounter(fatiguedCounter);

	}

}
