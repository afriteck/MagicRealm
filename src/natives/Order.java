package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public  class Order extends NativeGroup{

	
    private static LinkedList<Native> natives;   
    
	private Knight OHQ;
	private Knight o1;
	private Knight o2;
	private Knight o3;
	private int cost;

    

	public Order() {
		
		initializeNatives();
		setName("Order");
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeOHQ();
		initializeo1();
		initializeo2();
		initializeo3();
		setNatives(natives);
		setCost(getHireCost());


	

		
	
	}
	
	public void initializeo1(){
		
		o1 = new Knight();
		o1.setName("Knight(O1)");
		o1.setStrikeWeight(DamageEnum.HEAVY);
		o1.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		o1.setMoveSpeed(6);
		o1.setAlertMoveSpeed(5);
		o1.isLeader(false);
		//natives.add(o1);
		addNative(natives, o1);

}
	
	public void initializeo2(){
		
		o2 = new Knight();
		o2.setName("Knight(O2)");
		o2.setStrikeWeight(DamageEnum.HEAVY);
		o2.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		o2.setMoveSpeed(5);
		o2.setAlertMoveSpeed(6);
		o2.isLeader(false);
		//natives.add(o2);
		addNative(natives, o2);

	}

	public void initializeo3(){
		
		o3 = new Knight();
		o3.setName("Knight(O3)");
		o3.setStrikeWeight(DamageEnum.HEAVY);
		o3.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		o3.setMoveSpeed(6);
		o3.setAlertMoveSpeed(6);
		o3.isLeader(false);
		//natives.add(o3);
		addNative(natives, o3);


	}

	

	public void initializeOHQ(){
		
		OHQ = new Knight();
		OHQ.setName("Knight(OHQ)");
		OHQ.setStrikeWeight(DamageEnum.HEAVY);
		OHQ.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		OHQ.setMoveSpeed(4);
		OHQ.setAlertMoveSpeed(6);
		OHQ.isLeader(true);
		//natives.add(OHQ);
		addNative(natives, OHQ);

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
