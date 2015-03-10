package models;

import java.util.LinkedList;

import natives.NativeGroup;

public class Amazon extends Things{

	static Weapons weapon ;
    private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2, myArmor3;
	private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;




	public Amazon(){
		weapon = new ShortSword();
		myArsenal = new LinkedList<Armor>();
		myArmor1 = new Helmet();
		myArmor2 = new BreastPlates();
		myArmor3 = new Shields();
	    hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);

		
		setWeapon(weapon);
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(3);
		setName("Amazon");
		setGold(10);
		setSpeed(3);
		setPlayerArmoury(myArsenal);

		
		addArmor(myArmor1);
		addArmor(myArmor2);
		addArmor(myArmor3);


		
	}

	
	public static void main(String[] args){
		
		Things sm = new Amazon();
		System.out.println(sm.getWeapons().getName() + sm.getGold() + sm.getSpeed() + sm.getWeapons().getSharpness()+ sm.getWeapons().getSpeed());
	
		for(int i = 0 ; i < myArsenal.size(); i++){
	    	System.out.println(sm.getName() + " has the following armor " + sm.getCharacterArmory().get(i).getName() + sm.getCharacterArmory().get(i).isDamaged() + sm.getCharacterArmory().get(i).isDestroyed());
	    
		}
	}
	


}
