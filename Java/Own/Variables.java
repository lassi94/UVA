package Game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Variables 
{
	private int x, y, koko;
	
	public Variables(int k)
	{
		this.koko=k;
	}
	
	public void setX(int x)		//accessor methods
	{
		this.x=x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setPaikka(int x, int y)		//Give coordinates as parameters and set them
	{
		this.x = x;
		this.y = y;
	}
	
	public void liiku(int x2, int y2)		//Move
	{
		x = x+x2;
		y = y+y2;
	}
	
	public Rectangle getBound()				
	{
		return new Rectangle(x,y,koko,koko);
	}
	
	public boolean isCollsion(Variables p)
	{
		if(p==this)
		{
			return false;
		}
		return getBound().intersects(p.getBound());
	}
	
	public void render(Graphics2D g)
	{
		g.fillRect(x+1, y+1, koko-2, koko-2);
	}
}
