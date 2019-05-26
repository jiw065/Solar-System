import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 * This is the parent class for all stars
 * sun is the instance of this class as it cannot move
 * @author Amber
 *
 */

public class Star {
	Image img;
	double x,y; //position
	int width, height;
	String name;
	
	//default constructor allows subclass has independent constructor
	public Star() {
		
	}
	
	public Star(String imgPath, String name) {
		this.img = GameUtil.getImage(imgPath);
		this.name = name; 
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	// constructor for solar
	public Star(String imgPath, double x,double y,String name) {
		this(imgPath, name);
		this.x = x;
		this.y = y;
	}
	

	

	public void  drawStar(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
    	g.drawString(this.name, (int)x-2, (int)y-5);
    	g.setColor(c);
		g.drawImage(img, (int)x, (int)y, null);
	}
	
}
