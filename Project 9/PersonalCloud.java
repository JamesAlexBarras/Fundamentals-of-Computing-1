/**
is a subclass of sharedcloud.


Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/
public class PersonalCloud extends SharedCloud {
/**
*comment for constant.
*/
   public static final double COST_FACTOR = 3.0;

/**
is the constructor of the class.

@param namee is the inputted name
@param storagee is the inputted storage
@param storedd is the stored amount
@param limitt is the limit amount
*/
   public PersonalCloud(String namee, double storagee, 
                        double storedd, double limitt) {
      super(namee, storagee, storedd, limitt);
   
   }

/**
returns the cost factor of the object.

@return double
*/
   public double getCostFactor() {
      return PersonalCloud.COST_FACTOR;
   }

/**
calculates monthly cost.

@return double
*/
   public double monthlyCost() {
      double thecost2 = (bStorageCost + this.dataOverage() 
                        * PersonalCloud.COST_FACTOR);
      return thecost2;
   }


}