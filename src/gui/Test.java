package gui;

import java.util.ArrayList;

import models.Amazon;
import models.Counters;
import models.DamageEnum;
import models.Dwarf;
import models.Player;

public class Test {
		
	public static void combatResolution(Player p1, Object obj) {
		System.out.println("Here");
		Counters c1, c2, c3, c4;
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;

		// Last used counters for player 1
		if (p1.getCharacter().getFatiguedCounter().size() > 0) {
			c1 = p1.getCharacter().getFatiguedCounter()
					.get(p1.getCharacter().getFatiguedCounter().size() - 1);
			c2 = p1.getCharacter().getFatiguedCounter()
					.get(p1.getCharacter().getFatiguedCounter().size() - 2);
		}
		// Last used counters for player 2
		if (obj instanceof Player) {
			if (((Player) obj).getCharacter().getFatiguedCounter().size() > 0) {
				c3 = ((Player) obj)
						.getCharacter()
						.getFatiguedCounter()
						.get(((Player) obj).getCharacter().getFatiguedCounter()
								.size() - 1);
				c4 = ((Player) obj)
						.getCharacter()
						.getFatiguedCounter()
						.get(((Player) obj).getCharacter().getFatiguedCounter()
								.size() - 2);
			}
		}

		if (c1.getType() == "FIGHT" && c3.getType() == "MOVE") {
			if (c1.getStrength().equals(DamageEnum.TREMENDOUS)
					&& ((c3.getStrength().equals(DamageEnum.HEAVY) && c3.getStar() < 1)
							|| (c3.getStrength().equals(DamageEnum.MEDIUM) && c3.getStar() < 2) || (c3
							.getStrength().equals(DamageEnum.LIGHT) && c3.getStar() < 3))) {
				// say initiating player won out
				System.out.println("Player 1 won");
			} else if (c1.getStrength().equals(DamageEnum.HEAVY)
					&& ((c3.getStrength().equals(DamageEnum.MEDIUM) && c3.getStar() < 2) || (c3
							.getStrength().equals(DamageEnum.LIGHT) && c3.getStar() < 3))) {
				System.out.println("Player 1 won -- 2");
			} else if (c1.getStrength().equals(DamageEnum.MEDIUM)
					&& (c3.getStrength().equals(DamageEnum.LIGHT) && c3.getStar() < 3)) {
				System.out.println("Player 1 won -- 3");
			} else {
				// Strength are the same
				if(c1.getSpeed() < c3.getSpeed()) {
					System.out.println("Player 1 won -- Speed Higher");
				} else {
					if(p1.getCharacter().getWeapons().getLength() > ((Player) obj).getCharacter().getWeapons().getLength()) {
						System.out.println("Player 1 won -- Weapon Length Longer");
					} else {
						// initiated player wins
						System.out.println("Player 2 won");
					}
				}
			}
		}

		if (c2.getType() == "MOVE" && c4.getType() == "FIGHT") {

		}
	}

	
	public static void main(String[] arg) {
		Player p1 = new Player();
		Player p2 = new Player();
		Amazon c1 = new Amazon();
		Dwarf c2 = new Dwarf();
		
		p1.setCharacter(c1);
		p2.setCharacter(c2);
		
		ArrayList<Counters> f1 = new ArrayList<Counters>();
		ArrayList<Counters> f2 = new ArrayList<Counters>();
		
		f1.add(new Counters("FIGHT", DamageEnum.TREMENDOUS, 5, 1));
		f1.add(new Counters("FIGHT", DamageEnum.TREMENDOUS, 5, 1));
		f2.add(new Counters("MOVE", DamageEnum.TREMENDOUS, 5, 1));
		f2.add(new Counters("MOVE", DamageEnum.MEDIUM, 5, 2));
		
		p1.getCharacter().setFatiguedCounter(f1);
		p2.getCharacter().setFatiguedCounter(f2);
		
		Test t = new Test();
		t.combatResolution(p1, p2);
	}
}
