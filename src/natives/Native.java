package natives;

import java.util.ArrayList;
import java.util.LinkedList;

import models.Armor;
import models.Business;
import models.DamageEnum;
import models.Follow;
import models.Hide;
import models.Move;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public abstract class Native implements Move, Business, Hide, Follow{

	private Weapons weapon;
	private int wage;
	private String name;
	private int notoriety;
    private static ArrayList<Armor> myArsenal;    // the chatacters arsenal
    private boolean status;

	private DamageEnum alertedStrikeWeight;
	private DamageEnum strikeWeight;
	private int moveSpeed;
	private int alertMoveSpeed;
	private boolean leader;
	

	
	
	public Native(String nativeName){
		// Take native name and parse native JSON. Used returned values to fill in details for native
	}
	
	public Native(){
		
	}
	
	/***** Getter Methods *****/
	public Weapons getWeapon() {
		return this.weapon;
	}
	
		/***** Setter Methods *****/
	// Set the current native's inventory
	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	

		public int getWage() {
			return wage;
		}

		public void setWage(int wage) {
			this.wage = wage;
		}

		public void setName(String string) {
			// TODO Auto-generated method stub
			this.name = string;
		}
		public String getName(){
			return name;
		}

		public int getNotoriety() {
			return notoriety;
		}

		public void setNotoriety(int notoriety) {
			this.notoriety = notoriety;
		}

		public DamageEnum getStrikeWeight() {
			return strikeWeight;
		}

		public void setStrikeWeight(DamageEnum strikeWeight) {
			this.strikeWeight = strikeWeight;
		}

	

		public static ArrayList<Armor> getNativeArsenal() {
			return myArsenal;
		}

		public static void setNativeArsenal(ArrayList<Armor> myArsenal) {
			Native.myArsenal = myArsenal;
		}

		public boolean getStatus() {
			return status;
		}

		public void isAlert(boolean alert) {
			this.status = alert;
		}

		public DamageEnum getAlertedStrikeWeight() {
			return alertedStrikeWeight;
		}

		public void setAlertedStrikeWeight(DamageEnum alertedStrikeWeight) {
			this.alertedStrikeWeight = alertedStrikeWeight;
		}

		public int getMoveSpeed() {
			return moveSpeed;
		}

		public void setMoveSpeed(int moveSpeed) {
			this.moveSpeed = moveSpeed;
		}

		public int getAlertMoveSpeed() {
			return alertMoveSpeed;
		}

		public void setAlertMoveSpeed(int alertMoveSpeed) {
			this.alertMoveSpeed = alertMoveSpeed;
		}

		public boolean getLeader() {
			return leader;
		}

		public void isLeader(boolean leader) {
			this.leader = leader;
		}

		public void buyNative(Things th, NativeGroup nt){		//you can recruit a native with gold

		}

		@Override
		public void moveFrom(String tile, int clearing) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void moveTo(String tile, int clearing) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sellArmor(Things th, Armor arm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sellWeapon(Things th, Weapons arms) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sellTreasure(Things th, TreasureChit tr, int gold) {
			// TODO Auto-generated method stub
			
		}

		
		@Override
		public void buyArmor(Things th, Armor arm) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void buyWeapon(Things th, Weapons arms) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void buyTreasure(Things th, TreasureChit tr) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void HideCharacter(Things character) {
			// TODO Auto-generated method stub
			
		}	












}
