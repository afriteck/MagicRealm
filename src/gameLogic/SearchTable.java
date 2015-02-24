/**
 * 
 */
package gameLogic;

/**
 * @author joshwhite
 *
 */
public class SearchTable {
	
	static LocateEnum locate;
	PeerEnum peer;
	MagicSightEnum magicsight;
	LootEnum loot;
	
	public  LocateEnum getLocateAction(int roll) {
		switch (roll) {
			case 1:  locate = LocateEnum.CHOICE;
	        case 2:  locate = LocateEnum.PASSAGES_AND_CLUES;
	        case 3:  locate = LocateEnum.PASSAGES;
	        case 4:  locate = LocateEnum.DISCOVER_CHITS;
	        case 5:  locate = LocateEnum.NOTHING;
	        case 6:  locate = LocateEnum.NOTHING;
	        default: System.out.println("Error, did not recieve valid roll.");
		}
		return locate;
	}
	
	public PeerEnum getPeerAction(int roll) {
		switch (roll) {
			case 1:  peer = PeerEnum.CHOICE;
	        case 2:  peer = PeerEnum.CLUES_AND_PATHS;
	        case 3:  peer = PeerEnum.HIDDEN_ENEMIES_AND_PATHS;
	        case 4:  peer = PeerEnum.HIDDEN_ENEMIES;
	        case 5:  peer = PeerEnum.CLUES;
	        case 6:  peer = PeerEnum.NOTHING;
	        default: System.out.println("Error, did not recieve valid roll.");
		}
		return peer;
	}
	
	public MagicSightEnum getMagicSightAction(int roll) {
		switch (roll) {
			case 1:  magicsight = MagicSightEnum.CHOICE;
	        case 2:  magicsight = MagicSightEnum.COUNTERS;
	        case 3:  magicsight = MagicSightEnum.TREASURE_CARDS;
	        case 4:  magicsight = MagicSightEnum.PERCEIVE_SPELL;
	        case 5:  magicsight = MagicSightEnum.DISCOVER_CHITS;
	        case 6:  magicsight = MagicSightEnum.NOTHING;
	        default: System.out.println("Error, did not recieve valid roll.");
		}
		return magicsight;
	}
	
	public LootEnum getLootAction(int roll) {
		switch(roll) {
			case 1:  loot = LootEnum.TAKE_1ST;
			case 2:  loot = LootEnum.TAKE_2ND;
			case 3:  loot = LootEnum.TAKE_3RD;
			case 4:  loot = LootEnum.TAKE_4TH;
			case 5:  loot = LootEnum.TAKE_5TH;
			case 6:  loot = LootEnum.TAKE_6TH;
			default: System.out.println("Error, did not recieve valid roll.");
		}
		return loot;
	}
}
