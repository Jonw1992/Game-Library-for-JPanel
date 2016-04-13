import java.awt.*;
import java.util.*;
import java.lang.Object.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class ColliderTester extends Game
{
		private ArrayList<SpriteObject> sprites;
		private SpriteObject player;
		private SpriteObject test;

		//Initializion here -------------------------------------------------------------------------------------------------
		public ColliderTester()
		{
			super.startTheGame();
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);

		}
		
		public void initializeGame()
		{
			sprites = new ArrayList<SpriteObject>();
			sprites.add(new SpriteObject(400,400, 100,100));
			sprites.add(new SpriteObject(700,700, 100,100));
			sprites.add(new SpriteObject(100,100,50,50));
			test = (new SpriteObject(400,100,50,50));
			player = new SpriteObject(700,500,50,50);
		}
		
		
		//Handle all painting here -----------------------------------------------------------------------------------------
		public void paintIt(Graphics g)
		{
			for(int i=0;i<sprites.size();i++)
			{
				SpriteObject s = sprites.get(i);
				g.setColor(Color.BLUE);
				g.fillRect(s.x,s.y,s.w,s.h);				
			}
			
				g.setColor(Color.GREEN);
				g.fillRect(player.x,player.y,player.w,player.h);
				
				g.setColor(Color.GREEN);
				g.fillRect(test.x,test.y,test.w,test.h);
			

		}
		
		//Handle calculations that don't need to be syncrhronized with framerate here----------------------------
		public void calculateIt()
		{
			player.checkCollision(test.c);
			for(SpriteObject s : sprites)
			{
				if(!player.c.collision)
				{
					player.checkCollision(s.c);
				}
			}
			player.update();
		}
			
		//A better method of moving a game object than Keylistener provides. It is synchronized with framerate and detects multiply key presses.
		@Override
		public void onKeyHeld(ArrayList<KeyEvent> e)
		{
			player.moveWithInput(e);
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