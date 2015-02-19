package gui;




import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
import models.Swordsman;
import models.Things;

import java.awt.Component;
import java.util.LinkedList;
import java.awt.event.MouseAdapter;

public class Gui extends JFrame implements MouseListener {

	
	private JPanel contentPane;
	private JTextArea txt = new JTextArea ("Welcome to Magic Realm! ");
	private JLabel[] Die1Label, Die2Label;
	
	private JButton rollButton, selectButton, backButton;
	private JButton p1button, p2button;         // player turn indicators
    private int turn = 1;       // for the player character selection phase

	 private int lastRoll = 0;       // the last roll
	 private int lastRoll2 = 0;
	 private boolean rolled = false;
	 private boolean[] dieclicked = new boolean [2] ;
	 private boolean cheatMode = false;
	 private boolean randomMode = false;
	 private boolean selected = false;
	 private boolean characterSelectionPhase = false;
	 private boolean donePlayerRound = false;
	 private boolean startGame = false;
	 
	 private int clicked = 0;
	 int player1Roll = 0;
	 


	 
	 private CharacterContainer characters = new CharacterContainer();  // bag of things

	 
	 private Player currentPlayer = null;    // the turn of the current player.
	 private Things selectedCharacter = null;     //when the player clicks a Character off their rack
	 
	 private LinkedList<Things> p1characters = new LinkedList<Things>(), p2characters = new LinkedList<Things>(),
	            p3characters = new LinkedList<Things>(), p4characters = new LinkedList<Things>();
	 
	 
	 Player player1 = new Player();
	 Player player2 = new Player();
	 
	 JButton die1 ;
	 JButton die2 ;

	 /*Add dice that roll to the game board */

	ImageIcon[] img = new ImageIcon[8]; 
	 
	 



	 

	 private JLabel amazon, blackKnight, captain, dwarf, elf, swordsman, AmazonIcon, CaptainIcon, BlackKnightIcon, SwordsManIcon, DwarfIcon, ElfIcon;
	 
	// private JLabel[] characterLabels;
	 
	 final LinkedList<JLabel> characterLabels = new LinkedList<JLabel>();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	
	
	   final int totalPlayers = 2;
		
	
		
		String firstPlayer = (String)JOptionPane.showInputDialog(null, "Name:", "Enter Player 1 name", JOptionPane.QUESTION_MESSAGE,
	            null, null, "");
	    if (firstPlayer == null || firstPlayer.trim().length() == 0){
	    	System.out.println("You must enter a name");
	    	System.exit(1);
	    }
	   final String player1Name = firstPlayer.trim();
		
		
		String secondPlayer = (String)JOptionPane.showInputDialog(null, "Name:", "Enter Player 2 name", JOptionPane.QUESTION_MESSAGE,
	            null, null, "");
	    if (secondPlayer == null || secondPlayer.trim().length() == 0){ 
	    	
	    	System.out.println("You must enter a name");
	    	System.exit(1);
	    }
	   final String player2Name = secondPlayer.trim();
		
	    txt.append("\n----------------------------------\n Welcome to Magic Realm " + player1Name + " and " + player2Name + "!" + " \n Press 'New Game' to Play. \n--"); 

			
		player1.setName(player1Name);
		player2.setName(player2Name);
		
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/others/rs_logo.jpg")));
        setVisible(true);
        setTitle(" MAGIC REALM ");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1880, 1000);
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




setRoll.setBounds(300, 20, 120, 29);                               // bounds for button 
//setRoll.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));  
//setRoll.setSelected(false);
//setRoll.setBorderPainted(false);  
//setRoll.setContentAreaFilled(false);  
setRoll.setVisible(false);
getContentPane().add(setRoll); 



RollButton.setBounds(50, 47, 68, 66); 
RollButton.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
RollButton.setBorderPainted(false); 
RollButton.setContentAreaFilled(false); 
RollButton.setIcon(img[0]);
RollButton.setVisible(false);
getContentPane().add(RollButton);

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
    	
    	die1.setVisible(true);
        die2.setVisible(true);
    	
    	
    lastRoll = Dice(); 
    lastRoll2 = Dice(); 
    
    player1Roll = currentPlayer.getPlayerDie().getDieRoll(currentPlayer.getDieBool(), lastRoll, lastRoll2);
    
    txt.append("\n----------------------------------\n" + currentPlayer.getName() +" rolled : " + player1Roll); 

    
    txt.append("\n----------------------------------\nDie1 rolled a: " + lastRoll); 
    txt.append("\n----------------------------------\nDie2 rolled a: " + lastRoll2); 
   
    die1.setIcon(img[lastRoll]); 
    die2.setIcon(img[lastRoll2]); 
    
    rolled = true;    

    }  
    }); 

 

setRoll.addActionListener(new ActionListener() {                 //Button Listener/* 
    @Override
public void actionPerformed(ActionEvent e) { 
  
        txt.append("\n---------------------------------- die 1 rolled!!\n" + lastRoll);
        txt.append("\n---------------------------------- die 2 rolled!!\n" + lastRoll2);

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


        txt.append("\n----------------------------------\nPlease choose your characters \n"); 
        
        characterSelectionPhase = true;
        currentPlayer = player1;
        
          
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

//JScrollPane frameScroll = new JScrollPane (frame, 
//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//frameScroll.setSize(300, 300);
//frameScroll.setLocation(1500, 27);
//contentPane.add(frameScroll);

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



/*
selectButton = new JButton("select");
selectButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
       
    	int dialogButton = JOptionPane.YES_NO_OPTION;
    	int dialogResult = JOptionPane.showConfirmDialog (null, "ARE YOU SURE YOU WANT TO SELECT THIS CHARACTER?","Alert",dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION){  
            //cheatMode = true;
            selected = true;
        	txt.append("\n---------------------------------- THIS CHARACTER HAS BEEN SELECTED....yay!!\n");
            AmazonIcon.setVisible(false);
            CaptainIcon.setVisible(false);
            BlackKnightIcon.setVisible(false);
            ElfIcon.setVisible(false);
            DwarfIcon.setVisible(false);
            SwordsManIcon.setVisible(false);
            selectButton.setVisible(false);
            backButton.setVisible(false);
        }
        else{
        	selected = false;
            AmazonIcon.setVisible(false);
            CaptainIcon.setVisible(false);
            BlackKnightIcon.setVisible(false);
            ElfIcon.setVisible(false);
            DwarfIcon.setVisible(false);
            SwordsManIcon.setVisible(false);
            selectButton.setVisible(false);
            backButton.setVisible(false);
        	JOptionPane.showMessageDialog(getContentPane(), "PLEASE SELECT A CHARACTER.");
        	
        }
        }
    });

selectButton.setBounds(600, 807, 89, 23);
selectButton.setVisible(false);
contentPane.add(selectButton);

	*/
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



   
    }
    });
backButton.setBounds(800, 907, 100, 23);
backButton.setIcon (new ImageIcon(Gui.class.getResource("/actions/backarrow.gif")));
backButton.setVisible(false);
contentPane.add(backButton);
	
	
	
	
	}

	
public static int Dice(){                                       // Dice Function - returns # 
        
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

public void selectPlayerCharacter(Player p, int t, MouseEvent e){
   
    //Things temp = getTerrainFromBoard(e, JLabelList);

	
	   if (p == player1) { 
            if (t == 1) {
            	Things p1character = new Things();
            	p1character.setName(((Component) e.getSource()).getName());
            p1characters.add(p1character);

            }
          
        }
        
          if (p == player2){
            if (t == 1) {
            	Things p2character = new Things();
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


public void getNextPlayer(Player p){
    
    if (p == player1) { 
    	currentPlayer = player2; p1button.setSelected(false); 
                        p2button.setSelected(true); }
    if (p == player2) {
    	currentPlayer = player1; p2button.setSelected(false); 
    	p1button.setSelected(true); 
    	turn++;
                       }   
      
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
	
	if(p == player1){
	    selected = false;		//we know the players are not done selection
		if(name == "Amazon"){
	    	Things p1character = new Amazon();
	        p1characters.add(p1character); 
	        showMessage(p1character, player1);
		}
		
		else if(name == "Captain"){
			Things p1character = new Captain();
	        p1characters.add(p1character); 
	        showMessage(p1character, player1);
		}
		
		else if(name == "Dwarf"){
			Things p1character = new Dwarf();
	        p1characters.add(p1character); 
	        showMessage(p1character, player1);
		}
	
		else if(name == "Elf"){
			Things p1character = new Elf();
	        p1characters.add(p1character); 
	        showMessage(p1character, player1);

		}
		
		else if(name == "BlackKnight"){
			Things p1character = new BlackKnight();
	        p1characters.add(p1character); 
	        showMessage(p1character, player1);
		}
		else if(name == "SwordsMan"){
			Things p1character = new Swordsman();
	        p1characters.add(p1character); 
	        showMessage(p1character, player1);
		}
		
	}
	
	if(p == player2){
	    selected = true;			//we now know that p2 is done selecting so, selecion phase is over	
		if(name == "Amazon"){
	    	Things p2character = new Amazon();
	        p2characters.add(p2character); 
	        showMessage(p2character, player2);

		}
		
		else if(name == "Captain"){
			Things p2character = new Captain();
	        p2characters.add(p2character); 
	        showMessage(p2character, player2);
		}
		
		else if(name == "Dwarf"){
			Things p2character = new Dwarf();
	        p2characters.add(p2character); 
	        showMessage(p2character, player2);
		}
	
		else if(name == "Elf"){
			Things p2character = new Elf();
	        p2characters.add(p2character); 
	        showMessage(p2character, player2);
		}
		
		else if(name == "BlackKnight"){
			Things p2character = new BlackKnight();
	        p2characters.add(p2character); 
	        showMessage(p2character, player2);
		}
		else if(name == "SwordsMan"){
			Things p2character = new Swordsman();
	        p2characters.add(p2character); 
	        showMessage(p2character, player2);
		}		
		
		
	
	
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

public void checkSelected(Player p, MouseEvent e){
	
			if(!selected){
			int dialogButton = JOptionPane.YES_NO_OPTION;
	    	int dialogResult = JOptionPane.showConfirmDialog (null, "ARE YOU SURE YOU WANT TO SELECT THIS CHARACTER?","Alert",dialogButton);
			
	    	if (dialogResult == JOptionPane.YES_OPTION){  
	            //cheatMode = true;
	            selected = true;
                recruitCharacter(currentPlayer, e);
                
	            txt.append("\n---------------------------------- " + p.getName() + " YOU HAVE CHOOSEN :\n" + ((Component) e.getSource()).getName() + "\n");
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

		
	
	
}


}
