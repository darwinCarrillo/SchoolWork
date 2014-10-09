import javax.swing.*;
import java.util.*;
public class Josephus
{
   public static void main(String[] args)
   {
      String ans = JOptionPane.showInputDialog("Enter the number of men: ");
      int noMen = Integer.parseInt(ans);
      System.out.println("You entered: " + noMen);
      LinkedList<Integer> circle = new LinkedList<Integer>();
      for (int i = 1; i <= noMen; i++)
      {        
         circle.add(new Integer(i));
      }
      while (circle.size() > 1)
      {
         System.out.println(circle);
         Collections.rotate(circle, -1);
         circle.removeFirst();
     }
     System.out.println("The last man standing was at position " 
           + circle.getFirst());
   }
}
