package models;

public class Counters {

	private String type;
	private DamageEnum strength;
	private int speed;
	private int star;

	public Counters(String type, DamageEnum strength, int speed, int star) {
		setType(type);
		setStrength(strength);
		setSpeed(speed);
		setStar(star);
	}

	public Counters() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DamageEnum getStrength() {
		return strength;
	}

	public void setStrength(DamageEnum strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	public String getDetails() {
		String returnStr;
		
		returnStr = getType() + ": ";
		
		//System.out.println(getStrength());
		if(getStrength().name().equals("LIGHT")) {
			returnStr += "L";
		} else if(getStrength().name().equals("MEDIUM")) {
			returnStr += "M";
		} else if(getStrength().name().equals("HEAVY")) {
			returnStr += "H";
		} else if(getStrength().name().equals("TREMENDOUS")) {
			returnStr += "T";
		}
		
		returnStr += getSpeed();
		
		if(getStar() == 1) {
			returnStr += "*";
		} else if(getStar() == 2) {
			returnStr += "**";
		}
		
		return returnStr;
	}
	
	public String toString() {
		return getType() + " " + getStrength() + " " + getSpeed() + " " + getStar();
	}

}
