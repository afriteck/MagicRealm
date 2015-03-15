package models;
/**
 * @author joshwhite
 *
 */
public class WarningChit {
	
	
	private  String name;
    private String url;
	private boolean hidden = false;
	private String home;
	private int clearing;

	//private Smoke sm;
	//private Bones bn;
	
	
	//public Smoke getSmoke(){
		//return sm;
	//}
	
	
	//public Bones getBones(){
		//return bn;
	//}
	
	public String getName(){
		return name;
	}
	
	public String getUrl(){
		return url;
	}
	
	public boolean getHidden(){
		return hidden;
	}
	
	
	public  void setName(String string) {
		this.name = string;
	}

	public void setUrl(String string) {
		this.url = string;
	}
	
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public int getClearing() {
		return clearing;
	}

	public void setClearing(int clearing) {
		this.clearing = clearing;
	}

	public static class Bones extends WarningChit{
		
		public Bones(){
			setName("BONES");
			setUrl("bones.png");
		}
	}

    public static class Dank extends WarningChit{
		
    	
    	public Dank(){
    	setName("DANK");
    	setUrl("dank.png");
    	}

    }


    public static class Ruins extends WarningChit{
    	public Ruins(){
        	setName("RUINS");
        	setUrl("ruins.png");
    	}

    }


    public static class Smoke extends WarningChit{
    public Smoke(){
    	setName("SMOKE");
    	setUrl("smoke.png");

    }

    }


    public static class Stink extends WarningChit{
    	public Stink(){
    		setName("STINK");
    		setUrl("stink.png");
    	}

    }


	











}
