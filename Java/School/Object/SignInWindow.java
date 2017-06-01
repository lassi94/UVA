package Harjoitustyö;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SignInWindow extends JFrame {

	/**
	 * Attribuutit
	 */
	public final int WIDTH = 500; //Julkinen lopullinen kokonaislukumuuttuja WIDTH
	public final int HEIGHT = 500;//Julkinen lopullinen kokonaislukumuuttuja WIDTH
	
	private JLabel label1;//Yksityinen JLabel tyyppinen attribuutti label1
	private JLabel label2;//Yksityinen JLabel tyyppinen attribuutti label2
	
	private Color color;//Yksityinen Color tyyppinen attribuutti
	private ImageIcon img;//Yksityinen ImageIcon attribuutti
	private JButton signIn; //Yksityinen JButton(Nappi) attribuutti signIn
	private JButton register;//Yksityinen JButton(Nappi) attribuutti register
	private JButton close;//Yksityinen JButton(Nappi) attribuutti close
	//Olioiden esittely
	private AccountTietokanta o;
	private AjoneuvoTietokanta i;
	
	/**
	 * Muodostin, jossa määritellään ikkunan toiminta ja ulkoasu.
	 * Parametreina AjoneuvoTietokanta ja AccountTietokanta.
	 * Oliot pitää välittää ikkunoiden välillä oikean toiminnan aikaansaamiseksi
	 * @param j, AjoneuvoTietokanta
	 * @param k, AccountTietokanta
	 */
	public SignInWindow(AccountTietokanta k, AjoneuvoTietokanta j)
	{	
		o=k;
		i=j;
		//Poikkeuskäsittely kuvalle
		try
		{
			//Yritetään löytää kuva
			img = new ImageIcon(this.getClass().getResource("rent.png"));

		}
		//Otetaan poikkeus kiinni, jos kuvaa ei löydy
		catch(Exception ex)
		{
			//info
			JOptionPane.showMessageDialog(null, "Kuvaa ei löydy!");
		}
		
		//Luodaan JLabelit(tekstit/arvot jotka sijoitetaan ikkunaan)
		label2 = new JLabel(img);//label2 paikkaaan asetetaan kuva
		label1 = new JLabel("Tervetuloa Ajoneuvovuokraamoon!");
		//Luodaan napit
		signIn = new JButton("Kirjaudu sisään");
		register = new JButton("Rekisteröidy");
		close = new JButton("Lopeta");
		//Luodaan uusi väri
		color = new Color(0,51,102);
		//lisätään komponentit ikkunaan
		this.add(label1);
		this.add(label2);
		this.add(signIn);
		this.add(register);
		this.add(close);
		//Asetetaan napeille kuuntelijat. Toiminta määritetty alla
		close.addActionListener(new ListenerButton());
		signIn.addActionListener(new ListenerButton());
		register.addActionListener(new ListenerButton());
		//Muokataan komponenttien ulkoasua. Alla muutetaan fonttia
		//new Font("fontin nimi", fontin ulkonäkö(perus, tummennettu tai kursivoitu), fontin koko)
		//Sijoitetaan komponentit keskelle ikkunaa
		label1.setHorizontalAlignment(JLabel.CENTER);
		signIn.setHorizontalAlignment(JButton.CENTER);
		register.setHorizontalAlignment(JButton.CENTER);
		close.setHorizontalAlignment(JButton.CENTER);
		this.label1.setFont(new Font("Century Gothic", Font.BOLD, 20));
		this.signIn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.register.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		this.close.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		
		//Vaihdetaan ikkunan taustan, fontin ja komponenttien väriä
		getContentPane().setBackground(Color.WHITE);
		signIn.setBackground(color);
		register.setBackground(color);
		close.setBackground(color);
		signIn.setForeground(Color.WHITE);
		register.setForeground(Color.WHITE);
		close.setForeground(Color.WHITE);
		label1.setForeground(color);
		//Asetetaan ikkuna näkyväksi ja sille koko, paikka ja otsikko.
		this.setLayout(new GridLayout(5,1));
		this.setTitle("Ajoneuvovuokraamo Marigoldin kirjautumisikkuna");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Suljetaan applikaatio jos käyttäjä painaa rastia
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(500,200);
		
	}
	/**
	 * Julkinen arvoa palauttamaton close1 metodi, jolla suljetaan/asetetaan näkymättömäksi ikkuna
	 */
	public void close()
	{
		this.setVisible(false);
	}
	/**
	 * Yksityinen Listener luokka, jossa määritellään ikkunan toiminta kun nappeja painetaan.
	 * Luokka toteuttaa ActionListener rajapinnan abstraktin metodin actionPerformed
	 * <p>
	 * Harjoitustyö, Olio-ohjelmointi, kevät 2017
	 * <p>
	 * @author Lassi Korhonen, y104296
	 * Tietotekniikka, Vaasan Yliopisto
	 */
	private class ListenerButton implements ActionListener
	{
		/**
		 * Arvoa palauttamaton actionPerformed metodi, jossa määritellään ikkunan toiminta nappeja painettaessa
		 * @param e, tyyppi: ActionEvent
		 */
		public void actionPerformed(ActionEvent e) 
		{
			//Jos kirjaudu sisään nappi painettu
			if(e.getActionCommand().equals("Kirjaudu sisään"))
			{
				//Avataan uusi ikkuna
				Window2 w = new Window2(o,i);
				//suljetaan nykyinen
				close();
			}
			//Jos rekisteröidy nappi painettu
			if(e.getActionCommand().equals("Rekisteröidy"))
			{
				//Avataan uusi ikkuna
				RegisterWindow h = new RegisterWindow(o, i);
				//suljetaan nykyinen
				close();
				
			}
			//Jos lopeta nappia painettu
			if(e.getActionCommand().equals("Lopeta"))
			{
				//Suljetaan applikaatio
				System.exit(0);
			}
			
		}
		
	}
	
	/**
	 * Pääohjelmametodi
	 * @param args, tyyppi: kokonaisluku
	 */
	public static void main(String[] args) 
	{
		//Lisätään uusi käyttäjä Account arraylistiin
		//Tunnukset ylläpidon puolelle
		char[] y = {'o','k'};
		String kayttaja = "Yllapito";
		Account u = new Account(kayttaja,y);
		//Luodaan uudet oliot
		//Molemmat oliot sijoittavat olioita arraylistiin
		AjoneuvoTietokanta w = new AjoneuvoTietokanta();
		AccountTietokanta l = new AccountTietokanta();
		//lisätään käyttäjä listaan
		l.setAccount(u);
		//käynnistetään applikaatio
		new SignInWindow(l,w);

	}

}
