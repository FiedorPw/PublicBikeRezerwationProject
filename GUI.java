import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {
    static int count;
    static JPanel panel;
    static JLabel label;
     JButton button;
    public static void main(String[] args) {
        //button
        GUI gui = new GUI();
        gui

                //panel
        panel = new JPanel();
        panel.setSize(40,40);
        //panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);




        //lable
        label = new JLabel();
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
        //frame.getContentPane().setBackground(new Color(255,255,255));
        //Color.GREEN moze byc w ostatnim nawiasie



        //lable



        frame.add(label);
        frame.add(panel);
        frame.add(button);
        panel.add(label);
    }
    public void buttonMetod(){
        button = new JButton("Sprawdz stan clicks:" + count);
        button.setSize(40,40);
        button.setBounds(100,100,100,100);
        button.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            System.out.println("testtt");
            count++;
            label.setText("Sprawdz stan clicks:" + count);
            button.setText("Sprawdz stan clicks:" + count);
            //zwiększanie countera nie działa
        }
    }
}
