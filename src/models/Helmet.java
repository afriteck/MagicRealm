package models;

public class Helmet extends Armor{

	
	public Helmet(){
	
	setName("Helmet");
	setDamage(isDamaged());
	setDestroyed(isDestroyed());
    setDamageLevel(DamageEnum.MEDIUM);



	}
}
