/**
 * 
 */
package models;

import java.util.Random;

/**
 * @author josh
 *
 */
public class Dice {
	int dieRoll1;
	int dieRoll2;
	
    public int getDieRoll(boolean oneDie){
    	Random rand = new Random();
	    dieRoll1 = rand.nextInt(6) + 1;
	    dieRoll2 = rand.nextInt(6) + 1;
	    if(oneDie==true){dieRoll2=0;}
        return Math.max(dieRoll1, dieRoll2);
    }
    
    public int highestRoll(int lastRoll, int lastRoll2){
    	return Math.max(lastRoll, lastRoll2);
    }
}
