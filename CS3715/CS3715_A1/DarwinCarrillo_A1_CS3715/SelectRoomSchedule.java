/* This class is used to generate a HTML containing a table that 
 * displays all the CS classes in a specified room.
 * Data is extracted from a csv file.
 * Author: Darwin Carrillo 
 * Assignment: #1
 */

import Course.Course;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectRoomSchedule 
{
    //hold course objects that meet the specified criteria
    public static ArrayList<Course> results = new ArrayList<>();

    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        String csv_file = "";
        String building_code = "";
        String room_number = "";       
        
        //Input the CSV file
        System.err.println("Please choose a CSV file to parse through. \n");
        csv_file = input.nextLine();
        
        //Input the Building Code
        System.err.println("Please choose a building code. \n");
        building_code = input.nextLine();
        
        //Input the Room Number
        System.err.println("Please choose a room number. \n");
        room_number = input.nextLine();
        
        try
        {
            //Get the CSV File
            File csv = new File(csv_file);
            Scanner file_Scanner = new Scanner(csv);
            
            //skip first line of csv file
            file_Scanner.nextLine();
            
            while(file_Scanner.hasNext())
            {
                parseLine(file_Scanner.nextLine(), building_code, room_number);                
            }            
            HTMLBuilder buildthis = new HTMLBuilder(results, args[0]);
        }
        catch(Exception e)
        { 
            e.printStackTrace();
        }
    }
    
    //Parses through line to extract time and room number etc
    public static void parseLine(String x, String building_code, String room_number)
    {         
         //Resultant Course information
        String course_Subject = x.split(",")[0];
        String course_Number = x.split(",")[1];
        String course_Title = x.split(",")[3];
        String course_Type = x.split(",")[4];
        
        //Ignore course if it is not a lecture
        if(!course_Type.equals("L&L") 
                && !course_Type.equals("LEC"))
        {
            return;
        }
        String meetings = x.split(",")[6];
        Course toAdd = null;

        toAdd = new Course(course_Subject,course_Number,course_Title,
                    course_Type, meetings);
        
        //Check if the course meets the specified criteria
        if(toAdd.testBuildingRoom(building_code+"#"+room_number))
        {        
            SelectRoomSchedule.results.add(toAdd);
        }
        else
        {
            toAdd = null;
        }
    }
}
