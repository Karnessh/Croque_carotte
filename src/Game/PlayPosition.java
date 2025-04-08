package Game;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PlayPosition extends JPanel implements MouseListener{

	private static int positionOffsetX = 26;
	private static int positionOffsetY = 17;
	
	private static String tileDirtPath = ".\\Graphics\\tileDirt.png";
	private static String tileHolePath = ".\\Graphics\\dirthole.png";
	
	private static Image tileDirt;
	private static Image tileHole;
	private Image tile;
	
	private int positionX;
	private int positionY;
	
	private boolean hole = false;
	
	private int width;
	private int height;
	
	public PlayPosition(int x, int y) {
		
		tileDirt = new ImageIcon(tileDirtPath).getImage();
		tileHole = new ImageIcon(tileHolePath).getImage();
		tile = tileDirt;
		width = tileDirt.getWidth(null);
		height = tileDirt.getHeight(null);
		this.setOpaque(false);
		this.setPositionX(x);
		this.setPositionY(y);
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.addMouseListener(this);
		
	}
	

	public boolean isHole() {
		
		return hole;
	}
	

	public void setHole(boolean hole) {
		
		this.hole = hole;
		if (hole) {
			setTile(getTileHole());
		}
		else {
			setTile(getTileDirt());
		}
	}

	
	public int getPositionOffsetX() {
		return getPositionX() + positionOffsetX;
	}
	public int getPositionOffsetY() {
		return getPositionY() + positionOffsetY;
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
	public Image getTile() {
		return tile;
	}
	public void setTile(Image tile) {
		this.tile = tile;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	//	System.out.println("Source : " + e.getSource());
		System.out.println("Coordonates " + this.positionX + "," + this.positionY);
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
