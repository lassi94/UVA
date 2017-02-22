package Harjoitus4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UusiTili extends JFrame
{
	private JRadioButton button1;
	private JRadioButton button2;
	private JTextField in1;
	private JTextField in2;
	private JLabel label1;
	private JLabel label2;
	private JButton button3;
	private JPanel paneeli1;
	private JPanel paneeli2;
	private int tilinro;
	protected double saldo;
	
	public UusiTili()
	{
		button1 = new JRadioButton("Käyttötili");
		button2 = new JRadioButton("Säästötili");
		in1 = new JTextField(40);
		in2 = new JTextField(40);
		label1 = new JLabel("Tilinumero: ");
		label2 = new JLabel("Saldo: ");
		button3 = new JButton("Luo uusi tili");
		paneeli1 = new JPanel();
		paneeli2 = new JPanel();
		
		this.setLayout(new GridLayout(6,3));
		this.add(button1);
		this.add(button2);
		this.add(label1);
		this.add(in1);
		this.add(label2);
		this.add(in2);
		this.add(button3);
		
		button3.addActionListener(new NappiListener());
		button1.addActionListener(new NappiListener());
		button2.addActionListener(new NappiListener());
		
		this.setTitle("Uuden tilin luonti");
		this.setVisible(true);
		this.setLocation(600,400);
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void close()
	{
		this.setVisible(false);
	}
	
	
	private class NappiListener implements ActionListener
	{
		Pankki p = new Pankki();
		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Luo uusi tili") && button1.isSelected())
		{
			saldo = Double.parseDouble(in2.getText());
			tilinro = Integer.parseInt(in1.getText());
			
			kayttoTili k = new kayttoTili(saldo, tilinro);
			p.lisaaTili(k);
			GraficAccount a = new GraficAccount(p);
			close();
		}
		
		if(e.getActionCommand().equals("Luo uusi tili") && button2.isSelected())
		{
			saastoTili s = new saastoTili(saldo,tilinro);
			p.lisaaTili(s);
			GraficAccount r = new GraficAccount(p);
			close();
		}
		
	}
	}

}
