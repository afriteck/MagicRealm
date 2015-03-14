package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class BlackKnight extends Things {

	Weapons weapon;
	 private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2;
	private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private LinkedList<Weapons> myweapons;    // the chatacters arsenal

	
	public BlackKnight(){
		
		setName("Black Knight");
	
		weapon = new Mace();
		myweapons = new  LinkedList<Weapons>();

		setWeapon(weapon);
		
		myArsenal = new LinkedList<Armor>();
		myArmor1 = new Shields();
		myArmor2 = new SuitsOfArmor();
		hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
	    setMyweapons(myweapons);

		
		setGold(10);
		if(weapon.getSpeed() < 1)
			weapon.setSpeed(3);
		setSpeed(3);
		setPlayerArmoury(myArsenal);
		setAlert(false);


		addArmor(myArmor1);
		addArmor(myArmor2);
		myweapons.add(weapon);

		setVisibility(true);

	
	}

public static void main(String[] args){
		
		Things sm = new BlackKnight();
		System.out.println(sm.getWeapons().getName() + sm.getGold() + sm.getSpeed() + sm.getWeapons().getSharpness()+ sm.getWeapons().getSpeed());
	
		for(int i = 0 ; i < myArsenal.size(); i++){
	    	System.out.println(sm.getName() + " has the following armor " + sm.getCharacterArmory().get(i).getName() + sm.getCharacterArmory().get(i).isDamaged() + sm.getCharacterArmory().get(i).isDestroyed());
	    
		}

}

}
