import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Date;

/**
   Displays the current time once every second.
*/
public class TimerDemo
{
   public static void main(String[] args)
   {
      class CurrentTimePrinter implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            System.out.println(new Date());
         }
      }

      CurrentTimePrinter listener = new CurrentTimePrinter();

      final int DELAY = 1000; // milliseconds between timer ticks
      final Timer t = new Timer(DELAY, listener);
      t.start();

class TimerToggler implements ActionListener 
{
   public void actionPerformed(ActionEvent event) 
   {
      if (t.isRunning()) 
         t.stop(); 
      else 
         t.restart(); 
   } 
}  

ActionListener listener2 = new TimerToggler(); 
Timer t2 = new Timer(15000, listener2); 
t2.start(); 	

class ProgramStopper implements ActionListener
{
   public void actionPerformed(ActionEvent event)
   {
      System.exit(0);
   }
}

ActionListener listener3 = new ProgramStopper();
Timer t3 = new Timer(120000, listener3);
t3.start();

JOptionPane.showMessageDialog(null, "Please wait"); 

   }
}

