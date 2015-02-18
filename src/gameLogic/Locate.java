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

	public void choice(Player player){
		// choice implementation
	}
	
	public void passages_and_clues(Player player){
		//implementation
	}
	
	public void passages(Player player){
		//implementation
	}
	
	public void discover_chits(Player player){
		//implementation
	}
	
	public void locateAction(Player player, LocateEnum locate){
		//implementation
		if(locate == LocateEnum.CHOICE){
			//implementation
			choice(player);
		}else if(locate == LocateEnum.PASSAGES_AND_CLUES){
			//implementation
			passages_and_clues(player);
		}else if(locate == LocateEnum.PASSAGES){
			//implementation
			passages(player);
		}else if(locate == LocateEnum.DISCOVER_CHITS){
			//implementation
			discover_chits(player);
		}else if(locate == LocateEnum.NOTHING){
			//implementation
		}else if(locate == LocateEnum.NOTHING){
			//implementation
		}else{
			System.out.println("Error, did not recieve valid Enum");
		}
	}
}
