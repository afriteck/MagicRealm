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
        if(tilehex != null){
        	g2.draw(shape);
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
		        	cl = at.createTransformedShape(new Ellipse2D.Double((tilehex.getClearings().get(i).getXposition() - 40), (tilehex.getClearings().get(i).getYposition() - 40), 80, 80));
		        	if(tilehex.getClearings().get(i).getDwelling() != null){
		        		URL url = BoardTest.class.getResource(tilehex.getClearings().get(i).getDwelling().getFpath());
	        			try {
							chitimg = ImageIO.read(new File(url.getPath()));
							at.translate((w / 2), (h / 2));
					        at.rotate(Math.toRadians(-angle));
					        at.translate((-w / 2), (-h / 2));
					        g2d.setTransform(at);
				        	g2d.drawImage(chitimg, cl.getBounds().x, cl.getBounds().y, cl.getBounds().width, cl.getBounds().height, null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	if(tilehex.getClearings().get(i).getMonsterChits().size()>0){
		        		URL url = BoardTest.class.getResource("/monsters/" + tilehex.getClearings().get(i).getMonsterChits().get(0).getImgFilePath());
	        			try {
							chitimg = ImageIO.read(new File(url.getPath()));
							at.translate((w / 2), (h / 2));
					        at.rotate(Math.toRadians(-angle));
					        at.translate((-w / 2), (-h / 2));
					        g2d.setTransform(at);
				        	g2d.drawImage(chitimg, cl.getBounds().x, cl.getBounds().y, cl.getBounds().width, cl.getBounds().height, null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	/*
		        	at.translate((w / 2), (h / 2));
			        at.rotate(Math.toRadians(-angle));
			        at.translate((-w / 2), (-h / 2));
			        g2d.setTransform(at);
		        	g2d.drawImage(chitimg, cl.getBounds().x, cl.getBounds().y, cl.getBounds().width, cl.getBounds().height, null);
					*/
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