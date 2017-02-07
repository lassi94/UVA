package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener, Runnable {

	public static final int W = 600;
	public static final int L = 600;
	private int luku;
	//Loop
	private Thread t;
	private boolean r;
	private long time;
	public long stime;
	public long kulunut;
	public long odotus;
	//Render
	BufferedImage image;
	Graphics2D graphs;
	//Game
	private final int koko = 10;
	Variables p,apple;
	ArrayList<Variables> k;
	private int level;
	private boolean go;
	//liike
	private int kx,ky;
	//key input
	private boolean yl, al, oik, vas, start;
	
	public Panel()
	{
		setPreferredSize(new Dimension(W,L));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		
	}
	public void addNotify()
	{
		super.addNotify();
		t = new Thread(this);
		t.start();
	}
	public void setTime(int a)
	{
		time = 1000/a;
	}
	
	public void run() {
		
		if(r)
		{
			return;
		}
		
		runTrue();
		
		while(r)
		{
			stime = System.nanoTime();
			
			paivitys();
			requestRender();
			
			kulunut = System.nanoTime() - stime;
			odotus = time - kulunut / 100000;
			
			if(odotus>0)
			{
				try
				{
					Thread.sleep(odotus);
				}
				catch (Exception joku)
				{
					joku.getStackTrace();
				}
			}
		}

	}

	private void requestRender() {
			
		render(graphs);
		Graphics graphs2 = getGraphics();
		
		graphs2.drawImage(image, 0, 0, null);
		graphs2.dispose();
		
		
	}
	private void render(Graphics2D graphs2) {
		graphs2.clearRect(0, 0, W, L);
		
		graphs2.setColor(Color.BLUE);
		
		for(Variables e: k)
		{
			e.render(graphs2);
		}
		graphs2.setColor(Color.GRAY);
		apple.render(graphs2);
		
		graphs2.setColor(Color.WHITE);
		graphs2.drawString("Score: " + luku, 10, 10);
	}
	private void paivitys() {
	
		if(yl&&ky==0)
		{
			ky = -koko;
			kx = 0;
		}
		if(al&&ky==0)
		{
			ky = koko;
			kx = 0;
		}
		if(vas&&kx==0)
		{
			ky = 0;
			kx = -koko;
		}
		if(oik&&ky==0)
		{
			ky = 0;
			kx = koko;
		}
		
		if(kx!=0||ky!=0)
		{
		
		for (int i = k.size()-1;i>0;i--)
		{
			k.get(i).setPaikka(k.get(i-1).getX(), k.get(i-1).getY());
		}
		p.liiku(kx, ky);
		}
		
		if(apple.isCollsion(p))
		{
			luku++;
			setOmena();
		}
		
		if(p.getX()<0)
		{
			p.setX(W);
		}
		if(p.getY()<0)
		{
			p.setY(L);
		}
		if(p.getX()>W)
		{
			p.setX(0);
		}
		if(p.getY()>L)
		{
			p.setY(0);
		}
	}
	private void runTrue() {
		
		image = new BufferedImage(W,L,BufferedImage.TYPE_INT_ARGB);
		graphs = image.createGraphics();
		
		r = true;
		setUpLevel();
		
		setTime(10);
		
		setOmena();
		luku = 0;
		
	}
	
	private void setUpLevel()
	{
		k = new ArrayList<Variables>();
		p = new Variables(koko);
		
		p.setPaikka(W/2, L/2);
		
		k.add(p);
		
		for(int i = 1; i<5;i++)
		{
			Variables e = new Variables(koko);
			e.setPaikka(p.getX() + (i*koko), p.getY());
			k.add(e);
		}
		
		apple = new Variables(koko);
	}
	
	public void setOmena()
	{
		int x = (int)(Math.random()*(W-koko));
		int y = (int)(Math.random()*(L-koko));
		x = x -(x&koko);
		y = y -(y&koko);
		
		apple.setPaikka(x, y);
	}
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if (k == KeyEvent.VK_UP)
		{
			yl =true;
		}
		if (k== KeyEvent.VK_DOWN)
		{
			al = true;
		}
		if (k == KeyEvent.VK_RIGHT)
		{
			oik = true;
		}
		if (k == KeyEvent.VK_LEFT)
		{
			vas = true;
		}
		if (k == KeyEvent.VK_ENTER)
		{
			start=true;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
		int k = e.getKeyCode();
		
		if (k == KeyEvent.VK_UP)
		{
			yl =false;
		}
		if (k== KeyEvent.VK_DOWN)
		{
			al = false;
		}
		if (k== KeyEvent.VK_RIGHT)
		{
			oik = false;
		}
		if (k==KeyEvent.VK_LEFT)
		{
			vas = false;
		}
		if (k == KeyEvent.VK_ENTER)
		{
			start=false;
		}
		
	
	}

	public void keyTyped(KeyEvent e) {
		

	}

}
