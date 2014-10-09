import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DoorPanel extends JPanel
{
   private Door door;
   private JButton openButton;
   private JButton closeButton;
   private JTextField txtField;

   public DoorPanel ()
   {
      door = new Door("closed");
      txtField = new JTextField(20);
      txtField.setText(door.getMessage());
      setBackground (Color.blue);
      setPreferredSize (new Dimension(360, 400));
      setLayout(new BorderLayout());
      setFont (new Font("Arial", Font.BOLD, 16));
      openButton = new JButton("Open");
      closeButton = new JButton("Close");
      ButtonListener bl = new ButtonListener();
      openButton.addActionListener (bl);
      closeButton.addActionListener (bl); 
      JPanel buttonPanel = new JPanel();
      buttonPanel.setPreferredSize(new Dimension(200,60));
      buttonPanel.add(openButton);
      buttonPanel.add(closeButton);
      buttonPanel.add(txtField);
      add(buttonPanel, BorderLayout.NORTH);
   }

   public void paintComponent (Graphics page)
   {
      super.paintComponent(page);
      if (door.isOpen())
      {
         door.drawOpenDoor(page);
      }
      else
      {
         door.drawClosedDoor(page);
      }
   }

   private class ButtonListener implements ActionListener
   {
      /**
         Updates the counter and label when the button is pushed.
      */
      public void actionPerformed (ActionEvent event)
      {
         if (event.getSource() == openButton)
         {
            door.open();
            txtField.setText(door.getMessage());
         }
         else 
         {
            door.close();
            txtField.setText(door.getMessage());
         }
         repaint();
      }
   }
}
