import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;


public class Planet extends Star {
	double degree = 180;
	double speed;
	boolean satellite;
	Star center;
	String name; 
	double longAxis, shortAxis;
	
	public Planet(String img, Star center, double longAxis, double shortAxis, double speed, String name ) {
		 super(img, name);
		 this.center = center;
		 this.longAxis = longAxis;
		 this.shortAxis = shortAxis;
		 this.speed = speed;
		 this.x = center.x + longAxis;
		 this.y = center.y;		
	}
	
	// constructor for satellite
	public Planet(String img, Star center, double longAxis, double shortAxis, double speed,boolean satellite,String name ) {
		 this(img, center, longAxis, shortAxis, speed, name);
		 this.satellite = satellite;	
	}
	

    private void drawTrace(Graphics g) {
    	double ovalX,ovalY,ovalWidth,ovalHeight;
        ovalWidth = longAxis*2;
        ovalHeight = shortAxis*2;
        ovalX = center.x+center.width/2-longAxis;
        ovalY = center.y+center.height/2-shortAxis;
        Color c = g.getColor();
        g.setColor(Color.ORANGE);
        g.drawOval((int)ovalX,(int)ovalY,(int)ovalWidth,(int)ovalHeight);
        g.setColor(c);
    }
    
	public void move() {
		x=center.x+center.width/2-width/2+longAxis*Math.cos(degree);
	    y=center.y+center.height/2-height/2+shortAxis*Math.sin(degree);
		degree+=speed;
	}

	public void drawStar(Graphics g) {
		super.drawStar(g);
		move();
		if(!satellite) {
			drawTrace(g);
		}	
	}
	
	
}
