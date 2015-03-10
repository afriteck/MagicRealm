package models;
/**
 * @author joshwhite
 *
 */
public class WarningChit {
	
	
	private  String name;
    private String url;
	private boolean hidden = false;
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
	
	public static class Bones extends WarningChit{
		
		public Bones(){
			setName("BONES");
		}
	}

    public static class Dank extends WarningChit{
		
    	
    	public Dank(){
    	setName("DANK");
    	}

    }


    public static class Ruins extends WarningChit{
    	public Ruins(){
        	setName("RUINS");

    	}

    }


    public static class Smoke extends WarningChit{
    public Smoke(){
    	setName("SMOKE");

    }

    }


    public static class Stink extends WarningChit{
    	public Stink(){
    		setName("STINK");
    	}

    }


	











}
