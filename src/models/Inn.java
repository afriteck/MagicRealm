package models;

import gameBoard.BoardTiles;

public class Inn extends Dwelling{
	BoardTiles bt;

public Inn(){
		
		setName("INN");
		//setHomeTile(bt.getTile("BAD VALLEY"));
		setHome("BAD VALLEY");
		//setCurrentClearing(bt.getTile("BAD VALLEY").getClearingByNum(5));
		setClearing(5);

		setFpath("/dwellings/inn.gif");
		
	}




}
