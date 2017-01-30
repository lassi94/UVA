package Kotitehtava3;

public class Kirjallinen extends Work 
{
	protected int year;
	protected int page;
	
	public Kirjallinen()
	{
		super();
	}
	
	public Kirjallinen(int year, int page)
	{
		super();
		this.year=year;
		this.page=page;
	}
	
	public void setYear(int y)
	{
		year = y;
	}
	
	public void setPage(int p)
	{
		page = p;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getPage()
	{
		return page;
	}
	
	public String toString()
	{
		return Libraryid + "\n" + name;
	}
}
