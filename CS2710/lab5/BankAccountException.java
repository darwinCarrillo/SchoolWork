/**
   This class reports a bank account exception (illegal operation).
*/
public class BankAccountException extends RuntimeException
{
   public BankAccountException() {}
   
   public BankAccountException(String message)
   {
      super(message);
   }
}
