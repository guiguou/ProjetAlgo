import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics ;
import java.util.Scanner;
import java.awt.Color;
import java.awt.*;
public class fenetreMenu extends JFrame implements MouseListener, ActionListener{

    private JButton bout4;

    public fenetreMenu()
    {
        setTitle("Menu");
        setSize(650,650);
        setLocation(300,200);

        JTextField text1 = new JTextField("Enter username");
        text1.setBounds(10, 10, 100, 50);


        JTextField text2 = new JTextField("Regles du jeu");
        text2.setBounds(10, 70, 500, 200);


        JLabel label1 = new JLabel("Choix du niveau");
        label1.setBounds(10, 270, 150, 50);
        label1.setForeground(Color.magenta);


        JButton bout1 = new JButton("Facile");
        bout1.setBounds(10, 330, 150, 50);
        bout1.setBackground(Color.magenta);


        JButton bout2 = new JButton("Moyen");
        bout2.setBounds(200, 330, 150, 50);
        bout2.setBackground(Color.magenta);


        JButton bout3 = new JButton("Difficile");
        bout3.setBounds(400, 330, 150, 50);
        bout3.setBackground(Color.magenta);


        bout4 = new JButton("Jouer!");
        bout4.setBounds(400, 500, 150, 50);
        bout4.setBackground(Color.magenta);
        bout4.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 650, 650);
        panel.add(text1);
        panel.add(text2);
        panel.add(label1);
        panel.add(bout1);
        panel.add(bout2);
        panel.add(bout3);
        panel.add(bout4);
        panel.setBackground(Color.cyan);
        add(panel);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bout4)
            setVisible(false);
        fenetreJeu jeu = new fenetreJeu();
    }


    //SURCHARGES DE METHODES POUR LA SOURIS
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}