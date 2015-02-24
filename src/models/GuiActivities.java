package models;

import gameLogic.BoardTiles;
import gui.BoardTest;
import gui.Gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.WarningChit.Bones;
import models.WarningChit.Dank;
import models.WarningChit.Ruins;
import models.WarningChit.Smoke;
import models.WarningChit.Stink;

public class GuiActivities {

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
    	/* String activity2 = e.getActionCommand();
    	 String activity3 = e.getActionCommand();
    	 String activity4 = e.getActionCommand();
    	 String activity5 = e.getActionCommand();
    	 String activity6 = e.getActionCommand();
    	 String activity7 = e.getActionCommand();

    	
    	 if(n == 5)
	    	 p1choiceOrder.add(activity5);
    	 if(n == 4)
	    	 p1choiceOrder.add(activity2);

		if(n == 3)
	    	 p1choiceOrder.add(activity3);
		
		if(n == 2)
	    	 p1choiceOrder.add(activity7);

		
		if(n == 1)
	    	 p1choiceOrder.add(activity4);
		
		if(n == 0)
	    	 p1choiceOrder.add(activity6);
		*/
		
		

		
		
    	 
    	 
    	 
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
public void requestMove(){
	
	int option = JOptionPane.showConfirmDialog(null, message, "MOVE!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		
		//BoardTiles bd = new BoardTiles(); 
		//bd = BoardTest.initializeTiles();
		
		
		
		String input = TileName.getText().toString().trim();
		bd.getTile(input);
		moveTiles.add(bd.getTile(input));
		System.out.println(bd.getTile(input).getName());		
		  if (TileName.getText().equals("h") && Clearing.getText().equals("h")) {	
	        System.out.println("Login successful");
	    } else {
	        System.out.println("login failed");
	    }
	} else {
	    System.out.println("Login canceled");
	}





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

public void requestHide(Things character){
	
	int option = JOptionPane.showConfirmDialog(null, null, "HIDE!", JOptionPane.OK_CANCEL_OPTION);

	if (option == JOptionPane.OK_OPTION) {

			character.setVisibility(true);
			System.out.println(character.getName() + " is now hidden from everybody");
	
		}else{
			character.setVisibility(true);
		}
	
	
}



}
