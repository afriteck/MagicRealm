package gameLogic;

import gameBoard.BoardTiles;
import gameBoard.Tiles;
import gui.CombatScreen;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Amazon;
import models.BlackKnight;
import models.BreastPlates;
import models.BroadSword;
import models.Captain;
import models.Chapel;
import models.CrossBow;
import models.Dwarf;
import models.Dwelling;
import models.Elf;
import models.GreatAxe;
import models.GreatSword;
import models.GuardHouse;
import models.Helmet;
import models.House;
import models.Inn;
import models.LightBow;
import models.Mace;
import models.Player;
import models.PlayerChit;
import models.Shields;
import models.ShortSword;
import models.SoundChit;
import models.SoundChit.Flutter;
import models.SoundChit.Howl;
import models.SoundChit.Patter;
import models.SoundChit.Roar;
import models.SoundChit.Slither;
import models.Spear;
import models.SuitsOfArmor;
import models.Swordsman;
import models.ThrustingSword;
import models.WarningChit;
import models.WarningChit.Bones;
import models.WarningChit.Dank;
import models.WarningChit.Ruins;
import models.WarningChit.Smoke;
import models.WarningChit.Stink;
import monsters.Monster;
import natives.Bashkars;
import natives.Company;
import natives.Lancers;
import natives.NativeGroup;
import natives.Patrol;
import natives.Woodfolk;
import networking.MyServer;

public class GuiActivities {

	private Player player1 = new Player();
	private Player player2 = new Player();
	private Player currentPlayer = null;
	private int turn;

	private PlayerChit p1chit = new PlayerChit();
	private PlayerChit p2chit = new PlayerChit();

	private boolean hideAct;
	private boolean rolled;

	private boolean moveAct;
	private boolean cheatMode = true;

	private boolean selected;

	private boolean move;
	private boolean place;

	private boolean hide;
	private boolean trade;
	private boolean rest;
	private boolean search;
	private boolean follow;
	private boolean alert;
	private boolean hire;
	private boolean enchant;
	private boolean combat;
	private boolean sendToServer = false;

	private Chapel chapell = new Chapel();
	private GuardHouse guardhousee = new GuardHouse();
	private House housee = new House();
	private Inn innn = new Inn();

	MyServer server = new MyServer();

	private CombatScreen cs;

	private int activityCounter = 0; // for the player character selection phase

	private LinkedList<Tiles> moveTiles = new LinkedList<Tiles>();
	private LinkedList<Tiles> searchTiles = new LinkedList<Tiles>();

	private JButton locate, loot, peer;

	private BoardTiles bd = server.getBd();

	private ArrayList<NativeGroup> ng;
	private Bashkars bashkars;
	private Company company;
	private Lancers lancers;
	private Patrol patrol;
	private Woodfolk woodfolk;
	
	private Howl howl;
	private Roar roar;
	private Slither slither;
	private Flutter flutter;
	private Patter patter;

	private Chapel chapel;
	private GuardHouse guardhouse;
	private House house;
	private Inn inn;

	Bones bones;
	Dank dank;
	Ruins ruins;
	Smoke smoke;
	Stink stink;

	public GuiActivities(BoardTiles bd) {

		this.bd = bd;
		// bd = new BoardTiles();
		// bd = BoardTest.initializeTiles();
		player1.setTile("BAD VALLEY");
		player1.setClearing(5);

		player2.setTile("BAD VALLEY");
		player2.setClearing(5);

		ng = new ArrayList<NativeGroup>();

		bashkars = new Bashkars();
		company = new Company();
		lancers = new Lancers();
		patrol = new Patrol();
		woodfolk = new Woodfolk();

		chapel = new Chapel();
		guardhouse = new GuardHouse();
		house = new House();
		inn = new Inn();

		bones = new Bones();
		dank = new Dank();
		ruins = new Ruins();
		smoke = new Smoke();
		stink = new Stink();
		
		howl = new Howl();
		roar = new Roar();
		slither = new Slither();
		flutter = new Flutter();
		patter = new Patter();

		

		ng.add(bashkars);
		ng.add(company);
		ng.add(lancers);
		ng.add(patrol);
		ng.add(woodfolk);
		ng.add(chapel.getNatives());
		ng.add(guardhouse.getNatives());
		ng.add(house.getNatives());
		ng.add(inn.getNatives());

	}

	public void activity(LinkedList<String> p1, ActionEvent e, int n) {

		HashMap<Player, LinkedList<String>> hm = new HashMap<Player, LinkedList<String>>();
		LinkedList<String> p1choiceOrder = new LinkedList<String>();

		String activity = e.getActionCommand();

		if (!moveAct) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"ARE YOU SURE YOU WANT TO DO THIS ACTIVITY FOR THE DAY?",
					"Alert", dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {

				p1.add(activity);

			} else {
				System.out.println("select your action");

			}
		}

	}

	public void display(JTextArea txt) {

		txt.append("\n---------------------------------- WHERE WOULD YOU LIKE TO MOVE!!\n");

	}

	public void displayOptionPane(Component cp) {
		JOptionPane.showMessageDialog(cp,
				"PLEASE CHOOSE YOUR ACTIVITIES FOR THE DAY.");

	}

	public int getActivityCounter() {
		return activityCounter;
	}

	public void setActivityCounter(int activityCounter) {
		this.activityCounter = activityCounter;
		// activityCounter--;
	}

	public void addWarningChits() {

		ArrayList<WarningChit> chits = new ArrayList<WarningChit>();

		WarningChit smoke = new Smoke();
		WarningChit bones = new Bones();
		WarningChit dank = new Dank();
		WarningChit ruins = new Ruins();
		WarningChit stink = new Stink();

		for (int i = 0; i < bd.size(); i++) {
			chits.add(smoke);
			chits.add(bones);
			chits.add(dank);
			chits.add(ruins);
			chits.add(stink);
		}

		for (int i = 0; i < bd.size(); i++) {

			bd.getTile(i).getWarnings().add(chits.get(i));
			// if(bd.getTile(i).getWarnings() !=null)
			// System.out.println(bd.getTile(i).getWarnings().getName());
		}

		System.out.println(bd);
	}

	JTextField TileName = new JTextField();
	JTextField Clearing = new JTextField();

	Object[] message = { "Tile Name:", TileName, "Clearing:", Clearing };

	public boolean requestMove(Player p) {
		int option = JOptionPane.showConfirmDialog(null, message, "MOVE!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String input = TileName.getText().toString().trim();
			if (getBD().getTile(p.getCharacter().getTileName()).isNeighbour(
					getBD().getTile(input)) == true
					|| p.getCharacter().getTileName().equals(input) == true) {
				if (getBD().getTile(getPlayer1().getTile())
						.getClearingByNum(p.getClearing()).getPeopleHere()
						.size() == 1)
					getBD().getTile(getPlayer1().getTile())
							.getClearingByNum(p.getClearing())
							.setPlayerHere(false);
				getBD().getTile(p.getTile()).getClearingByNum(p.getClearing())
						.removePersonHere(p.getPchit());

				// if(getBD().getTile(getPlayer1().getTile()).getClearingByNum(p.getClearing()).getPeopleHere().size()
				// > 1)
				// getBD().getTile(getPlayer1().getTile()).getClearingByNum(p.getClearing()).setPlayerHere(true);

				// CHECK IF SOMEONE IS CURRENTLY ON THE TILE

				checkCombat(getBD(), p);
				// getPlayer1().setPchit(p1chit);
				/*
				p.moveTo(TileName.getText(),
						Integer.parseInt(Clearing.getText()));
				p.getCharacter().moveTo(TileName.getText(),
						Integer.parseInt(Clearing.getText()));
				getBD().getTile(TileName.getText().toUpperCase())
						.getClearingByNum(Integer.parseInt(Clearing.getText()))
						.movePersonHere(p.getPchit());
						*/

				// getBD().getTile(p.getTile()).getClearingByNum(p.getClearing()).removePersonHere(p.getPchit());
				// server.getBd().getTile(p.getTile()).getClearingByNum(p.getClearing()).removePerson(p.getPchit());

				// getPlayer1().setPchit(p1chit);

			} else {
				JOptionPane.showMessageDialog(null,
						"Invalid Move \n DON'T CHEAT!");
				getBD().getTile(getPlayer1().getTile())
						.getClearingByNum(p.getClearing()).setPlayerHere(false);
				setMove(false);
			}
			setMove(false);
			turn++;
			return true;
			/*
			 * 
			 * if (TileName.getText().equals("h") &&
			 * Clearing.getText().equals("h")) {
			 * System.out.println("Login successful"); //success = false; } else
			 * { System.out.println("login failed"); //success = false;
			 * 
			 * } } else { System.out.println("Login canceled"); //success =
			 * false;
			 */

		} else
			setMove(false);
		return false;

	}

	JTextField useMoveChit = new JTextField();
	JTextField moveChitLocation = new JTextField();

	Object[] message1 = {
			"Move Chit (Enter it as it appears on character list):",
			useMoveChit };

	public boolean placeMove(Player p) {
		int option = JOptionPane.showConfirmDialog(null, message1,
				"PLACE MOVE CHIT!", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String chit = useMoveChit.getText().toString().trim();
			updateChits(chit, "MOVE");
			return true;
		} else {
			return false;
		}
	}

	JTextField useFightChit = new JTextField();
	JTextField fightChitLocation = new JTextField();

	Object[] message2 = {
			"Fight Chit (Enter it as it appears on character list):",
			useFightChit };

	public boolean placeFight(Player p) {
		int option = JOptionPane.showConfirmDialog(null, message2,
				"PLACE FIGHT CHIT!", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String chit = useFightChit.getText().toString().trim();
			updateChits(chit, "FIGHT");
			return true;
		} else {
			return false;
		}
	}

	public void updateChits(String chit, String chitType) {
		for (int i = 0; i < (this.getPlayer1().getCharacter().getReadyCounter())
				.size(); i += 1) {
			if (((this.getPlayer1().getCharacter().getReadyCounter()).get(i))
					.getDetails().equals(chitType + ": " + chit)) {
				this.getPlayer1()
						.getCharacter()
						.getFatiguedCounter()
						.add(this.getPlayer1().getCharacter().getReadyCounter()
								.get(i));
				this.getPlayer1().getCharacter().getReadyCounter().remove(i);
				break;
			}
		}
	}

	public boolean requestCombat(Player p) {
		// cs = new CombatScreen(this);
		if (cs != null) {
			/*
			 * cs.move.addActionListener(new ActionListener() { public void
			 * actionPerformed(ActionEvent e) { placeMove(getPlayer1()); } });
			 * cs.move.setBounds(50, 200, 89, 23); cs.btnPanel.add(cs.move);
			 * cs.move.setVisible(true);
			 * 
			 * cs.fight.addActionListener(new ActionListener() { public void
			 * actionPerformed(ActionEvent e) { placeFight(getPlayer1()); } });
			 * cs.fight.setBounds(50, 250, 89, 23); cs.btnPanel.add(cs.fight);
			 * cs.fight.setVisible(true);
			 * 
			 * cs.submitStats.addActionListener(new ActionListener() { public
			 * void actionPerformed(ActionEvent e) { setSendToServer(true); }
			 * }); cs.submitStats.setBounds(50, 250, 89, 23);
			 * cs.btnPanel.add(cs.submitStats); cs.submitStats.setVisible(true);
			 */
			System.out.println("Here");
			return true;
		} else {
			//this.initCombatScreen();
			System.out.println("Here 2");
			return false;
		}
	}

	public boolean placedwelling(Dwelling d) {
		int option = JOptionPane.showConfirmDialog(null, message, "Place!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String input = TileName.getText().toString().trim();
			// bd.getTile(input);
			// moveTiles.add(bd.getTile(input));
			// System.out.println(bd.getTile(input).getName());

			bd.getTile(TileName.getText().toUpperCase())
					.getClearingByNum(Integer.parseInt(Clearing.getText()))
					.setDwelling(d);
			d.setTile(TileName.getText());
			d.setClearing(Integer.parseInt(Clearing.getText()));

			return true;

		} else
			return false;

	}

	public boolean placeNative(NativeGroup d) {
		int option = JOptionPane.showConfirmDialog(null, message, "Place!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String input = TileName.getText().toString().trim();
			bd.getTile(input);
			moveTiles.add(bd.getTile(input));
			System.out.println(bd.getTile(input).getName());

			bd.getTile(TileName.getText().toUpperCase())
					.getClearingByNum(Integer.parseInt(Clearing.getText()))
					.setNatives(d);
			//d.setClearing(Integer.parseInt(Clearing.getText()));

			return true;

		} else
			return false;

	}
	
	public boolean placeSoundChit(SoundChit d) {
		int option = JOptionPane.showConfirmDialog(null, message, "Place!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String input = TileName.getText().toString().trim();
			bd.getTile(input);
			moveTiles.add(bd.getTile(input));
			System.out.println(bd.getTile(input).getName());

			bd.getTile(TileName.getText().toUpperCase())
					.getClearingByNum(Integer.parseInt(Clearing.getText()))
					.getSound().add(d);
			
			d.setClearing(Integer.parseInt(Clearing.getText()));

			return true;

		} else
			return false;
	}
	
	public boolean placeMonsterChit(Monster d) {
		int option = JOptionPane.showConfirmDialog(null, message, "Place!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String input = TileName.getText().toString().trim();
			bd.getTile(input);
			moveTiles.add(bd.getTile(input));
			System.out.println(bd.getTile(input).getName());

			bd.getTile(TileName.getText().toUpperCase())
					.getClearingByNum(Integer.parseInt(Clearing.getText()))
					.addMonster(d);
			return true;
		} else
			return false;
	}

	public boolean placePlayer1(Player p) {
		int option = JOptionPane.showConfirmDialog(null, message,
				"Place Player!", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			String input = TileName.getText().toString().trim();

			getPlayer1().moveTo(input, Integer.parseInt(Clearing.getText()));
			getPlayer1().getCharacter().moveTo(TileName.getText(),
					Integer.parseInt(Clearing.getText()));

			p1chit.setName(getPlayer1().getName());
			getPlayer1().setPchit(p1chit);

			getBD().getTile(TileName.getText())
					.getClearingByNum(Integer.parseInt(Clearing.getText()))
					.movePersonHere(getPlayer1().getPchit());
			getBD().getTile(getPlayer1().getTile())
					.getClearingByNum(p.getClearing()).setPlayerHere(true);

			setPlace(true);
			getPlayer1().setFirstTile(input);
			getPlayer1().getCharacter().setFirstTile(input);
			getPlayer1().setFirstClearing(Integer.parseInt(Clearing.getText()));
			getPlayer1().getCharacter().setFirstClearing(
					Integer.parseInt(Clearing.getText()));

			return true;
		} else
			return false;
	}

/*
	public boolean placeWarningChit(WarningChit wc) {
		/*
		 * bd.getTile((String)JOptionPane.showInputDialog(null, "Tile:",
		 * "Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
		 * "Type Tile name here")).setWarnings(wc);
		 * 
		 * return true;
		 */
	/*
		String inputname;

		inputname = (String) JOptionPane.showInputDialog(null, "Tile:",
				"Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
				"Type your name here");

		if (inputname == null || inputname.trim().length() == 0)
			JOptionPane.showMessageDialog(null, "Enter A  tile name");

		else if (inputname != null) {
			if (bd.getTile(inputname) != null) {
				bd.getTile(inputname).getWarnings().add(wc);
				return true;
			} else {
				JOptionPane.showMessageDialog(null,
						"Enter A  Valid Tile name in Block Letters!");
				return false;
			}
		}
		return false;
	}
*/
	// String input = inputname.trim();
	// int option = JOptionPane.showConfirmDialog(null, message, "Place!",
	// JOptionPane.OK_CANCEL_OPTION);

	// if(bd.isLegalTile())

	// bd.getTile((String)JOptionPane.showInputDialog(null, "Tile:",
	// "Place a dwelling", JOptionPane.QUESTION_MESSAGE, null,
	// null, "Type Tile name here")).setWarnings(wc);

	// return false;

	public boolean requestSearch(final Player p, final JTabbedPane tabbedpane,
			final Container cp) {
		int option = JOptionPane.showConfirmDialog(null, null, "SEARCH!",
				JOptionPane.OK_CANCEL_OPTION);
		// JButton[] items = new JButton[3];
		final JButton locate;
		final JButton peer;
		final JButton loot;
		final JButton backButton;

		if (!rolled)
			JOptionPane.showMessageDialog(null, "Roll a die first");

		if (option == JOptionPane.OK_OPTION) {

			locate = new JButton("LOCATE");
			locate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rolled)
						JOptionPane.showMessageDialog(null, "Roll a die first");
					if (rolled && p.getCharacter().getRoll() == 4) {
						for (int i = 0; i < bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().size(); i++)
							bd.getTile(p.getTile())
									.getClearingByNum((p.getClearing()))
									.getTreasureChits().get(i)
									.setVisisble(true);

						JOptionPane.showMessageDialog(null,
								"Treasure chits are now visible!");

						System.out.println(" Treasure chits are now visible");
					} else  if (rolled && p.getCharacter().getRoll() == 1) {
						JOptionPane.showMessageDialog(null,
								"Which would you want to do!");

					} else if (rolled && p.getCharacter().getRoll() == 2) {
						for (int i = 0; i < bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getSound().size(); i++)
							bd.getTile(p.getTile())
									.getClearingByNum((p.getClearing()))
									.getSound().get(i)
									.setHidden(false);
						JOptionPane.showMessageDialog(null,
								"you have located hidden clues and paths!");

					} else if (rolled && p.getCharacter().getRoll() == 3) {
						
						JOptionPane.showMessageDialog(null,
								"you have located hidden Passages");

					}

					else if (rolled && p.getCharacter().getRoll() > 4) {
						JOptionPane.showMessageDialog(null,
								"You discovered nothing");

					}
					rolled = false;
					// isSearch = false;
				}
			});
			locate.setBounds(1430, 329, 109, 30);
			locate.setIcon(new ImageIcon(GuiActivities.class
					.getResource("/others/reveal.gif")));
			locate.setVisible(true);
			cp.add(locate);

			peer = new JButton("PEER");
			peer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!rolled)
						JOptionPane.showMessageDialog(null, "Roll a die first");
					if (rolled && p.getCharacter().getRoll() == 4) {
						for (int i = 0; i < bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getMonsterChits().size(); i++)
							bd.getTile(p.getTile())
									.getClearingByNum((p.getClearing()))
									.getMonsterChits().get(i)
									.setVisible(true);

						JOptionPane.showMessageDialog(null,
								"Enemies are now visible!");

						System.out.println(" Enemies are now visible!");
					} else  if (rolled && p.getCharacter().getRoll() == 1) {
						JOptionPane.showMessageDialog(null,
								"Which would you want to do!");

					} else if (rolled && p.getCharacter().getRoll() == 2) {
						for (int i = 0; i < bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getSound().size(); i++)
							bd.getTile(p.getTile())
									.getClearingByNum((p.getClearing()))
									.getSound().get(i)
									.setHidden(false);
						JOptionPane.showMessageDialog(null,
								"you have located hidden clues and paths!");

					} else if (rolled && p.getCharacter().getRoll() == 3) {
						for (int i = 0; i < bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getMonsterChits().size(); i++)
							bd.getTile(p.getTile())
									.getClearingByNum((p.getClearing()))
									.getMonsterChits().get(i)
									.setVisible(true);
						JOptionPane.showMessageDialog(null,
								"you have located hidden enemies and paths!");

					}
					else if (rolled && p.getCharacter().getRoll() == 5) {
						for (int i = 0; i < bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getSound().size(); i++)
							bd.getTile(p.getTile())
									.getClearingByNum((p.getClearing()))
									.getSound().get(i)
									.setHidden(false);
						JOptionPane.showMessageDialog(null,
								"You discovered clues!");

					}
					else if (rolled && p.getCharacter().getRoll() > 5) {
						JOptionPane.showMessageDialog(null,
								"You discovered nothing");

					}
					rolled = false;
					// isSearch = false;
				}
			});
			peer.setBounds(1430, 295, 109, 30);
			peer.setIcon(new ImageIcon(GuiActivities.class
					.getResource("/others/peer.png")));
			peer.setVisible(true);
			cp.add(peer);

			loot = new JButton("LOOT");
			loot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Please Roll a die");
					if (!rolled)
						JOptionPane.showMessageDialog(null, "Roll a die first");
					if (rolled && p.getCharacter().getRoll() == 4) {
						if(bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().get(3) != null){
							p.getCharacter().setGold(p.getCharacter().getGold() + 
									bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(3).getGold());
							bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().remove(3);
							JOptionPane.showMessageDialog(null,
									"You got Treasure!");
						}else{
						JOptionPane.showMessageDialog(null,
								"Sorry! No Treasure there!");
						}

						System.out.println(" Treasure chits are now visible");
					} else  if (rolled && p.getCharacter().getRoll() == 1) {
						if(bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().get(0) != null){
							p.getCharacter().setGold(p.getCharacter().getGold() + 
									bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(0).getGold());
							bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().remove(0);
							JOptionPane.showMessageDialog(null,
									"You got Treasure!");
						}else{
						JOptionPane.showMessageDialog(null,
								"Sorry! No Treasure there!");
						}

					} else if (rolled && p.getCharacter().getRoll() == 2) {
						if(bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().get(1) != null){
							p.getCharacter().setGold(p.getCharacter().getGold() + 
									bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(1).getGold());
							bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().remove(1);
							JOptionPane.showMessageDialog(null,
									"You got Treasure!");
						}else{
						JOptionPane.showMessageDialog(null,
								"Sorry! No Treasure there!");
						}

					} else if (rolled && p.getCharacter().getRoll() == 3) {
						
						if(bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().get(2) != null){
							p.getCharacter().setGold(p.getCharacter().getGold() + 
									bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(2).getGold());
							bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().remove(2);
							JOptionPane.showMessageDialog(null,
									"You got Treasure!");
						}else{
						JOptionPane.showMessageDialog(null,
								"Sorry! No Treasure there!");
						}
					}
					else if (rolled && p.getCharacter().getRoll() == 5) {
						if(bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().get(4) != null){
							p.getCharacter().setGold(p.getCharacter().getGold() + 
									bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(4).getGold());
							bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().remove(4);
							JOptionPane.showMessageDialog(null,
									"You got Treasure!");
						}else{
						JOptionPane.showMessageDialog(null,
								"Sorry! No Treasure there!");
						}

					}
					else if (rolled && p.getCharacter().getRoll() == 6) {
						if(bd.getTile(p.getTile())
								.getClearingByNum((p.getClearing()))
								.getTreasureChits().get(5) != null){
							p.getCharacter().setGold(p.getCharacter().getGold() + 
									bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(5).getGold());
							bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().remove(5);
							JOptionPane.showMessageDialog(null,
									"You got Treasure!");
						}else{
						JOptionPane.showMessageDialog(null,
								"Sorry! No Treasure there!");
						}

					}
					rolled = false;
					// isSearch = false;
				}
			});
			loot.setBounds(1430, 261, 109, 30);
			loot.setIcon(new ImageIcon(GuiActivities.class
					.getResource("/others/loot.png")));
			loot.setVisible(true);
			cp.add(loot);

			backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					locate.setVisible(false);
					peer.setVisible(false);
					loot.setVisible(false);

					backButton.setVisible(false);
					tabbedpane.remove(cp);
					setSearch(false);
					setRolled(false);
					turn++;

				}
			});
			backButton.setBounds(800, 907, 100, 23);
			backButton.setIcon(new ImageIcon(GuiActivities.class
					.getResource("/actions/backarrow.gif")));
			backButton.setVisible(true);
			cp.add(backButton);

			return true;

			// if (TileName.getText().equals("h") &&
			// Clearing.getText().equals("h")) {
			// System.out.println("Login successful");
			// } else {
			// System.out.println("login failed");
			// }
			// } else {
			// System.out.println("Login canceled");
		}
		return false;
	}

	public boolean requestHide(Player p, boolean rolled, JTextArea txt) {
		int option = JOptionPane.showConfirmDialog(null, null, "HIDE!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			if (getRolled() == false) {
				JOptionPane.showMessageDialog(null, "Please roll die first");
				setHide(false);
				return false;
			}

			else if (getRolled() && p.getCharacter().getRoll() < 6) {

				p.getCharacter().setVisibility(false);
				getPlayer1().getPchit().setHidden(true);
				bd.getTile(p.getCharacter().getTileName()).getClearingByNum(p.getCharacter()
						.getClearingLocation()).getPersonHere().setHidden(true);
				txt.append(p.getName() + " is now hidden from every one \n");

				setHide(false);
				turn++;
				return true;

			}

			else if (p.getCharacter().getRoll() == 6) {
				JOptionPane.showMessageDialog(null, "Sorry you cant hide");
				getPlayer1().getPchit().setHidden(false);
				bd.getTile(p.getCharacter().getTileName()).getClearingByNum(p.getCharacter()
						.getClearingLocation()).getPersonHere().setHidden(false);
				setHide(false);
				turn++;
				return true;
			}

			else {
				JOptionPane.showMessageDialog(null, "Play a Turn!");
				// txt.append(p.getCharacter().getName())
			}

		}
		setHide(false);
		return false;

	}

	public boolean requestRest(Player p, JTextArea txt) {

		int option = JOptionPane.showConfirmDialog(null, null, "REST!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			if(p.getCharacter().getFatiguedCounter().size() > 0 && p.getCharacter().getFatiguedCounter().get(0).getStar() == 1){
			p.getCharacter().rest(p.getCharacter().getFatiguedCounter().get(0));
			txt.append("You are now resting " + p.getCharacter().getFatiguedCounter().get(0).getDetails());			
			setRest(false);
			turn++;
			return true;
			}else if(p.getCharacter().getFatiguedCounter().size() > 0 && p.getCharacter().getFatiguedCounter().get(0).getStar() == 2){
				int option2 = JOptionPane.showConfirmDialog(null, null, "Needs 2 rest activities!",
						JOptionPane.OK_CANCEL_OPTION);
					if((option2 == JOptionPane.OK_OPTION)){
						turn += 2;
						p.getCharacter().rest(p.getCharacter().getFatiguedCounter().get(0));
						setRest(false);
						return true;
					}else{ JOptionPane.showMessageDialog(null, p.getCharacter().getFatiguedCounter().get(0).getDetails() + " is not rested");
					setRest(false);
					return false;
					}
			}else if(p.getCharacter().getFatiguedCounter().size() > 0 && p.getCharacter().getFatiguedCounter().get(0).getStar() == 3 ){
				int option3 = JOptionPane.showConfirmDialog(null, null, "Needs 3 rest activities!",
						JOptionPane.OK_CANCEL_OPTION);
					if((option3 == JOptionPane.OK_OPTION)){
						turn += 3;
						p.getCharacter().rest(p.getCharacter().getFatiguedCounter().get(0));
						setRest(false);
						return true;
					}else{ JOptionPane.showMessageDialog(null, p.getCharacter().getFatiguedCounter().get(0).getDetails() + " is not rested");
					setRest(false);
					return false;

			}
				
			}else{ JOptionPane.showMessageDialog(null, "You have no fatigued counters to rest");
			setRest(false);
			return false;

			}
		} else {
			txt.append(p.getName() + " is not resting \n");
			setRest(false);
			return false;
		}

	}

	public boolean requestAlert(Player p, JTextArea txt) {

		int option = JOptionPane.showConfirmDialog(null, null, "Alert!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			p.getCharacter().setAlert(true);
			txt.append(p.getName() + " is now Alerted \n");

			if (p.getCharacter().getHiredNatives() != null) {
				for (int i = 0; i < p.getCharacter().getHiredNatives().get(0)
						.getNatives().size(); i++)
					p.getCharacter().getHiredNative().getNatives().get(i)
							.isAlert(true);
				txt.append(p.getCharacter().getHiredNative() + " is now Alerted \n");
				setAlert(false);
				turn++;
				return true;

			}

		} else {
			System.out.println(p.getCharacter().isAlert());
			setAlert(false);

			return false;
		}
		setAlert(false);
		return false;
	}

	public boolean requestHire(Player p, JTextArea txt) {

		int option = JOptionPane.showConfirmDialog(null, null, "Hire!",
				JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			JOptionPane.showMessageDialog(null,
					"please select the native group you wish to hire \n");
			txt.append(" You can only hire native groups in the same clearing with you \n");

			turn++;
			return true;

		} else {
			JOptionPane.showMessageDialog(null, "Please play a turn");

			return false;
		}

	}

	public boolean hireNative(ActionEvent e, Player p, NativeGroup ng, JTextArea txt) { // player hires a native group
		String name = ((Component) e.getSource()).getName();

		int option = JOptionPane.showConfirmDialog(null, null,
				"Recruit this Native Group?", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {

			if (name == ng.getName() && ng.isHired() == false) { // check if the
																	// native
																	// group is
																	// already
																	// hired
				p.getCharacter().buyNative(p.getCharacter(), ng); // if not
																	// hired
																	// hire the
																	// group
				txt.append("You have successfully recruited "
						+ p.getCharacter().getHiredNatives().get(0).getName());
				ng.setHired(true);
				return true;
			}

		} else {
			JOptionPane.showMessageDialog(null,
					"This group has already been hired by another player");
		}
		if (p.getCharacter().getHiredNatives().size() > 0)
			txt.append("You currently have this native group \n"
					+ p.getCharacter().getHiredNatives().get(0).getName());
		return false;
	}

	public void promptPlayerName() {

		String firstPlayer = (String) JOptionPane.showInputDialog(null,
				"Name:", "Enter Player name", JOptionPane.QUESTION_MESSAGE,
				null, null, "");
		if (firstPlayer == null || firstPlayer.trim().length() == 0) {
			System.out.println("You must enter a name");
			System.exit(1);
		}
		final String player1Name = firstPlayer.trim();

		/*
		 * String secondPlayer = (String)JOptionPane.showInputDialog(null,
		 * "Name:", "Enter Player 2 name", JOptionPane.QUESTION_MESSAGE, null,
		 * null, ""); if (secondPlayer == null || secondPlayer.trim().length()
		 * == 0){
		 * 
		 * System.out.println("You must enter a name"); System.exit(1); } final
		 * String player2Name = secondPlayer.trim();
		 * 
		 * txt.append(
		 * "\n----------------------------------\n Welcome to Magic Realm " +
		 * player1Name + " and " + player2Name + "!" +
		 * " \n Press 'New Game' to Play. \n--");
		 */
		getPlayer1().setName(player1Name);
		// player2.setName(player2Name);

	}

	public boolean requestTrade(Player p) {

		return false;

	}

	public void intializeTrade(final Container cp,
			final JTabbedPane tabbedPane, final Player p) {

		final ButtonGroup buttonGroup = new ButtonGroup();

		final JButton backButton;

		final JButton[] items = new JButton[13];

		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < items.length; i++)
					items[i].setVisible(false);
				backButton.setVisible(false);
				tabbedPane.remove(cp);
				setTrade(false);
				turn++;

			}
		});
		backButton.setBounds(800, 907, 100, 23);
		backButton.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/actions/backarrow.gif")));
		backButton.setVisible(true);
		cp.add(backButton);

		int option = JOptionPane.showConfirmDialog(null, null, "TRADE!",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {

			items[0] = new JButton("BreastPlates");

			items[0].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this armor BreastPlates?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						BreastPlates bp = new BreastPlates();
						p.getCharacter().buyArmor(p.getCharacter(), bp);
						items[0].setVisible(false);

					}

				}
			});

			items[0].setBounds(50, 150, 65, 70);
			items[0].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/armor/breastplate.png")));
			items[0].setVisible(true);
			buttonGroup.add(items[0]);
			cp.add(items[0]);

			items[1] = new JButton("BroadSword");
			items[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon BroadSword?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						BroadSword bs = new BroadSword();
						p.getCharacter().buyWeapon(p.getCharacter(), bs);
						items[1].setVisible(false);

					}
				}
			});
			items[1].setBounds(145, 300, 85, 50);
			items[1].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/broadsword.png")));
			items[1].setVisible(true);
			buttonGroup.add(items[1]);
			cp.add(items[1]);

			items[2] = new JButton("CrossBow");
			items[2].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon CrossBow?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						CrossBow cb = new CrossBow();
						p.getCharacter().buyWeapon(p.getCharacter(), cb);
						items[2].setVisible(false);

					}
				}
			});

			items[2].setBounds(350, 500, 150, 60);
			items[2].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/crossboww.png")));
			items[2].setVisible(true);
			buttonGroup.add(items[2]);
			cp.add(items[2]);

			items[3] = new JButton("GreatAxe");
			items[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon GreatAxe?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						GreatAxe ga = new GreatAxe();
						p.getCharacter().buyWeapon(p.getCharacter(), ga);
						items[3].setVisible(false);

					}
				}
			});
			items[3].setBounds(50, 300, 75, 70);
			items[3].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/greataxe.png")));
			items[3].setVisible(true);
			buttonGroup.add(items[3]);
			cp.add(items[3]);

			items[4] = new JButton("GreatSword");

			items[4].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon GreatSword?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						GreatSword gs = new GreatSword();
						p.getCharacter().buyWeapon(p.getCharacter(), gs);
						items[4].setVisible(false);

					}
				}
			});
			items[4].setBounds(250, 300, 140, 100);
			items[4].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/greatsword.png")));
			items[4].setVisible(true);
			buttonGroup.add(items[4]);
			cp.add(items[4]);

			items[5] = new JButton("Helmet");

			items[5].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Armor Helmet?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						Helmet gs = new Helmet();
						p.getCharacter().buyArmor(p.getCharacter(), gs);
						items[5].setVisible(false);

					}
				}
			});
			items[5].setBounds(140, 150, 65, 70);
			items[5].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/armor/helmet.png")));
			items[5].setVisible(true);
			buttonGroup.add(items[5]);
			cp.add(items[5]);

			items[6] = new JButton("LightBow");
			items[6].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon LightBow?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						LightBow lb = new LightBow();
						p.getCharacter().buyWeapon(p.getCharacter(), lb);
						items[6].setVisible(false);

					}
				}
			});
			items[6].setBounds(430, 300, 100, 50);
			items[6].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/lightbow.png")));
			items[6].setVisible(true);
			buttonGroup.add(items[6]);
			cp.add(items[6]);

			items[7] = new JButton("Mace");
			items[7].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon Mace?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						Mace m = new Mace();
						p.getCharacter().buyWeapon(p.getCharacter(), m);
						items[7].setVisible(false);

					}
				}
			});
			items[7].setBounds(570, 300, 150, 50);
			items[7].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/mace.png")));
			items[7].setVisible(true);
			buttonGroup.add(items[7]);
			cp.add(items[7]);

			items[8] = new JButton("Shields");
			items[8].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Armor Shields?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						Shields s = new Shields();
						p.getCharacter().buyArmor(p.getCharacter(), s);
						items[8].setVisible(false);

					}
				}
			});
			items[8].setBounds(230, 150, 70, 110);
			items[8].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/armor/shields.png")));
			items[8].setVisible(true);
			buttonGroup.add(items[8]);
			cp.add(items[8]);

			items[9] = new JButton("ShortSword");
			items[9].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon ShortSword?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						ShortSword ss = new ShortSword();
						p.getCharacter().buyWeapon(p.getCharacter(), ss);
						items[9].setVisible(false);

					}
				}
			});
			items[9].setBounds(730, 300, 130, 35);
			items[9].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/shortsword.png")));
			items[9].setVisible(true);
			buttonGroup.add(items[9]);
			cp.add(items[9]);

			items[10] = new JButton("Spear");
			items[10].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Weapon Spear?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						Spear ss = new Spear();
						p.getCharacter().buyWeapon(p.getCharacter(), ss);
						items[10].setVisible(false);

					}
				}
			});
			items[10].setBounds(50, 500, 130, 90);
			items[10].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/spear.png")));
			items[10].setVisible(true);
			buttonGroup.add(items[10]);
			cp.add(items[10]);

			items[11] = new JButton("ThrustingSword");
			items[11].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane
							.showConfirmDialog(
									null,
									null,
									"Would you like to buy this Weapon ThrustingSword?",
									JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						ThrustingSword ts = new ThrustingSword();
						p.getCharacter().buyWeapon(p.getCharacter(), ts);
						items[11].setVisible(false);

					}
				}
			});
			items[11].setBounds(200, 500, 110, 50);
			items[11].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/weapons/thrustingsword.png")));
			items[11].setVisible(true);
			buttonGroup.add(items[11]);
			cp.add(items[11]);

			items[12] = new JButton("SuitsOfAmor");
			items[12].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int option = JOptionPane.showConfirmDialog(null, null,
							"Would you like to buy this Armor SuitsOfAmor?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {

						SuitsOfArmor sa = new SuitsOfArmor();
						p.getCharacter().buyArmor(p.getCharacter(), sa);
						items[12].setVisible(false);

					}
				}
			});
			items[12].setBounds(330, 150, 135, 125);
			items[12].setIcon(new ImageIcon(GuiActivities.class
					.getResource("/armor/suitsofarmor.png")));
			items[12].setVisible(true);
			buttonGroup.add(items[12]);
			cp.add(items[12]);

		}
		// return items;

	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void getNextPlayer(Player p) {

		if (p == player1) {
			setCurrentPlayer(player2);
		}
		if (p == player2) {
			setCurrentPlayer(player1);
		}

	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void showNativeGroup(final NativeGroup ng, final Player p, final JTextArea txt, JPanel cp) {

		System.out.println(ng.getTile() + p.getTile());
		//System.out.println(ng.getClearing() + " " + p.getClearing());

		final JButton groupLabel = new JButton();

		if (ng.getTile().equals(p.getTile())
				/*&& ng.getClearing() == p.getClearing()*/) {

			groupLabel.setVisible(true);

		}

		groupLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ng.isHired() == true) {
					JOptionPane.showMessageDialog(null,
							"This group has already been hired!");
					groupLabel.setVisible(false);
					setHire(false);

				} else {
					hireNative(e, p, ng, txt);
					groupLabel.setVisible(false);
					setHire(false);
				}
			}
		});
		groupLabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/others/nativegroup.jpg")));
		groupLabel.setName(ng.getName());
		groupLabel.setBounds(400, 700, 120, 120);
		groupLabel.setVisible(false);
		cp.add(groupLabel);

	}

	public void cheatmodeButtons(Container container) {

		JButton[] cheatbuttons = new JButton[5];

		final JLabel boneslabel;
		final JLabel danklabel;
		final JLabel ruinslabel;
		final JLabel smokelabel;
		final JLabel stinklabel;

		final JLabel baskarlabel;
		final JLabel lancerslabel;
		final JLabel patrollabel;
		final JLabel woodfolklabel;
		final JLabel companylabel;
		
		final JLabel howllabel;
		final JLabel roarlabel;
		final JLabel slitherlabel;
		final JLabel flutterlabel;
		final JLabel patterlabel;

		//final ArrayList<Dwelling> dwellings = new ArrayList<Dwelling>();
		//final ArrayList<WarningChit> warningchits = new ArrayList<WarningChit>();
		//final ArrayList<SoundChit> sounds = new ArrayList<SoundChit>();

		// bashkars = new Bashkars();
		// lancers = new Lancers();
		// patrol = new Patrol();
		// woodfolk = new Woodfolk();
		// company = new Company();

		final JComboBox comboBox = new JComboBox();

		comboBox.setEnabled(false);
		comboBox.setBounds(706, 237, 245, 27);

		//dwellings.add(chapel);
		//dwellings.add(guardhouse);
		//dwellings.add(house);
		//dwellings.add(inn);
/*
		warningchits.add(bones);
		warningchits.add(dank);
		warningchits.add(ruins);
		warningchits.add(smoke);
		warningchits.add(stink);
		*/
		//sounds.add(howl);

		final JLabel chapelLabel = new JLabel();
		chapelLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placedwelling(chapel);
			}
		});
		chapelLabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/dwellings/chapel.gif")));
		chapelLabel.setBounds(220, 150, 70, 50);
		chapelLabel.setName("Chapel");
		chapelLabel.setVisible(false);
		container.add(chapelLabel);

		final JLabel guardLabel = new JLabel();
		guardLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placedwelling(guardhouse);

			}
		});
		guardLabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/dwellings/guard.gif")));
		guardLabel.setBounds(300, 150, 70, 50);
		guardLabel.setName("GuardHouse");
		guardLabel.setVisible(false);
		container.add(guardLabel);

		final JLabel houseLabel = new JLabel();
		houseLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placedwelling(house);

			}
		});
		houseLabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/dwellings/house.gif")));
		houseLabel.setBounds(390, 150, 70, 50);
		houseLabel.setName("House");
		houseLabel.setVisible(false);
		container.add(houseLabel);

		final JLabel innLabel = new JLabel();
		innLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placedwelling(inn);

			}
		});
		innLabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/dwellings/inn.gif")));
		innLabel.setBounds(480, 150, 70, 50);
		innLabel.setName("Inn");
		innLabel.setVisible(false);
		container.add(innLabel);

		boneslabel = new JLabel();
		boneslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String inputname;

				inputname = (String) JOptionPane.showInputDialog(null, "Tile:",
						"Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
						"Type your name here");

				if (inputname == null || inputname.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Enter A  tile name");

				else if (inputname != null) {
					if (bd.getTile(inputname) != null) {
						bd.getTile(inputname).getWarnings().add(bones);
					} else {
						JOptionPane.showMessageDialog(null,
								"Enter A  Valid Tile name in Block Letters!");
					}
				};
			}
		});
		boneslabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/others/bones.png")));
		boneslabel.setBounds(150, 250, 70, 50);
		boneslabel.setName("Bones");
		boneslabel.setVisible(false);
		container.add(boneslabel);

		danklabel = new JLabel();
		danklabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String inputname;

				inputname = (String) JOptionPane.showInputDialog(null, "Tile:",
						"Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
						"Type your name here");

				if (inputname == null || inputname.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Enter A  tile name");

				else if (inputname != null) {
					if (bd.getTile(inputname) != null) {
						bd.getTile(inputname).getWarnings().add(dank);
					} else {
						JOptionPane.showMessageDialog(null,
								"Enter A  Valid Tile name in Block Letters!");
					}
				};

			}
		});
		danklabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/others/dank.png")));
		danklabel.setBounds(250, 250, 70, 50);
		danklabel.setName("DANK");
		danklabel.setVisible(false);
		container.add(danklabel);

		ruinslabel = new JLabel();
		ruinslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String inputname;

				inputname = (String) JOptionPane.showInputDialog(null, "Tile:",
						"Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
						"Type your name here");

				if (inputname == null || inputname.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Enter A  tile name");

				else if (inputname != null) {
					if (bd.getTile(inputname) != null) {
						bd.getTile(inputname).getWarnings().add(ruins);
					} else {
						JOptionPane.showMessageDialog(null,
								"Enter A  Valid Tile name in Block Letters!");
					}
				};

			}
		});
		ruinslabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/others/ruins.png")));
		ruinslabel.setBounds(350, 250, 70, 50);
		ruinslabel.setName("Ruins");
		ruinslabel.setVisible(false);
		container.add(ruinslabel);

		smokelabel = new JLabel();
		smokelabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String inputname;

				inputname = (String) JOptionPane.showInputDialog(null, "Tile:",
						"Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
						"Type your name here");

				if (inputname == null || inputname.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Enter A  tile name");

				else if (inputname != null) {
					if (bd.getTile(inputname) != null) {
						bd.getTile(inputname).getWarnings().add(smoke);
					} else {
						JOptionPane.showMessageDialog(null,
								"Enter A  Valid Tile name in Block Letters!");
					}
				};

			}
		});
		smokelabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/others/smoke.png")));
		smokelabel.setBounds(450, 250, 70, 50);
		smokelabel.setName("Smoke");
		smokelabel.setVisible(false);
		container.add(smokelabel);

		stinklabel = new JLabel();
		stinklabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String inputname;

				inputname = (String) JOptionPane.showInputDialog(null, "Tile:",
						"Place a dwelling", JOptionPane.QUESTION_MESSAGE, null, null,
						"Type your name here");

				if (inputname == null || inputname.trim().length() == 0)
					JOptionPane.showMessageDialog(null, "Enter A  tile name");

				else if (inputname != null) {
					if (bd.getTile(inputname) != null) {
						bd.getTile(inputname).getWarnings().add(stink);
					} else {
						JOptionPane.showMessageDialog(null,
								"Enter A  Valid Tile name in Block Letters!");
					}
				};

			}
		});
		stinklabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/others/stink.png")));
		stinklabel.setBounds(550, 250, 70, 50);
		stinklabel.setName("Stink");
		stinklabel.setVisible(false);
		container.add(stinklabel);

		companylabel = new JLabel();
		companylabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeNative(company);

			}
		});
		companylabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/natives/company.png")));
		companylabel.setBounds(550, 350, 70, 50);
		companylabel.setName("Company");
		companylabel.setVisible(false);
		container.add(companylabel);

		woodfolklabel = new JLabel();
		woodfolklabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeNative(woodfolk);

			}
		});
		woodfolklabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/natives/woodfolk.png")));
		woodfolklabel.setBounds(450, 350, 70, 50);
		woodfolklabel.setName("Woodfolk");
		woodfolklabel.setVisible(false);
		container.add(woodfolklabel);

		patrollabel = new JLabel();
		patrollabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeNative(patrol);

			}
		});
		patrollabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/natives/patrol.png")));
		patrollabel.setBounds(350, 350, 70, 50);
		patrollabel.setName("PATROL");
		patrollabel.setVisible(false);
		container.add(patrollabel);

		baskarlabel = new JLabel();
		baskarlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeNative(bashkars);

			}
		});
		baskarlabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/natives/bashkars.png")));
		baskarlabel.setBounds(150, 350, 70, 50);
		baskarlabel.setName("Bashkars");
		baskarlabel.setVisible(false);
		container.add(baskarlabel);

		lancerslabel = new JLabel();
		lancerslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeNative(lancers);

			}
		});
		lancerslabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource("/natives/lancers.png")));
		lancerslabel.setBounds(250, 350, 70, 50);
		lancerslabel.setName("LANCERS");
		lancerslabel.setVisible(false);
		container.add(lancerslabel);
		
		howllabel = new JLabel();
		howllabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeSoundChit(howl);

			}
		});
		howllabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource(howl.getFpath())));
		howllabel.setBounds(550, 350, 75, 75);
		howllabel.setName("HOWL");
		howllabel.setVisible(false);
		container.add(howllabel);
		
		roarlabel = new JLabel();
		roarlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeSoundChit(roar);

			}
		});
		roarlabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource(roar.getFpath())));
		roarlabel.setBounds(450, 350, 75, 75);
		roarlabel.setName("ROAR");
		roarlabel.setVisible(false);
		container.add(roarlabel);
		
		slitherlabel = new JLabel();
		slitherlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeSoundChit(slither);

			}
		});
		slitherlabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource(slither.getFpath())));
		slitherlabel.setBounds(350, 350, 75, 75);
		slitherlabel.setName("SLITHER");
		slitherlabel.setVisible(false);
		container.add(slitherlabel);
		
		flutterlabel = new JLabel();
		flutterlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeSoundChit(flutter);

			}
		});
		flutterlabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource(flutter.getFpath())));
		flutterlabel.setBounds(250, 350, 75, 75);
		flutterlabel.setName("FLUTTER");
		flutterlabel.setVisible(false);
		container.add(flutterlabel);
		
		patterlabel = new JLabel();
		patterlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				placeSoundChit(patter);

			}
		});
		patterlabel.setIcon(new ImageIcon(GuiActivities.class
				.getResource(patter.getFpath())));
		patterlabel.setBounds(150, 350, 75, 75);
		patterlabel.setName("PATTER");
		patterlabel.setVisible(false);
		container.add(patterlabel);

		cheatbuttons[0] = new JButton("Dwellings");
		cheatbuttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane
						.showMessageDialog(null,
								"Please select the dwelling that you would like to place on the board");

				innLabel.setVisible(true);
				houseLabel.setVisible(true);
				guardLabel.setVisible(true);
				chapelLabel.setVisible(true);

			}
		});
		cheatbuttons[0].setBounds(50, 150, 100, 40);
		cheatbuttons[0].setVisible(true);
		container.add(cheatbuttons[0]);

		// cheatbuttons[1] = new JButton("Player");
		// cheatbuttons[1].addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// if(!isSelected())
		// JOptionPane.showMessageDialog(null,
		// "Please select a character first before placing players on the board");
		// else activityCounter++;
		// placePlayer1(getPlayer1());

		// if(isSelected() && activityCounter == 1)
		// placePlayer1(getPlayer1());

		// if(isSelected() && activityCounter == 2){
		// placePlayer2(getPlayer2());
		// activityCounter = 0;
		// }

		// }
		// });
		// cheatbuttons[1].setBounds(50, 200, 100, 40);
		// cheatbuttons[1].setVisible(true);
		// container.add(cheatbuttons[1]);

		cheatbuttons[1] = new JButton("Warning Chits");
		cheatbuttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane
						.showMessageDialog(null,
								"Please select the Chit that you would like to place on the board");

				boneslabel.setVisible(true);
				danklabel.setVisible(true);
				ruinslabel.setVisible(true);
				smokelabel.setVisible(true);
				stinklabel.setVisible(true);

			}
		});
		cheatbuttons[1].setBounds(50, 200, 100, 40);
		cheatbuttons[1].setVisible(true);
		container.add(cheatbuttons[1]);

		cheatbuttons[2] = new JButton("Treasure Chits");
		cheatbuttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		cheatbuttons[2].setBounds(50, 250, 100, 40);
		cheatbuttons[2].setVisible(true);
		container.add(cheatbuttons[2]);

		cheatbuttons[3] = new JButton("NATIVES");
		cheatbuttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(null,
								"Please select the Natives that you would like to place on the board");

				baskarlabel.setVisible(true);
				lancerslabel.setVisible(true);
				patrollabel.setVisible(true);
				woodfolklabel.setVisible(true);
				companylabel.setVisible(true);

			}
		});
		cheatbuttons[3].setBounds(50, 300, 100, 40);
		cheatbuttons[3].setVisible(true);
		container.add(cheatbuttons[3]);
		
		cheatbuttons[4] = new JButton("Sounds");
		cheatbuttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(null,
								"Please select the Sounds that you would like to place on the board");

				howllabel.setVisible(true);
				roarlabel.setVisible(true);
				flutterlabel.setVisible(true);
				slitherlabel.setVisible(true);
				patterlabel.setVisible(true);
				

			}
		});
		cheatbuttons[4].setBounds(50, 350, 100, 40);
		cheatbuttons[4].setVisible(true);
		container.add(cheatbuttons[4]);

	}

	public boolean getRolled() {
		return rolled;
	}

	public void setRolled(boolean rolled) {
		this.rolled = rolled;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public PlayerChit getP1chit() {
		return p1chit;
	}

	public PlayerChit getP2chit() {
		return p2chit;
	}

	public void setP1chit(PlayerChit pc) {
		this.p1chit = pc;
	}

	public void setP2chit(PlayerChit pc) {
		this.p2chit = pc;
	}

	public boolean isCheatMode() {
		return cheatMode;
	}

	public void setCheatMode(boolean cheatMode) {
		this.cheatMode = cheatMode;
	}

	public void checkSelected(Player p, MouseEvent e) {

		if (!selected) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null,
					"ARE YOU SURE YOU WANT TO SELECT THIS CHARACTER?", "Alert",
					dialogButton);

			if (dialogResult == JOptionPane.YES_OPTION) {
				// cheatMode = true;
				selected = true;
				recruitCharacter(p, e);

			}

			else {

				JOptionPane.showMessageDialog(null,
						"PLEASE SELECT A CHARACTER.");

			}

		}

		if (selected) {

			JOptionPane.showMessageDialog(null, " you have chosen "
					+ p.getCharacter().getName());
			// txt.append("\n----------------------------------\nPlease click on the 4 activities you would want to do today \n");

			// if(!cheatMode && gm.isSelected()){

			// gm.getPlayer1().setTile("BAD VALLEY");
			// gm.getPlayer1().getCharacter().setTileName("BAD VALLEY");
			// gm.getPlayer1().getCharacter().setClearingLocation(5);

			// gm.getPlayer2().setTile("BAD VALLEY");

			// gm.getPlayer2().getCharacter().setTileName("BAD VALLEY");
			// gm.getPlayer2().getCharacter().setClearingLocation(5);
			// boardt.getTile("BAD VALLEY").getClearingByNum(5).movePersonHere(gm.getPlayer1().getPchit());
			// boardt.getTile("BAD VALLEY").getClearingByNum(5).movePersonHere(gm.getPlayer2().getPchit());

		}

	}

	public void recruitCharacter(Player p, MouseEvent e) {

		checkCharacter(p, e);
		// gm.setSelected(true);

	}

	public void checkCharacter(Player p, MouseEvent e) { // check the character
															// clicked and make
															// a new instance of
															// that character

		String name = ((Component) e.getSource()).getName();

		selected = false; // we know the players are not done selection
		if (name == "Amazon") {
			Amazon amazon = new Amazon();
			getPlayer1().setCharacter(amazon);
			// txt.append(gm.getPlayer1().getName() + " Chose " +
			// gm.getPlayer1().getCharacter().getName() + "\n" +
			// gm.getPlayer1().getCharacter().getName() +
			// " currently visibile? " +
			// gm.getPlayer1().getCharacter().getVisibility() + "\n");
			getP1chit().setUrl(amazon.getUrl());
			getP1chit().setCharacter(amazon.getName());

		}

		else if (name == "Captain") {

			Captain captain = new Captain();
			getPlayer1().setCharacter(captain);
			// txt.append(gm.getPlayer1().getName() + " Chose " +
			// gm.getPlayer1().getCharacter().getName() + "\n" +
			// gm.getPlayer1().getCharacter().getName() +
			// " currently visibile? " +
			// gm.getPlayer1().getCharacter().getVisibility() + "\n");
			getP1chit().setUrl(captain.getUrl());
			getP1chit().setCharacter(captain.getName());

		}

		else if (name == "Dwarf") {
			Dwarf dwarf = new Dwarf();
			getPlayer1().setCharacter(dwarf);
			// txt.append(gm.getPlayer1().getName() + " Chose " +
			// gm.getPlayer1().getCharacter().getName() + "\n" +
			// gm.getPlayer1().getCharacter().getName() +
			// " currently visibile? " +
			// gm.getPlayer1().getCharacter().getVisibility() + "\n");
			getP1chit().setUrl(dwarf.getUrl());
			getP1chit().setCharacter(dwarf.getName());

		}

		else if (name == "Elf") {
			Elf elf = new Elf();
			getPlayer1().setCharacter(elf);
			// txt.append(gm.getPlayer1().getName() + " Chose " +
			// gm.getPlayer1().getCharacter().getName() + "\n" +
			// gm.getPlayer1().getCharacter().getName() +
			// " currently visibile? " +
			// gm.getPlayer1().getCharacter().getVisibility() + "\n");
			getP1chit().setUrl(elf.getUrl());
			getP1chit().setCharacter(elf.getName());

		}

		else if (name == "BlackKnight") {
			BlackKnight blackknight = new BlackKnight();
			getPlayer1().setCharacter(blackknight);
			getP1chit().setUrl(blackknight.getUrl());
			getP1chit().setCharacter(blackknight.getName());

			// txt.append(gm.getPlayer1().getName() + " Chose " +
			// gm.getPlayer1().getCharacter().getName() + "\n" +
			// gm.getPlayer1().getCharacter().getName() +
			// " currently visibile? " +
			// gm.getPlayer1().getCharacter().getVisibility() + "\n");

		} else if (name == "Swordsman") {
			Swordsman swordsman = new Swordsman();
			getPlayer1().setCharacter(swordsman);

			// txt.append(gm.getPlayer1().getName() + " Chose " +
			// gm.getPlayer1().getCharacter().getName() + "\n" +
			// gm.getPlayer1().getCharacter().getName() +
			// " currently visibile? " +
			// gm.getPlayer1().getCharacter().getVisibility() + "\n");

			getP1chit().setUrl(swordsman.getUrl());
			getP1chit().setCharacter(swordsman.getName());

			// showMessage(p1character, player1);
		}
		// getPlayer1().setTile("BAD VALLEY");
		// getPlayer1().setClearing(5);
		// getPlayer1().getCharacter().setTileName("BAD VALLEY");
		// getPlayer1().getCharacter().setClearingLocation(5);

		p1chit.setName(getPlayer1().getName());
		getPlayer1().setPchit(getP1chit());

		setSelected(true);

		if (isSelected() && !isCheatMode()) {

			getPlayer1().setTile("BAD VALLEY");
			getPlayer1().getCharacter().setTileName("BAD VALLEY");
			getPlayer1().getCharacter().setClearingLocation(5);
			bd.getTile("BAD VALLEY").getClearingByNum(5)
					.movePersonHere(getPlayer1().getPchit());

		}

	}

	public BoardTiles getBD() {
		return bd;
	}
	
	public void initCombatScreen() {
		cs = new CombatScreen(this);
		
		cs.move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeMove(getPlayer1());
			}
		});
		cs.move.setBounds(50, 200, 89, 23);
		cs.btnPanel.add(cs.move);
		cs.move.setVisible(true);

		cs.fight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeFight(getPlayer1());
			}
		});
		cs.fight.setBounds(50, 250, 89, 23);
		cs.btnPanel.add(cs.fight);
		cs.fight.setVisible(true);
		
		cs.submitStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Here 2");
				cs.updateFrame();
				setSendToServer(true);
				System.out.println("Here 3");
			}
		});
		cs.submitStats.setBounds(50, 250, 89, 23);
		cs.btnPanel.add(cs.submitStats);
		cs.submitStats.setVisible(true);
	}
	
	public CombatScreen getCombatScreen() {
		return cs;
	}

	public boolean moved() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}

	public boolean isTrade() {
		return trade;
	}

	public void setTrade(boolean trade) {
		this.trade = trade;
	}

	public boolean isRest() {
		return rest;
	}

	public void setRest(boolean rest) {
		this.rest = rest;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public boolean isFollow() {
		return follow;
	}

	public void setFollow(boolean follow) {
		this.follow = follow;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	public boolean isHire() {
		return hire;
	}

	public void setHire(boolean hire) {
		this.hire = hire;
	}

	public boolean isEnchant() {
		return enchant;
	}

	public void checkCombat(BoardTiles bt, Player p) {

		if (bt.getTile(TileName.getText())
				.getClearingByNum(Integer.parseInt(Clearing.getText()))
				.isPlayerHere()
				&& bt.getTile(TileName.getText())
						.getClearingByNum(Integer.parseInt(Clearing.getText()))
						.getPersonHere().isHidden() == false) {

			int alert = JOptionPane
					.showConfirmDialog(
							null,
							null,
							"Something is on this clearing \n Do you still want to move?",
							JOptionPane.YES_NO_OPTION);
			if (alert == JOptionPane.YES_OPTION) {
				p.moveTo(TileName.getText(),
						Integer.parseInt(Clearing.getText()));
				p.getCharacter().moveTo(TileName.getText(),
						Integer.parseInt(Clearing.getText()));
				bt.getTile(TileName.getText().toUpperCase())
						.getClearingByNum(Integer.parseInt(Clearing.getText()))
						.movePersonHere(p.getPchit());
				// IF SOMEONE IS THERE ASK IF THEY WOULD WANT TO ALERT THEIR
				// WEAPON
				int weapons = JOptionPane.showConfirmDialog(null, null,
						"Do you want to alert your weapons? \n",
						JOptionPane.YES_NO_OPTION);
				if (weapons == JOptionPane.YES_OPTION) {
					int warning = JOptionPane
							.showConfirmDialog(
									null,
									null,
									"This action would count as an activity for the day! \n Do you wish to continue?",
									JOptionPane.YES_NO_OPTION);
					if (warning == JOptionPane.YES_OPTION) {
						p.getCharacter().setAlert(true);
						// increase turn here
					} else {
						JOptionPane.showMessageDialog(null,
								"Turn not increased!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Weapons not alerted!");
				}
				// IF SOMEONE IS THERE ASK IF THEY WOULD WANT TO HIDE

				int hide = JOptionPane.showConfirmDialog(null, null,
						"Do you want to Hide as well? \n",
						JOptionPane.YES_NO_OPTION);
				if (hide == JOptionPane.YES_OPTION) {
					int warning = JOptionPane
							.showConfirmDialog(
									null,
									null,
									"This action would count as an activity for the day! \n Do you wish to continue?",
									JOptionPane.YES_NO_OPTION);
					if (warning == JOptionPane.YES_OPTION) {
						p.getCharacter().setVisibility(false);
						getPlayer1().getPchit().setHidden(true);

						// increase turn here
						// initialize combat panel here
					} else {
						JOptionPane.showMessageDialog(null,
								"Turn not increased!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "You are not hidden");
				}
			} else {
				setMove(false);
				// getBD().getTile(getPlayer1().getTile()).getClearingByNum(p.getClearing()).setPlayerHere(true);
			}

		}else{
			p.moveTo(TileName.getText(),
					Integer.parseInt(Clearing.getText()));
			p.getCharacter().moveTo(TileName.getText(),
					Integer.parseInt(Clearing.getText()));
			bt.getTile(TileName.getText().toUpperCase())
					.getClearingByNum(Integer.parseInt(Clearing.getText()))
					.movePersonHere(p.getPchit());
		}

	}

	public void setEnchant(boolean enchant) {
		this.enchant = enchant;
	}

	public boolean isCombat() {
		
		return combat;
	}

	public void setCombat(boolean combat) {
		this.combat = combat;
	}
	
	public boolean getSendToServer() {
		return sendToServer;
	}
	
	public void setSendToServer(boolean sendToServer) {
		this.sendToServer = sendToServer;
	}

	public Chapel getChapell() {
		return chapell;
	}

	public void setChapell(Chapel chapell) {
		this.chapell = chapell;
	}

	public GuardHouse getGuardhousee() {
		return guardhousee;
	}

	public void setGuardhousee(GuardHouse guardhousee) {
		this.guardhousee = guardhousee;
	}

	public House getHousee() {
		return housee;
	}

	public ArrayList<NativeGroup> getNativeGroup() {
		return ng;
	}

	public void setHousee(House housee) {
		this.housee = housee;
	}

	public Inn getInnn() {
		return innn;
	}

	public void setInnn(Inn innn) {
		this.innn = innn;
	}

	public void setBd(BoardTiles bt) {
		this.bd = bt;
	}
	
	public void playGame(JTextArea txt, Container cp) {

		if (turn == 4) {
			JOptionPane.showMessageDialog(null,
					"you have maxed your activities for the day");

			/*
			 * try { Thread.sleep(10000); } catch (InterruptedException e) { //
			 * TODO Auto-generated catch block e.printStackTrace(); }
			 */
		}
		/*
		 * if(moved() == true){ if(requestMove(getPlayer1())) turn ++;
		 * setMove(false);
		 * 
		 * System.out.println(turn);
		 * 
		 * }
		 */if (isHide()) {
			if (requestHide(getPlayer1(), getRolled(), txt))
				turn++;
			setHide(false);

		}
		if (isAlert()) {
			if (requestAlert(getPlayer1(), txt))
				turn++;
			setAlert(false);

		}
		if (isRest()) {
			if (requestRest(getPlayer1(), txt))
				turn++;
			setRest(false);

		}
		if (isHire()) {
			if (requestHire(getPlayer1(), txt))
				for (int i = 0; i < ng.size(); i++)
					// showNativeGroup(ng.get(i), getPlayer1(), txt, cp);
					turn++;
			setHire(false);

		}
		if (isSearch()) {
			// if(requestSearch(getPlayer1(), cp))
			turn++;
			setSearch(false);

		}
		if (isTrade()) {
			// intializeTrade(cp, getPlayer1());
			if (requestTrade(getPlayer1()))
				turn++;
			setTrade(false);

		}

	}

	public boolean isPlace() {
		return place;
	}

	public void setPlace(boolean place) {
		this.place = place;
	}

	public int getTurn(){
		return turn;
	}

	public void setTurn(int t){
		this.turn = t;
}
}
