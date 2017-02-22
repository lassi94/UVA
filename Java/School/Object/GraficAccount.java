package Harjoitus4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GraficAccount extends JFrame
{
	private JLabel label;
	private JRadioButton nappi1;
	private JRadioButton nappi2;
	private JRadioButton nappi3;
	private JButton nappi4;
	private Pankki a;
	
	public GraficAccount(Pankki p)
	{
		a=p;
		label = new JLabel("Valitse toiminto");
		nappi1 = new JRadioButton("Luo uusi tili");
		nappi2 = new JRadioButton("Nosta Rahaa tililtä");
		nappi3 = new JRadioButton("Talleta rahaa tilille");
		nappi4 = new JButton("Valitse");
		
		ButtonGroup bt = new ButtonGroup();
		bt.add(nappi1);
		bt.add(nappi2);
		bt.add(nappi3);
		bt.add(nappi4);
		
		this.setLayout(new GridLayout(5,1));
		this.add(label);
		this.add(nappi1);
		this.add(nappi2);
		this.add(nappi3);
		this.add(nappi4);
		
		nappi4.addActionListener(new NappiKuuntelija());
		nappi1.addActionListener(new NappiKuuntelija());
		nappi2.addActionListener(new NappiKuuntelija());
		nappi3.addActionListener(new NappiKuuntelija());
		
		this.setTitle("Tilisovellus");
		this.setVisible(true);
		this.setLocation(350,350);
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void Close()
	{
		this.setVisible(false);
	}

	private class NappiKuuntelija implements ActionListener
	{
	public void actionPerformed(ActionEvent e) 
	{
		
		if(nappi1.isSelected() && e.getActionCommand().equals("Valitse"))
		{
			UusiTili u = new UusiTili();
			Close();
			
		}
		
		if(nappi2.isSelected() && e.getActionCommand().equals("Valitse"))
		{
			NostaRahaa n = new NostaRahaa(a);
			Close();
		}
		
		if(nappi3.isSelected() && e.getActionCommand().equals("Valitse"))
		{
			TalletaRahaa t = new TalletaRahaa(a); 
			Close();
		}
	}
	
	}
	
	public static void main(String[] args) 
	{
		Pankki p = new Pankki();
		new GraficAccount(p);

	}

}
