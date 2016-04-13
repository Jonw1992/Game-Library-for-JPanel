public class SpriteObject
{
		protected int x;
		protected int y; 
		protected int w;
		protected int h; 
		public Collider c;
		private int speed = 15;
		
		
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
			c.updateCollider(x,y,w,h);
			
		}

		public void down()
		{
			this.y+=speed;
			c.updateCollider(x,y,w,h);
			
		}
		
		public void left()
		{
			this.x-=speed;
			c.updateCollider(x,y,w,h);
			
		}
		
		public void right()
		{
			
			this.x+=speed;
			c.updateCollider(x,y,w,h);
		}
		

}