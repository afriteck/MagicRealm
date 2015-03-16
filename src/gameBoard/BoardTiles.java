/**
 * 
 */
package gameBoard;

import java.util.ArrayList;

import javax.swing.JOptionPane;


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
	
	public int size(){
		return tiles.size();
	}
	
	public ArrayList<Tiles> getAllTiles(){ return tiles; }
	
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

	public String getFileName(int i) {
		// TODO Auto-generated method stub
		if(i<tiles.size()){
			return tiles.get(i).getFilePath();
		}else{
			return null;
		}
	}
	
	public Tiles getTile(String name) {
		// TODO Auto-generated method stub
		Tiles wantedTile = null;
		for(int i=0; i<tiles.size(); i++){
			if(tiles.get(i).getName().equals(name)){wantedTile = tiles.get(i);}
		}
		if(wantedTile != null){
			//System.out.println(wantedTile.getName());
			return wantedTile;
		}else{
			JOptionPane.showMessageDialog(null, "Error. That is not a valid tile!");
			System.out.println("Error. That is not a valid tile!");
			return wantedTile;
		}
	}

	public Tiles getTile(int i) {
		// TODO Auto-generated method stub
		if(i<tiles.size()){
			return tiles.get(i);
		}else{
			return null;
		}
	}
}
