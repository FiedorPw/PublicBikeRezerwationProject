import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

// sprawdzenie
public class GUI extends JPanel implements ActionListener, MouseListener  {
     Color fajnyzielony = new Color(46, 248, 68);
     Color fajnyTurkusowy = new Color(28, 229, 222);
     JPanel mainPanel;
    JPanel panelPoprostu;
    DragPointer dragpointer = new DragPointer();
     JLabel logo;
     JLabel label2;
     JLabel centralLable1;
     JLabel centralLable2;

     JButton button;
     boolean mouseTracking = false;


    public GUI() {


        ImageIcon image = new ImageIcon("bikeIcon.png");
        //button
        button = new JButton("Kliknij aby rozpocząc symulacje" );
       // button.setBounds(135,513,280,50);
        button.addActionListener(this);
        //panel
        mainPanel = new JPanel();
        panelPoprostu = new JPanel();
        panelPoprostu.setBackground(fajnyTurkusowy);
        mainPanel.setBackground(fajnyTurkusowy);

        // mainPanel.setSize(40,40);

      //  mainPanel.setBounds(43,0,500,500);
        //lable
        logo = new JLabel();
      //  label.setBounds(100,100,200,50);
        logo.setBackground(fajnyTurkusowy);
        logo.setOpaque(true);
        logo.setText("                                                           " +
                "System rezerwacji rowerów®");
        logo.setVisible(true);

        label2 = new JLabel();
        //label2.setBounds(200,200,200,50);
        //label2.setBackground(new Color(185, 26, 105));
        label2.setOpaque(true);
        label2.setText("Stacja uwuuwuwu 69/420");
        label2.setVisible(true);
        //central lable
        centralLable1 = new JLabel();
        centralLable2 = new JLabel();

        centralLable1.setBackground(Color.RED);
        centralLable1.setText("testuuuuwa1");
        centralLable1.setBounds(100, 100, 100, 100);

        centralLable2.setBackground(Color.RED);
        centralLable2.setText("testuuuuwa2");
        centralLable2.setBounds(50,50,100,100);


        //ustawienia frame
        JFrame frame = new JFrame();
        frame.setTitle("System Rezerwacji Rowerów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));
        //  frame.setResizable(false);
        frame.setSize(600,600);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("bikeIcon.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(5, 155, 149));
        // Jlayerd pane

        JLayeredPane panelCentralny = new JLayeredPane();
        panelCentralny.setBackground(fajnyTurkusowy);
        panelCentralny.add(centralLable1,JLayeredPane.DEFAULT_LAYER);
        panelCentralny.add(centralLable2,JLayeredPane.DEFAULT_LAYER);
        panelCentralny.add(dragpointer,JLayeredPane.DRAG_LAYER );
        //frame.add(dragpointer);

        //label.setOpaque(true);
       // label2.setOpaque(true);



        //mainPanel.setSize(50,400);
        //Container conteiner = frame.getContentPane();
       // conteiner.setLayout(new BorderLayout(30,30));
        mainPanel.setPreferredSize(new Dimension(50,50));
        panelPoprostu.setPreferredSize(new Dimension(50,50));
        //mainPanel.add(label);
        //mainPanel.add(label2);

        //Container.add(dragpointer);
        //mainPanel.add(dragpointer);
       //mainPanel.setBackground(fajnyzielony);
        frame.add(logo,BorderLayout.NORTH);
        frame.add(mainPanel,BorderLayout.EAST);
        frame.add(panelPoprostu,BorderLayout.WEST);
        frame.add(button,BorderLayout.SOUTH);
        frame.add(label2);
        frame.add(panelCentralny,BorderLayout.CENTER);


                         /* DANGER */
        //ALBAŃSKI RAJ, NIE RUSZAĆ STRASZNA BESTIA

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
