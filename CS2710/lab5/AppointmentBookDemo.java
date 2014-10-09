import java.util.Scanner;
import java.text.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AppointmentBookDemo
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      AppointmentBook book = null;
      AppointmentBookReader bookReader = new AppointmentBookReader();
      
      try
      {
         System.out.println("Please enter the file name: ");
         String filename = in.next();
         book = bookReader.read(filename);
      }
      catch (FileNotFoundException exception)
      {
         System.out.println("File not found.");
      }
      catch (IOException exception)
      {
         System.out.println(exception);
      }
      catch (ParseException exception)
      {
         System.out.println("Bad date format.");
      }
      
      System.out.println(book);
   }
}
