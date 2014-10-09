import static java.lang.System.out;

/**
 * Bad syntax example
 * @author Rod Byrne
 */
public class Syntax4 {                                  //@err

    private static double areaOfCircle( double radius) {
        return Math.PI * radius * radius;                  //@err
    }

    public static void main( String[] args ) {
        System.out.println("Area of 1.0 circle " + areaOfCircle(1.0) );   //@err
        System.out.println("Area of 2.0 circle " + areaOfCircle(2.0) );   //@err
        System.out.println("Area of 4.0 circle " + areaOfCircle(4.0) );   //@err
        System.out.println("Area of 8.0 circle " + areaOfCircle(8.0) );  //@err
    }
}
