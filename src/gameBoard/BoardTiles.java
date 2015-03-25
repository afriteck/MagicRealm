/**
 * 
 */
package gameBoard;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author joshwhite
 */
public class BoardTiles {

	private ArrayList<Tiles> tiles;

	// private boolean legalTile = true;

	public BoardTiles() {
		// constructor
		tiles = new ArrayList<Tiles>();
	}

	public int size() {
		return tiles.size();
	}

	public ArrayList<Tiles> getAllTiles() {
		return tiles;
	}

	public void addTile(Tiles foo) {
		tiles.add(foo);
	}

	public void removeTile(Tiles foo, int index) {
		tiles.remove(index);
	}

	public String toString() {
		String strToReturn = "";

		for (int i = 0; i < tiles.size(); i++) {
			strToReturn += tiles.get(i).toString() + "\n";
		}

		return strToReturn;
	}

	public String getFileName(int i) {
		if (i < tiles.size()) {
			return tiles.get(i).getFilePath();
		} else {
			return null;
		}
	}

	public Tiles getTile(String name) {
		Tiles wantedTile = null;
		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).getName().equals(name)) {
				wantedTile = tiles.get(i);
				// setLegalTile(true);
			}
		}
		if (wantedTile != null) {
			// System.out.println(wantedTile.getName());
			// setLegalTile(false);

			return wantedTile;
		} else {
			JOptionPane.showMessageDialog(null,
					"Error. That is not a valid tile!");
			System.out.println("Error. That is not a valid tile!");
			// setLegalTile(false);

			return wantedTile;
		}
	}

	public Tiles getTile(int i) {
		if (i < tiles.size()) {
			return tiles.get(i);
		} else {
			return null;
		}
	}

}
