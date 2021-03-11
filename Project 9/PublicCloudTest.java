import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

 /**
Tests the PublicCloud class.

  Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/
public class PublicCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /**
   tests the getcostfactor method.
   
   */
   @Test public void getCostFactorTest() {
      PublicCloud c1 = new PublicCloud("c1", 10.0, 17.0, 18.0);
   
      Assert.assertEquals(2.0, c1.getCostFactor(), .001);
   }
   /**
   tests the monthly cost calculation.
   */
   @Test public void monthlycosttest() {
      PublicCloud c2 = new PublicCloud("c1", 10.0, 21.0, 20.0);
   
      Assert.assertEquals(12.0, c2.monthlyCost(), .001);
   }
}
