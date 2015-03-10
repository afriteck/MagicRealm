package models;

public class CrossBow extends Weapons{


	public CrossBow(){

		setName("Cross Bow");
	    setDamage(DamageEnum.HEAVY);
	    setReadyDamage(DamageEnum.HEAVY);
	    setSharpness(0);
	    setReadySpeed(1);
	    setReadySharpness(1);
	    setLength(12);
	    setPrice(10);
	    setHands(2);
	    setMissile(true);
	    //setReady(true);
	}




}
