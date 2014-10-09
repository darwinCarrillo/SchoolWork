/**
 * See http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 *
 * @author Rod Byrne
 */
public class SieveEratosthenes {

    // numbers[index] is true if index is prime,
    // to simplify the program numbers[0] stands for 0
    // and numbers[1] stands for 1 will be skipped
    private boolean[] numbers;

    public SieveEratosthenes( int size ) {
        numbers = new boolean[size];
        for( int i = 0 ; i < size; i++ ) {
            numbers[i] = true;
        }
        runSieve();
    }

    // perform the sieve of Eratosthenes algorithm
    private void runSieve() {
        // skip 0 and 1
        for( int i = 2 ; i < numbers.length; i++ ) {
            if ( numbers[i] ) {
                for( int j = i + i; j < numbers.length; j += i ) {
                     numbers[j] = false;
                }
            }
        }
    }

    public boolean isPrime( int num ) {
        return numbers[ num ];
    }

    public int getLastNumber() {
        return numbers.length - 1;
    }

    public void prettyPrint( int rowSize ) {
        int r = 0;
        for( int n = 2; n <= getLastNumber() ; n++ ) {
            if ( isPrime( n ) ) {
                System.out.printf( "%5d", n );
                r++;
                if ( r >= rowSize ) {
                    System.out.println();
                    r = 0;
                }
            }
        }
        if ( r != 0 ) {
            System.out.println();
        }
    }

    public static void main( String[] args ) {
        SieveEratosthenes se = new SieveEratosthenes( 30 );

        // print out all the print numbers up to 100
        for( int n = 2; n <= se.getLastNumber() ; n++ ) {
            if ( se.isPrime( n ) ) {
                System.out.printf(" %d is prime%n", n );
            }
        }

        // allocate a new object
        se = new SieveEratosthenes( 30 );
        se.prettyPrint( 15 );
    }
}
