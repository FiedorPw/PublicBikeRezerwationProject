import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GUI implements ActionListener, MouseListener {
     int count;
     JPanel panel;
     JPanel plansza;
     JLabel label;
     JButton button;
     boolean mouseTracking = false;


    public GUI() {
        //button
        button = new JButton("Ustaw lokalizacje" + count);

        button.setBounds(230,315,280,50);

        button.addActionListener(this);


        //panel
        panel = new JPanel();
        panel.setSize(40,40);
        //panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);

        //plansza
        plansza = new JPanel();
        plansza.setBounds(250,250,200,200);
       // plansza.getContentPane().setBackground(Color.black);




        //lable
        label = new JLabel();
        label.setBounds(200,300,100,100);
        label.setText("Obecny stan systemu wyporzyczania");
        label.setVisible(true);
        //ustawienia frame

        JFrame frame = new JFrame();
        frame.setTitle("System Rezerwacji Rowerów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(800,400);
        frame.setVisible(true);
        //ImageIcon image = new ImageIcon("bikeIcon.png");
        // gdy ^ jest niezakomentowane przestaje się pokazywać lable
        //frame.getContentPane().setBackground(new Color(66, 133, 29));
        //Color.GREEN moze byc w ostatnim nawiasie



        //lable

        frame.add(button);

        frame.add(panel);
        frame.add(label);
       // panel.add(label);


    }
    public void buttonMetod(){


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {

            if(mouseTracking == false) {
                button.setText("Kliknij gdzie chcesz ustawić lokalizacje");
                mouseTracking = true;
            } else {
                button.setText("Ustaw lokalizacje");
                mouseTracking = false;
            }
            //button.setText("clicks:" + count);
            //zwiększanie countera nie działa
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    //muszą być zeby implement
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
