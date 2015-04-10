package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.LightBow;
import models.ShortSword;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public class Archer extends Native {

	private static Weapons weapon ;
    private ArrayList<Armor> nativeArsenal;   
	
	
	public Archer(){
		
		setName("Archer");
		weapon = new LightBow();
		setStrikeWeight(DamageEnum.MEDIUM);
		setWage(2);
		setNotoriety(4);
		setWeapon(weapon);


		nativeArsenal = new ArrayList<Armor>();
		setNativeArsenal(nativeArsenal);

		
		
	}
	

}
