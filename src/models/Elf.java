package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Elf extends Things{
	static Weapons weapon ;
	private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2, myArmor3;
	private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private LinkedList<Weapons> myweapons;    // the chatacters arsenal



	public Elf(){
		setName("Elf");
		weapon = new LightBow();
		myArsenal = new LinkedList<Armor>();
		hiredNatives =  new LinkedList<NativeGroup>();
		myweapons = new  LinkedList<Weapons>();

	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
	    setMyweapons(myweapons);
		setAlert(false);

		
		
		setWeapon(weapon);
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(4);
		
		weapon.setReadySharpness(1);
		weapon.setReadySpeed(3);
		setGold(10);
		setSpeed(4);
	
		setPlayerArmoury(myArsenal);
		myweapons.add(weapon);

		setVisibility(true);

	
	}


}
