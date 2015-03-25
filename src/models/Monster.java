package models;

public class Monster extends Entity {

	private char harm;
	private String sharpness;
	private int move;
	private int attack;
	private boolean attentionStatus;

	/***** Constructors *****/
	public Monster(String name) {
		// Use the name passed to parse the JSON file of monsters to build
		// monster
	}

	/**** Getter Methods *****/
	// Get the monster's harm letter
	public char getHarmLetter() {
		return this.harm;
	}

	// Get the monster's sharpness
	public String getSharpness() {
		return this.sharpness;
	}

	// Get the monster's move speed
	public int getMMove() {
		return this.move;
	}

	// Get the monster's attack speed
	public int getAttack() {
		return this.attack;
	}

	// Get the monster's attention status
	public boolean getAttention() {
		return this.attentionStatus;
	}

	/***** Setter Methods *****/
	// Set the monster's harm letter
	public void setHarm(char letter) {
		this.harm = letter;
	}

	// Set the monster's sharpness
	public void setSharpness(String sharpness) {
		this.sharpness = sharpness;
	}

	// Set the monster's
}
