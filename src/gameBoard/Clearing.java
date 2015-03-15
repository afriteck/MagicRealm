/**
 * 
 */
package gameBoard;

import java.util.ArrayList;

import models.Dwelling;
import models.Monster;
import models.PlayerChit;
import models.TreasureChit;
import models.WarningChit;

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
	private ArrayList<WarningChit> warningChits;
	private Dwelling dwelling;
	private ArrayList<PlayerChit> peopleHere;
	private boolean playerHere;
	
	
	

	public Clearing(int number, long xpos, long ypos){
		setClearingNumber(number);
		setXposition((int) xpos);
		setYposition((int) ypos);
		setTreasureChits(new ArrayList<TreasureChit>());
		setMonsterChits(new ArrayList<Monster>());
		setWarningChits(new ArrayList<WarningChit>());
		setPeopleHere(new ArrayList<PlayerChit>());
		
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
	
	public void addMonster(Monster monster){
		monsterChits.add(monster);
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

	public ArrayList<WarningChit> getWarningChits() {
		return warningChits;
	}

	public void setWarningChits(ArrayList<WarningChit> warningChits) {
		this.warningChits = warningChits;
	}
	
	public void setPeopleHere(ArrayList<PlayerChit> playerChits) {
		this.peopleHere = playerChits;
	}

	public ArrayList<PlayerChit> getPeopleHere() {
		return peopleHere;
	}
	
	public void movePersonHere(PlayerChit person) {
		this.peopleHere.add(person);
	}
	
	public void removePersonHere(PlayerChit person) {
		this.peopleHere.remove(person);
	}
}
