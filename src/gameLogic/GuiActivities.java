package gameLogic;

import gameBoard.BoardTiles;
import gameBoard.Tiles;
import gui.Gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Chapel;
import models.Dwelling;
import models.GuardHouse;
import models.House;
import models.Inn;
import models.Player;
import models.PlayerChit;
import models.WarningChit;
import models.WarningChit.Bones;
import models.WarningChit.Dank;
import models.WarningChit.Ruins;
import models.WarningChit.Smoke;
import models.WarningChit.Stink;
import natives.Bashkars;
import natives.Company;
import natives.Lancers;
import natives.NativeGroup;
import natives.Patrol;
import natives.Woodfolk;

public class GuiActivities {
	
	private Player player1 = new Player();
	 private Player player2 = new Player();
	 private Player currentPlayer = null;
	 
	 private PlayerChit p1chit = new PlayerChit();
	  private PlayerChit p2chit = new PlayerChit();
	 

	 private boolean hideAct;
	 private boolean rolled;
	 
		private boolean moveAct;
		private boolean selected;
		private boolean tradeAct;
		private boolean restAct;
		private boolean doneMove;
	    private int activityCounter = 0;       // for the player character selection phase
	    
	    private LinkedList<Tiles> moveTiles = new LinkedList<Tiles>();
	    private LinkedList<Tiles> searchTiles = new LinkedList<Tiles>();

	   private JButton locate, loot, peer;
	 
	    BoardTiles bd; 
	    
	public GuiActivities(BoardTiles bd){
		
		this.bd=bd;
		//bd = new BoardTiles(); 
		//bd = BoardTest.initializeTiles();
		 player1.setTile("BAD VALLEY");
	      player1.setClearing(5);
		 
		 player2.setTile("BAD VALLEY");
	      player2.setClearing(5);
		 
		

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
						System.out.println("select your action");

		        }} 
		
		
		
		}

		

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
		String input = TileName.getText().toString().trim();
		if(bd.getTile(p.getCharacter().getTileName()).isNeighbour(bd.getTile(input)) == true || p.getCharacter().getTileName().equals(input) == true){
			bd.getTile(TileName.getText().toUpperCase()).getClearingByNum(Integer.parseInt(Clearing.getText())).movePersonHere(p.getPchit());
			
			

			bd.getTile(p.getTile()).getClearingByNum(p.getClearing()).removePersonHere(p.getPchit());

			p.moveTo(TileName.getText(), Integer.parseInt(Clearing.getText()));

			p.getCharacter().moveTo(TileName.getText(), Integer.parseInt(Clearing.getText()));
	

		}else{JOptionPane.showMessageDialog(null, "Invalid Move \n DON'T CHEAT!");}
		
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

	}else 
		return false;
	
	





}


public boolean placedwelling(Dwelling d){
	int option = JOptionPane.showConfirmDialog(null, message, "Place!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		String input = TileName.getText().toString().trim();
		bd.getTile(input);
		moveTiles.add(bd.getTile(input));
		System.out.println(bd.getTile(input).getName());
		
		bd.getTile(TileName.getText().toUpperCase()).getClearingByNum(Integer.parseInt(Clearing.getText())).setDwelling(d);
		d.setHome(TileName.getText());
		d.setClearing(Integer.parseInt(Clearing.getText()));
		
		
		return true;
	
	}else return false;

}

public boolean placeNative(NativeGroup d){
	int option = JOptionPane.showConfirmDialog(null, message, "Place!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		String input = TileName.getText().toString().trim();
		bd.getTile(input);
		moveTiles.add(bd.getTile(input));
		System.out.println(bd.getTile(input).getName());
		
		bd.getTile(TileName.getText().toUpperCase()).getClearingByNum(Integer.parseInt(Clearing.getText())).setNatives(d);
		d.setClearing(Integer.parseInt(Clearing.getText()));
		
		
		return true;
	
	}else return false;

}


public boolean placePlayer1(Player p){
	int option = JOptionPane.showConfirmDialog(null, message, "Place Player 1!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		String input = TileName.getText().toString().trim();
		
		getPlayer1().moveTo(input, Integer.parseInt(Clearing.getText()));		
		getPlayer1().getCharacter().moveTo(TileName.getText(), Integer.parseInt(Clearing.getText()));		

		
		p1chit.setName(getPlayer1().getName());
		getPlayer1().setPchit(p1chit);
		
		bd.getTile(TileName.getText()).getClearingByNum(Integer.parseInt(Clearing.getText())).movePersonHere(getPlayer1().getPchit());
	
		
		return true;
		}
	else return false;
}


public boolean placePlayer2(Player p){
	int option = JOptionPane.showConfirmDialog(null, message, "Place Player 2!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		String input = TileName.getText().toString().trim();
		
		getPlayer2().moveTo(input, Integer.parseInt(Clearing.getText()));		
		getPlayer2().getCharacter().moveTo(TileName.getText(), Integer.parseInt(Clearing.getText()));		

		
		p2chit.setName(getPlayer2().getName());
		//p2chit.setCharacter(getPlayer2().getCharacter().getName());
		//p2chit.setUrl(getPlayer2().getCharacter().getUrl());
		getPlayer2().setPchit(p2chit);
		
		bd.getTile(TileName.getText()).getClearingByNum(Integer.parseInt(Clearing.getText())).movePersonHere(getPlayer2().getPchit());
	
				
		
		return true;
		}
	else return false;
}



public boolean placeWarningChit(WarningChit wc){
	/*
	bd.getTile((String)JOptionPane.showInputDialog(null, "Tile:", "Place a dwelling", JOptionPane.QUESTION_MESSAGE, null,
     null, "Type Tile name here")).setWarnings(wc);
	
	return true;
	*/
	String inputname;
	
	 inputname = (String)JOptionPane.showInputDialog(null, "Tile:", "Place a dwelling", JOptionPane.QUESTION_MESSAGE, null,
	        null, "Type your name here");
	
	if (inputname == null || inputname.trim().length() == 0) 
		JOptionPane.showMessageDialog(null, "Enter A  tile name");

		else if(inputname != null){
			if(bd.getTile(inputname) != null){
				bd.getTile(inputname).setWarnings(wc);
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Enter A  Valid Tile name in Block Letters!");
				return false;
			}
		}
		return false;
	}
	// String input = inputname.trim();
	//int option = JOptionPane.showConfirmDialog(null, message, "Place!", JOptionPane.OK_CANCEL_OPTION);
	

	//if(bd.isLegalTile())
	
		//bd.getTile((String)JOptionPane.showInputDialog(null, "Tile:", "Place a dwelling", JOptionPane.QUESTION_MESSAGE, null,
		         //  null, "Type Tile name here")).setWarnings(wc);

	
	
//return false;







public boolean requestSearch(final Player p, Container cp){
int option = JOptionPane.showConfirmDialog(null, null, "SEARCH!", JOptionPane.OK_CANCEL_OPTION);
	//JButton[] items = new JButton[3]; 
	final JButton locate;
	final JButton peer;
	final JButton loot ;
	final JButton backButton;

	
	
	if(!rolled)				
		JOptionPane.showMessageDialog(null, "Roll a die first");

	if (option == JOptionPane.OK_OPTION) {

		//String input = TileName.getText().toString().trim();
//LinkedList <JButton> buttons = new LinkedList<JButton>();
		
		locate = new JButton("LOCATE");
		locate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!rolled)
					JOptionPane.showMessageDialog(null, "Roll a die first");
				if(rolled && p.getCharacter().getRoll() == 4){
					for(int i = 0; i < bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().size(); i++)
					bd.getTile(p.getTile()).getClearingByNum((p.getClearing())).getTreasureChits().get(i).setVisisble(true);
					
					JOptionPane.showMessageDialog(null, "Treasure chits are now visible!");

					System.out.println(" Treasure chits are now visible");
				}else if(rolled && p.getCharacter().getRoll() == 1){
					JOptionPane.showMessageDialog(null, "Which would you want to do!");

				
			}else if(rolled && p.getCharacter().getRoll() == 2){
				JOptionPane.showMessageDialog(null, "you have located hidden clues");

			}
			else if(rolled && p.getCharacter().getRoll() == 3){
				JOptionPane.showMessageDialog(null, "you have located hidden Passages");

			}
		
			else if(rolled && p.getCharacter().getRoll() > 4){
				JOptionPane.showMessageDialog(null, "You discovered nothing");

			}
			rolled = false;
			}
		});
		locate.setBounds(1430, 329, 109, 30);
		locate.setIcon(new ImageIcon(Gui.class.getResource("/others/reveal.gif")));
		locate.setVisible(true);
		cp.add(locate);
		
		
		peer = new JButton("PEER");
		peer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		peer.setBounds(1430, 295, 109, 30);
		peer.setIcon(new ImageIcon(Gui.class.getResource("/others/peer.png")));
		peer.setVisible(true);
		cp.add(peer);
		
		
		loot = new JButton("LOOT");
		loot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Please Roll a die");

				
			}
		});
		loot.setBounds(1430, 261, 109, 30);
		loot.setIcon(new ImageIcon(Gui.class.getResource("/others/loot.png")));
		loot.setVisible(true);
		cp.add(loot);

		
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    			    	
		    	
				locate.setVisible(false);
				peer.setVisible(false);
				loot.setVisible(false);

				backButton.setVisible(false);


		   
		    }
		    });
		backButton.setBounds(800, 907, 100, 23);
		backButton.setIcon (new ImageIcon(Gui.class.getResource("/actions/backarrow.gif")));
		backButton.setVisible(true);
		cp.add(backButton);
		
		
		
		
		
		
		return true;

	
		// if (TileName.getText().equals("h") && Clearing.getText().equals("h")) {	
		 //      System.out.println("Login successful");
		 //   } else {
		      //  System.out.println("login failed");
		//    }
		//} else {
		//    System.out.println("Login canceled");
		}
	return false;	
		}

public boolean requestHide(Player p, boolean rolled, JTextArea txt){
	int option = JOptionPane.showConfirmDialog(null, null, "HIDE!", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {
		
		if(getRolled() == false){
			JOptionPane.showMessageDialog(null, "Please roll die first");
		return false;
		}
		
		else if(getRolled() && p.getCharacter().getRoll() < 6){

			p.getCharacter().setVisibility(false);
			p.getPchit().setHidden(true);
			txt.append(p.getName() + " is now hidden from every one \n");


			return true;
			
		}
		
		else if(p.getCharacter().getRoll()==6){
			JOptionPane.showMessageDialog(null, "Sorry you cant hide");
			return true;
		}
			
		else{
			JOptionPane.showMessageDialog(null, "Play a Turn!");
			//txt.append(p.getCharacter().getName())
		}
		
	}
	return false;
	
	
}


public boolean requestRest(Player p, JTextArea txt){
	
	int option = JOptionPane.showConfirmDialog(null, null, "REST!", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {
		
		txt.append(p.getName() + " is now resting \n");


		return true;
		
		
	}else{
		txt.append(p.getName() + " is not resting \n");

		return false;
	}
	
}


public boolean requestAlert(Player p, JTextArea txt){
	
	int option = JOptionPane.showConfirmDialog(null, null, "Alert!", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {
		
		p.getCharacter().setAlert(true);
		txt.append(p.getName() + " is now Alerted \n");


		return true;
		
		
	}else{
		System.out.println(p.getCharacter().isAlert());

		return false;
	}
	
}


public boolean requestHire(Player p, JTextArea txt){
	
	int option = JOptionPane.showConfirmDialog(null, null, "Hire!", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {
		txt.append(" please select the native group you wish to hire \n");
		txt.append(" You can only hire native groups in the same clearing with you \n");


		return true;
		
		
	}else{
		System.out.println(p.getCharacter().isAlert());

		return false;
	}
	
}

public boolean hireNative(ActionEvent e, Player p, NativeGroup ng, JTextArea txt ){		//player hires a native group
	String name = ((Component) e.getSource()).getName();

	int option = JOptionPane.showConfirmDialog(null, null, "Recruit this Native Group?", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {
		
		if(name == ng.getName() && ng.isHired() == false){				//check if the native group is already hired
			p.getCharacter().buyNative(p.getCharacter(), ng);	//if not hired hire the group
			txt.append("You have successfully recruited " + p.getCharacter().getHiredNatives().get(0).getName());	
			ng.setHired(true);			
			return true;
		}
		
	}else{
		txt.append("This group has already been hired");
	}
	if(p.getCharacter().getHiredNatives().size() > 0)
	txt.append("You currently have this native group " + p.getCharacter().getHiredNatives().get(0).getName());
	return false;
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





public void intializeTrade(Container cp){
	
	final ButtonGroup buttonGroup = new ButtonGroup();
	
	final JButton backButton;
	
	final JButton[] items = new JButton[13]; 
	
	backButton = new JButton("Back");
	backButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
	  	        
	        for(int i = 0; i < items.length; i++)
				items[i].setVisible(false);
	    		backButton.setVisible(false);

	   
	    }
	    });
	backButton.setBounds(800, 907, 100, 23);
	backButton.setIcon (new ImageIcon(Gui.class.getResource("/actions/backarrow.gif")));
	backButton.setVisible(true);
	cp.add(backButton);	
	
	int option = JOptionPane.showConfirmDialog(null, null, "TRADE!", JOptionPane.OK_CANCEL_OPTION);
	if (option == JOptionPane.OK_OPTION) {


	items[0] = new JButton("BreastPlates");
	items[0].setBounds(50, 150, 65, 70);
	items[0].setIcon(new ImageIcon(Gui.class.getResource("/armor/breastplate.png")));
	items[0].setVisible(true);
	buttonGroup.add(items[0]);
	cp.add(items[0]);
	
	
	items[1] = new JButton("BroadSword");
	items[1].setBounds(145, 300, 85, 50);
	items[1].setIcon(new ImageIcon(Gui.class.getResource("/weapons/broadsword.png")));
	items[1].setVisible(true);
	buttonGroup.add(items[1]);
	cp.add(items[1]);


	items[2] = new JButton("CrossBow");
	items[2].setBounds(350, 500, 150, 60);
	items[2].setIcon(new ImageIcon(Gui.class.getResource("/weapons/crossboww.png")));
	items[2].setVisible(true);
	buttonGroup.add(items[2]);
	cp.add(items[2]);

	
	items[3] = new JButton("GreatAxe");
	items[3].setBounds(50, 300, 75, 70);
	items[3].setIcon(new ImageIcon(Gui.class.getResource("/weapons/greataxe.png")));
	items[3].setVisible(true);
	buttonGroup.add(items[3]);
	cp.add(items[3]);

	
	items[4] = new JButton("GreatSword");
	items[4].setBounds(250, 300, 140, 100);
	items[4].setIcon(new ImageIcon(Gui.class.getResource("/weapons/greatsword.png")));
	items[4].setVisible(true);
	buttonGroup.add(items[4]);
	cp.add(items[4]);

	
	
	items[5] = new JButton("Helmet");
	items[5].setBounds(140, 150, 65, 70);
	items[5].setIcon(new ImageIcon(Gui.class.getResource("/armor/helmet.png")));
	items[5].setVisible(true);
	buttonGroup.add(items[5]);
	cp.add(items[5]);

	
	
	items[6] = new JButton("LightBow");
	items[6].setBounds(430, 300, 100, 50);
	items[6].setIcon(new ImageIcon(Gui.class.getResource("/weapons/lightbow.png")));
	items[6].setVisible(true);
	buttonGroup.add(items[6]);
	cp.add(items[6]);

	
	
	items[7] = new JButton("Mace");
	items[7].setBounds(570, 300, 150, 50);
	items[7].setIcon(new ImageIcon(Gui.class.getResource("/weapons/mace.png")));
	items[7].setVisible(true);
	buttonGroup.add(items[7]);
	cp.add(items[7]);

	
	items[8] = new JButton("Shields");
	items[8].setBounds(230, 150, 70, 110);
	items[8].setIcon(new ImageIcon(Gui.class.getResource("/armor/shields.png")));
	items[8].setVisible(true);
	buttonGroup.add(items[8]);
	cp.add(items[8]);

	
	items[9] = new JButton("ShortSword");
	items[9].setBounds(730, 300, 130, 35);
	items[9].setIcon(new ImageIcon(Gui.class.getResource("/weapons/shortsword.png")));
	items[9].setVisible(true);
	buttonGroup.add(items[9]);
	cp.add(items[9]);

	
	items[10] = new JButton("Spear");
	items[10].setBounds(50, 500, 130, 90);
	items[10].setIcon(new ImageIcon(Gui.class.getResource("/weapons/spear.png")));
	items[10].setVisible(true);
	buttonGroup.add(items[10]);
	cp.add(items[10]);

	
	items[11] = new JButton("ThrustingSword");
	items[11].setBounds(200, 500, 110, 50);
	items[11].setIcon(new ImageIcon(Gui.class.getResource("/weapons/thrustingsword.png")));
	items[11].setVisible(true);
	buttonGroup.add(items[11]);
	cp.add(items[11]);

	
	
	items[12] = new JButton("SuitsOfAmor");
	items[12].setBounds(330, 150, 135, 125);
	items[12].setIcon(new ImageIcon(Gui.class.getResource("/armor/suitsofarmor.png")));
	items[12].setVisible(true);
	buttonGroup.add(items[12]);
	cp.add(items[12]);

	}
	//return items;
	
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


public void showNativeGroup(final NativeGroup ng, final Player p, final JTextArea txt, Container cp) {

	System.out.println(ng.getTile() +  p.getTile());
	System.out.println(ng.getClearing() + " " + p.getClearing());
	
	final JButton groupLabel = new JButton(); 
	
	groupLabel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(ng.isHired() == true){
				JOptionPane.showMessageDialog(null, "This group has already been hired!");
				groupLabel.setVisible(false);	
				}else{
				hireNative(e, p, ng, txt);
				groupLabel.setVisible(false);	
				}
		}
	});
	groupLabel.setIcon(new ImageIcon(Gui.class.getResource("/others/nativegroup.jpg")));
	groupLabel.setName(ng.getName());
	groupLabel.setBounds(50, 700, 120, 120);
	groupLabel.setVisible(false);
	cp.add(groupLabel);

	
	if(ng.getTile().equals(p.getTile()) && ng.getClearing() == p.getClearing()){		
		
		groupLabel.setVisible(true);	
	
	}
}


public void cheatmodeButtons(Container container){
	
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

	
	final LinkedList<Dwelling> dwellings = new LinkedList<Dwelling>();
	final LinkedList<WarningChit> warningchits = new LinkedList<WarningChit>();

	final Chapel chapel = new Chapel();
	final GuardHouse guardhouse = new GuardHouse();
	final House house = new House();
	final Inn inn = new Inn();
	
	final Bones bones = new Bones();
	final Dank dank = new Dank();
	final Ruins ruins = new Ruins();
	final Smoke smoke = new Smoke();
	final Stink stink = new Stink();
	
	final Bashkars bashkars = new Bashkars();
	final Lancers lancers = new Lancers();
	final Patrol patrol = new Patrol();
	final Woodfolk woodfolk = new Woodfolk();
	final Company company = new Company();
	
	
	final JComboBox comboBox = new JComboBox();
	
    comboBox.setEnabled(false);
    comboBox.setBounds(706, 237, 245, 27);
	
	
	dwellings.add(chapel);
	dwellings.add(guardhouse);
	dwellings.add(house);
	dwellings.add(inn);
	
	warningchits.add(bones);
	warningchits.add(dank);
	warningchits.add(ruins);
	warningchits.add(smoke);
	warningchits.add(stink);

		
	
	final JLabel chapelLabel = new JLabel();
	chapelLabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
			placedwelling(chapel);
		}
	});
	chapelLabel.setIcon(new ImageIcon(Gui.class.getResource("/dwellings/chapel.gif")));
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
	guardLabel.setIcon(new ImageIcon(Gui.class.getResource("/dwellings/guard.gif")));
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
	houseLabel.setIcon(new ImageIcon(Gui.class.getResource("/dwellings/house.gif")));
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
	innLabel.setIcon(new ImageIcon(Gui.class.getResource("/dwellings/inn.gif")));
	innLabel.setBounds(480, 150, 70, 50);
	innLabel.setName("Inn");
	innLabel.setVisible(false);
	container.add(innLabel);
	

		
	
	boneslabel = new JLabel();
	boneslabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
			placeWarningChit(bones);
		}
	});
	boneslabel.setIcon(new ImageIcon(Gui.class.getResource("/others/bones.png")));
	boneslabel.setBounds(150, 250, 70, 50);
	boneslabel.setName("Bones");
	boneslabel.setVisible(false);
	container.add(boneslabel);


	danklabel = new JLabel();
	danklabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			placeWarningChit(dank);

		
		}
	});
	danklabel.setIcon(new ImageIcon(Gui.class.getResource("/others/dank.png")));
	danklabel.setBounds(250, 250, 70, 50);
	danklabel.setName("DANK");
	danklabel.setVisible(false);
	container.add(danklabel);
	
	
	ruinslabel = new JLabel();
	ruinslabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
			placeWarningChit(ruins);

		}
	});
	ruinslabel.setIcon(new ImageIcon(Gui.class.getResource("/others/ruins.png")));
	ruinslabel.setBounds(350, 250, 70, 50);
	ruinslabel.setName("Ruins");
	ruinslabel.setVisible(false);
	container.add(ruinslabel);
	
	
	smokelabel = new JLabel();
	smokelabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
			placeWarningChit(smoke);

		}
	});
	smokelabel.setIcon(new ImageIcon(Gui.class.getResource("/others/smoke.png")));
	smokelabel.setBounds(450, 250, 70, 50);
	smokelabel.setName("Smoke");
	smokelabel.setVisible(false);
	container.add(smokelabel);
	
	
	
	stinklabel = new JLabel();
	stinklabel.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
		
			placeWarningChit(stink);

		}
	});
	stinklabel.setIcon(new ImageIcon(Gui.class.getResource("/others/stink.png")));
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
	companylabel.setIcon(new ImageIcon(Gui.class.getResource("/natives/company.png")));
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
	woodfolklabel.setIcon(new ImageIcon(Gui.class.getResource("/natives/woodfolk.png")));
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
	patrollabel.setIcon(new ImageIcon(Gui.class.getResource("/natives/patrol.png")));
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
	baskarlabel.setIcon(new ImageIcon(Gui.class.getResource("/natives/bashkars.png")));
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
	lancerslabel.setIcon(new ImageIcon(Gui.class.getResource("/natives/lancers.png")));
	lancerslabel.setBounds(250, 350, 70, 50);
	lancerslabel.setName("LANCERS");
	lancerslabel.setVisible(false);
	container.add(lancerslabel);
	
	
	


	cheatbuttons[0] = new JButton("Dwellings");
	cheatbuttons[0].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "Please select the dwelling that you would like to place on the board");

			innLabel.setVisible(true);
			houseLabel.setVisible(true);
			guardLabel.setVisible(true);
			chapelLabel.setVisible(true);


		}
	});
	cheatbuttons[0].setBounds(50, 150, 100, 40);
	cheatbuttons[0].setVisible(true);
	container.add(cheatbuttons[0]);

	
	
	cheatbuttons[1] = new JButton("Player");
	cheatbuttons[1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(!isSelected())
				JOptionPane.showMessageDialog(null, "Please select a character first before placing players on the board");
			else activityCounter++;

			if(isSelected() && activityCounter == 1)
			placePlayer1(getPlayer1());

			if(isSelected() && activityCounter == 2){
				placePlayer2(getPlayer2());
				activityCounter = 0;
			}
		
		}
	});
	cheatbuttons[1].setBounds(50, 200, 100, 40);
	cheatbuttons[1].setVisible(true);
	container.add(cheatbuttons[1]);


	cheatbuttons[2] = new JButton("Warning Chits");
	cheatbuttons[2].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "Please select the Chit that you would like to place on the board");

			boneslabel.setVisible(true);
			danklabel.setVisible(true);
			ruinslabel.setVisible(true);
			smokelabel.setVisible(true);
			stinklabel.setVisible(true);

		
		}
	});
	cheatbuttons[2].setBounds(50, 250, 100, 40);
	cheatbuttons[2].setVisible(true);
	container.add(cheatbuttons[2]);

	
	cheatbuttons[3] = new JButton("Treasure Chits");
	cheatbuttons[3].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
		
		}
	});
	cheatbuttons[3].setBounds(50, 300, 100, 40);
	cheatbuttons[3].setVisible(true);
	container.add(cheatbuttons[3]);


	cheatbuttons[4] = new JButton("NATIVES");
	cheatbuttons[4].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Please select the Natives that you would like to place on the board");

			baskarlabel.setVisible(true);
			lancerslabel.setVisible(true);
			patrollabel.setVisible(true);
			woodfolklabel.setVisible(true);
			companylabel.setVisible(true);
		
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

public PlayerChit getP1chit(){
	return p1chit;
}

public PlayerChit getP2chit(){
	return p2chit;
}

public void setP1chit(PlayerChit pc){
	this.p1chit = pc;
}

public void setP2chit(PlayerChit pc){
	this.p2chit = pc;
}

}