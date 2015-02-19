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
	private ArrayList<MonsterChit> monsterChits;
	private ArrayList<SoundChit> soundChits;
	private ArrayList<WarningChit> warningChits;

	public Clearing(int number, long xpos, long ypos){
		setClearingNumber(number);
		setXposition((int) xpos);
		setYposition((int) ypos);
		treasureChits = new ArrayList<TreasureChit>();
		monsterChits = new ArrayList<MonsterChit>();
		soundChits = new ArrayList<SoundChit>();
		warningChits = new ArrayList<WarningChit>();
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
}
