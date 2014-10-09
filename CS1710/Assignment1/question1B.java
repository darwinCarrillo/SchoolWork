import java.util.*;

public class question1B{

	public static void main (String [] args){
		
		String word = new String("kaap ewey");
		StringTokenizer letters = new StringTokenizer(word);
		String word1, word2;
		
		word1 = letters.nextToken().replace("a", "e");
		word2 = letters.nextToken().replace("e" ,"a");

		System.out.println(word1 + " " + word2);	
	
		}

}
