/**
this is a subclass of SharedCloud with a.
different cost factor



Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/
public class PublicCloud extends SharedCloud {
/**
*comment for constant.
*/
   public static final double COST_FACTOR = 2.0;

/**
is the constructor of the class.

@param namein3 is the inputted name
@param storage3 is the inputted storage cost
@param stored3 is the amount of data stored
@param limit3 is the data limit

*/
   public PublicCloud(String namein3, double storage3, 
            double stored3, double limit3) {
      super(namein3, storage3, stored3, limit3);
   
   }

/**
returns the cost factor of the object.

@return double
*/
   public double getCostFactor() {
      return PublicCloud.COST_FACTOR;
   }
   
   
   /**
   calculates the monthly cost.
   
   @return double
   */
   public double monthlyCost() {
      double thecost = (bStorageCost + this.dataOverage() 
               * PublicCloud.COST_FACTOR);
      return thecost;
   }




}