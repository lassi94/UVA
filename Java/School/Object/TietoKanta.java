package Kotitehtava3;

import java.util.ArrayList;

public class TietoKanta
{
	ArrayList<Work> b1;

	
	public TietoKanta()
	{
		b1 = new ArrayList<>();
	}
	
	public void setTeos(Work b2)
	{
		b1.add(b2);
		System.out.println("Succes!");
	}
	
	public ArrayList<Work> getWork()
	{
		return b1;
	}
	
	public void deleteWork(int n)
	{
		b1.remove(n);
		System.out.println("Succes!");
	}
	
	public void printLibrary()
	{
		for(Work u: b1)
		{
			System.out.println(u);
		}
	}
	
	public void printBooks()
	{
		for(Work u: b1)
		{
			if(u instanceof Book)
			{
				System.out.println(u);
			}
		}
	}
	
	public void printMag()
	{
		for(Work u: b1)
		{
			if(u instanceof Magazine)
			{
				System.out.println(u);
			}
		}
		
	}
	
	public void printCD()
	{
		for(Work u: b1)
		{
			if(u instanceof Magazine)
			{
				System.out.println(u);
			}
		}
	}
	
	public void printLoans()
	{
		Work b = new Work();
		
		for(Work u: b1)
		{
			if(b.getLoan()==true)
			{
				System.out.println(u);
			}
		}
	}
		
	
}
