package Bubble;
import java.util.Scanner;

public class TestBubble {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);
		int size,max;
		
		System.out.println("Give the sixe of array");
		size = a.nextInt();
		
		int[] kb = new int[size];
		
		System.out.println("Give the max value");
		max = a.nextInt();
		
		for(int i = 0; i<kb.length; i++)
		{
			kb[i] = 1 + (int)(Math.random() * max);
		}
		
		System.out.println("\nUnsorted array\n");
		
		for(int h = 0; h<kb.length; h++)
		{
			System.out.print(kb[h]+" ");
		}
		
		Bubblesort bk = new Bubblesort();
		
		bk.setSortedArray(kb,0);
		
		System.out.println("\n\nSorted Array\n");
		
		for(int l = 0; l<kb.length; l++)
		{
			System.out.print(kb[l] + " ");
		}
	}	

}

