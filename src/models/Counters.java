package models;

public class Counters {

private String type;
private DamageEnum strength;
private int speed;
private int star;

public Counters(String type, DamageEnum strength, int speed, int star){
	setType(type);
	setStrength(strength);
	setSpeed(speed);
	setStar(star);
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public DamageEnum getStrength() {
	return strength;
}
public void setStrength(DamageEnum strength) {
	this.strength = strength;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public int getStar() {
	return star;
}
public void setStar(int star) {
	this.star = star;
}




}
