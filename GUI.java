import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GUI implements ActionListener, MouseListener {
     Color fajnyzielony = new Color(46, 248, 68);
     JPanel mainPanel;
     JPanel plansza;
     JLabel label;
     JButton button;
     boolean mouseTracking = false;


    public GUI() {
        //button
        button = new JButton("Ustaw lokalizacje" );

        button.setBounds(235,513,280,50);

        button.addActionListener(this);


        //panel
        mainPanel = new JPanel();
        mainPanel.setSize(40,40);
        mainPanel.setBackground(fajnyzielony);
        mainPanel.setBounds(135,0,500,500);


        //plansza
        plansza = new JPanel();


        plansza.setBounds(135,0,500,500);



        //lable
        label = new JLabel();
        label.setBounds(100,100,300,300);
        label.setBackground(new Color(33, 90, 234));
        label.setOpaque(true);
        label.setText("Obecny stan systemu wyporzyczania");
        label.setVisible(true);

        //ustawienia frame
        JFrame frame = new JFrame();
        frame.setTitle("System Rezerwacji Rowerów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setVisible(true);


        ImageIcon image = new ImageIcon("bikeIcon.png");
        frame.setIconImage(image.getImage());
        // gdy ^ jest niezakomentowane przestaje się pokazywać lable
        frame.getContentPane().setBackground(new Color(5, 155, 149));
        //Color.GREEN moze byc w ostatnim nawiasie



        //lable



// frame.add(label);
        // plansza.add(label);
        mainPanel.add(label);
        frame.add(mainPanel);
        //frame.add(plansza);
        frame.add(button);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {

            if(!mouseTracking) {
                button.setText("Kliknij gdzie chcesz ustawić lokalizacje");
                mouseTracking = true;
            } else {
                button.setText("Ustaw lokalizacje");
                mouseTracking = false;
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    //muszą być zeby implement mouse clicked
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
