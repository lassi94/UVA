package Harjoitus4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NostaRahaa extends JFrame 
{
	private JLabel label1;
	private JLabel label2;
	private JButton button;
	
	private JTextField field1;
	private JTextField field2;
	private int tilinro;
	private int maara;
	private Pankki a;
	
	public NostaRahaa(Pankki p)
	{
		a=p;
		label1 = new JLabel("Tilinumero:");
		label2 = new JLabel("Nostettava määrä:");
		field1 = new JTextField(40);
		field2 = new JTextField(40);
		button = new JButton("Nosta rahaa");
		
		this.setLayout(new GridLayout(6,6));
		this.add(label1);
		this.add(field1);
		
		this.add(label2);
		this.add(field2);
		
		this.add(button);
		
		button.addActionListener(new nappiKuuntelija());
		
		this.setTitle("Rahan nosto");
		this.setVisible(true);
		this.setLocation(500,500);
		this.setSize(350,350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void Close()
	{
		this.setVisible(false);
	}
	
	public double RahanNosto(int maara, Pankki w)
	{
		Pankki a = w;
		double saldo = a.getSaldo()-(double)maara;
		return saldo;
	}
	
	private class nappiKuuntelija implements ActionListener
	{
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Nosta rahaa"))
		{
			tilinro = Integer.parseInt(field1.getText());
			maara = Integer.parseInt(field2.getText());
			
			double s = a.miiinustaRahaa(maara, tilinro);
			
			//double s = RahanNosto(Integer.parseInt(field2.getText()),a);
			JOptionPane.showMessageDialog(null, "Nostettiin rahaa tililtä " + field1.getText() + " " + field2.getText() + " euroa. Saldosi on " + s);
			Close();
			GraficAccount l = new GraficAccount(a);
		}
		
	}
	}
	

}
