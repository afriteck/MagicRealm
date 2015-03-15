package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Dwarf extends Things{
	
	private static final String url = "dwarf.png";

	static Weapons weapon ;
	private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1;
	private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private LinkedList<Weapons> myweapons;    // the chatacters arsenal



	public Dwarf(){
		setUrl(url);
		setName("Dwarf");
		weapon = new GreatAxe();
		myArsenal = new LinkedList<Armor>();
		myweapons = new  LinkedList<Weapons>();

		myArmor1 = new Helmet();
		hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
	    setMyweapons(myweapons);
		setAlert(false);


		
	    setWeapon(weapon);						
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(5);
		
		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(5);
		setPlayerArmoury(myArsenal);
	
		addArmor(myArmor1);
		myweapons.add(weapon);

		setVisibility(true);


	
	}


}
