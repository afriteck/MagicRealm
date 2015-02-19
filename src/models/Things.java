package models;

import java.util.LinkedList;

public class Things implements Move, Fight{


	private static String name;
	private int gold;
	private Weapons myweapon;
	private Armor myArmor;
    private LinkedList<Armor> myArsenal;    // the chatacters arsenal
    private LinkedList<Things> friends;
    private LinkedList<Things> enemies;
    private int speed;




	public static String getName(){
		return name;
	}

	public int getGold(){
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void setName(String name) {
		this.name = name;
	}

public Weapons getWeapons(){
	return myweapon;
}

public void setWeapon(Weapons weapon){
	this.myweapon = weapon;
}

public Armor getArmour(){
	return myArmor;
}

public void setAmor(Armor am){
	
	this.myArmor = am;
}
public LinkedList<Armor> getCharacterArmory() {
    return myArsenal;
}

public LinkedList<Things> getFriends() {
    return friends;
}

public LinkedList<Things> getEnemies() {
    return enemies;
}

public void setFriends(LinkedList<Things> characterFriends) {
    this.friends = characterFriends;
}

public void setEnemies(LinkedList<Things> characterEnemies) {
    this.enemies = characterEnemies;
}

public void setPlayerArmoury(LinkedList<Armor> characterArsenal) {
    this.myArsenal = characterArsenal;
}

public int getSpeed(){
	return speed;
}

public void addArmor(Armor arm){

	getCharacterArmory().add(arm);
	
}

public void setSpeed(int spd){
	this.speed = spd;
}


}
