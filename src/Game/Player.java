package Game;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class Player {
	static ArrayList<Integer> playerList = new ArrayList<Integer>();
	static ArrayList<Color> playersColorList = new ArrayList<Color>();
	static int numberOfPlayer = 2;
	static Miniature miniature = new Miniature();
	public static final Color[] LISTCOLORS = {Color.BLUE, Color.RED, Color.YELLOW, new Color(30, 120, 25),Color.CYAN,new Color(190, 10, 190)};	
	int playerID;
	int playerBestScore;
	Color playerColor;
	String playerName;
	Image miniatureImage;
	int positionX = 0;
	int positionY = 0;
	
	
	int playerColorIndex;
	public void setPosition(int x, int y) {
		positionX = Miniature.getMiniatureOffsetX(x);
		positionY = Miniature.getMiniatureOffsetY(y);
	}
	public int getPlayerColorIndex() {
		return playerColorIndex;
	}
	public void setPlayerColorIndex(int playerColorIndex) {
		this.playerColorIndex = playerColorIndex;
		miniatureImage = miniature.getImage(playerColorIndex); 
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
	public int getArrayPlayerID() {
		return playerID - 1;
	}


	
	public Player() {
		playerID = playerList.size() + 1;
		playerList.add(playerID);
		playersColorList.add(LISTCOLORS[getArrayPlayerID()]);
		setPlayerColorIndex(getArrayPlayerID());
	}
	public Player(int playerID, Color playerColor, String playerName, int playerBestScore) {
		this.playerID = playerID;
		this.playerColor = playerColor;
		this.playerName = playerName;
		this.playerBestScore = playerBestScore;
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
					Player.playersColorList.set(getArrayPlayerID(), playerColor);
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
					Player.playersColorList.set(getArrayPlayerID(), playerColor);
					return;
				}
			}
		}
	}

}
