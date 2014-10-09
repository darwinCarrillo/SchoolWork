public class BankAccount implements Comparable<BankAccount>
{
	private double balance;
	
	public int compareTo(BankAccount other)
	{
		if (balance > other.getBalance())
			return 1;
		else if (balance < other.getBalance())
			return -1;
		else
			return 0;					
	}	

}
