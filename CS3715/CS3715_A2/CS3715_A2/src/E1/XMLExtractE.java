/*
 * This class is used to return a list of elements after given a specific 
 * file and element name.Returns null if no element of such a name is found.
 * Author: Darwin Carrillo
 * Assignment #2
 */

package E1;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLExtractE {          
    
    public static ArrayList<Element> eFromFile(String t_P, String e_N)
    {
        ArrayList<Element> elements_List= new ArrayList<>();    
        File to_Parse = new File(t_P);
        String element_Name = e_N;
        
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(to_Parse);
            Element root = doc.getDocumentElement();            
            elements_List = XMLExtractE.eFromElement(root, element_Name);
        }
        catch( Exception ex ) 
        {
            System.out.println("File is not valid.");
        }
        return elements_List;
    }
    
    public static ArrayList<Element> eFromElement(Element root, String element_Name)
    {
        ArrayList<Element> elements_List= new ArrayList<>();    
        //Get elements using specified element name
        NodeList elements = root.getElementsByTagName(element_Name);
        
        if(elements.getLength() == 0)
        {
            return null;
        }
        
        for(int i = 0; i < elements.getLength();i++)
        {
            elements_List.add((Element)elements.item(i));
        }
        return elements_List;
    }
}
