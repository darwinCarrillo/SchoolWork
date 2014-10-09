public class Shift {
    private int[] elements; // array of integers

    public Shift( int size ) {
        elements = new int[size];
        // initialize elements to: 0, 1, 2, .. size-1
        for( int i = 0 ; i < size-1; i++ ) {
            elements[i] = i;
        }
    }

    // print upto end-1
    public void print( int end) {
        for(int i = 0 ; i < end; i++ ) {
            System.out.printf("%5d", elements[i] );
        }
        System.out.println();
    }

    public void replaceZero( int x ) {
        elements[0] = x;
    }
    /**
     * shiftUpFixed moves 4 arrays element up one
     * position, this leaves the zero element available,
     * the element array's size must be greater or equal to 5.
     */
    public void shiftUpFixed() {
        /* notice that the elements at the end are shifted first */
        elements[4] = elements[3];
        elements[3] = elements[2];
        elements[2] = elements[1];
        elements[1] = elements[0];
    }

    /**
     * shiftUp, shifts the entire array by one element using
     * a loop. Hint: the first element to shift is elements[size-2] to
     * elements[size-1], the last element to shift is elements[0] to
     * elements[1].
     */
    public void shiftUp() {
        for(int i = elements.length; i > 1; i--){
		elements[i - 1] = elements[i - 2];
	}
    }

    public static void main( String[] args)  {
        Shift sh = new Shift( 10 );
        System.out.println("orginal: ");
        sh.print( 5 );
        sh.shiftUpFixed();
        sh.replaceZero( -1 );
        System.out.println("after shiftUpFixed: ");
        sh.print( 5 );

        // start again
        sh = new Shift( 10 );
        System.out.println("orginal: ");
        sh.print( 10 );
        sh.shiftUp(); // test your implementation
        sh.replaceZero( -1 );
        System.out.println("after shiftUp: ");
        sh.print( 10 );
    }
}
