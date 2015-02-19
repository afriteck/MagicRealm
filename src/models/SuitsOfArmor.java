package models;

public class SuitsOfArmor extends Armor{


	public SuitsOfArmor(){
		
		
		setName("Suits of Amor");
		setDamage(isDamaged());
		setDestroyed(isDestroyed());
	    setDamageLevel(DamageEnum.HEAVY);

	}


}
