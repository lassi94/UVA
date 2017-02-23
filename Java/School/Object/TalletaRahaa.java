package Harjoitus4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TalletaRahaa extends JFrame {

	private JLabel label1;
	private JLabel label2;
	private JButton button;
	
	private JTextField field1;
	private JTextField field2;
	private int tilinro;
	private int maara;
	private Pankki a;
	
	public TalletaRahaa(Pankki p)
	{
		a=p;
		label1 = new JLabel("Tilinumero:");
		label2 = new JLabel("Talletettava määrä:");
		field1 = new JTextField(40);
		field2 = new JTextField(40);
		button = new JButton("Talleta rahaa");
		
		this.setLayout(new GridLayout(6,6));
		this.add(label1);
		this.add(field1);
		
		this.add(label2);
		this.add(field2);
		
		this.add(button);
		
		button.addActionListener(new ListenerNappi());
		
		this.setTitle("Rahan talletus");
		this.setVisible(true);
		this.setLocation(500,500);
		this.setSize(350,350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void close()
	{
		this.setVisible(false);
	}
	
	public double RahanTalletus(int maara, Pankki w)
	{
		Pankki a = w;
		double saldo = a.getSaldo() + maara;
		return saldo;
	}
	
	private class ListenerNappi implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Talleta rahaa"))
			{
				tilinro = Integer.parseInt(field1.getText());
				maara = Integer.parseInt(field2.getText());
				
				double s = a.lisääRahaa(maara, tilinro);
				
				//double s = RahanTalletus(Integer.parseInt(field2.getText()), a);
				JOptionPane.showMessageDialog(null, "Tilille " + field1.getText() + " talletettiin " + field2.getText() + " euroa. Saldo " + s);
				close();
				GraficAccount p = new GraficAccount(a);
			}
			
		}
		
	}

}
