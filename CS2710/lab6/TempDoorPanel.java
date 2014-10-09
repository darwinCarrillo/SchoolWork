import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TempDoorPanel extends JPanel
{
   private Door door;
   
   public TempDoorPanel ()
   {
      door = new Door("closed");
      setBackground (Color.blue);
      setPreferredSize (new Dimension(360, 400));
   }

   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);
      //door.drawOpenDoor(page);
      door.drawClosedDoor(page);
   }
}
