/**
 * 
 */
package gui;

/**
 * @author joshwhite
 *
 */

import gameBoard.BoardTiles;
import gameBoard.Tiles;
import gameLogic.Iteration1Board;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

 
public class HexTiles extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8567918989120001764L;
	/**
	 * 
	 */
	final static int SIDES = 6;
    double MIN_DIST = 0;
    boolean showIndex  = false;
    boolean zoomOut    = false;
    static boolean debug = true;   // main method switch -d
    boolean firstTime    = true;
    static HexCell[] cells;
    double scale = 3/4.0;
    BoardTiles bt = new BoardTiles();
    
    public HexTiles(BoardTiles bd){
    	this.bt = bd;
    }
    
    public HexCell getHexCell(int i){
    	return cells[i];
    }

    public static void placeTile(int hexIndex, Tiles tile, int rotation){
		tile.setTheta(rotation);
		cells[hexIndex].setTile(tile);
		cells[hexIndex].tilehex.setId(cells[hexIndex].id);
		cells[hexIndex].tilehex.setNeighbours(cells[hexIndex].neighbors);
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        double w = getWidth();
        double h = getHeight();
        double R = Math.min(w,h)/7;
        MIN_DIST = R/4;
        if(debug && firstTime)
            System.out.printf("w = %.1f  h = %.1f  R = %.1f%n", w, h, R);
        double delta = (1.0 - scale)/2;
        Image img = Toolkit.getDefaultToolkit().getImage(HexTiles.class.getResource("/others/background_1.png"));  
        g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        if(zoomOut) {
            // Draw everything smaller to see all the cells.
            g2.translate(delta*w, delta*h);
            g2.scale(scale, scale);
        }
        Rectangle r = getBounds();
        r.grow((int)(R*3/4), (int)(R*3/4));
        if(cells == null) {
            initHexCells(w, h, R, r);
        }
        if(zoomOut) {
            g2.setPaint(Color.green.darker());
            //g2.draw(r);
            g2.setPaint(Color.blue);
            //g2.draw(getBounds());
        }
        g2.setPaint(Color.black);
        for(int i = 0; i < cells.length; i++) {
            cells[i].draw(g2);            
        }
        if(zoomOut) {
            g2.translate(-delta*w, -delta*h);
            g2.scale(1.0/scale, 1.0/scale);
        }
        firstTime = false;
    }
 
    public Dimension getPreferredSize() {
        return new Dimension(1400,800);
    }
 
    private void initHexCells(double w, double h, double R, Rectangle range) {
        Path2D.Double path = getPath(w/2, h/2, R);
        Rectangle2D bounds = path.getBounds2D();
        if(debug && firstTime)
            System.out.printf("bounds = [%.1f, %.1f, %.1f, %.1f]%n", bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        double radius = Math.min(bounds.getWidth(), bounds.getHeight());
        if(debug && firstTime)
            System.out.printf("radius = %f%n", radius);
        List<Point2D.Double> list = getAllPoints(bounds.getCenterX(), bounds.getCenterY(), radius, range);
        if(debug && firstTime)
            System.out.printf("list size = %d%n", list.size());
        cells = new HexCell[list.size()];
        // For HexCell to find the side that starts at zero degrees.
        double theta = 0;
  
        for(int i = 0; i < list.size(); i++) {
            String id = String.valueOf(i);
            Point2D.Double p = list.get(i);
            double x = p.x - w/2;
            double y = p.y - h/2;
            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            Shape s = at.createTransformedShape(path);
            String[] adjacentIds = getNeighbors(i, radius, list);
            cells[i] = new HexCell(id, p, s, showIndex, theta, adjacentIds);
        }
        Iteration1Board.it1Board(bt);
    }
    
 
    private String[] getNeighbors(int index, double radius,
                                  List<Point2D.Double> list) {
        // Collect neighbors clockwise starting at zero degrees.
        String[] ids = new String[SIDES];
        double thetaInc = Math.PI/6;
        Point2D.Double center = list.get(index);
        // Make ellipse larger to include the points we're
        // looking for so we can use the intersects method.
        radius += 1;
        Ellipse2D.Double e = new Ellipse2D.Double(center.x-radius, center.y-radius, 2*radius, 2*radius);
        for(int i = 0; i < list.size(); i++) {
            if(i == index) continue;
            Point2D.Double p = list.get(i);
            if(e.contains(p)) {
                // Get bearing to p.
                double phi = Math.atan2(p.y-center.y, p.x-center.x);
                // Avoid case of -0.0 for negative pi.
                if(phi < 0.0 && phi < -0.0001) phi += 2*Math.PI;
                // Index into array found with thetaInc.
                int j = (int)Math.round(phi/thetaInc);
                j /= 2;
                if(j < 0) j += 5;
                if(j < ids.length) {
                    ids[j] = String.valueOf(i);
                }
            }
        }
        return ids;
    }
 
    private List<Point2D.Double> getAllPoints(double cx, double cy, double radius, Rectangle range) {
        Point2D.Double center = new Point2D.Double(cx, cy);
        List<Point2D.Double> list = new ArrayList<Point2D.Double>();
        list.add(center);
        Point2D.Double[] points = { new Point2D.Double(cx, cy) };
        List<Point2D.Double> subList = null;
        do {
            List<Point2D.Double> nextPoints = new ArrayList<Point2D.Double>();
            for(int i = 0; i < points.length; i++) {
                subList = getPoints(points[i].x, points[i].y, radius, range, center);
                for(int j = 0; j < subList.size(); j++) {
                    Point2D.Double p = subList.get(j);
                    if(!haveCloseEnoughPoint(p, list)) {
                        list.add(p);
                        nextPoints.add(p);
                    }
                }
            }
            points = nextPoints.toArray(new Point2D.Double[nextPoints.size()]);
        } while(points.length > 0);
 
        return list;
    }
 
    private List<Point2D.Double> getPoints(double cx, double cy, double radius, Rectangle r, Point2D.Double center) {
        List<Point2D.Double> list = new ArrayList<Point2D.Double>();
        double minDist = center.distance(cx, cy);
        for(int i = 0; i < SIDES; i++) {
            double theta = i*Math.PI/3;
            theta += Math.PI/6;
            double x = cx + radius*Math.cos(theta);
            double y = cy + radius*Math.sin(theta);
            double distance = center.distance(x, y);
            if(r.contains(x, y) && distance > minDist) {
                list.add(new Point2D.Double(x, y));
            }
        }
        return list;
    }
 
    private boolean haveCloseEnoughPoint(Point2D.Double p, List<Point2D.Double> list) {
        for(int i = 0; i < list.size(); i++) {
            Point2D.Double next = list.get(i);
            if(next.distance(p) < MIN_DIST) {
                return true;
            }
        }
        return false;
    }
 
    private Path2D.Double getPath(double cx, double cy, double R) {
        Path2D.Double path = new Path2D.Double();
        double thetaInc = 2*Math.PI/SIDES;
        double theta = thetaInc;
        double x = cx + R*Math.cos(theta);
        double y = cy + R*Math.sin(theta);
        path.moveTo(x, y);
        for(int i = 0; i < SIDES; i++) {
            theta += thetaInc;
            x = cx + R*Math.cos(theta);
            y = cy + R*Math.sin(theta);
            path.lineTo(x, y);
        }
        return path;
    }
 
    private JPanel getControls() {
        String[] ids = { "Show Index", "zoom out" };
        boolean[] state = { showIndex, zoomOut };
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = e.getActionCommand();
                boolean selected = ((JCheckBox)e.getSource()).isSelected();
                if(id.equals("Show Index")) {
                    showIndex = selected;
                    for(int i = 0; i < cells.length; i++) {
                        cells[i].setShowIndex(selected);
                    }
                    repaint();
                } else {
                    if(id.equals("zoom out")) {
                        zoomOut = selected;
                    }
                    reset();
                }
            }
        };
        JPanel panel = new JPanel();
        for(int i = 0; i < ids.length; i++) {
            JCheckBox cb = new JCheckBox(ids[i], state[i]);
            cb.setActionCommand(ids[i]);
            cb.addActionListener(al);
            panel.add(cb);
        }
        return panel;
    }
    
    public static void initGameBoard(BoardTiles bd) {
        HexTiles test = new HexTiles(bd);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.add(test);
        f.add(test.getControls(), "Last");
        f.pack();
        f.setLocation(35,180);
        f.setVisible(true);
        test.addMouseListener(test.switcher);
        test.addComponentListener(test.resizeMonitor);
    }
 
    public void reset() {
        cells = null;
        firstTime = true;
        repaint();
    }
 
    private MouseListener switcher = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            if(zoomOut) {
                double cx = getWidth()/2.0;
                double cy = getHeight()/2.0;
                double x = cx + (p.x - cx)/scale;
                double y = cy + (p.y - cy)/scale;
                p.setLocation((int)x, (int)y);
            }
            for(int i = 0; i < cells.length; i++) {
                if(cells[i].contains(p)) {
                    cells[i].toggleSelection();
                    break;
                }
            }
            repaint();
        }
    };
 
    private ComponentListener resizeMonitor = new ComponentAdapter() {
        public void componentResized(ComponentEvent e) {
            reset();
        }
    };
}
