package models;

public class Mace extends Weapons {

//private Things myOwner;

public Mace(){

	setName("Mace");
    setDamage(DamageEnum.MEDIUM);
    setReadyDamage(DamageEnum.MEDIUM);
    setSharpness(1);
    setReadySpeed(3);
    setReadySharpness(0);
    setLength(1);
    setPrice(6);
    setHands(1);
    setMissile(false);
    //setReady(true);
}

}
