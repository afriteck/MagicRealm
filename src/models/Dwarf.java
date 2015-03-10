package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Dwarf extends Things{

	static Weapons weapon ;
	private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1;
	private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;



	public Dwarf(){
		setName("Dwarf");
		weapon = new GreatAxe();
		myArsenal = new LinkedList<Armor>();
		myArmor1 = new Helmet();
		hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
		
	    setWeapon(weapon);						
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(5);
		
		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(5);
		setPlayerArmoury(myArsenal);
	
		addArmor(myArmor1);

	
	}


}
