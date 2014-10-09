import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class MemoPadReader
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner console = new Scanner(System.in);
      JFileChooser chooser = new JFileChooser();
      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
      {
         File selectedFile = chooser.getSelectedFile();
         Scanner in = new Scanner(selectedFile);

         boolean done = false;
         while (in.hasNextLine() && !done)
         {
            String topic = in.nextLine();
            String dateStamp = in.nextLine();
            String message = in.nextLine();
            System.out.println(topic + "\n" + dateStamp + "\n" + message);

            if (in.hasNextLine())
            {
               System.out.println("Do you want to read the next memo (y/n)?");
               String ans = console.nextLine();
               if (ans.equalsIgnoreCase("n"))
                  done = true;
            }
         }
         in.close();
      }
   }
}
