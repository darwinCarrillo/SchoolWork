public class CallingCard extends Card
{

	private String cardNumber;
	private int pin;

	public CallingCard(String n,String cardNumber, int pin)
	{
		super(n);
		this.cardNumber = cardNumber;
		this.pin = pin;	
	}

	public String format()
	{
		return super.format() + ", Card number: " + cardNumber + ", Pin: " + pin;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}	
	
	public String toString()
	{
	return "CallingCard[name=" + getName() + "][number=" + cardNumber + ",pin=" + pin + "]";
	}

public boolean equals(Object otherObject)
{
  if (getClass() == otherObject.getClass())
  {
    CallingCard other = (CallingCard) otherObject;
    return getName().equals(other.getName()) &&
           cardNumber.equals(other.cardNumber) && pin == other.pin;
  }

  return false;
}


}
