/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author josh
 *
 */
public class Treasure {

	private ArrayList<TreasureChit> treasure;
	
	public Treasure(){
		//constructor
		treasure = new ArrayList<TreasureChit>();
	}
	
	public ArrayList<TreasureChit> getTreasure(){ return treasure; }
}
