import java.awt.Graphics;
import java.awt.Image;



public class Star {
	Image img;
	double x,y; //position
	int width, height;
	
	//default constructor allows subclass has independent constructor
	public Star() {
		
	}
	// constructor for solar
	public Star(Image img, double x,double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Star(Image img) {
		this.img = img; 
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	

	public void  drawStar(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	
}
