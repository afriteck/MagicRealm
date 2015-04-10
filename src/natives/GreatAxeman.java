package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.GreatAxe;
import models.ShortSword;
import models.Weapons;

public class GreatAxeman extends Native {



	private static Weapons weapon ;
    private static ArrayList<Armor> nativeArsenal;    // the chatacters arsenal

	
	public GreatAxeman(){
		
	setName("Great Axeman");
	weapon = new GreatAxe();
	setStrikeWeight(DamageEnum.HEAVY);
	setWage(4);
	setNotoriety(6);
	setWeapon(weapon);


	nativeArsenal = new ArrayList<Armor>();
	setNativeArsenal(nativeArsenal);

	
	}
	
	









}
