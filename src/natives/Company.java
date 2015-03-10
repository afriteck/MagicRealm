package natives;

import java.util.LinkedList;

import models.Armor;
import models.DamageEnum;
import models.Things;
import models.TreasureChit;
import models.Weapons;

public class Company extends NativeGroup {

	
	
private static LinkedList<Native> natives;   
private int cost;

    
	private ShortSwordsman CHQ;
	private ShortSwordsman c1;
	private Pikeman c2;
	private Pikeman c3;
	private Pikeman c4;
	private GreatSwordsman c5;
	private Crossbowman c6;
	//private int hireCost;

    

	public Company() {
		
		initializeNatives();
		setName("Company");
	
	}



	public void initializeNatives(){
		
		natives = new LinkedList<Native>(); 
		
		initializeCHQ();
		initializec1();
		initializec2();
		initializec3();
		initializec4();
		initializec5();
		initializec6();
		setNatives(natives);
		setCost(getHireCost());

		
	
	}
	
	public void initializec1(){
		
		c1 = new ShortSwordsman();
		c1.setName("Short Swordsman(C1)");
		c1.setStrikeWeight(DamageEnum.LIGHT);
		c1.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		c1.setMoveSpeed(4);
		c1.setAlertMoveSpeed(3);
		c1.isLeader(false);
		addNative(natives, c1);
}
	
	public void initializec2(){
		
		c2 = new Pikeman();
		c2.setName("Pikeman(C2)");
		c2.setStrikeWeight(DamageEnum.HEAVY);
		c2.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		c2.setMoveSpeed(4);
		c2.setAlertMoveSpeed(5);
		c2.isLeader(false);
		//natives.add(c2);
		addNative(natives, c2);

	}

	public void initializec3(){
		
		c3 = new Pikeman();
		c3.setName("Pikeman(C3)");
		c3.setStrikeWeight(DamageEnum.HEAVY);
		c3.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		c3.setMoveSpeed(4);
		c3.setAlertMoveSpeed(3);
		c3.isLeader(false);
		//natives.add(c3);
		addNative(natives, c3);


	}

	public void initializec4(){
		
		c4 = new Pikeman();
		c4.setName("Pikeman(C4)");
		c4.setStrikeWeight(DamageEnum.HEAVY);
		c4.setAlertedStrikeWeight(DamageEnum.MEDIUM);
		c4.setMoveSpeed(4);
		c4.setAlertMoveSpeed(3);
		c4.isLeader(false);
		//natives.add(c4);
		addNative(natives, c4);


	}

	public void initializec5(){
		
		c5 = new GreatSwordsman();
		c5.setName("Great Swordsman(C5)");
		c5.setStrikeWeight(DamageEnum.TREMENDOUS);
		c5.setAlertedStrikeWeight(DamageEnum.HEAVY);
		c5.setMoveSpeed(6);
		c5.setAlertMoveSpeed(5);
		c5.isLeader(false);
		//natives.add(c5);
		addNative(natives, c5);

	}

	
public void initializec6(){
		
		c6 = new Crossbowman();
		c6.setName("Crossbowman(C6)");
		c6.setStrikeWeight(DamageEnum.HEAVY);
		c6.setAlertedStrikeWeight(DamageEnum.HEAVY);
		c6.setMoveSpeed(5);
		c6.setAlertMoveSpeed(4);
		c6.isLeader(false);
		//natives.add(c6);
		addNative(natives, c6);


	}
	
	public void initializeCHQ(){
		
		CHQ = new ShortSwordsman();
		CHQ.setName("Short Swordsman(CHQ)");
		CHQ.setStrikeWeight(DamageEnum.MEDIUM);
		CHQ.setAlertedStrikeWeight(DamageEnum.LIGHT);
		CHQ.setMoveSpeed(5);
		CHQ.setAlertMoveSpeed(3);
		CHQ.isLeader(true);
		//natives.add(CHQ);
		addNative(natives, CHQ);


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

	
	/*
	public static void main(String[] args){
		
	Company cp = new Company();
	Bashkars ba = new Bashkars();
	Rogues rg = new Rogues();
	

	System.out.println(cp.getName() + " costs " + cp.getHireCost());
	for(int i = 0; i < cp.size(); i++)
		System.out.println(cp.getNatives().get(i).getName() + cp.getNatives().get(i).getWage());
	
	
	System.out.println(ba.getName() + " costs " + ba.getHireCost());
	for(int i = 0; i < ba.size(); i++)
		System.out.println(ba.getNatives().get(i).getName() + ba.getNatives().get(i).getWage());
	

	System.out.println(rg.getName() + " costs " + rg.getHireCost());
	for(int i = 0; i < rg.size(); i++)
		System.out.println(rg.getNatives().get(i).getName() + rg.getNatives().get(i).getWage());
	
	
}*/
}



