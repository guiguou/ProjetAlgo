import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Graphics ;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
public class fenetreGameOver extends JFrame implements MouseListener, ActionListener
{
    private JButton Bouton1;
    private JButton Bouton2;
    int score = 0;

    public fenetreGameOver(int score)
    {
       setTitle("Game Over!");
       this.score = score;
        setSize(700,800);
        //setLocation(300,200);
        setLocationRelativeTo(null);
        Bouton1 = new JButton("Nouvelle partie");
        Bouton1.setBounds(210,500,300,70);
        Font police = new Font(" Calibri ",Font.BOLD,20);
        Bouton1.setBackground(new Color(255,192,203));
        Bouton1.setForeground(Color.white);
        Bouton1.setFont(police);
        Bouton1.addActionListener(this);
        add(Bouton1);
        
        Bouton2 = new JButton("Menu");
        Bouton2.setBounds(210,600,300,70);
        Font police1 = new Font(" Calibri ",Font.BOLD,20);
        Bouton2.setBackground(new Color(255,192,203));
        Bouton2.setForeground(Color.white);
        Bouton2.setFont(police1);
        Bouton2.addActionListener(this);
        add(Bouton2);
        
        JLabel Texte = new JLabel("SCORE: " +score);
        Texte.setBounds(272,140,250,150);
        Font police2 = new Font(" Calibri ",Font.BOLD,22);
        Texte.setForeground(Color.black);
        Texte.setFont(police2);
         add(Texte);
         JLabel Texte2 = new JLabel("GAME OVER ! ");
        Texte2.setBounds(220,100,250,150);
        Font police3 = new Font(" Calibri ",Font.BOLD,30);
        Texte2.setForeground(Color.black);
        Texte2.setFont(police3);
         add(Texte2);
         
        JLabel monEtiquette = new JLabel() ;
        monEtiquette.setIcon(new ImageIcon("gameOverImage.jpg"));
        monEtiquette.setBounds(0,0,700,800);
        add(monEtiquette);
         
        JPanel ConteneurMain= new JPanel() ;
        ConteneurMain.setBounds(0,0,400,400);
        ConteneurMain.setLayout(null) ;
        ConteneurMain.add(Bouton1) ;
        ConteneurMain.add(Bouton2) ;
        ConteneurMain.add(Texte) ;
        ConteneurMain.add(Texte2) ;
        ConteneurMain.add(monEtiquette);
        ConteneurMain.setBackground(new Color(109,234,255));
        add(ConteneurMain);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(this.getWidth());
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Bouton1)
        {
            setVisible(false);
            fenetreJeu jeu = new fenetreJeu();
        }

        else if (e.getSource() == Bouton2)
        {
            setVisible(false);
            fenetreMenu m = new fenetreMenu();
        }
    }
    
    
    //SURCHARGES DE METHODES POUR LA SOURIS
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
