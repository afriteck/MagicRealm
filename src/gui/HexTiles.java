/**
 * 
 */
package gui;

/**
 * @author joshwhite
 *
 */

import gameLogic.BoardTiles;
import gameLogic.Iteration1Board;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import models.Tiles;
 
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
    //boolean tipHigh      = false;
    boolean zoomOut    = true;
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
    /*
    public static void placeCharacter(String tilename, int tileclearing){
    	for(int i=0; i<20; i++){
    		if(cells[i].tilehex.getName().equals(tilename)){cells[i].setPlayerImg(tileclearing);}
    	}
    }
    */
    public static void placeTile(int hexIndex, Tiles tile, int rotation){
		tile.setTheta(rotation);
		cells[hexIndex].setTile(tile);
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
        double w = getWidth();
        double h = getHeight();
        double R = Math.min(w,h)/7;
        MIN_DIST = R/4;
        if(debug && firstTime)
            System.out.printf("w = %.1f  h = %.1f  R = %.1f%n", w, h, R);
        double delta = (1.0 - scale)/2;
        Image img = Toolkit.getDefaultToolkit().getImage(  
                HexTiles.class.getResource("/others/background_1.png"));  
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
            System.out.printf("bounds = [%.1f, %.1f, %.1f, %.1f]%n",
                               bounds.getX(), bounds.getY(),
                               bounds.getWidth(), bounds.getHeight());
        double radius = Math.min(bounds.getWidth(), bounds.getHeight());
        if(debug && firstTime)
            System.out.printf("radius = %f%n", radius);
        List<Point2D.Double> list =
                getAllPoints(bounds.getCenterX(),
                             bounds.getCenterY(), radius, range);
        if(debug && firstTime)
            System.out.printf("list size = %d%n", list.size());
        cells = new HexCell[list.size()];
        // For HexCell to find the side that starts at zero degrees.
        double theta = /*tipHigh ? -Math.PI/6 :*/ 0;
        /*
        JSONParser parser = new JSONParser();
		long xPos, yPos;
		ArrayList<Clearing> clearingList = null;
		Clearing currClearing;
		Tiles tile = null;
				
		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("/Z:/eclipse-Juno-Workspace/MagicRealm/bin/res/data.json"));
			
			for(Object o : a) {
				JSONObject currTile = (JSONObject) o;
				clearingList = new ArrayList<Clearing>();
				
				String tileName = (String) currTile.get("tileName");
				
				String tileFileName = (String) currTile.get("fileName");
								
				JSONObject clearings = (JSONObject) currTile.get("numbers");
								
				for(int i = 0; i <=6; i++) {
					if(clearings.containsKey(Integer.toString(i))) {
						JSONObject clearingNum = (JSONObject) clearings.get(Integer.toString(i));
						xPos = (long) clearingNum.get("x");
						yPos = (long) clearingNum.get("y");

						currClearing = new Clearing(i, xPos, yPos);
						clearingList.add(currClearing);
					}
				}
				tile = new Tiles(tileName, tileFileName, clearingList);
				bt.addTile(tile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//System.out.println(bt);
        for(int i = 0; i < list.size(); i++) {
            String id = String.valueOf(i);
            Point2D.Double p = list.get(i);
            double x = p.x - w/2;
            double y = p.y - h/2;
            AffineTransform at =
                    AffineTransform.getTranslateInstance(x, y);
            Shape s = at.createTransformedShape(path);
            String[] adjacentIds = getNeighbors(i, radius, list);
            
            //img = Toolkit.getDefaultToolkit().getImage(HexTiles.class.getResource("/" + bt.getFileName(i)));
				//System.out.println("adding image");
                

            //cells[i] = new HexCell(id, p, s, showIndex, theta, adjacentIds, bt.getTile(i));
            cells[i] = new HexCell(id, p, s, showIndex, theta, adjacentIds);
        }
        Iteration1Board.it1Board(bt);
        
        /*
        //cells[0].setImg(Toolkit.getDefaultToolkit().getImage(HexTiles.class.getResource("/" + cells[0].tilehex.getFilePath())));
        cells[0].setTile(bt.getTile("OAK WOODS"));
        cells[0].tilehex.setTheta(60);
        //System.out.println("/" + cells[0].tilehex.getName());
        try {
        	URL url = BoardTest.class.getResource("/" + cells[0].tilehex.getFilePath());
			cells[0].setImg(ImageIO.read(new File(url.getPath())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        cells[2].setTile(bt.getTile("CAVES"));
        cells[2].tilehex.setTheta(180);
        //System.out.println("/" + cells[0].tilehex.getName());
        try {
        	URL url = BoardTest.class.getResource("/" + cells[2].tilehex.getFilePath());
			cells[2].setImg(ImageIO.read(new File(url.getPath())));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
    }
    
 
    private String[] getNeighbors(int index, double radius,
                                  List<Point2D.Double> list) {
        // Collect neighbors clockwise starting at zero degrees.
        String[] ids = new String[SIDES];
        double thetaInc = /*tipHigh ? Math.PI/3 :*/ Math.PI/6;
        Point2D.Double center = list.get(index);
        // Make ellipse larger to include the points we're
        // looking for so we can use the intersects method.
        radius += 1;
        Ellipse2D.Double e = new Ellipse2D.Double(center.x-radius,
                                                  center.y-radius,
                                                  2*radius, 2*radius);
        for(int i = 0; i < list.size(); i++) {
            if(i == index) continue;
            Point2D.Double p = list.get(i);
            if(e.contains(p)) {
                // Get bearing to p.
                double phi = Math.atan2(p.y-center.y, p.x-center.x);
                // Avoid case of -0.0 for negative phi.
                if(phi < 0.0 && phi < -0.0001) phi += 2*Math.PI;
                // Index into array found with thetaInc.
                int j = (int)Math.round(phi/thetaInc);
               /* if(!tipHigh)*/ j /= 2;
                if(j < 0) j += 5;
                if(j < ids.length) {
                    ids[j] = String.valueOf(i);
                }
            }
        }
        return ids;
    }
 
    private List<Point2D.Double> getAllPoints(double cx, double cy,
                                              double radius,
                                              Rectangle range) {
        Point2D.Double center = new Point2D.Double(cx, cy);
        List<Point2D.Double> list = new ArrayList<Point2D.Double>();
        list.add(center);
        Point2D.Double[] points = { new Point2D.Double(cx, cy) };
        List<Point2D.Double> subList = null;
        do {
            List<Point2D.Double> nextPoints = new ArrayList<Point2D.Double>();
            for(int i = 0; i < points.length; i++) {
                subList = getPoints(points[i].x, points[i].y,
                                    radius, range, center);
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
 
    private List<Point2D.Double> getPoints(double cx, double cy,
                                           double radius, Rectangle r,
                                           Point2D.Double center) {
        List<Point2D.Double> list = new ArrayList<Point2D.Double>();
        double minDist = center.distance(cx, cy);
        for(int i = 0; i < SIDES; i++) {
            double theta = i*Math.PI/3;
            /*if(!tipHigh)*/ theta += Math.PI/6;
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
        double theta = /*tipHigh ? -Math.PI/2 :*/ thetaInc;
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
        String[] ids = {/* "Show Index", "tip high",*/ "zoom out" };
        boolean[] state = {/* showIndex, tipHigh,*/ zoomOut };
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
                } else {/*
                    if(id.equals("tip high")) {
                        tipHigh = selected;
                    }*/
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
 /*
    public static void main(String[] args) {
        if(args.length > 0)
            debug = args[0].equals("-d");
        HexTiles test = new HexTiles(BoardTest.initializeTiles());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test);
        f.add(test.getControls(), "Last");
        f.pack();
        f.setLocation(100,100);
        f.setVisible(true);
        test.addMouseListener(test.switcher);
        test.addComponentListener(test.resizeMonitor);
    }
    */
    public static void initGameBoard(BoardTiles bd) {
        HexTiles test = new HexTiles(bd);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
/* 
class HexCell {
    String id;
    Point2D.Double center;
    Shape shape;
    boolean showIndex;
    double start;
    String[] neighbors;
    boolean isSelected = false;
    BufferedImage tileimg;
    BufferedImage rotated;
    Tiles tilehex;
    //List<Point2D.Double> clearingList = new ArrayList<Point2D.Double>();
    
    
 
    public HexCell(String id, Point2D.Double center, Shape shape,
                   boolean showCenter, double start, String[] neighbors, Tiles tile) {
        this.id = id;
        this.center = center;
        this.shape = shape;
        this.showIndex = showCenter;
        this.start = start;
        this.neighbors = neighbors;
        this.tilehex = tile;
        try {
			this.tileimg = ImageIO.read(new File("/Z:/eclipse-Juno-Workspace/MagicRealm/src/" + tilehex.getFilePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //rotateTile();
    }
    
    public HexCell(String id, Point2D.Double center, Shape shape,
        boolean showCenter, double start, String[] neighbors) {
		this.id = id;
		this.center = center;
		this.shape = shape;
		this.showIndex = showCenter;
		this.start = start;
		this.neighbors = neighbors;
		}
    
    public void setImg(BufferedImage img){
    	tileimg = img;
    	//rotateTile();
    }
    
    public void setTile(Tiles tile){
    	tilehex = tile;
    }
    
    public void rotateTile() {
    	
    	if(tilehex != null && tileimg != null){
    		double angle = tilehex.getTheta();
    	
	        int w = tileimg.getWidth();
	        int h = tileimg.getHeight();
	        
	        rotated = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2d = rotated.createGraphics();
	        AffineTransform at = new AffineTransform();
	        at.translate((w / 2), (h / 2));
	
	        at.rotate(Math.toRadians(angle));
	        at.translate((-w / 2), (-h / 2));
	        g2d.setTransform(at);
	        
	        g2d.drawImage(tileimg, 0, 0, null);

            tileimg = rotated;
            System.out.println("rotated " + angle);
            g2d.dispose();
    	}
    }
 
    public void draw(Graphics2D g2) {
        if(showIndex) {
            g2.setPaint(Color.red);
            g2.fill(new Ellipse2D.Double(center.x-1.5, center.y-1.5, 4, 4));
            g2.drawString(id, (float)(center.x+3), (float)(center.y+3));
            g2.setPaint(Color.black);
        }
        if(tilehex != null){g2.draw(shape);
        /*
        BufferedImage scaled = new BufferedImage(tileimg.getWidth() / 2, tileimg.getHeight() / 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaled.createGraphics();
        g2d.setTransform(AffineTransform.getScaleInstance(0.5d, 0.5d));
        g2d.drawImage(tileimg, 0, 0, null);
        g2d.dispose();
        tileimg = scaled;
        setAngle(0d);
        */
        // Save the current transform of the graphics contexts.
        //AffineTransform saveTransform = g2.getTransform();
        // Create a identity affine transform, and apply to the Graphics2D context
        //AffineTransform identity = new AffineTransform();
        //g2.setTransform(identity);
        //g2.translate(shape.getBounds().x, shape.getBounds().y);
        
        /*if(tilehex != null){
	        switch (tilehex.getTheta()) {
				case 0:  g2.rotate(Math.toRadians(0));
		        case 60:  g2.rotate(Math.toRadians(60));
		        case 120:  g2.rotate(Math.toRadians(120));
		        case 180:  g2.rotate(Math.toRadians(180));
		        case 240:  g2.rotate(Math.toRadians(240));
		        case 300:  g2.rotate(Math.toRadians(300));
		        default: 
			}
        }
        //rotateTile();
	        if(tilehex != null && tileimg != null){
	    		double angle = tilehex.getTheta();
	    	
		        int w = tileimg.getWidth();
		        int h = tileimg.getHeight();
		        
		        rotated = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		        Graphics2D g2d = rotated.createGraphics();
		        AffineTransform at = new AffineTransform();
		        at.translate((w / 2), (h / 2));
		
		        at.rotate(Math.toRadians(angle));
		        at.translate((-w / 2), (-h / 2));
		        g2d.setTransform(at);
		        
		        g2d.drawImage(tileimg, 0, 0, null);
		        Shape cl = null;
		        BufferedImage chitimg = null;
		        for(int i=0; i<tilehex.getClearings().size(); i++){
		        	//g2d.draw(new Ellipse2D.Double((tilehex.getClearings().get(i).getXposition()), (tilehex.getClearings().get(i).getYposition()), 80, 80));
		        	//chitimg = ImageIO.read(new File("/Z:/eclipse-Juno-Workspace/MagicRealm/src/" + tilehex.getClearings().get(i).getSoundChits().get(i).getFilePath()));
		        	cl = at.createTransformedShape(new Ellipse2D.Double((tilehex.getClearings().get(i).getXposition() - 40), (tilehex.getClearings().get(i).getYposition() - 40), 80, 80));
		        	g2d.drawImage(chitimg, tilehex.getClearings().get(i).getXposition() - 40, tilehex.getClearings().get(i).getYposition() - 40, cl.getBounds().width, cl.getBounds().height, null);
		        }

		        //g2d.draw(new Ellipse2D.Double(center.x-1.5, center.y-1.5, 30, 30));
		        g2.drawImage(rotated, shape.getBounds().x, shape.getBounds().y, shape.getBounds().width, shape.getBounds().height, null);
		        //g2.draw(c1);
	            //tileimg = rotated;
	            System.out.println("rotated " + angle);
	            g2d.dispose();
	    	}
	        //g2.drawImage(tileimg, shape.getBounds().x, shape.getBounds().y, shape.getBounds().width, shape.getBounds().height, null);
	        //g2.draw(new Ellipse2D.Double(center.x-1.5, center.y-1.5, 30, 30));
        }
        
        
        //g2.setTransform(saveTransform);
        
        if(isSelected) {
        	System.out.println(tilehex);
        	toggleSelection();
        }
    }
 
    public void setShowIndex(boolean show) { showIndex = show; }
 
    public void toggleSelection() { isSelected = !isSelected; }
 
    public boolean contains(Point p) {
        return shape.contains(p);
    }
 
    public String toString() {
        return "HexCell[id:" + id + ", neighbors:" +
                        Arrays.toString(neighbors) + "]";
    }
}
*/