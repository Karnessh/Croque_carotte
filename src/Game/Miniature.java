package Game;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Miniature {
	Image MiniatureColorBlueImage;
	String MiniatureColorBluePath = ".\\Graphics\\blue_miniature.png";
	
	Image MiniatureColorRedImage;
	String MiniatureColorRedPath = ".\\Graphics\\red_miniature.png";
	
	Image MiniatureColorYellowImage;
	String MiniatureColorYellowPath = ".\\Graphics\\yellow_miniature.png";
	
	Image MiniatureColorGreenImage;
	String MiniatureColorGreenPath = ".\\Graphics\\green_miniature.png";
	
	Image MiniatureColorCyanImage;
	String MiniatureColorCyanPath = ".\\Graphics\\cyan_miniature.png";
	
	Image MiniatureColorPurpleImage;
	String MiniatureColorPurplePath = ".\\Graphics\\purple_miniature.png";
	
	static int miniatureOffsetX = -20;
	static int miniatureOffsetY = -64;
	
	public static int getMiniatureOffsetX(int x) {
		return miniatureOffsetX + x;
	}

	public static int getMiniatureOffsetY(int y) {
		return miniatureOffsetY + y;
	}

	private Image[] listImages = new Image[6];
	
	public Image getImage(int index) {
		return listImages[index];
	}

	public Miniature() {
		listImages[0] = MiniatureColorBlueImage = new ImageIcon(MiniatureColorBluePath).getImage();
		listImages[1] = MiniatureColorRedImage = new ImageIcon(MiniatureColorRedPath).getImage();
		listImages[2] = MiniatureColorYellowImage = new ImageIcon(MiniatureColorYellowPath).getImage();
		listImages[3] = MiniatureColorGreenImage = new ImageIcon(MiniatureColorGreenPath).getImage();
		listImages[4] = MiniatureColorCyanImage = new ImageIcon(MiniatureColorCyanPath).getImage();
		listImages[5] = MiniatureColorPurpleImage = new ImageIcon(MiniatureColorPurplePath).getImage();
		
		
	}
	

}
