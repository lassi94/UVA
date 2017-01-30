package Kotitehtava3;

public class Cd extends Work 
{
	private String esittaja;
	private String saveltaja;
	private String tyylilaji;
	
	public Cd()
	{
		
	}
	
	public Cd(String year, String page, String tyylilaji)
	{
		super();
		this.esittaja=year;
		this.saveltaja=page;
		this.tyylilaji=tyylilaji;
	}
	
	public void setEsittaja(String y)
	{
		esittaja = y;
	}
	
	public void setSaveltaja(String p)
	{
		saveltaja = p;
	}
	
	public void settyylilaji(String t)
	{
		tyylilaji=t;
	}
	
	public String getesittaja()
	{
		return esittaja;
	}
	
	public String getSaveltaja()
	{
		return saveltaja;
	}
	
	public String getTyylilaji()
	{
		return tyylilaji;
	}
	
	public String toString()
	{
		return Libraryid + "\n" + name;
}

}
