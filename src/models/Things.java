package models;

import gameBoard.Clearing;
import gameBoard.Tiles;
import gui.Gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import natives.Bashkars;
import natives.Company;
import natives.Lancers;
import natives.Native;
import natives.NativeGroup;
import natives.Rogues;

import models.WarningChit.Smoke;

public abstract class Things implements Move, Business, Search, Hide{

	//Gui gui = new Gui();

	private static String name;
	private int gold;
	private static String url;
	//private PlayerChit pchit;
	private Weapons myweapon;
    private LinkedList<Weapons> myweapons;    // the chatacters arsenal

	private Armor myArmor;
    private LinkedList<Armor> myArsenal;    // the chatacters arsenal
    private LinkedList<Things> friends;
    private LinkedList<Things> enemies;
    private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private int speed;
    private boolean hiden = false;
  private String tileName;
  private static int clearingLocation;
  private int roll;
  private ArrayList<Counters> readyCounter;
  private ArrayList<Counters> fatiguedCounter;



  
  private static  Tiles mytiles;
  private boolean alert;
  
  
  	public static void setUrl(String url) {
		Things.url = url;
	}
	
	public static String getUrl(){
		return url;
	}
	
	/*
	public PlayerChit getPchit() {
		return pchit;
	}

	public void setPchit(PlayerChit pchit) {
		this.pchit = pchit;
	}*/

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
	public int getClearingLocation(){
		return clearingLocation;
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

public LinkedList<NativeGroup> getHiredNatives() {
	//hiredNatives = new LinkedList<NativeGroup>();
	return hiredNatives;
}

public void setHiredNatives(LinkedList<NativeGroup> hiredNatives) {
	this.hiredNatives = hiredNatives;
}

public NativeGroup getHiredNative() {
	return hiredNative;
}

public String getHiredNativeGroupName() {
	return getHiredNative().getName();
}

public void setHiredNative(NativeGroup nt) {
	this.hiredNative = nt;
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

}

public static  String getMytiles() {
	return mytiles.getName();
}

public void setMytiles(Tiles mytiles) {
	this.mytiles = mytiles;
}

@Override
public void searchLocation(Tiles tile) {
	

	System.out.println(tile.getWarnings().getName());




}

@Override
public void HideCharacter(Things character) {
	
character.setVisibility(false);			// hide the character character

}

public void addNative(LinkedList<NativeGroup> hiredN, NativeGroup aNativeGroup) {
	
	hiredN = new LinkedList<NativeGroup>();
	aNativeGroup= new NativeGroup();
	this.hiredNatives = hiredN;
	this.hiredNative = aNativeGroup;
	hiredN.add(aNativeGroup);
} 

@Override
public void sellArmor(Things th, Armor arm) {
	for(int i = 0; i < getArsenalSize(); i++){
	if(th.getCharacterArmory().get(i).getName() == arm.getName()){
		th.getCharacterArmory().remove(i);
		 if(arm.isDamaged()){
		th.setGold(th.getGold()+ arm.getDamagedPrice());
		JOptionPane.showMessageDialog(null, "You have sold your " + arm.getName() + " your current gold is " + th.getGold() + " golds");

		 }else if(!arm.isDamaged()){
				th.setGold(th.getGold()+ arm.getIntactPrice());

			JOptionPane.showMessageDialog(null, "You have sold your " + arm.getName() + " your current gold is " + th.getGold() + " golds");
		 }
	}
	
	}		
	JOptionPane.showMessageDialog(null, "You have do not have the specified armor to sell");


}

@Override
public void sellWeapon(Things th, Weapons arms) {
		
	if(th.getMyweapons().size() == 1 && th.getWeapons().getName() == arms.getName()){
		th.getMyweapons().remove(arms);
		th.setWeapon(null);
		JOptionPane.showMessageDialog(null, "You have sold your one and only weapon!");
		th.setGold(th.getGold() + arms.getPrice());

		}
	else if(th.getMyweapons().size() > 1){
	
	for(int i = 0; i < th.getMyweapons().size(); i++){
	if(th.getMyweapons().get(i).getName() == arms.getName()){
		th.getMyweapons().remove(arms);
		th.setGold(th.getGold() + arms.getPrice());
		JOptionPane.showMessageDialog(null, "You have sold your weapon!");

	}
	}
	}
}

@Override
public void sellTreasure(Things th, TreasureChit tr, int gold) {
	// TODO Auto-generated method stub
	
}

public void buyNative(Things th, NativeGroup nt){		//you can recruit a native with gold
	if(th.getGold() >= nt.getCost()){
	th.getHiredNatives().add(nt);
	JOptionPane.showMessageDialog(null, "You have successfully acquired " + nt.getName() + " Native Group");
	th.setGold(th.getGold()- nt.getCost());
	}
	else{
		JOptionPane.showMessageDialog(null, "You cannot afford this native");

	}

	}


/*
public void buyNative(Things th, LinkedList<NativeGroup> ng, NativeGroup nt) {	
	
	if(th.getGold() >= nt.getCost()){

	this.hiredNatives = ng;
	this.hiredNative = nt;
 	th.setHiredNatives(ng);

	ng.add(nt);
	
	th.setGold(th.getGold()- nt.getCost());
	JOptionPane.showMessageDialog(null, "You have successfully acquired " + nt.getName() + " Native Group");

	}else{ 

		System.out.println("You do not have enough gold to hire this native");
		JOptionPane.showMessageDialog(null, "You do not have enough gold to buy this native group ");

	
		}
	 
}*/

@Override
public void buyArmor(Things th, Armor arm) {
	if(arm.isDamaged() && th.getGold() >= arm.getDamagedPrice()){
	th.setGold(th.getGold() - arm.getDamagedPrice());
	th.addArmor(arm);
	JOptionPane.showMessageDialog(null, "You have purchased "+ arm.getName() + " \n your balance is " + th.getGold() + " golds");


	}else if(!arm.isDamaged() && th.getGold() >= arm.getIntactPrice()){
		th.setGold(th.getGold() - arm.getIntactPrice());
		th.addArmor(arm);
		JOptionPane.showMessageDialog(null, "You have purchased "+ arm.getName() + " \n your balance is " + th.getGold() + " golds");
	}
	else{
		System.out.println(" You cannot afford the selected armor");
		JOptionPane.showMessageDialog(null, "You cannot afford the selected armor");

	}
}

@Override
public void buyWeapon(Things th, Weapons arms) {
	// TODO Auto-generated method stub
	if(th.getGold() < arms.getPrice())
	JOptionPane.showMessageDialog(null, "You cannot afford the weapon");

	else{
		th.getMyweapons().add(arms);
		th.setGold(th.getGold() - arms.getPrice());
	}
	
	/*
	if(th.getName() == "Amazon" && arms.getName() == "Short Sword"){
		th.setWeapon(arms);
		th.setGold(th.getGold() - arms.getPrice());
	}
	else if (th.getName() == "Black Knight" && arms.getName() == "Mace"){
		th.setWeapon(arms);
		th.setGold(th.getGold() - arms.getPrice());
		
	}
	else if (th.getName() == "Captain" && arms.getName() == "Short Sword"){
		th.setWeapon(arms);
		th.setGold(th.getGold() - arms.getPrice());

	}
	else if (th.getName() == "Dwarf" && arms.getName() == "Great Axe"){
		th.setWeapon(arms);
		th.setGold(th.getGold() - arms.getPrice());

	}
	else if (th.getName() == "Elf" && arms.getName() == "Light Bow"){
		th.setWeapon(arms);
		th.setGold(th.getGold() - arms.getPrice());
	}
	else if (th.getName() == "Swordsman" && arms.getName() == "Thrusting Sword"){
		th.setWeapon(arms);
		th.setGold(th.getGold() - arms.getPrice());
	}
	else JOptionPane.showMessageDialog(null, "Your character cannot use this weapon");
	*/

}
	//else JOptionPane.showMessageDialog(null, "You cannot afford the weapon");


@Override
public void buyTreasure(Things th, TreasureChit tr) {
	// TODO Auto-generated method stub
	
}


/*

public static void main(String[] args){
	
	Things nt = new Amazon();
	Weapons arms = new Mace();
	Weapons shortsword = new ShortSword();
	Lancers ng = new Lancers();

	Armor arm = new BreastPlates();
	Tiles tl = new Tiles("Deep woods");
	Clearing cl = new Clearing(3,40,50);

		
 nt.sellWeapon(nt, nt.getWeapons());
 
 System.out.println("after selling weapon, i have " + nt.getGold());

 
 nt.buyWeapon(nt, arms);
 
 System.out.println("I just bought " + nt.getMyweapons().get(0).getName());

 System.out.println("after buying weapon, i have " + nt.getGold());

 for(int i = 0; i < nt.getMyweapons().size(); i++)
 System.out.println("checking my list of weapons " + nt.getMyweapons().get(i).getName());

 
 
 nt.buyNative(nt, ng);
 
 System.out.println("I bought this native group " + nt.getHiredNatives().get(0).getName());
 System.out.println("I now have this much gold left " + nt.getGold());


}
*/

public LinkedList<Weapons> getMyweapons() {
	return myweapons;
}

public void setMyweapons(LinkedList<Weapons> myweapons) {
	this.myweapons = myweapons;
}

public boolean isAlert() {
	return alert;
}

public void setAlert(boolean alert) {
	this.alert = alert;
}

public int getRoll() {
	return roll;
}

public void setRoll(int roll) {
	this.roll = roll;
}

public ArrayList<Counters> getReadyCounter() {
	return readyCounter;
}

public void setReadyCounter(ArrayList<Counters> readyCounter) {
	this.readyCounter = readyCounter;
}

public ArrayList<Counters> getFatiguedCounter() {
	return fatiguedCounter;
}

public void setFatiguedCounter(ArrayList<Counters> fatiguedCounter) {
	this.fatiguedCounter = fatiguedCounter;
}


}


