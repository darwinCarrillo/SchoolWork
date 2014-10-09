import java.util.*;
import java.util.ArrayList;

public class Person
{
   private String name;
   private int age;
   private Memory mem;
  
   public Person(String name, int age)
   {
      this.name = name;
      this.age = age;
      mem = new Memory(this);
   }

   public String toString()
   {
      return "Name:  " + name + '\n' +
             "Age:  " + age + '\n';
   }

   public String getName()
   {
      return name;
   }

   public int getAge()
   {
      return age;
   }

   public void tellAll()
   {
      mem.dumpMemory();
   }

   public void rememberAnEvent(String s)
   {
       mem.addLifeData(s);
   }
}


