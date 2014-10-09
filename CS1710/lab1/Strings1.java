public class Strings1{

	public static void main(String[] args){
		String test = new String("This is a test.");
		String testLower = new String();
		
		testLower = test.toLowerCase();
		System.out.println(testLower);

		String bigTestString = testLower.toUpperCase();
		System.out.println(bigTestString);
		}

}
