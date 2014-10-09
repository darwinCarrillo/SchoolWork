import java.util.Scanner;

public class BankAccountDemo
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      System.out.print("Initial balance: ");
      double initialBalance = in.nextDouble();
      
      System.out.print("Amount to deposit: ");
      double amountToDeposit = in.nextDouble();

      System.out.print("Amount to withdraw: ");
      double amountToWithdraw = in.nextDouble();

      BankAccount account = new BankAccount(initialBalance);
      account.deposit(amountToDeposit);
      account.withdraw(amountToWithdraw);
      
      System.out.println("New balance: " + account.getBalance());
   }
}
