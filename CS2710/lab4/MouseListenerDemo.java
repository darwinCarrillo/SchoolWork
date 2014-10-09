import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import java.awt.Color;

public class MouseListenerDemo
{
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;

   public static void main(String[] args)
   {
      final JFrame frame = new JFrame();
      
      // Create and add a mouse listener

      class EnterExitListener implements MouseListener
      {
         public void mouseEntered(MouseEvent event)
         {
            frame.getContentPane().setBackground(Color.RED);
         }
         
         public void mouseExited(MouseEvent event)
         {
            frame.getContentPane().setBackground(Color.BLUE);
         }

         // Do-nothing methods
         public void mousePressed(MouseEvent event) {}
         public void mouseReleased(MouseEvent event) {}
         public void mouseClicked(MouseEvent event) {}
      }
         
      MouseListener listener = new EnterExitListener();
      frame.addMouseListener(listener);

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
