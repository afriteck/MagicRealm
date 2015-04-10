/**
 * 
 */
package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author joshwhite
 *
 */

public class Zoom extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -461244679110379744L;
	/**
	 * 
	 */
	
	private HexCell cell;


	public Zoom(HexCell cell) {
		// TODO Auto-generated constructor stub
		this.cell=cell;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		cell.drawBig(g2);
	}

	public Dimension getPreferredSize() {
		return new Dimension(1000, 900);
	}

	public static void showTile(HexCell cell) {
		Zoom test = new Zoom(cell);
		JFrame f = new JFrame();
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(test);
		f.pack();
		f.setLocation(50, 100);
		f.setVisible(true);
	}

}