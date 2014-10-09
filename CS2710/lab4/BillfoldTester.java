public class BillfoldTester
{
	public static void main(String [] args)
	{
	
		DriverLicense d = new DriverLicense("John Doe", "08-097654", 2007);
		CallingCard c = new CallingCard("Omega Card", "301233985945", 1030);
      
      		Billfold b = new Billfold();
      
      		b.addCard(d);
      		b.addCard(c);
      
      		System.out.println(b.formatCards());
      		System.out.println("Expected: [Name: John Doe, ID: 08-097654, "
         		+ "Expiration year: 2007 " + "| Name: Omega Card, "
         		+ "Card number: 301233985945, Pin: 1030]");

      		System.out.println(b.formatCards());
      		System.out.println("Number of expired cards: " + b.getExpiredCardCount());
      		System.out.println("Expected: 1"); 
   	}
}
