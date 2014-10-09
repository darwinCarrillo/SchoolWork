public class Door
{
   private String state;     // Open or closed
   private int number;

   /**
      Constructor for objects of class Door.  Pass in "open" or "closed" to
      represent the state of the Door object. 
      @param aState the initial state of the Door object 
      @param aNumber the number of the Door object 
   */
   public Door(String aState, int aNumber)
   {
      // Initialize the state of the Door with one of two states: open, closed
      state = aState;
      number = aNumber;
   }
     
   /**
      A Boolean method that reports whether the state variable is "open".
      @return true if state equals "open"
   */
   public boolean isOpen()
   {
      return state.equals("open");
   }

   /**
      A Boolean method that reports whether the state variable is "closed".
      @return true if state equals "closed"
   */
   public boolean isClosed()
   {
       return state.equals("closed");
   }

   /**
      A mutator method that sets the state variable.
     @param newState  the new value for the state variable
   */
   public void setState(String newState)
   {
      state = newState;
   }

   /**
      An accessor method that gets the door's number.
      @return the value of "number" 
   */
   public int getNumber()
   {
      return number;
   }

   /**
      Sets the state of the Door to open if the door is closed.
   */
   public void open()
   {
      if (state.equals("open"))
      {
         System.out.println("The door is already open.");
      }
      else 
      {
         state = "open";
      }
   }

   /**
      Sets the state of the Door to closed if the door is open.
   */
   public void close()
   {
      if (state.equals("open"))
      {
         state = "closed";
      }
      else 
      {
         System.out.println("The door is already closed.");
      }
   }

   public String toString()
   {
      return "Door number " + number + " is " + state + ".";
   }
}
