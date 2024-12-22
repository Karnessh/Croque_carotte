package Game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayPosition {

	private static int positionOffsetX = 26;
	private static int positionOffsetY = 17;
	
	private static String tileDirtPath = ".\\Graphics\\tileDirt.png";
	private static String tileHolePath = "";
	
	private static Image tileDirt = new ImageIcon(tileDirtPath).getImage();
	private static Image tileHole = new ImageIcon(tileHolePath).getImage();
	
	private int positionX;
	private int positionY;
	
	public PlayPosition(int x, int y) {
		setPositionX(x);
		setPositionY(y);
	}
	public static int getPositionOffsetX(int x) {
		return x + positionOffsetX;
	}

	public static int getPositionOffsetY(int y) {
		return y + positionOffsetY;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}



	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}



	public static Image getTileDirt() {
		return tileDirt;
	}

	public static Image getTileHole() {
		return tileHole;
	}

}
