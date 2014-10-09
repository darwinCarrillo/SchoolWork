/*
 * This class is used to hold building information that has been parsed from
 * an XML file.
 * Author: Darwin Carrillo
 * Assignment #2
 */
package E1;

import java.util.TreeSet;
import org.w3c.dom.Element;

public class Building implements Comparable<Building>{
    
    public String building_Code = "";
    public String building_Name = "";
    public TreeSet<String> building_Rooms = new TreeSet<>();
    
    public Building(Element building)
    {
        this.building_Code = building.getAttribute("code");
        this.building_Name = building.getNodeValue();
        System.err.println(building.getNodeValue());
    }
    
    @Override
    public int compareTo(Building t) 
    {
        return building_Name.compareTo(t.building_Name);
    }
    
    public void addRoom(String room)
    {
        building_Rooms.add(room);
    }
}
