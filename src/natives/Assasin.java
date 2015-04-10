package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.ShortSword;
import models.Weapons;

public class Assasin extends Native {


	private static Weapons weapon ;
    private static ArrayList<Armor> nativeArsenal;    // the chatacters arsenal

	
	public Assasin(){
		
	setName("Assasin");
	weapon = new ShortSword();
	setStrikeWeight(DamageEnum.MEDIUM);
	setWage(1);
	setNotoriety(2);
	setWeapon(weapon);


	nativeArsenal = new ArrayList<Armor>();
	setNativeArsenal(nativeArsenal);

	
	}
	
	


}
