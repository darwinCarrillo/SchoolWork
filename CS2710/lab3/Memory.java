import java.util.ArrayList;

public class Memory
{
   ArrayList<String> lifeData;
      
   public Memory(Person p)
   {
      lifeData = new ArrayList<String>();
      lifeData.add("Name: " + p.getName());
      lifeData.add("Age:  " + p.getAge());
   }

   public void addLifeData(String datum)
   {
      lifeData.add(datum);
   }

   public void dumpMemory()
   {
      for (String s: lifeData)
      {
         System.out.println(s);
      }
   }
}

