import java.awt.*; 
import javax.swing.*;

class GameFrame extends JFrame
{
	public GameFrame()
	{
		setTitle("Game");
		setSize(1366,768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new GameController());
		setVisible(true);		
	}
}