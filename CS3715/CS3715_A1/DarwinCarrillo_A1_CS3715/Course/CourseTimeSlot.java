package Course;

/** 
 * This Class is used to store the time slots of a class
 * Author: Darwin Carrillo
 * A1_CS3715
 */

public class CourseTimeSlot {
    public  String start_Time;
    public  String end_Time;
    public  String building;
    public  String room;
    public  String days;

    public CourseTimeSlot(String start_Time, String end_Time,
            String building, String room, String days)
    {
        this.start_Time = start_Time;
        this.end_Time = end_Time;
        this.building = building;
        this.room = room;
        this.days = days;
    }   
    
    public String[] getDays()
    {
        return days.split("#");
    }
    //return days in the form of a string
    public String daysToString()
    {
        String toReturn = "";
        for(String i: days.split("#"))
        {
            toReturn += i+" ";
        }
        return toReturn;
    }
    public boolean buildingRoom(String buildingRoom)
    {
        if(this.building.equalsIgnoreCase(buildingRoom.split("#")[0])
                && this.room.equalsIgnoreCase(buildingRoom.split("#")[1]))
        {
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        return start_Time+" "+end_Time+" "+building+" "+room+" "+daysToString();
    }
}
