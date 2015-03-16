package gui;




import gameBoard.BoardTiles;
import gameBoard.InitBoardTiles;
import gameLogic.GuiActivities;
import gameLogic.Iteration1Board;
import gameLogic.Locate;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import models.Amazon;
import models.BlackKnight;
import models.Captain;
import models.CharacterContainer;
import models.Dwarf;
import models.Elf;
import models.Player;
import models.PlayerChit;
import models.Swordsman;
import models.Things;
import natives.Bashkars;
import natives.Company;
import natives.Guard;
import natives.Lancers;
import natives.NativeGroup;
import natives.Order;
import natives.Patrol;
import natives.Rogues;
import natives.Soldiers;
import natives.Woodfolk;

public class Gui extends JFrame implements MouseListener {

	
	private JPanel contentPane;
	private JTextArea txt = new JTextArea ("Welcome to Magic Realm! ");
	private JLabel[] Die1Label, Die2Label;
	
	private JButton rollButton, selectButton, sbackButton, backButton,move,hide,search,trade,rest,alert,hire,follow,enchant;
	private JButton p1button, p2button;         // player turn indicators
    private int turn = 0;       // for the player character selection phase
    private int activityCounter = 4;       // for the player character selection phase
    int globalrole;
    private JButton peer = new JButton("PEER");
    private JButton loot = new JButton("LOOT");
    private JButton locate = new JButton("LOCATE");
    private JButton[] tradeItems;
    private JButton[] searchItems;
    
    PlayerChit p1chit = new PlayerChit();
    PlayerChit p2chit = new PlayerChit();

    
	 LinkedList<JButton> searchButtons;
	 
    
    static GuiActivities gm;
    public static BoardTiles boardt;

    
	 private int lastRoll ;       // the last roll
	 private int lastRoll2 ;
	 private boolean rolled = false;
	 private boolean[] dieclicked = new boolean [2] ;
	 private boolean cheatMode = false;
	 private boolean randomMode = false;
	 private boolean selected = false;
	 private boolean characterSelectionPhase = false;
	 private boolean donePlayerRound = false;
	 private boolean startGame = false;
	 
	 private boolean hideAct,moveAct,searchAct,tradeAct, restAct,doneMove, birdsong;
	 
	 private int clicked = 0;
	 int player1Roll = 0;
	 
	 LinkedList<String>  p1choiceOrder = new LinkedList<String>();
	 LinkedList<String>  p2choiceOrder = new LinkedList<String>();

	 String playerOrder;
	
	 LinkedList<NativeGroup> ng;
	 
	 Order order;
	 Soldiers soldiers ;
	 Guard guard;
	 Rogues rogues;
	 Bashkars bashkars;
	 Company company;
	 Lancers lancers;
	 Patrol patrol;
	 Woodfolk woodfolk;
	
	 
	 JLabel grouplabel;
	 
	
	
	 
	 private CharacterContainer characters = new CharacterContainer();  // bag of things

	 
	 private Player currentPlayer = gm.getPlayer1();    // the turn of thGDGFGFe current player.
	 private Things selectedCharacter = null;     //when the player clicks a Character off their rack
	 
	 private LinkedList<Things> p1characters = new LinkedList<Things>(), p2characters = new LinkedList<Things>(),
	            p3characters = new LinkedList<Things>(), p4characters = new LinkedList<Things>();
	 
	 Things p1character;
	 Things p2character;
	 
	 
	//Player player1 = gm.getPlayer1();
	//Player player2  = gm.getPlayer2();
	 
	 
	 JButton die1 ;
	 JButton die2 ;

	 /*Add dice that roll to the game board */

	ImageIcon[] img = new ImageIcon[8]; 
	 
	 



	 

	 private JLabel amazon, blackKnight, captain, dwarf, elf, swordsman, AmazonIcon, CaptainIcon, BlackKnightIcon, SwordsManIcon, DwarfIcon, ElfIcon;
	 
	// private JLabel[] characterLabels;
	 
	 final LinkedList<JLabel> characterLabels = new LinkedList<JLabel>();
	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boardt = new BoardTiles(); 
					boardt = InitBoardTiles.initializeTiles();
					gm = new GuiActivities(boardt);
					Gui window = new Gui();
					HexTiles.initGameBoard(boardt);
					
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		//initialize();
		gm.promptPlayerName(txt);
		//player1.setName(player1.getName());
		//player2.setName(player2.getName());


		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/others/rs_logo.jpg")));
        setVisible(true);
        setTitle(" MAGIC REALM ");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1920, 1080);
        contentPane = new JPanel(){ 
         
         /**
             * 
             */
            private static final long serialVersionUID = 1L;
 
	
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                           Gui.class.getResource("/others/background_1.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
       };     
contentPane.setBackground(new Color(238, 238, 238));


contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);



ng = new LinkedList<NativeGroup>();
order = new Order();
soldiers = new Soldiers();
guard = new Guard();
rogues = new Rogues();
bashkars = new Bashkars();
company = new Company();
lancers = new Lancers();
patrol = new Patrol() ;
woodfolk = new Woodfolk();



grouplabel = new JLabel();



ng.add(order);
ng.add(soldiers);
ng.add(guard);
ng.add(rogues);
ng.add(bashkars);
ng.add(company);
ng.add(lancers);
ng.add(patrol);
ng.add(woodfolk);







img[0] = new ImageIcon(Gui.class.getResource("/dice/roll.png")); 
img[1] = new ImageIcon(Gui.class.getResource("/dice/1.png")); 
img[2] = new ImageIcon(Gui.class.getResource("/dice/2.png")); 
img[3] = new ImageIcon(Gui.class.getResource("/dice/3.png")); 
img[4] = new ImageIcon(Gui.class.getResource("/dice/4.png")); 
img[5] = new ImageIcon(Gui.class.getResource("/dice/5.png")); 
img[6] = new ImageIcon(Gui.class.getResource("/dice/6.png"));



final JButton RollButton = new JButton();

final JButton setRoll = new JButton("Set Roll");
selectButton = new JButton();
      

p1button = new JButton("P1");
p1button.setBounds(719, 28, 48, 48);
p1button.setIcon(new ImageIcon(Gui.class.getResource("/others/p1.png")));
p1button.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
p1button.setSelected(true);
p1button.setVisible(false);
contentPane.add(p1button);
 
p2button = new JButton("P2");
p2button.setBounds(768, 28, 48, 48);
p2button.setIcon(new ImageIcon(Gui.class.getResource("/others/p2.png")));
p2button.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p2s.png")));
p2button.setVisible(false);
contentPane.add(p2button);




setRoll.setBounds(300, 20, 120, 29);                               // bounds for cheat button 
setRoll.setVisible(false);
getContentPane().add(setRoll); 



RollButton.setBounds(50, 47, 68, 66); 
RollButton.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
RollButton.setBorderPainted(false); 
RollButton.setContentAreaFilled(false); 
RollButton.setIcon(img[0]);
RollButton.setVisible(false);
getContentPane().add(RollButton);



 move = new JButton("MOVE");
move.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		//boardt.getTile(currentPlayer.getTile()).getClearingByNum(currentPlayer.getClearing()).removePersonHere(currentPlayer.getPchit().getName());

		if(gm.requestMove(currentPlayer)){
			turn++;	

		if(turn >= 5){
		getNextPlayer(currentPlayer);
		turn = 1;
	}
		}
		

	}
});
buttonGroup.add(move);
move.setBounds(1460, 227, 89, 23);
contentPane.add(move);
move.setVisible(false);

 hide = new JButton("HIDE");
hide.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(gm.getRolled() == false)
		JOptionPane.showMessageDialog(null, "Please Roll a die \n Roll a 1 for hide \n Roll 2 for hide \n Roll 3 for hide \n Roll 4 to hide \n Roll 5 for hide \n Roll 6 for nothing");
		if(gm.getRolled())
		if(gm.requestHide(currentPlayer, gm.getRolled(),txt)){
			turn++;
			if(turn >= 5){
				getNextPlayer(currentPlayer);
				turn = 1;
			}
		}
	
	}
});
buttonGroup.add(hide);
hide.setBounds(1460, 261, 89, 23);
contentPane.add(hide);
hide.setVisible(false);

 trade = new JButton("TRADE");
trade.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(turn >= 5){
			getNextPlayer(currentPlayer);
			turn = 1;
		}
		
		gm.intializeTrade(getContentPane());
			turn++;
	}
});
buttonGroup.add(trade);
trade.setBounds(1460, 295, 89, 23);
contentPane.add(trade);
trade.setVisible(false);


 search = new JButton("SEARCH");
buttonGroup.add(search);
search.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
			if(turn >= 5){
			getNextPlayer(currentPlayer);
			turn = 1;
		}
		
		searchItems = gm.requestSearch();
		for(int i = 0; i < searchItems.length; i++)
			getContentPane().add(searchItems[i]);
			turn++;
			sbackButton.setVisible(true);
		
			hide.setVisible(false);
			move.setVisible(false);
			search.setVisible(false);
			trade.setVisible(false);
			rest.setVisible(false);
			alert.setVisible(false);
			hire.setVisible(false);
			enchant.setVisible(false);
			follow.setVisible(false);


		
	}
});
search.setBounds(1460, 329, 89, 23);
contentPane.add(search);
search.setVisible(false);

 rest = new JButton("REST");
rest.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		if(gm.requestRest(currentPlayer, txt)){
			turn++;
			if(turn >= 5){
				getNextPlayer(currentPlayer);
				turn = 1;
			}
		}
		
	}
});
buttonGroup.add(rest);
rest.setBounds(1460, 363, 89, 23);
contentPane.add(rest);
rest.setVisible(false);




alert = new JButton("ALERT");
alert.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		if(gm.requestAlert(currentPlayer, txt)){
			turn++;
			if(turn >= 5){
				getNextPlayer(currentPlayer);
				turn = 1;
			}
		}
		
		
	}
});
buttonGroup.add(alert);
alert.setBounds(1460, 394, 89, 23);
contentPane.add(alert);
alert.setVisible(false);



hire = new JButton("HIRE");
hire.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
		if(gm.requestHire(currentPlayer, txt)){
			turn++;
			for(int i = 0; i < ng.size(); i++)
			gm.showNativeGroup(ng.get(i), currentPlayer, txt, getContentPane());
			if(turn >= 5){
				getNextPlayer(currentPlayer);
				turn = 1;
			}
		}
		
	
	
	}
});
buttonGroup.add(hire);
hire.setBounds(1460, 428, 89, 23);
contentPane.add(hire);
hire.setVisible(false);




follow = new JButton("FOLLOW");
follow.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	
	}
});
buttonGroup.add(follow);
follow.setBounds(1460, 462, 89, 23);
contentPane.add(follow);
follow.setVisible(false);




enchant = new JButton("ENCHANT");
enchant.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {

	}
});
buttonGroup.add(enchant);
enchant.setBounds(1460, 496, 89, 23);
contentPane.add(enchant);
enchant.setVisible(false);



die1 = new JButton();
die1.setBounds(140, 47, 68, 66);                               // bounds for button 
die1.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));  
die1.setSelected(false);
die1.setBorderPainted(false); 
die1.setContentAreaFilled(false); 
die1.setVisible(false);
getContentPane().add(die1);


die2 = new JButton();
die2.setBounds(210, 47, 68, 66);                               // bounds for button 
die2.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));  
die2.setSelected(false);
die2.setBorderPainted(false);  
die2.setContentAreaFilled(false);  
die2.setVisible(false);
getContentPane().add(die2); 





RollButton.addActionListener(new ActionListener() {                 //Button Listener/* 
    @Override
public void actionPerformed(ActionEvent e) { 
    	gm.setRolled(true);
    	die1.setVisible(true);
        die2.setVisible(true);
    	
    	
    setLastRoll(roll());  
    setLastRoll2(roll()); 
    
//  setPlayer1Roll (currentPlayer.getPlayerDie().getDieRoll(currentPlayer.getDieBool(), getLastRoll(), getLastRoll2()));
    

    
    txt.append("\n----------------------------------\nDie1 rolled a: " + lastRoll); 
    txt.append("\n----------------------------------\nDie2 rolled a: " + lastRoll2); 
   
    if(currentPlayer.getCharacter() != null){
        currentPlayer.getCharacter().setRoll(Math.max(lastRoll, lastRoll2));
    
        txt.append("\n----------------------------------\n" + currentPlayer.getName() +" rolled : " + currentPlayer.getCharacter().getRoll()); 
    }
    die1.setIcon(img[lastRoll]); 
    die2.setIcon(img[lastRoll2]); 
    
    rolled = true;    

    globalrole = getPlayer1Roll();
    //return player1Roll;
    
    }  
    }); 

 

setRoll.addActionListener(new ActionListener() {                 //Button Listener/* 
    @Override
public void actionPerformed(ActionEvent e) { 
  
        txt.append("\n---------------------------------- die 1 rolled!!\n" + lastRoll);
        txt.append("\n---------------------------------- die 2 rolled!!\n" + lastRoll2);
        
        if(currentPlayer.getCharacter() != null)
            currentPlayer.getCharacter().setRoll(Math.max(lastRoll, lastRoll2));

    }  
    }); 


final JButton btnNewButton = new JButton("New Game");
btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        // after start button button is clicked

    	characters.fillContainer();
       
    	int dialogButton = JOptionPane.YES_NO_OPTION;
    	int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to play in cheat mode?","Alert",dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION){  
            cheatMode = true;
            txt.append("\n---------------------------------- You are now in Cheat mode....\n CLICK ON INDIVIDUAL DIE TO SET ROLL!!\n");
        
      //  set up the game for cheat mode.....
            //setRoll.setVisible(true);
            RollButton.setVisible(false);
			die1.setVisible(true);
			die2.setVisible(true);

            die1.setIcon(img[1]);
			die2.setIcon(img[2]);

			p1button.setVisible(true);
			p2button.setVisible(true);

         amazon.setVisible(true);
         captain.setVisible(true);
         blackKnight.setVisible(true);
         elf.setVisible(true);
         dwarf.setVisible(true);
         swordsman.setVisible(true);
         btnNewButton.setVisible(false);
        }
        else{
        	
        	cheatMode = false;
        	randomMode = true;
            txt.append("\n---------------------------------- You are now in normal mode!!\n  CLICK ON ROLL BUTTON TO ROLL \n");
           gm.addWarningChits();
            //set up the game for random mode.
            
            btnNewButton.setVisible(false);     //disable the start new game button until we figure out a way to reset the game.
            RollButton.setVisible(true);
            p1button.setVisible(true);
			p2button.setVisible(true);
            amazon.setVisible(true);
            captain.setVisible(true);
            blackKnight.setVisible(true);
            elf.setVisible(true);
            dwarf.setVisible(true);
            swordsman.setVisible(true);
            btnNewButton.setVisible(false);

        }

        if(cheatMode){
        	gm.cheatmodeButtons(getContentPane());
        }

        txt.append("\n----------------------------------\nPlease choose your characters \n"); 
        
       //currentPlayer = gm.getPlayer1();
      
          
    }
});

 

btnNewButton.setBounds(20, 47, 117, 29);
contentPane.add(btnNewButton);
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
contentPane.add(scroll);


die1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    clicked++;
    if(cheatMode){
        setRoll.setVisible(true);

    		toggleDie1();
      die1.setSelected(true); 
   	  dieclicked[0] = true;
      txt.append("\ndie one was clicked\n");
      die1.setBounds(140, 47, 68, 70);  


    	//die1.setContentAreaFilled(true);
    	}
    }
}); 


die2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    	clicked ++;
    	if(cheatMode){
    	    setRoll.setVisible(true);

    		toggleDie2();
    		
    	die2.setSelected(true); 
        //die2.doClick();
     	  dieclicked[1] = true;
        txt.append("\ndie 2 was clicked\n");
        die2.setBounds(210, 47, 68, 70);                               // bounds for button 
        
        
    	}
    }
}); 
	

amazon = new JLabel("");
amazon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
	displayCharacterDetail(arg0, AmazonIcon) ;

	}
});
amazon.setIcon(new ImageIcon(Gui.class.getResource("/characters/amazon.png")));
amazon.setBounds(300, 47, 100, 100);
amazon.setName("amazon");
amazon.setVisible(false);
contentPane.add(amazon);

 
dwarf = new JLabel("");

dwarf.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
	
		displayCharacterDetail(arg0, DwarfIcon) ;

	}
});
dwarf.setIcon(new ImageIcon(Gui.class.getResource("/characters/dwarf.png")));
dwarf.setBounds(450, 47, 100, 100);
dwarf.setName("dwarf");
dwarf.setVisible(false);
contentPane.add(dwarf);
 
elf = new JLabel("");

elf.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		displayCharacterDetail(arg0, ElfIcon) ;

	}
});

elf.setIcon(new ImageIcon(Gui.class.getResource("/characters/elf.png")));
elf.setBounds(600, 47, 100, 100);
elf.setName("elf");
elf.setVisible(false);
contentPane.add(elf);
 
captain = new JLabel("");
captain.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		displayCharacterDetail(arg0, CaptainIcon) ;

	}
});
captain.setIcon(new ImageIcon(Gui.class.getResource("/characters/captain.png")));
captain.setBounds(750, 47, 100, 100);
captain.setName("captain");
captain.setVisible(false);
contentPane.add(captain);
 
blackKnight = new JLabel("");
blackKnight.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		displayCharacterDetail(arg0, BlackKnightIcon) ;

	}
});

blackKnight.setIcon(new ImageIcon(Gui.class.getResource("/characters/black_knight.png")));
blackKnight.setBounds(900, 47, 100, 100);
blackKnight.setName("blackKnight");
blackKnight.setVisible(false);
contentPane.add(blackKnight);

swordsman = new JLabel("");
swordsman.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		displayCharacterDetail(arg0, SwordsManIcon) ;

	}
});
swordsman.setIcon(new ImageIcon(Gui.class.getResource("/characters/swordsman.png")));
swordsman.setBounds(1050, 47, 100, 100);
swordsman.setName("swordsman");
swordsman.setVisible(false);
contentPane.add(swordsman);




characterLabels.add(amazon);
characterLabels.add(blackKnight);
characterLabels.add(swordsman);
characterLabels.add(dwarf);
characterLabels.add(elf);       
characterLabels.add(captain);

 
for (int i=0; i<6; i++) characterLabels.get(i).addMouseListener(this);	


AmazonIcon = new JLabel("");
AmazonIcon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	
		checkSelected(currentPlayer,e);
	}
});

AmazonIcon.setIcon(new ImageIcon(Gui.class.getResource("/characterdetails/amazon.jpg")));
AmazonIcon.setBounds(300, 150, 900, 700);
AmazonIcon.setName("Amazon");
AmazonIcon.setVisible(false);
contentPane.add(AmazonIcon);

CaptainIcon = new JLabel("");
CaptainIcon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	
		checkSelected(currentPlayer, e);


	}
});

CaptainIcon.setIcon(new ImageIcon(Gui.class.getResource("/characterdetails/captain.jpg")));
CaptainIcon.setBounds(300, 150, 900, 700);
CaptainIcon.setName("Captain");
CaptainIcon.setVisible(false);
contentPane.add(CaptainIcon);

DwarfIcon = new JLabel("");

DwarfIcon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	
		checkSelected(currentPlayer, e);


	}
});
DwarfIcon.setIcon(new ImageIcon(Gui.class.getResource("/characterdetails/dwarf.jpg")));
DwarfIcon.setBounds(300, 150, 900, 700);
DwarfIcon.setName("Dwarf");
DwarfIcon.setVisible(false);
contentPane.add(DwarfIcon);

ElfIcon = new JLabel("");
ElfIcon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	
		checkSelected(currentPlayer,e);
	}
});
ElfIcon.setIcon(new ImageIcon(Gui.class.getResource("/characterdetails/elf.jpg")));
ElfIcon.setBounds(300, 150, 900, 700);
ElfIcon.setName("Elf");
ElfIcon.setVisible(false);
contentPane.add(ElfIcon);

SwordsManIcon = new JLabel("");

SwordsManIcon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	
		checkSelected(currentPlayer,e);


	}
});
SwordsManIcon.setIcon(new ImageIcon(Gui.class.getResource("/characterdetails/swordsman.jpg")));
SwordsManIcon.setBounds(300, 150, 900, 700);
SwordsManIcon.setName("Swordsman");
SwordsManIcon.setVisible(false);
contentPane.add(SwordsManIcon);

BlackKnightIcon = new JLabel("");
BlackKnightIcon.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
	
		checkSelected(currentPlayer,e);


	}
});
BlackKnightIcon.setIcon(new ImageIcon(Gui.class.getResource("/characterdetails/black_knight.jpg")));
BlackKnightIcon.setBounds(300, 150, 900, 700);
BlackKnightIcon.setName("BlackKnight");
BlackKnightIcon.setVisible(false);
contentPane.add(BlackKnightIcon);


backButton = new JButton("Back");
backButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        AmazonIcon.setVisible(false);
        CaptainIcon.setVisible(false);
        BlackKnightIcon.setVisible(false);
        ElfIcon.setVisible(false);
        DwarfIcon.setVisible(false);
        SwordsManIcon.setVisible(false);
        backButton.setVisible(false);
        selectButton.setVisible(false);
        
            
        for(int i = 0; i < searchItems.length; i++)
        	searchItems[i].setVisible(false);



   
    }
    });
backButton.setBounds(800, 907, 100, 23);
backButton.setIcon (new ImageIcon(Gui.class.getResource("/actions/backarrow.gif")));
backButton.setVisible(false);
contentPane.add(backButton);



sbackButton = new JButton("Back");
sbackButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
    	
    	hide.setVisible(true);
		move.setVisible(true);
		search.setVisible(true);
		trade.setVisible(true);
		rest.setVisible(true);
		alert.setVisible(true);
		hire.setVisible(true);
		enchant.setVisible(true);
		follow.setVisible(true);
		
    	
    	
		searchItems[0].setVisible(false);
		searchItems[1].setVisible(false);
		searchItems[2].setVisible(false);

		sbackButton.setVisible(false);


   
    }
    });
sbackButton.setBounds(800, 907, 100, 23);
sbackButton.setIcon (new ImageIcon(Gui.class.getResource("/actions/backarrow.gif")));
sbackButton.setVisible(false);
contentPane.add(sbackButton);
	
	
	
	
	
	
	
	
	}

	
protected int getActivityCounter() {
	//activityCounter++;
		return activityCounter--;
	}

public static int roll(){                                       // Dice Function - returns # 
        
        return (int)(6.0 * Math.random()) + 1;   
}

@Override
public void mouseClicked(MouseEvent arg0) {
	
	   
	// TODO Auto-generated method stub

	//if (characterSelectionPhase)
         //  selectPlayerCharacter(currentPlayer, turn, arg0);
            
              
      // if (arg0.getSource() == p1button){
          // currentPlayer = player1;
          // displayRackFor(player1);
          // }
       //if (arg0.getSource() == p2button){
           //currentPlayer = player2;
           //displayRackFor(player2);
          // }	
	
}

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void playerCharacterSelectionPrompt(Player p, int n){
    txt.append("\n----------------------------------\n" + currentPlayer.getName() + ", Choose your ");
    if (n == 1) txt.append("First Character.\n\n");
   // if (n == 2) txt.append("Second Character.\n\n");
   // if (n == 3) txt.append("Third Character.\n\n");
}


/*
public void selectPlayerCharacter(Player p, int t, MouseEvent e){
   
    //Things temp = getTerrainFromBoard(e, JLabelList);

	
	   if (p == player1) { 
            if (t == 1) {
            	 p1character = new Things();
            	p1character.setName(((Component) e.getSource()).getName());
            p1characters.add(p1character);

            }
          
        }
        
          if (p == player2){
            if (t == 1) {
            	 p2character = new Things();
            	p2character.setName(((Component) e.getSource()).getName());
            p1characters.add(p2character);
            donePlayerRound = true;          
            }
            
        }
          txt.append("\n");
          characterSelectionPhase = false;  
          getNextPlayer(currentPlayer);
          if (!donePlayerRound)
          characterSelectionPhase = true;
          else { 
              characterSelectionPhase = false;
              txt.append("\n---------------------------------\nPlayer characters have been chosen.\n");
              donePlayerRound = false;
              startGame = true;
          
          }
	}
*/





public void displayCharacterDetail(MouseEvent e, JLabel j){
	
	if(!selected){
		 txt.append(((Component) e.getSource()).getName()+ "\n CLICK ON THE IMAGE TO SELECT THIS CHARACTER \n");
	       
	        j.setVisible(true);
	        backButton.setVisible(true);
       }
	 else{
       	j.setVisible(true);
	        backButton.setVisible(true);
	                   
	 }

}


public Player getNextPlayer(Player p){
    
    if (p == gm.getPlayer1()) { 
    	currentPlayer = gm.getPlayer2();
    	gm.getPlayer2().setTile(gm.getPlayer2().getTile());
    	p1button.setSelected(false); 
                        p2button.setSelected(true); 
                        }
    if (p == gm.getPlayer2()) {
    	currentPlayer = gm.getPlayer1();
    	gm.getPlayer1().setTile(gm.getPlayer1().getTile());

    	p2button.setSelected(false); 
    	p1button.setSelected(true); 
    	turn++;
                       }   
      
return p;
}


public void getRecruitThing(MouseEvent e){
    
    for (int i=0; i<characters.getCharacterContainerSize(); i++){
        if (((Component) e.getSource()).getName() == characters.getCharacterContainer().get(i).getName()){
            selectedCharacter = characters.getCharacterContainer().get(i);
        }
    }
}

public void recruitCharacter(Player p, MouseEvent e){
    
    getRecruitThing(e); 

    checkCharacter(p, e);
     getNextPlayer(currentPlayer);
     


}
 
public void showMessage(Things ths, Player p){
	 txt.append(p.getName() + " Chose " + ths.getName() + "\n" + ths.getName() + " has the following weapons \n" + ths.getWeapons().getName() + "\n" + ths.getWeapons().getName() + " has a length of " + ths.getWeapons().getLength()+"\n the weapon has a speed of " + ths.getWeapons().getSpeed() + "\n");		    
	    txt.append(ths.getName() + " has the following armors \n");
		for(int j = 0 ; j < ths.getArsenalSize(); j++)
		    txt.append(ths.getCharacterArmory().get(j).getName() + "\n");
}


public void checkCharacter(Player p, MouseEvent e){   //check the character clicked and make a new instance of that character
	
	String name = ((Component) e.getSource()).getName();
	
	if(p == gm.getPlayer1()){
	    selected = false;		//we know the players are not done selection
		if(name == "Amazon"){
	      gm.getPlayer1().setCharacter(new Amazon());
	   	 txt.append(gm.getPlayer1().getName() + " Chose " + gm.getPlayer1().getCharacter().getName() + "\n"  + gm.getPlayer1().getCharacter().getName() + " currently visibile? " + gm.getPlayer1().getCharacter().getVisibility() + "\n");		    

	       // showMessage(p1character, player1);

		}
		
		else if(name == "Captain"){	        
	        gm.getPlayer1().setCharacter(new Captain());
		     // player1.setCharacter(new Captain());
		   	 txt.append(gm.getPlayer1().getName() + " Chose " + gm.getPlayer1().getCharacter().getName() + "\n"  + gm.getPlayer1().getCharacter().getName() + " currently visibile? " + gm.getPlayer1().getCharacter().getVisibility() + "\n");		    
		}
		
		else if(name == "Dwarf"){
	        gm.getPlayer1().setCharacter(new Dwarf());
		     // player1.setCharacter(new Dwarf());

		   	 txt.append(gm.getPlayer1().getName() + " Chose " + gm.getPlayer1().getCharacter().getName() + "\n"  + gm.getPlayer1().getCharacter().getName() + " currently visibile? " + gm.getPlayer1().getCharacter().getVisibility() + "\n");		    
		}
	
		else if(name == "Elf"){
	        gm.getPlayer1().setCharacter(new Elf());
		     // player1.setCharacter(new Elf());

		   	 txt.append(gm.getPlayer1().getName() + " Chose " + gm.getPlayer1().getCharacter().getName() + "\n"  + gm.getPlayer1().getCharacter().getName() + " currently visibile? " + gm.getPlayer1().getCharacter().getVisibility() + "\n");		    
	       
	        //showMessage(p1character, player1);

		}
		
		else if(name == "BlackKnight"){
	        gm.getPlayer1().setCharacter(new BlackKnight());
		     // player1.setCharacter(new BlackKnight());

		   	 txt.append(gm.getPlayer1().getName() + " Chose " + gm.getPlayer1().getCharacter().getName() + "\n"  + gm.getPlayer1().getCharacter().getName() + " currently visibile? " + gm.getPlayer1().getCharacter().getVisibility() + "\n");		    
	       
	        //showMessage(p1character, player1);
		}
		else if(name == "Swordsman"){
	        gm.getPlayer1().setCharacter(new Swordsman());
		     // player1.setCharacter(new Swordsman());

		   	 txt.append(gm.getPlayer1().getName() + " Chose " + gm.getPlayer1().getCharacter().getName() + "\n"  + gm.getPlayer1().getCharacter().getName() + " currently visibile? " + gm.getPlayer1().getCharacter().getVisibility() + "\n");		    
	        
	        //showMessage(p1character, player1);
		}
		gm.getPlayer1().getCharacter().setTileName("BAD VALLEY");
		gm.getPlayer1().getCharacter().setClearingLocation(5);
		//PlayerChit p1chit = new PlayerChit(gm.getPlayer1().getName(), gm.getPlayer1().getCharacter().getName(), gm.getPlayer1().getCharacter().getUrl());
		p1chit.setName(gm.getPlayer1().getName());
		p1chit.setCharacter(gm.getPlayer1().getCharacter().getName());
		p1chit.setUrl(gm.getPlayer1().getCharacter().getUrl());
		gm.getPlayer1().setPchit(p1chit);
		boardt.getTile("BAD VALLEY").getClearingByNum(5).movePersonHere(gm.getPlayer1().getPchit());
	}
	
	if(p == gm.getPlayer2()){
	    selected = true;			//we now know that p2 is done selecting so, selecion phase is over	
		if(name == "Amazon"){
	        gm.getPlayer2().setCharacter(new Amazon());
		      //player2.setCharacter(new Amazon());

		   	 txt.append(gm.getPlayer2().getName() + " Chose " + gm.getPlayer2().getCharacter().getName() + "\n"  + gm.getPlayer2().getCharacter().getName() + " currently visibile? " + gm.getPlayer2().getCharacter().getVisibility() + "\n");		    
	        
	        //showMessage(p2character, player2);

		}
		
		else if(name == "Captain"){
	       gm.getPlayer2().setCharacter(new Captain());
		      //player2.setCharacter(new Captain());

		   	 txt.append(gm.getPlayer2().getName() + " Chose " + gm.getPlayer2().getCharacter().getName() + "\n"  + gm.getPlayer2().getCharacter().getName() + " currently visibile? " + gm.getPlayer2().getCharacter().getVisibility() + "\n");		    
	        	        
	        
	        //showMessage(p2character, player2);
		}
		
		else if(name == "Dwarf"){
	        gm.getPlayer2().setCharacter(new Dwarf());
		     // player2.setCharacter(new Dwarf());

		   	 txt.append(gm.getPlayer2().getName() + " Chose " + gm.getPlayer2().getCharacter().getName() + "\n"  + gm.getPlayer2().getCharacter().getName() + " currently visibile? " + gm.getPlayer2().getCharacter().getVisibility() + "\n");		    
	        	        
	        //showMessage(p2character, player2);
		}
	
		else if(name == "Elf"){
	        gm.getPlayer2().setCharacter(new Elf());
		      //player2.setCharacter(new Elf());

		   	 txt.append(gm.getPlayer2().getName() + " Chose " + gm.getPlayer2().getCharacter().getName() + "\n"  + gm.getPlayer2().getCharacter().getName() + " currently visibile? " + gm.getPlayer2().getCharacter().getVisibility() + "\n");		    
	        	        
	        
	        //showMessage(p2character, player2);
		}
		
		else if(name == "BlackKnight"){
	        gm.getPlayer2().setCharacter(new BlackKnight());
		      //player2.setCharacter(new BlackKnight());

		   	 txt.append(gm.getPlayer2().getName() + " Chose " + gm.getPlayer2().getCharacter().getName() + "\n"  + gm.getPlayer2().getCharacter().getName() + " currently visibile? " + gm.getPlayer2().getCharacter().getVisibility() + "\n");		    
	        	        
	        
	        //showMessage(p2character, player2);
		}
		else if(name == "Swordsman"){
	        gm.getPlayer2().setCharacter(new Swordsman());
		     //player2.setCharacter(new Swordsman());

		   	 txt.append(gm.getPlayer2().getName() + " Chose " + gm.getPlayer2().getCharacter().getName() + "\n"  + gm.getPlayer2().getCharacter().getName() + " currently visibile? " + gm.getPlayer2().getCharacter().getVisibility() + "\n");		    
	        	        
	        //showMessage(p2character, player2);
		}
		gm.getPlayer2().getCharacter().setTileName("BAD VALLEY");
		gm.getPlayer2().getCharacter().setClearingLocation(5);
		//PlayerChit p2chit = new PlayerChit(gm.getPlayer2().getName(), gm.getPlayer2().getCharacter().getName(), gm.getPlayer2().getCharacter().getUrl());
		p2chit.setName(gm.getPlayer2().getName());
		p2chit.setCharacter(gm.getPlayer2().getCharacter().getName());
		p2chit.setUrl(gm.getPlayer2().getCharacter().getUrl());
		gm.getPlayer2().setPchit(p2chit);
		boardt.getTile("BAD VALLEY").getClearingByNum(5).movePersonHere(gm.getPlayer2().getPchit());
		
	
		//player1 = gm.getPlayer1();
		//player2 = gm.getPlayer2();

	
	}
	
	
}


 
public void toggleDie1(){	// change the die1 face any time the die is clicked

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
 

public void toggleDie2(){

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
//}

/*
public void moveActivity(Player p, ActionEvent e){
	if(!moveAct){
		int dialogButton = JOptionPane.YES_NO_OPTION;
    	int dialogResult = JOptionPane.showConfirmDialog (null, "ARE YOU SURE YOU WANT TO DO THIS ACTIVITY FOR THE DAY?","Alert",dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION){  
            moveAct = true;

            txt.append("\n---------------------------------- WHERE WOULD YOU LIKE TO MOVE!!\n");
        }
        else{
        	moveAct = false;
        	JOptionPane.showMessageDialog(getContentPane(), "PLEASE CHOOSE YOUR ACTIVITIES FOR THE DAY.");

        }
		}
		else if (activityCounter == 0){ JOptionPane.showMessageDialog(getContentPane(), "YOU HAVE USED ALL YOUR REQUIRED ACTIVITIES FOR THE DAY.");
		moveAct = false;
}	//getNextPlayer(currentPlayer);
			//movePlayer(currentPlayer, e);
	
	if(moveAct & p == player2 & activityCounter == 0){
		moveAct = false;
	    doneMove = true;
	    	txt.append("done activity choosing");
        	JOptionPane.showMessageDialog(getContentPane(), "we are done here.");
            move.setVisible(false);
            hide.setVisible(false);
            search.setVisible(false);
            rest.setVisible(false);
            trade.setVisible(false);
}
else{
	doneMove = false;
}

}

public void movePlayer(Player p, ActionEvent e){
	 moveActivity(p, e);
	
	
}*/
public int getPlayer1Roll(){
	return player1Roll;
}
public void setPlayer1Roll(int t){
	this.player1Roll = t;
}
public int getLastRoll(){
	return lastRoll;
}

public int getLastRoll2(){
	return lastRoll2;
}

public void setLastRoll(int t){
	this.lastRoll = t;
}
public void setLastRoll2(int t){
	this.lastRoll2 = t;
}

public void playGame(){
	getNextPlayer(currentPlayer);

	
	}
	
	



public void searchAction(){
	
	searchButtons = new LinkedList<JButton>(); 
	searchButtons.add(peer);
	searchButtons.add(loot);
	searchButtons.add(locate);
	
	//getContentPane().add(peer);
	//getContentPane().add(loot);
	//getContentPane().add(locate);
	
	locate = new JButton("LOCATE");

	locate.addActionListener(new ActionListener() {                 //Button Listener/* 
@Override
public void actionPerformed(ActionEvent e) { 
	
	txt.append("PLEASE ROLL A DIE");
    player1Roll = Math.max(roll(), roll());

	System.out.println(getPlayer1Roll());
	Locate.locateAction(currentPlayer, player1Roll);

}  
}); 
	locate.setBounds(1430, 329, 109, 23);
	locate.setIcon(new ImageIcon(Gui.class.getResource("/others/reveal.gif")));
	//locate.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
	locate.setSelected(true);
	locate.setVisible(true);
	//Gui.getContentPane().add(locate);
	contentPane.add(locate);

	
	peer = new JButton("PEER");
	
	peer.addActionListener(new ActionListener() {                 //Button Listener/* 
	    @Override
	public void actionPerformed(ActionEvent e) { 
	    	
	    
	    }  
	    }); 
	peer.setBounds(1460, 295, 80, 23);
	//peer.setIcon(new ImageIcon(Gui.class.getResource("/others/p1.png")));
	//peer.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
	peer.setSelected(true);
	peer.setVisible(true);
	contentPane.add(peer);
	
	
	loot = new JButton("LOOT");
	loot.addActionListener(new ActionListener() {                 //Button Listener/* 
	    @Override
	public void actionPerformed(ActionEvent e) { 
	    	
	    
	    }  
	    }); 
	loot.setBounds(1460, 261, 80, 23);
	//loot.setIcon(new ImageIcon(Gui.class.getResource("/others/p1.png")));
	//loot.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
	loot.setSelected(true);
	loot.setVisible(true);
	contentPane.add(loot);


}

public void checkSelected(Player p, MouseEvent e){
	
			if(!selected){
			int dialogButton = JOptionPane.YES_NO_OPTION;
	    	int dialogResult = JOptionPane.showConfirmDialog (null, "ARE YOU SURE YOU WANT TO SELECT THIS CHARACTER?","Alert",dialogButton);
			
	    	if (dialogResult == JOptionPane.YES_OPTION){  
	            //cheatMode = true;
	            selected = true;
                recruitCharacter(currentPlayer, e);
                
	          //  txt.append("\n---------------------------------- " + p.getName() + " YOU HAVE CHOOSEN :\n" + ((Component) e.getSource()).getName() + "\n");
	            AmazonIcon.setVisible(false);
	            CaptainIcon.setVisible(false);
	            BlackKnightIcon.setVisible(false);
	            ElfIcon.setVisible(false);
	            DwarfIcon.setVisible(false);
	            SwordsManIcon.setVisible(false);
	            backButton.setVisible(false);

	    	}
			
	        else {
	            AmazonIcon.setVisible(false);
	            CaptainIcon.setVisible(false);
	            BlackKnightIcon.setVisible(false);
	            ElfIcon.setVisible(false);
	            DwarfIcon.setVisible(false);
	            SwordsManIcon.setVisible(false);
	            backButton.setVisible(false);
	        	JOptionPane.showMessageDialog(getContentPane(), "PLEASE SELECT A CHARACTER.");

	        }
	        

			}

		if(selected & p == gm.getPlayer2()){
			    characterSelectionPhase = true;
			    	txt.append("done selection!! ya!!!");
		        	JOptionPane.showMessageDialog(getContentPane(), "PLEASE CHOOSE YOUR 4 ACTIVITIES FOR THE DAY.");
		            txt.append("\n----------------------------------\nPlease click on the 4 activities you would want to do today \n"); 
		            move.setVisible(true);
		            hide.setVisible(true);
		            search.setVisible(true);
		            rest.setVisible(true);
		            trade.setVisible(true);
		            alert.setVisible(true);
		            hire.setVisible(true);
		            follow.setVisible(true);
		            enchant.setVisible(true);

		}
		else{
			characterSelectionPhase = false;
		}
	


}
}
