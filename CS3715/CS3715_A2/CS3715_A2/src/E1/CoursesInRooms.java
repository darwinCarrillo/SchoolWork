/*
 * This class is used to extract course information and present it 
 * in an organized manner.
 * Author: Darwin Carrillo
 * Assignment #2
 */

package E1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.w3c.dom.Element;

public class CoursesInRooms {

    public static void main(String[] args)
    {
        TreeMap<String, Building> buildings = new TreeMap<>();
        ArrayList<Course> courses = new ArrayList<>();
        
        //populate buildings tree set with data from buildings.xml file
        for(Element b : XMLExtractE.eFromFile("SRC_FILES/building.xml", "building"))
        {
            Building toAdd = new Building(b);
            buildings.put(toAdd.building_Code, toAdd);
        }
        
        //populate courses arraylist with data from the slot-book.xml file
        for(Element c : XMLExtractE.eFromFile("SRC_FILES/slot-book.xml", "course"))
        {
            Course toAdd = new Course(c);
            //Add rooms to building
            for(Map.Entry<String,String> p : toAdd.course_Rooms.entrySet())
            {
                buildings.get(p.getValue()).addRoom(p.getValue()+"-"+p.getKey());
            }
            //ignore courses with no meeting times
            if(toAdd.hasMeetings())
            {
                courses.add(toAdd);
            }
            toAdd = null;
        }
        
        //Match buildings to courses

        for(Map.Entry<String, Building> b : buildings.entrySet())
        {
            System.out.println(b.getKey()+":"+b.getValue().building_Name);
            for(String r : b.getValue().building_Rooms)
            {
                System.out.println(b.getKey()+":"+r);
                for(Course c : courses)
                {
                    if(c.hasRoom(b.getKey(), r))
                    {
                        System.out.print(c.course_Subject+"-"+c.course_Subject);
                    }
                }
                System.out.println();
            }
        }
    }
            
}
