public class DoorTester{

	public static void main(String [] args){
	
      		Door frontDoor = new Door("Front", "open");
      		System.out.println("The front door is " + frontDoor.getState());
      		System.out.println("Expected:  open");

      		Door backDoor = new Door("Back", "closed");
      		System.out.println("The back door is " + backDoor.getState());
      		System.out.println("Expected:  closed");        
      		backDoor.setState("open");
		System.out.println("The back door is " + backDoor.getState());
		System.out.println("Expected:  open");
		
		backDoor.setDoorName("Room1");
		System.out.println("The name of the backDoor object is " + backDoor.getDoorName());
		System.out.println("Expected: Room1");

		Door sideDoor = new Door("Side" , "closed");
		System.out.println("The sideDoor name is " + sideDoor.getDoorName());
		System.out.println("Expected: " + sideDoor.getDoorName());
		System.out.println("The sideDoor is " + sideDoor.getState());
		System.out.println("Expected: closed");		
	}

}

