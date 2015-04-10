package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Shields;
import models.ShortSword;
import models.Spear;
import models.Weapons;

public class Pikeman extends Native {

	private static Weapons weapon ;
    private static ArrayList<Armor> nativeArsenal;    // the chatacters arsenal
    private Armor armor;



    public Pikeman(){
    	
    	setName("Pikeman");
    	weapon = new Spear();
    	armor = new Shields();
    	nativeArsenal = new ArrayList<Armor>();
    	setNativeArsenal(nativeArsenal);
    	nativeArsenal.add(armor);
    	setStrikeWeight(DamageEnum.MEDIUM);
    	setWage(2);
    	setNotoriety(3);
    	setWeapon(weapon);


    	
    	
    }
    
}
