package Harjoitustyö;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame
{
	/**
	 * Attribuutit
	 */
	private JLabel otsikko;//Yksityinen JLabel tyyppinen attribuutti otsikko
	private JLabel sposti;//Yksityinen JLabel tyyppinen attribuutti sposti
	private JLabel knimi;//Yksityinen JLabel tyyppinen attribuutti knimi
	private JLabel salasana;//Yksityinen JLabel tyyppinen attribuutti salasana
	
	//JTextField = syötekenttä
	private JTextField input;//Yksityinen JTextField tyyppinen attribuutti input
	private JPasswordField input2;//Yksityinen JPasswordField tyyppinen attribuutti input2
	private JTextField input3;//Yksityinen JTextField tyyppinen attribuutti input3

	private JButton luo;//Yksityinen JButton(Nappi) attribuutti luo
	private JButton takaisin;//Yksityinen JButton(Nappi) attribuutti takaisin

	private Color color;//Color tyyppinen attribuutti color
	//Esitellään oliot luokalle
	private AccountTietokanta p;
	private AjoneuvoTietokanta u;
	//Tarkistukseen tarvittavat boolean muuttujat tark
	private boolean tark;
	/**
	 * Muodostin, jossa määritellään ikkunan toiminta ja ulkoasu.
	 * Parametreina AjoneuvoTietokanta ja AccountTietokanta.
	 * Oliot pitää välittää ikkunoiden välillä oikean toiminnan aikaansaamiseksi
	 * @param a, AjoneuvoTietokanta
	 * @param o, AccountTietokanta
	 */
	public RegisterWindow(AccountTietokanta a, AjoneuvoTietokanta o)
	{
		p=a;
		u=o;
		//Määritetään väri
		color = new Color(0,51,102);
		//Määritetään JLabeleihin sijoitettavat tekstit/arvot
		otsikko = new JLabel("Rekisteröidy");
		knimi = new JLabel("Käyttäjänimi: ");
		salasana = new JLabel("Salasana: ");
		sposti = new JLabel("Sähköposti: ");
		//Luodaan nappi
		takaisin = new JButton("Takaisin");
		//Luodaan tekstikentät, 20 suurin syöte
		input = new JTextField(20);
		input2 = new JPasswordField(20);
		input3 = new JTextField(20);
		//Luodaan nappi
		luo = new JButton("Luo käyttäjä");
		//Asetetaan ikkunalle asettelu. Gridlayout asettelee komponentit verkkomaisesti(9 riviä ja 1 sarake)
		this.setLayout(new GridLayout(9,1));
		//Lisätään komponentit ikkunaan
		this.add(otsikko);
		this.add(knimi);
		this.add(input);
		this.add(salasana);
		this.add(input2);
		this.add(sposti);
		this.add(input3);
		this.add(luo);
		this.add(takaisin);
		
		//Asetetaan luo ja takaisin napeille kuuntelijat. Toiminta määritetty alla
		luo.addActionListener(new Listener());
		takaisin.addActionListener(new Listener());
		
		//Asetetaan ikkuna näkyväksi ja sille koko, paikka ja otsikko.
		this.setTitle("Rekisteröitymisikkuna");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(500, 200);
		this.setSize(500, 600);
		//Asetetaan JLabel ja JTextField komponentit ikkunan keskelle
		knimi.setHorizontalAlignment(JLabel.CENTER);
		salasana.setHorizontalAlignment(JLabel.CENTER);
		otsikko.setHorizontalAlignment(JLabel.CENTER);
		sposti.setHorizontalAlignment(JLabel.CENTER);
		input.setHorizontalAlignment(JTextField.CENTER);
		input2.setHorizontalAlignment(JTextField.CENTER);
		input3.setHorizontalAlignment(JTextField.CENTER);
		takaisin.setHorizontalAlignment(JTextField.CENTER);
		
		//Vaihdetaan ikkunan taustan, fontin ja komponenttien väriä
		getContentPane().setBackground(Color.WHITE);
		takaisin.setBackground(color);	
		luo.setBackground(color);
		takaisin.setForeground(Color.WHITE);
		luo.setForeground(Color.WHITE);
		otsikko.setForeground(color);
		knimi.setForeground(color);
		sposti.setForeground(color);
		salasana.setForeground(color);
		//Muokataan komponenttien ulkoasua. Alla muutetaan fonttia
		//new Font("fontin nimi", fontin ulkonäkö(perus, tummennettu tai kursivoitu), fontin koko)
		otsikko.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		knimi.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		salasana.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		sposti.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		takaisin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		luo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		input.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		input2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		input3.setFont(new Font("Century Gothic", Font.PLAIN, 16));



			
	}
	/**
	 * Julkinen arvoa palauttamaton close1 metodi, jolla suljetaan/asetetaan näkymättömäksi ikkuna
	 */
	public void close()
	{
		this.setVisible(false);
	}
	
	private class Listener implements ActionListener{
		
		/**
		 * Arvoa palauttamaton actionPerformed metodi, jossa määritellään ikkunan toiminta nappeja painettaessa
		 * @param e, tyyppi: ActionEvent
		 */
		public void actionPerformed(ActionEvent e) {
			//Jos luo käyttäjä nappia painettu
			if(e.getActionCommand().equals("Luo käyttäjä"))
			{
				//Tarkistetaan onko käyttäjätunnus varattu. Jos metodi palauttaa arvon true niin käyttäjätunnus on varattu
				tark = p.kayttajaTarkistus(input.getText());
				
				//Jos tark on true
				if(tark == true)
				{	//Info
					JOptionPane.showMessageDialog(null, "Käyttäjänimi varattu, valitse toinen!");
				}
				//jos tark on false
				if(tark == false && !(input.getText().isEmpty()&&input.getText().isEmpty()))
				{	//Luodaan uusi Account olio ja sijoitetaan se Account arraylistiin
					Account b = new Account(input.getText(), input2.getPassword(), input3.getText());
					p.setAccount(b);
					//Info
					JOptionPane.showMessageDialog(null, "Uusi tili luotu!");
					//suljetaan nykyinen ikkuna
					close();
					//ja avataan edellinen
					SignInWindow g = new SignInWindow(p,u);
				}
				//Jos kayttäjänimi ja salasana kenttä tyhjä
				if(input.getText().isEmpty()||input.getText().isEmpty())
				{
					//Poikkeuskäsittely
					try
					{
						//Heitetään uusi poikkeus
						throw new Exception();
					}
					//otetaan kiinni
					catch(Exception er)
					{
						//Info
						JOptionPane.showMessageDialog(null, "Tiliä ei luotu, koska yksi tai useampi kenttä tyhjä!");
					}
				}
			}
			//Jos takaisin nappia painettu
			if(e.getActionCommand().equals("Takaisin"))
			{
				//Suljetaan RegisterWindow ikkuna ja avataan edellinen
				close();
				SignInWindow r = new SignInWindow(p,u);
			}
		}
		
	}
	
}


