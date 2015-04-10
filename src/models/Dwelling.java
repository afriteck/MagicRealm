package models;

import natives.NativeGroup;
import gameBoard.Clearing;
import gameBoard.Tiles;

public class Dwelling {
	
	private String name;
	private String fpath;
	private int clearing;
	private String tile;

	private NativeGroup natives;

	
	public Dwelling(String name, String fpath){
		this.name=name;
		this.fpath=fpath;
		
	}
	
	public Dwelling(){
		
	}
	
public Dwelling(String name){
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}



	public int getClearing() {
		return clearing;
	}

	public void setClearing(int clearing) {
		this.clearing = clearing;
	}


	public NativeGroup getNatives() {
		return natives;
	}

	public void setNatives(NativeGroup natives) {
		this.natives = natives;
	}

	public String getTile() {
		return tile;
	}

	public void setTile(String tile) {
		this.tile = tile;
	}

	

}
