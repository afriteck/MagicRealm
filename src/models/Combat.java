package models;

import java.util.ArrayList;
import monsters.Monster;

public class Combat {
	private Weapons characterWeapon, opponentWeapon;
	private Armor characterArmor, opponentArmor;
	private ArrayList<Counters> characterCounters, opponentCounters;
	private int alertedAttackSpeed;
	private int attackSpeed;
	private int alertedMoveSpeed;
	private int moveSpeed;
	boolean endCombat = false;
	
	
	//encounter, melee, 
	public void Fight(Player p1, Object obj) {
		// Get player details
		characterWeapon = p1.getCharacter().getWeapons();
		characterArmor = p1.getCharacter().getArmour();
		characterCounters = p1.getCharacter().getReadyCounter();
				
		if(obj instanceof Player) {			
			// Get opponent details
			opponentWeapon = ((Player) obj).getCharacter().getWeapons();
			opponentArmor = ((Player) obj).getCharacter().getArmour();
			opponentCounters = ((Player) obj).getCharacter().getReadyCounter();
		} else if(obj instanceof Monster) {
			// Get opponent details
			if(((Monster) obj).getWeapon() != null) {
				opponentWeapon = ((Monster) obj).getWeapon();
			}
			
			alertedAttackSpeed = ((Monster) obj).getAlertedAttackSpeed();
			attackSpeed = ((Monster) obj).getAttackSpeed();
			alertedMoveSpeed = ((Monster) obj).getAlertedMoveSpeed();
			moveSpeed = ((Monster) obj).getMoveSpeed();			
		}
	}
}
