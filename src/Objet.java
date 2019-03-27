import java.awt.*;

public class Objet
{
    int x, y;
    int c;
    Color couleur;

    public Objet()
    {
        x = 700;
        y = 400;
        c = 20;
        couleur = Color.black;
    }

    public void bouge(int tps)
    {
        x -= 8;
        y += 10*Math.sin(tps *30); //à améliorer
    }

    public boolean collision(Boule b)
    {
        if (x < b.x + b.cote && x > b.x)
        {
            if (y > b.y && y < b.y+b.cote)
            {
                return true;
            }
            else
                return false;
        }
        else return false;
    }

    public void dessine(Graphics g)
    {
        g.fillRect(x,y,c,c);
    }
}
