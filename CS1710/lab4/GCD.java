import java.util.Scanner;

public class GCD
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the first integer: ");
      int x = in.nextInt();
      System.out.println("x = " + x);
      System.out.println("Enter the second integer: ");
      int y = in.nextInt();
      System.out.println("y = " + y);
      
	while ( x != 0 && y != 0){

		if (x > y){
			x = x-y;
		}
		else{
			y = y - x;
		}	
	}	
	int gcd = x + y;
	System.out.println(gcd);
   }    
}
