package natives;

import java.util.LinkedList;

import models.Armor;
import models.BreastPlates;
import models.BroadSword;
import models.DamageEnum;
import models.ShortSword;
import models.Things;
import models.Weapons;

public class Knight extends Native {


	private static Weapons weapon ;
    private  LinkedList<Armor> nativeArsenal;    // the chatacters arsenal
    private Armor armor;

	
	public Knight(){
		
	setName("Knight");
	weapon = new BroadSword();
	setStrikeWeight(DamageEnum.TREMENDOUS);
	setWage(8);
	setNotoriety(12);
	setWeapon(weapon);
	armor = new BreastPlates();

	nativeArsenal = new LinkedList<Armor>();
	setNativeArsenal(nativeArsenal);
	nativeArsenal.add(armor);

	
	}


	


}
