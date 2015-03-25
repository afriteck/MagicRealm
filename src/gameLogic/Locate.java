/**
 * 
 */
package gameLogic;

import models.Player;

/**
 * @author joshwhite
 * 
 */
public class Locate {

	public static void choice(Player player) {
		System.out.println("got it");
	}

	public static void passages_and_clues(Player player) {
		// implementation
		System.out.println("got it");
	}

	public static void passages(Player player) {
		// implementation
		System.out.println("got it");
	}

	public static void discover_chits(Player player) {
		// implementation
		System.out.println("got it");
	}

	public static void locateAction(Player player, int myroll) {
		// implementation
		if (myroll == 1) {
			// implementation
			choice(player);
		} else if (myroll == 2) {
			// implementation
			passages_and_clues(player);
		} else if (myroll == 3) {
			// implementation
			passages(player);
		} else if (myroll == 4) {
			// implementation
			discover_chits(player);
		} else if (myroll == 5) {
			// implementation
		} else if (myroll == 6) {
			// implementation
		} else {
			System.out.println("Error, did not recieve valid Enum");
		}
	}
}
