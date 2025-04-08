package Game;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Cards extends JPanel implements MouseListener{
	static String jump1Path = ".\\Graphics\\jump1.png";
	static String jump2Path = ".\\Graphics\\jump2.png";
	static String jump3Path = ".\\Graphics\\jump3.png";
	static String turnCarrotPath = ".\\Graphics\\turnCarrot.png";
	static String backCardPath = ".\\Graphics\\turnCard.png";
	
	static Image jump1 = new ImageIcon(jump1Path).getImage();
	static Image jump2 = new ImageIcon(jump2Path).getImage();
	static Image jump3 = new ImageIcon(jump3Path).getImage();
	static Image turnCarrot = new ImageIcon(turnCarrotPath).getImage();
	static Image backCard = new ImageIcon(backCardPath).getImage();
	
	Image currenImage;
	
	cardType cardSelected;
	long cardFlipBackDelay = 3000;
	long cardFlipBackStartTime;
	
	int numMove1;
	int numMove2;
	int numMove3;
	int numTurnCarrot;
	int positionX;
	int positionY;
	
	LinkedList<cardType> currentList = new LinkedList<Cards.cardType>();
	LinkedList<cardType> shuffledList = new LinkedList<Cards.cardType>();
	
	packType thisType;
	static public enum cardType {
		MOVE1,
		MOVE2,
		MOVE3,
		TURN_CARROT,
		BACKCARD
	}
	
	
	static public enum packType {
		SAFE,
		MEDIUM,
		RISKY
	}
	
	
	public Cards(int numMove1, int numMove2, int numMove3, int numTurnCarrot, int positionX, int positionY, packType type) {
		
		this.thisType = type;
		this.positionX = positionX;
		this.positionY = positionY;
		
		for (int i=0; i < numMove1; i++) {
			currentList.add(cardType.MOVE1);
		}
		for (int i=0; i < numMove2; i++) {
			currentList.add(cardType.MOVE2);
		}
		for (int i=0; i < numMove3; i++) {
			currentList.add(cardType.MOVE3);
		}
		for (int i=0; i < numTurnCarrot; i++) {
			currentList.add(cardType.TURN_CARROT);
		}
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(positionX, positionY, jump1.getWidth(null), jump1.getHeight(null));
		this.addMouseListener(this);
		resetShuffledList();
		setCurrentImage(backCard);
	}
	

	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	private void setCurrentImage(Image image) {
		currenImage = image;
	}
	public Image getCurrentImage() {
		
		return currenImage;
	}
	
	
	private void resetShuffledList() {
		
		shuffledList.addAll(currentList);
		Collections.shuffle(shuffledList);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!PlayScreen.isProcessingPayerMove()) {
			PlayScreen.setPocessingPlayerMove(true);
			// make sure the list is not empty
			if (shuffledList.isEmpty()) {
				resetShuffledList();
			}
			cardSelected = shuffledList.poll();
			// show card
			setCurrentImage(retrieveCard(cardSelected));
			PlayScreen.currentCardsPack = this;
		}
	}
	
	
	public void resetCard() {

		setCurrentImage(retrieveCard(cardType.BACKCARD));
		PlayScreen.setPocessingPlayerMove(false);
		getParent().repaint();
	}
	
	
	private Image retrieveCard(cardType poll) {
		switch (poll) {
		case cardType.MOVE1:
			return jump1;
		case cardType.MOVE2:
			return jump2;
		case cardType.MOVE3:
			return jump3;
		case cardType.TURN_CARROT:
			return turnCarrot;
		default:
			return backCard;
		}
	}


	public int holeCount() {

		// Generate the maximum number of holes when the carrot is turned and randomize it
		int numberOfHoles;
		int numberOfHolesMax = 1;
		
		if (thisType == packType.SAFE) {
			numberOfHolesMax = 2;
		}
		if (thisType == packType.MEDIUM) {
			numberOfHolesMax = 3;
		}
		if (thisType == packType.RISKY) {
			numberOfHolesMax = 4;
		}
		numberOfHoles = new Random().nextInt(numberOfHolesMax);
		return numberOfHoles;
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


