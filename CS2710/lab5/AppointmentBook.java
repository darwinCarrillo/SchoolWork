import java.util.ArrayList;
import java.text.ParseException;

public class AppointmentBook
{
   private ArrayList<Appointment> book;

   public AppointmentBook()
   {
      book = new ArrayList<Appointment>();
   }
   
   public void add(String aDate, String aDescription)
      throws ParseException
{
   Appointment appointment = new Appointment(aDate, aDescription);
   book.add(appointment);
}



   public void addAll(ArrayList<Appointment> list)
   {
      book.addAll(list);
   }
   
   public int getNumAppointments()
   {
      return book.size();
   }
   
   public Appointment getAppointment(int i)
   {
      return book.get(i);
   }

   public String toString()
   {
      String out = "";
      for (Appointment a : book)
      {
         out = out + a.toString() + "\n";
      }
      return out;
   }
}
