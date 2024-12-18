import java.awt.Color;
import java.util.ArrayList;

public class Player {
	
	int playerID;
	Color playerColor;
	int playerColorIndex;
	String playerName;
	int playerBestScore;
	static ArrayList<Integer> playerList = new ArrayList<Integer>();
	static ArrayList<Color> playersColorList = new ArrayList<Color>();
	static int numberOfPlayer = 2;
	public static int getNumberOfPlayer() {
		return numberOfPlayer;
	}

	public static void setNumberOfPlayer(int numberOfPlayer) {
		Player.numberOfPlayer = numberOfPlayer;
	}
	public static final Color[] listColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN,Color.ORANGE};
	
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
		playersColorList.add(listColors[getArrayPlayerID()]);
		playerColorIndex = getArrayPlayerID();
		playerColor = listColors[getArrayPlayerID()];
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
			
			for (int i = 0; i < listColors.length - 1; i++ ) { // we are not checking the player current color
				thisColorIndex--;
				boolean isFound = false;
				if (thisColorIndex < 0) { // go to the back of the array if you reach the beginning
					thisColorIndex = listColors.length - 1;
				}
				for (int y = 0; y < numberOfPlayer; y++ ) { // check if color is already used by another player
					if (listColors[thisColorIndex] == playersColorList.get(y)) {
						isFound = true;
					}
				}
				if (!isFound) { // if color is not found by another player change current player to that color
					this.playerColorIndex = thisColorIndex;
					this.playerColor = listColors[thisColorIndex];
					Player.playersColorList.set(getArrayPlayerID(), playerColor);
					return;
				}
			}
		}
		else {
			for (int i = 0; i < listColors.length - 1; i++ ) { // we are not checking the player current color
				thisColorIndex++;
				boolean isFound = false;
				// for info  listColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN,Color.ORANGE};
				if (thisColorIndex > listColors.length - 1) { // go to the beginning of the array if you reach the end
					thisColorIndex = 0;
				}
				for (int y = 0; y < numberOfPlayer; y++ ) { // check if color is already used by another player
					if (listColors[thisColorIndex] == playersColorList.get(y)) {
						isFound = true;
					}
				}
				if (!isFound) { // if color is not found by another player change current player to that color
					this.playerColorIndex = thisColorIndex;
					this.playerColor = listColors[thisColorIndex];
					Player.playersColorList.set(getArrayPlayerID(), playerColor);
					return;
				}
			}
		}
	}

}
