package Game;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background  extends JPanel{
	Image background;
	String path;

	
	Background(String path) {
		this.setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.path = path;
		this.setLayout(null);
		this.setPreferredSize(new Dimension(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY()));
		repaint();

	}
	public void paint(Graphics g) {
		background = new ImageIcon(path).getImage();

		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(background, 0, 0, null);
		//g2D.drawLine(0	,0, 250, 250);

		
	}

	
}
