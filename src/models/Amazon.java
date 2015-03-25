package models;

import java.util.ArrayList;
import java.util.LinkedList;

import natives.NativeGroup;

public class Amazon extends Things {

	private static final String url = "amazon.png";

	static Weapons weapon;
	private static LinkedList<Armor> myArsenal; // the characters arsenal
	private Armor myArmor1, myArmor2, myArmor3;
	private LinkedList<NativeGroup> hiredNatives;
	private LinkedList<Weapons> myweapons; // the characters arsenal

	private NativeGroup hiredNative;

	private ArrayList<Counters> readyCounter;
	private ArrayList<Counters> fatiguedCounter;

	public Amazon() {
		setUrl(url);

		setName("Amazon");

		weapon = new ShortSword();
		myweapons = new LinkedList<Weapons>();
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

		setWeapon(weapon);
		if (weapon.getSpeed() < 1)
			weapon.setSpeed(3);
		setName("Amazon");
		setGold(10);
		setSpeed(3);
		setPlayerArmoury(myArsenal);
		setAlert(false);

		addArmor(myArmor1);
		addArmor(myArmor2);
		addArmor(myArmor3);
		myweapons.add(weapon);
		setVisibility(true);

		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 0));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 3, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.LIGHT, 4, 0));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 5, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 3, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 2));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 4, 2));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 2));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 1));

		setReadyCounter(readyCounter);
		setFatiguedCounter(fatiguedCounter);

	}

	/*
	 * public static void main(String[] args){
	 * 
	 * Things sm = new Amazon(); System.out.println(sm.getWeapons().getName() +
	 * sm.getGold() + sm.getSpeed() + sm.getWeapons().getSharpness()+
	 * sm.getWeapons().getSpeed());
	 * 
	 * for(int i = 0 ; i < myArsenal.size(); i++){
	 * System.out.println(sm.getName() + " has the following armor " +
	 * sm.getCharacterArmory().get(i).getName() +
	 * sm.getCharacterArmory().get(i).isDamaged() +
	 * sm.getCharacterArmory().get(i).isDestroyed());
	 * 
	 * } }
	 */

}
