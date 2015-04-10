package monsters;

import models.DamageEnum;

public class Giant extends Monster {

	public Giant() {
		setName("Giant");
		setSize("Tremendous");
		setFame(8);
		setNotoriety(8);
		
		//Unalerted monster stats
		setStrikeWeight(DamageEnum.HEAVY);
		setAttackSpeed(5);
		setMoveSpeed(5);
		
		//Alerted monster stats
		setAlertedAttackSpeed(4);
		setAlertedMoveSpeed(6);
		
		//Set monster file path
		setFilePath("/monsters/giant.gif");
	}	
	
}
