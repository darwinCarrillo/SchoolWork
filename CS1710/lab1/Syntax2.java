/**
 * Bad syntax example
 * @author Rod Byrne
 */
public class Syntax2 {

    private static void printMsg() {
        System.out.println( "hello" );             //@err
        System.out.println( "world" );java             //@err
    }

    public static void main( String[] ags ) {
        printMsg();
    }
}
