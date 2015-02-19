package models;

public class Armor {

private boolean damaged = false;
private String name;
private int damageCounter;
private boolean destroyed = false;
private DamageEnum damageLevel;




public boolean isDamaged(){
	checkDamage();
	return damaged;
}

public boolean isDestroyed(){
	checkDamage();
	if(damageCounter == 2)
		destroyed = true;
	else destroyed = false;
		return destroyed;
	
}

public void setDamage(boolean dmg){
	this.damaged = dmg;
}

public void setDestroyed(boolean dst){
	this.destroyed = dst;
}

public String getName(){
	return name;
}

public void setName(String nm){
	this.name = nm;
}

public void checkDamage(){
	//if it is damaged, then  damaged = true
	damageCounter++;
	//else damage = false
	
}

public DamageEnum getDamage(){
		return damageLevel;
	
	}

public void setDamageLevel(DamageEnum dam){
	this.damageLevel = dam;
}


}


