/**
 * 
 */
package models;

/**
 * @author josh
 *
 */
public class Loot {

	public void lootAction(Player player, LootEnum loot, Treasure treasure){
		//implementation
		if(loot == LootEnum.TAKE_1ST){
			//implementation
		}else if(loot == LootEnum.TAKE_2ND){
			//implementation
		}else if(loot == LootEnum.TAKE_3RD){
			//implementation
		}else if(loot == LootEnum.TAKE_4TH){
			//implementation
		}else if(loot == LootEnum.TAKE_5TH){
			//implementation
		}else if(loot == LootEnum.TAKE_6TH){
			//implementation
		}else{
			System.out.println("Error, did not recieve valid Enum");
		}
	}
}
