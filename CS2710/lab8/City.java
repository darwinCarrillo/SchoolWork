public class City implements Comparable<City>
{
   private String name;
   private String state;

   public City(String name, String state)
   {
      this.name = name;
      this.state = state;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getState()
   {
      return state;
   }
   
   public int compareTo(City other)
   {
      if (name.compareTo(other.name) == 0)
         return state.compareTo(other.state);
      return name.compareTo(other.name);
   }
   
   public String toString()
   {
      return "City[" + name + "," + state + "]";
   }
}
