/**
 * 
 */
package models;

/**
 * @author joshwhite
 *
 */
public class SoundChit {
	private String fpath;
	private String name;
	private boolean hidden = false;
	private int clearing;
	private String tile;
	
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String filepath) {
		this.fpath = filepath;
	}
	public String getName() {
		return name;
	}
	public void setName(String type) {
		this.name = type;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public int getClearing() {
		return clearing;
	}
	public void setClearing(int clearing) {
		this.clearing = clearing;
	}

	public String getTile() {
		return tile;
	}
	public void setTile(String tile) {
		this.tile = tile;
	}

	public static class Howl extends SoundChit {
		
		public Howl(){
			setFpath("wolf.gif");
			setName("HOWL");
		}

	}
}
