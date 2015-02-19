package models;

import java.util.LinkedList;

public class BlackKnight extends Things {

	Weapons weapon;
	 private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2;
	
	
	public BlackKnight(){
		
		setName("Black Knight");
	
		weapon = new Mace();
		setWeapon(weapon);
		
		myArsenal = new LinkedList<Armor>();
		myArmor1 = new Shields();
		myArmor2 = new SuitsOfArmor();
		
		setGold(10);
		if(weapon.getSpeed() < 1)
			weapon.setSpeed(3);
		setSpeed(3);
		setPlayerArmoury(myArsenal);

		addArmor(myArmor1);
		addArmor(myArmor2);

	
	}

public static void main(String[] args){
		
		Things sm = new BlackKnight();
		System.out.println(sm.getWeapons().getName() + sm.getGold() + sm.getSpeed() + sm.getWeapons().getSharpness()+ sm.getWeapons().getSpeed());
	
		for(int i = 0 ; i < myArsenal.size(); i++){
	    	System.out.println(sm.getName() + " has the following armor " + sm.getCharacterArmory().get(i).getName() + sm.getCharacterArmory().get(i).isDamaged() + sm.getCharacterArmory().get(i).isDestroyed());
	    
		}

}

}
