import java.util.Scanner;
import java.text.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class AppointmentBookReader 
{ 
   private AppointmentBook book; 

   public AppointmentBookReader() 
   { 
      book = new AppointmentBook();
   } 

   public AppointmentBook read(String filename)
      throws IOException, ParseException 
   {
      FileReader reader = new FileReader(filename);
      Scanner in = new Scanner(reader);
      while (in.hasNextLine()) 
      { 
         String input1 = in.nextLine(); 
         String input2 = in.nextLine(); 
         book.add(input1, input2); 
         reader.close();
      } 
      return book; 
   } 
}
