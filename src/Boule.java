import java.awt.Image;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class Boule
{
	public int x;
	public int y;
	public int v;
	public int vLim;
	public int m;
	public int a;
	public int cote;
	public int g;
	public boolean estMort;
	Image deadPig = Toolkit.getDefaultToolkit().getImage("./src/pigFinalMort.png");

	public Boule(int x,int y,int m,int g, int vLim, int cote)
	{
		this.cote=cote;
		this.x=x - cote/2;
		this.y=y;
		this.m=m;
		this.g = g;
		this.v=0;
		this.vLim = vLim;
		this.a=0;
		estMort = false;
	}

	public void bouge(int f)
	{	
		a=g-f/m;
        v+=a*30*0.001;
        if (v>vLim)
            v = vLim;
        else if (v<-vLim)
            v=-vLim;
		

		if (y <= 0)
		{
			v = 0;
			y +=20;
		}
		
       // System.out.println("La vitesse est v = "+v);
        y+=v*30*0.001;
        //System.out.println("La boule est en y = "+y); */
	}

	public void dessine(Graphics g, ImageObserver i)
    {

	}
}