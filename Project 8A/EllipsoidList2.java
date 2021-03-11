import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
Provides the methods for the EllipsoidListApp.

Project 08B
 @author James Barras comp 1210 LLB 010
 @version March 25th 2020
*/
public class EllipsoidList2 {
   private String ellipListname;
   private int listsize;
   private Ellipsoid[] ellipsoidList;
   //private ArrayList<Ellipsoid> ellipList;

/**
Creates the Ellipsoid list from a string and an array.

@param ellipLiname is the name of the list
@param ellipListIn is the array.
@param listsizeIn is the inputted listsize
*/
   public EllipsoidList2(String ellipLiname, Ellipsoid[] ellipListIn, 
         int listsizeIn) {
      ellipListname = ellipLiname;
      listsize = listsizeIn;
      ellipsoidList = ellipListIn;
      //ellipList = ellipListIn;
   
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
      if (listsize > none) {
         return listsize;
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
      
      if (listsize == objects) {
         return total;
      }
      while (objects < listsize) {
         total += ellipsoidList[objects].volume();
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
   
      if (listsize == objects) {
         return total;
      }
      while (objects < listsize) {
         total += ellipsoidList[objects].surfaceArea();
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
   
      if (listsize == objects) {
         return total;
      }
      while (objects < listsize) {
         total += ellipsoidList[objects].volume();
         objects++;
      }
      average = (total / listsize);
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
   
      if (listsize == objects) {
         return total;
      }
      while (objects < listsize) {
         total += ellipsoidList[objects].surfaceArea();
         objects++;
      }
      average = (total / listsize);
      return average;
   }
 
 /**
 converts the array into a string display.
 
 @return String
 */ 
   public String toString() {
      int objects = 0;
   
      String totalstring = ellipListname + "\n";
      while (objects < listsize) {
         totalstring += "\n" + ellipsoidList[objects] + "\n";
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
   public Ellipsoid[] getList() {
      return ellipsoidList;
   }
   
   /**
   takes an inputted file name and searches for the file.
   then takes the information from the file and 
   creates a list.
   
   @return EllipsoidList
   @param filenamein is the file name given by the user
   @throws FileNotFoundException if the file cannot be opened.

   */
   public EllipsoidList2 readFile(String filenamein)
               throws FileNotFoundException {
     
      String listname = "";
      Ellipsoid[] arrayfromfile = new Ellipsoid[100];
      Scanner filescan = new Scanner(new File(filenamein));
      int numofEllipsoids = 0;
      
      listname = filescan.nextLine();
      while (filescan.hasNext()) {
         
         String label = filescan.nextLine();
         Double axis1 = Double.parseDouble(filescan.nextLine());
         Double axis2 = Double.parseDouble(filescan.nextLine());
         Double axis3 = Double.parseDouble(filescan.nextLine()); 
      
      
         Ellipsoid newellip = new Ellipsoid(label, axis1, axis2, axis3);
         arrayfromfile[numofEllipsoids] = newellip;
         numofEllipsoids++;
      }
      EllipsoidList2 listfromfile = new EllipsoidList2(listname, arrayfromfile, 
            numofEllipsoids);
      
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
      ellipsoidList[listsize] = ellipnew;
      listsize++;
   }
  
  /**
  finds a label in an array based on the inputted label.
  
  @return Ellipsoid
  @param label1 is the inputted label
  */ 
   public Ellipsoid findEllipsoid(String label1) {
      Ellipsoid e = null;
      
      for (int i = 0; i < listsize; i++) {
         if (label1.compareToIgnoreCase(ellipsoidList[i].getLabel()) == 0) {
            e = ellipsoidList[i];
            break;
         }
      }
      return e;
   }
   
   /**
   deletes an ellipsoid in an array based.
   on the inputted label.
  
  @param label3 is the inputted label
  @return Ellipsoid 
   */
   public Ellipsoid deleteEllipsoid(String label3) {
      Ellipsoid theone = null;
      
      for (int i = 0; i < listsize; i++) {
         
         if (ellipsoidList[i].getLabel().compareToIgnoreCase(label3) == 0) {
            theone = ellipsoidList[i];
            
            for (int j = i; j < listsize - 1; j++) {
               ellipsoidList[j] = ellipsoidList[j + 1];
            }
            ellipsoidList[listsize - 1] = null;
            listsize--;
          
            return theone;
         }
      }
      return theone;
      /**
      if (findEllipsoid(label3) != null) { 
         theone = findEllipsoid(label3);
         
         ellipList.remove(findEllipsoid(label3));
         return theone;
      }
      else {
         return theone;
      }
      */
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
   
   /**
   finds the ellipsoid in the list with the.
   smallest volume
   
   @return Ellipsoid
   */
   public Ellipsoid findEllipsoidWithSmallestVolume() {
      int index = 0;
      int smallestindex = 0;
      
      if (listsize == 0) {
         return null;
      }
      while (index < listsize) {
         if (ellipsoidList[smallestindex].volume() 
               > ellipsoidList[index].volume()) {
            smallestindex = index;
         }
         index++;
      }
      return ellipsoidList[smallestindex];
   }
   
   /**
   finds ellipsoid in the list with the.
   largest volume
   
   @return Ellipsoid
   */
   public Ellipsoid findEllipsoidWithLargestVolume() {
      int index = 0;
      int largestindex = 0;
   
      if (listsize == 0) {
         return null;
      }
      while (index < listsize) {
         if (ellipsoidList[largestindex].volume() 
               < ellipsoidList[index].volume()) {
            largestindex = index;
         }
         index++;
      }
      return ellipsoidList[largestindex];
   }
   
   /**
   finds the ellipsoid in the list with the.
   smallest surface area
   
   @return Ellipsoid
   */
   public Ellipsoid findEllipsoidWithSmallestSurfaceArea() {
      int index = 0;
      int smallestindex = 0;
   
      if (listsize == 0) {
         return null;
      }
      while (index < listsize) {
         if (ellipsoidList[smallestindex].surfaceArea() 
               > ellipsoidList[index].surfaceArea()) {
            smallestindex = index;
         }
         index++;
      }
      return ellipsoidList[smallestindex];
   }
   
   /**
   returns the ellipsoid in the list with the.
   largest surface area
   
   @return Ellipsoid
   */
   public Ellipsoid findEllipsoidWithLargestSurfaceArea() {
      int index = 0;
      int largestindex = 0;
   
      if (listsize == 0) {
         return null;
      }
      while (index < listsize) {
         if (ellipsoidList[largestindex].surfaceArea() 
               < ellipsoidList[index].surfaceArea()) {
            largestindex = index;
         }
         index++;
      }
      return ellipsoidList[largestindex];
   }
}