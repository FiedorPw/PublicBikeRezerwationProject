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
     DragPointer dragpointer = new DragPointer();
     JLabel label;
     JLabel label2;
     JButton button;
     boolean mouseTracking = false;


    public GUI() {
        //button
        button = new JButton("Kliknij aby rozpocząc symulacje" );
        button.setBounds(135,513,280,50);
        button.addActionListener(this);


        //panel
        mainPanel = new JPanel();
        mainPanel.setSize(40,40);
        mainPanel.setBackground(fajnyzielony);
        mainPanel.setBounds(43,0,500,500);






        //lable
        label = new JLabel();
        label.setBounds(100,100,200,50);
        label.setBackground(fajnyzielony);
        label.setOpaque(true);
        label.setText("Stacja poliwUda 21/37");
        label.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(200,200,200,50);
        label2.setBackground(fajnyzielony);
        label2.setOpaque(true);
        label2.setText("Stacja uwuuwuwu 69/420");
        label2.setVisible(true);




        //ustawienia frame
        JFrame frame = new JFrame();
        frame.setTitle("System Rezerwacji Rowerów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(600,600);
        frame.setVisible(true);


        ImageIcon image = new ImageIcon("bikeIcon.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(5, 155, 149));


        // frame.add(label);
        // plansza.add(label);
        mainPanel.add(label);
        mainPanel.add(label2);
        frame.add(mainPanel);
        //frame.add(plansza);
        frame.add(button);


        frame.add(dragpointer);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {

            if(!mouseTracking) {
                button.setText("Kliknij aby rozpocząc symulacje");
                mouseTracking = true;
            } else {
                button.setText("Symulowanie");
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
