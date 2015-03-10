package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Swordsman extends Things {

	static Weapons weapon ;
    private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
    private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;


	public Swordsman(){
		setName("Swordsman");
		weapon = new ThrustingSword();
		hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
		setWeapon(weapon);
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(2);
		
		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(2);
		setPlayerArmoury(myArsenal);

	
	}


}
