package Game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlayScreen extends JPanel implements MouseListener{
	Image background;
	String backgroundPath = ".\\Graphics\\playScreen.png";
	
	ArrayList<PlayPosition> playPositions= new ArrayList<PlayPosition>();
	
	Cards riskyCards;
	Cards mediumCards;
	Cards safeCards;

	
	PlayScreen() {
		riskyCards = new Cards(5, 5, 15, 15);
		mediumCards = new Cards(10, 10, 10, 10);
		safeCards = new Cards(20, 15, 5, 5);
		
		
		background = new ImageIcon(backgroundPath).getImage();
		fillPlayPositions();
		setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.setLayout(null);
		repaint();

	}
	public void paint(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(background, 0, 0, null);

		for (PlayPosition position:playPositions) {
			g2D.drawImage(PlayPosition.getTileDirt(), position.getPositionX(), position.getPositionY(), null);
			
		}
		g2D.drawImage(safeCards.getCurrentImage(), 578, 30, null);
		g2D.drawImage(mediumCards.getCurrentImage(), 695, 30, null);
		g2D.drawImage(riskyCards.getCurrentImage(), 810, 30, null);
		
		g2D.drawImage(CroqueCarotte.player1.miniatureImage, 426-20, 501-64, null);
		g2D.drawImage(CroqueCarotte.player2.miniatureImage, 426-20+25, 501-64, null);
		g2D.drawImage(CroqueCarotte.player3.miniatureImage, 426-20+50, 501-64, null);
		g2D.drawImage(CroqueCarotte.player4.miniatureImage, 426-20+75, 501-64, null);
		System.out.println("Graphic ok");

		
	}
	private void fillPlayPositions() {
		playPositions.add(new PlayPosition(402,486));
		playPositions.add(new PlayPosition(309,481));
		playPositions.add(new PlayPosition(216,464));
		playPositions.add(new PlayPosition(114,446));
		playPositions.add(new PlayPosition(180,393));
		playPositions.add(new PlayPosition(264,376));
		playPositions.add(new PlayPosition(346,363));
		playPositions.add(new PlayPosition(427,367));
		playPositions.add(new PlayPosition(515,363));
		playPositions.add(new PlayPosition(591,376));
		playPositions.add(new PlayPosition(666,389));
		playPositions.add(new PlayPosition(743,389));
		playPositions.add(new PlayPosition(830,368));
		playPositions.add(new PlayPosition(783,336));
		playPositions.add(new PlayPosition(708,319));
		playPositions.add(new PlayPosition(636,299));
		playPositions.add(new PlayPosition(556,286));
		playPositions.add(new PlayPosition(476,269));
		playPositions.add(new PlayPosition(385,277));
		playPositions.add(new PlayPosition(308,282));
		playPositions.add(new PlayPosition(234,277));
		playPositions.add(new PlayPosition(159,260));
		playPositions.add(new PlayPosition(120,220));
		playPositions.add(new PlayPosition(190,199));
		playPositions.add(new PlayPosition(267,185));
		playPositions.add(new PlayPosition(346,178));
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getSource());
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
