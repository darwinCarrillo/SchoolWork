import javax.swing.JFrame;

public class DoorRunner
{
   /**
      Creates the main frame of the program.
   */
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Door");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      DoorPanel panel = new DoorPanel();
      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
