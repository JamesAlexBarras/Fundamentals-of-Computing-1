import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
Provides the methods for the EllipsoidListApp.

Project 06
 @author James Barras comp 1210 LLB 010
 @version February 19 2020
*/
public class EllipsoidList {
   private String ellipListname;
   private ArrayList<Ellipsoid> ellipList;

/**
Creates the Ellipsoid list from a string and an array.

@param ellipLiname is the name of the list
@param ellipListIn is the array.
*/
   public EllipsoidList(String ellipLiname, ArrayList<Ellipsoid> ellipListIn) {
      ellipListname = ellipLiname;
      ellipList = ellipListIn;
   
   }

/**
returns the name.

@return String
*/
   public String getName() {
      return ellipListname;
   }
   
  /**
  returns the number of ellipsoids as an int.
  
  @return int
  */
   public int numberOfEllipsoids() {
      int none = 0;
      if (ellipList.size() > none) {
         return ellipList.size();
      }
      else {
         return none;
      }
   }


/**
calculates and returns the total volume.

@return double
*/
   public double totalVolume() {
      int objects = 0;
      double total = 0.0;
      
      if (ellipList.size() == objects) {
         return total;
      }
      while (objects < ellipList.size()) {
         total += ellipList.get(objects).volume();
         objects++;
      }
      return total;
   }
   
 /**
 calculates and returns the total surface area.
 
 @return double
 */  
   public double totalSurfaceArea() {
      int objects = 0;
      double total = 0.0;
   
      if (ellipList.size() == objects) {
         return total;
      }
      while (objects < ellipList.size()) {
         total += ellipList.get(objects).surfaceArea();
         objects++;
      }
      return total;
   }

/**
calculates and returns average volume.

@return double
*/
   public double averageVolume() {
      int objects = 0;
      double total = 0.0;
      double average = 0.0;
   
      if (ellipList.size() == objects) {
         return total;
      }
      while (objects < ellipList.size()) {
         total += ellipList.get(objects).volume();
         objects++;
      }
      average = (total / ellipList.size());
      return average;
   }
   
  /**
  calculates and returns average surface area.
  
  @return double
  */
   public double averageSurfaceArea() {
      int objects = 0;
      double total = 0.0;
      double average = 0.0;
   
      if (ellipList.size() == objects) {
         return total;
      }
      while (objects < ellipList.size()) {
         total += ellipList.get(objects).surfaceArea();
         objects++;
      }
      average = (total / ellipList.size());
      return average;
   }
 
 /**
 converts the array into a string display.
 
 @return String
 */ 
   public String toString() {
      int objects = 0;
   
      String totalstring = ellipListname + "\n";
      while (objects < ellipList.size()) {
         totalstring += "\n" + ellipList.get(objects) + "\n";
         objects++;
      }
      return totalstring;
   }
   
  /**
  reuturns a summary of the array's information.
  
  @return String
  */ 
   public String summaryInfo() {
      DecimalFormat dfformat = new DecimalFormat("#,##0.0##");
      String summary = "";
      
      summary += "----- Summary for " + ellipListname + " -----"
         + "\nNumber of Ellipsoid Objects: " + numberOfEllipsoids()
         + "\nTotal Volume: " + dfformat.format(totalVolume()) + " cubic units"
         + "\nTotal Surface Area: " + dfformat.format(totalSurfaceArea()) 
         + " square units"
         + "\nAverage Volume: " + dfformat.format(averageVolume()) 
         + " cubic units"
         + "\nAverage Surface Area: " + dfformat.format(averageSurfaceArea()) 
         + " square units"
         + "\n";
   
      return summary;
   }
   
   
   ///////////////////////////////
   ///////////////////////////////
   
   /**
   gives array of the inputted list.
   
   @return ArrayList<Ellipsoid>
   */
   public ArrayList<Ellipsoid> getList() {
      return ellipList;
   }
   
   /**
   takes an inputted file name and searches for the file.
   then takes the information from the file and 
   creates a list.
   
   @return EllipsoidList
   @param filenamein is the file name given by the user
   @throws FileNotFoundException if the file cannot be opened.

   */
   public EllipsoidList readFile(String filenamein)
               throws FileNotFoundException {
     
      String listname = "";
      ArrayList<Ellipsoid> arrayfromfile = new ArrayList<Ellipsoid>();
      Scanner filescan = new Scanner(new File(filenamein));
      
      listname = filescan.nextLine();
      while (filescan.hasNext()) {
         String label = filescan.nextLine();
         Double axis1 = Double.parseDouble(filescan.nextLine());
         Double axis2 = Double.parseDouble(filescan.nextLine());
         Double axis3 = Double.parseDouble(filescan.nextLine()); 
      
         Ellipsoid newellip = new Ellipsoid(label, axis1, axis2, axis3);
         arrayfromfile.add(newellip);
      }
      EllipsoidList listfromfile = new EllipsoidList(listname, arrayfromfile);
      
      return listfromfile;
   }
   
   /**
  Takes inputs needed to create an ellipsoid.
  then adds that ellipsoid to the list.
  
  @param label is the inputted label
   @param a is the inputted a axis
   @param b is the inputted b axis
   @param c is the inputted c axis
   */
   public void addEllipsoid(String label, double a, double b, double c) {
      Ellipsoid ellipnew = new Ellipsoid(label, a, b, c);
      ellipList.add(ellipnew);
   }
  
  /**
  finds a label in an array based on the inputted label.
  
  @return Ellipsoid
  @param label1 is the inputted label
  */ 
   public Ellipsoid findEllipsoid(String label1) {
      for (Ellipsoid e: ellipList) {
         if (label1.compareToIgnoreCase(e.getLabel()) == 0) {
            return e;
         }
      }
      return null;
   }
   
   /**
   deletes an ellipsoid in an array based.
   on the inputted label.
  
  @param label3 is the inputted label
  @return Ellipsoid 
   */
   public Ellipsoid deleteEllipsoid(String label3) {
      Ellipsoid theone = null;
      if (findEllipsoid(label3) != null) {
         theone = findEllipsoid(label3);
         ellipList.remove(findEllipsoid(label3));
         return theone;
      }
      else {
         return theone;
      }
   }
   
   /**
   edits an ellipsoid of an inputted label.
   
   @return Ellipsoid
   @param label is the inputted label
   @param a is the inputted a axis
   @param b is the inputted b axis
   @param c is the inputted c axis
   */
   public Ellipsoid editEllipsoid(String label, double a, double b, double c) {
      Ellipsoid edited = null;
      if (findEllipsoid(label) != null) {
         edited = findEllipsoid(label);
         
         edited.setA(a);
         edited.setB(b);
         edited.setC(c);
         
         return edited;
      }
      else {
         return edited;
      }
   }
}