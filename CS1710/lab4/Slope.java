import java.awt.geom.Point2D; 
import java.util.Scanner;

public class Slope 
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Input x coordinate of the first point: ");
      double xcoord = in.nextDouble();

      System.out.print("Input y coordinate of the first point: ");
      double ycoord = in.nextDouble();

      Point2D.Double p1 = new Point2D.Double(xcoord, ycoord);

      System.out.print("Input x coordinate of the second point: ");
      xcoord = in.nextDouble();

      System.out.print("Input y coordinate of the second point: ");
      ycoord = in.nextDouble();

      Point2D.Double p2 = new Point2D.Double(xcoord, ycoord);

      double slope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());        

      System.out.println("The slope of the line is " + slope);
   } 
}
