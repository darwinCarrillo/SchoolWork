import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.Line2D;

public class Triangle extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      Line2D.Double l1 = new Line2D.Double(100, 100, 200, 100);
      g2.draw(l1);

      Line2D.Double l2 = new Line2D.Double(100, 100, 150, 20);
      g2.draw(l2);

      Line2D.Double l3 = new Line2D.Double(150, 20, 200, 100);
      g2.draw(l3);
   }
}

