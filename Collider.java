public class Collider
{
		protected int x;
		protected int y; 
		protected int w;
		protected int h; 
		protected boolean l;
		protected boolean r;
		protected boolean t;
		protected boolean b;
		protected boolean collision;
		
		
		
		public Collider(int x, int y, int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w; 
			this.h = h; 
			l = r = t = b = collision = false; 
		}
		
		
		public void collision(Collider c)
		{
			boolean col = false;
			int centery1 = y+h/2;
			int centery2 = c.y+c.h/2;
			int centerx1 = x + w/2;
			int centerx2 = c.x+  c.w/2;
			
			int j=0;
			/*for(int i = y; i<=(y +h); i++)
			{
				if(this.y + j <= (c.y+c.h)  && this.y + j >= c.y)
				{
					if(this.x <= (c.x+c.w) &&  this.x >= c.x)
					{
						l= true;
					}
				}
				j++;
			}*/
			j=0;
			double degrees = Math.atan2(centerx2 -centerx1,centery2-centery1)*180/Math.PI;
					if(degrees>0)
					{
						degrees = degrees;
					}
					else
					{
						degrees = degrees+360;						
						
					}


						if(Math.abs(centerx2 - centerx1) <= Math.abs(c.w/2 + w/2) && Math.abs(centery2 - centery1) <= Math.abs(c.h/2 + h/2))
						{
							if(degrees > 225 && degrees < 315)
							{
								l = true;
							}
							else
							{
								l = false;
							}
							if (degrees > 45 && degrees < 135)
							{ 
								r = true ;
							}
							else
							{
								r = false;
							}
							if(degrees > 135 && degrees < 225)
							{
								t = true;
							}
							else 
							{
								t = false;
							}
							if((degrees > 315 && degrees <= 360) || (degrees >= 0 && degrees < 45))
							{ 
								b = true ;
							}
							else
							{
								b = false ;
							}
						}

						else
						{ 
							l = r = t = b = false;

						}



				}
				
			
			
			
			

		
		
		public void updateCollider(int x, int y, int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w; 
			this.h = h; 
		}

}