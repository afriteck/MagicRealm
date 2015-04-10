package models;

import javax.swing.JOptionPane;

import natives.Native;

public class Entity{

	private int xPos, yPos; // used to keep track of the entity's position on the board
	private String imgFilePath; // used to show image file for entity 
	private int entityNum; // used to uniquely identify a character
	private String entityName; // used for entity name
	
	/***** Getter Methods *****/
	// Get the entity's x position on the board
	public int getxPos() {
		return xPos;
	}
	
	// Get the entity's y position on the board
	public int getyPos() {
		return yPos;
	}
	
	// Get the entity's image
	public String getImgFilePath() {
		return imgFilePath;
	}
	
	// Get entity number
	public int getEntityNum() {
		return entityNum;
	}
	
	// Get the entity's name
	public String getEntityName() {
		return entityName;
	}
	
	/***** Setter Methods *****/
	// Set the entity's x position on the board
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	
	// Set the entity's y position on the board
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	// Set the entity's image
	public void setImgFilePath(String imgFilePath) {
		this.imgFilePath = imgFilePath;
	}
	
	// Set the entity's unique identifying number
	public void setEntityNum(int entityNum) {
		this.entityNum = entityNum;
	}

	// Set the entity's name
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	
	
	
}
