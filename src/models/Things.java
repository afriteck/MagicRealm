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

  private String tileLocation;
  private int clearingLocation;
  private int clearingX;
  private int clearingY;


	public static String getName(){
		return name;
	}

	public String getTileLocation(){
		return tileLocation;
	}
	public int getClearingLocation(){
		return clearingLocation;
	}
	
	public int getClearingX(){
		return clearingX;
	}
	
	public int getClearingY(){
		return clearingY;
	}
	
	public int getGold(){
		return gold;
	}

	public void setTileLocation(String tl) {
		this.tileLocation = tl;
	}
	
	public void setClearingLocation(int cl) {
		this.clearingLocation = cl;
	}
	
	public void setClearingX(int xpos) {
		this.clearingX = xpos;
	}
	
	public void setClearingY(int ypos) {
		this.clearingY = ypos;
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

public int getArsenalSize(){
	return myArsenal.size();
}

public void setSpeed(int spd){
	this.speed = spd;
}


@Override
public void moveFrom(String tile, int clearing, int posX, int posY) {
	// TODO Auto-generated method stub
	
	Tiles tl = new Tiles(tile);
	Clearing cl = new Clearing(clearing, posX, posY);

	setTileLocation(tile);
	setClearingLocation(clearing);
	setClearingX(posX);
	setClearingY(posY);
	
}

@Override
public void moveTo(String tile, int clearing, int posX, int posY) {
	// TODO Auto-generated method stub
 Tiles tl = new Tiles();
 tl.setName(tile);

 Clearing cl = new Clearing();
 cl.setClearingNumber(clearing);
 cl.setXposition(posX);
 cl.setYposition(posY);

 setTileLocation(tl.getName());
 setClearingLocation(cl.getClearingNumber());
 setClearingX(cl.getXposition());
 setClearingY(cl.getYposition());
 
}



public static void main(String[] args){
	
	Things nt = new Amazon();
	Tiles tl = new Tiles("Deep woods");
	Clearing cl = new Clearing(3,40,50);


	nt.moveFrom(tl.getName(), cl.getClearingNumber(), cl.getXposition(), cl.getYposition());	
	//check where the character is currently at
	System.out.println(" from the character " + nt.getName() + " I am  currently at " + tl.getName() + " clearing number " + nt.getClearingLocation() + " Xposition " + nt.getClearingX() + " y position " + nt.getClearingY() + " \n");	
	//print out the actual location on the board
	System.out.println(" from tile: " + nt.getName() + " moving from " + tl.getName() + " clearing number " + cl.getClearingNumber() + " Xposition " + cl.getXposition() + " y position " + cl.getYposition() + " to \n");
	
	
	
	Tiles newTile = new Tiles("Mountain");
	Clearing newcl = new Clearing(1, 90,100);

	nt.moveTo(newTile.getName(), newcl.getClearingNumber(), newcl.getXposition(), newcl.getYposition());
	System.out.println(nt.getName() + " is at " + newTile.getName() + " clearing number " + nt.getClearingLocation() + " Xposition " + nt.getClearingX() + " y position " + nt.getClearingY() + " \n");
	System.out.println(newTile.getName() + " is confirming that Amazon is on location " + newTile.getName() + " clearing number " + newcl.getClearingNumber() + " Xposition " + newcl.getXposition() + " y position " + newcl.getYposition() + " \n");

	
}

}
