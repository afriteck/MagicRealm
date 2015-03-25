package models;

import gameLogic.Iteration1Board;
import natives.Order;

public class Chapel extends Dwelling {

	public Iteration1Board ib;

	public Chapel() {

		// ib = new Iteration1Board();
		setName("CHAPEL");
		setFpath("/dwellings/chapel.gif");
		setNatives(new Order());

	}

}
