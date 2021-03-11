import java.text.DecimalFormat;
/**
this class is the highest parent class of the project.
it is abstract and provides several basic methods
that all other child classes will use.

Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020

*/
public abstract class CloudStorage implements Comparable<CloudStorage> {
   protected String name;
   protected double bStorageCost;

   protected static int count = 0;

/**
this is the constructor of the class.
to be called in other child classes

@param namein is the inputted name
@param bStorageCostin is the inputted cost

*/
   public CloudStorage(String namein, double bStorageCostin) {
      count++;
      name = namein;
      bStorageCost = bStorageCostin;
   }

/**
returns the name of the storage object.
@return String
*/
   public String getName() {
      return name;
   }

/**
sets the name of the object.
@param namein1 is the inputted name
*/
   public void setName(String namein1) {
      name = namein1;
   }

/**
returns the storage cost of the object.

@return double
*/
   public double getBaseStorageCost() {
      return bStorageCost;
   }
 
 /**
 sets the storage cost to an inputted amount.
 
 @param bstoragein is the inputted cost
 */  
   public void setBaseStorageCost(double bstoragein) {
      bStorageCost = bstoragein;
   }
   
   /**
   returns the active count amount.
   
   @return int
   */
   public static int getCount() {
      return count;
   }
   
   /**
   resets the count.
   */
   public static void resetCount() {
      count = 0;
   }
   
   /**
   returns the object as a string.
   
   @return String
   */
   public String toString() {
      DecimalFormat stringform = new DecimalFormat("#,##0.00");
      
      String complete = name + " (" + this.getClass()
         + ") " + "Monthly Cost: $" + stringform.format(monthlyCost())
         + "\nBase Storage Cost: $" + stringform.format(bStorageCost);
      return complete;
   }
   
   /**
   is an abstract method to be defined.
   in child classes
   @return double
   */
   public abstract double monthlyCost();
   
   
   /**
   compares two cloudstorage objects.
   
   @return int
   @param objin is the inputted object
   */
   public int compareTo(CloudStorage objin) {
      return name.toLowerCase().compareTo(objin.getName().toLowerCase());
   
   
   
   }
}
