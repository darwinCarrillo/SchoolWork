import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZipsReader
{
   public static void main(String[] args)throws FileNotFoundException
   {
      File inFile = new File("ziptable.txt");
      File outFile = new File("ziptablemod.txt");
      PrintWriter pw = new PrintWriter(outFile);
      Scanner scan = new Scanner(inFile);
      while (scan.hasNextLine())
      {
         String line = scan.nextLine();
         Scanner lineScan = new Scanner(line);
         while (lineScan.hasNext())
         {
            String token = lineScan.next();
            if (token.matches("\\d{3}-\\d{3}"))
            {
               pw.print(token + " ");
            }
            else if (token.matches("\\d{3}"))
            {
               pw.print(token + "-" + token + " ");
            }
            else
            {
               pw.print(token + " ");
            }
         }
         pw.println();
      }
      pw.close();
   }
}
