package models;

public class BreastPlates extends Armor {
	
	
	
	public BreastPlates(){
	setName("Breast Plates");
	setDamage(isDamaged());
	setDestroyed(isDestroyed());
    setDamageLevel(DamageEnum.MEDIUM);

	
	
	
	}
}
