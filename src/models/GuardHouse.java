package models;

import gameBoard.BoardTiles;
import natives.Guard;

public class GuardHouse extends Dwelling {

	public GuardHouse() {

		BoardTiles bt;
		setName("Guard House");
		setFpath("/dwellings/guard.gif");
		setNatives(new Guard());
	}

}
