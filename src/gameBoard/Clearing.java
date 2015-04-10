/**
 * 
 */
package gameBoard;

import java.util.ArrayList;

import natives.NativeGroup;

import models.Dwelling;
import models.Monster;
import models.PlayerChit;
import models.SoundChit;
import models.TreasureChit;

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
	private ArrayList<SoundChit> sound;
	private Dwelling dwelling;
	private ArrayList<PlayerChit> peopleHere;
	private boolean playerHere;
	private PlayerChit personHere;
	private NativeGroup natives;

	
	

	public Clearing(int number, long xpos, long ypos){
		setClearingNumber(number);
		setXposition((int) xpos);
		setYposition((int) ypos);
		setTreasureChits(new ArrayList<TreasureChit>());
		setMonsterChits(new ArrayList<Monster>());
		setPeopleHere(new ArrayList<PlayerChit>());
		setSound(new ArrayList<SoundChit>());
		setPersonHere(new PlayerChit());
		
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
	
	public void setPeopleHere(ArrayList<PlayerChit> playerChits) {
		this.peopleHere = playerChits;
	}

	public ArrayList<PlayerChit> getPeopleHere() {
		return peopleHere;
	}
	
	public void movePersonHere(PlayerChit person) {
		this.peopleHere.add(person);
		setPlayerHere(true);
	}
	
	public void removePersonHere(PlayerChit person) {
		if(peopleHere.size()>0){
			this.peopleHere.remove(person);
			for(int i=0; i<peopleHere.size(); i++){
				if(peopleHere.get(i).equals(person)){
					this.peopleHere.remove(i);
					if(peopleHere.size() < 1){
						setPlayerHere(false);						
						System.out.println("no body is here");

					}
				
					
					}
			}
		}
	}

	public void removePerson(PlayerChit person) {
		if(personHere.equals(person)){
			person.setName(null);
			person.setUrl(null);

		}
	}
	
	public PlayerChit getPersonHere() {
		return personHere;
	}

	public void setPersonHere(PlayerChit personHere) {
		this.personHere = personHere;
	}

	public NativeGroup getNatives() {
		return natives;
	}

	public void setNatives(NativeGroup natives) {
		this.natives = natives;
	}

	public ArrayList<SoundChit> getSound() {
		return sound;
	}

	public void setSound(ArrayList<SoundChit> sound) {
		this.sound = sound;
	}
}
