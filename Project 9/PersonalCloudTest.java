import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
    /**
Tests the PersonalCloud class.

  Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/

public class PersonalCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
     /**
   tests the getcostfactor method.
   
   */
   @Test public void getCostFactorTest() {
      PersonalCloud c1 = new PersonalCloud("c1", 10.0, 17.0, 18.0);
   
      Assert.assertEquals(3.0, c1.getCostFactor(), .001);
   }
   /**
   tests the monthly cost calculation.
   */
   @Test public void monthlycosttest() {
      PersonalCloud c2 = new PersonalCloud("c1", 10.0, 21.0, 20.0);
   
      Assert.assertEquals(13.0, c2.monthlyCost(), .001);
   }

}
