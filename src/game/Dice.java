package game;

import java.util.Random;

public class Dice {

	public static int rollDice(){
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}	


}
