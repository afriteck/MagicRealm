package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Captain extends Things {

	static Weapons weapon ;
	 private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
		private Armor myArmor1, myArmor2, myArmor3;
		private LinkedList<NativeGroup> hiredNatives;
	    private NativeGroup hiredNative;




	public Captain(){
		setName("Captain");
		weapon = new ShortSword();
		setWeapon(weapon);
		
		myArsenal = new LinkedList<Armor>();
		myArmor1 = new Helmet();
		myArmor2 = new BreastPlates();
		myArmor3 = new Shields();
		hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
		
		
		if(weapon.getSpeed() < 1)
			weapon.setSpeed(4);
		setGold(10);
		setSpeed(4);
		setPlayerArmoury(myArsenal);

		addArmor(myArmor1);
		addArmor(myArmor2);
		addArmor(myArmor3);
	
	}

public static void main(String[] args){
		
		Things sm = new Captain();
		System.out.println(sm.getWeapons().getName() + sm.getGold() + sm.getSpeed() + sm.getWeapons().getSharpness()+ sm.getWeapons().getSpeed());
	}


}
