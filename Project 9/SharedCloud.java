import java.text.DecimalFormat;
/**
is a child class of class CloudStorage.
adds new methods and variables.

Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020


*/
public class SharedCloud extends CloudStorage {
   protected double dataStored;
   protected double dataLimit;

/**
*comment for constant.
*/
   public static final double COST_FACTOR = 1.0;

/**
is the constructor of the class.

@param namein2 is the inputted name
@param bstoragein2 is the inputted storage cost
@param limitin is the inputted data limit
@param storedin is the inputted stored amount

*/
   public SharedCloud(String namein2, double bstoragein2, 
                     double storedin, double limitin) {
      super(namein2, bstoragein2);
      dataLimit = limitin;
      dataStored = storedin;
   
   }

/**
returns data stored.

@return double

*/
   public double getDataStored() {
      return dataStored;
   }
  
  /**
  sets the data stored.
  
  @param storedin1 is the inputted stored amount
  */ 
   public void setDataStored(double storedin1) {
      dataStored = storedin1;
   }

/**
sets the data limit to user input.

@param limitin2 is the inputted limit.

*/
   public void setDataLimit(double limitin2) {
      dataLimit = limitin2;
   
   }
/**
returns the data limit.

@return double

*/
   public double getDataLimit() {
      return dataLimit;
   }

/**
returns the cost factor.

@return double
*/
   public double getCostFactor() {
      return SharedCloud.COST_FACTOR;
   }
   
   /**
   calculates the data overage.
   
   @return double
   */
   public double dataOverage() {
      double overage = 0.0;
   
      if (dataStored - dataLimit < 0) {
         return overage;
      }
      overage = dataStored - dataLimit;
      return overage;
   }
   
   /**
   calculates monthly cost.
   
   @return double
   */
   public double monthlyCost() {
      double finalcost1 = (bStorageCost 
               + this.dataOverage() * SharedCloud.COST_FACTOR);
      return finalcost1;
   
   }
   
   /**
   turns the object into a string.
   
   @return String
   */
   public String toString() {
      DecimalFormat stringform1 = new DecimalFormat("#,##0.000");
      
      String tostring1 = super.toString()
         + "\nData Stored: " + stringform1.format(dataStored) + " GB"
         + "\nData Limit: " + stringform1.format(dataLimit) + " GB"
         + "\nOverage: " + stringform1.format(this.dataOverage()) + " GB"
         + "\nCost Factor: " + this.getCostFactor();
         
      return tostring1;
   }
}