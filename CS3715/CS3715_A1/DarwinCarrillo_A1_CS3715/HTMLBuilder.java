/* The following class is used to turn an array of courses
 * into a html file schedule.
 * Author: Darwin Carrillo
 * Assignment #1
 */

import Course.Course;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTMLBuilder {
    
    ArrayList<Course> results;
    
    public HTMLBuilder(ArrayList<Course> results, String file_Name)
    {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file_Name, "UTF-8");
            this.results = results;
            writer.println("<!DOCTYPE html>" 
            + "<title>Scheduling Table Example</title>"
            + "<style type='text/css'>"
            + "table {    border-collapse : collapse;    border : thin solid black;}"
            + "table td {    border : thin solid black;    padding : 4px;}"
            + "table th {    border : thin solid black;    padding : 4px;}"
            + "</style>");
            writer.println("<body>"
            +"<h1>Course Schedule for "
            +results.get(0).getBuilding()+"-"+results.get(0).getRoom()+"</h1>"
            +"<table>"
            +"<tr><th>Time</th> <th>Tuesday</th> <th>Thursday</th> </tr>");
            writer.println(buildTag("0900","1015", 2));
            writer.println(buildTag("1030","1145", 2));
            writer.println(buildTag("1145","1230", 2));
            writer.println(buildTag("1400","1515", 2));
            writer.println(buildTag("1530","1645", 2));
            writer.println("</table>");
            writer.println("<br>"
            +"<table>"
            +"<tr> <th>Time</th> <th>Monday</th> <th>Wedensday</th> <th>Friday</th> </tr>");
            writer.println(buildTag("0900","0950", 3));
            writer.println(buildTag("1000","1050", 3));
            writer.println(buildTag("1100","1150", 3));
            writer.println(buildTag("1200","1250", 3));
            writer.println(buildTag("1300","1350", 3));
            writer.println(buildTag("1400","1450", 3));
            writer.println(buildTag("1500","1550", 3));
            writer.println(buildTag("1600","1650", 3));
            writer.println("</table></body></html>");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HTMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HTMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }

    //The method is meant to search for a course in a specified time slot
    //and return a html line of code with the appropriate course details
    public String buildTag(String start_Time, String end_Time, int days)
    {     
        String built_Tag = "<tr><td>"+start_Time+"-"+end_Time+"</td>";
        Course result = null;
        
        for(Course i : this.results)
        {
            if(i.isTime(start_Time, end_Time))
            {                
                result = i;
            }
        }
        for(int x = 1; x <=days; x++)
        {
            if(result != null)
            {
                built_Tag += "<td>"+result.course_Title+"</td>";         
            }else
            {
            built_Tag = built_Tag+"<td>***</td>";
            }
        }
        built_Tag += "</tr>";
        return built_Tag;
    }   
}
