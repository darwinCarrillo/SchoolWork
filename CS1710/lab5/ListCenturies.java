public class ListCenturies
{
   public static void main(String[] args)
   {
      int from;
      int to;

      for (int i = -5; i <= 5; i++)
      {
         if (i < 0)
         {
            if (((i * -1) - 1) * 100 != 0)
               from = ((i * -1) - 1) * 100;
            else
               from = 1;
            to = ((i * -1) * 100 - 1);

            System.out.println("Century " + (i * -1) + " BC  " + from + "-" + to );
         }
         else if (i > 0)
         {
            if ((i - 1) * 100 != 0)
               from = (i - 1) * 100;
            else
               from = 1;
            to = i * 100 - 1;

            System.out.println("Century " + i + " AD  " + from + "-" + to );
         }

      }
   }
}
