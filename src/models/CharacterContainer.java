package models;

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
    	 
    	Things Amazon = new Amazon();
        charactercontainer.add(Amazon);
 
        Things Captain = new Captain();
        charactercontainer.add(Captain);
        
        
        Things Elf = new Elf();
        charactercontainer.add(Elf);
 
        Things Dwarf = new Dwarf();
        charactercontainer.add(Dwarf);
 
        Things Swordsman = new Swordsman();
        charactercontainer.add(Swordsman);
 
        Things BlackKnight = new BlackKnight();
        charactercontainer.add(BlackKnight);

    }


}
