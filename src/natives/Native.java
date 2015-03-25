package natives;

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

public abstract class Native implements Move, Business, Hide, Follow {

	private Weapons weapon;
	private int wage;
	private String name;
	private int notoriety;
	private static LinkedList<Armor> myArsenal; // the characters arsenal
	private boolean status;

	private DamageEnum alertedStrikeWeight;
	private DamageEnum strikeWeight;
	private int moveSpeed;
	private int alertMoveSpeed;
	private boolean leader;

	public Native(String nativeName) {
		// Take native name and parse native JSON. Used returned values to fill
		// in details for native
	}

	public Native() {

	}

	/***** Getter Methods *****/
	public Weapons getWeapon() {
		return this.weapon;
	}

	public int getWage() {
		return wage;
	}

	public String getName() {
		return name;
	}

	public int getNotoriety() {
		return notoriety;
	}

	public DamageEnum getStrikeWeight() {
		return strikeWeight;
	}

	public static LinkedList<Armor> getNativeArsenal() {
		return myArsenal;
	}

	public boolean getStatus() {
		return status;
	}

	public DamageEnum getAlertedStrikeWeight() {
		return alertedStrikeWeight;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public int getAlertMoveSpeed() {
		return alertMoveSpeed;
	}

	public boolean getLeader() {
		return leader;
	}

	/***** Setter Methods *****/
	// Set the current native's inventory
	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public void setName(String string) {
		this.name = string;
	}

	public void setNotoriety(int notoriety) {
		this.notoriety = notoriety;
	}

	public void setStrikeWeight(DamageEnum strikeWeight) {
		this.strikeWeight = strikeWeight;
	}

	public static void setNativeArsenal(LinkedList<Armor> myArsenal) {
		Native.myArsenal = myArsenal;
	}

	public void isAlert(boolean alert) {
		this.status = alert;
	}

	public void setAlertedStrikeWeight(DamageEnum alertedStrikeWeight) {
		this.alertedStrikeWeight = alertedStrikeWeight;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void setAlertMoveSpeed(int alertMoveSpeed) {
		this.alertMoveSpeed = alertMoveSpeed;
	}

	public void isLeader(boolean leader) {
		this.leader = leader;
	}

	public void buyNative(Things th, NativeGroup nt) { // you can recruit a
														// native with gold

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
