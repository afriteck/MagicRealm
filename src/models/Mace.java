package models;

public class Mace extends Weapons {

private Things myOwner;

public Mace(){
	
	myOwner.setName("BlackKnight");
	setOwner(myOwner);
    setDamage(DamageEnum.MEDIUM);
    setSharpness(1);
    setSpeed(myOwner.getSpeed());

}


}
