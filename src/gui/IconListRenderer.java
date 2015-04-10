package gui;

import java.awt.Component;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

@SuppressWarnings("serial")
public class IconListRenderer extends DefaultListCellRenderer {
	private Map<Object, ImageIcon> characters = null;
	
	public IconListRenderer(Map<Object, ImageIcon> characters) {
		this.characters = characters;
	}
	
	@Override
	public Component getListCellRendererComponent(
		    @SuppressWarnings("rawtypes") JList list, Object value, int index,
		    boolean isSelected, boolean cellHasFocus) {
		// Get the renderer component from parent class

	    JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

	    // Get icon to use for the list item value
	    Icon i = characters.get(value);

	    // Set icon to display for value
	    label.setIcon(i);
	    
	    return label;
	}
}
