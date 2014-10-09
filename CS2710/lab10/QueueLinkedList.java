import java.util.Formatter;

public class QueueLinkedList {

    private static class Node {
        public Node( int elem, Node next ) {
            this.elem = elem;
            this.next = next;
        }
        public Node( int elem ) {
            this( elem, null );
        }
        public int elem;
        public Node next;
    }

    private Node last;
    private Node first;
    private int len;

    public QueueLinkedList() {
        this.last = this.first = null;
        this.len = 0;
    }

    public void add( int elem ) {
        Node entry = new Node( elem, null );
        if ( len == 0 ) {
            last = first = entry;
        }
        else {
            last.next = entry;
            last = entry;
        }
        len++;
    }

    public int remove() {
        if ( len <= 0 ) return 0; // XXX error
        int d = first.elem;
        Node t = first.next;
        first.next = null; // mark as free, not required
        first = t;         // advance to next node
        len--;
        if ( len == 0 ) {
            last = first = null;
        }
        return d;
    }

    public int getLength() {
        return len;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        if ( last != null ) {
            fmt.format("last: %-8x%n", last.hashCode() );
        }
        else {
            fmt.format("last: %-8s%n", "null");
        }
        if ( first != null ) {
            fmt.format("first: %-8x%n", first.hashCode() );
        }
        else {
            fmt.format("first: %-8s%n", "null");
        }
        fmt.format("len: %-4d%n", len );
        // traverse the list and print out the hash values
        fmt.format("%-5s", "hash:" );
        Node n = first;
        while ( n != null ) {
            fmt.format( "%12x", n.hashCode() );
            n = n.next;
        }
        fmt.format("%n");
        // traverse the list and print out the element values
        fmt.format("%-5s", "elem:" );
        n = first;
        while ( n != null ) {
            fmt.format( "%12d", n.elem );
            n = n.next;
        }
        fmt.format("%n");
        return fmt.toString();
    }

    public static void main( String[] args ) {
        QueueLinkedList q = new QueueLinkedList();
        assert q.getLength() == 0;
        q.add( 3 );
        assert q.getLength() == 1;
        q.add( 4 );
        assert q.getLength() == 2;
        q.add( 7 );
        assert q.getLength() == 3;
        System.out.println( q );
    }

}
