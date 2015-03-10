package models;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public interface Move {



	public void moveFrom(String tile, int clearing);
	public void moveTo(String tile, int clearing);
	//public void moveActivity(Player p, ActionEvent e);
		

}
