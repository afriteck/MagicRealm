package models;

import java.util.ArrayList;
import java.util.LinkedList;

import natives.NativeGroup;

public class Dwarf extends Things{
	
	private static final String url = "dwarf.png";

	static Weapons weapon ;
	private static LinkedList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1;
	private LinkedList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private LinkedList<Weapons> myweapons;    // the chatacters arsenal

    private ArrayList<Counters> readyCounter;
    private ArrayList<Counters> fatiguedCounter;


	public Dwarf(){
		setUrl(url);
		setName("Dwarf");
		weapon = new GreatAxe();
		myArsenal = new LinkedList<Armor>();
		myweapons = new  LinkedList<Weapons>();

		myArmor1 = new Helmet();
		hiredNatives =  new LinkedList<NativeGroup>();
	    hiredNative =  new NativeGroup();
	    fatiguedCounter = new ArrayList<Counters>();
	    readyCounter = new ArrayList<Counters>();
	    
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
	    setMyweapons(myweapons);
		setAlert(false);


		
	    setWeapon(weapon);						
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(5);
		
		weapon.setReadySharpness(2);
		setGold(10);
		setSpeed(5);
		setPlayerArmoury(myArsenal);
	
		addArmor(myArmor1);
		myweapons.add(weapon);

		setVisibility(true);


		readyCounter.add(new Counters("DUCK", DamageEnum.TREMENDOUS, 3, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.HEAVY, 6, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 5, 1));		
		readyCounter.add(new Counters("MOVE", DamageEnum.TREMENDOUS, 6, 1));		
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 6, 0));		
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 4, 2));				
		readyCounter.add(new Counters("MOVE", DamageEnum.HEAVY, 5, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.TREMENDOUS, 6, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.HEAVY, 4, 2));						
		readyCounter.add(new Counters("MOVE", DamageEnum.TREMENDOUS, 5, 2));
		readyCounter.add(new Counters("FIGHT", DamageEnum.TREMENDOUS, 5, 2));
		readyCounter.add(new Counters("FIGHT", DamageEnum.TREMENDOUS, 5, 2));
		
		setReadyCounter(readyCounter);
	    setFatiguedCounter(fatiguedCounter);
		
	
	
	
	}


}
