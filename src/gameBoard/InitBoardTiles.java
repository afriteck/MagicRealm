package gameBoard;



import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

import models.TreasureChit;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class InitBoardTiles {

	//private BoardTiles bt = new BoardTiles();
	
	public static BoardTiles initializeTiles() {
		JSONParser parser = new JSONParser();
		long xPos, yPos;
		ArrayList<Clearing> clearingList = null;
		Clearing currClearing;
		Tiles tile = null;
		BoardTiles bt = new BoardTiles();
		
				
		try {
			System.out.println(InitBoardTiles.class.getResource("/res/data.json"));
			URL url = InitBoardTiles.class.getResource("/res/data.json");
			JSONArray a = (JSONArray) parser.parse(new FileReader(url.getPath()));
			
			for(Object o : a) {
				JSONObject currTile = (JSONObject) o;
				clearingList = new ArrayList<Clearing>();
				
				String tileName = (String) currTile.get("tileName");
				
				String tileFileName = (String) currTile.get("fileName");
								
				JSONObject clearings = (JSONObject) currTile.get("numbers");
								
				for(int i = 0; i <=6; i++) {
					if(clearings.containsKey(Integer.toString(i))) {
						JSONObject clearingNum = (JSONObject) clearings.get(Integer.toString(i));
						xPos = (long) clearingNum.get("x");
						yPos = (long) clearingNum.get("y");

						currClearing = new Clearing(i, xPos, yPos);
						clearingList.add(currClearing);
					}
				}
				tile = new Tiles(tileName, tileFileName, clearingList);
				bt.addTile(tile);
			}
			
			//System.out.println(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bt;
	}
}
