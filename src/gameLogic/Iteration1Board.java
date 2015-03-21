/**
 * 
 */
package gameLogic;

import gameBoard.BoardTiles;
import gui.HexTiles;
import models.Chapel;
import models.Dwelling;
import models.GuardHouse;
import models.House;
import models.Inn;
import natives.Guard;
import natives.Order;
import natives.Rogues;
import natives.Soldiers;

/**
 * @author joshwhite
 *
 */
public class Iteration1Board {
	
	private static Chapel chapel = new Chapel();
	private static GuardHouse guardhouse = new GuardHouse();
	private static Inn inn = new Inn();
	private static House house = new House();
	
	public static void it1Board(BoardTiles bt){
		//Guard guard = new Guard();
		//Rogues rogues = new Rogues();
		//Order order = new Order();
		//Soldiers soldiers = new Soldiers();
		
		//bt.getTile("AWFUL VALLEY").getClearingByNum(5).setDwelling(new Dwelling("Chapel", "/dwellings/chapel.gif"));

		
		/*
		
		bt.getTile("AWFUL VALLEY").getClearingByNum(5).setDwelling(chapel);
		bt.getTile("DARK VALLEY").getClearingByNum(5).setDwelling(guardhouse);
		bt.getTile("BAD VALLEY").getClearingByNum(5).setDwelling(inn);
		bt.getTile("CURST VALLEY").getClearingByNum(5).setDwelling(house);
		*/
		//guard.setHome(guardhouse);
		//rogues.setHome(inn);
		//order.setHome(chapel);
		//soldiers.setHome(house);
		
		/*Monster goul = new Monster("Ghost");
		goul.setImgFilePath("ghost.gif");
		bt.getTile("AWFUL VALLEY").getClearings().get(3).addMonster(goul);*/
		HexTiles.placeTile(0, bt.getTile("OAK WOODS"), 120); 
		HexTiles.placeTile(1, bt.getTile("BAD VALLEY"), 180); 
		HexTiles.placeTile(2, bt.getTile("BORDERLAND"), 180); 
		HexTiles.placeTile(3, bt.getTile("LEDGES"), 120); 
		HexTiles.placeTile(4, bt.getTile("CRAG"), 60); 
		HexTiles.placeTile(5, bt.getTile("DEEP WOODS"), 240); 
		HexTiles.placeTile(6, bt.getTile("MAPLE WOODS"), 0); 
		HexTiles.placeTile(7, bt.getTile("MOUNTAIN"), 180); 
		HexTiles.placeTile(8, bt.getTile("CAVERN"), 300); 
		HexTiles.placeTile(9, bt.getTile("CAVES"), 0); 
		HexTiles.placeTile(10, bt.getTile("HIGH PASS"), 0); 
		HexTiles.placeTile(11, bt.getTile("EVIL VALLEY"), 0); 
		HexTiles.placeTile(12, bt.getTile("CLIFF"), 180); 
		HexTiles.placeTile(30, bt.getTile("LINDEN WOODS"), 300); //30
		HexTiles.placeTile(29, bt.getTile("AWFUL VALLEY"), 240); //29
		HexTiles.placeTile(15, bt.getTile("DARK VALLEY"), 0); 
		HexTiles.placeTile(16, bt.getTile("CURST VALLEY"), 240); 
		HexTiles.placeTile(17, bt.getTile("NUT WOODS"), 60); 
		HexTiles.placeTile(18, bt.getTile("RUINS"), 0); 
		HexTiles.placeTile(21, bt.getTile("PINE WOODS"), 240); //21
	}

public Chapel getChapel(){
	return chapel;
}

public Inn getInn(){
	return inn;
}

}
