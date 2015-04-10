package gui;

import gameBoard.BoardTiles;
import gameBoard.InitBoardTiles;
import gameLogic.Dice;
import gameLogic.GuiActivities;
import gameLogic.Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import models.Message;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class CombatGui extends JPanel {

	//public static BoardTiles bt = new BoardTiles();
	public static BoardTiles bt;

	static JTabbedPane tabbedPane = new JTabbedPane();
	static JFrame frame = new JFrame("TabbedPaneDemo");
	static GuiActivities gm ;
	
	private static JTextArea txt = new JTextArea ("Welcome to Magic Realm! ");

	static JComponent setup;
	static JComponent panel2;
	static JComponent panel1;
	 static JComponent panel3;
	 static JComponent panel4;
	 static JComponent tradepanel;
	 static JComponent searchpanel;


	 static JButton die1 ;
	static JButton die2 ;
	static ImageIcon[] img;
	 
	final static JButton RollButton = new JButton();	
	 final static JButton setRoll = new JButton("Set Roll");
	 static int clicked;
	 static int lastRoll ;
	static int lastRoll2 ;
	static Model md;
	private static boolean submitt;
    private static Client client;
    private static Kryo kryo;
    static JButton btnNewButton;
    private static BoardTiles bd;
    static JButton[] activity = new JButton[12];
    static HexTiles ht;

    private static boolean blocked;
    private static boolean skippedturn;
    static JLabel amazon;

	static JLabel elf;

	static JLabel dwarf;

	static JLabel captain;

	static JLabel blackKnight;

	static JLabel swordsman;
	int turn;

	// JFrame frame = new JFrame("TabbedPaneDemo");

	public CombatGui() {
		

		super(new GridLayout(1, 1));

		ImageIcon icon = createImageIcon("images/middle.gif");

		setup = makesetupPanel("Panel #1");
		tabbedPane.addTab("Setup", icon, setup, "Select Game Mode");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		gm.promptPlayerName();
		bd = new BoardTiles();
		// JComponent panel1 = makeBoardPanel("Panel #1");
		// tabbedPane.addTab("Game Board", icon, panel1, "Displays Game Board");
		// tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// JComponent panel2 = makeActivityPanel("Panel #2");
		// tabbedPane.addTab("Activity Panel", icon, panel2,
		// "perform daily activities");
		// tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		// JComponent panel3 = makeCharacterPanel("Panel #3");
		// tabbedPane.addTab("Characters", icon, panel3, "Display characters");
		// tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		// JComponent panel4 =
		// makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
		// panel4.setPreferredSize(new Dimension(410, 50));
		// tabbedPane.addTab("Natives", icon, panel4, "Displays hired natives");
		// tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		// Add the tabbed pane to this panel.
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel(String text) {

		// HexTiles ht = new HexTiles(bt);

		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	public static void makeselectionpanel(){
		
	panel2 = makeCharacterPanel("Panel #2");
		tabbedPane.addTab("Characters", null, panel2,
				"Display characters");
		tabbedPane.remove(setup);			
				
	}
	
	
	protected JComponent makesetupPanel(String text) {

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit
						.getDefaultToolkit()
						.getImage(
								CombatGui.class
										.getResource("/others/background_1.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		panel.setLayout(null);
		setBounds(0, 0, 200, 500);

		btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// after start button button is clicked
				// characters.fillContainer();

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Would you like to play in cheat mode?", "Alert",
						dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					gm.setCheatMode(true);
					makeselectionpanel();

					
					

					 txt.append("\n---------------------------------- You are now in Cheat mode....\n CLICK ON INDIVIDUAL DIE TO SET ROLL!!\n");

					// set up the game for cheat mode.....
				

					// die1.setIcon(img[1]);
					// die2.setIcon(img[2]);

					// p1button.setVisible(true);
					// p2button.setVisible(true);

					// amazon.setVisible(true);
					// captain.setVisible(true);
					// blackKnight.setVisible(true);
					// elf.setVisible(true);
					// dwarf.setVisible(true);
					// swordsman.setVisible(true);
					btnNewButton.setVisible(false);
					client.sendTCP(new Message(" we are in cheatmode "));
				} else {
					gm.setCheatMode(false);
					client.sendTCP(new Message(" we are not cheatmode "));

					
					makeselectionpanel();
					
					
					
					// randomMode = true;
					 txt.append("\n---------------------------------- You are now in normal mode!!\n  CLICK ON ROLL BUTTON TO ROLL \n");
					gm.addWarningChits();
					
					//tabbedPane.remove(setup);

           		 	panel1 = makeBoardPanel("Panel #1");
        			tabbedPane.addTab("Game Board", null, panel1, "Displays Game Board");        			
					
					bt.getTile("AWFUL VALLEY").getClearingByNum(5).setDwelling(gm.getChapell());
					bt.getTile("DARK VALLEY").getClearingByNum(4).setDwelling(gm.getGuardhousee());
					bt.getTile("CURST VALLEY").getClearingByNum(5).setDwelling(gm.getHousee());
					bt.getTile("BAD VALLEY").getClearingByNum(5).setDwelling(gm.getInnn());

					if(gm.isSelected())
	        			panel2 = makeCharacterPanel("Panel #2");

					// set up the game for random mode.

					btnNewButton.setVisible(false); // disable the start new
													// game button until we
													// figure out a way to reset
													// the game.
					
					
					 //RollButton.setVisible(true);
					

				}

				if (gm.isCheatMode()) {
					// gm.cheatmodeButtons(getContentPane());

				} else if (!gm.isCheatMode()) {

					// bt.getTile("AWFUL VALLEY").getClearingByNum(5).setDwelling(chapel);
					// bt.getTile("BAD VALLEY").getClearingByNum(5).setDwelling(guardhouse);
					// bt.getTile("CURST VALLEY").getClearingByNum(5).setDwelling(house);
					// bt.getTile("DARK VALLEY").getClearingByNum(5).setDwelling(inn);

					// else if(!cheat)

					// place other natives
					// place other natives

				}


			}
		});

		btnNewButton.setBounds(20, 47, 117, 29);
		panel.add(btnNewButton);
		btnNewButton.setVisible(false);

		// txt.setBorder(new EmptyBorder(0, 0, 0, 0));
		// txt.setForeground(Color.WHITE);
		// txt.setBackground(Color.BLAC

		return panel;
	}

	protected static JComponent makeBoardPanel(String text) {

		JPanel panel = new JPanel(false);
		//bt = InitBoardTiles.initializeTiles();
		ht = new HexTiles(gm.getBD());
		panel.add(ht, BorderLayout.CENTER);
		panel.add(ht.getControls(), BorderLayout.SOUTH);
		panel.setVisible(true);
		ht.addMouseListener(ht.switcher);
		frame.addComponentListener(ht.resizeMonitor);

		
		//JScrollPane scroll = new JScrollPane (tabbedPane, 
				//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				//scroll.setSize(0, 0);
				//scroll.setLocation(1550, 1557);
		//frame.add(scroll);
		
		
		return panel;
	}

	protected static  JComponent makeActivityPanel(String text) {

		//activity 
		
		final JPanel panel = new JPanel(false) {

			public void paintComponent(Graphics g) {
				Image img = Toolkit
						.getDefaultToolkit()
						.getImage(
								CombatGui.class
										.getResource("/others/background_1.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		panel.setLayout(null);
	//	setBounds(0, 0, 200, 500);

			img = new ImageIcon[8]; 
	
		
		

		
		img[0] = new ImageIcon(Gui.class.getResource("/dice/roll.png")); 
		img[1] = new ImageIcon(Gui.class.getResource("/dice/1.png")); 
		img[2] = new ImageIcon(Gui.class.getResource("/dice/2.png")); 
		img[3] = new ImageIcon(Gui.class.getResource("/dice/3.png")); 
		img[4] = new ImageIcon(Gui.class.getResource("/dice/4.png")); 
		img[5] = new ImageIcon(Gui.class.getResource("/dice/5.png")); 
		img[6] = new ImageIcon(Gui.class.getResource("/dice/6.png"));
		
		txt.setBorder(new EmptyBorder(0, 0, 0, 0));
		txt.setForeground(Color.WHITE);
		txt.setBackground(Color.BLACK);


		// create the scroll bar

		txt.setLineWrap(true);
		txt.setEditable(false);
		txt.setWrapStyleWord(true);
		txt.setCaretPosition(txt.getDocument().getLength());
		DefaultCaret caret = (DefaultCaret)txt.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane scroll = new JScrollPane (txt, 
		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setSize(300, 300);
		scroll.setLocation(1550, 227);
		panel.add(scroll);
		
		
		activity[0] = new JButton("Player");
		activity[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gm.placePlayer1(gm.getPlayer1());	
				activity[0].setVisible(false);	
			}
		});
		activity[0].setBounds(400, 200, 100, 40);
		activity[0].setVisible(false);
		panel.add(activity[0]);
		

		if(gm.isCheatMode()){
			activity[0].setVisible(true);
		}
		
		
		die1 = new JButton();
		die1.setBounds(140, 47, 68, 66);                               // bounds for button 
		die1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));  
		die1.setContentAreaFilled(false); 
		die1.setIcon(img[1]);
		die1.setVisible(false);
		panel.add(die1);

		
		die2 = new JButton();
		die2.setBounds(210, 47, 68, 66);                               // bounds for button 
		die2.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));  
		die2.setContentAreaFilled(false);  
		die2.setIcon(img[2]);
		die2.setVisible(false);
		panel.add(die2); 

		
		
		RollButton.setBounds(50, 47, 68, 66); 
		RollButton.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		RollButton.setBorderPainted(false); 
		RollButton.setContentAreaFilled(false); 
		RollButton.setIcon(img[0]);
		RollButton.setVisible(false);
		panel.add(RollButton);
		
		
		setRoll.setBounds(300, 20, 120, 29);                               // bounds for cheat button 
		setRoll.setVisible(false);
		panel.add(setRoll); 
		
		
		
		die1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    clicked++;
		    if(gm.isCheatMode()){
		    	toggleDie1();
		      die1.setSelected(true); 
		      txt.append("\ndie one was clicked\n");
		      die1.setBounds(140, 47, 68, 70);  
		    	}
		    }
		}); 


		die2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	clicked ++;
		    	if(gm.isCheatMode()){
		    		toggleDie2();		    		
		    	die2.setSelected(true); 
		        txt.append("\ndie 2 was clicked\n");
		        die2.setBounds(210, 47, 68, 70);                               // bounds for button 
		        
		        
		    	}
		    }
		}); 
		
		
		
		
		
		RollButton.addActionListener(new ActionListener() {                 //Button Listener/* 
		    @Override
		public void actionPerformed(ActionEvent e) { 
		    	
		    	Dice dice = new Dice();
		    	int lastRoll ;
		    	int lastRoll2 ;
		    	
		    	gm.setRolled(true);
		    	die1.setVisible(true);
		        die2.setVisible(true);
		        RollButton.setVisible(false);
		        
		    	
		    	
		   lastRoll = (dice.roll());  
		  lastRoll2 = (dice.roll()); 		 		    
		    
		    txt.append("\n----------------------------------\nDie1 rolled a: " + lastRoll); 
		    txt.append("\n----------------------------------\nDie2 rolled a: " + lastRoll2); 
		   
		        gm.getPlayer1().getCharacter().setRoll(Math.max(lastRoll, lastRoll2));
		    
		        txt.append("\n----------------------------------\n" + gm.getPlayer1().getName() +" rolled : " + gm.getPlayer1().getCharacter().getRoll()); 
		    
		    die1.setIcon(img[lastRoll]); 
		    die2.setIcon(img[lastRoll2]); 
		    
		    //rolled = true;    

		    
		    }  
		    }); 
		
		setRoll.addActionListener(new ActionListener() {                 //Button Listener/* 
		    @Override
		public void actionPerformed(ActionEvent e) { 

		    	gm.setRolled(true);

		        txt.append("\n---------------------------------- die 1 rolled!!\n" + lastRoll + "\n");
		        txt.append("\n---------------------------------- die 2 rolled!!\n" + lastRoll2 + "\n");
		        
		            gm.getPlayer1().getCharacter().setRoll(Math.max(lastRoll, lastRoll2));
			        txt.append("You rolled  " + gm.getPlayer1().getCharacter().getRoll() + "\n");

		            
		    }  
		    }); 
		
		final JTextField TileName = new JTextField();
		final JTextField Clearing = new JTextField();
		
		final Object[] message = {
		    "Tile Name:", TileName,
		    "Clearing:", Clearing
		};
		
		activity[1] = new JButton("MOVE");
		activity[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "move!");                        	
				//gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).removePersonHere(gm.getPlayer1().getPchit());	

				gm.setMove(true);	
			//make sure that no event is still happening before moving	
	if(!gm.isEnchant() && !gm.isAlert() && !gm.isFollow() && !gm.isHide() && !gm.isHire()&& !gm.isRest() && !gm.isSearch()&& !gm.isTrade()){
		if(gm.requestMove(gm.getPlayer1())){
					System.out.println(gm.getPlayer1().getClearing());
					System.out.println(gm.getPlayer1().getCharacter().getClearingLocation());
					System.out.println(gm.getPlayer1().getCharacter().getTileName());
					System.out.println(gm.getPlayer1().getTile());

					activity[0].setVisible(false);
					//gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(2).setPlayerHere(false);	
					//System.out.println(gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(2).getPersonHere());	

					
				if(gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).getPeopleHere().size() > 1 && gm.getPlayer1().getCharacter().getVisibility() == false)	
						client.sendTCP(new Message("block me"));
				
					
				}
				}
			}
		});
		activity[1].setBounds(50, 150, 89, 23);
		panel.add(activity[1]);
		activity[1].setVisible(true);

		activity[2] = new JButton("HIDE");
		activity[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				gm.setHide(true);
				gm.setRolled(false);

	if(!gm.isEnchant() && !gm.isAlert() && !gm.isFollow() && !gm.moved() && !gm.isHire()&& !gm.isRest() && !gm.isSearch()&& !gm.isTrade()){

				hiding(gm.isCheatMode());
	}
			}
		});
		activity[2].setBounds(50, 200, 89, 23);
		panel.add(activity[2]);
		activity[2].setVisible(true);

		activity[3] = new JButton("TRADE");
		activity[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				JOptionPane.showMessageDialog(null, "Hit back button when done to continue game");
				gm.setTrade(true);
if(!gm.isEnchant() && !gm.isAlert() && !gm.isFollow() && !gm.moved() && !gm.isHire()&& !gm.isRest() && !gm.isSearch()&& !gm.isHide()){
			
				tradepanel = new JPanel(){								
				public void paintComponent(Graphics g) {
					Image img = Toolkit
							.getDefaultToolkit()
							.getImage(
									CombatGui.class
											.getResource("/others/background_1.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};

				tradepanel.setName("Trade Panel");												
				tradepanel.setLayout(null);
				gm.intializeTrade(tradepanel, tabbedPane, gm.getPlayer1());
				tabbedPane.addTab("Tradepanel", null, tradepanel, "DO YOUR TRADINGS");
}
			}
		});
		activity[3].setBounds(50, 250, 89, 23);
		panel.add(activity[3]);
		activity[3].setVisible(true);

		activity[4] = new JButton("SEARCH");
		activity[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hit back button when done to continue game");
		gm.setSearch(true);
	if(!gm.isEnchant() && !gm.isAlert() && !gm.isFollow() && !gm.moved() && !gm.isHire()&& !gm.isRest() && !gm.isTrade()&& !gm.isHide()){			
				//hhh
				searching(gm.isCheatMode());
				}
			}
		});
		activity[4].setBounds(50, 300, 89, 23);
		panel.add(activity[4]);
		activity[4].setVisible(true);

		activity[5] = new JButton("REST");
		activity[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setRest(true);
	if(!gm.isEnchant() && !gm.isAlert() && !gm.isFollow() && !gm.moved() && !gm.isHire()&& !gm.isSearch() && !gm.isTrade()&& !gm.isHide()){			
				
			gm.requestRest(gm.getPlayer1(), txt);
	
	}
			}
		});
		activity[5].setBounds(50, 350, 89, 23);
		panel.add(activity[5]);
		activity[5].setVisible(true);

		activity[6] = new JButton("ALERT");
		activity[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setAlert(true);
				if(!gm.isEnchant() && !gm.isRest() && !gm.isFollow() && !gm.moved() && !gm.isHire()&& !gm.isSearch() && !gm.isTrade()&& !gm.isHide()){			
			
				gm.requestAlert(gm.getPlayer1(), txt);
				gm.setAlert(false);

				//gm.playGame(txt, panel);
				}
			}
		});
		activity[6].setBounds(50, 400, 89, 23);
		panel.add(activity[6]);
		activity[6].setVisible(true);

		activity[7] = new JButton("HIRE");
		activity[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setHire(true);				
	if(!gm.isEnchant() && !gm.isRest() && !gm.isFollow() && !gm.moved() && !gm.isAlert()&& !gm.isSearch() && !gm.isTrade()&& !gm.isHide()){			

					
		if(gm.requestHire(gm.getPlayer1(), txt)){
		for(int i = 0; i < gm.getNativeGroup().size(); i++)
			gm.showNativeGroup(gm.getNativeGroup().get(i), gm.getPlayer1(), txt, panel);
		//gm.playGame(txt, panel);
		gm.setHire(false);

		}
	}
			}
		});
		activity[7].setBounds(50, 450, 89, 23);
		panel.add(activity[7]);
		activity[7].setVisible(true);

		activity[8] = new JButton("FOLLOW");
		activity[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setFollow(true);				
	if(!gm.isEnchant() && !gm.isRest() && !gm.isHire() && !gm.moved() && !gm.isAlert()&& !gm.isSearch() && !gm.isTrade()&& !gm.isHide()){			
			if(gm.getPlayer1().getCharacter().getHiredNatives().get(0) != null){
				gm.getPlayer1().getCharacter().getHiredNatives().get(0).setTile(gm.getPlayer1().getCharacter().getTileName());
				gm.getPlayer1().getCharacter().getHiredNatives().get(0).setClearing(gm.getPlayer1().getCharacter().getClearingLocation());

				gm.setFollow(false);
				
				//gm.playGame(txt, panel);
	}
			}
			}
		});
		activity[8].setBounds(50, 500, 89, 23);
		panel.add(activity[8]);
		activity[8].setVisible(true);

		activity[9] = new JButton("ENCHANT");
		activity[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setEnchant(true);
				gm.playGame(txt, panel);

			}
		});
		activity[9].setBounds(50, 550, 89, 23);
		panel.add(activity[9]);
		activity[9].setVisible(true);

		activity[10] = new JButton("COMBAT");
		activity[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gm.setCombat(true);
				// gm.initCombatScreen();
				System.out.println(gm.requestCombat(gm.getPlayer1()));
				//gm.requestCombat(gm.getPlayer1());
				if (gm.requestCombat(gm.getPlayer1()) == false) {
					System.out.println("Here 4");
					gm.initCombatScreen();
					System.out.println("Here 5");
					//gm.requestCombat(gm.getPlayer1());
				} else {
					System.out.println("DdDDDDD");
					gm.initCombatScreen();
				}
				
				if (gm.getSendToServer() == true) {
					client.sendTCP(new Message("character chits sent"));
					client.sendTCP(gm.getPlayer1());
				}
			}
		});
		activity[10].setBounds(50, 600, 89, 23);
		panel.add(activity[10]);
		activity[10].setVisible(true);

		activity[11] = new JButton("SUBMIT");
		activity[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setsubmit(true);
				client.sendTCP(new Message("sending game model"));
				client.sendTCP(gm.getBD());
				client.sendTCP(gm.getPlayer1());
				for (int i = 0; i < activity.length; i++)
					activity[i].setVisible(false);

			}
		});
		activity[11].setBounds(50, 800, 89, 23);
		panel.add(activity[11]);
		activity[11].setVisible(true);
		
		
		
		
		
		if(gm.isCheatMode()){
			die2.setVisible(true);
			die1.setVisible(true);
		JOptionPane.showMessageDialog(null, "Welcome to cheat mode");                        	
		setRoll.setVisible(true);	

			
		}
		else if(!gm.isCheatMode()){
			RollButton.setVisible(true);
			if(gm.isSelected())
				tabbedPane.remove(panel2);
		
		}
		
		
		return panel;
	}

	protected static  JComponent CharacterPanel(String text) {
		
		JPanel panel = new JPanel(false) {
			

			public void paintComponent(Graphics g) {
				Image img = Toolkit
						.getDefaultToolkit()
						.getImage(
								CombatGui.class
										.getResource("/others/background_1.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		panel.setLayout(null);
		
		
		final JLabel selectedCharacter = new JLabel("");
		selectedCharacter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		

			}
		});

		toggleIcons(selectedCharacter);							// checks and displays the right character icon
		selectedCharacter.setBounds(300, 150, 900, 700);
		selectedCharacter.setName(gm.getPlayer1().getCharacter().getName());
		selectedCharacter.setVisible(true);
		panel.add(selectedCharacter);
	
	
		JButton weapons = new JButton("Weapons");	
		weapons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0 ; i < gm.getPlayer1().getCharacter().getMyweapons().size(); i++)
				JOptionPane.showMessageDialog(null, gm.getPlayer1().getCharacter().getMyweapons().get(i).getName() +" \n");

			}
		});
		weapons.setBounds(1250, 150, 100, 23);
		//backButton.setIcon(new ImageIcon(CombatGui.class
				//.getResource("/actions/backarrow.gif")));
		weapons.setVisible(true);
		panel.add(weapons);

		JButton armor = new JButton("Armor");	
		armor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0 ; i < gm.getPlayer1().getCharacter().getCharacterArmory().size(); i++)
					JOptionPane.showMessageDialog(null, gm.getPlayer1().getCharacter().getCharacterArmory().get(i).getName() +" \n");

			}
		});
		armor.setBounds(1250, 180, 100, 23);
		//backButton.setIcon(new ImageIcon(CombatGui.class
				//.getResource("/actions/backarrow.gif")));
		armor.setVisible(true);
		panel.add(armor);
		
		JButton natives = new JButton("Hired Natives");	
		natives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gm.getPlayer1().getCharacter().getHiredNatives() != null){
				for(int i = 0 ; i < gm.getPlayer1().getCharacter().getHiredNatives().size(); i++)
					JOptionPane.showMessageDialog(null, gm.getPlayer1().getCharacter().getHiredNatives().get(i).getName() +" \n");
				
				
				
				}
			}
		});
		natives.setBounds(1250, 230, 100, 23);
		//backButton.setIcon(new ImageIcon(CombatGui.class
				//.getResource("/actions/backarrow.gif")));
		natives.setVisible(true);
		panel.add(natives);
		
		JButton gold = new JButton("Gold");	
		gold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You currently have: " + gm.getPlayer1().getCharacter().getGold() +" golds\n");


			}
		});
		gold.setBounds(1250, 280, 100, 23);
		//backButton.setIcon(new ImageIcon(CombatGui.class
				//.getResource("/actions/backarrow.gif")));
		gold.setVisible(true);
		panel.add(gold);
		
		JButton treasures = new JButton("Treasures");	
		treasures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
			}
		});
		treasures.setBounds(1250, 330, 100, 23);
		//backButton.setIcon(new ImageIcon(CombatGui.class
				//.getResource("/actions/backarrow.gif")));
		treasures.setVisible(true);
		panel.add(treasures);
		
		
		JButton notoriety = new JButton("Notoriety");	
		notoriety.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			JOptionPane.showMessageDialog(null, "You currently have: " + gm.getPlayer1().getCharacter().getNotoriety() +" Notoriety\n");


			}
		});
		notoriety.setBounds(1250, 380, 100, 23);
		notoriety.setVisible(true);
		panel.add(notoriety);
		
		JButton movechit = new JButton("Chits");	
		movechit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(gm.getPlayer1().getCharacter().getReadyCounter() != null){
			for(int i = 0; i < gm.getPlayer1().getCharacter().getReadyCounter().size(); i++)
				JOptionPane.showMessageDialog(null, "You currently these ready chits \n: " + gm.getPlayer1().getCharacter().getReadyCounter().get(i).getDetails() +" Notoriety\n");

				}
			}
		});
		movechit.setBounds(1250, 430, 100, 23);
		movechit.setVisible(true);
		panel.add(movechit);
		
		
		JButton fatchit = new JButton("Fatigued Chits");	
		fatchit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(gm.getPlayer1().getCharacter().getFatiguedCounter() != null){
			for(int i = 0; i < gm.getPlayer1().getCharacter().getFatiguedCounter().size(); i++)
				JOptionPane.showMessageDialog(null, "You currently these fatiqued chits \n: " + gm.getPlayer1().getCharacter().getFatiguedCounter().get(i).getDetails() +" Notoriety\n");

				}
			}
		});
		fatchit.setBounds(1250, 480, 100, 23);
		fatchit.setVisible(true);
		panel.add(fatchit);
		
		
		if(gm.isCheatMode()){  	
			gm.cheatmodeButtons(panel);		
			}
	
	
		
		
		return panel;
	
	
	}
	
	protected static  JComponent makeCharacterPanel(String text) {

		JPanel panel = new JPanel(false) {
			

			public void paintComponent(Graphics g) {
				Image img = Toolkit
						.getDefaultToolkit()
						.getImage(
								CombatGui.class
										.getResource("/others/background_1.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		panel.setLayout(null);
		//setBounds(0, 0, 200, 500);

		final JLabel AmazonIcon = new JLabel("");
		AmazonIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gm.checkSelected(gm.getPlayer1(), e);
				checkSelected();
				getNextPhase();

			}
		});

		AmazonIcon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characterdetails/amazon.jpg")));
		AmazonIcon.setBounds(300, 150, 900, 700);
		AmazonIcon.setName("Amazon");
		AmazonIcon.setVisible(false);
		panel.add(AmazonIcon);

		final JLabel CaptainIcon = new JLabel("");
		CaptainIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gm.checkSelected(gm.getPlayer1(), e);
				checkSelected();
				getNextPhase();
			}
		});

		CaptainIcon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characterdetails/captain.jpg")));
		CaptainIcon.setBounds(300, 150, 900, 700);
		CaptainIcon.setName("Captain");
		CaptainIcon.setVisible(false);
		panel.add(CaptainIcon);

		final JLabel DwarfIcon = new JLabel("");

		DwarfIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gm.checkSelected(gm.getPlayer1(), e);
				checkSelected();
				getNextPhase();

			}
		});
		DwarfIcon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characterdetails/dwarf.jpg")));
		DwarfIcon.setBounds(300, 150, 900, 700);
		DwarfIcon.setName("Dwarf");
		DwarfIcon.setVisible(false);
		panel.add(DwarfIcon);

		final JLabel ElfIcon = new JLabel("");
		ElfIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gm.checkSelected(gm.getPlayer1(), e);
				checkSelected();
				getNextPhase();

			}
		});
		ElfIcon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characterdetails/elf.jpg")));
		ElfIcon.setBounds(300, 150, 900, 700);
		ElfIcon.setName("Elf");
		ElfIcon.setVisible(false);
		panel.add(ElfIcon);

		final JLabel SwordsManIcon = new JLabel("");

		SwordsManIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gm.checkSelected(gm.getPlayer1(), e);
				checkSelected();
				getNextPhase();

			}
		});
		SwordsManIcon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characterdetails/swordsman.jpg")));
		SwordsManIcon.setBounds(300, 150, 900, 700);
		SwordsManIcon.setName("Swordsman");
		SwordsManIcon.setVisible(false);
		panel.add(SwordsManIcon);

		final JLabel BlackKnightIcon = new JLabel("");
		BlackKnightIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				gm.checkSelected(gm.getPlayer1(), e);
				checkSelected();
				getNextPhase();
			}
		});
		BlackKnightIcon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characterdetails/black_knight.jpg")));
		BlackKnightIcon.setBounds(300, 150, 900, 700);
		BlackKnightIcon.setName("BlackKnight");
		BlackKnightIcon.setVisible(false);
		panel.add(BlackKnightIcon);

		final JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AmazonIcon.setVisible(false);
				CaptainIcon.setVisible(false);
				BlackKnightIcon.setVisible(false);
				ElfIcon.setVisible(false);
				DwarfIcon.setVisible(false);
				SwordsManIcon.setVisible(false);
				backButton.setVisible(false);

			}
		});
		backButton.setBounds(800, 907, 100, 23);
		backButton.setIcon(new ImageIcon(CombatGui.class
				.getResource("/actions/backarrow.gif")));
		backButton.setVisible(false);
		panel.add(backButton);

		amazon = new JLabel("");
		amazon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AmazonIcon.setVisible(true);
				backButton.setVisible(true);

			}
		});
		amazon.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/amazon.png")));
		amazon.setBounds(300, 47, 100, 100);
		amazon.setName("amazon");
		amazon.setVisible(true);
		panel.add(amazon);

		dwarf = new JLabel("");

		dwarf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				DwarfIcon.setVisible(true);
				backButton.setVisible(true);

			}
		});
		dwarf.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/dwarf.png")));
		dwarf.setBounds(450, 47, 100, 100);
		dwarf.setName("dwarf");
		dwarf.setVisible(true);
		panel.add(dwarf);

		elf = new JLabel("");

		elf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ElfIcon.setVisible(true);
				backButton.setVisible(true);

			}
		});

		elf.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/elf.png")));
		elf.setBounds(600, 47, 100, 100);
		elf.setName("elf");
		elf.setVisible(true);
		panel.add(elf);

		captain = new JLabel("");
		captain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CaptainIcon.setVisible(true);
				backButton.setVisible(true);

			}
		});
		captain.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/captain.png")));
		captain.setBounds(750, 47, 100, 100);
		captain.setName("captain");
		captain.setVisible(true);
		panel.add(captain);

		blackKnight = new JLabel("");
		blackKnight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BlackKnightIcon.setVisible(true);
				backButton.setVisible(true);

			}
		});

		blackKnight.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/black_knight.png")));
		blackKnight.setBounds(900, 47, 100, 100);
		blackKnight.setName("blackKnight");
		blackKnight.setVisible(true);
		panel.add(blackKnight);

		swordsman = new JLabel("");
		swordsman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SwordsManIcon.setVisible(true);
				backButton.setVisible(true);
			}
		});
		swordsman.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/swordsman.png")));
		swordsman.setBounds(1050, 47, 100, 100);
		swordsman.setName("swordsman");
		swordsman.setVisible(true);
		panel.add(swordsman);

		System.out.println(gm.isSelected());

		return panel;
	}

	public static void popup(String name) {

		JPanel popup = new JPanel();
		JLabel tileLabel = new JLabel();

		tileLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		tileLabel.setIcon(new ImageIcon(HexCell.class.getResource("/"
				+ bt.getTile(name).getFilePath())));
		tileLabel.setBounds(50, 1000, 1000, 1000);
		tileLabel.setName(name);
		tileLabel.setVisible(true);

		popup.add(tileLabel);
		popup.setVisible(true);

		JFrame frame1 = new JFrame("");
		frame1.setBounds(50, 50, 600, 600);
		frame1.add(popup);
		frame1.setTitle(name);
		frame1.setVisible(true);
		// frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
	}

	public static  void getNextPhase() {

		if (gm.isSelected()) {

			tabbedPane.remove(panel2);
			panel4 = CharacterPanel("panel 4");
			tabbedPane.addTab("Character", null, panel4,
					"check characters inventory");
		
			panel3 = makeActivityPanel("Panel #3");
			tabbedPane.addTab("Activity Panel", null, panel3,
					"perform daily activities");
			// tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
			//tabbedPane.setSelectedIndex(1);
		
			 

        	client.sendTCP(new Message("selected"));
			client.sendTCP(new Message(gm.getPlayer1().getCharacter().getName()));

		
		
		}

	}
	
	public static void checkSelected(){
		if(gm.isSelected())
	    	JOptionPane.showMessageDialog(null, "PLEASE CHOOSE YOUR 4 ACTIVITIES FOR THE DAY.");
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = CombatGui.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 */
	@SuppressWarnings("deprecation")
	private static void createAndShowGUI() {
		// Create and set up the window.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new CombatGui(), BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.resize(new Dimension(1920, 1040));

		// HexTiles.initGameBoard(bt);

		// frame.add(ht.getCon)
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
	

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				md = new Model();
				//md.playGame();
				bt = new BoardTiles(); 
				bt = InitBoardTiles.initializeTiles();
				gm = new GuiActivities(bt);
				//HexTiles.initGameBoard(bt);

		
				
				createAndShowGUI();
			}
		});
		
		client = new Client(122768, 106384);
        client.setTimeout(600000);
        kryo = client.getKryo();
        kryo.setReferences(true);
        registerClasses();

        new Thread(client).start();
        try {
            client.connect(5000, "localhost", 9999);
        } catch (Exception e) {
            System.out.println("Connection failed");
        }

        client.sendTCP(new Message("connect"));
        

        client.addListener(new Listener() {
            @Override
            public void connected(Connection connection) {
                System.out.println("Connected to server");
            }
            @Override
            public void received(Connection connection, Object object) {
                if (object instanceof BoardTiles) {
                //	((BoardTiles)object).getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).removePersonHere(gm.getPlayer1().getPchit());
                	
                             	
                	gm.setBd(((BoardTiles) object));
                	 gm.getPlayer1().moveTo(gm.getPlayer1().getTile(), gm.getPlayer1().getClearing());
                    gm.getPlayer1().getCharacter().moveTo(gm.getPlayer1().getTile(), gm.getPlayer1().getClearing());
                  
    				gm.getPlayer1().setPchit(gm.getP1chit());

                    // gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).removePersonHere(gm.getPlayer1().getPchit());	
                
                    //   gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).movePersonHere(gm.getPlayer1().getPchit());                    
                    tabbedPane.remove(panel1);

                		 panel1 = makeBoardPanel("Panel #1");
             			tabbedPane.addTab("Game Board", null, panel1, "Displays Game Board");
            			//panel2 = CharacterPanel("Panel #2");


            			
            			
            			/*
                	System.out.println("Received game model");                                       
                    tabbedPane.remove(panel1);
                    gm.setBd((BoardTiles) object);   
                    panel1 = makeBoardPanel("Panel #1");
        			tabbedPane.addTab("Game Board", null, panel1, "Displays Game Board");
             
        			panel2 = CharacterPanel("Panel #2");
                    
                    
                 // if(gm.isPlace()){
                  gm.getBD().getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).removePersonHere(gm.getPlayer1().getPchit());	
                 
                   // panel1 = makeBoardPanel("Panel #1");
        			//tabbedPane.addTab("Game Board", null, panel1, "Displays Game Board");
             
                   // }
                    
                   // gm.getPlayer1().moveTo(gm.getPlayer1().getTile(), gm.getPlayer1().getClearing());
                   // gm.getPlayer1().getCharacter().moveTo(gm.getPlayer1().getTile(), gm.getPlayer1().getClearing());

                    
             
                   	//gm.setBd((BoardTiles) object);
                		//if(gm.isPlace())                    
                   // ((BoardTiles) object).getTile(gm.getPlayer1().getTile()).getClearingByNum(gm.getPlayer1().getClearing()).movePersonHere(gm.getPlayer1().getPchit());                    
                       
            			
                	
                    
              
        		
                  */  
                   
                  
                    
                } else if (object instanceof Message) {
                    System.out.println(object.toString()); //set attribute on UI letting you know what player you are.
                    if (object.toString().contains("Connection 1")) {
                    	//System.out.println(activity.length);
                    	btnNewButton.setVisible(true);
    					
                    		 
                    	
                    	//JOptionPane.showMessageDialog(null, "Welcome to Magic Realm!");
                   
                    	}
    					else if(object.toString().contains("your turn")){
    						if(!gm.isSelected())
    							makeselectionpanel();
    						else{JOptionPane.showMessageDialog(null, "Your turn!");    			
                    		for(int i = 0; i < activity.length; i++)
                    			activity[i].setVisible(true);
    						}
    					}else if(object.toString().contains("not turn")){
    						//if(!gm.isSelected())
        						//makeselectionpanel();

    							//client.sendTCP(new Message("notselected"));
    						
    					}
                    
    					else if(((Message) object).toString().contains("chose amazon")){
                        amazon.setVisible(false);
    					
    					}
                        
                        else if(((Message) object).toString().contains("chose elf")){
                        elf.setVisible(false);
                        
                        }
                       
                        else if(((Message) object).toString().contains("chose dwarf")){
                        dwarf.setVisible(false);
                        }
                        else if(((Message) object).toString().contains("chose captain")){
                        captain.setVisible(false);
                        }
                        
                        else if(((Message) object).toString().contains("chose Swordsman")){
                        	swordsman.setVisible(false);
                        }
                        
                        else if(((Message) object).toString().contains("chose blackknight")){
                        	blackKnight.setVisible(false);
                        }
    					else if(object.toString().contains("select")){            					
	                    	//if(!gm.isSelected())
    						//makeselectionpanel();
	     				

    					}     
                    
    					else if(object.toString().contains("not current turn")){   
    						if(isSkippedturn())
	                    	setBlocked(false);

   					}     
                    
    					else if(object.toString().contains("been blocked")){   
    						setBlocked(true);
	     					JOptionPane.showMessageDialog(null, "You have been Blocked!");
	     					client.sendTCP(gm.getBD());
	     					client.sendTCP(gm.getPlayer1());
                			for(int i = 0; i < activity.length; i++)
                    			activity[i].setVisible(false);
                		client.sendTCP(new Message("i was blocked"));

   					}     
                    
    					else if(object.toString().contains("is connectedtrue")){            					
    						gm.setCheatMode(true);
   					}     
    					else if(object.toString().contains("is connectedfalse")){            					
    						gm.setCheatMode(false);
   					}  else if (object.toString().contains("are now in combat")) {
						JOptionPane.showMessageDialog(null,
								"You are now in combat");
						if (gm.requestCombat(gm.getPlayer1()) == false) {
							gm.initCombatScreen();
							//gm.requestCombat(gm.getPlayer1());
						}
					} else if(object.toString().contains("ok")){            					
        				JOptionPane.showMessageDialog(null, "Wait your turn!");                        	
							tabbedPane.remove(panel2);
    						System.out.println(object);

    						for(int i = 0; i < activity.length; i++)
                    		activity[i].setVisible(false);
   						//for(int i = 0; i < activity.length; i++)
                   			//activity[i].setVisible(false);
   						
                   		//if(!gm.isSelected())
   					} 
    					else if(object.toString().contains("sending")){            					
    	                    System.out.println("Server said: "  + object.toString());
    	                    txt.append("Server said: "  + object.toString() + "\n");

       					} 
                    
    					
    					//}else{
    						//if(!gm.isSelected())
    	                    	 //makeselectionpanel();
    					}
                    		
                    		/*}else{
                    	 
                    	if(!gm.isSelected())
                    	 makeselectionpanel();
                    	//JOptionPane.showMessageDialog(null, "Wait your turn!");
                    	for(int i = 0; i < activity.length; i++)
                			activity[i].setVisible(false);
                    	
                    		
                    }
                    	*/
                    
                    //client.sendTCP(new Message("sending thank you!"));
                   // System.out.println("Server said: "  + object.toString());
                  
                }
        
           
            @Override
            public void disconnected(Connection connection) {
                System.out.println("Disconnected from server");
            }
        });
    
		
		
		
		
		
		
		
		
		
	}

	
public static void registerClasses() {
	 kryo.register(java.util.ArrayList.class);
     kryo.register(java.util.HashMap.class);      
     kryo.register(java.util.HashMap.class);      

     kryo.register(java.awt.BorderLayout.class);      
     kryo.register(java.awt.Color.class);      
     kryo.register(java.awt.Dimension.class);      
     kryo.register(java.awt.Graphics.class);      
     kryo.register(java.awt.GridLayout.class);      
     kryo.register(java.awt.Image.class);      
     kryo.register(java.awt.Toolkit.class);      
     kryo.register(java.awt.event.ActionEvent.class);      
     kryo.register(java.awt.event.ActionListener.class);      
     kryo.register(java.awt.event.KeyEvent.class);      
     kryo.register(java.awt.event.MouseAdapter.class);      
     kryo.register(java.awt.event.MouseEvent.class);      
     kryo.register(javax.swing.BorderFactory.class);      
     kryo.register(javax.swing.ImageIcon.class);      
     kryo.register(javax.swing.JButton.class);      
     kryo.register(javax.swing.JComponent.class);      
     kryo.register(javax.swing.JFrame.class);      
     kryo.register(javax.swing.JLabel.class);      
     kryo.register(javax.swing.JOptionPane.class);      
     kryo.register(javax.swing.JPanel.class);      
     kryo.register(javax.swing.JScrollPane.class);      
     kryo.register(javax.swing.JTabbedPane.class);      
     kryo.register(javax.swing.JTextArea.class);      
     kryo.register(javax.swing.SwingUtilities.class);      
     kryo.register(javax.swing.UIManager.class);      
     kryo.register(javax.swing.border.EmptyBorder.class);      
     kryo.register(javax.swing.text.DefaultCaret.class);      
     
     
     kryo.register(java.io.FileReader.class);      
     kryo.register(java.net.URL.class);      
     kryo.register(org.json.simple.JSONObject.class);      
     
     
     kryo.register(org.json.simple.JSONArray.class);      
     kryo.register(org.json.simple.parser.JSONParser.class);      
     
     
     kryo.register(javax.swing.JTextField.class);      
     kryo.register(javax.swing.ButtonGroup.class);   
     
     kryo.register(java.awt.Container.class);   
     kryo.register(java.awt.Component.class);   
     kryo.register(javax.swing.ButtonGroup.class);   
     kryo.register(javax.swing.ButtonGroup.class);   

     


     
     kryo.register(gameBoard.BoardTiles.class);
     kryo.register(gameBoard.Clearing.class);
     kryo.register(gameBoard.InitBoardTiles.class);
     kryo.register(gameBoard.Tiles.class);
     kryo.register(gameLogic.Dice.class);
     kryo.register(gameLogic.GuiActivities.class);
     kryo.register(gameLogic.Iteration1Board.class);
     kryo.register(gameLogic.Locate.class);
     kryo.register(gameLogic.LocateEnum.class);
     kryo.register(gameLogic.Loot.class);
     kryo.register(gameLogic.LootEnum.class);
     kryo.register(gameLogic.MagicSightEnum.class);
     kryo.register(gameLogic.Model.class);
     kryo.register(gameLogic.Peer.class);
     kryo.register(gameLogic.PeerEnum.class);
     kryo.register(gameLogic.SearchTable.class);
     kryo.register(gui.CombatGui.class);
     kryo.register(gui.Gui.class);
     kryo.register(gui.HexCell.class);
     kryo.register(models.Amazon.class);
     kryo.register(models.Armor.class);
     kryo.register(models.BlackKnight.class);
     kryo.register(models.BreastPlates.class);
     kryo.register(models.BroadSword.class);
     kryo.register(models.Business.class);
     kryo.register(models.Captain.class);
     kryo.register(models.Chapel.class);
     kryo.register(models.Message.class);


     kryo.register(models.CharacterContainer.class);
     kryo.register(models.Counters.class);
     kryo.register(models.CrossBow.class);
     kryo.register(models.DamageEnum.class);
     kryo.register(models.Dwarf.class);
     kryo.register(models.Dwelling.class);
     kryo.register(models.Elf.class);
     kryo.register(models.Entity.class);
     kryo.register(models.Fight.class);
     kryo.register(models.Follow.class);
     kryo.register(models.GreatAxe.class);
     kryo.register(models.GreatSword.class);
     kryo.register(models.GuardHouse.class);
     kryo.register(models.Helmet.class);
     kryo.register(models.Hide.class);
     kryo.register(models.House.class);
     kryo.register(models.Income.class);
     kryo.register(models.Inn.class);


     kryo.register(models.LightBow.class);
     kryo.register(models.Mace.class);
     kryo.register(models.Monster.class);
     kryo.register(models.Move.class);
     kryo.register(models.Player.class);
     kryo.register(models.PlayerChit.class);
     kryo.register(models.Search.class);
     kryo.register(models.Shields.class);
     kryo.register(models.ShortSword.class);
     kryo.register(models.Spear.class);
     kryo.register(models.SuitsOfArmor.class);
     kryo.register(models.Swordsman.class);
     kryo.register(models.Things.class);
     kryo.register(models.ThrustingSword.class);
     kryo.register(models.TreasureChit.class);
     kryo.register(models.WarningChit.class);
     kryo.register(models.Weapons.class);
     
     
     
     
     kryo.register(natives.Archer.class);
     kryo.register(natives.Assasin.class);
     kryo.register(natives.Bashkars.class);
     kryo.register(natives.Company.class);
     kryo.register(natives.Crossbowman.class);
     kryo.register(natives.GreatAxeman.class);
     kryo.register(natives.GreatSwordsman.class);
     kryo.register(natives.Guard.class);
     kryo.register(natives.Knight.class);
     kryo.register(natives.Lancer.class);
     kryo.register(natives.Lancers.class);
     kryo.register(natives.Native.class);
     kryo.register(natives.NativeGroup.class);
     kryo.register(natives.Order.class);
     kryo.register(natives.Patrol.class);
     kryo.register(natives.Pikeman.class);
     kryo.register(natives.Raider.class);
     kryo.register(natives.Rogues.class);
     kryo.register(natives.ShortSwordsman.class);
     kryo.register(natives.Soldiers.class);
     kryo.register(natives.Swordsman.class);
     kryo.register(natives.Woodfolk.class);
    
     
     kryo.register(networking.MyServer.class);
     kryo.register(javax.swing.JPasswordField.class);
     kryo.register(javax.swing.ActionMap.class);
     kryo.register(javax.swing.text.JTextComponent.class);
     kryo.register(String[].class);
     kryo.register(models.WarningChit.Smoke.class);
     kryo.register(models.WarningChit.Bones.class);
     kryo.register(models.WarningChit.Dank.class);
     kryo.register(models.WarningChit.Ruins.class);
     kryo.register(models.WarningChit.Stink.class);
     kryo.register(java.util.LinkedList.class);
     //kryo.register(javax.swing.text.JTextComponent.KeymapActionMap.class);
}



public static void toggleDie1(){	// change the die1 face any time the die is clicked

	if (clicked ==1){
		die1.setIcon(img[1]);
		lastRoll = 1;
	}
	else if(clicked == 2) {
		die1.setIcon(img[2]);
		lastRoll = 2;

	}
	else if(clicked == 3){ 
		die1.setIcon(img[3]);
	    lastRoll = 3;
	}
	else if(clicked == 4){ 
		die1.setIcon(img[4]);
	    lastRoll = 4;

	}
	else if(clicked == 5) {
		die1.setIcon(img[5]);
		lastRoll = 5;
	}
	else if(clicked == 6){ 
		die1.setIcon(img[6]);
		lastRoll = 6;
	}
	else if(clicked >6){;
	  clicked = 1;
	  toggleDie1();
	}


	
}
 

public static void toggleDie2(){

	if (clicked ==1) {
		die2.setIcon(img[1]);
		lastRoll2 = 1;
	}
	else if(clicked == 2) {
		die2.setIcon(img[2]);
		lastRoll2 = 2;

	}
	else if(clicked == 3) {
		die2.setIcon(img[3]);
		lastRoll2 = 3;

	}
	else if(clicked == 4) {
		die2.setIcon(img[4]);
		lastRoll2 = 4;

	}
	else if(clicked == 5){
		die2.setIcon(img[5]);
		lastRoll2 = 5;
	}
	else if(clicked == 6) {
		die2.setIcon(img[6]);
		lastRoll2 = 6;
	}
	else if(clicked >6){;
	  clicked = 1;
	  toggleDie2();
	}


	
}

public static void hiding(boolean cheatmode){// performs hiding according to game mode.
	if(!cheatmode){
		RollButton.setVisible(true);
		if(gm.getRolled() == false)
			JOptionPane.showMessageDialog(null, "Please Roll a die \n Roll a 1 for hide \n Roll 2 for hide \n Roll 3 for hide \n Roll 4 to hide \n Roll 5 for hide \n Roll 6 for nothing");
		if(gm.getRolled())
			RollButton.setVisible(false);
		if(gm.requestHide(gm.getPlayer1(), gm.getRolled(),txt)){
			gm.getPlayer1().getPchit().setHidden(true);
			gm.setRolled(false);
			RollButton.setVisible(true);
			gm.setHide(false);
	}
	
	}else if(cheatmode){	
		if(gm.getRolled() == false)			
			JOptionPane.showMessageDialog(null, "Please Roll a die \n Roll a 1 for hide \n Roll 2 for hide \n Roll 3 for hide \n Roll 4 to hide \n Roll 5 for hide \n Roll 6 for nothing");
		if(gm.getRolled())
			if(gm.requestHide(gm.getPlayer1(), gm.getRolled(),txt)){
				gm.setRolled(false);
				gm.setHide(false);

			}
	}
}


public static void searching(boolean cheatmode){// performs searching according to game mode.
	gm.setRolled(false);

	if(!gm.isCheatMode() && gm.isSearch()){
		RollButton.setVisible(true);
		if(gm.getRolled() == false)
			JOptionPane.showMessageDialog(null, "Please Roll a die \n Roll a 1 for choice \n Roll 2 for Passages and clues \n Roll 3 for passages \n Roll 4 to discover chits \n Roll 5 for nothing \n Roll 6 for nothing");		
				
		searchpanel = new JPanel(){								
			public void paintComponent(Graphics g) {
				Image img = Toolkit
						.getDefaultToolkit()
						.getImage(
								CombatGui.class
										.getResource("/others/background_1.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

			searchpanel.setName("Search Panel");												
			searchpanel.setLayout(null);
			gm.requestSearch(gm.getPlayer1(), tabbedPane, searchpanel);  		//do search
			tabbedPane.addTab("Search Panel", null, searchpanel, "DO YOUR Searchs");
		

		
		
		//gm.requestSearch(gm.getPlayer1(), tabbedPane, panel);
								
			
		
	}else if (gm.isCheatMode() && gm.isSearch()) {
		RollButton.setVisible(false);
		if(gm.getRolled() == false)
			JOptionPane.showMessageDialog(null, "Please Roll a die \n Roll a 1 for choice \n Roll 2 for Passages and clues \n Roll 3 for passages \n Roll 4 to discover chits \n Roll 5 for nothing \n Roll 6 for nothing");		

		searchpanel = new JPanel(){								
			public void paintComponent(Graphics g) {
				Image img = Toolkit
						.getDefaultToolkit()
						.getImage(
								CombatGui.class
										.getResource("/others/background_1.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

			searchpanel.setName("Search Panel");												
			searchpanel.setLayout(null);
			gm.requestSearch(gm.getPlayer1(), tabbedPane, searchpanel);  		//do search
			tabbedPane.addTab("Search Panel", null, searchpanel, "DO YOUR Searchs");
				
		
		//gm.requestSearch(gm.getPlayer1(), tabbedPane, panel);
			

	
	}	else{ JOptionPane.showMessageDialog(null, "You can only search during searching phase");

		
	}
}


public void initializeCombatGui() {

	}

public static void setBd(BoardTiles t){
	bd = t;
}

public static BoardTiles getbd(){
return bd;
		}

public static boolean getsubmit(){
return submitt;
		}

public static void setsubmit(boolean t){
submitt = t;
		}

public static void toggleIcons(JLabel lb){
	if(gm.isSelected()){
		if(gm.getPlayer1().getCharacter().getName().equals("Amazon"))
		lb.setIcon(new ImageIcon(CombatGui.class.getResource("/characterdetails/amazon.jpg")));
	else if(gm.getPlayer1().getCharacter().getName().equals("Black Knight"))
		lb.setIcon(new ImageIcon(CombatGui.class.getResource("/characterdetails/black_knight.jpg")));
	else if(gm.getPlayer1().getCharacter().getName().equals("Captain"))
		lb.setIcon(new ImageIcon(CombatGui.class.getResource("/characterdetails/captain.jpg")));
	else if(gm.getPlayer1().getCharacter().getName().equals("Dwarf"))
		lb.setIcon(new ImageIcon(CombatGui.class.getResource("/characterdetails/dwarf.jpg")));
	else if(gm.getPlayer1().getCharacter().getName().equals("Elf"))
		lb.setIcon(new ImageIcon(CombatGui.class.getResource("/characterdetails/elf.jpg")));
	else if(gm.getPlayer1().getCharacter().getName().equals("Swordsman"))
		lb.setIcon(new ImageIcon(CombatGui.class.getResource("/characterdetails/swordsman.jpg")));


}
	
}

public static boolean isBlocked() {
	return blocked;
}

public static void setBlocked(boolean block) {
	blocked = block;
}

public static boolean isSkippedturn() {
	return skippedturn;
}

public static void setSkippedturn(boolean skippedturn) {
	CombatGui.skippedturn = skippedturn;
}

/*
public static void checkturn(){
	if(gm.getTurn() == 4) {
		client.sendTCP(gm.getBD());
		client.sendTCP(gm.getPlayer1());
	}
		for(int i = 0; i < activity.length; i++)
			activity[i].setVisible(false);

}
*/
}
