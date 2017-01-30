package Kotitehtava3;
import java.util.Scanner;

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0;
		int b, o, r, id;
		boolean l = true;
		Scanner kb = new Scanner(System.in);
		
		TietoKanta b1 = new TietoKanta();
		Book b2 = new Book();
		Magazine m1 = new Magazine();
		Cd c1 = new Cd();
		
		while(a == 0)
		{
			System.out.println("1.Add Book\n2.Add Magazine\n3.Add Cd\n4.Show contents\n5.Delete a book\n6.List all the books\n7.List Magazines\n8.List CD\n9.Print Loans\n0.End");
			b = kb.nextInt();
			
			switch(b)
			{
			
			case 1:		b1.setTeos(addBook());
			
				break;
				
			case 2:		b1.setTeos(addMag());
						
				break;
				
			case 3:		b1.setTeos(addCd());
				break;
				
			case 4:		//conLib();
						b1.printLibrary();
			
						System.out.println("Haluatko lainata teoksen 1.yes 2. no");
						r = kb.nextInt();
						
						if(r==1)
						{
							System.out.println("Minkä teoksen haluat lainata");
							id = kb.nextInt();
							
							Loan(id);
							
						}
						else
						
				break;
				
			case 5:		System.out.println("Anna kirjastoId, jonka haluat poistaa");
						o = kb.nextInt();
						deleteBook(o);
				break;
				
			case 6:		b1.printBooks();	
				break;
				
			case 7:		b1.printMag();
				break;
				
			case 8:		b1.printCD();
				break;
			
			case 9: 	b1.printLoans();
				
			case 0:
				break;
				
			default: System.out.println("Wrong number, try again");
				break;
				
			}
			
			if(b==0)
			{
				break;
			}
		}

	}
	
	public static Book addBook()
	{
		Scanner e = new Scanner(System.in);
		System.out.println("Anna ISBN, tekija, painos");
		String isbn = e.next();
		String tekija = e.next();
		byte painos = e.nextByte();
		Book b2 = new Book(isbn,tekija,painos);
		
		return b2;
		
	}
	
	public static Magazine addMag()
	{
		Scanner e = new Scanner(System.in);
		System.out.println("Anna number ja date");
		byte number = e.nextByte();
		String date = e.next(); 
		Magazine m2 = new Magazine(number,date);
		
		return m2;
	}
	
	public static Cd addCd()
	{
		Scanner e = new Scanner(System.in);
		System.out.println("Anna esittaja, saveltaja, tyylilaji");
		String esittaja = e.next();
		String saveltaja = e.next();
		String tyylilaji = e.next();
		
		Cd c1 = new Cd(esittaja,saveltaja,tyylilaji);
		
		return c1;
	}
	
	public static void conLib()
	{
		TietoKanta t2 = new TietoKanta();
		t2.printLibrary();
		
	}
	
	public static void deleteBook(int n)
	{
		TietoKanta t1 = new TietoKanta();
		t1.deleteWork(n);
	}
	
	public static void Loan(int e)
	{
		Work p = new Work();
		
		if(p.getLoan()==false)
		{
			System.out.println("You can loan");
			p.setLoan(true);
			
		}else
			System.out.println("Loaned");
			
		
	}
	

}
