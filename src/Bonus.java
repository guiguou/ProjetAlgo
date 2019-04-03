import java.awt.*;

public class Bonus extends Objet
{
    Color couleur;

    public Bonus()
    {
        super();
        couleur = Color.green;
    }

    public void dessine(Graphics g)
    {
        g.setColor(couleur);
        super.dessine(g);
    }
}
