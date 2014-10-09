/**
 * Bad syntax example
 * @author Rod Byrne
 */
public class Syntax3 {

    private static void printMsg() {
        System.out.print(  "4 + 7 is ");  
        System.out.println( 4 + 7  );
	}
    // end of printMsg                                          //@err

    public static void main( String[] args ) {
        printMsg();                                               //@err
    }
}
