package Game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawMenu extends JPanel implements ActionListener{
	
	int positionX;
	int positionY;
	FlowLayout flowLayout;
	JButton newGameButton;
	JButton exitGameButton;
	int buttonWidth = 300;
	int mainMenuX = 400;
	int mainMenuY = 200;
	public int test = 0;
	
	public DrawMenu() {
		
		newGameButton = new JButton();
		newGameButton.setSize(buttonWidth, newGameButton.getHeight());
		newGameButton.setMinimumSize(new Dimension(buttonWidth, newGameButton.getHeight()));
		newGameButton.setFont(new Font("Arial", Font.BOLD, 35));
		newGameButton.setText("New Game");
		
		exitGameButton = new JButton();
		exitGameButton.setSize(buttonWidth, exitGameButton.getHeight());
		exitGameButton.setMinimumSize(new Dimension(buttonWidth, newGameButton.getHeight()));
		exitGameButton.setFont(new Font("Arial", Font.BOLD, 35));
		exitGameButton.addActionListener(this);
		exitGameButton.setText("Exit game");
		
		
		flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		
		this.add(newGameButton);
		this.add(exitGameButton);
		this.setLayout(flowLayout);
		this.setOpaque(false);
		
		this.setBounds(getPosition(CroqueCarotte.getScreenWidthX(), mainMenuX), 
				getPosition(CroqueCarotte.getScreenHeightY()+200, mainMenuY), 
				mainMenuX, 
				mainMenuY);
		
	}
	private int  getPosition(int parentValue, int thisValue) {
		int parentHalf = parentValue / 2;
		int thisValueHalf = thisValue / 2;
		return parentHalf - thisValueHalf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	
	
	

}
