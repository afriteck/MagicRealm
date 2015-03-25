/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author joshwhite
 * 
 */
public class Clearing {

	private int clearingNumber;
	private int xposition;
	private int yposition;

	private ArrayList<TreasureChit> treasureChits;
	private ArrayList<Monster> monsterChits;
	private ArrayList<SoundChit> soundChits;
	private Dwelling dwelling;
	private boolean playerHere;

	public Clearing(int number, long xpos, long ypos) {
		setClearingNumber(number);
		setXposition((int) xpos);
		setYposition((int) ypos);
		setTreasureChits(new ArrayList<TreasureChit>());
		setMonsterChits(new ArrayList<Monster>());
		setSoundChits(new ArrayList<SoundChit>());

	}

	public Clearing() {

	}

	public int getClearingNumber() {
		return clearingNumber;
	}

	public void setClearingNumber(int clearingNumber) {
		this.clearingNumber = clearingNumber;
	}

	public int getXposition() {
		return xposition;
	}

	public void setXposition(int xposition) {
		this.xposition = xposition;
	}

	public int getYposition() {
		return yposition;
	}

	public void setYposition(int yposition) {
		this.yposition = yposition;
	}

	public String toString() {
		return "Clearing Number: " + clearingNumber + " X position: "
				+ xposition + " Y Position: " + yposition + "\n";
	}

	public ArrayList<TreasureChit> getTreasureChits() {
		return treasureChits;
	}

	public void setTreasureChits(ArrayList<TreasureChit> treasureChits) {
		this.treasureChits = treasureChits;
	}

	public ArrayList<Monster> getMonsterChits() {
		return monsterChits;
	}

	public void setMonsterChits(ArrayList<Monster> monsterChits) {
		this.monsterChits = monsterChits;
	}

	public void addMonster(Monster monster) {
		monsterChits.add(monster);
	}

	public ArrayList<SoundChit> getSoundChits() {
		return soundChits;
	}

	public void setSoundChits(ArrayList<SoundChit> soundChits) {
		this.soundChits = soundChits;
	}

	public Dwelling getDwelling() {
		return dwelling;
	}

	public void setDwelling(Dwelling dwelling) {
		this.dwelling = dwelling;
	}

	public boolean isPlayerHere() {
		return playerHere;
	}

	public void setPlayerHere(boolean playerHere) {
		this.playerHere = playerHere;
	}
}
