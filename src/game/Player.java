package game;

import java.util.LinkedList;

import javax.swing.JTextArea;

public class Player {

	    private String playerName;
	    private Things character;
	    private Income income;  
	    private String url;
	    private int gold;   // amount of gold that the player possesses. 
	    private LinkedList<Things> characterStack;    // the players stack

	    
	    
	    
	    public Player(String name, Income i, LinkedList<Things> t, String u) {
	        
	        playerName = name;
	        setIncome(i);
	        setPlayerCharacters(t);
	        url = u;    
	    }

	    public Player(String name){
	        playerName = name;
	    }

	    public Player(){
	    }


		
	    
	    
	    public void initializePlayer(int g, LinkedList<Things> t, String u){
	        
	        setPlayerCharacters(t);
	        setGold(g);
	        setUrl(u);
	         
	    }
	     
	     
	    public String getName() { return playerName; }
	     
	    public void setName(String playerName){
	        this.playerName = playerName;
	    }
	     
	    public Income getIncome() {
	        return income;
	    }
	     
	    public void setIncome(Income income) {
	        this.income = income;
	    }
	         
	     
	    public LinkedList<Things> getPlayerCharacters() {
	        return characterStack;
	    }
	     
	    public void setPlayerCharacters(LinkedList<Things> playerStack) {
	        this.characterStack = playerStack;
	    }
	     
	      
	    public int getGold() {
	        return gold;
	    }
	     
	    public void setGold(int gold) {
	        this.gold = gold;
	    }
	     
	    public String getUrl() {
	        return url;
	    }
	     
	    public void setUrl(String url) {
	        this.url = url;
	    }
	         
	    public void chooseCharacters(LinkedList<Things> characterstack, Things playercharacter){
	     
	        this.characterStack= characterstack;
	        this.character = playercharacter;
	         
	        characterStack.add(playercharacter);
	     
	    }
	     
	    public void calculateIncome(){
	         
	        setGold(getGold());
	         
	    }
	     
	    // toString() method for the player object
	     
	    public void toString(JTextArea t){
	         
	         
	         
	        t.append("\n----------------------------------\n" + playerName + " has " + gold + " gold.\n");
	         
	        t.append(playerName + " owns the following Characters:\n");
	         
	        for (int i=0; i<characterStack.size(); i++) t.append(characterStack.get(i).getName() + "\n");
	         
	        t.append("----------------------------------\n");
	         
	    }




























}
