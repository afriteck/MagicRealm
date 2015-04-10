package models;

import java.util.ArrayList;
import java.util.LinkedList;

import natives.NativeGroup;

public class BlackKnight extends Things {

	private static final String url = "black_knight.png";
	
	Weapons weapon;
	private static ArrayList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2;
	private ArrayList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private ArrayList<Weapons> myweapons;    // the chatacters arsenal
    private ArrayList<Counters> readyCounter;
    private ArrayList<Counters> fatiguedCounter;
	
	public BlackKnight(){
		
		setUrl(url);
		
		setName("Black Knight");
	
		weapon = new Mace();
		myweapons = new  ArrayList<Weapons>();

		setWeapon(weapon);
		
		myArsenal = new ArrayList<Armor>();
		myArmor1 = new Shields();
		myArmor2 = new SuitsOfArmor();
		//hiredNatives =  new ArrayList<NativeGroup>();
	    //hiredNative =  new NativeGroup();
	    
	    fatiguedCounter = new ArrayList<Counters>();
	    readyCounter = new ArrayList<Counters>();
	    
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
	    setMyweapons(myweapons);

		
		setGold(10);
		if(weapon.getSpeed() < 1)
			weapon.setSpeed(3);
		setSpeed(3);
		setPlayerArmoury(myArsenal);
		setAlert(false);


		addArmor(myArmor1);
		addArmor(myArmor2);
		myweapons.add(weapon);

		setVisibility(true);

	
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 5, 0));
		readyCounter.add(new Counters("MOVE", DamageEnum.HEAVY, 5, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 5, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.HEAVY, 6, 0));
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 6, 0));		
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 1));				
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 5, 0));		
		readyCounter.add(new Counters("MOVE", DamageEnum.HEAVY, 4, 2));		
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 4, 2));		
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 2));
	
		setReadyCounter(readyCounter);
	    setFatiguedCounter(fatiguedCounter);
	
	}

	/*
public static void main(String[] args){
		
		Things sm = new BlackKnight();
		System.out.println(sm.getWeapons().getName() + sm.getGold() + sm.getSpeed() + sm.getWeapons().getSharpness()+ sm.getWeapons().getSpeed());
	
		for(int i = 0 ; i < myArsenal.size(); i++){
	    	System.out.println(sm.getName() + " has the following armor " + sm.getCharacterArmory().get(i).getName() + sm.getCharacterArmory().get(i).isDamaged() + sm.getCharacterArmory().get(i).isDestroyed());
	    
		}

}*/

}
