package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class NumberPlayerMenu extends JPanel {

	int positionX;
	int positionY;
	static int lastSelected = 1;
	

	Background background;
	JPanel backgroundJPanel;
	
	//label number of players
	JPanel 		numberOfPlayerJPanel;
	JLabel 		numberOfPlayerJLabel;
	
	// Panel for number of players buttons
	JPanel 		numberOfPlayerButtonJPanel;
	JToggleButton 	numberOfPlayer2Button;
	JToggleButton 	numberOfPlayer3Button;
	JToggleButton 	numberOfPlayer4Button;
	ButtonGroup numberOfPlayerButtonGroup;
	
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
	
	public NumberPlayerMenu() {
		
		labelFonts = new Font("Arial", Font.PLAIN, 25);
		buttonFont = new Font("Arial", Font.PLAIN, 20);
		flowLayout = new FlowLayout();
		labelColor = new Color(255,255,255);
		flowLayout.setAlignment(FlowLayout.LEFT);

		backgroundJPanel = new JPanel();
		background = new Background(".\\Graphics\\main_screen.png");
		
		// First Panel
		numberOfPlayerJPanel = new JPanel();
		numberOfPlayerJPanel.setOpaque(isOpaque);
		numberOfPlayerJPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		numberOfPlayerJPanel.setBackground(Color.blue);
		
		numberOfPlayerJLabel = new JLabel("Choose the number of players");
		numberOfPlayerJLabel.setFont(new Font("Arial", Font.BOLD, 30));
		numberOfPlayerJLabel.setForeground(labelColor);
		
		// Second panel
		numberOfPlayerJPanel.add(numberOfPlayerJLabel);
		
		numberOfPlayerButtonJPanel = new JPanel();
		numberOfPlayerButtonJPanel.setOpaque(isOpaque);
		numberOfPlayerButtonJPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		numberOfPlayerButtonJPanel.setBackground(Color.blue);
		
		numberOfPlayer2Button = new JToggleButton("2 Players");
		numberOfPlayer2Button.setFont(buttonFont);
		numberOfPlayer2Button.setSelected(true);
		numberOfPlayer2Button.addActionListener(new ToogleNumberOfPlayers(this));
		
		numberOfPlayer3Button = new JToggleButton("3 Players");
		numberOfPlayer3Button.setFont(buttonFont);
		numberOfPlayer3Button.addActionListener(new ToogleNumberOfPlayers(this));
		
		numberOfPlayer4Button = new JToggleButton("4 Players");
		numberOfPlayer4Button.setFont(buttonFont);
		numberOfPlayer4Button.addActionListener(new ToogleNumberOfPlayers(this));
		
		numberOfPlayerButtonGroup = new ButtonGroup();
		numberOfPlayerButtonGroup.add(numberOfPlayer2Button);
		numberOfPlayerButtonGroup.add(numberOfPlayer3Button);
		numberOfPlayerButtonGroup.add(numberOfPlayer4Button);
				
		numberOfPlayerButtonJPanel.add(numberOfPlayer2Button);
		numberOfPlayerButtonJPanel.add(numberOfPlayer3Button);
		numberOfPlayerButtonJPanel.add(numberOfPlayer4Button);
		
		// Player 1 panel
		player1JPanel = new JPanel();
		player1JPanel.setOpaque(isOpaque);
		player1JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player1JPanel.setBackground(Color.blue);
		
		player1NameJLabel = new JLabel("Player 1 name :");
		player1NameJLabel.setFont(labelFonts);
		player1NameJLabel.setForeground(labelColor);
		
		player1NameTextField = new JTextField();
		player1NameTextField.setFont(buttonFont);
		player1NameTextField.setPreferredSize(new Dimension(170, 30));
		player1NameTextField.setText(CroqueCarotte.player1.getPlayerName());
		
		player1ColorSelectionJLabel = new JLabel("  Choose color :");
		player1ColorSelectionJLabel.setFont(labelFonts);
		player1ColorSelectionJLabel.setForeground(labelColor);
		
		player1LeftColorSelectionButton = new JButton("<");
		player1LeftColorSelectionButton.addActionListener(new ColorChanger(this, Direction.LEFT, CroqueCarotte.player1));
		
		player1RightColorSelectionButton = new JButton(">");
		player1RightColorSelectionButton.addActionListener(new ColorChanger(this, Direction.RIGHT, CroqueCarotte.player1));
		
		player1ColorDisplayBox = new JLabel();
		player1ColorDisplayBox.setOpaque(true);
		player1ColorDisplayBox.setBackground(CroqueCarotte.player1.getPlayerColor());
		player1ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		
		player1JPanel.add(player1NameJLabel);
		player1JPanel.add(player1NameTextField);
		player1JPanel.add(player1ColorSelectionJLabel);
		player1JPanel.add(player1LeftColorSelectionButton);
		player1JPanel.add(player1RightColorSelectionButton);
		player1JPanel.add(player1ColorDisplayBox);

		// Player 2 panel
		player2JPanel = new JPanel();
		player2JPanel.setOpaque(isOpaque);
		player2JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player2JPanel.setBackground(Color.blue);
		
		player2NameJLabel = new JLabel("Player 2 name :");
		player2NameJLabel.setFont(labelFonts);
		player2NameJLabel.setForeground(labelColor);
		
		player2NameTextField = new JTextField();
		player2NameTextField.setFont(buttonFont);
		player2NameTextField.setPreferredSize(new Dimension(170, 30));
		player2NameTextField.setText(CroqueCarotte.player2.getPlayerName());
		
		player2ColorSelectionJLabel = new JLabel("  Choose color :");
		player2ColorSelectionJLabel.setFont(labelFonts);
		player2ColorSelectionJLabel.setForeground(labelColor);
		
		player2LeftColorSelectionButton = new JButton("<");
		player2LeftColorSelectionButton.addActionListener(new ColorChanger(this, Direction.LEFT, CroqueCarotte.player2));
		
		player2RightColorSelectionButton = new JButton(">");
		player2RightColorSelectionButton.addActionListener(new ColorChanger(this, Direction.RIGHT, CroqueCarotte.player2));
		
		player2ColorDisplayBox = new JLabel();
		player2ColorDisplayBox.setOpaque(true);
		player2ColorDisplayBox.setBackground(CroqueCarotte.player2.getPlayerColor());
		player2ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		
		player2JPanel.add(player2NameJLabel);
		player2JPanel.add(player2NameTextField);
		player2JPanel.add(player2ColorSelectionJLabel);
		player2JPanel.add(player2LeftColorSelectionButton);
		player2JPanel.add(player2RightColorSelectionButton);
		player2JPanel.add(player2ColorDisplayBox);
		
		// Player 3 panel
		player3JPanel = new JPanel();
		player3JPanel.setOpaque(isOpaque);
		player3JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player3JPanel.setBackground(Color.blue);
		
		player3NameJLabel = new JLabel("Player 3 name :");
		player3NameJLabel.setFont(labelFonts);
		player3NameJLabel.setForeground(labelColor);
		
		player3NameTextField = new JTextField();
		player3NameTextField.setFont(buttonFont);
		player3NameTextField.setPreferredSize(new Dimension(170, 30));
		player3NameTextField.setText(CroqueCarotte.player3.getPlayerName());
		
		player3ColorSelectionJLabel = new JLabel("  Choose color :");
		player3ColorSelectionJLabel.setFont(labelFonts);
		player3ColorSelectionJLabel.setForeground(labelColor);
		
		player3LeftColorSelectionButton = new JButton("<");
		player3LeftColorSelectionButton.addActionListener(new ColorChanger(this, Direction.LEFT, CroqueCarotte.player3));
		
		player3RightColorSelectionButton = new JButton(">");
		player3RightColorSelectionButton.addActionListener(new ColorChanger(this, Direction.RIGHT, CroqueCarotte.player3));
		
		player3ColorDisplayBox = new JLabel();
		player3ColorDisplayBox.setOpaque(true);
		player3ColorDisplayBox.setBackground(CroqueCarotte.player3.getPlayerColor());
		player3ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		
		player3JPanel.add(player3NameJLabel);
		player3JPanel.add(player3NameTextField);
		player3JPanel.add(player3ColorSelectionJLabel);
		player3JPanel.add(player3LeftColorSelectionButton);
		player3JPanel.add(player3RightColorSelectionButton);
		player3JPanel.add(player3ColorDisplayBox);
		
		// Player 4 panel
		player4JPanel = new JPanel();
		player4JPanel.setOpaque(isOpaque);
		player4JPanel.setPreferredSize(new Dimension(mainMenuX, panelHeight));
		player4JPanel.setBackground(Color.blue);
		
		player4NameJLabel = new JLabel("Player 4 name :");
		player4NameJLabel.setFont(labelFonts);
		player4NameJLabel.setForeground(labelColor);
		
		player4NameTextField = new JTextField();
		player4NameTextField.setFont(buttonFont);
		player4NameTextField.setPreferredSize(new Dimension(170, 30));
		player4NameTextField.setText(CroqueCarotte.player4.getPlayerName());
		
		player4ColorSelectionJLabel = new JLabel("  Choose color :");
		player4ColorSelectionJLabel.setFont(labelFonts);
		player4ColorSelectionJLabel.setForeground(labelColor);
		
		player4LeftColorSelectionButton = new JButton("<");
		player4LeftColorSelectionButton.addActionListener(new ColorChanger(this, Direction.LEFT, CroqueCarotte.player4));
		
		player4RightColorSelectionButton = new JButton(">");
		player4RightColorSelectionButton.addActionListener(new ColorChanger(this, Direction.RIGHT, CroqueCarotte.player4));
		
		player4ColorDisplayBox = new JLabel();
		player4ColorDisplayBox.setOpaque(true);
		player4ColorDisplayBox.setBackground(CroqueCarotte.player4.getPlayerColor());
		player4ColorDisplayBox.setPreferredSize(new Dimension(30, 30));
		
		player4JPanel.add(player4NameJLabel);
		player4JPanel.add(player4NameTextField);
		player4JPanel.add(player4ColorSelectionJLabel);
		player4JPanel.add(player4LeftColorSelectionButton);
		player4JPanel.add(player4RightColorSelectionButton);
		player4JPanel.add(player4ColorDisplayBox);
		
		// start and back button panel
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
		
		backgroundJPanel.add(numberOfPlayerJPanel);
		backgroundJPanel.add(numberOfPlayerButtonJPanel);
		backgroundJPanel.add(player1JPanel);
		backgroundJPanel.add(player2JPanel);
		backgroundJPanel.add(player3JPanel);
		backgroundJPanel.add(player4JPanel);
		backgroundJPanel.add(startJPanel);
		backgroundJPanel.setOpaque(true);
		backgroundJPanel.setBackground(new Color(0, 0, 200, 190));
		backgroundJPanel.setBorder(BorderFactory.createBevelBorder(15, Color.CYAN, Color.DARK_GRAY));
		backgroundJPanel.setBounds(getPosition(CroqueCarotte.getScreenWidthX(), mainMenuX), 
				getPosition(CroqueCarotte.getScreenHeightY(), mainMenuY), 
				mainMenuX, 
				mainMenuY);
		
		this.add(backgroundJPanel);
		this.add(background);
		this.setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		this.setLayout(null);
		
		updateNumberOfPlayers(Player.getNumberOfPlayer());
	}
	public void refreshField() {
		player1NameTextField.setText(CroqueCarotte.player1.getPlayerName());
		player1ColorDisplayBox.setBackground(CroqueCarotte.player1.getPlayerColor());
		player2NameTextField.setText(CroqueCarotte.player2.getPlayerName());
		player2ColorDisplayBox.setBackground(CroqueCarotte.player2.getPlayerColor());
		player3NameTextField.setText(CroqueCarotte.player3.getPlayerName());
		player3ColorDisplayBox.setBackground(CroqueCarotte.player3.getPlayerColor());
		player4NameTextField.setText(CroqueCarotte.player4.getPlayerName());
		player4ColorDisplayBox.setBackground(CroqueCarotte.player4.getPlayerColor());
		if (Player.getNumberOfPlayer() == 2) {
			numberOfPlayer2Button.setSelected(true);
		}
		if (Player.getNumberOfPlayer() == 3) {
			numberOfPlayer3Button.setSelected(true);
		}
		if (Player.getNumberOfPlayer() == 4) {
			numberOfPlayer4Button.setSelected(true);
		}
	}
	
	
	public void saveDataToPlayers() {
		
		CroqueCarotte.player1.setPlayerName(checkName(player1NameTextField.getText(),1));
		CroqueCarotte.player2.setPlayerName(checkName(player2NameTextField.getText(),2));
		CroqueCarotte.player3.setPlayerName(checkName(player3NameTextField.getText(),3));
		CroqueCarotte.player4.setPlayerName(checkName(player4NameTextField.getText(),4));
	}
	
	
	private String checkName(String name, int playerID) {
		
		if (name.equals("")) {
			name = "Player " + playerID;
		}
		return name;
	}

	
	private int  getPosition(int parentValue, int thisValue) {
		
		int parentHalf = parentValue / 2;
		int thisValueHalf = thisValue / 2;
		return parentHalf - thisValueHalf;
	}
	
	
	public void updateNumberOfPlayers(int nbrPlayer) {
		
		if (nbrPlayer == 2) {
			Player.setNumberOfPlayer(2);
			player3JPanel.setVisible(false);;
			player4JPanel.setVisible(false);
			lastSelected = 1;
		}
		if (nbrPlayer == 3) {
			Player.setNumberOfPlayer(3);
			player3JPanel.setVisible(true);
			player4JPanel.setVisible(false);
			if (CroqueCarotte.player3.checkDuplicatePlayerColor()) {
				CroqueCarotte.player3.updateColor(Direction.RIGHT);
			}
			player3ColorDisplayBox.setBackground(CroqueCarotte.player3.getPlayerColor());
			lastSelected = 2;
		}
		if (nbrPlayer == 4) {
			Player.setNumberOfPlayer(4);
			player3JPanel.setVisible(true);
			player4JPanel.setVisible(true);
			if (CroqueCarotte.player3.checkDuplicatePlayerColor()) {
				CroqueCarotte.player3.updateColor(Direction.RIGHT);
			}
			
			if (CroqueCarotte.player4.checkDuplicatePlayerColor()) {
				CroqueCarotte.player4.updateColor(Direction.RIGHT);
			}
			
			player3ColorDisplayBox.setBackground(CroqueCarotte.player3.getPlayerColor());
			player4ColorDisplayBox.setBackground(CroqueCarotte.player4.getPlayerColor());
			lastSelected = 3;
		}
		PlayScreen.currentPlayerList.clear();
		for (int i = 0; i < Player.getNumberOfPlayer(); i++) {
			PlayScreen.currentPlayerList.add(Player.getPlayerList().get(i));
		}
		this.repaint();
	}
	
	
	class ColorChanger implements ActionListener {
		
		NumberPlayerMenu thisClass;
		Direction direction;
		Player player;
		
		public ColorChanger(NumberPlayerMenu thisClass, Direction direction, Player player) {
			this.thisClass = thisClass;
			this.direction = direction;
			this.player = player;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			player.updateColor(direction);
			System.out.println(player.getPlayerColor());
			switch (player.getPlayerID()) {
			case 0:
				thisClass.player1ColorDisplayBox.setBackground(player.getPlayerColor());
				break;
			case 1:
				thisClass.player2ColorDisplayBox.setBackground(player.getPlayerColor());
				break;
			case 2:
				thisClass.player3ColorDisplayBox.setBackground(player.getPlayerColor());
				break;
			case 3:
				thisClass.player4ColorDisplayBox.setBackground(player.getPlayerColor());
				break;
			}
		}
	}
	
	
	class ToogleNumberOfPlayers implements ActionListener {
		NumberPlayerMenu thisClass;

		
		public ToogleNumberOfPlayers(NumberPlayerMenu thisClass) {
			this.thisClass = thisClass;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == thisClass.numberOfPlayer2Button && lastSelected != 1) {
				updateNumberOfPlayers(2);
			}
			if (e.getSource() == thisClass.numberOfPlayer3Button && lastSelected != 2) {
				updateNumberOfPlayers(3);
			}
			if (e.getSource() == thisClass.numberOfPlayer4Button && lastSelected != 3) {
				updateNumberOfPlayers(4);
			}
		}
	}
}
