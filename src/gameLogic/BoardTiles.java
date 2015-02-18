/**
 * 
 */
package gameLogic;

import java.util.ArrayList;

import models.Tiles;

/**
 * @author joshwhite
 *
 */
public class BoardTiles {

	private ArrayList<Tiles> tiles;
	
	public BoardTiles(){
		//constructor
		tiles = new ArrayList<Tiles>();
	}
	
	public ArrayList<Tiles> getTiles(){ return tiles; }
	
	public void addTile(Tiles foo){
		tiles.add(foo);
	}
	
	public void removeTile(Tiles foo, int index){
		tiles.remove(index);
	}
	
	public String toString() {
		String strToReturn = "";
		
		for(int i = 0; i < tiles.size(); i++) {
			strToReturn += tiles.get(i).toString() + "\n";
		}
		
		return strToReturn;
	}
}