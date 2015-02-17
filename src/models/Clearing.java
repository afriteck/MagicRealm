/**
 * 
 */
package models;

import gameLogic.Treasure;

import java.util.ArrayList;

/**
 * @author joshwhite
 *
 */
public class Clearing {
	
	private int clearingNumber;
	private int xposition;
	private int yposition;
	private Treasure treasureChits;
	private ArrayList<MonsterChit> monsterChits;
	private ArrayList<SoundChit> soundChits;
	private ArrayList<WarningChit> warningChits;

	public Clearing(int number, int xpos, int ypos){
		setClearingNumber(number);
		setXposition(xpos);
		setYposition(ypos);
		treasureChits = new Treasure();
		monsterChits = new ArrayList<MonsterChit>();
		soundChits = new ArrayList<SoundChit>();
		warningChits = new ArrayList<WarningChit>();
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
}
