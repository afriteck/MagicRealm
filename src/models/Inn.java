package models;

import natives.Rogues;
import gameBoard.BoardTiles;

public class Inn extends Dwelling{
	BoardTiles bt;

public Inn(){
		
		setName("INN");
		//setHome("BAD VALLEY");
		setClearing(5);
		setFpath("/dwellings/inn.gif");
		setNatives(new Rogues());
		
	}




}
