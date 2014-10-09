import java.util.*;
public class Peevish
{
   public static void main(String[] args)
   {
      final int NUMDOORS = 100;
      ArrayList<Door> boxes = new ArrayList<Door>();
      boxes.add(null);  // Waste the first ArrayList cell with a null reference
      for (int i = 1; i <= NUMDOORS; i++)
      {
         boxes.add(new Door("closed", i));
      }

      for (int pass = 1; pass <= NUMDOORS; pass++)
      {
         for (int num = pass; num <= NUMDOORS; num = num + pass)
         {
            Door d = boxes.get(num);
            if (d.isOpen())
            {
               d.close();
            }
            else 
            {
               d.open();
            }
         }
      }

      for (Door d : boxes)
      {
         if (d != null)
         {
            System.out.println(d);
         }
      }
   }
}
