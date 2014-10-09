/* This class is used to generate a HTML containing a table that 
 * displays all the CS classes in a specified room.
 * Data is extracted from an XML file.
 * Author: Darwin Carrillo 
 * Assignment: #1
 */

import Course.Course;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SelectRoomScheduleXML {
    
    //Hold course object that meet the specified criteria
    public static ArrayList<Course> results = new ArrayList<>();

    
    public static void main(String[] args)
    {    
        Scanner input = new Scanner(System.in);
        String csv_file = "cs_slot.xml";
        String building_code = "EN";
        String room_number = "1052";      
        
//        //Input the CSV file
//        System.err.println("Please choose a XML file to parse through. \n");
//        csv_file = input.nextLine();
//        
//        //Input the Building Code
//        System.err.println("Please choose a building code. \n");
//        building_code = input.nextLine();
//        
//        //Input the Room Number
//        System.err.println("Please choose a room number. \n");
//        room_number = input.nextLine();
        
        try 
        {
            DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =
            factory.newDocumentBuilder();

            Document doc = builder.parse( new File("cs_slot.xml") );
            Element root = doc.getDocumentElement();
            NodeList courses = root.getElementsByTagName("course");

            for(int i = 0; i < courses.getLength();i++)
            {
                parseElement((Element)courses.item(i), building_code, room_number);
            }
            HTMLBuilder buildthis = new HTMLBuilder(results, "eng1052-xml.html");
        }
        catch( Exception ex ) 
        {
            ex.printStackTrace();
        }
    }
    
    public static void parseElement(Element courses, String building_code, String room_number)
    {        
         //Resultant Course information
        String course_Subject = courses.getAttribute("subject");
        String course_Number = courses.getAttribute("number");
        Element course_Title_E = ((Element)courses.getElementsByTagName("title").item(0));
        String course_Title = course_Title_E.getChildNodes().item(0).getNodeValue();
        Element course_Type_E = ((Element)courses.getElementsByTagName("sched-type").item(0));
        String course_Type = course_Type_E.getChildNodes().item(0).getNodeValue();
        
        //Ignore course if it is not a lecture
        if(!course_Type.equals("L&L") 
                && !course_Type.equals("LEC"))
        {
            return;
        }
        Element meeting1_E = ((Element)courses.getElementsByTagName("meeting1").item(0));
        String meetings = meeting1_E.getChildNodes().item(0).getNodeValue();
        Course toAdd = null;
        
        toAdd = new Course(course_Subject,course_Number,course_Title,
                    course_Type, meetings);
        
        //Check if the course meets the specified criteria
        if(toAdd.testBuildingRoom(building_code+"#"+room_number))
        {        
            SelectRoomScheduleXML.results.add(toAdd);
        }
        else
        {
            toAdd = null;
        }
   }
}