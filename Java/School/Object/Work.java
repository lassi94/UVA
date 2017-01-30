package Kotitehtava3;

public class Work 
{
	final protected int Libraryid;
	protected String name;
	private String publisher;
	private String sijainti;
	private static int idLaskuri=1000;
	private boolean loaned;
	
	public Work()
	{
		Libraryid = idLaskuri;
		idLaskuri++;
	}
	
	public Work(String n, String p)
	{
		this();
		this.name=n;
		this.publisher=p;

	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setPublisher(String p)
	{
		publisher=p;
	}
	
	public void setSijainti(String s)
	{
		sijainti = s;
	}
	
	public void setLoan(boolean l)
	{
		loaned=l;
	}
	
	public int getLibraryid()
	{
		return Libraryid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	
	public boolean getLoan()
	{
		return loaned;
	}
	
	public String toString()
	{
		return name + "\n" + publisher + "\n" + sijainti;
	}
	
}
