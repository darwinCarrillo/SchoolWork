import java.awt.*;

public class Door
{
   private String state;     // Open or closed
   private String message;

   /**
      Constructor for objects of class Door.  Pass in "open" or "closed" to
      represent the state of the Door object. 
      @param aState the initial state of the Door object 
   */
   public Door(String aState)
   {
      // Initialize the state of the Door with one of two states: open, closed
      state = aState;
      message = "";
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
      An accessor method that gets the door's message variable.
   */
   public String getMessage()
   {
      return message;
   }

   /**
      Sets the state of the Door to open if the door is closed.
   */
   public void open()
   {
      if (state.equals("open"))
      {
         message = "The door is already open.";
      }
      else 
      {
         state = "open";
         message = "The door has been opened";
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
         message = "The door has been closed.";
      }
      else 
      {
         message = "The door is already closed.";
      }
   }

   public String toString()
   {
      return "The door is " + state + ".";
   }

   public void drawOpenDoor(Graphics page)
   {
      page.setColor(Color.black);
      page.fillRect(120, 120, 120, 225);
      page.setColor(Color.red);
      int[] x = {120, 150, 150, 120};
      int[] y = {120, 120, 320, 345};
      page.fillPolygon(x,y,4);
   } 
  
   public void drawClosedDoor(Graphics page)
   {
      page.setColor(Color.red);
      page.fillRect(120, 120, 120, 225);  
      page.setColor(Color.black);
      page.fillOval(210,240,10,10);
   }   
}
