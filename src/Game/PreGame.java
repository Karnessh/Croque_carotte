package Game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PreGame extends JFrame{

	DrawMenu drawMenu;
	NumberPlayerMenu numberPlayerMenu;
	PlayScreen playScreen;
	NewGameListener newGameListener;
	Point point;
	JPanel mainWindowJPanel;
	Background background;


	public PreGame() {
		
		newGameListener = new NewGameListener(this);
		background = new Background(".\\Graphics\\main_screen.png");
		point = new Point(CroqueCarotte.getScreenWidthX()/2,CroqueCarotte.getScreenHeightY()/2);
		
		drawMenu = new DrawMenu();
		drawMenu.newGameButton.addActionListener(newGameListener);
		
		numberPlayerMenu = new NumberPlayerMenu();	
		numberPlayerMenu.backButton.addActionListener(newGameListener);
		numberPlayerMenu.startButton.addActionListener(newGameListener);
		
		playScreen = new PlayScreen();
		
		mainWindowJPanel = new JPanel();
		mainWindowJPanel.setPreferredSize(new Dimension(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY()));
		mainWindowJPanel.setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		mainWindowJPanel.setLayout(null);
		mainWindowJPanel.add(drawMenu);
		mainWindowJPanel.setOpaque(false);
		
		
		
		this.setTitle("Croque Carotte");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(point);

		//this.setSize(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		setPreferredSize(new Dimension(CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY() + 30));
		
		
		
		this.add(mainWindowJPanel);
		this.add(background);
		this.pack();

		JOptionPane.showMessageDialog(null, "The original game is copywrited by ____ and some of the image included in this application are too.\n"
				+ " This game is only for educational purpose and should not be distributed" , "Warning" , JOptionPane.INFORMATION_MESSAGE);
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


	}
}