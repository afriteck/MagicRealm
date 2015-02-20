package models;

public class Native extends Entity {

	private Weapons weapon;
	
	
	public Native(String nativeName){
		// Take native name and parse native JSON. Used returned values to fill in details for native
	}
	
	/***** Getter Methods *****/
	public Weapons getWeapon() {
		return this.weapon;
	}
	
		/***** Setter Methods *****/
	// Set the current native's inventory
	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}
}
