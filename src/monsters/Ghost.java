package monsters;

import models.DamageEnum;

public class Ghost extends Monster {

	public Ghost() {
		setName("Ghost");
		setSize("Medium");
		setFame(0);
		setNotoriety(2);
		
		//Unalerted monster stats
		setStrikeWeight(DamageEnum.HEAVY);
		setAttackSpeed(4);
		setMoveSpeed(4);
		
		//Alerted monster stats
		setAlertedStrikeWeight(DamageEnum.LIGHT);
		setAlertedAttackSpeed(2);
		setAlertedMoveSpeed(2);
		
		//Set monster file path
		setFilePath("/natives/ghost.gif");
	}
	
}
