import java.util.Scanner;


class harjoitus11
{
	public static void main(String[] args)
	{
	int a=0;
	int b;
	String lause;
	Scanner kb = new Scanner(System.in);
	
	while(a<1)
	{

		System.out.println("1. Syötä merkkijono ja tarkista onko palindromi\n2. Lopeta");
		b = kb.nextInt();
	
		
		if(b==2)
		{
			break;
		}
		
		
			System.out.println("Anna merkkijono");
			lause = kb.next();
		
			lause.replace(" ", "");
		
			boolean tulos = tarkistapalindromi(lause);
			
			System.out.println(tulos);
		
		
	}
	
	
	}
	public static boolean tarkistapalindromi(String str)
	{
		
		int n = str.length();
		
		for( int i = 0; i < n/2; i++ )
		{
        if (str.charAt(i) != str.charAt(n-i-1)) 
		{
			return false;
		}
		}
		return true;
	}

}
