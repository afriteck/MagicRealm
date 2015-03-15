package natives;

import gameBoard.BoardTiles;
import gameLogic.Iteration1Board;

import java.util.LinkedList;

import models.DamageEnum;
import models.Inn;

public class Rogues extends NativeGroup{

	
	private static LinkedList<Native> natives;   

	private Assasin RHQ;
	private GreatAxeman r1;
	private GreatAxeman r2;
	private ShortSwordsman r3;
	private Archer r4;
	private Assasin r5;
	private Swordsman r6;
	private Swordsman r7;
	private int cost;

    

	public Rogues() {
		
		setName("Rogues");
		setTile("BAD VALLEY");
		setClearing(5);
		initializeNatives();
		
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeRHQ();
		initializer1();
		initializer2();
		initializer3();
		initializer4();
		initializer5();
		initializer6();
		initializer7();
		setNatives(natives);
		setCost(getHireCost());



		
	
	}
	
	public void initializer1(){
		
		r1 = new GreatAxeman();
		r1.setName("Great Axeman(R1)");
		r1.setStrikeWeight(DamageEnum.HEAVY);
		r1.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		r1.setMoveSpeed(4);
		r1.setAlertMoveSpeed(5);
		r1.isLeader(false);
		//natives.add(r1);
		addNative(natives, r1);

}
	
	public void initializer2(){
		
		r2 = new GreatAxeman();
		r2.setName("Great Axeman(R2)");
		r2.setStrikeWeight(DamageEnum.HEAVY);
		r2.setAlertedStrikeWeight(DamageEnum.TREMENDOUS);
		r2.setMoveSpeed(4);
		r2.setAlertMoveSpeed(5);
		r2.isLeader(false);
		//natives.add(r2);
		addNative(natives, r2);

	}

	public void initializer3(){
		
		r3 = new ShortSwordsman();
		r3.setName("Short Swordsman(R3)");
		r3.setStrikeWeight(DamageEnum.MEDIUM);
		r3.setAlertedStrikeWeight(DamageEnum.LIGHT);
		r3.setMoveSpeed(3);
		r3.setAlertMoveSpeed(4);
		r3.isLeader(false);
		//natives.add(r3);
		addNative(natives, r3);

	}

	public void initializer4(){
		
		r4 = new Archer();
		r4.setName("Archer(R4)");
		r4.setStrikeWeight(null);
		r4.setAlertedStrikeWeight(DamageEnum.LIGHT);
		r4.setMoveSpeed(2);
		r4.setAlertMoveSpeed(4);
		r4.isLeader(false);
		//natives.add(r4);
		addNative(natives, r4);

	}

	public void initializer5(){
		
		r5 = new Assasin();
		r5.setName("Assasin(C5)");
		r5.setStrikeWeight(DamageEnum.MEDIUM);
		r5.setAlertedStrikeWeight(DamageEnum.LIGHT);
		r5.setMoveSpeed(4);
		r5.setAlertMoveSpeed(2);
		r5.isLeader(false);
		//natives.add(r5);
		addNative(natives, r5);

	}

	
public void initializer6(){
		
		r6 = new Swordsman();
		r6.setName("Swordsman(R6)");
		r6.setStrikeWeight(DamageEnum.MEDIUM);
		r6.setAlertedStrikeWeight(DamageEnum.LIGHT);
		r6.setMoveSpeed(5);
		r6.setAlertMoveSpeed(4);
		r6.isLeader(false);
		//natives.add(r6);
		addNative(natives, r6);

	}
	
public void initializer7(){
	
	r7 = new Swordsman();
	r7.setName("Swordsman(R7)");
	r7.setStrikeWeight(DamageEnum.MEDIUM);
	r7.setAlertedStrikeWeight(DamageEnum.LIGHT);
	r7.setMoveSpeed(5);
	r7.setAlertMoveSpeed(4);
	r7.isLeader(false);
	//natives.add(r7);
	addNative(natives, r7);

}


public void initializeRHQ(){
		
		RHQ = new Assasin();
		RHQ.setName("Short Swordsman(CHQ)");
		RHQ.setStrikeWeight(DamageEnum.MEDIUM);
		RHQ.setAlertedStrikeWeight(DamageEnum.LIGHT);
		RHQ.setMoveSpeed(4);
		RHQ.setAlertMoveSpeed(2);
		RHQ.isLeader(true);
		//natives.add(RHQ);
		addNative(natives, RHQ);


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
