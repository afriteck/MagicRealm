package models;

import gameLogic.BoardTiles;
import gui.BoardTest;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

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

	 
	    BoardTiles bd; 
	    
	public GuiActivities(BoardTiles bd){
		
		this.bd=bd;
		//bd = new BoardTiles(); 
		//bd = BoardTest.initializeTiles();
		
		

	}


	public void activity(Player p, ActionEvent e, int n) {
		if(n > 0 && !moveAct){
				int dialogButton = JOptionPane.YES_NO_OPTION;
		    	int dialogResult = JOptionPane.showConfirmDialog (null, "ARE YOU SURE YOU WANT TO DO THIS ACTIVITY FOR THE DAY?","Alert",dialogButton);
		        if (dialogResult == JOptionPane.YES_OPTION){  
		           n--;
		        	// setActivityCounter(getActivityCounter()-1);
		            activityCounter--;
		            moveAct = true;
		            //requestMove();
		            
		        }
		        else if(!moveAct){
		        	n++;
		        	//setActivityCounter(getActivityCounter()+1);
		        	//activityCounter++;
		        	moveAct = false;
		        	JOptionPane.showMessageDialog(null, "PLEASE CHOOSE YOUR ACTIVITIES FOR THE DAY.");
		        	System.out.println("PLEASE CHOOSE YOUR ACTIVITIES FOR THE DAY.");
		        	activityCounter++;
		        	//activity(p,e,activityCounter);
		        }
				}
						else { 

				moveAct = false;
				//setActivityCounter(activityCounter);
				//System.out.println( "YOU HAVE USED ALL YOUR REQUIRED ACTIVITIES FOR THE DAY.");

		}	//getNextPlayer(currentPlayer);
					//movePlayer(currentPlayer, e);
		//if (getActivityCounter()== 0)
			
			//JOptionPane.showMessageDialog(null, "YOU HAVE USED ALL YOUR REQUIRED ACTIVITIES FOR THE DAY.");

			
			
			//if(moveAct & p == player2 & activityCounter  == 0){
		
			
			
			//if(moveAct & n  == 0){

				//moveAct = false;
			   // doneMove = true;
			    	//gui.txt.append("done activity choosing");
		        	//JOptionPane.showMessageDialog(gui.getContentPane(), "we are done here.");
		           // gui.move.setVisible(false);
		           // gui.hide.setVisible(false);
		            //gui.search.setVisible(false);
		            //gui.rest.setVisible(false);
		            //gui.trade.setVisible(false);
		//}
		//else{
		//	doneMove = false;
		//}

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

public void requestSearch(){
int option = JOptionPane.showConfirmDialog(null, message, "SEARCH!", JOptionPane.OK_CANCEL_OPTION);
	
	if (option == JOptionPane.OK_OPTION) {
		String input = TileName.getText().toString().trim();


		searchTiles.add(bd.getTile(input));
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
