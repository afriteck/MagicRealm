package models;

import natives.Order;
import gameLogic.Iteration1Board;

public class Chapel extends Dwelling{

public Iteration1Board ib;
	public Chapel(){
		
		//ib = new Iteration1Board();
		setName("CHAPEL");
		setFpath("/dwellings/chapel.gif");
		setNatives(new Order());
		
	}

}
