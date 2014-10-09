import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelloFrame extends JFrame
{
   private double fontSizeFactor = 1;
   private String message;
   private JLabel label;
   
   private static int FRAME_WIDTH = 300;
   private static int FRAME_HEIGHT = 300;
   private static int DEFAULT_SIZE = 20;

   public HelloFrame()
   {
      message = "Hello, World!";
      label = new JLabel(message);
      label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
      add(label, BorderLayout.CENTER);
      
      createMenu();
      
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
   
   private void createMenu()
   {
      JMenuBar menuBar = new JMenuBar(); 
      setJMenuBar(menuBar);
      
      JMenu fontMenu = new JMenu("Font");
      menuBar.add(fontMenu);

      JMenuItem largerItem = new JMenuItem("Larger"); 
      fontMenu.add(largerItem);  

      JMenuItem smallerItem = new JMenuItem("Smaller"); 
      fontMenu.add(smallerItem);
      
      // create and add the action listeners
      largerItem.addActionListener(makeScaleActionListener(1.25));
      smallerItem.addActionListener(makeScaleActionListener(0.8));
   }
   
   public ActionListener makeScaleActionListener(final double scaleFactor) 
   {
      class ScaleListener implements ActionListener  
      {
         public void actionPerformed(ActionEvent event) 
         {
            fontSizeFactor = scaleFactor * fontSizeFactor;
            label.setFont(new Font("Serif", Font.PLAIN,
                     (int) (DEFAULT_SIZE * fontSizeFactor)));
            label.repaint();
         } 
      } 
      return new ScaleListener(); 
   } 
}
