import java.util.Scanner;



class harjoitus14
{
	public static void main(String[] args)
	{
	
	int a = 0, luku3;
	Scanner kb = new Scanner(System.in);
	int koko, koko1;
	int valinta;
	String kok="kokonaisluku", merkki="merkkijono", valinta3;
	String valinta2, kok = "kokonaisluku", merk="merkkijono";
	
	
	while(a<1)
	{
		
	System.out.println("Haluatko tehdä kokonaisluku vai merkkijono taulukon");
	valinta2 = kb.next();
	
	if(valinta2.equals(kok))
	{
		System.out.println("kuinka iso taulukko");
		koko=kb.nextInt();
		
		int[] taulukko = new int[koko];
		
		for(int i = 0; i<taulukko.length; i++)
		{
			System.out.println("Anna luku");
			taulukko[i]=kb.nextInt();
		}
		
	}
	
	if(valinta2.equals(merk))
	{
		System.out.println("kuinka iso taulukko");
		koko1=kb.nextInt();
		
		String[] taulukko2 = new String[koko1];
		
		for(int i = 0; i<taulukko2.length; i++)
		{
			System.out.println("Anna merkkijono");
			taulukko2[i]=kb.next();
		}
		
	}
	
	System.out.println("1.Tulosta taulukko\n2.Kasvata taulukkoa\n3.Etsi taulukosta\n4.Lopeta");
	valinta = kb.nextInt();
	
	switch(valinta)
	{
		case 1: System.out.println("kumman taulukon haluat tulostaa?");
				valinta3=kb.next();
				
				if(valinta3.equals(kok))
				{
					tulosta(taulukko);
				}
				if(valinta3.equals(merkki))
				{
					tulostaMerkki(taulukko2);
				}
			break;
			
		case 2: System.out.println("Kumman taulukon haluat kasvattaa");
				
				kasvata(koko,taulukko);
				kasvatastr(koko,taulukko2)
			break;
			
		case 3: System.out.println("Minka luvun haluat etsia");
				luku3=kb.nextInt();
				etsi(luku3);
			break;
			
		case 4: System.out.println("Loppu");
			break;
			
		default: System.out.println("Väärä luku");
		
	}
	
	if(valinta==4)
	{
		break;
	}
		
		
	}
	
	
	}
	
	public static int tulosta(int [] joku)
	{
		for(int b=0; i<taulukko3.length; i++)
		{
			System.out.println(taulukko3[i]);
		}
		
		
	}
	public static void tulostaMerkki(String[] joku)
	{
		
		for(int b=0; i<taulukko3.length; i++)
		{
			System.out.println(taulukko3[i]);
		}
		
	}
	
	public static int[] kasvata(int[] joku)
	
	{

		koko = koko*2;
		int[] taulukko4=new taulukko4[koko];
		
		for(int i =0; i<taulukko4.length; i++)
		{
			taulukko4[i]=joku[i];
			
		}

		return taulukko4;
		
		
	}
	public static String[] kasvatastr(String[] joku)
	{
		koko = koko*2;
		String[] taulukko4=new taulukko4[koko];
		
		for(int i =0; i<taulukko4.length; i++)
		{
			taulukko4[i]=joku[i];
			
		}

		return taulukko4;
	}
	
	public static void etsi(int luku2)
	{
		int laskuri = 0;
		
		for(int b =0; b<taulukko.length; b++)
		{
			if(taulukko[i]==luku2)
			{
				laskuri++;
			}
			
		}
		System.out.println("maara on " + laskuri);
		
	}


}
