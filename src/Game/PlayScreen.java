package Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import Game.Cards.packType;

@SuppressWarnings("serial")
public class PlayScreen extends JPanel {
	
	final private double FPS = 60.0;
	private Image background;
	private Image carrotForeGround;
	private String backgroundPath = ".\\Graphics\\playScreen.png";
	private String foregroundPath = ".\\Graphics\\front_carrot.png";
	private long pauseStart = 0;
	private long pauseDelay = 0;
	
	private ArrayList<PlayPosition> playPositions= new ArrayList<PlayPosition>();
	static public ArrayList<Player> currentPlayerList = new ArrayList<Player>();
	static public ArrayList<Player> inHolePlayerList = new ArrayList<Player>();
	static public Cards currentCardsPack;
	static private boolean processingPlayerMove = false;
	
	private Cards riskyCards;
	private Cards mediumCards;
	private Cards safeCards;
	
	private Timer gameTimer;
	private Player currentPlayer;
	
	public JButton backButton;
	private boolean gameWon = false;
	private boolean processingHoles = false;
	private boolean flipCardPause = false;
	
	private double moveX;
	private double moveY;
	private double playerPositionX;
	private double playerPositionY;
	private double moveSpeed = 12.0; // in pixel
	private double gravity;
	private double height = 400;
	private boolean startMove = true;
	
	

	public static boolean isProcessingPayerMove() {
		return processingPlayerMove;
	}
	public static void setPocessingPlayerMove(boolean waitForUpdate) {
		processingPlayerMove = waitForUpdate;
	}

	
	PlayScreen() {
		riskyCards = new Cards(5, 8, 15, 12, 578, 30, packType.RISKY);
		mediumCards = new Cards(10, 10, 10, 10, 695, 30, packType.MEDIUM);
		safeCards = new Cards(20, 15, 7, 3, 810, 30, packType.SAFE);
		
		currentCardsPack = riskyCards;
		
		currentPlayer = currentPlayerList.getFirst();
		
		backButton = new JButton("Back to player screen");
		backButton.setBounds(700, 480, 200, 30);
		backButton.setFont(new Font("Arial",Font.BOLD,15));
		
		// create a game timer to run a game loop
		gameTimer = new Timer( (int) (1000.0/FPS) , new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("running");
					gameRun();
			}
		});
		
		
		background = new ImageIcon(backgroundPath).getImage();
		carrotForeGround = new ImageIcon(foregroundPath).getImage();
		fillPlayPositions();
		setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.setLayout(null);
		this.setOpaque(false);
		for (PlayPosition position:playPositions) {
			add(position);
		}
		this.add(riskyCards);
		this.add(mediumCards);
		this.add(safeCards);
		this.add(backButton);
		gameTimer.start();
		
	}
	
	
	public void gameRun()  {  // logic loop for the game
		if (gameWon) {
			JOptionPane.showMessageDialog(null, "Congradulation " + currentPlayer.getPlayerName() + "You won!" , "Warning" , JOptionPane.INFORMATION_MESSAGE);
			currentPlayer.addToScore();
			resetGame();
		}
		if (processingPlayerMove) { // loop to execute when we are moving the miniature
			int numberOfMoveLeft = currentPlayer.getNumberOfMoveLeft();
			if (startMove) {  // on the first frame after the player click, prepare the miniature movement and etc
				checkCardSelected(currentCardsPack.cardSelected); // depending on pack selected, update player movement
				if (processingHoles) { // if the card trun carrot selected, create holes
					startMove = false;
					generateHoles();
				}
				else { // prepare player move
					preparePlayerNextMove();
					startMove = false;
					movePlayer();
				}
				
			}
			else { 
				if (processingHoles) { 
					dropPlayerThroughHoles();
				}
				else {
					if ( numberOfMoveLeft == 0) {
						if (!flipCardPause) {
							pause(2000);
							flipCardPause = true;
						}
						if (checkPlayerOverHoles()) {
							processingHoles = true;
							return;
						}
						if (pause()) {
							return;
						}
						currentCardsPack.resetCard();
						startMove = true;
						selectNextPlayer();
						flipCardPause = false;
						return;
					}
					movePlayer();
				}
			}
		}
		repaint();
	}
	
	
	private void pause(long pauseLengh) {
		this.pauseDelay = pauseLengh;
		pauseStart = System.currentTimeMillis();
	}
	
	
	private boolean pause() {
		if (pauseStart + pauseDelay < System.currentTimeMillis()) {
			return false;
		}
		return true;
	}
	
	
	private void dropPlayerThroughHoles() {
		boolean clearList = false;
		System.out.println(inHolePlayerList.size());
		for (Player player: inHolePlayerList) {
			player.dropHoleAnimation();
			if (!player.isInHole()) {
				player.resetPlayer();
				player.resetImage();
				clearList = true;
			}
		}
		if(clearList) {
			inHolePlayerList.clear();
		}
		if (inHolePlayerList.isEmpty()) {
			currentPlayer.setNumberOfMoveLeft(0);
			processingHoles = false;
		}
		
	}
	
	
	private void generateHoles() {

		int numberOfHoles = 1;
		int maxPlayPositionIndex = playPositions.size() - 1;
		Random randomindex;
		// reset all holes to no hole
		resetAllHole();
		
		numberOfHoles = currentCardsPack.holeCount();
		randomindex  = new Random();
		for (int i =0; i <= numberOfHoles ;i++) {
			playPositions.get(randomindex.nextInt(maxPlayPositionIndex)).setHole(true);
		}
		checkPlayerOverHoles();
	}
	
	
	private boolean checkPlayerOverHoles() {

		boolean playerOverHole = false;
		for (Player player:currentPlayerList) {
			for (PlayPosition position:playPositions) {
				if (position.isHole()) {
					int holePosition = playPositions.indexOf(position);
					int playerPosition = player.getPlayerPositionIndex();
					if (playerPosition == holePosition) {
						playerOverHole = true;
						inHolePlayerList.add(player);
						player.setInHole(true);
						player.setStartTimeDropHoleAnimation(System.currentTimeMillis());
					}
					
				}
			}
		}
		return playerOverHole;
	}
	
	
	private void resetAllHole() {

		for (PlayPosition index:playPositions) {
			index.setHole(false);
		}
	}
	
	
	public void resetGame() {

		gameWon = false;
		for (Player player: currentPlayerList) {
			player.resetPlayer();
		}
		resetAllHole();
		currentPlayer = currentPlayerList.getFirst();
		startMove = true;
		currentCardsPack.resetCard();
	}
	
	
	private void selectNextPlayer() {
		
		int indexOfCurrentPlayer = currentPlayerList.indexOf(currentPlayer);
		if (indexOfCurrentPlayer + 1 < currentPlayerList.size()) {
			currentPlayer = currentPlayerList.get( indexOfCurrentPlayer + 1);
		}
		else {
			currentPlayer = currentPlayerList.getFirst();
		}
	}
	
	
	private void checkCardSelected(Cards.cardType currentCardType) {

		if (currentCardType == Cards.cardType.MOVE1) {
			currentPlayer.setNumberOfMoveLeft(1);
		}
		else if (currentCardType == Cards.cardType.MOVE2) {
			currentPlayer.setNumberOfMoveLeft(2);
		}
		else if (currentCardType == Cards.cardType.MOVE3) {
			currentPlayer.setNumberOfMoveLeft(3);
		}
		else if (currentCardType == Cards.cardType.TURN_CARROT) {
			processingHoles = true;
		}
	}
	
	
	private void movePlayer() {

		int numberOfMoveLeft = currentPlayer.getNumberOfMoveLeft();
		int positionX = currentPlayer.getPositionX();
		int positionY = currentPlayer.getPositionY();
		int nextPositionX = currentPlayer.getNextPositionX();
		int nextPositionY = currentPlayer.getNextPositionY();
		
		if ( (moveX < 0 && positionX + moveX < nextPositionX) ||
				(moveX > 0 && positionX + moveX > nextPositionX)) { 
			moveX=0;
			currentPlayer.setPositionX(nextPositionX);
		}
		if ( (moveX == 0) && (positionY - moveY + gravity > nextPositionY ) ) {
			gravity = 0;
			moveY = 0;
			
			currentPlayer.setPosition(nextPositionX, nextPositionY);
			numberOfMoveLeft--;
			currentPlayer.setNumberOfMoveLeft(numberOfMoveLeft);
			currentPlayer.setNextToCurrent();
			if (currentPlayer.getPlayerPositionIndex() + 1 == playPositions.size()) {
				gameWon = true;
				return;
			}

			if (numberOfMoveLeft >0 ) {
				preparePlayerNextMove();
			}
		}
		else {
			startMovePlayer();
		}
	}

	
	private void startMovePlayer() {

		int newPositionX;
		int newPositionY;
		
		// calculate the new position
		this.playerPositionX += moveX; 
		this.playerPositionY -= moveY;
		moveY  = moveY + gravity;
		
		newPositionX = (int) this.playerPositionX;
		newPositionY = (int) this.playerPositionY;
		
		// output for debugging
		// System.out.print( "new positionX : " + newPositionX + ", Y : " + newPositionY + "\n");

		// apply the new position
		currentPlayer.setPosition(newPositionX, newPositionY);
	}
	
	
	private void preparePlayerNextMove() {
		
		boolean isPlayerOnPosition = true;
		int positionX = currentPlayer.getPositionX();
		int positionY = currentPlayer.getPositionY();
		int positionIndex = currentPlayer.getPlayerPositionIndex();
		int nextIndex = 1;
		int playerPositionNextIndex;

		while (isPlayerOnPosition) { // make sure the position the player is moving too is not occupied by another player
			isPlayerOnPosition = false;
			for (Player player: currentPlayerList) {
				if (currentPlayer.getPlayerPositionIndex() + nextIndex  == player.getPlayerPositionIndex()
						&& !currentPlayer.equals(player)) {
					isPlayerOnPosition = true;
					nextIndex++;
					break;
				}
			}
		}
		playerPositionNextIndex = positionIndex + nextIndex;
		currentPlayer.setPlayerPositionNextIndex( playerPositionNextIndex);
		
		int nextPositionX = playPositions.get(playerPositionNextIndex).getPositionOffsetX();
		int nextPositionY = playPositions.get(playerPositionNextIndex).getPositionOffsetY();
		
		currentPlayer.setNextPosition(nextPositionX, nextPositionY);
		
		//set variable for next turn
		playerPositionX = positionX;
		playerPositionY = positionY;
		
		//set movement for each frame for x and y
		// check total distance to move + height over next point
		double distanceX = Math.abs(nextPositionX - positionX);
		double distanceY = Math.abs(nextPositionY - positionY);
		double hypotenuse = Math.sqrt( Math.pow(distanceX, 2.0) + Math.pow(distanceY + height, 2.0));
		double frame = hypotenuse/moveSpeed;
		
		// try to keep every move at a constant speed depending on where we move the player
		moveX = (nextPositionX - positionX ) / frame;
		System.out.println(moveX);
		
		// totally random equation to make it look good
		moveY = (distanceY + height) * frame / 1800;
		gravity = -.44;
	}
	
	
	public void paint(Graphics g) {

		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(background, 0, 0, null);
		super.paint(g); // added to paint the back button
		for (PlayPosition position:playPositions) {
			g2D.drawImage(position.getTile(), position.getPositionX(), position.getPositionY(), null);
		}
		// Write screen text;
		g2D.setColor(Color.BLACK);
		g2D.setFont(new Font("Arial", Font.BOLD, 25));
		g2D.drawString("It's " + currentPlayer.getPlayerName() + " turn!", 15, 30);
		
		g2D.setFont(new Font("Arial", Font.PLAIN, 18));
		g2D.drawString("Fast Pack", 590, 26);
		g2D.drawString("Normal Pack", 695, 26);
		g2D.drawString("Slow Pack", 820, 26);
		
		g2D.setFont(new Font("Arial", Font.BOLD, 20));
		g2D.setColor(CroqueCarotte.player1.getPlayerColor());
		g2D.drawString(CroqueCarotte.player1.getPlayerName() + " score : " + CroqueCarotte.player1.getScore(), 15, 60);
		
		g2D.setColor(CroqueCarotte.player2.getPlayerColor());
		g2D.drawString(CroqueCarotte.player2.getPlayerName() + " score : " + CroqueCarotte.player2.getScore(), 15, 90);
		
		// draw cards images
		g2D.drawImage(safeCards.getCurrentImage(), safeCards.getPositionX(), safeCards.getPositionY(), null);
		g2D.drawImage(mediumCards.getCurrentImage(), mediumCards.getPositionX(), mediumCards.getPositionY(), null);
		g2D.drawImage(riskyCards.getCurrentImage(), riskyCards.getPositionX(), riskyCards.getPositionY(), null);
		
		// draw two first players 
		if (!CroqueCarotte.player1.equals(currentPlayer)) { // make sure it's not the current player so we can draw the current player over the others
			g2D.drawImage(CroqueCarotte.player1.getImage(), CroqueCarotte.player1.getPositionOffsetX(), CroqueCarotte.player1.getPositionOffsetY(), null);
		}
		if (!CroqueCarotte.player2.equals(currentPlayer)) {
			g2D.drawImage(CroqueCarotte.player2.getImage(), CroqueCarotte.player2.getPositionOffsetX(), CroqueCarotte.player2.getPositionOffsetY(), null);
		}
		// draw more data if there is more players than 2	
		if (Player.getNumberOfPlayer()>2) {
			if (!CroqueCarotte.player3.equals(currentPlayer)) {
				g2D.drawImage(CroqueCarotte.player3.getImage(), CroqueCarotte.player3.getPositionOffsetX(), CroqueCarotte.player3.getPositionOffsetY(), null);
			}
			g2D.setColor(CroqueCarotte.player3.getPlayerColor());
			g2D.drawString(CroqueCarotte.player3.getPlayerName() + " score : " + CroqueCarotte.player3.getScore(), 15, 120);
		}
		if (Player.getNumberOfPlayer()>3) {
			if (!CroqueCarotte.player4.equals(currentPlayer)) {
				g2D.drawImage(CroqueCarotte.player4.getImage(), CroqueCarotte.player4.getPositionOffsetX(), CroqueCarotte.player4.getPositionOffsetY(), null);
			}
			g2D.setColor(CroqueCarotte.player4.getPlayerColor());
			g2D.drawString(CroqueCarotte.player4.getPlayerName() + " score : " + CroqueCarotte.player4.getScore(), 15, 150);
		}
		g2D.drawImage(currentPlayer.getImage(), currentPlayer.getPositionOffsetX(), currentPlayer.getPositionOffsetY(), null);
		g2D.drawImage(carrotForeGround, 417, 88, null);
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
		playPositions.add(new PlayPosition(435,92));
	}
}
