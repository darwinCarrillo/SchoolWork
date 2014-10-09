public class TrimIt
{
   public static void main(String[] args)
   {
      String sentence1 = "      abc   ";
      String sentence2 = "   def";
      String sentence3 = "ghi         ";
       
      /* Your work goes here */
	sentence1 = sentence1.trim();
	sentence2 = sentence2.trim();
	sentence3 = sentence3.trim();
	String all = new String();
	all = sentence1 + sentence2 + sentence3;
      System.out.println(all);
   }
}
