import javax.swing.JFrame;
public class TempDoorRunner
{
   /**
      Creates the main frame of the program.
   */
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Door");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      TempDoorPanel panel = new TempDoorPanel();
      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
