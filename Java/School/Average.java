import java.util.Scanner;

class kotitehtava13
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		double luku;
		int luku2;
		
		System.out.println("Kuinka monen luvun keskiarvon haluat laskea");
		luku2 = kb.nextInt();
		
		int[] array = new int[luku2];
		
		for(int i=0; i<array.length; i++)
		{
		
		System.out.println("Anna luku");
		luku = kb.nextDouble();
		
		}
		
		int sum=0;
		
		for(int b=0; b<array.length;b++)
		{
		
		sum=sum+array[b];
		
		}
		
		double average = sum/luku2;
		
		System.out.println("Keskiarvo on " + average);
	}
}
