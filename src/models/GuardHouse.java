package models;

import natives.Guard;
import gameBoard.BoardTiles;

public class GuardHouse extends Dwelling{


public GuardHouse(){
	
	BoardTiles bt;
	setName("Guard House");
	setFpath("/dwellings/guard.gif");
	setNatives(new Guard());
}

}
