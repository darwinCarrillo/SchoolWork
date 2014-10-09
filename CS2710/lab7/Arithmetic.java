public class Arithmetic
{
   public static int gcd(int a, int b)
   {
      if ((a == 0) || (b == 0))
         return a + b;
      if (a < b) 
      {
         b = b % a;
      }
      else
      {
         a = a % b;
      }
      return gcd(a,b);
   }
}
