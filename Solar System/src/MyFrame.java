import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;





public class MyFrame extends Frame {

	public void paint(Graphics g) {		
		Color c =  g.getColor();
		g.drawImage(Constant.BACKGROUND_IMG, 0, 0, null);
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
		
	
		
	}
	
	
	public static void main(String[] args) {
		MyFrame  f = new MyFrame();
		f.launchFrame();

	}
	
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.WINDOW_WIDTH,Constant.WINDOW_HEIGHT);
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}

}
