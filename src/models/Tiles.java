/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author joshwhite
 *
 */
public class Tiles {

	private String tileName;
	private String filePath;
	private int theta;
	private ArrayList<Clearing> tileClearings;
	
	
	public Tiles(String name, String fPath, int rotation, ArrayList<Clearing> clearings){
		setName(name);
		setFilePath(fPath);
		setTheta(rotation);
		setClearings(clearings);
	}
	
	public Tiles(String name, String fPath, ArrayList<Clearing> clearings){
		setName(name);
		setFilePath(fPath);
		setClearings(clearings);
	}

	public Tiles(String name){
		setName(name);
	}

	public Tiles(){
		
	}
	public String getName() {
		return tileName;
	}


	public void setName(String tileName) {
		this.tileName = tileName;
	}


	public ArrayList<Clearing> getClearings() {
		return tileClearings;
	}


	public void setClearings(ArrayList<Clearing> tileClearings) {
		this.tileClearings = tileClearings;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String toString() {
		String strToReturn = "Tile Name: " + tileName + " at file path: " + filePath + " Clearings in tile: \n";

		for(int i = 0; i < tileClearings.size(); i++) {
			strToReturn += tileClearings.get(i);
		}
		
		return strToReturn;
		
	}

	public int getTheta() {
		return theta;
	}

	public void setTheta(int rotation) {
		this.theta = rotation;
	}
}
