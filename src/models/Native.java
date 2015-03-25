package models;

/**
 * @author Hassan Said
 */

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Native extends Entity {

	private Weapon weapon;
	private long wage;
	private long[] bounty = new long[2]; // the first element of bounty is
											// notoriety, second element is gold
	private String moveUnalerted[] = new String[2]; // move for native when
													// un-alerted
	private String moveAlerted[] = new String[2]; // move for native when
													// alerted
	private String weight;
	private String[] vul = new String[2]; // vulnerability first element is
											// vulnerability of native and
											// second is armor of native
	private String[] readyStats = new String[3]; // First element of array
													// letter, second is effort,
													// third is fatigue, fourth
													// is sharpness
	private String[] unReadyStats = new String[3]; // First element of array
													// letter, second is effort,
													// third is fatigue, fourth
													// is sharpness
	private String group; // group that native is part of
	private boolean ready = false; // native ready statistics
	JSONParser parser;

	// List of different native groups
	String[] Bashkars = { "BHQ", "B1", "B2", "B3", "B4", "B5" };
	String[] Company = { "CHQ", "C1", "C2", "C3", "C4", "C5", "C6" };
	String[] Guard = { "GHQ", "G1", "G2" };
	String[] Lancer = { "LHQ", "L1", "L2", "L3" };
	String[] Order = { "OHQ", "O1", "O2", "O3" };
	String[] Patrol = { "PHQ", "P1", "P2" };
	String[] Rogues = { "RHQ", "R1", "R2", "R3", "R4", "R5", "R6", "R7" };
	String[] Soldiers = { "SHQ", "S1", "S2", "S3" };
	String[] Woodfolk = { "WHQ", "W1", "W2" };

	/***** Constructors *****/
	protected Native(String nativeName, String nativeType) {
		// Take native name and parse native JSON. Used returned values to fill
		// in details for native
		parser = new JSONParser();

		try {
			JSONArray array = (JSONArray) parser
					.parse(new FileReader(
							"Z:/eclipse-Juno-Workspace/Magic Realm/src/res/nativeList.json"));

			for (Object o : array) {
				JSONObject currNative = (JSONObject) o;

				String n = (String) currNative.get("Name");

				if (n.equals(nativeName)) {
					setImgFilePath((String) currNative.get("File Path")); // Set
																			// the
																			// image
																			// file
																			// for
																			// weapon
					setEntityName((String) currNative.get("Name")); // Set the
																	// name for
																	// the
																	// entity

					// Fetch the current weapon array for native
					JSONObject weaponArray = (JSONObject) currNative
							.get("Weapon");

					// Create weapon using the type found in weapon array
					Weapon weaponTemp = new Weapon(
							(String) weaponArray.get("Type"));

					// Set temporary weapon to current native's weapon
					setWeapon(weaponTemp);

					// Set the native's wage
					setWage((long) currNative.get("Wage"));

					// Create a temporary array to store native bounty
					long[] tempBounty = new long[2];

					// Get the native's gold and notoriety
					JSONObject bountyArray = (JSONObject) currNative
							.get("Bounty");

					// Get the native's gold
					if (bountyArray.containsKey("Gold"))
						tempBounty[0] = (long) bountyArray.get("Gold");

					// Get the native's notoriety
					if (bountyArray.containsKey("Notoriety"))
						tempBounty[1] = (long) bountyArray.get("Notoriety");

					// Set the temporary array to the bounty array of native
					setBounty(tempBounty);

					// Set the native's weight
					if (((String) currNative.get("Weight"))
							.equals("Tremendous")) {
						setWeight("T");
					} else if (((String) currNative.get("Weight"))
							.equals("Heavy")) {
						setWeight("H");
					} else if (((String) currNative.get("Weight"))
							.equals("Medium")) {
						setWeight("M");
					} else if (((String) currNative.get("Weight"))
							.equals("Light")) {
						setWeight("L");
					}

					// Get the native's vulnerability and armored statistics
					JSONObject vulArray = (JSONObject) currNative.get("VUL");

					// Create temporary array to store vulnerability and armor
					String[] tempVul = new String[2];

					// Get native's vulnerability
					if (vulArray.containsKey("Vulnerability"))
						tempVul[0] = (String) vulArray.get("Vulnerability");

					// Get native's armor
					if (vulArray.containsKey("Armor"))
						tempVul[1] = (String) vulArray.get("Armor");

					// Set native's vulnerability and armor
					setVul(tempVul);

					// Get all native's type
					JSONObject currNativeType = (JSONObject) currNative
							.get("Type");

					// See if the nativeType is part of currNativeType
					if (currNativeType.containsKey(nativeType)) {
						// Set the native's group
						setGroup(nativeType);

						// Create temporary array for native's move when alerted
						String[] tempMove = new String[2];

						// Create temporary array for native's move when
						// un-alerted
						String[] tempMove2 = new String[2];

						// Get the characters move letter
						if (currNative.containsKey("Move")) {
							if (((String) currNative.get("Move"))
									.equals("Tremendous")) {
								tempMove[0] = tempMove2[0] = "T";
							} else if (((String) currNative.get("Move"))
									.equals("Heavy")) {
								tempMove[0] = tempMove2[0] = "H";
							} else if (((String) currNative.get("Move"))
									.equals("Medium")) {
								tempMove[0] = tempMove2[0] = "M";
							} else if (((String) currNative.get("Move"))
									.equals("Light")) {
								tempMove[0] = tempMove2[0] = "L";
							}
						}

						// Get the current native type details
						JSONObject nativeTypeDetails = (JSONObject) currNativeType
								.get(nativeType);

						// Get the numeric movement array for current character
						JSONObject moveStatistics = (JSONObject) nativeTypeDetails
								.get("Move");

						// Set the numeric value of ready native
						tempMove[1] = (String) moveStatistics.get("Alerted");

						// Set the numeric value for un-ready native
						tempMove2[1] = (String) moveStatistics.get("Unalerted");

						// Set temporary arrays to character ready and un-ready
						// move statistics respectively
						setMoveAlerted(tempMove);
						setMoveUnalerted(tempMove2);

						// Set up a temporary array for un-ready native
						String[] unReadyTemp = new String[3];

						// Set up a temporary array for ready native
						String[] readyTemp = new String[3];

						// Get native attack Array
						JSONObject attackStatistics = (JSONObject) nativeTypeDetails
								.get("Attack");

						// Set the JSON object for ready attack
						JSONObject readyAttackStats = (JSONObject) attackStatistics
								.get("Alerted");

						// Set the JSON object for un-ready attack
						JSONObject unReadyAttackStats = (JSONObject) attackStatistics
								.get("Unalerted");

						// Retrieve ready attack letter for ready native
						readyTemp[0] = (String) readyAttackStats.get("letter");

						// Retrieve ready attack effort for ready native
						readyTemp[1] = (String) readyAttackStats.get("effort");

						// Retrieve ready attack fatigue for ready native
						readyTemp[2] = (String) readyAttackStats.get("fatigue");

						// Retrieve un-ready attack letter for ready native
						unReadyTemp[0] = (String) unReadyAttackStats
								.get("letter");

						// Retrieve un-ready attack effort for ready native
						unReadyTemp[1] = (String) unReadyAttackStats
								.get("effort");

						// Retrieve un-ready attack fatigue for ready native
						unReadyTemp[2] = (String) unReadyAttackStats
								.get("fatigue");

						// Set temporary arrays to character ready and un-ready
						// attack statistics respectively
						setReadyStats(readyTemp);
						setUnreadyStats(unReadyTemp);
					}

					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***** Getter Methods *****/
	// Return weapon native has
	protected Weapon getWeapon() {
		return weapon;
	}

	// Return wage to hire native
	protected long getWage() {
		return wage;
	}

	// Return bounty for native
	protected long[] getBounty() {
		return bounty;
	}

	// Return move of native when un-alerted
	protected String[] getMoveUnalerted() {
		return moveUnalerted;
	}

	// Return move of native when alerted
	protected String[] getMoveAlerted() {
		return moveAlerted;
	}

	// Return weight of native
	protected String getWeight() {
		return weight;
	}

	// Return vulnerability and armor of native
	protected String[] getVul() {
		return vul;
	}

	// Return the ready statistics of native
	protected String[] getReadyStats() {
		return readyStats;
	}

	// Return the un-ready statistics of native
	protected String[] getUnreadyStats() {
		return unReadyStats;
	}

	// Return what group native is part of
	protected String getGroup() {
		return group;
	}

	// Return if the native is ready
	protected boolean isReady() {
		return ready;
	}

	/***** Setter Methods *****/
	// Set the current native's inventory
	protected void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	// Set the wage to hire native
	protected void setWage(long wage) {
		this.wage = wage;
	}

	// Set bounty for native
	protected void setBounty(long[] bounty) {
		this.bounty = bounty;
	}

	// Set move of native when un-alerted
	protected void setMoveUnalerted(String[] move) {
		this.moveUnalerted = move;
	}

	// Set move of native when alerted
	protected void setMoveAlerted(String[] move) {
		this.moveAlerted = move;
	}

	// Set the weight for the native
	protected void setWeight(String weight) {
		this.weight = weight;
	}

	// Set the vulnerability of the native
	protected void setVul(String[] vul) {
		this.vul = vul;
	}

	// Set the ready statistics for the native
	protected void setReadyStats(String[] readyStats) {
		this.readyStats = readyStats;
	}

	// Set the un-ready statistics for the native
	protected void setUnreadyStats(String[] unReadyStats) {
		this.unReadyStats = unReadyStats;
	}

	// Set the group native is in
	protected void setGroup(String group) {
		this.group = group;
	}

	// Set the ready status of native
	protected void setReady(boolean ready) {
		this.ready = ready;
	}

	// Used for testing purposes
	public String toString() {
		String strToReturn = "Native Details\n";
		strToReturn += "Native File Path: " + getImgFilePath() + "\n";
		strToReturn += "Native Wage: " + getWage() + "\n";
		strToReturn += "Native Has Following Bounty\n";
		strToReturn += "\nBounty:\n";

		// get and loop through bounty array
		long[] bountyArray = getBounty();

		for (int i = 0; i < bountyArray.length; i++) {
			if (i == 0)
				strToReturn += "Gold: " + bountyArray[i] + "\n";
			else if (i == 1)
				strToReturn += "Notoriety: " + bountyArray[i] + "\n";
		}

		strToReturn += "\nNative has following move statistics when ready: \n";

		// get and loop through ready move array
		String[] moveArray = getMoveAlerted();

		for (int i = 0; i < moveArray.length; i++) {
			if (i == 0)
				strToReturn += "Letter: " + moveArray[i] + "\n";
			else if (i == 1)
				strToReturn += "Effort: " + moveArray[i] + "\n";
		}

		strToReturn += "\nNative has following move statistics when not ready: \n";

		// get and loop through not ready move array
		String[] unreadyMoveArray = getMoveUnalerted();

		for (int i = 0; i < unreadyMoveArray.length; i++) {
			if (i == 0)
				strToReturn += "Letter: " + unreadyMoveArray[i] + "\n";
			else if (i == 1)
				strToReturn += "Effort: " + unreadyMoveArray[i] + "\n";
		}

		strToReturn += "\nNative has the following weight: " + getWeight()
				+ "\n";
		strToReturn += "\nNative has following vulnerability and armor: \n";

		// get and loop through vulnerability array
		String[] vulArray = getVul();

		for (int i = 0; i < vulArray.length; i++) {
			if (i == 0)
				strToReturn += "Vulnerability: " + vulArray[i] + "\n";
			else if (i == 1)
				strToReturn += "Armor: " + vulArray[i] + "\n";
		}

		strToReturn += "\nNative has following statistics when ready: \n";

		// get and loop through ready statistics array
		String[] readyArray = getReadyStats();

		for (int i = 0; i < readyArray.length; i++) {
			if (i == 0)
				strToReturn += "Letter: " + readyArray[i] + "\n";
			else if (i == 1)
				strToReturn += "Effort: " + readyArray[i] + "\n";
			else if (i == 2)
				strToReturn += "Fatigue: " + readyArray[i] + "\n";
		}

		strToReturn += "\nNative has following statistics when ready: \n";

		// get and loop through un-ready statistics array
		String[] unReadyArray = getUnreadyStats();

		for (int i = 0; i < unReadyArray.length; i++) {
			if (i == 0)
				strToReturn += "Letter: " + unReadyArray[i] + "\n";
			else if (i == 1)
				strToReturn += "Effort: " + unReadyArray[i] + "\n";
			else if (i == 2)
				strToReturn += "Fatigue: " + unReadyArray[i] + "\n";
		}

		strToReturn += "\nNative has the following weapon: \n";
		strToReturn += getWeapon().toString();

		return strToReturn;
	}

	public static void main(String[] args) {
		Native n = new Native("Knight", "OHQ");
		System.out.println(n);
	}
}
