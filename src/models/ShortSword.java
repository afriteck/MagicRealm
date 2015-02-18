package models;

public class ShortSword extends Weapons {

private Things myOwner = new Amazon();

	
	public  ShortSword(){
		
		setOwner(myOwner);
		myOwner.setName("Amazon");
	    setDamage(getDamage());
	    setSharpness(getSharpness());
	    setSpeed(myOwner.getSpeed());
	    setReadySpeed(myOwner.getSpeed());
	    setReadySharpness(1);
}

	

	public static void main(String[] args){
		
	ShortSword ss = new ShortSword();
	  System.out.println(ss.getSpeed() + "\n " + ss.getDamage() + ss.getSharpness() + ss.getOwner().getName() ) ;
	
	
	}

}
