import java.awt.*;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import javax.swing.*;


	public abstract class Game extends JPanel
	{
		//Screen and framerate informaion
		protected final int SCREENX = 1366;
		protected final int SCREENY = 768;
		protected final int FRAMERATE = 60;
		
		//Graphics buffer to calculate paint things behind the scenes before painting that to the screen 
		
		//Some key information to determine if a key is being held down or not 
		private KeyEvent event;
		private boolean keyHeld;
		
		
		//Methods to be overridden in extending class that will control the game 
		public abstract void paintIt(Graphics g);
		public abstract void calculateIt();
		public abstract void onKeyDown(KeyEvent e);
		public abstract void onKeyReleased(KeyEvent e);
		public abstract void onKeyTyped(KeyEvent e);
		public abstract void onKeyHeld(KeyEvent e);
		
		//initialize
		public void startTheGame() 
		{
			addKeyListener(new KeyListener());
			new PaintThread().start();

		}
		

		
		
		//override paint to draw to screen 
		@Override
		public void paintComponent(Graphics g) 
		{
						super.paintComponent(g);
			paintIt(g);

		}
		
		
		//Thread to be synchronized with framerate, for painting to screen
		public class PaintThread extends Thread 
		{
			public void run() 
			{
				new CalculateThread().start();
				while(true)
				{
					//for keeping transition between two buttons held at once smooth
					if(keyHeld)
					{
						onKeyHeld(event);
					}
					repaint();

					try 
					{
						Thread.sleep(1000/FRAMERATE);
					} 
					catch (InterruptedException e) {}
				}
			}
			//Thread that runs as fast as possible for other calculations 
			public class CalculateThread extends Thread 
			{
				public void run() 
				{
					while(true)
					{
						calculateIt();
					}
				}
			}
		}		
		

		
		//KeyListener
		class KeyListener extends KeyAdapter
		{
			public KeyListener(){}
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				onKeyTyped(e);
			}
			@Override
			public void keyPressed(KeyEvent e)
			{
				event = e;
				keyHeld = true;
				onKeyDown(e);
			}
			@Override
			public void keyReleased(KeyEvent e)
			{
				if(event.getKeyCode() == e.getKeyCode())
				{
				keyHeld = false;
				}
				onKeyReleased(e);
			}

		}
		
	}