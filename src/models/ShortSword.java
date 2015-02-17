package models;

public class ShortSword extends Weapons {

private Things myOwner;

	
	public  ShortSword(){
		
		setOwner(myOwner);
		myOwner.setName("Amazon");
	    setDamage(DamageEnum.LIGHT);
	    setSharpness(1);
	    setSpeed(myOwner.getSpeed());
	    setReadySpeed(myOwner.getSpeed());
	    setReadySharpness(1);
}

	


}
