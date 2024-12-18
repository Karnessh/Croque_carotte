import javax.swing.ImageIcon;

public class CroqueCarotte {
	static private int screenWidthX = 960;
	static public int screenHeightY = 540;
	public static Player player1;
	public static Player player2;
	public static Player player3;
	public static Player player4;
	
	public static int getScreenWidthX() {
		return screenWidthX;
	}
	
	
	public static int getScreenHeightY() {
		return screenHeightY;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		player4 = new Player();
		ImageIcon mainIcon = new ImageIcon(".\\Graphics\\carrot.png");
		MainWindow titleScreen = new MainWindow();
		titleScreen.setIconImage(mainIcon.getImage());
	}

}
