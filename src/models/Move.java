package models;

public interface Move {



	public void moveFrom(String tile, int clearing, int posX, int posY);
	public void moveTo(String tile, int clearing, int posX, int posY);
	

}
