import java.util.*;

public class FloatingAdd{

	public static double add(double a, double b,double c){

		return (a+b) + c;
	
	}

	public static void main (String [] args){

		Scanner yup = new Scanner(System.in);
		int indeed;
		System.out.println("Enter something. DANGER BALL!");
		indeed = yup.nextInt();
		System.out.println(indeed);
		System.out.println(add(1e16, -1e16, 1.0));
		System.out.println(add(1e16, 1.0, -1e16));
		System.out.println(add(1e14, -1e14, 1.0));
		System.out.println(add(1e14, 1.0, -1e14));		
		
		}

}
