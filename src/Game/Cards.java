package Game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Cards implements ActionListener{
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
	
	int numMove1;
	int numMove2;
	int numMove3;
	int numTurnCarrot;
	
	LinkedList<cardType> currentList = new LinkedList<Cards.cardType>();
	LinkedList<cardType> shuffledList = new LinkedList<Cards.cardType>();
	
	static public enum cardType {
		MOVE1,
		MOVE2,
		MOVE3,
		TURN_CARROT,
		BACKCARD
	}
	public Cards(int numMove1, int numMove2, int numMove3, int numTurnCarrot) {
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
		resetShuffledList();
		setCurrentImage(backCard);
	}
	private void setCurrentImage(Image image) {
		currenImage = image;
	}
	private void resetShuffledList() {
		shuffledList = currentList;
		Collections.shuffle(shuffledList);
	}
	public Image getCurrentImage() {
		
		return currenImage;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


