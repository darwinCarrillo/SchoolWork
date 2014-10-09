public class Appointment
{
   private Date date;
   private String description;
   private DateFormat formatter = DateFormat.getDateTimeInstance(
         DateFormat.MEDIUM, DateFormat.SHORT);

   public Appointment(String aDate, String aDescription)
      throws ParseException
   {
      date = formatter.parse(aDate);
      description = aDescription;
   }


   public String toString()
   {
      return "Appointment[date=" 
           + formatter.format(date) 
           + "description=" + description + "; "
           + "]";
   }
}
