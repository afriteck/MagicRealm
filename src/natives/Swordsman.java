package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.GreatAxe;
import models.ThrustingSword;
import models.Weapons;

public class Swordsman extends Native {



	private static Weapons weapon ;
    private static ArrayList<Armor> nativeArsenal;    // the chatacters arsenal

	
	public Swordsman(){
		
	setName("Swordsman");
	weapon = new ThrustingSword();
	setStrikeWeight(DamageEnum.MEDIUM);
	setWage(1);
	setNotoriety(2);
	setWeapon(weapon);


	nativeArsenal = new ArrayList<Armor>();
	setNativeArsenal(nativeArsenal);

	
	}
	




}
