package gameLogic;

import gui.Gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Player;
import models.Things;
import models.Tiles;
import models.WarningChit;
import models.WarningChit.Bones;
import models.WarningChit.Dank;
import models.WarningChit.Ruins;
import models.WarningChit.Smoke;
import models.WarningChit.Stink;

public class GuiActivities {
	
	private Player player1 = new Player();
	 private Player player2 = new Player();
	 private Player currentPlayer = null;
	 
	 private boolean hideAct;
		private boolean moveAct;
		private boolean searchAct;
		private boolean tradeAct;
		private boolean restAct;
		private boolean doneMove;
	    private int activityCounter = 5;       // for the player character selection phase
	    
	    private LinkedList<Tiles> moveTiles = new LinkedList<Tiles>();
	    private LinkedList<Tiles> searchTiles = new LinkedList<Tiles>();

	   private JButton locate, loot, peer;
	 
	    BoardTiles bd; 
	    
	public GuiActivities(BoardTiles bd){
		
		this.bd=bd;
		//bd = new BoardTiles(); 
		//bd = BoardTest.initializeTiles();
		
		

	}


	public void activity(LinkedList<String> p1, ActionEvent e, int n) {
		
      	 HashMap<Player, LinkedList<String>> hm = new HashMap<Player, LinkedList<String>>();
    	 LinkedList<String>  p1choiceOrder = new LinkedList<String>();

    	 String activity = e.getActionCommand();

		if(!moveAct){
				int dialogButton = JOptionPane.YES_NO_OPTION;
		    	int dialogResult = JOptionPane.showConfirmDialog (null, "ARE YOU SURE YOU WANT TO DO THIS ACTIVITY FOR THE DAY?","Alert",dialogButton);
		        if (dialogResult == JOptionPane.YES_OPTION){  
		       
		    	 p1.add(activity);
		    	
		        }
		        else{
					//n++;
					
						//moveAct = true;					
						System.out.println("select your action");

		        }} 
		
		
		
		}
		
		// hm.put(p1, p1choiceOrder);
		//System.out.println(p1choiceOrder);
       	// return hm;		        }
		

	public void display(JTextArea txt){
		
        txt.append("\n---------------------------------- WHERE WOULD YOU LIKE TO MOVE!!\n");

	
	}

	
	
	
	
	
	public void displayOptionPane(Component cp){
	JOptionPane.showMessageDialog(cp, "PLEASE CHOOSE YOUR ACTIVITIES FOR THE DAY.");

	}


	public int getActivityCounter() {
		return activityCounter;
	}


	
	

	
	
	
	public void setActivityCounter(int activityCounter) {
		this.activityCounter = activityCounter;
		//activityCounter--;
	}


	public void addWarningChits(){
		
		LinkedList<WarningChit> chits = new LinkedList<WarningChit>();
		
		WarningChit smoke = new Smoke();
		WarningChit bones = new Bones();
		WarningChit dank = new Dank();
		WarningChit ruins = new Ruins();
		WarningChit stink = new Stink();
		
		for(int i=0; i<bd.size(); i++){
			chits.add(smoke);
			chits.add(bones);
			chits.add(dank);
			chits.add(ruins);
			chits.add(stink);
		}
		
		
		for(int i = 0; i < bd.size(); i++){
			
			bd.getTile(i).setWarnings(chits.get(i));
			//if(bd.getTile(i).getWarnings() !=null)
				//System.out.println(bd.getTile(i).getWarnings().getName());
		}
		
		System.out.println(bd);
	}





	JTextField TileName = new JTextField();
	JTextField Clearing = new JPasswordField();
	
	Object[] message = {
	    "Tile Name:", TileName,
	    "Clearing:", Clearing
	};
public boolean requestMove(Player p){
	int option = JOptionPane.showConfirmDialog(null, message, "MOVE!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		//success = true;
		String input = TileName.getText().toString().trim();
		bd.getTile(input);
		moveTiles.add(bd.getTile(input));
		System.out.println(bd.getTile(input).getName());
		
		bd.getTile(TileName.getText().toUpperCase()).getClearingByNum(Integer.parseInt(Clearing.getText())).setPlayerHere(true);
		return true;
		
		
		
		/*
		
		  if (TileName.getText().equals("h") && Clearing.getText().equals("h")) {	
	        System.out.println("Login successful");
	        //success = false;
	    } else {
	        System.out.println("login failed");	 
	        //success = false;

	    }
	} else {
	    System.out.println("Login canceled");
        //success = false;*/

	}else return false;





}

public LinkedList<JButton> requestSearch(){
int option = JOptionPane.showConfirmDialog(null, null, "SEARCH!", JOptionPane.OK_CANCEL_OPTION);
LinkedList <JButton> buttons = new LinkedList<JButton>();

	if (option == JOptionPane.OK_OPTION) {
		//String input = TileName.getText().toString().trim();
//LinkedList <JButton> buttons = new LinkedList<JButton>();
		
		locate = new JButton("LOCATE");
		locate.setBounds(1430, 329, 109, 23);
		locate.setIcon(new ImageIcon(Gui.class.getResource("/others/reveal.gif")));
		//locate.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
		locate.setSelected(true);
		locate.setVisible(true);
		//Gui.getContentPane().add(locate);
		
		
		peer = new JButton("PEER");
		peer.setBounds(1460, 295, 80, 23);
		peer.setIcon(new ImageIcon(Gui.class.getResource("/others/p1.png")));
		peer.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
		peer.setSelected(true);
		peer.setVisible(true);
		//contentPane.add(peer);
		
		
		loot = new JButton("LOOT");
		loot.setBounds(1460, 261, 80, 23);
		loot.setIcon(new ImageIcon(Gui.class.getResource("/others/p1.png")));
		loot.setSelectedIcon(new ImageIcon(Gui.class.getResource("/others/p1s.png")));
		loot.setSelected(true);
		loot.setVisible(true);
		//contentPane.add(loot);

		
		buttons.add(locate);
		buttons.add(peer);
		buttons.add(loot);
		//searchTiles.add(bd.getTile(input));
		//System.out.println(bd.getTile(input).getName());
	
		 if (TileName.getText().equals("h") && Clearing.getText().equals("h")) {	
		        System.out.println("Login successful");
		    } else {
		        System.out.println("login failed");
		    }
		} else {
		    System.out.println("Login canceled");
		}
	return buttons;
	}

public boolean requestHide(Player p){
	int option = JOptionPane.showConfirmDialog(null, null, "HIDE!", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {
		System.out.println(p.getCharacter().getName());

			p.getCharacter().setVisibility(false);
			System.out.println(p.getCharacter().getName());

			return true;
	
		}else{
			p.getCharacter().setVisibility(true);
			return false;
		}
	
	
}

public void promptPlayerName(JTextArea txt){
	
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

		
	getPlayer1().setName(player1Name);
	player2.setName(player2Name);
	
	
}


public boolean requestTrade(Player p) {
	
	
	return false;



}





public JButton[] intializeTrade(){
	
	final ButtonGroup buttonGroup = new ButtonGroup();
	
	JButton[] items = new JButton[13]; 

	items[0] = new JButton("BreastPlates");
	//JButton BreastPlates = new JButton("BreastPlates");
	items[0].setBounds(50, 200, 100, 70);
	items[0].setIcon(new ImageIcon(Gui.class.getResource("/armor/breastplate.gif")));
	items[0].setVisible(true);
	buttonGroup.add(items[0]);
	
	
	items[1] = new JButton("BroadSword");
	items[1].setBounds(170, 200, 100, 70);
	items[1].setIcon(new ImageIcon(Gui.class.getResource("/weapons/broadsword.gif")));
	items[1].setVisible(true);
	buttonGroup.add(items[1]);

	items[2] = new JButton("CrossBow");
	items[2].setBounds(270, 200, 100, 70);
	items[2].setIcon(new ImageIcon(Gui.class.getResource("/weapons/crossbow.gif")));
	items[2].setVisible(true);
	buttonGroup.add(items[2]);
	
	items[3] = new JButton("GreatAxe");
	items[3].setBounds(370, 200, 100, 70);
	items[3].setIcon(new ImageIcon(Gui.class.getResource("/weapons/great_axe.gif")));
	items[3].setVisible(true);
	buttonGroup.add(items[3]);
	
	items[4] = new JButton("GreatSword");
	items[4].setBounds(470, 200, 100, 70);
	items[4].setIcon(new ImageIcon(Gui.class.getResource("/weapons/great_sword.gif")));
	items[4].setVisible(true);
	buttonGroup.add(items[4]);
	
	
	items[5] = new JButton("Helmet");
	items[5].setBounds(570, 200, 100, 70);
	items[5].setIcon(new ImageIcon(Gui.class.getResource("/armor/helmet.gif")));
	items[5].setVisible(true);
	buttonGroup.add(items[5]);
	
	
	items[6] = new JButton("LightBow");
	items[6].setBounds(50, 300, 100, 70);
	items[6].setIcon(new ImageIcon(Gui.class.getResource("/weapons/light_bow.gif")));
	items[6].setVisible(true);
	buttonGroup.add(items[6]);
	
	
	items[7] = new JButton("Mace");
	items[7].setBounds(170, 300, 100, 70);
	items[7].setIcon(new ImageIcon(Gui.class.getResource("/weapons/mace.gif")));
	items[7].setVisible(true);
	buttonGroup.add(items[7]);
	
	items[8] = new JButton("Shields");
	items[8].setBounds(270, 300, 100, 70);
	items[8].setIcon(new ImageIcon(Gui.class.getResource("/armor/shield.gif")));
	items[8].setVisible(true);
	buttonGroup.add(items[8]);
	
	items[9] = new JButton("ShortSword");
	items[9].setBounds(370, 300, 100, 70);
	items[9].setIcon(new ImageIcon(Gui.class.getResource("/weapons/short_sword.gif")));
	items[9].setVisible(true);
	buttonGroup.add(items[9]);
	
	items[10] = new JButton("Spear");
	items[10].setBounds(470, 300, 100, 70);
	items[10].setIcon(new ImageIcon(Gui.class.getResource("/weapons/spear.gif")));
	items[10].setVisible(true);
	buttonGroup.add(items[10]);
	
	items[11] = new JButton("ThrustingSword");
	items[11].setBounds(570, 300, 100, 70);
	items[11].setIcon(new ImageIcon(Gui.class.getResource("/weapons/thrusting_sword.gif")));
	items[11].setVisible(true);
	buttonGroup.add(items[11]);
	
	
	items[12] = new JButton("SuitsOfAmor");
	items[12].setBounds(670, 300, 100, 70);
	items[12].setIcon(new ImageIcon(Gui.class.getResource("/armor/suitofarmor.gif")));
	items[12].setVisible(true);
	buttonGroup.add(items[12]);
	
	return items;
	
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


public void getNextPlayer(Player p){
    
    if (p == player1) { 
    	setCurrentPlayer(player2);  }
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


}
