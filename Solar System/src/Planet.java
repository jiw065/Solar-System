import java.awt.Graphics;
import java.awt.Image;


public class Planet extends Star {
	double degree = 0;
	double speed;
	boolean satellite;
	Star center;
	String name; 
	double longAxis, shortAxis;
	
	public Planet(String img, Star center, double longAxis, double shortAxis, double speed, String name ) {
		 super(img);
		 this.center = center;
		 this.longAxis = longAxis;
		 this.shortAxis = shortAxis;
		 this.speed = speed;
		 this.name = name;
		 this.x = center.x + longAxis;
		 this.y = center.y + shortAxis;		
	}
	
	// constructor for satellite
	public Planet(String img, Star center, double longAxis, double shortAxis, double speed,boolean satellite,String name ) {
		 this(img, center, longAxis, shortAxis, speed, name);
		 this.satellite = satellite;	
	}
	

	
	public void drawStar(Graphics g) {
		super.drawStar(g);
	
	}
	
	
}
