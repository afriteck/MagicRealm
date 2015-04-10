package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

public class GUIConfig {
	// File path starter, so that don't need to have first part of direct path
	// everywhere
	// public static final String FILE_PATH_STARTER =
	// "C:/Users/Hassan/workspace/Magic Realm/src/";
	public static final String FILE_PATH_STARTER = "Z:/eclipse-Juno-Workspace/MagicRealm/src/";
	// Get dimensions of screen to always center frames
	public static final Dimension dim = Toolkit.getDefaultToolkit()
			.getScreenSize();
	public static final int HALF_DIMENSION_WIDTH = dim.width / 2;
	public static final int HALF_DIMENSION_HEIGHT = dim.height / 2;

	// Set the game title
	public static final String DEFAULT_GAME_TITLE = "MAGIC REALM";

	// Set the main game background
	public static final String DEFAULT_GAME_BACKGROUND = FILE_PATH_STARTER
			+ "others/background_1.png";

	// Set the defaults for the start menu
	public static final String DEFAULT_START_MENU_BACKGROUND = FILE_PATH_STARTER
			+ "others/background.jpg";
	public static final int DEFAULT_START_MENU_WIDTH = 250;
	public static final int DEFAULT_START_MENU_HEIGHT = 400;
	public static final String DEFAULT_START_GAME_BUTTON = "New Game";
	public static final String DEFAULT_EXIT_GAME_BUTTON = "Exit Game";

	// Set the defaults for the character selection frame
	public static final int DEFAULT_SELECTION_MENU_WIDTH = 1400;
	public static final int DEFAULT_SELECTION_MENU_HEIGHT = 600;

	// Set default character names and file paths list for character selection
	public static final ArrayList<String> DEFAULT_CHARACTER_NAMES = new ArrayList<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4782327227256278106L;

		{
			add("Default");
			add("Amazon");
			add("Black Knight");
			add("Captain");
			add("Dwarf");
			add("Elf");
			add("Swordsman");
		}
	};
	public static final HashMap<String, String> DEFAULT_CHARACTER_SYMBOLS = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7713488512154151179L;

		{
			put(DEFAULT_CHARACTER_NAMES.get(0), FILE_PATH_STARTER
					+ "characters/default.png");
			put(DEFAULT_CHARACTER_NAMES.get(1), FILE_PATH_STARTER
					+ "characters/amazon.png");
			put(DEFAULT_CHARACTER_NAMES.get(2), FILE_PATH_STARTER
					+ "characters/black_knight.png");
			put(DEFAULT_CHARACTER_NAMES.get(3), FILE_PATH_STARTER
					+ "characters/captain.png");
			put(DEFAULT_CHARACTER_NAMES.get(4), FILE_PATH_STARTER
					+ "characters/dwarf.png");
			put(DEFAULT_CHARACTER_NAMES.get(5), FILE_PATH_STARTER
					+ "characters/elf.png");
			put(DEFAULT_CHARACTER_NAMES.get(6), FILE_PATH_STARTER
					+ "characters/swordsman.png");
		}
	};
	public static final HashMap<String, String> DEFAULT_CHARACTER_DETAILS = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 509723662680171066L;

		{
			put(DEFAULT_CHARACTER_NAMES.get(0), FILE_PATH_STARTER
					+ "characterdetails/default.jpg");
			put(DEFAULT_CHARACTER_NAMES.get(1), FILE_PATH_STARTER
					+ "characterdetails/amazon.jpg");
			put(DEFAULT_CHARACTER_NAMES.get(2), FILE_PATH_STARTER
					+ "characterdetails/black_knight.jpg");
			put(DEFAULT_CHARACTER_NAMES.get(3), FILE_PATH_STARTER
					+ "characterdetails/captain.jpg");
			put(DEFAULT_CHARACTER_NAMES.get(4), FILE_PATH_STARTER
					+ "characterdetails/dwarf.jpg");
			put(DEFAULT_CHARACTER_NAMES.get(5), FILE_PATH_STARTER
					+ "characterdetails/elf.jpg");
			put(DEFAULT_CHARACTER_NAMES.get(6), FILE_PATH_STARTER
					+ "characterdetails/swordsman.jpg");
		}
	};

	// User details panel defaults. The user details panel is used to gather
	// important details
	// such as the name the player would like to use in the game, as provide
	// notes such as how to
	// open the game menu so that the player can pause, exit, etc the game
	public static final String DEFAULT_INFO_PROMPT_LABEL = "Please enter your name: ";
	public static final String DEFAULT_NOTES_LABEL = "** Press F10 to bring up the game menu **";
	public static final String DEFAULT_SUBMIT_PLAYER_DETAILS_BTN = "Submit Player Details";
}
