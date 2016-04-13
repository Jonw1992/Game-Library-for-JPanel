public class SpriteObject
{
		protected int x;
		protected int y; 
		protected int w;
		protected int h; 
		public Collider c;
		private int speed = 20;
		
		
		public SpriteObject(int x, int y, int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w; 
			this.h = h; 
			c = new Collider(x,y,w,h);
		}
		
		
		public void up()
		{
			this.y-=speed;			
		}

		public void down()
		{
			this.y+=speed;
		}
		
		public void left()
		{
			this.x-=speed;
		}
		
		public void right()
		{
			this.x+=speed;
		}
		
		public void update()
		{
			c.updateCollider(x,y,w,h);	
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
		
		public void fixOverlap()
		{

		}
		

}