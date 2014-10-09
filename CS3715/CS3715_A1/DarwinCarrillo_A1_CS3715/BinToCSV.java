/**
 * The following class is used to convert a binary file into a 
 * csv file
 * Author: Darwin Carrillo
 * Assignment #1
 */

import Course.Course;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BinToCSV {
    
    private static Course course;
    private static ArrayList<Course> allCourses = new ArrayList<>();
    
    public BinToCSV(Course course)
    {
        this.course = course;
    }
    
    public static void main( String[] args ) throws IOException 
    {
	DataInputStream ds=null;
        if( args.length != 1 ) 
        {
            System.out.println("usage: java ExtractField infile field");
            System.exit( 1 );
        }
      	try{
         ds= new DataInputStream(new FileInputStream(args[0]));
      	
		while(true){
        	System.out.println(ds.readUTF().replace(" ",","));
		System.out.flush();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
        finally
        {
            ds.close();
        }
   }
}
