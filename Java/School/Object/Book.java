package Kotitehtava3;

public class Book extends Kirjallinen
{
	private String ISBN;
	private String tekija;
	private byte painos;
	
	public Book()
	{
		
	}
	
	public Book(String i, String t, byte p)
	{
		super();
		this.ISBN=i;
		this.tekija=t;
		this.painos=p;
	}
	
	public Book(String i, String t, byte p, int year, int page)
	{
		super();
		this.ISBN=i;
		this.tekija=t;
		this.painos=p;
		this.year=year;
		this.page=page;
	}
	
	public void setIS(String i)
	{
		ISBN = i;
	}
	
	public void setTekija(String t)
	{
		tekija = t;
	}
	
	public void setPainos(byte p)
	{
		painos = p;
	}
	
	public String getIS()
	{
		return ISBN;
	}
	
	public String getTekija()
	{
		return tekija;
	}
	
	public byte getPainos()
	{
		return painos;
	}
	
	public String toString()
	{
		return Libraryid + "\n" + ISBN + "\n" + tekija + "\n" + painos;
	}
}
