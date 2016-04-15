import java.awt.event.KeyEvent;
import java.lang.Object.*;
import java.awt.*;
import java.util.*;


public class SpriteObject
{
		protected int x;
		protected int y; 
		protected int w;
		protected int h; 
		protected Collider c;
		private int speed = 5;
		private SpriteSheet spritesheet;
		
		
		public SpriteObject(String url,int x, int y, int w, int h)
		{
			spritesheet = new SpriteSheet(url);
			this.x = x;
			this.y = y;
			this.w = w; 
			this.h = h; 
			c = new Collider(x,y,w,h);
		}
		
		public SpriteObject(int x, int y, int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w; 
			this.h = h; 
			c = new Collider(x,y,w,h);
		}
		
		public void drawSprite(Graphics2D g)
		{
			g.drawImage(spritesheet.getCurImage() ,x,y,w,h, null);
		}
		
		
		public void up()
		{
			this.y-=speed;
			spritesheet.walkUp();			
		}

		public void down()
		{
			this.y+=speed;
			spritesheet.walkDown();
		}
		
		public void left()
		{
			this.x-=speed;
			spritesheet.walkLeft();
		}
		
		public void right()
		{
			this.x+=speed;
			spritesheet.walkRight();
		}
		
		public void update()
		{
			c.updateCollider(x,y,w,h);
			//spritesheet.update();
		}
		
		public void checkCollision(Collider c)
		{
			this.c.collision(c);
			if(this.c.l)
			{	
				if(this.x < (c.x+c.w))
				{
					this.x = c.x+c.w;
				}
			}
			if(this.c.t)
			{	
				if(this.y < (c.y+c.h))
				{
					this.y = c.y+c.h;
				}
			}
			if(this.c.r)
			{	
				if(this.x + this.w > (c.x))
				{
					this.x = c.x - this.w;
				}
			}
			if(this.c.b)
			{	
				if(this.y + this.h > (c.y))
				{
					this.y = c.y - this.h;
				}
			}
		}
		
		public void moveWithInput(ArrayList<KeyEvent> eList)
		{
			for(KeyEvent e: eList)
			{
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					if(!c.t)
					{
						up();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					if(!c.b)
					{
						down();
					}	
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if(!c.l)
					{
						left();
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if(!c.r)
					{				
						right();
					}
				}
			}
		}
		

}