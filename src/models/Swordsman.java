package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Swordsman extends Things {

	private static final String url = "swordsman.png";
	
	static Weapons weapon ;
    private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
    private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private LinkedList<Weapons> myweapons;    // the chatacters arsenal

    


	public Swordsman(){
		setUrl(url);
		setName("Swordsman");
		weapon = new ThrustingSword();
		hiredNatives =  new LinkedList<NativeGroup>();
		myweapons = new  LinkedList<Weapons>();

	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
		setWeapon(weapon);
	    setMyweapons(myweapons);

		if(weapon.getSpeed() < 1)
		weapon.setSpeed(2);
		
		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(2);
		setPlayerArmoury(myArsenal);
		setAlert(false);

		myweapons.add(weapon);

		setVisibility(true);


	
	}


}
