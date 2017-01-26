package Bubble;

public class Bubblesort 
{
	public int number=0;
	public int number2;
	
	
	public Bubblesort()
	{
		
		
	}
	
	public Bubblesort(int n)
	{
		this.number = n;
	}
	
	
	public void setSortedArray(int taul[], int n)
	{
		number = n;
		
		for(int o = 0; o<taul.length; o++)
		{
			for(int k = 1; k<((taul.length)-o); k++)
			{
				if(taul[k-1]>taul[k])
				{
					number = taul[k-1];
					taul[k-1] = taul[k];
					taul[k] = number;
				}
			}
			
		}
	}
	
		
}
	

