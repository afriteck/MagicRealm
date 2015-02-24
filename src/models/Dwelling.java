package models;

public class Dwelling {
	
	private String name;
	private String fpath;
	
	public Dwelling(String name, String fpath){
		this.name=name;
		this.fpath=fpath;
		
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

}
