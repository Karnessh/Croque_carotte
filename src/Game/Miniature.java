package Game;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Miniature {
	
	private static int miniatureOffsetX = -20;
	private static int miniatureOffsetY = -64;
	private MiniatureImages[] listImages = new MiniatureImages[6];
	private String[] miniatureColor = { "blue", "red", "yellow", "green", "cyan", "purple"};
	private int playerIndexColor;
	private Image currentImage;
	
	public static int getMiniatureOffsetX(int x) {
		return miniatureOffsetX + x;
	}
	public static int getMiniatureOffsetY(int y) {
		return miniatureOffsetY + y;
	}
	public Image getImage() {
		return currentImage;
	}
	public void setImage(int playerColorIndex) {
		currentImage = listImages[playerColorIndex].getCurrentFrame();
		this.playerIndexColor = playerColorIndex;
	}
	public void getNextImage() {
		currentImage =  listImages[playerIndexColor].getnextFrame();
	}
	public void resetImage() {
		currentImage =  listImages[playerIndexColor].resetImage();
	}


	public Miniature() {
		
		for (int i = 0; i < listImages.length; i++) {
			listImages[i] = new MiniatureImages(miniatureColor[i]);
		}
	}
	

	class MiniatureImages {
		
		private int baseFrame = 0;
		private int currentFrame = 0;
		private Image[] miniImages = new Image[10];
		
		public MiniatureImages(String color) {
			String fullPath = ".\\Graphics\\" + color + "\\" + color + "_";
			for (int i = 0; i < miniImages.length; i++) {
				miniImages[i] = new ImageIcon(fullPath + i + ".png").getImage();
			}
			
		}
		
		
		public Image getnextFrame() {
			
			if (currentFrame < miniImages.length-1) {
				currentFrame++;
			} else {
				currentFrame = 0;
			}
			return miniImages[currentFrame];
			
		}
		
		
		public Image getCurrentFrame() {
			
			return miniImages[currentFrame];
		}
		
		
		public Image resetImage() {
			
			return miniImages[baseFrame];
		}
	}
}
