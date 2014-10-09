/*
 * This class is used to hold course information that has been parsed from 
 * an XML file.
 * Author: Darwin Carrillo
 * Assignment #2
 */
package E1;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Element;

public class Course {

    public String course_Subject = "";
    public String course_Number = "";
    public HashMap<String,String> course_Rooms = new HashMap<>();
    
    public Course(Element course_Element)
    {
        this.course_Subject = course_Element.getAttribute("subject");
        this.course_Number = course_Element.getAttribute("number");        
        this.initRooms(course_Element);
    }
    
    //Extract rooms from meetings
    public void initRooms(Element course_Element)
    {
        ArrayList<Element> elements = null;
        elements = XMLExtractE.eFromElement(course_Element, "meeting");
       
        // Check to see if course contains this element
        if(elements == null)
        {
            return;
        }
        
        //extract building and room number
        for(Element i : elements)
        {
            String building = i.getAttribute("building").trim();
            String room = i.getAttribute("room").trim();
            //ignore any meeting times without a room and/or building
            if(!building.equals("") && !room.equals(""))
            {
                course_Rooms.put(room,building);            
            }
        }     
    }  
    
    //Check if course meets in specified room
    public boolean hasRoom(String building, String room)
    {
        if(course_Rooms.get(room).equals(building))
        {
            return true;
        }
        return false;
    }
    
    //Check if course has meet times
    public boolean hasMeetings()
    {
        return !course_Rooms.isEmpty();
    }
}
