import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.lang.Object.*;
import java.awt.*;
import java.util.*;

public class SpriteSheet
{
	
	private double rate;
	private double lastcall;
	private BufferedImage sheet;
	private Image sprite;
	private int curSprite;
	
	public SpriteSheet(String url)
	{
			rate = .5;
            try
            {
                sheet = ImageIO.read(new File(url));
            }
			catch(Exception e){e.printStackTrace();
			}
			sprite = sheet.getSubimage(30,0,15,15);
			lastcall = java.lang.System.currentTimeMillis();
	}
	
	public void update()
	{
		//sprite = sheet.getSubimage(30,30,15,15);	
	}
	
	public Image getCurImage()
	{
		
		return sprite;
	}
	
	public void walkLeft()
	{
		if(	java.lang.System.currentTimeMillis() - lastcall > 60/rate)
		{
			lastcall = java.lang.System.currentTimeMillis();
			
			if(curSprite%2 ==0)
			{
				sprite = sheet.getSubimage(30,30,15,15);				
			}
			else
			{
				sprite = sheet.getSubimage(30,0,15,15);	
			}
			curSprite++;
		}
	}
	
	public void walkRight()
	{
		if(	java.lang.System.currentTimeMillis() - lastcall > 60/rate)
		{
			lastcall = java.lang.System.currentTimeMillis();
			
			if(curSprite%2 ==0)
			{
				sprite = sheet.getSubimage(90,30,15,15);				
			}
			else
			{
				sprite = sheet.getSubimage(90,0,15,15);	
			}
			curSprite++;
		}
		
		
	}
	
	public void walkUp()
	{
		if(	java.lang.System.currentTimeMillis() - lastcall > 60/rate)
		{
			lastcall = java.lang.System.currentTimeMillis();
			
			if(curSprite%2 ==0)
			{
				sprite = sheet.getSubimage(60,30,15,15);				
			}
			else
			{
				sprite = sheet.getSubimage(60,0,15,15);	
			}
			curSprite++;
		}
		
		
	}
	
	public void walkDown()
	{
		if(	java.lang.System.currentTimeMillis() - lastcall > 60/rate)
		{
			lastcall = java.lang.System.currentTimeMillis();
			
			if(curSprite%2 ==0)
			{
				sprite = sheet.getSubimage(0,30,15,15);				
			}
			else
			{
				sprite = sheet.getSubimage(0,0,15,15);	
			}
			curSprite++;
		}
		
		
	}
	
	
	

}