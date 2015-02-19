package models;

import java.util.LinkedList;

public class Swordsman extends Things {

	static Weapons weapon ;
    private static LinkedList<Armor> myArsenal;    // the chatacters arsenal


	public Swordsman(){
		setName("Swordsman");
		weapon = new ThrustingSword();
		setWeapon(weapon);
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(2);
		
		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(2);
		setPlayerArmoury(myArsenal);

	
	}


}
