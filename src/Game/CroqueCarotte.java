package Game;

import javax.swing.ImageIcon;


public class CroqueCarotte {
	static private int screenWidthX = 960;
	static private int screenHeightY = 540;
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

		player1 = new Player(500, 496);
		player2 = new Player(550, 496);
		player3 = new Player(600, 496);
		player4 = new Player(650, 496);
		ImageIcon mainIcon = new ImageIcon(".\\Graphics\\carrot.png");
		PreGame titleScreen = new PreGame();
		titleScreen.setIconImage(mainIcon.getImage());
	}

}
