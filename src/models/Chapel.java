package models;

import gameLogic.Iteration1Board;

public class Chapel extends Dwelling{

public Iteration1Board ib;
	public Chapel(){
		
		ib = new Iteration1Board();
		setName("CHAPEL");
		//setHomeTile(ib.getChapel());
		//setCurrentClearing(5);
		setFpath("/dwellings/chapel.gif");
		
	}

}
