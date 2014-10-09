import java.util.GregorianCalendar;
import java.util.Calendar;

public class DriverLicense extends IDCard
{
   private int expYear;

   public DriverLicense(String n, String id, int ey)
   {
      super(n, id);
      expYear = ey;
   }
   
   public String format()
   {
      return super.format() + ", Expiration year: " + expYear; 
   }
   
   public boolean isExpired()
   {
      GregorianCalendar calendar = new GregorianCalendar();
      if (calendar.get(Calendar.YEAR) > expYear)
         return true;
      else
         return false;
   }
   
   public int getExpYear()
   {
      return expYear;
   }

   public String toString()
   {
	return "DriverLicense[name=" + getName() + "][idNumber=" + getIDnumber() +
         ",expYear=" + expYear + "]";
   }

public boolean equals(Object otherObject)
{
  if (getClass() == otherObject.getClass())
  {
    DriverLicense other = (DriverLicense) otherObject;
    return getName().equals(other.getName()) &&
           getIDnumber().equals(other.getIDnumber()) &&
           expYear == other.expYear;
  }

  return false;
}
	
}
