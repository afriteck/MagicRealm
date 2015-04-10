package monsters;

/**
 * @author Hassan Said
 */

import java.util.ArrayList;

import models.Counters;
import models.DamageEnum;
import models.Hide;
import models.Move;
import models.Things;
import models.Weapons;

public abstract class Monster implements Move, Hide {

	private String name;
	private int notoriety;
	private int fame;
	private Weapons weapon;

	private String size;
	private int alertedAttackSpeed;
	private int attackSpeed;
	private int alertedMoveSpeed;
	private int moveSpeed;
	private DamageEnum alertedStrikeWeight;
	private DamageEnum strikeWeight;
	private ArrayList<Counters> readyCounter;

	private String fPath;

	public String getName() {
		return name;
	}

	public int getNotoriety() {
		return notoriety;
	}

	public int getFame() {
		return fame;
	}

	public Weapons getWeapon() {
		return weapon;
	}

	public String getSize() {
		return size;
	}

	public int getAlertedAttackSpeed() {
		return alertedAttackSpeed;
	}

	public int getAttackSpeed() {
		return attackSpeed;
	}

	public int getAlertedMoveSpeed() {
		return alertedMoveSpeed;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public DamageEnum getAlertedStrikeWeight() {
		return alertedStrikeWeight;
	}

	public DamageEnum getStrikeWeight() {
		return strikeWeight;
	}

	public String getFilePath() {
		return fPath;
	}
	
	public ArrayList<Counters> getReadyCounter() {
		return readyCounter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotoriety(int notoriety) {
		this.notoriety = notoriety;
	}

	public void setFame(int fame) {
		this.fame = fame;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setAlertedAttackSpeed(int alertedAttackSpeed) {
		this.alertedAttackSpeed = alertedAttackSpeed;
	}

	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public void setAlertedMoveSpeed(int alertedMoveSpeed) {
		this.alertedMoveSpeed = alertedMoveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public void setAlertedStrikeWeight(DamageEnum alertedStrikeWeight) {
		this.alertedStrikeWeight = alertedStrikeWeight;
	}

	public void setStrikeWeight(DamageEnum strikeWeight) {
		this.strikeWeight = strikeWeight;
	}

	public void setFilePath(String fPath) {
		this.fPath = fPath;
	}
	
	public void setReadyCounter(ArrayList<Counters> readyCounter) {
		this.readyCounter = readyCounter;
	}

	@Override
	public void HideCharacter(Things character) {

	}

	@Override
	public void moveFrom(String tile, int clearing) {

	}

	@Override
	public void moveTo(String tile, int clearing) {

	}

}
