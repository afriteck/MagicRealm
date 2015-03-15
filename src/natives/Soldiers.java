package natives;

import java.util.LinkedList;

import models.DamageEnum;
import models.House;

public class Soldiers extends NativeGroup{

	
	
private static LinkedList<Native> natives;   
    
	private GreatSwordsman SHQ;
	private Pikeman s1;
	private Pikeman s2;
	private Crossbowman s3;
	private int cost;



    

	public Soldiers() {
		
		initializeNatives();
		setName("Soldiers");
		setTile("CURST VALLEY");
		setClearing(5);	
		setHired(false);

		}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeSHQ();
		initializes1();
		initializes2();
		initializes3();
		setNatives(natives);
		setCost(getHireCost());




		
	
	}
	
	public void initializes1(){
		
		s1 = new Pikeman();
		s1.setName("Pikeman(S1)");
		s1.setStrikeWeight(DamageEnum.HEAVY);
		s1.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		s1.setMoveSpeed(4);
		s1.setAlertMoveSpeed(5);
		s1.isLeader(false);
		//natives.add(s1);
		addNative(natives, s1);

}
	
	public void initializes2(){
		
		s2 = new Pikeman();
		s2.setName("Pikeman(S2)");
		s2.setStrikeWeight(DamageEnum.HEAVY);
		s2.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		s2.setMoveSpeed(4);
		s2.setAlertMoveSpeed(5);
		s2.isLeader(false);
		//natives.add(s2);
		addNative(natives, s2);


	}

public void initializes3(){
		
		s3 = new Crossbowman();
		s3.setName("Crossbowman(S3)");
		s3.setStrikeWeight(DamageEnum.HEAVY);
		s3.setAlertedStrikeWeight(DamageEnum.HEAVY);
		s3.setMoveSpeed(5);
		s3.setAlertMoveSpeed(4);
		s3.isLeader(false);
		//natives.add(s3);
		addNative(natives, s3);


	}
	
	public void initializeSHQ(){
		
		SHQ = new GreatSwordsman();
		SHQ.setName("Great Swordsman(LHQ)");
		SHQ.setStrikeWeight(DamageEnum.TREMENDOUS);
		SHQ.setAlertedStrikeWeight(DamageEnum.HEAVY);
		SHQ.setMoveSpeed(6);
		SHQ.setAlertMoveSpeed(5);
		SHQ.isLeader(true);
		//natives.add(SHQ);
		addNative(natives, SHQ);


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
