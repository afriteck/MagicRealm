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
	private ArrayList<WarningChit> warningChits;
	
	
	

	public Clearing(int number, long xpos, long ypos){
		setClearingNumber(number);
		setXposition((int) xpos);
		setYposition((int) ypos);
		setTreasureChits(new ArrayList<TreasureChit>());
		setMonsterChits(new ArrayList<Monster>());
		setSoundChits(new ArrayList<SoundChit>());
		setWarningChits(new ArrayList<WarningChit>());
	}

	public Clearing(){
		
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
	
	public String toString(){
		return "Clearing Number: " + clearingNumber + " X position: " + xposition + " Y Position: " + yposition + "\n";
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

	public ArrayList<SoundChit> getSoundChits() {
		return soundChits;
	}

	public void setSoundChits(ArrayList<SoundChit> soundChits) {
		this.soundChits = soundChits;
	}

	public ArrayList<WarningChit> getWarningChits() {
		return warningChits;
	}

	public void setWarningChits(ArrayList<WarningChit> warningChits) {
		this.warningChits = warningChits;
	}
}
