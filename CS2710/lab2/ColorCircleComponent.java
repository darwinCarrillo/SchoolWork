import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;


public class ColorCircleComponent extends JComponent{

	public void paintComponent(Graphics g){

		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.RED);
		Ellipse2D.Double circle = new Ellipse2D.Double(50, 50, 200, 200);
		g2.draw(circle);

		g2.setColor(Color.GREEN);
		circle = new Ellipse2D.Double(70, 90, 160, 160);
		g2.draw(circle);
	
		g2.setColor(Color.MAGENTA);
		circle = new Ellipse2D.Double(110, 170, 80, 80);
		g2.draw(circle);
	
		g2.setColor(Color.YELLOW);
		circle = new Ellipse2D.Double(130, 210, 40, 40);
		g2.draw(circle);
}
}
