package Kotitehtava3;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number, largest, low = 0;
		Scanner kb = new Scanner(System.in);
		
		Quick q = new Quick();
		Random r = new Random();
		
		System.out.println("Give the size of Array");
		number = kb.nextInt();
		
		int[] kt = new int[number];
		int high = kt.length-1;
				
		System.out.println("Give the largest number that you want to add into the array");
		largest = kb.nextInt();
		
		for(int i = 0;i<kt.length;i++)
		{
			kt[i]=r.randomNumber(largest);
		}
		
		System.out.println("\nUnsorted Array");
		
		for(int k=0;k<kt.length;k++)
		{
			System.out.print(kt[k] + " ");
		}
		
		q.getSortedArray(kt, low, high);
		
		System.out.println("\nSorted Array");
		
		for(int j = 0;j<kt.length; j++)
		{
			System.out.print(kt[j] + " ");
		}
		
		
		
	}

}
