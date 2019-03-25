import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics ;

public class fenetreMenu extends JFrame implements MouseListener //, ActionListener
{
    public fenetreMenu()
    {
        setTitle("Menu");
        setSize(600,600);
        setLocation(300,200);
    
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    //SURCHARGES DE METHODES POUR LA SOURIS
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
