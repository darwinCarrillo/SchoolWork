/**
 * The following class is used to convert an xml file into a binary
 * encoding
 * Author: Darwin Carrillo
 * Assignment #1
 */

import Course.Course;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLToBin 
{
    //Store all the courses extracted from the XML file
    private static ArrayList<Course> courses = new ArrayList<>();
    
    //Parse through the XML file to extract courses
    private static void parseElement(Element course)
    {                     
         //Resultant Course information
        String course_Subject = course.getAttribute("subject");
        String course_Number = course.getAttribute("number");
        Element course_Title_E = ((Element)course.getElementsByTagName("title").item(0));
        String course_Title = course_Title_E.getChildNodes().item(0).getNodeValue();
        Element course_Type_E = ((Element)course.getElementsByTagName("sched-type").item(0));
        String course_Type = course_Type_E.getChildNodes().item(0).getNodeValue();
        
        //Ignore course if it is not a lecture
        if(!course_Type.equals("L&L") 
                && !course_Type.equals("LEC"))
        {
            return;
        }
        Element meeting1_E = ((Element)course.getElementsByTagName("meeting1").item(0));
        String meetings = meeting1_E.getChildNodes().item(0).getNodeValue();
        Course toAdd = null;
        
        //Take into account lab time
        if(course_Type.equals("L&L"))
        {
            Element meeting2_E = ((Element)course.getElementsByTagName("meeting2").item(0));
            meetings += "#"+meeting2_E.getChildNodes().item(0).getNodeValue();  
        }

        toAdd = new Course(course_Subject,course_Number,course_Title,
                    course_Type, meetings);
        XMLToBin.courses.add(toAdd);
    }
    
    public static void main( String[] args ) throws IOException 
    {
        if( args.length != 1 ) 
        {
            System.out.println("usage: java ExtractField infile field");
            System.exit( 1 );
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse( new File(args[0]) );
            Element root = doc.getDocumentElement();
            NodeList elements = root.getElementsByTagName("course");
            for(int i = 0; i < elements.getLength();i++)
            {
                parseElement((Element)elements.item(i));
            }
        }
        catch( Exception ex ) 
        {
            System.out.println(ex.getMessage() );
        }
        
        DataOutputStream output_Stream = new DataOutputStream(new FileOutputStream("bin.out"));
        for(Course c: courses)
        {
            String s = c.toString();
            output_Stream.writeUTF(s);
        }
        output_Stream.close();
    }    
}
