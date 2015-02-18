package gui;

import gameLogic.BoardTiles;

import java.io.FileReader;
import java.util.ArrayList;

import models.Clearing;
import models.Tiles;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class BoardTest {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		long xPos, yPos;
		ArrayList<Clearing> clearingList = null;
		Clearing currClearing;
		Tiles tile = null;
		BoardTiles bt = new BoardTiles();
				
		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("Z:/eclipse-Juno-Workspace/Magic Realm/src/res/data.json"));
			
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
			
			System.out.println(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
