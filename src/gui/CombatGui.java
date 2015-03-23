package gui;

import gameBoard.BoardTiles;
import gameBoard.InitBoardTiles;
import gameLogic.GuiActivities;

import java.awt.BorderLayout;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CombatGui extends JPanel {

	public static BoardTiles bt = new BoardTiles();
	
	static JTabbedPane tabbedPane = new JTabbedPane();
	static JFrame frame = new JFrame("TabbedPaneDemo");
	


	//JFrame frame = new JFrame("TabbedPaneDemo");

	public CombatGui() {
		super(new GridLayout(1, 1));
		
		

		ImageIcon icon = createImageIcon("images/middle.gif");

		JComponent panel1 = makeBoardPanel("Panel #1");
		tabbedPane.addTab("Game Board", icon, panel1, "Displays Game Board");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = makeActivityPanel("Panel #2");
		tabbedPane.addTab("Activity Panel", icon, panel2,
				"perform daily activities");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = makeCharacterPanel("Panel #3");
		tabbedPane.addTab("Characters", icon, panel3, "Display characters");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Natives", icon, panel4, "Displays hired natives");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

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

	protected JComponent makeBoardPanel(String text) {

		
		JPanel panel = new JPanel(false);
		bt = InitBoardTiles.initializeTiles();
		HexTiles ht = new HexTiles(bt);
		panel.add(ht, BorderLayout.CENTER);
		panel.add(ht.getControls(), BorderLayout.SOUTH);
		panel.setVisible(true);
		ht.addMouseListener(ht.switcher);
		frame.addComponentListener(ht.resizeMonitor);

		return panel;
	}

	protected JComponent makeActivityPanel(String text) {

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
		setBounds(0, 0, 200, 500);

		JButton move = new JButton("MOVE");
		move.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		move.setBounds(50, 50, 89, 23);
		panel.add(move);
		move.setVisible(true);

		JButton hide = new JButton("HIDE");
		hide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		hide.setBounds(50, 100, 89, 23);
		panel.add(hide);
		hide.setVisible(true);

		JButton trade = new JButton("TRADE");
		trade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		trade.setBounds(50, 150, 89, 23);
		panel.add(trade);
		trade.setVisible(true);

		JButton search = new JButton("SEARCH");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		search.setBounds(50, 200, 89, 23);
		panel.add(search);
		search.setVisible(true);

		JButton rest = new JButton("REST");
		rest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		rest.setBounds(50, 250, 89, 23);
		panel.add(rest);
		rest.setVisible(true);

		JButton alert = new JButton("ALERT");
		alert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		alert.setBounds(50, 300, 89, 23);
		panel.add(alert);
		alert.setVisible(true);

		JButton hire = new JButton("HIRE");
		hire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		hire.setBounds(50, 350, 89, 23);
		panel.add(hire);
		hire.setVisible(true);

		JButton follow = new JButton("FOLLOW");
		follow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		follow.setBounds(50, 400, 89, 23);
		panel.add(follow);
		follow.setVisible(true);

		JButton enchant = new JButton("ENCHANT");
		enchant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		enchant.setBounds(50, 450, 89, 23);
		panel.add(enchant);
		enchant.setVisible(true);

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

		JLabel amazon = new JLabel("");
		amazon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

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

			}
		});
		swordsman.setIcon(new ImageIcon(CombatGui.class
				.getResource("/characters/swordsman.png")));
		swordsman.setBounds(1050, 47, 100, 100);
		swordsman.setName("swordsman");
		swordsman.setVisible(true);
		panel.add(swordsman);

		final JLabel AmazonIcon = new JLabel("");
		AmazonIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

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

		return panel;
	}

	
	public static void popup(String name){
		

    	JPanel popup = new JPanel();
    	JLabel tileLabel = new JLabel();
    	
    	tileLabel.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent arg0) {
    		

    		}
    	});
    	tileLabel.setIcon(new ImageIcon(HexCell.class.getResource("/" + bt.getTile(name).getFilePath())));
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
    	//frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
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
		frame.resize(new Dimension(1920,1040));

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

				createAndShowGUI();
			}
		});
	}

	public void initializeCombatGui() {

	}

}
