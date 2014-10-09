import java.util.Date;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemoPadCreator
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Date now;
      Scanner console = new Scanner(System.in);
      System.out.print("Output file:");
      String filename = console.nextLine();

      PrintStream out = new PrintStream(filename);

      boolean done = false;
      while (!done)
      {
         System.out.println("Memo topic (enter -1 to end):");
         String topic = console.nextLine();
         if (topic.equals("-1"))
            done = true;
         else
         {
            System.out.println("Memo text:");
            String message = console.nextLine();
            now = new Date();
	    String dateStamp = now.toString();
            out.println(topic + "\n" + dateStamp + "\n" + message);
         }
      }
      out.close();
   }
}
