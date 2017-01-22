import java.util.Scanner;

class Basic
{

		public static void main(String[] args)
		{
		int a = 0;
		int luku, luku2, luku3, luku4;
		Scanner kb = new Scanner(System.in);
		
		while(a<1)
		{
			System.out.println("1. Kruuna vai klaava \n2. Tulosta tähtiä \n3. Laske kolmion ala \n4. Lopeta");
			luku = kb.nextInt();
			
			switch(luku)
			{
				case 1: kolikonheitto();
					break;
				case 2:	System.out.println("Anna luku");
						luku4 = kb.nextInt();
						tulosta(luku4);
					break;
				case 3: System.out.println("Anna kaksi lukua");
						luku2 = kb.nextInt();
						luku3 = kb.nextInt();
						ala(luku2, luku3);
					break;
				case 4: System.out.println("Loppu");
					break;
				default: System.out.println("Vaara luku");
					break;
				
			}
			
			if(luku==4)
			{
				break;
			}
			
		}
		
		}
		
		public static void tulosta(int maara)
		{
			for(int i=0; i<maara; i++)
			{
				System.out.println("*");
			}
		}
		public static void kolikonheitto()
		{
			int kolikko = 1+(int)(Math.random() *2);
			
			if(kolikko==1)
			{
				System.out.println("Kruuna");
			}
			else
				System.out.println("Klaava");
		}
		public static void ala(int korkeus, int kanta)
		{
			System.out.println((korkeus*kanta)/2);
			
		}
}
