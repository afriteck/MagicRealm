package models;

public class GreatAxe extends Weapons{



	
	public GreatAxe(){
		
		setName("Great Axe");
	    setDamage(DamageEnum.HEAVY);
	    setReadyDamage(DamageEnum.HEAVY);
	    setSharpness(1);
	    setReadySpeed(4);
	    setReadySharpness(1);
	    setLength(5);
	    setPrice(8);
	    setHands(2);
	    setMissile(false);
	}

}
