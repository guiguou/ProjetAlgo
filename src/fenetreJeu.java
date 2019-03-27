import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.Timer;
import java.util.*;

public class fenetreJeu extends JFrame implements KeyListener, ActionListener
{
    //attributs
    Timer chrono;
    int temps = 0;
    int instant = 0;
    int score = 0;
    boolean peutAppuyer = true;
    Boule boule = new Boule(350, 350, 2, 700, 500, 40); // (x,y,m,g,vLim,cote)
    Malus obj = new Malus();
    Sol sol = new Sol();
    Image pig = Toolkit.getDefaultToolkit().getImage("./src/pigFinal2.png");
    Image imgSol = Toolkit.getDefaultToolkit().getImage("./src/sol.png");
    public LinkedList<Obstacle> listeObstacle;

    //constructeur
    public fenetreJeu()
    {
        //création de la fenêtre
        setTitle("JEU");
        setSize(700,800);
        setLocation(50,50);

        //création du chrono
        chrono = new Timer(30,this);
        chrono.start();

        //gestion du clavier
        this.addKeyListener(this);

        //création de la liste d'obstacles
        listeObstacle = new LinkedList<Obstacle>();

        //paramètres de la fenêtres
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //TIC
    public void actionPerformed(ActionEvent e)
    {
        temps ++;

        //création des obstacles
        if (temps % 70 == 0)
            listeObstacle.add(new Obstacle(800, 250, 100));

        setTitle("Flappig boy !");

        //gestion du joueur
        boule.bouge(0);
        if (boule.y + boule.cote >= 800-sol.hauteur)
            chrono.stop();


        //gestion des objets
        obj.bouge(temps);
        if (obj.collision(boule))
            chrono.stop();

        //gestion des obstacles
        for (int i=0;i<listeObstacle.size();i++)
        {
            listeObstacle.get(i).bouge();

            //score
            if (listeObstacle.get(0).x +listeObstacle.get(0).largeur < boule.x && listeObstacle.get(0).x +listeObstacle.get(0).largeur +9 >  boule.x)
                score++;
            //collision
            if (listeObstacle.get(0).collision(boule))
                chrono.stop();
            //libération d'espace dans la liste
            if (listeObstacle.get(i).x + listeObstacle.get(i).largeur< 0)
                listeObstacle.remove(listeObstacle.get(i));
        }
        repaint();
    }

    //DESSIN
    public void paint(Graphics g)
    {
        //dessin du ciel bleu
        g.setColor(new Color(0,166,255));
        g.fillRect(0,0,this.getWidth(),this.getHeight());


        //Objet
        obj.dessine(g);

        //dessin du joueur
        boule.dessine(g);
        g.drawImage(pig, boule.x, boule.y, this);


        //dessin des obstacles
        for (Obstacle obs : listeObstacle)
        {
            obs.dessine(g);
        }

        //dessin du sol
        //sol.dessine(g);
        g.drawImage(imgSol,0, 800-sol.hauteur, this);
        //affichage du score
        g.setColor(Color.white);
        g.setFont(new Font("Impact", Font.PLAIN, 36));
        g.drawString(Integer.toString(score), 350, 100);
    }

    //gestion de l'appui sur la touche espace
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode()==KeyEvent.VK_SPACE)
        {
            if (temps - instant > 10)
            {
                boule.bouge(50000);
                instant = temps;
            }
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}