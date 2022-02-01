import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import static java.lang.Thread.sleep;

// sprawdzenie
public class GUI extends JPanel implements ActionListener, MouseListener  {
     Color fajnyzielony = new Color(46, 248, 68);
     Color fajnyTurkusowy = new Color(28, 229, 222);
     JPanel leftpanel;
    JPanel panelPoprostu;
    DragPointer dragpointer = new DragPointer();
     JLabel logo;
     JLabel label2;
     JLabel lablePW;
     JLabel LableSGH;
     JLabel LableUW;
     JLabel LableWUM;

     JButton button;
     boolean mouseTracking = false;
     int labelPW = 10;
     int labelUW = 8;
     int labelWUM = 12;
     int lableSGH = 9;

    public GUI() {


        ImageIcon image = new ImageIcon("bikeIcon.png");
        //button
        button = new JButton("Kliknij aby rozpocząc symulacje" );
       // button.setBounds(135,513,280,50);
        button.addActionListener(this);
        //panel
        leftpanel = new JPanel();
        panelPoprostu = new JPanel();
        panelPoprostu.setBackground(fajnyTurkusowy);
        leftpanel.setBackground(fajnyTurkusowy);

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

        label2.setVisible(true);
        //central lable
        lablePW = new JLabel();
        LableSGH = new JLabel();
        LableUW = new JLabel();
        LableWUM = new JLabel();

        lablePW.setBackground(Color.RED);
        lablePW.setText("Polibudowa " + labelPW+ "/10");
        lablePW.setBounds(350, 200, 150, 100);

        LableSGH.setBackground(Color.RED);
        LableSGH.setText("Sghowa " + lableSGH+ "/9");
        LableSGH.setBounds(200,350,100,100);

        LableUW.setBackground(Color.RED);
        LableUW.setText("Uwuwowa " + labelUW+ "/8");
        LableUW.setBounds(200,50,100,100);

        LableWUM.setBackground(Color.RED);
        LableWUM.setText("Wumowa " + labelWUM+ "/12");
        LableWUM.setBounds(50,200,100,100);





        //ustawienia frame
        JFrame frame = new JFrame();
        frame.setTitle("System Rezerwacji Rowerów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));
        //frame.setResizable(false);
        frame.setSize(600,600);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("bikeIcon.png");
        frame.setIconImage(icon.getImage());
        frame.getContentPane().setBackground(new Color(5, 155, 149));

        // Jlayerd pane
        JLayeredPane panelCentralny = new JLayeredPane();
        panelCentralny.setBackground(fajnyTurkusowy);
        panelCentralny.add(lablePW,JLayeredPane.DEFAULT_LAYER);
        panelCentralny.add(LableSGH,JLayeredPane.DEFAULT_LAYER);
        panelCentralny.add(LableUW,JLayeredPane.DEFAULT_LAYER);
        panelCentralny.add(LableWUM,JLayeredPane.DEFAULT_LAYER);

        panelCentralny.add(dragpointer,JLayeredPane.DRAG_LAYER );
        //frame.add(dragpointer);

        //label.setOpaque(true);
       // label2.setOpaque(true);



        //mainPanel.setSize(50,400);
        //Container conteiner = frame.getContentPane();
       // conteiner.setLayout(new BorderLayout(30,30));
        leftpanel.setPreferredSize(new Dimension(50,50));
        panelPoprostu.setPreferredSize(new Dimension(50,50));
        //mainPanel.add(label);
        //mainPanel.add(label2);



       //mainPanel.setBackground(fajnyzielony);
        frame.add(logo,BorderLayout.NORTH);
        frame.add(leftpanel,BorderLayout.EAST);
        frame.add(panelPoprostu,BorderLayout.WEST);
        frame.add(button,BorderLayout.SOUTH);
        frame.add(label2);
        frame.add(panelCentralny,BorderLayout.CENTER);


                         /* DANGER */
        //ALBAŃSKI RAJ, NIE RUSZAĆ STRASZNA BESTIA, niszczy wszysko na swojej drodze

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
               MainApp app = new MainApp("stations.csv", "users.csv");
               app.usersClosestStations();
               app.getAmountOfPoeopleOnStations();



              /* for (int i = 0; i< 28;i++) {
                       int liczba = (int) (Math.random() * ((3) + 1));
                       try {
                           sleep(10);
                       } catch (InterruptedException ex) {
                           ex.printStackTrace();
                       }*/
               labelPW -= app.peopleonStation3;
               labelUW -= app.peopleonStation2;
               lableSGH -= app.peopleonStation1;
               labelWUM -= app.peopleonStation4;
               LableUW.setText("Uwuwowa " + labelUW+ "/8");
               lablePW.setText("Polibudowa " + labelPW+ "/10");
               LableSGH.setText("Sghowa " + lableSGH+ "/9");
               LableWUM.setText("Wumowa " + labelWUM+ "/12");

               /* if(liczba == 3 && labelPW > 0) labelPW--;
                       else if (liczba == 2 && labelUW > 0) labelUW--;
                       else if (liczba == 1 && lableSGH > 0) lableSGH--;
                       else if (liczba == 4 && labelWUM > 0) labelWUM--;


                   }  */

                   mouseTracking = false;
           }

       }
   }



    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println();

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
    //Random rn = new Random();


    }



