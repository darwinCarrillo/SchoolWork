import java.util.Comparator;

public class CityComparator implements Comparator<City>
{
   public int compare(City a, City b)
   {
      if (a.getState().compareTo(b.getState()) == 0)
         return a.getName().compareTo(b.getName());
      return a.getState().compareTo(b.getState());
   }
}
