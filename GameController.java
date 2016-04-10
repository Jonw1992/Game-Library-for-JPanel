import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class GameController extends Game
{
		private int testStart = 0;
		private int testPaint = 0;
		private int testCalculate = 0;
		
		
		//Initializion here -------------------------------------------------------------------------------------------------
		public GameController()
		{
			testStart=testPaint=testCalculate=0;
			testStart++;
			super.startTheGame();
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			
		}
		
		
		//Handle all painting here -----------------------------------------------------------------------------------------
		public void paintIt(Graphics g)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString("Started: " + Integer.toString(testStart),20,20);
			g.drawString("At Frame: " + Integer.toString(testPaint), 20, 40);
			g.drawString("At Calculate: " + Integer.toString(testCalculate), 20, 60);
			g.drawRect(testPaint,100,50,50);

			testPaint++;
		}
		
		//Handle all calculations that don't need to be syncrhronized with framerate here----------------------------
		public void calculateIt()
		{
			
			testCalculate++;
		}
			
		//A better method of moving a game object than Keylistener provides. It is synchronized with framerate.--
		@Override
		public void onKeyHeld(KeyEvent e)
		{

			
		}		
		@Override
		
		//These are called from a standard KeyListener-------------------------------------------------------------------
		public void onKeyDown(KeyEvent e)
		{

			
		}
		
		@Override
		public void onKeyReleased(KeyEvent e)
		{

		}
		
		@Override
		public void onKeyTyped(KeyEvent e)
		{
		}	
		//-----------------------------------------------------------------------------------------------------------------------
}