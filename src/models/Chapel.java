package models;

import natives.Order;

public class Chapel extends Dwelling{

	public Chapel(){
		
		//ib = new Iteration1Board();
		setName("CHAPEL");
		setFpath("/dwellings/chapel.gif");
		setNatives(new Order());
		
	}

}
