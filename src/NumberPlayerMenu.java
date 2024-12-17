import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberPlayerMenu extends JPanel {

	int positionX;
	int positionY;
	
	//label number of players
	JPanel 		numberOfPlayerJPanel;
	JLabel 		numberOfPlayerJLabel;
	
	// Panel for number of players buttons
	JPanel 		numberOfPlayerButtonJPanel;
	JButton 	numberOfPlayer2Button;
	JButton 	numberOfPlayer3Button;
	JButton 	numberOfPlayer4Button;
	
	// Panel for the info of each players
	// player 1
	JPanel 		player1JPanel;
	JLabel 		player1NameJLabel;
	JTextField 	player1NameTextField;
	JLabel 		player1ColorSelectionJLabel;
	JButton 	player1LeftColorSelectionButton;
	JButton 	player1RightColorSelectionButton;
	JLabel 		player1ColorDisplayBox;
	
	// player 2
	JPanel 		player2JPanel;
	JLabel 		player2NameJLabel;
	JTextField 	player2NameTextField;
	JLabel 		player2ColorSelectionJLabel;
	JButton 	player2LeftColorSelectionButton;
	JButton 	player2RightColorSelectionButton;
	JLabel 		player2ColorDisplayBox;	
	
	// player 3
	JPanel 		player3JPanel;
	JLabel 		player3NameJLabel;
	JTextField 	player3NameTextField;
	JLabel 		player3ColorSelectionJLabel;
	JButton 	player3LeftColorSelectionButton;
	JButton 	player3RightColorSelectionButton;
	JLabel 		player3ColorDisplayBox;	
	
	// player 4
	JPanel 		player4JPanel;
	JLabel 		player4NameJLabel;
	JTextField 	player4NameTextField;
	JLabel 		player4ColorSelectionJLabel;
	JButton 	player4LeftColorSelectionButton;
	JButton 	player4RightColorSelectionButton;
	JLabel 		player4ColorDisplayBox;	
	
	JPanel startJPanel;
	JButton startButton;
	JButton backButton;
	
	
	
	int buttonWidth = 300;
	int mainMenuX = 700;
	int mainMenuY = 350;
	int panelHeight = 40;
	public int test = 0;
	boolean isOpaque = false; 
	Font labelFonts;
	Font buttonFont;
	FlowLayout flowLayout;
	Color labelColor;
	public final Color[] playerColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN,Color.ORANGE};
	
	public NumberPlayerMenu() {
		
		labelFonts = new Font("Arial", Font.PLAIN, 25);
		buttonFont = new Font("Arial", Font.PLAIN, 20);
		flowLayout = new FlowLayout();
		labelColor = new Color(255,255,255);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		numberOfPlayerJPanel = new JPanel();
		numberOfPlayerJPanel.setOpaque(isOpaque);
		numberOfPlayerJPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		numberOfPlayerJPanel.setBackground(Color.blue);
		numberOfPlayerJLabel = new JLabel("Choose the number of players");
		numberOfPlayerJLabel.setFont(new Font("Arial", Font.BOLD, 30));
		numberOfPlayerJLabel.setForeground(labelColor);
		numberOfPlayerJPanel.add(numberOfPlayerJLabel);
		
		numberOfPlayerButtonJPanel = new JPanel();
		numberOfPlayerButtonJPanel.setOpaque(isOpaque);
		numberOfPlayerButtonJPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		numberOfPlayerButtonJPanel.setBackground(Color.blue);
		numberOfPlayer2Button = new JButton("2 Players");
		numberOfPlayer3Button = new JButton("3 Players");
		numberOfPlayer4Button = new JButton("4 Players");
		numberOfPlayer2Button.setFont(buttonFont);
		numberOfPlayer3Button.setFont(buttonFont);
		numberOfPlayer4Button.setFont(buttonFont);
		numberOfPlayerButtonJPanel.add(numberOfPlayer2Button);
		numberOfPlayerButtonJPanel.add(numberOfPlayer3Button);
		numberOfPlayerButtonJPanel.add(numberOfPlayer4Button);
		
		player1JPanel = new JPanel();
		player1JPanel.setOpaque(isOpaque);
		//player1JPanel.setLayout(flowLayout);
		player1JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player1JPanel.setBackground(Color.blue);
		player1NameJLabel = new JLabel("Player 1 name :");
		player1NameJLabel.setFont(labelFonts);
		player1NameJLabel.setForeground(labelColor);
		player1NameTextField = new JTextField("Player 1 name");
		player1NameTextField.setFont(buttonFont);
		player1NameTextField.setPreferredSize(new Dimension(170, 30));
		player1ColorSelectionJLabel = new JLabel("  Choose color :");
		player1ColorSelectionJLabel.setFont(labelFonts);
		player1ColorSelectionJLabel.setForeground(labelColor);
		player1LeftColorSelectionButton = new JButton("<");
		player1RightColorSelectionButton = new JButton(">");
		player1ColorDisplayBox = new JLabel();
		player1ColorDisplayBox.setOpaque(true);
		player1ColorDisplayBox.setBackground(Color.GREEN);
		player1ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		player1JPanel.add(player1NameJLabel);
		player1JPanel.add(player1NameTextField);
		player1JPanel.add(player1ColorSelectionJLabel);
		player1JPanel.add(player1LeftColorSelectionButton);
		player1JPanel.add(player1RightColorSelectionButton);
		player1JPanel.add(player1ColorDisplayBox);
		
		player2JPanel = new JPanel();
		player2JPanel.setOpaque(isOpaque);
		player2JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player2JPanel.setBackground(Color.blue);
		player2NameJLabel = new JLabel("Player 2 name :");
		player2NameJLabel.setFont(labelFonts);
		player2NameJLabel.setForeground(labelColor);
		player2NameTextField = new JTextField("Player 2 name");
		player2NameTextField.setFont(buttonFont);
		player2NameTextField.setPreferredSize(new Dimension(170, 30));
		player2ColorSelectionJLabel = new JLabel("  Choose color :");
		player2ColorSelectionJLabel.setFont(labelFonts);
		player2ColorSelectionJLabel.setForeground(labelColor);
		player2LeftColorSelectionButton = new JButton("<");
		player2RightColorSelectionButton = new JButton(">");
		player2ColorDisplayBox = new JLabel();
		player2ColorDisplayBox.setOpaque(true);
		player2ColorDisplayBox.setBackground(Color.GREEN);
		player2ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		player2JPanel.add(player2NameJLabel);
		player2JPanel.add(player2NameTextField);
		player2JPanel.add(player2ColorSelectionJLabel);
		player2JPanel.add(player2LeftColorSelectionButton);
		player2JPanel.add(player2RightColorSelectionButton);
		player2JPanel.add(player2ColorDisplayBox);
		
		player3JPanel = new JPanel();
		player3JPanel.setOpaque(isOpaque);
		player3JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player3JPanel.setBackground(Color.blue);
		player3NameJLabel = new JLabel("Player 3 name :");
		player3NameJLabel.setFont(labelFonts);
		player3NameJLabel.setForeground(labelColor);
		player3NameTextField = new JTextField("Player 3 name");
		player3NameTextField.setFont(buttonFont);
		player3NameTextField.setPreferredSize(new Dimension(170, 30));
		player3ColorSelectionJLabel = new JLabel("  Choose color :");
		player3ColorSelectionJLabel.setFont(labelFonts);
		player3ColorSelectionJLabel.setForeground(labelColor);
		player3LeftColorSelectionButton = new JButton("<");
		player3RightColorSelectionButton = new JButton(">");
		player3ColorDisplayBox = new JLabel();
		player3ColorDisplayBox.setOpaque(true);
		player3ColorDisplayBox.setBackground(Color.GREEN);
		player3ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		player3JPanel.add(player3NameJLabel);
		player3JPanel.add(player3NameTextField);
		player3JPanel.add(player3ColorSelectionJLabel);
		player3JPanel.add(player3LeftColorSelectionButton);
		player3JPanel.add(player3RightColorSelectionButton);
		player3JPanel.add(player3ColorDisplayBox);
		
		player4JPanel = new JPanel();
		player4JPanel.setOpaque(isOpaque);
		player4JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player4JPanel.setBackground(Color.blue);
		player4NameJLabel = new JLabel("Player 4 name :");
		player4NameJLabel.setFont(labelFonts);
		player4NameJLabel.setForeground(labelColor);
		player4NameTextField = new JTextField("Player 4 name");
		player4NameTextField.setFont(buttonFont);
		player4NameTextField.setPreferredSize(new Dimension(170, 30));
		player4ColorSelectionJLabel = new JLabel("  Choose color :");
		player4ColorSelectionJLabel.setFont(labelFonts);
		player4ColorSelectionJLabel.setForeground(labelColor);
		player4LeftColorSelectionButton = new JButton("<");
		player4RightColorSelectionButton = new JButton(">");
		player4ColorDisplayBox = new JLabel();
		player4ColorDisplayBox.setOpaque(true);
		player4ColorDisplayBox.setBackground(Color.GREEN);
		player4ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		player4JPanel.add(player4NameJLabel);
		player4JPanel.add(player4NameTextField);
		player4JPanel.add(player4ColorSelectionJLabel);
		player4JPanel.add(player4LeftColorSelectionButton);
		player4JPanel.add(player4RightColorSelectionButton);
		player4JPanel.add(player4ColorDisplayBox);
		
		startJPanel = new JPanel();
		startJPanel.setOpaque(isOpaque);
		startJPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		startJPanel.setBackground(Color.blue);
		startButton = new JButton("Start game");
		startButton.setFont(buttonFont);
		backButton = new JButton("Go back to main menu");
		backButton.setFont(buttonFont);
		startJPanel.add(startButton);
		startJPanel.add(backButton);
		/*
		newGameButton = new JButton();
		newGameButton.setSize(buttonWidth, newGameButton.getHeight());
		newGameButton.setMinimumSize(new Dimension(buttonWidth, newGameButton.getHeight()));
		newGameButton.setFont(new Font("Arial", Font.BOLD, 35));
		newGameButton.setText("New Game");
		*/

		
		
		this.add(numberOfPlayerJPanel);
		this.add(numberOfPlayerButtonJPanel);
		this.add(player1JPanel);
		this.add(player2JPanel);
		this.add(player3JPanel);
		this.add(player4JPanel);
		this.add(startJPanel);
		this.setOpaque(true);
		this.setBackground(new Color(0, 0, 200, 190));
		this.setBorder(BorderFactory.createBevelBorder(15, Color.CYAN, Color.DARK_GRAY));
		//this.setPreferredSize(new Dimension(mainMenuX, 30));
		
		this.setBounds(getPosition(CroqueCarotte.getScreenWidthX(), mainMenuX), 
				getPosition(CroqueCarotte.getScreenHeightY(), mainMenuY), 
				mainMenuX, 
				mainMenuY);
		
	}
	private int  getPosition(int parentValue, int thisValue) {
		int parentHalf = parentValue / 2;
		int thisValueHalf = thisValue / 2;
		return parentHalf - thisValueHalf;
	}
	class colorChanger implements ActionListener {
		NumberPlayerMenu thisClass;
		
		public colorChanger(NumberPlayerMenu thisClass) {
			this.thisClass = thisClass;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

	
	
}
