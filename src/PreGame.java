import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PreGame extends JPanel{

	DrawMenu drawMenu;
	NumberPlayerMenu numberPlayerMenu;
	NewGameListener newGameListener;

	
	public PreGame() {
		
		// listener
		newGameListener = new NewGameListener(this) ;
		
		// add new 
		numberPlayerMenu = new NumberPlayerMenu();		
		drawMenu = new DrawMenu();
		drawMenu.newGameButton.addActionListener(newGameListener);

		this.setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.setLayout(null);
		this.add(drawMenu);
		this.setOpaque(false);


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
		preGame.add(new NumberPlayerMenu());
		//preGame.drawMenu.setVisible(false);
		preGame.remove(preGame.drawMenu);
		preGame.validate();
		preGame.repaint();
		System.out.println("is it working");
	}
}