package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.GreatSword;
import models.Shields;
import models.ShortSword;
import models.Weapons;

public class GreatSwordsman extends Native{


	private static Weapons weapon ;
    private ArrayList<Armor> nativeArsenal;    // the chatacters arsenal
    private Armor armor;



    public GreatSwordsman(){
    	
    	
    	setName("Great SwordsMan");
    	weapon = new GreatSword();
    	armor = new Shields();
    	nativeArsenal = new ArrayList<Armor>();
    	setNativeArsenal(nativeArsenal);    	
    	nativeArsenal.add(armor);
    	setStrikeWeight(DamageEnum.HEAVY);
    	setWage(4);
    	setNotoriety(6);
    	setWeapon(weapon);
    	setMoveSpeed(1);


    

    	
    	
    	
    }
    

	
	
	
	



}
