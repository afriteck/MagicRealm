package models;

import gameLogic.Dice;

import java.util.LinkedList;

import javax.swing.JTextArea;


public class Player {

	    private String playerName;
	    private GameCharacters character;
	    private Income income;  
	    private String url;
	    private int gold;   // amount of gold that the player possesses. 
	    private LinkedList<GameCharacters> characterStack;    // the players stack
	    private Dice playerDie;
	    private boolean dieBool = false;
	    
		public Player(String name, Income i, LinkedList<GameCharacters> t, String u) {
			playerName = name;
	        setIncome(i);
	        setPlayerCharacters(t);
	        url = u;   
	    }

	    public Player(String name){
	        playerName = name;
	        playerDie = new Dice();
	    }

	    public Player(){
	        playerDie = new Dice();
	    }

	    public void initializePlayer(int g, LinkedList<GameCharacters> t, String u){
	    	setPlayerCharacters(t);
	        setGold(g);
	        setUrl(u);
	    }
	    
	    
	    /***** Getter Methods *****/
	    // Get current player die roll
	    public Dice getPlayerDie(){ return playerDie; }
	    
	    // Get the current player name
	    public String getName() { return playerName; }
	    
	    // Get current player income
	    public Income getIncome() { return income; }
	    
	    // Get current player gold
	    public int getGold() { return gold; }
	    
	    // Get current tile player is on
	    public String getUrl() { return url; }
	    
	    // Get current player's die roll
	    public boolean getDieBool(){ return dieBool; }
	    
	    public LinkedList<GameCharacters> getPlayerCharacters() { return characterStack; }
	    
	    /***** Setter Methods *****/
	    // Set the current player name
	    public void setName(String playerName){ this.playerName = playerName; }
	    
	    // Set the current player income
	    public void setIncome(Income income) { this.income = income; }
	    
	    // Set the current player gold
	    public void setGold(int gold) { this.gold = gold; }
	    
	    // Set current tile player is on
	    public void setUrl(String url) { this.url = url; }
	    
	    // Set current player's die roll to highest roll
	    public void setDieBool(boolean foo){ dieBool = foo; }
	    
	    public void setPlayerCharacters(LinkedList<GameCharacters> playerStack) { this.characterStack = playerStack; }
	         
	    public void chooseCharacters(LinkedList<GameCharacters> characterstack, GameCharacters playercharacter){
	    	this.characterStack= characterstack;
	        this.character = playercharacter;
	         
	        characterStack.add(playercharacter);
	    }
	     
	    public void calculateIncome(){ setGold(getGold()); }
	    
	    public void toString(JTextArea t){
	    	t.append("\n----------------------------------\n" + playerName + " has " + gold + " gold.\n");
	        t.append(playerName + " owns the following Characters:\n");
	        
	        for (int i = 0; i < characterStack.size(); i++)
	        	t.append(characterStack.get(i).getName() + "\n");
	         
	        t.append("----------------------------------\n"); 
	    }
}