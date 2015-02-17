package game;

import java.util.LinkedList;

public class CharacterContainer {

    private LinkedList<Things> charactercontainer = new LinkedList<Things>();


    public CharacterContainer(){}
    
    public LinkedList<Things> getCharacterContainer() {
        return charactercontainer;
    }
 
    public int getCharacterContainerSize(){
        return charactercontainer.size();
    }
    public Things getNextCharacter(){
 
        if (charactercontainer.isEmpty())
            return null;
        return charactercontainer.remove(0);
    }


    public void fillContainer(){
    	 
    	Things Amazon = new Things();
        charactercontainer.add(Amazon);
 
        Things Captain = new Things();
        charactercontainer.add(Captain);
        
        
        Things Elf = new Things();
        charactercontainer.add(Elf);
 
        Things Dwarf = new Things();
        charactercontainer.add(Dwarf);
 
        Things Swordsman = new Things();
        charactercontainer.add(Swordsman);
 
        Things BlackKnight = new Things();
        charactercontainer.add(BlackKnight);

    }


}
