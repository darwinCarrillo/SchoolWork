public class AnimalRunner
{
   public static void main(String[] args)
   {
      Dog d1 = new Dog("Fred");
      d1.speak();
      Object obj = new Dog("Connie");
      Dog d2 = (Dog)obj;
      d2.speak();
      	
   }
}

