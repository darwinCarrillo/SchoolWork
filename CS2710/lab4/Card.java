public class Card
{
   private String name;

   public Card()
   {
      name = "";
   }

   public Card(String n)
   {
      name = n;
   }

   public String getName()
   {
      return name;
   }

   public boolean isExpired()
   {
      return false;
   }

   public String format()
   {
      return "Card holder: " + name;
   }
   public String toString()
   {
	return "Card[name=" + name + "]";  
   }
public boolean equals(Object otherObject)
{
  if (getClass() == otherObject.getClass())
  {
    Card other = (Card) otherObject;
    return name.equals(other.name);
  }

  return false;
}

	
}
