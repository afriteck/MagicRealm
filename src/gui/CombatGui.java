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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class CombatGui extends JPanel {

	// public static BoardTiles bt = new BoardTiles();
	public static BoardTiles bt;

	static JTabbedPane tabbedPane = new JTabbedPane();
	static JFrame frame = new JFrame("TabbedPaneDemo");
	static GuiActivities gm;

	private JTextArea txt = new JTextArea("Welcome to Magic Realm! ");

	JComponent setup;
	JComponent panel2;
	final JButton RollButton = new JButton();
	final JButton setRoll = new JButton("Set Roll");
	int clicked;
	int lastRoll;
	int lastRoll2;
	static Model md;

	// JFrame frame = new JFrame("TabbedPaneDemo");

	public CombatGui() {
		super(new GridLayout(1, 1));

		ImageIcon icon = createImageIcon("images/middle.gif");

		setup = makesetupPanel("Panel #1");
		tabbedPane.addTab("Setup", icon, setup, "Select Game Mode");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

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

		final JButton btnNewButton = new JButton("New Game");
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

					panel2 = makeCharacterPanel("Panel #2");

					gm.cheatmodeButtons(panel2);

					tabbedPane.addTab("Characters", null, panel2,
							"Display characters");

					tabbedPane.remove(setup);

					txt.append("\n---------------------------------- You are now in Cheat mode....\n CLICK ON INDIVIDUAL DIE TO SET ROLL!!\n");

					// set up the game for cheat mode.....
					// setRoll.setVisible(true);
					// RollButton.setVisible(false);
					// die1.setVisible(true);
					// die2.setVisible(true);

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
				} else {

					gm.setCheatMode(false);

					panel2 = makeCharacterPanel("Panel #2");

					tabbedPane.addTab("Characters", null, panel2,
							"Display characters");

					tabbedPane.remove(setup);

					// randomMode = true;
					txt.append("\n---------------------------------- You are now in normal mode!!\n  CLICK ON ROLL BUTTON TO ROLL \n");
					gm.addWarningChits();

					bt.getTile("AWFUL VALLEY").getClearingByNum(5)
							.setDwelling(gm.getChapell());
					bt.getTile("BAD VALLEY").getClearingByNum(5)
							.setDwelling(gm.getGuardhousee());
					bt.getTile("CURST VALLEY").getClearingByNum(5)
							.setDwelling(gm.getHousee());
					bt.getTile("DARK VALLEY").getClearingByNum(5)
							.setDwelling(gm.getInnn());

					// set up the game for random mode.

					btnNewButton.setVisible(false); // disable the start new
													// game button until we
													// figure out a way to reset
													// the game.

					// RollButton.setVisible(true);

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

				// txt.append("\n----------------------------------\nPlease choose your characters \n");

				// currentPlayer = gm.getPlayer1();

			}
		});

		btnNewButton.setBounds(20, 47, 117, 29);
		panel.add(btnNewButton);
		// txt.setBorder(new EmptyBorder(0, 0, 0, 0));
		// txt.setForeground(Color.WHITE);
		// txt.setBackground(Color.BLAC

		return panel;
	}

	protected JComponent makeBoardPanel(String text) {

		JPanel panel = new JPanel(false);
		// bt = InitBoardTiles.initializeTiles();
		HexTiles ht = new HexTiles(gm.getBD());
		panel.add(ht, BorderLayout.CENTER);
		panel.add(ht.getControls(), BorderLayout.SOUTH);
		panel.setVisible(true);
		ht.addMouseListener(ht.switcher);
		frame.addComponentListener(ht.resizeMonitor);

		// JScrollPane scroll = new JScrollPane (tabbedPane,
		// JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// scroll.setSize(0, 0);
		// scroll.setLocation(1550, 1557);
		// frame.add(scroll);

		return panel;
	}

	protected JComponent makeActivityPanel(String text) {

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
		setBounds(0, 0, 200, 500);

		final ImageIcon[] img = new ImageIcon[8];

		final JButton die1;
		final JButton die2;

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
		DefaultCaret caret = (DefaultCaret) txt.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane scroll = new JScrollPane(txt,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setSize(300, 300);
		scroll.setLocation(1550, 227);
		panel.add(scroll);

		JButton player = new JButton("Player");
		player.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gm.placePlayer1(gm.getPlayer1());

			}
		});
		player.setBounds(400, 200, 100, 40);
		player.setVisible(false);
		panel.add(player);

		if (gm.isCheatMode()) {
			player.setVisible(true);
		}

		die1 = new JButton();
		die1.setBounds(140, 47, 68, 66); // bounds for button
		die1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		die1.setSelected(false);
		die1.setBorderPainted(false);
		die1.setContentAreaFilled(false);
		die1.setVisible(true);
		panel.add(die1);

		die2 = new JButton();
		die2.setBounds(210, 47, 68, 66); // bounds for button
		die2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		die2.setSelected(false);
		die2.setBorderPainted(false);
		die2.setContentAreaFilled(false);
		die2.setVisible(true);
		panel.add(die2);

		RollButton.setBounds(50, 47, 68, 66);
		RollButton.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		RollButton.setBorderPainted(false);
		RollButton.setContentAreaFilled(false);
		RollButton.setIcon(img[0]);
		RollButton.setVisible(false);
		panel.add(RollButton);

		setRoll.setBounds(300, 20, 120, 29); // bounds for cheat button
		setRoll.setVisible(false);
		panel.add(setRoll);

		die1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicked++;
				if (gm.isCheatMode()) {
					setRoll.setVisible(true);

					gm.toggleDie1(clicked, lastRoll, die1, img);
					die1.setSelected(true);
					// dieclicked[0] = true;
					txt.append("\ndie one was clicked\n");
					die1.setBounds(140, 47, 68, 70);

					// die1.setContentAreaFilled(true);
				}
			}
		});

		die2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clicked++;
				if (gm.isCheatMode()) {
					setRoll.setVisible(true);

					gm.toggleDie2(clicked, lastRoll2, die2, img);

					die2.setSelected(true);
					// die2.doClick();
					// dieclicked[1] = true;
					txt.append("\ndie 2 was clicked\n");
					die2.setBounds(210, 47, 68, 70); // bounds for button

				}
			}
		});

		RollButton.addActionListener(new ActionListener() { // Button Listener/*
					@Override
					public void actionPerformed(ActionEvent e) {

						Dice dice = new Dice();
						int lastRoll;
						int lastRoll2;

						gm.setRolled(true);
						die1.setVisible(true);
						die2.setVisible(true);
						RollButton.setVisible(false);

						lastRoll = (dice.roll());
						lastRoll2 = (dice.roll());

						txt.append("\n----------------------------------\nDie1 rolled a: "
								+ lastRoll);
						txt.append("\n----------------------------------\nDie2 rolled a: "
								+ lastRoll2);

						gm.getPlayer1().getCharacter()
								.setRoll(Math.max(lastRoll, lastRoll2));

						txt.append("\n----------------------------------\n"
								+ gm.getPlayer1().getName() + " rolled : "
								+ gm.getPlayer1().getCharacter().getRoll());

						die1.setIcon(img[lastRoll]);
						die2.setIcon(img[lastRoll2]);

						// rolled = true;

					}
				});

		setRoll.addActionListener(new ActionListener() { // Button Listener/*
			@Override
			public void actionPerformed(ActionEvent e) {

				// die1.setVisible(true);
				// die2.setVisible(true);

				// int lastRoll ;
				// int lastRoll2 ;

				txt.append("\n---------------------------------- die 1 rolled!!\n"
						+ lastRoll);
				txt.append("\n---------------------------------- die 2 rolled!!\n"
						+ lastRoll2);

				gm.getPlayer1().getCharacter()
						.setRoll(Math.max(lastRoll, lastRoll2));

			}
		});

		JButton move = new JButton("MOVE");
		move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gm.setMove(true);
				// System.out.println(gm.moved());
				gm.playGame(txt, panel);

				// if(gm.requestMove(gm.getPlayer1()));

			}
		});
		move.setBounds(50, 150, 89, 23);
		panel.add(move);
		move.setVisible(true);

		JButton hide = new JButton("HIDE");
		hide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RollButton.setVisible(true);

				gm.setHide(true);
				gm.playGame(txt, panel);

			}
		});
		hide.setBounds(50, 200, 89, 23);
		panel.add(hide);
		hide.setVisible(true);

		JButton trade = new JButton("TRADE");
		trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setTrade(true);
				gm.playGame(txt, panel);

			}
		});
		trade.setBounds(50, 250, 89, 23);
		panel.add(trade);
		trade.setVisible(true);

		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setSearch(true);
				gm.playGame(txt, panel);

			}
		});
		search.setBounds(50, 300, 89, 23);
		panel.add(search);
		search.setVisible(true);

		JButton rest = new JButton("REST");
		rest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setRest(true);
				gm.playGame(txt, panel);

			}
		});
		rest.setBounds(50, 350, 89, 23);
		panel.add(rest);
		rest.setVisible(true);

		JButton alert = new JButton("ALERT");
		alert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setAlert(true);
				gm.playGame(txt, panel);

			}
		});
		alert.setBounds(50, 400, 89, 23);
		panel.add(alert);
		alert.setVisible(true);

		JButton hire = new JButton("HIRE");
		hire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setHire(true);
				gm.playGame(txt, panel);

			}
		});
		hire.setBounds(50, 450, 89, 23);
		panel.add(hire);
		hire.setVisible(true);

		JButton follow = new JButton("FOLLOW");
		follow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setFollow(true);
				gm.playGame(txt, panel);

			}
		});
		follow.setBounds(50, 500, 89, 23);
		panel.add(follow);
		follow.setVisible(true);

		JButton enchant = new JButton("ENCHANT");
		enchant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.setEnchant(true);
				gm.playGame(txt, panel);

			}
		});
		enchant.setBounds(50, 550, 89, 23);
		panel.add(enchant);
		enchant.setVisible(true);

		if (gm.isCheatMode()) {
			// setRoll.setVisible(true);

			die1.setVisible(true);
			die2.setVisible(true);

		}
		if (!gm.isCheatMode())
			RollButton.setVisible(true);

		return panel;
	}

	protected JComponent makeCharacterPanel(String text) {

		JPanel panel = new JPanel(false) {
			;

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

		JLabel amazon = new JLabel("");
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

		JLabel dwarf = new JLabel("");

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

		JLabel elf = new JLabel("");

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

		JLabel captain = new JLabel("");
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

		JLabel blackKnight = new JLabel("");
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

		JLabel swordsman = new JLabel("");
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

	public void getNextPhase() {

		if (gm.isSelected()) {

			tabbedPane.remove(panel2);

			JComponent panel1 = makeBoardPanel("Panel #1");
			tabbedPane
					.addTab("Game Board", null, panel1, "Displays Game Board");
			// tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

			JComponent panel2 = makeActivityPanel("Panel #2");
			tabbedPane.addTab("Activity Panel", null, panel2,
					"perform daily activities");
			// tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
			tabbedPane.setSelectedIndex(1);

		}

	}

	public void checkSelected() {
		if (gm.isSelected())
			JOptionPane.showMessageDialog(null,
					"PLEASE CHOOSE YOUR 4 ACTIVITIES FOR THE DAY.");
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
				// md.playGame();
				bt = new BoardTiles();
				bt = InitBoardTiles.initializeTiles();
				gm = new GuiActivities(bt);
				// HexTiles.initGameBoard(bt);
				gm.promptPlayerName();

				createAndShowGUI();
			}
		});
	}

	public void initializeCombatGui() {

	}

}
