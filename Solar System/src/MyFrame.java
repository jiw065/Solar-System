import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This is the display window for program
 * @author Amber
 *
 */
public class MyFrame extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Star sun = new Star("images/sun.jpg",Constant.WINDOW_WIDTH/2,Constant.WINDOW_HEIGHT/2,"Sun");	
    Planet earth = new Planet("images/Earth.jpg", sun, 145, 95, 0.06, "Earth");
	Planet jupiter = new Planet("images/Jupiter.jpg", sun, 230,160,0.04, "Jupiter");
    Planet mars = new Planet("images/Mars.jpg", sun, 185,125,0.05, "Mars");
	Planet mercury = new Planet("images/Mercury.jpg", sun, 80,50,0.08, "Mercury");
    Planet neptune = new Planet("images/Neptune.jpg", sun, 395,295,0.01, "Neptune");
	Planet saturn = new Planet("images/Saturn.jpg", sun, 280,200,0.03, "Saturn");
    Planet uranus = new Planet("images/Uranus.jpg", sun, 335,245,0.02, "Uranus");
	Planet venus = new Planet("images/Venus.jpg", sun, 110,70,0.07, "Venus");
	Planet moon = new Planet("images/moon.jpg", earth, 20,15,0.5, true, "moon");
	
    public void paint(Graphics g) {		
		Color c =  g.getColor();
		g.drawImage(Constant.BACKGROUND_IMG, 0, 0, null);

		sun.drawStar(g);
		earth.drawStar(g);
		jupiter.drawStar(g);
		mars.drawStar(g);
		mercury.drawStar(g);
		neptune.drawStar(g);
		saturn.drawStar(g);
		uranus.drawStar(g);
		venus.drawStar(g);
		moon.drawStar(g);
	}
    
    
	public  void  launchFrame(){
		this.setTitle("Solar System");
		this.setVisible(true);
		this.setSize(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
		this.setLocation(300, 300);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});	
		new PaintThread().start();	
	}
	
	// this thread is used to repaint the frame 
	class  PaintThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
				repaint();		
				
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		MyFrame  f = new MyFrame();
		f.launchFrame();

	}
	
	// solve display problem, copied from internet
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT);
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}

}
