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
	private String hiddenfpath;
	private String name;
	private boolean hidden = false;
	private int clearing;
	private String tile;
	
	public String getFpath() {
		if(hidden == false){
			return fpath;
		}else{
			return hiddenfpath;
		}
	}
	public void setFpath(String filepath) {
		this.fpath = filepath;
	}
	public void setHiddenFpath(String filepath) {
		
		this.hiddenfpath = filepath;
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
			setFpath("/sound/howl-alert.png");
			setHiddenFpath("/sound/howl-nonalert.png");
			setName("HOWL");
			setHidden(false);
		}
	}
	
	public static class Roar extends SoundChit {
			
			public Roar(){
				setFpath("/sound/roar-alert.jpg");
				setHiddenFpath("/sound/roar-nonalert.png");
				setName("ROAR");
				setHidden(false);
			}
		}
	
	public static class Slither extends SoundChit {
		
		public Slither(){
			setFpath("/sound/slither-alert.png");
			setHiddenFpath("/sound/slither-nonalert.jpg");
			setName("SLITHER");
			setHidden(false);
		}
	}
	
	public static class Flutter extends SoundChit {
		
		public Flutter(){
			setFpath("/sound/flutter-alert.png");
			setHiddenFpath("/sound/flutter-nonalert.png");
			setName("FLUTTER");
			setHidden(false);
		}
	}
	
	public static class Patter extends SoundChit {
		
		public Patter(){
			setFpath("/sound/patter-alert.png");
			setHiddenFpath("/sound/patter-nonalert.png");
			setName("PATTER");
			setHidden(false);
		}
	}
	
}
