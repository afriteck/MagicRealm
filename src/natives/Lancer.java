package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.ShortSword;
import models.Spear;
import models.Weapons;

public class Lancer extends Native{



	private static Weapons weapon ;
    private static ArrayList<Armor> nativeArsenal;    // the chatacters arsenal

	
	public Lancer(){
		
	setName("Lancer");
	weapon = new Spear();
	setStrikeWeight(DamageEnum.LIGHT);
	setWage(2);
	setNotoriety(4);
	setWeapon(weapon);


	nativeArsenal = new ArrayList<Armor>();
	setNativeArsenal(nativeArsenal);

	
	}






}
