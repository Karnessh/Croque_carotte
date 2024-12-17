import java.awt.Color;
import java.util.ArrayList;

public class Player {
	
	int playerID;
	Color playerColor;
	String playerName;
	int playerBestScore;
	static ArrayList<Color> colorList;
	
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


	
	public Player(int playerID, Color playerColor) {
		this.playerID = playerID;
		this.playerColor = playerColor;
	}
	public Player(int playerID, Color playerColor, String playerName, int playerBestScore) {
		this.playerID = playerID;
		this.playerColor = playerColor;
		this.playerName = playerName;
		this.playerBestScore = playerBestScore;
	}

}
