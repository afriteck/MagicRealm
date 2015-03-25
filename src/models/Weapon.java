package models;

/**
 * @author Hassan Said
 */

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weapon extends Entity {

	/*
	 * private DamageEnum damage; private DamageEnum readyDamage;
	 */

	/* Set weapon's unready statistics */
	private String[] unreadyStats = new String[4]; // First element of array
													// letter, second is effort,
													// third is fatigue, fourth
													// is sharpness

	// weapons ready status
	private boolean ready = false;

	/* Set weapon's ready statistics */
	private String[] readyStats = new String[4]; // First element of array
													// letter, second is effort,
													// third is fatigue, fourth
													// is sharpness

	private long weaponLength; // Weapon's length
	private boolean missile = false; // Check if the weapon is a missile type
	int hands;
	private long price; // Price of the weapon

	JSONParser parser; // JSON parser

	/***** Constructors *****/
	protected Weapon(String weaponName) {
		// Take the weapon name that is passed as string and search JSON for
		// weapon
		parser = new JSONParser();

		try {
			JSONArray array = (JSONArray) parser
					.parse(new FileReader(
							"Z:/eclipse-Juno-Workspace/Magic Realm/src/res/weaponList.json"));

			for (Object o : array) {
				JSONObject currWeapon = (JSONObject) o;

				String n = (String) currWeapon.get("Name");

				if (n.equals(weaponName)) {
					setImgFilePath((String) currWeapon.get("File Path")); // Set
																			// the
																			// image
																			// file
																			// for
																			// weapon
					setEntityName((String) currWeapon.get("Name")); // Set the
																	// name for
																	// the
																	// entity

					// retrieve the weapon's attack type
					String weaponAttackType = (String) currWeapon.get("Attack");
					if (weaponAttackType.equals("missile")) {
						setMissile(true);
					}

					setWeaponLength((long) currWeapon.get("Length")); // Set the
																		// weapon
																		// length
					setPrice((long) currWeapon.get("Price")); // Set the price
																// of weapon

					JSONObject detailsArray = (JSONObject) currWeapon
							.get("Details");

					/* Get the unalerted statistics for the current weapon */
					JSONObject unAlertedArray = (JSONObject) detailsArray
							.get("Unalerted");

					// Create a temporary array to store un-ready statistics
					String[] tempUnReady = new String[4];

					// if the letter is set then place it in the first element
					// of the un-ready array
					if (unAlertedArray.containsKey("letter")) {
						tempUnReady[0] = (String) unAlertedArray.get("letter");
					}

					// if effort is set then place it in the second element of
					// the un-ready array
					if (unAlertedArray.containsKey("effort")) {
						tempUnReady[1] = (String) unAlertedArray.get("effort");
					}

					// if fatigue is set then place it in the third element of
					// the un-ready array
					if (unAlertedArray.containsKey("fatigue")) {
						tempUnReady[2] = (String) unAlertedArray.get("fatigue");
					}

					// if sharpness is set then place it in the fourth element
					// of the un-ready array
					if (unAlertedArray.containsKey("sharpness")) {
						tempUnReady[2] = (String) unAlertedArray
								.get("sharpness");
					}

					// Set the temporary array to the un-ready array of weapon
					setUnreadyStats(tempUnReady);

					/* Get ready statistics for the current weapon */
					JSONObject alertedArray = (JSONObject) detailsArray
							.get("Alerted");

					// Create a temporary array to store ready statistics
					String[] tempReady = new String[4];

					// if the letter is set then place it in the first element
					// of the ready array
					if (alertedArray.containsKey("letter")) {
						tempReady[0] = (String) alertedArray.get("letter");
					}

					// if effort is set then place it in the second element of
					// the ready array
					if (alertedArray.containsKey("effort")) {
						tempReady[1] = (String) alertedArray.get("effort");
					}

					// if fatigue is set then place it in the third element of
					// the ready array
					if (alertedArray.containsKey("fatigue")) {
						tempReady[2] = (String) alertedArray.get("fatigue");
					}

					// if sharpness is set then place it in the fourth element
					// of the ready array
					if (alertedArray.containsKey("sharpness")) {
						tempReady[2] = (String) alertedArray.get("sharpness");
					}

					// Set the temporary array to the ready array of weapon
					setReadyStats(tempReady);

					// Once all details of weapon are set exit out of loop
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***** Getter Methods *****/
	// Get the weapon's price
	protected long getPrice() {
		return price;
	}

	// Get weapon length
	protected long getWeaponLength() {
		return weaponLength;
	}

	// Get ready status of weapon
	protected boolean getReady() {
		return ready;
	}

	/* Get statistics for the weapon when un-ready */
	protected String[] getUnreadyStats() {
		return unreadyStats;
	}

	/* Get weapon statistics when ready */
	protected String[] getReadyStats() {
		return readyStats;
	}

	/* Check if the weapon attack type is a missile */
	protected boolean isMissile() {
		return missile;
	}

	/***** Setter Methods *****/
	// Set the weapon's price
	protected void setPrice(long price) {
		this.price = price;
	}

	// Set the weapon's length
	protected void setWeaponLength(long length) {
		this.weaponLength = length;
	}

	// Set The Weapon's ready state
	protected void setReady(boolean ready) {
		this.ready = ready;
	}

	/* Set unready stats of weapon */
	protected void setUnreadyStats(String[] unreadyStats) {
		this.unreadyStats = unreadyStats;
	}

	/* Set ready stats of weapon */
	protected void setReadyStats(String[] readyStats) {
		this.readyStats = readyStats;
	}

	/* Set true if weapon is missile, false otherwise */
	protected void setMissile(boolean missile) {
		this.missile = missile;
	}

	/* Used for testing purposes */
	public String toString() {
		String strToReturn = "Weapon Details\n";
		strToReturn += "Weapon File Path: " + getImgFilePath() + "\n";
		strToReturn += "Weapon Length: " + getWeaponLength() + "\n";
		strToReturn += "Weapon Price: " + getPrice() + "\n";
		strToReturn += "Weapon Ready Statistics: ";

		String[] tempReady = getReadyStats();
		for (int i = 0; i < tempReady.length; i++) {
			if (i == 0 || i == 1 || i == 2)
				strToReturn += tempReady[i] + ", ";
			else
				strToReturn += tempReady[i] + "\n";
		}

		strToReturn += "Weapon Un-ready Statistics: ";

		String[] tempUnready = getUnreadyStats();
		for (int i = 0; i < tempReady.length; i++) {
			if (i == 0 || i == 1 || i == 2)
				strToReturn += tempUnready[i] + ", ";
			else
				strToReturn += tempUnready[i] + "\n";
		}

		strToReturn += "Is weapon of type missile? " + isMissile() + "\n";
		return strToReturn;
	}

	public static void main(String[] args) {
		Weapon w = new Weapon("Medium Bow");
		System.out.println(w);

		Weapon w2 = new Weapon("Bane Sword");
		System.out.println(w2);
	}
}
