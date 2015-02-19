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

public static void main(String[] args){
	
Mace ss = new Mace();
  System.out.println(ss.getSpeed() + "\n " + ss.getDamage().toString() + ss.getSharpness()  + ss.getHands()+ ss.getLength() + ss.getPrice()+ ss.getReady()) ;


}


}
