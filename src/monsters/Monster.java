package monsters;

/**
 * @author Hassan Said
 */

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

	private String fPath;

	protected String getName() {
		return name;
	}

	protected int getNotoriety() {
		return notoriety;
	}

	protected int getFame() {
		return fame;
	}

	protected Weapons getWeapon() {
		return weapon;
	}

	protected String getSize() {
		return size;
	}

	protected int getAlertedAttackSpeed() {
		return alertedAttackSpeed;
	}

	protected int getAttackSpeed() {
		return attackSpeed;
	}

	protected int getAlertedMoveSpeed() {
		return alertedMoveSpeed;
	}

	protected int getMoveSpeed() {
		return moveSpeed;
	}

	protected DamageEnum getAlertedStrikeWeight() {
		return alertedStrikeWeight;
	}

	protected DamageEnum getStrikeWeight() {
		return strikeWeight;
	}

	protected String getFilePath() {
		return fPath;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setNotoriety(int notoriety) {
		this.notoriety = notoriety;
	}

	protected void setFame(int fame) {
		this.fame = fame;
	}

	protected void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	protected void setSize(String size) {
		this.size = size;
	}

	protected void setAlertedAttackSpeed(int alertedAttackSpeed) {
		this.alertedAttackSpeed = alertedAttackSpeed;
	}

	protected void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	protected void setAlertedMoveSpeed(int alertedMoveSpeed) {
		this.alertedMoveSpeed = alertedMoveSpeed;
	}

	protected void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	protected void setAlertedStrikeWeight(DamageEnum alertedStrikeWeight) {
		this.alertedStrikeWeight = alertedStrikeWeight;
	}

	protected void setStrikeWeight(DamageEnum strikeWeight) {
		this.strikeWeight = strikeWeight;
	}

	protected void setFilePath(String fPath) {
		this.fPath = fPath;
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
