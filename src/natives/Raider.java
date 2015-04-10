package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.BreastPlates;
import models.DamageEnum;
import models.Helmet;
import models.Shields;
import models.ShortSword;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public class Raider extends Native {

	private static Weapons weapon ;
    private static ArrayList<Armor> nativeArsenal;    // the chatacters arsenal

	
	public Raider(){
		
	setName("Raider");
	weapon = new ShortSword();
	setStrikeWeight(DamageEnum.LIGHT);
	setWage(2);
	setNotoriety(4);
	setWeapon(weapon);


	nativeArsenal = new ArrayList<Armor>();
	setNativeArsenal(nativeArsenal);

	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
