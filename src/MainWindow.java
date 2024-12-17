
import java.awt.Point;
import javax.swing.JFrame;


public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5312301715461382513L;
	int test = CroqueCarotte.getScreenWidthX();
	TitleScreen titleScreen;
	Point point;

	MainWindow() {
		titleScreen = new TitleScreen();
		point = new Point(CroqueCarotte.getScreenWidthX()/2,CroqueCarotte.getScreenHeightY()/2);

		this.setTitle("Croque Carotte");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(point);

		this.setSize(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		
		this.add(titleScreen);
		
		
	}

}
