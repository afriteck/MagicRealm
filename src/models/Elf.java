package models;

import java.util.ArrayList;
import java.util.LinkedList;

import natives.NativeGroup;

public class Elf extends Things{
	
	private static final String url = "elf.png";
	
	static Weapons weapon ;
	private static ArrayList<Armor> myArsenal;    // the chatacters arsenal
	private Armor myArmor1, myArmor2, myArmor3;
	private ArrayList<NativeGroup> hiredNatives;
    private NativeGroup hiredNative;
    private ArrayList<Weapons> myweapons;    // the chatacters arsenal

    private ArrayList<Counters> readyCounter;
    private ArrayList<Counters> fatiguedCounter;

	public Elf(){
		setUrl(url);
		setName("Elf");
		weapon = new LightBow();
		myArsenal = new ArrayList<Armor>();
		//hiredNatives =  new ArrayList<NativeGroup>();
		myweapons = new  ArrayList<Weapons>();
	    fatiguedCounter = new ArrayList<Counters>();
	    readyCounter = new ArrayList<Counters>();
	    
	    
	  //  hiredNative =  new NativeGroup();	    
	    setHiredNatives(hiredNatives);
	    setHiredNative(hiredNative);
	    setMyweapons(myweapons);
		setAlert(false);

		
		
		setWeapon(weapon);
		if(weapon.getSpeed() < 1)
		weapon.setSpeed(4);
		
		weapon.setReadySharpness(1);
		weapon.setReadySpeed(3);
		setGold(10);
		setSpeed(4);
	
		setPlayerArmoury(myArsenal);
		myweapons.add(weapon);
		setVuln(DamageEnum.LIGHT);

		setVisibility(true);

	
	
		
		readyCounter.add(new Counters("MOVE", DamageEnum.LIGHT, 3, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.LIGHT, 3, 1));
		readyCounter.add(new Counters("MOVE", DamageEnum.LIGHT, 2, 1));		
		readyCounter.add(new Counters("MOVE", DamageEnum.MEDIUM, 4, 0));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 3, 1));
		readyCounter.add(new Counters("FIGHT", DamageEnum.MEDIUM, 4, 0));

		
		setReadyCounter(readyCounter);
	    setFatiguedCounter(fatiguedCounter);
	
	
	
	}


}
