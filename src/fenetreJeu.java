import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.Timer;
import java.awt.Graphics ;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.*;

public class fenetreJeu extends JFrame implements KeyListener, ActionListener
{
    //attributs
    Timer chrono;
    int temps = 0;
    int instant = 0;
    int score = 0;
    boolean peutAppuyer = true;
    Boule boule = new Boule(350, 350, 2, 700, 500, 40); // (x,y,m,g,vLim,coté)
    public LinkedList<Obstacle> listeObstacle;

    //constructeur
    public fenetreJeu()
    {
        setTitle("JEU");
        setSize(700,800);
        setLocation(50,50);
        chrono = new Timer(30,this);
        chrono.start();
        this.addKeyListener(this);

        listeObstacle = new LinkedList<Obstacle>();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //TIC
    public void actionPerformed(ActionEvent e)
    {
        temps ++;

        if (temps % 70 == 0)
            listeObstacle.add(new Obstacle(800, 250, 100));

        setTitle("Flappy boule !");
        boule.bouge(0);

        for (int i=0;i<listeObstacle.size();i++)
        {
            listeObstacle.get(i).bouge();

            if (listeObstacle.get(0).x +listeObstacle.get(0).largeur < boule.x && listeObstacle.get(0).x +listeObstacle.get(0).largeur +9 >  boule.x)
                score++;
            //COLLISION
            if (listeObstacle.get(0).collision(boule))
                chrono.stop();

            if (listeObstacle.get(i).x + listeObstacle.get(i).largeur< 0)
                listeObstacle.remove(listeObstacle.get(i));

        }
        repaint();

        //GAME OVER
        if (boule.y > 800)
        {
            setVisible(false);
            dispose();
        }
    }

    //DESSIN
    public void paint(Graphics g)
    {
        g.setColor(new Color(0,166,255));
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        boule.dessine(g);
        for (Obstacle obs : listeObstacle)
        {
            obs.dessine(g);
        }
        g.setColor(Color.white);
        g.setFont(new Font("Impact", Font.PLAIN, 36));
        g.drawString(Integer.toString(score), 350, 100);
    }

    public void keyPressed(KeyEvent e)
    {
        if (temps - instant > 10)
        {
            boule.bouge(50000);
            instant = temps;
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}