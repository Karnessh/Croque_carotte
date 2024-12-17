import javax.swing.ImageIcon;

public class CroqueCarotte {
	static private int screenWidthX = 960;
	static public int screenHeightY = 540;
	
	
	public static int getScreenWidthX() {
		return screenWidthX;
	}
	
	
	public static int getScreenHeightY() {
		return screenHeightY;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageIcon mainIcon = new ImageIcon(".\\Graphics\\carrot.png");
		MainWindow titleScreen = new MainWindow();
		titleScreen.setIconImage(mainIcon.getImage());
	}

}
