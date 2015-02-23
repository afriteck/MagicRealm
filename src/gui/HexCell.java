/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;

import models.Tiles;
import models.WarningChit;

/**
 * @author joshwhite
 *
 */
public class HexCell {
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
        	URL url = BoardTest.class.getResource("/" + tilehex.getFilePath());
			this.tileimg = ImageIO.read(new File(url.getPath()));
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
    	try {
        	URL url = BoardTest.class.getResource("/" + tilehex.getFilePath());
			this.tileimg = ImageIO.read(new File(url.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
            //System.out.println("rotated " + angle);
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
        //g2.draw(shape);
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
        }*/
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
		        	if(tilehex.getClearings().get(i).getMonsterChits().size()>0){
		        		URL url = BoardTest.class.getResource("/monsters/" + tilehex.getClearings().get(i).getMonsterChits().get(0).getImgFilePath());
	        			try {
							chitimg = ImageIO.read(new File(url.getPath()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        		//System.out.println("adding warning chit pictures to board");
		        	/*
		        		if(tilehex.getWarnings() !=null){
		        			URL url = BoardTest.class.getResource("/monsters/" + tilehex.getWarnings().getUrl());
		        			try {
								chitimg = ImageIO.read(new File(url.getPath()));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        		}*/
		        		
		        	
		        	//g2d.draw(new Ellipse2D.Double((tilehex.getClearings().get(i).getXposition()), (tilehex.getClearings().get(i).getYposition()), 80, 80));
		        	//chitimg = ImageIO.read(new File("/Z:/eclipse-Juno-Workspace/MagicRealm/src/" + tilehex.getClearings().get(i).getSoundChits().get(i).getFilePath()));
		        	cl = at.createTransformedShape(new Ellipse2D.Double((tilehex.getClearings().get(i).getXposition() - 40), (tilehex.getClearings().get(i).getYposition() - 40), 80, 80));
		        	g2d.drawImage(chitimg, tilehex.getClearings().get(i).getXposition() - 40, tilehex.getClearings().get(i).getYposition() - 40, cl.getBounds().width, cl.getBounds().height, null);
		        }

		        //g2d.draw(new Ellipse2D.Double(center.x-1.5, center.y-1.5, 30, 30));
		        g2.drawImage(rotated, shape.getBounds().x, shape.getBounds().y, shape.getBounds().width, shape.getBounds().height, null);
		        //g2.draw(c1);
	            //tileimg = rotated;
	            //System.out.println("rotated " + angle);
	            g2d.dispose();
	    	}
	        //g2.drawImage(tileimg, shape.getBounds().x, shape.getBounds().y, shape.getBounds().width, shape.getBounds().height, null);
	        //g2.draw(new Ellipse2D.Double(center.x-1.5, center.y-1.5, 30, 30));
        }
        
        
        //g2.setTransform(saveTransform);
        
        if(isSelected) {
        	System.out.println(tilehex.getName());
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