import javax.swing.JPanel;


public class TitleScreen extends JPanel{
	Background background;
	PreGame preGame;

	
	public TitleScreen() {
		
		this.setBounds(0, 0, CroqueCarotte.getScreenWidthX(), CroqueCarotte.getScreenHeightY());
		
		preGame = new PreGame();
		background = new Background(".\\Graphics\\main_screen.png");
		this.setLayout(null);
		
		this.add(preGame);
		this.add(background);
		
		
	}

}
