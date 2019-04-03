import java.awt.*;

public class Malus extends Objet
{
    Color couleur;

    public Malus()
    {
        super();
        couleur = Color.red;
    }


    public void dessine(Graphics g)
    {
        g.setColor(couleur);
        super.dessine(g);
    }
}
