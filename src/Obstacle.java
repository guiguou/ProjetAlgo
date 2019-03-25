import java.awt.*;


public class Obstacle
{
	public int x; 
	public int vitesse;
	public int largeur; 
    public int hauteur;
	public int L1; //longueur du tuyau du haut 
	public int L2; //longueur du tuyau du bas
	public int distance; //la distance entre les deux tuyaux
	
    
	public Obstacle(int hauteur, int distance, int largeur) 
    {
		this.largeur=largeur;
		this.distance=distance;
		this.hauteur = hauteur;
         
        x = 700;
        L1= (int)(Math.random()*(hauteur-distance));
		L2=hauteur-(L1+distance);
	}
    
    public void dessine(Graphics g)
    {
        g.setColor(new Color(60,190,70));
		g.fillRect(x, 0, largeur, L1);
        g.fillRect(x, hauteur - L2, largeur, L2);
	}
    
    public void bouge()
    {
        x -= 8;
	}
	
	public boolean collision(Boule b)
	{
		if (b.x + b.cote > x && b.x < x+largeur)
		{
			if (b.y < L1 || b.y+b.cote > L1 + distance)
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
