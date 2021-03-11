import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
Reads files containing information, then uses the.
Ellipsoid and EllipsoidList classes to perform specific actions.
Then prints out the array list and summary info.

Project 05
 @author James Barras comp 1210 LLB 010
 @version February 12 2020
*/
public class EllipsoidListApp {
/**
is the main method for the EllipsoidListApp class.

@param args - is not used.
 *@throws FileNotFoundException required by Scanner for File
*/
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Ellipsoid> elliplistf = new ArrayList<Ellipsoid>();
      Scanner scanplz = new Scanner(System.in);
      
      //creates a scanner that reads from a file matching 
      //the user-entered String.
      System.out.print("Enter file name: ");
      String name = scanplz.nextLine();
      Scanner filescanner = new Scanner(new File(name));
      String ellipsoidlistname = filescanner.nextLine();
      
      
      while (filescanner.hasNext()) {
      
         String namelabel = filescanner.nextLine(); 
         String axis1 = filescanner.nextLine();
         String axis2 = filescanner.nextLine();
         String axis3 = filescanner.nextLine();
         
         Double axi1 = Double.parseDouble(axis1);
         Double axi2 = Double.parseDouble(axis2);
         Double axi3 = Double.parseDouble(axis3);
      
         Ellipsoid newE = new Ellipsoid(namelabel, axi1, axi2, axi3);
         elliplistf.add(newE);
      }
      filescanner.close();
      
      EllipsoidList finalist = new EllipsoidList(ellipsoidlistname, elliplistf);
   
      System.out.println("\n" + finalist.toString());
      System.out.println("\n" + finalist.summaryInfo());
   
   
   }
}