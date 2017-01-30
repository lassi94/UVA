package Kotitehtava3;

public class Magazine extends Kirjallinen
{
	private byte number;
	private String date;
	
	public Magazine()
	{
		
	}
	
	public Magazine(byte n, String d)
	{
		super();
		this.number=n;
		this.date=d;
	}
	
	public Magazine(byte n, String d, int year, int page)
	{
		super();
		this.number=n;
		this.date=d;
		this.year=year;
		this.page=page;
	}
	
	public void setNumber(byte n)
	{
		number = n;
	}
	
	public void setDate(String d)
	{
		date = d;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public byte getPainos()
	{
		return number;
	}
	
	public String toString()
	{
		return Libraryid + "\n" + number + "\n" + date;
		
	}
}
