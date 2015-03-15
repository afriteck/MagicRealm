package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public class Lancers extends NativeGroup{

	
private static LinkedList<Native> natives;   
    
	private Lancer LHQ;
	private Lancer l1;
	private Lancer l2;
	private Lancer l3;
	private int cost;


    

	public Lancers() {
		
		initializeNatives();
		setName("Lancers");
		setTile("BORDERLAND");
		setClearing(1);
		setHired(false);

	
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeLHQ();
		initializel1();
		initializel2();
		initializel3();
		setNatives(natives);
		setCost(getHireCost());



		
	
	}
	
	public void initializel1(){
		
		l1 = new Lancer();
		l1.setName("Lancer(L1)");
		l1.setStrikeWeight(DamageEnum.HEAVY);
		l1.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		l1.setMoveSpeed(2);
		l1.setAlertMoveSpeed(4);
		l1.isLeader(false);
		//natives.add(l1);
		addNative(natives, l1);

}
	
	public void initializel2(){
		
		l2 = new Lancer();
		l2.setName("Lancer(L2)");
		l2.setStrikeWeight(DamageEnum.MEDIUM);
		l2.setAlertedStrikeWeight(DamageEnum.HEAVY);
		l2.setMoveSpeed(3);
		l2.setAlertMoveSpeed(4);
		l2.isLeader(false);
		//natives.add(l2);
		addNative(natives, l2);



	}

public void initializel3(){
		
		l3 = new Lancer();
		l3.setName("Lancer(L3)");
		l3.setStrikeWeight(DamageEnum.HEAVY);
		l3.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		l3.setMoveSpeed(5);
		l3.setAlertMoveSpeed(4);
		l3.isLeader(false);
		//natives.add(l3);
		addNative(natives, l3);



	}
	
	public void initializeLHQ(){
		
		LHQ = new Lancer();
		LHQ.setName("Lancer(LHQ)");
		LHQ.setStrikeWeight(DamageEnum.HEAVY);
		LHQ.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		LHQ.setMoveSpeed(3);
		LHQ.setAlertMoveSpeed(4);
		LHQ.isLeader(true);
		//natives.add(LHQ);
		addNative(natives, LHQ);



	}

	public int getHireCost() {	
		int[] sum = new int[natives.size()];
		for(int i = 0; i < natives.size(); i++){
		sum[i] = natives.get(i).getWage();
		
	}
		for(int j : sum)
			total += j;
		setCost(total);
			return total ;
	}



	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}

}
