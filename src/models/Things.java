package models;

import gameLogic.BoardTiles;
import gui.BoardTest;
import gui.Gui;

import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import models.WarningChit.Smoke;

public class Things implements Move, Fight, Search, Hide{

	//Gui gui = new Gui();

	private static String name;
	private int gold;
	private Weapons myweapon;
	private Armor myArmor;
    private LinkedList<Armor> myArsenal;    // the chatacters arsenal
    private LinkedList<Things> friends;
    private LinkedList<Things> enemies;
    private int speed;
    private boolean hiden = false;
  private String tileName;
  private static int clearingLocation;
  private int clearingX;
  private int clearingY;
  
  private static  Tiles mytiles;
  
  


	public static String getName(){
		return name;
	}
	
	public boolean getVisibility(){
		return hiden;
	}

	public void setVisibility(boolean hide){
		this.hiden = hide;
	}
	public String getTileName(){
		return tileName;
	}
	public static int getClearingLocation(){
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

	public void setTileName(String tl) {
		this.tileName = tl;
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
public void moveFrom(String tile, int clearing) {
	// TODO Auto-generated method stub
	tile = getTileName();
	clearing = getClearingLocation();
	
}

@Override
public void moveTo(String tile, int clearing) {
	// TODO Auto-generated method stub
  setTileName(tile);
  setClearingLocation(clearing);
	
	/*
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
 */
}



public static void main(String[] args){
	
	Things nt = new Amazon();
	Tiles tl = new Tiles("Deep woods");
	Clearing cl = new Clearing(3,40,50);

	nt.setMytiles(tl);
	nt.setClearingLocation(3);
	nt.moveFrom(getMytiles(), getClearingLocation());	
	//check where the character is currently at
	System.out.println(" from the character " + nt.getName() + " I am  currently at " + nt.getMytiles() + " clearing number " + nt.getClearingLocation() +  " \n");	
	//print out the actual location on the board
	System.out.println(" from tile: " + nt.getName() + " moving from " + tl.getName() + " clearing number " + cl.getClearingNumber() + " to \n");
	
	Smoke ws = new Smoke();
	BoardTiles boardt = BoardTest.initializeTiles();
	Tiles newTile = boardt.getTile("MOUNTAIN");
	newTile.setWarnings(ws);
	//Tiles newTile = Gui.boardt.getTile("CAVES");
	Clearing newcl = new Clearing(1, 90,100);
	
	

	nt.moveTo(newTile.getName(), newcl.getClearingNumber());
	System.out.println(nt.getName() + " is at " + newTile.getName() + " clearing number " + nt.getClearingLocation() + " Xposition " + nt.getClearingX() + " y position " + nt.getClearingY() + " \n");
	System.out.println(newTile.getName() + " is confirming that Amazon is on location " + newTile.getName() + " clearing number " + newcl.getClearingNumber() + " Xposition " + newcl.getXposition() + " y position " + newcl.getYposition() + " \n");

	nt.searchLocation(newTile);



}

public static  String getMytiles() {
	return mytiles.getName();
}

public void setMytiles(Tiles mytiles) {
	this.mytiles = mytiles;
}

@Override
public void searchLocation(Tiles tile) {
	
	//mytiles = new Tiles(tile);
	//mytiles = Gui.boardt.getTile("MOUNTAIN");
	//System.out.println(tile.getWarnings().getName());
	System.out.println(tile.getWarnings().getName());

	//tile = getMytiles();
	
	//for(int i = 0; i < mytiles.getClearings().size(); i++){
	//mytiles.getClearings().get(i).getSoundChits();
	//mytiles.getClearings().get(i).getMonsterChits();
	//mytiles.getClearings().get(i).getTreasureChits();
	//mytiles.getClearings().get(i).getWarningChits();

	
	//System.out.println(mytiles.getSoundChits());
	//System.out.println(	mytiles.getClearings().get(i).getMonsterChits());
	//System.out.println(	mytiles.getClearings().get(i).getTreasureChits());


	
	//}

	
	
	//setMytiles(tile);


}

@Override
public void HideCharacter(Things character) {
	
character.setVisibility(true);			// hide the character character

}





}


