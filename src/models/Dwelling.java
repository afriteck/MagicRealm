package models;

import natives.NativeGroup;
import gameBoard.Clearing;
import gameBoard.Tiles;

public class Dwelling {
	
	private String name;
	private String fpath;
	private Tiles homeTile;
	private String home;
	private Clearing currentClearing;
	private int clearing;
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

	public Tiles getHomeTile() {
		return homeTile;
	}

	public void setHomeTile(Tiles homeTile) {
		this.homeTile = homeTile;
	}

	public Clearing getCurrentClearing() {
		return currentClearing;
	}

	public void setCurrentClearing(Clearing clearing) {
		this.currentClearing = clearing;
	}

	public int getClearing() {
		return clearing;
	}

	public void setClearing(int clearing) {
		this.clearing = clearing;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public NativeGroup getNatives() {
		return natives;
	}

	public void setNatives(NativeGroup natives) {
		this.natives = natives;
	}

}
