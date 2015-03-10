package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public class Guard extends NativeGroup{

	
private static LinkedList<Native> natives;   
    
	private GreatSwordsman GHQ;
	private GreatSwordsman g1;
	private GreatSwordsman g2;
	private int cost;


    

	public Guard() {
		
		initializeNatives();
		setName("Guard");
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeGHQ();
		initializeg1();
		initializeg2();
		setNatives(natives);
		setCost(getHireCost());



		
	
	}
	
	public void initializeg1(){
		
		g1 = new GreatSwordsman();
		g1.setName("Great Swordsman(G1)");
		g1.setStrikeWeight(DamageEnum.HEAVY);
		g1.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		g1.setMoveSpeed(5);
		g1.setAlertMoveSpeed(6);
		g1.isLeader(false);
		//natives.add(g1);
		addNative(natives, g1);


}
	
	public void initializeg2(){
		
		g2 = new GreatSwordsman();
		g2.setName("Great Swordsman(G2)");
		g2.setStrikeWeight(DamageEnum.HEAVY);
		g2.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		g2.setMoveSpeed(5);
		g2.setAlertMoveSpeed(6);
		g2.isLeader(false);
		//natives.add(g2);
		addNative(natives, g2);



	}

	public void initializeGHQ(){
		
		GHQ = new GreatSwordsman();
		GHQ.setName("Great Swordsman(GHQ)");
		GHQ.setStrikeWeight(DamageEnum.HEAVY);
		GHQ.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		GHQ.setMoveSpeed(5);
		GHQ.setAlertMoveSpeed(6);
		GHQ.isLeader(true);
		//natives.add(GHQ);
		addNative(natives, GHQ);



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
