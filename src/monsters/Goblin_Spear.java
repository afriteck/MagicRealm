package monsters;

import models.DamageEnum;
import models.Spear;
import models.Weapons;

public class Goblin_Spear extends Monster {

	private Weapons weapon;
	
	public Goblin_Spear() {
		setName("Goblin with Spear");
		setSize("Medium");
		setFame(1);
		setNotoriety(1);
		
		//Monster weapon
		weapon = new Spear();
		setWeapon(weapon);
		
		//Unalerted monster stats
		setMoveSpeed(3);
		
		//Alerted monster stats
		setAlertedStrikeWeight(DamageEnum.HEAVY);
		setAlertedAttackSpeed(5);
		setAlertedMoveSpeed(5);
		
		//Set file path to image
		setFilePath("/monsters/goblin_spear.gif");
	}
	
}
