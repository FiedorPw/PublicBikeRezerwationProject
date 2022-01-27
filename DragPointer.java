import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

//drag and drop mechanique

public class DragPointer extends JPanel{

    ImageIcon pointer = new ImageIcon("pointer.png");
    final int WIDTH = pointer.getIconWidth();
    final int HEIGHT = pointer.getIconHeight();
    Point imageCorner;
    Point prevPT;








    public DragPointer() {
        imageCorner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        pointer.paintIcon(this,g,(int)imageCorner.getX(),(int)imageCorner.getY());
    }
    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            prevPT = e.getPoint();
        }
    }
    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e){
            Point currentPt = e.getPoint();
            imageCorner.translate(
                    (int)(currentPt.getX()-prevPT.getX()),
                    (int)(currentPt.getY()-prevPT.getY())
                     );
            prevPT = currentPt;
            repaint();
        }

    }

}
