package natives;

import java.util.LinkedList;

import models.DamageEnum;

public class Woodfolk extends NativeGroup{

	
	 private static LinkedList<Native> natives;   
	    
		private Archer WHQ;
		private Archer w1;
		private Archer w2;
		private int cost;

	

		public Woodfolk(){
			
			initializeNatives();
			setName("Woodfolk");
			setTile("CRAG");
			setClearing(4);
			setHired(false);
			setFpath("/natives/woodfolk.png");


			
		}


		public void initializeNatives(){
			
			natives = new LinkedList<Native>(); 
			
			initializeWHQ();
			initializeW1();
			initializeW2();
			setNatives(natives);
			setCost(getHireCost());


		

			
		
		}
		
		public void initializeW1(){
			
			w1 = new Archer();
			w1.setName("Archer(W1)");
			WHQ.setStrikeWeight(null);
			w1.setAlertedStrikeWeight(DamageEnum.LIGHT);
			w1.setMoveSpeed(2);
			w1.setAlertMoveSpeed(4);
			w1.isLeader(false);
			//natives.add(w1);
			addNative(natives, w1);

	}
		
		public void initializeW2(){
			
			w2 = new Archer();
			w2.setName("Archer(W2)");
			WHQ.setStrikeWeight(null);
			w2.setAlertedStrikeWeight(DamageEnum.LIGHT);
			w2.setMoveSpeed(2);
			w2.setAlertMoveSpeed(4);
			w2.isLeader(false);
			//natives.add(w2);
			addNative(natives, w2);

		}

		public void initializeWHQ(){
			
			WHQ = new Archer();
			WHQ.setName("Archer(WHQ)");
			WHQ.setStrikeWeight(null);
			WHQ.setAlertedStrikeWeight(DamageEnum.MEDIUM);
			WHQ.setMoveSpeed(2);
			WHQ.setAlertMoveSpeed(4);
			WHQ.isLeader(true);
			//natives.add(WHQ);
			addNative(natives, WHQ);


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
