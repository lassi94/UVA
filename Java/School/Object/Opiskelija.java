package harjoitus2;

public class Opiskelija 
{
	private String sukunimi;
	private String etunimi;
	private int opnro;
	private String aine;
	private String kunta;
	
	private static int laskuri = 0;
	
	public Opiskelija()
	{
		laskuri++;
	}
	
	public Opiskelija(String e, String s)
	{
		laskuri++;
		
		
		this.etunimi=e;
		this.sukunimi=s;
		
	}
	
	public Opiskelija(int op)
	{
		this.opnro=op;
	}
	
	public void asetaNimi(String e, String s)
	{
		etunimi=e;
		sukunimi=s;
	}
	
	public void asetaNro(int op)
	{
		opnro=op;
	}
	
	public void asetaPaa(String a)
	{
		aine=a;
	}
	
	public void asetaTdk(String k)
	{
		kunta=k;
	}
	
	public String kerroNimi()
	{
		return etunimi + " " + sukunimi;
	}
	
	public int kerroOpnro()
	{
		return opnro;
	}
	
	public String kerroPaa()
	{
		return aine;
	}
	
	public String kerroTdk()
	{
		return kunta;
	}
	
	public static int kerroLkm()
	{
		return laskuri;
	}
	
	public String toString()
	{
		return "etunimi: " + etunimi + "\nsukunimi: "+ sukunimi + "\npaa-aine: " + aine;
	}
	
}
