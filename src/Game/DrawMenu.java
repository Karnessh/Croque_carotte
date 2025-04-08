package Game;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawMenu extends JPanel implements ActionListener{
	
	public JButton newGameButton;
	public JButton loadGameButton;
	public JButton exitGameButton;
	
	private PreGame preGame;
	private FlowLayout flowLayout;

	private int buttonWidth = 300;
	private int mainMenuX = 400;
	private int mainMenuY = 200;
	
	public DrawMenu(PreGame preGame) {
		
		this.preGame = preGame;
		newGameButton = new JButton();
		newGameButton.setSize(buttonWidth, newGameButton.getHeight());
		newGameButton.setMinimumSize(new Dimension(buttonWidth, newGameButton.getHeight()));
		newGameButton.setFont(new Font("Arial", Font.BOLD, 35));
		newGameButton.setText("New Game");
		
		loadGameButton = new JButton();
		loadGameButton.setSize(buttonWidth, newGameButton.getHeight());
		loadGameButton.setMinimumSize(new Dimension(buttonWidth, newGameButton.getHeight()));
		loadGameButton.setFont(new Font("Arial", Font.BOLD, 35));
		loadGameButton.setText("Load previous Game");
		loadGameButton.setVisible(false);
		
		exitGameButton = new JButton();
		exitGameButton.setSize(buttonWidth, exitGameButton.getHeight());
		exitGameButton.setMinimumSize(new Dimension(buttonWidth, newGameButton.getHeight()));
		exitGameButton.setFont(new Font("Arial", Font.BOLD, 35));
		exitGameButton.addActionListener(this);
		exitGameButton.setText("Exit game");
		
		
		flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		
		this.add(newGameButton);
		this.add(loadGameButton);
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
		preGame.confirmClosing();
	}
}
