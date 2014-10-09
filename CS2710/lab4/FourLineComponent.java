import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

public class FourLineComponent extends JComponent
{  
   private int x;
   private int y;

   public FourLineComponent()
   {  
      x = 50;
      y = 100;
   }

   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
      // Create the four lines
      Line2D.Double l1 = new Line2D.Double(0, 0, x, y);
      Line2D.Double l2 = new Line2D.Double(0, getHeight(), x, y);
      Line2D.Double l3 = new Line2D.Double(getWidth(), 0, x, y);
      Line2D.Double l4 = new Line2D.Double(getWidth(), getHeight(), x, y);
      
      // Draw the lines
      g2.draw(l1);
      g2.draw(l2);
      g2.draw(l3);
      g2.draw(l4);
   }
   
   public void setPoint(Point2D.Double p)
   {
      x = (int) p.getX();
      y = (int) p.getY();
   }
}


