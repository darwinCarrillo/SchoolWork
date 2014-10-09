public class Door{

	private String doorName;
	private String state;

	public Door(String doorName, String state){	
		this.doorName = doorName;
		this.state = state;		
	}

	public void openDoor(){
		state = "Open";	
	}

	public void closeDoor(){
		state = "Close";
	}

	public String getDoorName(){
		return doorName;
	}
	public String getState(){
		return state;
	}

	public void setDoorName(String newDoorName){
		this.doorName = newDoorName;
	}
	public void setState(String newState){
		this.state =  newState;
	}
}

