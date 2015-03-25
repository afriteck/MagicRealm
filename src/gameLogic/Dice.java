package gameLogic;

/**
 * @author joshwhite
 * 
 */
public class Dice {
	int dieRoll1;
	int dieRoll2;

	public int getDieRoll(boolean oneDie, int lastRoll1, int lastRoll2) {
		dieRoll1 = lastRoll1;
		dieRoll2 = lastRoll2;
		if (oneDie == true) {
			dieRoll2 = 0;
		}
		return Math.max(dieRoll1, dieRoll2);
	}

	public int highestRoll(int lastRoll, int lastRoll2) {
		return Math.max(lastRoll, lastRoll2);
	}

	public static int roll() { // Dice Function - returns #

		return (int) (6.0 * Math.random()) + 1;
	}

}
