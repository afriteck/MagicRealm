/**
 * 
 */
package gameLogic;

import models.Dwelling;
import gui.HexTiles;

/**
 * @author joshwhite
 *
 */
public class Iteration1Board {
	
	public static void it1Board(BoardTiles bt){
		bt.getTile("AWFUL VALLEY").getClearingByNum(5).setDwelling(new Dwelling("CHAPEL", "/dwellings/chapel.gif"));
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
}
