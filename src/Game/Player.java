package Game;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class Player {
	/**
	 * 
	 */
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	private static ArrayList<Color> playersColorList = new ArrayList<Color>();
	private static int numberOfPlayer = 2;
	
	public static final Color[] LISTCOLORS = {Color.BLUE, Color.RED, Color.YELLOW, new Color(30, 120, 25),Color.CYAN,new Color(190, 10, 190)};	
	private int playerID;
	private int score = 0;
	private int playerBestScore;
	private int inHoleFrame = 0;
	private long startTimeDropHoleAnimation;
	private long delayBetweenFrames = 300;
	private boolean inHole = false;
	
	private Miniature miniature = new Miniature();
	private Color playerColor;
	private String playerName;

	// data for movement on the board
	private int positionX = 0;
	private int positionY = 0;
	private int initialPositionX;
	private int initialPositionY;
	private int positionOffsetX = -21;
	private int positionOffsetY = -66;
	private int playerPositionIndex = -1;
	private int playerPositionNextIndex;
	private int nextPositionX;
	private int nextPositionY;
	private int numberOfMoveLeft = 0;
	private int playerColorIndex;
	
	
	public static ArrayList<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public boolean isInHole() {
		return inHole;
	}
	public void setInHole(boolean inHole) {
		this.inHole = inHole;
	}
	public void setStartTimeDropHoleAnimation(long startTimeDropHoleAnimation) {
		this.startTimeDropHoleAnimation = startTimeDropHoleAnimation;
	}
	public int getScore() {
		return score;
	}
	public void addToScore() {
		this.score = score + 1;
	}
	public int getPositionOffsetX() {
		return positionX + positionOffsetX;
	}
	public int getPositionOffsetY() {
		return positionY + positionOffsetY;
	}
	public void setPlayerPositionNextIndex(int playerPositionNextIndex) {
		this.playerPositionNextIndex = playerPositionNextIndex;
	}
	public int getPlayerPositionIndex() {
		return playerPositionIndex;
	}
	public void setPlayerPositionIndex(int playerPositionIndex) {
		this.playerPositionIndex = playerPositionIndex;
	}
	public int getNextPositionX() {
		return nextPositionX;
	}
	public void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
	}
	public void setNextPosition(int nextPositionX, int nextPositionY) {
		this.nextPositionX = nextPositionX;
		this.nextPositionY = nextPositionY;
	}
	public int getNextPositionY() {
		return nextPositionY;
	}
	public int getNumberOfMoveLeft() {
		return numberOfMoveLeft;
	}
	public void setNumberOfMoveLeft(int numberOfMoveLeft) {
		this.numberOfMoveLeft = numberOfMoveLeft;
	}
	public int getPlayerColorIndex() {
		return playerColorIndex;
	}
	public void setPlayerColorIndex(int playerColorIndex) {
		this.playerColorIndex = playerColorIndex;
		miniature.setImage(playerColorIndex); 
		setPlayerColor(LISTCOLORS[playerColorIndex]);
	}
	public static int getNumberOfPlayer() {
		return numberOfPlayer;
	}
	public static void setNumberOfPlayer(int numberOfPlayer) {
		Player.numberOfPlayer = numberOfPlayer;
	}
	public Color getPlayerColor() {
		return playerColor;
	}
	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerBestScore() {
		return playerBestScore;
	}
	public void setPlayerBestScore(int playerBestScore) {
		this.playerBestScore = playerBestScore;
	}
	public int getPlayerID() {
		return playerID;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	
	public Player(int x, int y) {
		
		setPositionX(x);
		setPositionY(y);
		initialPositionX = x;
		initialPositionY = y;
		playerID = playerList.size();
		playerName = "Player" + (playerList.size() + 1);
		playerList.add(this);
		playersColorList.add(LISTCOLORS[getPlayerID()]);
		setPlayerColorIndex(getPlayerID());
	}
	
	
	public Player(int playerID,  String playerName, int playerColorIndex, int playerBestScore, int x, int y) {
		
		setPositionX(x);
		setPositionY(y);
		this.playerID = playerID;
		this.playerColorIndex = playerColorIndex;
		this.playerName = playerName;
		this.playerBestScore = playerBestScore;
	}
	
	
	public void resetPlayer() {
		
		setPosition(initialPositionX, initialPositionY);
		setPlayerPositionIndex(-1);
	}
	
	
	public void setNextToCurrent() {
		
		int currentX = nextPositionX;
		int currentY = nextPositionY;
		int currentIndex = playerPositionNextIndex;
		setPlayerPositionIndex(currentIndex);
		setPosition(currentX, currentY);
	}
	
	
	public void updateColor(Direction direction) {
		
		// for info  listColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN,Color.ORANGE};
		int thisColorIndex = playerColorIndex;
		if (direction == Direction.LEFT) {// move left in the array 
			
			for (int i = 0; i < LISTCOLORS.length - 1; i++ ) { // we are not checking the player current color
				thisColorIndex--;
				boolean isFound = false;
				if (thisColorIndex < 0) { // go to the back of the array if you reach the beginning
					thisColorIndex = LISTCOLORS.length - 1;
				}
				for (int y = 0; y < numberOfPlayer; y++ ) { // check if color is already used by another player
					if (LISTCOLORS[thisColorIndex] == playersColorList.get(y)) {
						isFound = true;
					}
				}
				if (!isFound) { // if color is not found by another player change current player to that color
					setPlayerColorIndex(thisColorIndex);
					Player.playersColorList.set(getPlayerID(), playerColor);
					return;
				}
			}
		}
		else {
			for (int i = 0; i < LISTCOLORS.length - 1; i++ ) { // we are not checking the player current color
				thisColorIndex++;
				boolean isFound = false;
				// for info  listColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN,Color.ORANGE};
				if (thisColorIndex > LISTCOLORS.length - 1) { // go to the beginning of the array if you reach the end
					thisColorIndex = 0;
				}
				for (int y = 0; y < numberOfPlayer; y++ ) { // check if color is already used by another player
					if (LISTCOLORS[thisColorIndex] == playersColorList.get(y)) {
						isFound = true;
					}
				}
				if (!isFound) { // if color is not found by another player change current player to that color
					setPlayerColorIndex(thisColorIndex); 
					Player.playersColorList.set(getPlayerID(), playerColor);
					return;
				}
			}
		}
	}
	
	
	public boolean checkDuplicatePlayerColor () {
		
		for (int y = 0; y < numberOfPlayer; y++ ) { // check if color is already used by another player
			if (LISTCOLORS[playerColorIndex] == playersColorList.get(y)) {
				if (!(playerID == y)) { // make sure it's not the player own color that it is checking
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void dropHoleAnimation() {
		
		// 	long startTimeDropHoleAnimation;
		//  long delayBetweenFrames = 300;
		long currentTime = System.currentTimeMillis();
		if (startTimeDropHoleAnimation + delayBetweenFrames < currentTime) {
			miniature.getNextImage();
			inHoleFrame++;
		}
		if (inHoleFrame > 9) {
			inHoleFrame = 0;
			setInHole(false);
		}
	}
	
	
	public Image getImage() {
		
		return miniature.getImage();
	}
	
	
	public void resetImage() {
		
		miniature.resetImage();
	}
}
