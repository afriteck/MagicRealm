package natives;

import java.util.LinkedList;

import models.DamageEnum;

public class Patrol extends NativeGroup{

	
private static LinkedList<Native> natives;   
    
	private ShortSwordsman PHQ;
	private ShortSwordsman p1;
	private ShortSwordsman p2;
	private int cost;

    

	public Patrol() {
		
		initializeNatives();
		setName("Patrol");
		setTile("CAVERN");
		setClearing(2);
	
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializePHQ();
		initializep1();
		initializep2();
		setNatives(natives);
		setCost(getHireCost());

	
	
	}
	
	public void initializep1(){
		
		p1 = new ShortSwordsman();
		p1.setName("Short Swordsman(P1)");
		p1.setStrikeWeight(DamageEnum.LIGHT);
		p1.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		p1.setMoveSpeed(3);
		p1.setAlertMoveSpeed(4);
		p1.isLeader(false);
		//natives.add(p1);
		addNative(natives, p1);

}
	
	public void initializep2(){
		
		p2 = new ShortSwordsman();
		p2.setName("Short Swordsman(P2)");
		p2.setStrikeWeight(DamageEnum.MEDIUM);
		p2.setAlertedStrikeWeight(DamageEnum.LIGHT);
		p2.setMoveSpeed(3);
		p2.setAlertMoveSpeed(3);
		p2.isLeader(false);
		//natives.add(p2);
		addNative(natives, p2);

	}

	
	

	public void initializePHQ(){
		
		PHQ = new ShortSwordsman();
		PHQ.setName("Short Swordsman(OHQ)");
		PHQ.setStrikeWeight(DamageEnum.MEDIUM);
		PHQ.setAlertedStrikeWeight(DamageEnum.LIGHT);
		PHQ.setMoveSpeed(3);
		PHQ.setAlertMoveSpeed(5);
		PHQ.isLeader(true);
		//natives.add(PHQ);
		addNative(natives, PHQ);

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
