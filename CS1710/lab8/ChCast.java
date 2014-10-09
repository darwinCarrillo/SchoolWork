public class ChCast {
    public static void main( String[] args ) {
        char c = 48;
        System.out.printf("%d = '%c'%n", (int)c, c );
        c += 1;
        System.out.printf("%d = '%c'%n", (int)c, c );
        c =   (char)(c + 1);
        System.out.printf("%d = '%c'%n", (int)c, c );
        c = (char) 100000;
        System.out.printf("%d = '%c'%n", (int)c, c );
    }
}
