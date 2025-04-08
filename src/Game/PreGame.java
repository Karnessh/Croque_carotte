package Game;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PreGame extends JFrame {

	DrawMenu drawMenu;
	NumberPlayerMenu numberPlayerMenu;
	PlayScreen playScreen;
	NewGameListener newGameListener;
	JPanel mainWindowJPanel;
	Background background;
	CCIOLoadSave ccioLoadSave;
	private Point point;


	public PreGame() {
		
		ccioLoadSave = new CCIOLoadSave();
		newGameListener = new NewGameListener(this);
		background = new Background(".\\Graphics\\main_screen.png");
		point = new Point(CroqueCarotte.getScreenWidthX()/2,CroqueCarotte.getScreenHeightY()/2);
		
		drawMenu = new DrawMenu(this);
		drawMenu.newGameButton.addActionListener(newGameListener);
		drawMenu.loadGameButton.addActionListener(newGameListener);
		
		numberPlayerMenu = new NumberPlayerMenu();	
		numberPlayerMenu.backButton.addActionListener(newGameListener);
		numberPlayerMenu.startButton.addActionListener(newGameListener);
		
		playScreen = new PlayScreen();
		playScreen.backButton.addActionListener(newGameListener);		
		
		mainWindowJPanel = new JPanel();
		mainWindowJPanel.setPreferredSize(new Dimension(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY()));
		mainWindowJPanel.setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		mainWindowJPanel.setLayout(null);
		mainWindowJPanel.add(drawMenu);
		mainWindowJPanel.setOpaque(false);
		
		this.setTitle("Croque Carotte");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new PreGameWindowsAdapter(this));
		this.setLocation(point);

		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		setPreferredSize(new Dimension(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY() + 30));
		
		this.add(mainWindowJPanel);
		this.add(background);
		this.pack();
		
		// check if a file with players in it already exist
		String filePath = ".\\CroqueCarotte.sav";
		File file = new File(filePath);
		
		if (file.exists()) {
			this.drawMenu.loadGameButton.setVisible(true);
		}

		// Disclaimer because this is based on a table top game
		JOptionPane.showMessageDialog(null, "The original game this is based on is copywrited by Ravensburger and some of the images included in this application are too.\n"
				+ " This game is only for educational purpose and should not be distributed." , "Warning" , JOptionPane.INFORMATION_MESSAGE);
	}
	

	void confirmClosing() {
		
		int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (answer == JOptionPane.OK_OPTION) {
			ccioLoadSave.saveData(Player.getPlayerList());
			System.exit(0);
		}
	}
}


class PreGameWindowsAdapter extends WindowAdapter {
	
	PreGame preGame;
	
	public PreGameWindowsAdapter(PreGame preGame) {
		this.preGame = preGame;
	}
	@Override
	public void windowClosing(WindowEvent e) {

		preGame.confirmClosing();
	}
}


class NewGameListener implements ActionListener {
	
	PreGame preGame;
	public NewGameListener(PreGame preGame) {
		this.preGame = preGame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if new game button pressed, erase draw menu and add numberplayermenu
		if ( e.getSource() ==  preGame.drawMenu.loadGameButton) {
			// remove old JFrame
			preGame.mainWindowJPanel.remove(preGame.drawMenu);
			// update players info
			String filePath = ".\\CroqueCarotte.sav";
			File file = new File(filePath);
			
			if (file.exists()) {
				CCIOLoadSave ccioLoadSave = new CCIOLoadSave();
				ccioLoadSave.loadData(Player.getPlayerList());
				preGame.numberPlayerMenu.refreshField();
				preGame.numberPlayerMenu.updateNumberOfPlayers(Player.getNumberOfPlayer());
			}
			// add new JFrame
			preGame.mainWindowJPanel.add(preGame.numberPlayerMenu);
			// repaint all
			preGame.mainWindowJPanel.validate();
			preGame.mainWindowJPanel.repaint();
			System.out.println("is it working");
		}
		
		if ( e.getSource() ==  preGame.drawMenu.newGameButton) {
			
			// remove old JFrame
			preGame.mainWindowJPanel.remove(preGame.drawMenu);
			// add new JFrame
			preGame.mainWindowJPanel.add(preGame.numberPlayerMenu);
			// repaint all
			preGame.mainWindowJPanel.validate();
			preGame.mainWindowJPanel.repaint();
			System.out.println("is it working");
		}
		if ( e.getSource() ==  preGame.numberPlayerMenu.backButton) {
			
			// remove old JFrame
			preGame.numberPlayerMenu.saveDataToPlayers();
			preGame.numberPlayerMenu.refreshField();
			preGame.mainWindowJPanel.remove(preGame.numberPlayerMenu);
			// add new JFrame
			preGame.mainWindowJPanel.add(preGame.drawMenu);
			// repaint all
			preGame.mainWindowJPanel.validate();
			preGame.mainWindowJPanel.repaint();
			System.out.println("is it working");
		}
		if ( e.getSource() ==  preGame.numberPlayerMenu.startButton) {
			
			// remove old JFrame
			preGame.numberPlayerMenu.saveDataToPlayers();
			preGame.numberPlayerMenu.refreshField();
			preGame.mainWindowJPanel.remove(preGame.numberPlayerMenu);
			// add new JFrame
			preGame.mainWindowJPanel.add(preGame.playScreen);
			// repaint all
			preGame.mainWindowJPanel.validate();
			preGame.mainWindowJPanel.repaint();
			System.out.println("is it working");
		}
		if ( e.getSource() ==  preGame.playScreen.backButton) {
			
			// remove old JFrame
			preGame.playScreen.resetGame();
			preGame.mainWindowJPanel.remove(preGame.playScreen);
			// add new JFrame
			preGame.mainWindowJPanel.add(preGame.numberPlayerMenu);
			// repaint all
			preGame.mainWindowJPanel.validate();
			preGame.mainWindowJPanel.repaint();
			System.out.println("is it working");
		}
	}
}