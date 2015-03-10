package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public class Bashkars extends NativeGroup {
	
    private static LinkedList<Native> natives;   
    
	private Raider BHQ;
	private Raider b1;
	private Raider b2;
	private Raider b3;
	private Raider b4;
	private Raider b5;
	//private int cost;
    

	public Bashkars() {
		
		initializeNatives();
		setName("Bashkars");
	
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeBHQ();
		initializeB1();
		initializeB2();
		initializeB3();
		initializeB4();
		initializeB5();
		setNatives(natives);
		setCost(getHireCost());


		
	
	}
	
	public void initializeB1(){
		
		b1 = new Raider();
		b1.setName("Raider(B1)");
		b1.setStrikeWeight(DamageEnum.MEDIUM);
		b1.setAlertedStrikeWeight(DamageEnum.LIGHT);
		b1.setMoveSpeed(3);
		b1.setAlertMoveSpeed(3);
		b1.isLeader(false);
		//natives.add(b1);
		addNative(natives, b1);


}
	
	public void initializeB2(){
		
		b2 = new Raider();
		b2.setName("Raider(B2)");
		b2.setStrikeWeight(DamageEnum.MEDIUM);
		b2.setAlertedStrikeWeight(DamageEnum.LIGHT);
		b2.setMoveSpeed(2);
		b2.setAlertMoveSpeed(3);
		b2.isLeader(false);
		//natives.add(b2);
		addNative(natives, b2);

	}

	public void initializeB3(){
		
		b3 = new Raider();
		b3.setName("Raider(B3)");
		b3.setStrikeWeight(DamageEnum.LIGHT);
		b3.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		b3.setMoveSpeed(2);
		b3.setAlertMoveSpeed(3);
		b3.isLeader(false);
		//natives.add(b3);
		addNative(natives, b3);

	}

	public void initializeB4(){
		
		b4 = new Raider();
		b4.setName("Raider(B4)");
		b4.setStrikeWeight(DamageEnum.MEDIUM);
		b4.setAlertedStrikeWeight(DamageEnum.LIGHT);
		b4.setMoveSpeed(2);
		b4.setAlertMoveSpeed(4);
		b4.isLeader(false);
		//natives.add(b4);
		addNative(natives, b4);

	}

	public void initializeB5(){
		
		b5 = new Raider();
		b5.setName("Raider(B5)");
		b5.setStrikeWeight(DamageEnum.LIGHT);
		b5.setAlertedStrikeWeight(DamageEnum.LIGHT);
		b5.setMoveSpeed(4);
		b5.setAlertMoveSpeed(4);
		b5.isLeader(false);
		//natives.add(b5);
		addNative(natives, b5);

	}

	public void initializeBHQ(){
		
		BHQ = new Raider();
		BHQ.setName("Raider(BHQ)");
		BHQ.setStrikeWeight(DamageEnum.LIGHT);
		BHQ.setAlertedStrikeWeight(DamageEnum.LIGHT);
		BHQ.setMoveSpeed(2);
		BHQ.setAlertMoveSpeed(3);
		BHQ.isLeader(true);
		//natives.add(BHQ);
		addNative(natives, BHQ);


	}
	
	public int getHireCost() {	
		int[] sum = new int[natives.size()];
		for(int i = 0; i < natives.size(); i++){
		sum[i] = natives.get(i).getWage();
		
	}
		for(int j : sum)
			total += j;
			return total ;
	}



	/*public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}*/


}