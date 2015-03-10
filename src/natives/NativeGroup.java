package natives;

import java.util.LinkedList;

public  class NativeGroup {

    private String name;
    private LinkedList<Native> natives;   
	private int hireCost;
	int sum;
	int total ;
	private int cost;


	
    
    public NativeGroup(){
    	
    }
  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public  LinkedList<Native> getNatives() {
		return natives;
	}


	public  void setNatives(LinkedList<Native> natives) {
		this.natives = natives;
	}

	
	public int size() {
		 return getNatives().size();
		}

	

	
	
	
	public void setHireCost(int hireCost) {
		this.hireCost = hireCost;
	}   

	public void addNative(LinkedList<Native> groupnative, Native nt) {
		this.natives = groupnative;
		groupnative.add(nt);
	} 
	

	public int getHireCost() {	
		/*int[] sum = new int[natives.size()];
		for(int i = 0; i < natives.size(); i++){
		sum[i] = natives.get(i).getWage();
		
	}
		for(int j : sum)
			total += j;
			return total ;*/
		return hireCost;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


}
