package harjoitus2;
import java.util.ArrayList;

public class Opintojakso 
{
	private int opinto;
	private String nimi;
	private String koodi;
	private ArrayList<opiskelija> opisk = new ArrayList();
	
	
	public Opintojakso()
	{
		ArrayList<opiskelija> opisk = new ArrayList();
	}
	
	public Opintojakso(int o, String n, String k)
	{
		this.opinto=o;
		this.nimi=n;
		this.koodi=k;
		
		ArrayList<opiskelija> opisk = new ArrayList();
	}
	
	public void setOpiskelija(opiskelija opisk1)
	{
		opisk.add(opisk1);
	}
	
	public void setPisteet(int o)
	{
		opinto=o;
	}
	
	public void setCode(String k)
	{
		koodi=k;
	}
	
	public int getPisteet()
	
	{
		return opinto;
	}
	public String getCode()
	{
		return koodi;
	}
	public ArrayList<opiskelija> getOpiskelija()
	{
		return opisk;
	}

	public String toString()
	{
		return "Ilmoittautuneet opintojaksolle: ";
	}
}
