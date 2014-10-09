package Course;

/* The following class is meant to hold the information on a course
 * such as time, room etc
 * Author: Darwin Carrillo
 * Assignment #1 
 */

import java.util.ArrayList;

public class Course 
{
    public String course_Subject = "";
    public String course_Number = "";
    public String course_Title = "";
    public String course_Type = "";
    public ArrayList<CourseTimeSlot> times = new ArrayList<>();

    public Course(String course_Subject, String course_Number,
            String course_Title, String course_Type, String meetings)
    {
        this.course_Subject = course_Subject;
        this.course_Number = course_Number;
        this.course_Title = course_Title;
        this.course_Type = course_Type;
        
        String meeting1 = meetings.split("#")[0];
        parseMeeting(meeting1);
        
        if(course_Type.equalsIgnoreCase("L&L"))
        {
            String meeting2 = meetings.split("#")[1];
            parseMeeting(meeting2);
        }
    }
    
    private void parseMeeting(String meeting)
    {
        //Extract building and room number for 1st meeting time and the second
        //if it exists
        String[] meeting_Array = meeting.split(" ");
        String building = meeting_Array[meeting_Array.length - 2];
        String room = meeting_Array[meeting_Array.length - 1];
        String start_Time = "";
        String end_Time = "";
        String days = "";

        //Get start and end time
        end_Time = meeting_Array[meeting_Array.length - 3];
        start_Time = meeting_Array[meeting_Array.length - 4];
        
        //extract the meeting days from the line
        for(int i = meeting_Array.length-4 ; i >=0; i--)
        {
            if(meeting_Array[i].matches("[A-Z]"))
            {
                days += meeting_Array[i]+"#";
            }
        }
        times.add(new CourseTimeSlot(start_Time,end_Time,building,room,days));
    }
    
    //check to see if this course matches the building and room querry
    public boolean testBuildingRoom(String building_Room)
    {
        //check first time slot
        if(times.get(0).buildingRoom(building_Room))
        {
            return true;
        }
        //check second time slot if it exists
        else if(course_Type.equals("L&L"))
        {
            if(times.get(1).buildingRoom(building_Room))
            {
                //make second time slot primary 
                CourseTimeSlot a = times.get(1);
                CourseTimeSlot b = times.get(0);
                times.clear();
                times.add(a);
                times.add(b);
                return true;
            }
        }
        return false;
    }
    
    public String getBuilding(){return times.get(0).building;}
    public String getRoom(){return times.get(0).room;}
    public String getStartTime(){return times.get(0).start_Time;}
    public String getEndTime(){return times.get(0).end_Time;}
    public String[] getDays(){return times.get(0).getDays();}
    
    // test if the course matches the specified start and end time
    public boolean isTime(String start_Time, String end_Time)
    {
        if(this.getStartTime().equalsIgnoreCase(start_Time) 
                && this.getEndTime().equalsIgnoreCase(end_Time))
        {
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        String toReturn = "";
        toReturn = course_Subject+" "+course_Number+" "+course_Title+" ";
        toReturn += times.get(0).toString();
        if(times.size() > 1)
        {
            toReturn += times.get(1).toString();
        }    
        return toReturn;
    }
}
