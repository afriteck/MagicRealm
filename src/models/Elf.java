package models;

import java.util.LinkedList;

public class Elf extends Things{
	static Weapons weapon ;
	private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2, myArmor3;


	public Elf(){
		setName("Elf");
		weapon = new LightBow();
		myArsenal = new LinkedList<Armor>();
		
		
		setWeapon(weapon);
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(4);
		
		weapon.setReadySharpness(1);
		weapon.setReadySpeed(3);
		setGold(10);
		setSpeed(4);
	
		setPlayerArmoury(myArsenal);
	
	}


}
