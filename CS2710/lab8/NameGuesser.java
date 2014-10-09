import java.util.*;
import java.io.*;
import java.net.*;
public class NameGuesser
{
	public NameGuesser(){}

public static void main(String [] args)throws IOException, MalformedURLException{
	NameGuesser ng = new NameGuesser();	
	ng.readNames();
	ng.guessName();
}
   private ArrayList<String> lastNames = new ArrayList<String>();

public void readNames() throws IOException, MalformedURLException
{
   // Read the last names
   URL url = new URL("http://www.census.gov/genealogy/www/data/1990surnames/dist.all.last");
   Scanner in = new Scanner(url.openStream());
   while (in.hasNext())
   {
      // Read the last name
      String lastName = in.next();
      lastNames.add(lastName);
     
      // Ignore the statistical information
      in.nextDouble();
      in.nextDouble();
      in.nextInt();
   }
   in.close();
  
   // Sort the names
   Collections.sort(lastNames);
}

public void guessName()
{
   int low = 0;
   int high = lastNames.size() - 1;
   int mid = (low + high) / 2;

   Scanner in = new Scanner(System.in);
  
   System.out.println("This program tries to guess your last name,"
         + " but you have to give some hints.");
  
   String reply;
   boolean done = false;
   while (!done)
   {
      System.out.println("Is your name equal to \"" + lastNames.get(mid)
            + "\" in the dictionary? (Y/N)");
      reply = in.next();
      if (reply.equalsIgnoreCase("Y"))
         done = true;
      else {
         System.out.println("Is your name less than \"" + lastNames.get(mid)
               + "\" in the dictionary? (Y/N)");
         reply = in.next();
         if (reply.equalsIgnoreCase("Y"))
            high = mid - 1;
         else
            low = mid + 1;
      }
     
      mid = (low + high) / 2;
    
      if (low > high)
         done = true;
   }
  
   if (low <= high)
      System.out.println("Your last name is in the file.");
   else
      System.out.println("Sorry, your last name is not in the file.");
}


}
