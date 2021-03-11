import java.text.DecimalFormat;
/**
is a child class of CloudStorage.
creates a sublclass that includes
server cost

Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/
public class DedicatedCloud extends CloudStorage {
   private double serverCost;

/**
is the constructor of the class.

@param namein is the inputted name
@param bstoragein is the inputted storage amount
@param serverin is the inputted server amount
*/
   public DedicatedCloud(String namein, double bstoragein, double serverin) {
      super(namein, bstoragein);
      serverCost = serverin;
   
   
   }

/**
returns the server cost.

@return double
*/
   public double getServerCost() {
      return serverCost;
   }
   
   /**
   sets the server cost from an input.
   
   @param serverin1 is the inputted server cost
   */
   public void setServerCost(double serverin1) {
      serverCost = serverin1;
   }

/**
calculates the monthly cost.

@return double
*/
   public double monthlyCost() {
      double finalcost = bStorageCost + serverCost;
      return finalcost;
   
   
   }
   
   /**
   converts the object to a string.
   
   @return String 
   */
   public String toString() {
      DecimalFormat stringform2 = new DecimalFormat("#,##0.00");
     
      String string1 = super.toString() + "\n"
         + "Server Cost: $" + stringform2.format(serverCost);
   
      return string1;
   
   }
}