package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CCIOLoadSave {
	ArrayList<Player> playerList;
	File file;
	String filePath = ".\\CroqueCarotte.sav";

	public boolean saveData(ArrayList<Player> playerList) {
		
		file = new File(filePath);
		String dataToWrite = "";
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		for (Player player: playerList) {
			if (player.getPlayerName() == null) {
				continue;
			}
			// apply score to best score if score is 
			if (player.getScore() > player.getPlayerBestScore()) {
				player.setPlayerBestScore(player.getScore());
			}
			dataToWrite = dataToWrite + player.getPlayerID() + "," + player.getPlayerName() + "," + player.getPlayerColorIndex() + "," + player.getPlayerBestScore() + 
					"," + player.getPositionX() + "," + player.getPositionY() + "\n";

		}
		dataToWrite = dataToWrite + Player.getNumberOfPlayer();

		System.out.println(dataToWrite);
		try {
			fileWriter.write(dataToWrite);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public void loadData(ArrayList<Player> playerList) {
		
		file = new File(filePath);
		BufferedReader br;
		FileReader fileReader;
		String data = "";
		String reg = ",";
		
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			
			for (int i = 0; i < 4; i++) {
				data = br.readLine();
				System.out.println(data);
				String[] playerDataStrings = data.split(reg);
				playerList.get(i).setPlayerID(Integer.parseInt(playerDataStrings[0]));
				playerList.get(i).setPlayerName(playerDataStrings[1]);
				playerList.get(i).setPlayerColorIndex(Integer.parseInt(playerDataStrings[2]));
				playerList.get(i).setPlayerBestScore(Integer.parseInt(playerDataStrings[3]));
				playerList.get(i).setPosition(Integer.parseInt(playerDataStrings[4]),
											  Integer.parseInt(playerDataStrings[5]));
			}
			Player.setNumberOfPlayer(Integer.parseInt(br.readLine()));
			br.close();
			fileReader.close();
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
