package gui;

import gameLogic.GuiActivities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Armor;
import models.Counters;
import models.Player;
import models.Weapons;

public class CombatScreen {
	private boolean inCombat;
	public JButton fight, move, submitStats;
	public JPanel currPlayerDetails, characterActive, characterActiveCounter,
			characterActiveWeapons, characterActiveArmor, characterFatigued,
			characterFatiguedCounter, characterFatiguedWeapons,
			characterFatiguedArmor, btnPanel;
	public ArrayList<Counters> characterReadyCounters, characterFatigueCounters;
	public ArrayList<Armor> characterArmor;
	public ArrayList<Weapons> characterWeapons;

	public CombatScreen(final GuiActivities gm) {
		characterReadyCounters = gm.getPlayer1()
				.getCharacter().getReadyCounter();
		characterFatigueCounters = gm.getPlayer1()
				.getCharacter().getFatiguedCounter();
		characterArmor = gm.getPlayer1().getCharacter()
				.getCharacterArmory();
		characterWeapons = gm.getPlayer1().getCharacter()
				.getMyweapons();
		Box readyList, fatigueList, armorList, weaponsList;

		readyList = Box.createVerticalBox();

		fatigueList = Box.createVerticalBox();

		armorList = Box.createVerticalBox();

		weaponsList = Box.createVerticalBox();

		if(characterReadyCounters != null) {
			for (int i = 0; i < characterReadyCounters.size(); i += 1) {
				characterReadyCounters.get(i);
				JLabel holder = new JLabel(characterReadyCounters.get(i)
						.getDetails());
				holder.setSize(new Dimension(960, 520));
				readyList.add(holder);
			}	
		}
		
		if(characterFatigueCounters != null) {
			for (int i = 0; i < characterFatigueCounters.size(); i += 1) {
				characterFatigueCounters.get(i);
				JLabel holder = new JLabel(characterFatigueCounters.get(i)
						.getDetails());
				fatigueList.add(holder);
			}
		}
		
		if(characterArmor != null) {
			for (int i = 0; i < characterArmor.size(); i += 1) {
				characterArmor.get(i);
				JLabel holder = new JLabel(characterArmor.get(i).getName());
				armorList.add(holder);
			}	
		}
		
		if(characterWeapons != null) {
			for (int i = 0; i < characterWeapons.size(); i += 1) {
				characterWeapons.get(i);
				JLabel holder = new JLabel(characterWeapons.get(i).getName());
				weaponsList.add(holder);
			}	
		}		

		// Current character's active items
		characterActiveCounter = new JPanel();
		characterActiveCounter.setBorder(BorderFactory
				.createTitledBorder("Character Counters"));
		characterActiveCounter.add(readyList);

		characterActiveWeapons = new JPanel();
		characterActiveWeapons.setBorder(BorderFactory
				.createTitledBorder("Character Weapon(s)"));
		characterActiveWeapons.add(weaponsList);

		characterActiveArmor = new JPanel();
		characterActiveArmor.setBorder(BorderFactory
				.createTitledBorder("Character Armor"));
		characterActiveArmor.add(armorList);

		characterActive = new JPanel();
		characterActive.setPreferredSize(new Dimension(860, 500));
		characterActive.setBorder(BorderFactory.createTitledBorder("Active"));
		characterActive.setLayout(new BoxLayout(characterActive,
				BoxLayout.Y_AXIS));
		characterActive.add(characterActiveCounter);
		characterActive.add(characterActiveWeapons);
		characterActive.add(characterActiveArmor);

		// Current character's fatigued items
		characterFatiguedCounter = new JPanel();
		characterFatiguedCounter.setBorder(BorderFactory
				.createTitledBorder("Character Fatigued Counters"));
		characterFatiguedCounter.add(fatigueList);

		characterFatigued = new JPanel();
		characterFatigued.setPreferredSize(new Dimension(860, 500));
		characterFatigued.setBorder(BorderFactory
				.createTitledBorder("Fatigued"));
		characterFatigued.setLayout(new BoxLayout(characterFatigued,
				BoxLayout.Y_AXIS));
		characterFatigued.add(characterFatiguedCounter);

		currPlayerDetails = new JPanel(new FlowLayout());
		currPlayerDetails.setBackground(Color.LIGHT_GRAY);
		currPlayerDetails.setPreferredSize(new Dimension(1720, 1000));
		currPlayerDetails.add(characterActive);
		currPlayerDetails.add(characterFatigued);

		// Buttons JPanel
		btnPanel = new JPanel();
		btnPanel.setBackground(Color.LIGHT_GRAY);
		btnPanel.setPreferredSize(new Dimension(200, 1000));

		move = new JButton("Place Move Chit");
		
		fight = new JButton("Place Fight Chit");
		
		submitStats = new JButton("Submit");
		
		JFrame frame1 = new JFrame();
		frame1.add(currPlayerDetails, BorderLayout.WEST);
		frame1.add(btnPanel, BorderLayout.EAST);

		// Display the window.
		frame1.setSize(new Dimension(1920, 1040));
		frame1.pack();
		frame1.setVisible(true);
	}
}
