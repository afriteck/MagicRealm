package models;

public class Weapons {

	private DamageEnum damage;
	private int speed;
	private int sharpness;
	private Things owner;
	private boolean ready = false;
	private int readySpeed;
	private int readySharpness;
	private int weaponLength;
	boolean missile = false;
	int hands;
	int price;
	private DamageEnum readyDamage;


	public DamageEnum getDamage(){
		checkReady();
		if(!ready) return damage;
		else return readyDamage;
	}

public int getSpeed(){
	checkReady();
	if(!ready)
		return speed;
	else return readySpeed;
}
	
public int getSharpness(){
	checkReady();
	if(!ready)
		return sharpness;
	else return readySharpness;
}

public void setOwner(Things theowner){
	owner = new Things();
	this.owner = theowner;
	owner.setName(theowner.getName());

}

public void setDamage(DamageEnum dam){
	this.damage = dam;
}

public void setSpeed(int spd){
	
	this.speed = spd;
}

public boolean getReady(){
	return ready;
}

public void setReadySpeed(int rdspd){
	
	this.readySpeed = rdspd; 
}
public void setReady(boolean ready){
	this.ready = ready;
}

public void setSharpness(int sharp){
	this.sharpness = sharp;
}

public void setReadySharpness(int sharp){
	this.readySharpness = sharp;
}

public void checkReady(){
	//if whatever setReady true
	//else setReady false;

}

}
