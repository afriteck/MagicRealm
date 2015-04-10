package natives;

import java.util.LinkedList;

import models.Armor;
import models.BreastPlates;
import models.CrossBow;
import models.DamageEnum;
import models.Shields;
import models.Spear;
import models.Weapons;

public class Crossbowman extends Native {


	private static Weapons weapon ;
    private static LinkedList<Armor> nativeArsenal;    // the chatacters arsenal
    private Armor armor;



    public Crossbowman(){
    	
    	setName("Crossbowman");
    	weapon = new CrossBow();
    	armor = new BreastPlates();
    	nativeArsenal = new LinkedList<Armor>();
    	setNativeArsenal(nativeArsenal);
    	nativeArsenal.add(armor);
    	setStrikeWeight(DamageEnum.MEDIUM);
    	setWage(2);
    	setNotoriety(4);
    	setWeapon(weapon);


    	
    	
    }







}
