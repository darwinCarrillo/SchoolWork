import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;


public class HouseComponent extends JComponent{

	public void paintComponent(Graphics g){

		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle box = new Rectangle(50, 100, 90, 80);
		g2.draw(box);		

		Rectangle window = new Rectangle(60, 110, 20, 20);
		g2.draw(window);

		window.translate(50, 0);
		g2.draw(window);

		Rectangle door = new Rectangle(85, 140, 20, 40);
		g2.draw(door);

		Line2D.Double roofLine1 = new Line2D.Double(50, 100, 95, 75);
		g2.draw(roofLine1);

		Line2D.Double roofLine2 = new Line2D.Double(95, 75, 140, 100);
		g2.draw(roofLine2);
}
}
