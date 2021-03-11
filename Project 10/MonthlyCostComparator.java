import java.util.Comparator;
/**
is a class that compares objects based on monthly cost.

Project 10
 @author James Barras comp 1210 LLB 010
 @version April 10 2020

*/
public class MonthlyCostComparator implements Comparator<CloudStorage> {
/**
is the compare method of the class.

@param c1 is an examined object
@param c2 is an examined object
@return int
*/
   public int compare(CloudStorage c1, CloudStorage c2) {
      if (c1.monthlyCost() > c2.monthlyCost()) {
         return -1;
      }
      else if (c1.monthlyCost() < c2.monthlyCost()) {
         return 1;
      }
      else {
         return 0;
      }
   }



}