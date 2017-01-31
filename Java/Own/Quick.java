package Kotitehtava3;

public class Quick 
{
	public void getSortedArray(int[] a, int low, int high)
	{
		
		if(a == null || a.length == 0)
		{
			return;
		}
		
		if(low >= high)
		{
			return;
		}
		
		int middle = (low+high)/2;
		int pivot = a[middle];
		
		int k = low, j = high;
		
		while(k<=j)
		{
			while(a[k]<pivot)
			{
				k++;
			}
			
			while(a[j]>pivot)
			{
				j--;
			}
			
			if(k<=j)
			{
				int temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k++;
				j--;
			}
		}
		
		if(low<j)
		{
			getSortedArray(a,low,j);
		}
		if(high>k)
		{
			getSortedArray(a,k,high);
		}

	}
}
