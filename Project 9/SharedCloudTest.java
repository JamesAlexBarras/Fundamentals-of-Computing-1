import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
Tests the SharedCloud class.

  Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/
public class SharedCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

/**
tests the getDataStored(), setDataStored(), and.
getDataLimit() methods.
*/
   @Test public void dataStoredandLimitTest() {
      SharedCloud c2 = new SharedCloud("c2", 10.0, 18.0, 20.0);
   
      Assert.assertEquals(18.0, c2.getDataStored(), .001);
   
      c2.setDataStored(19.0);
      Assert.assertEquals(19.0, c2.getDataStored(), .001);
   
   
      Assert.assertEquals(20.0, c2.getDataLimit(), .001);
      
      SharedCloud c20 = new SharedCloud("c20", 10.0, 19.0, 20.0);
      c20.setDataLimit(21.0);
      Assert.assertEquals(21.0, c20.getDataLimit(), 0.001);
      
      
   }
   
   /**
   tests the get cost factore method.
   */
   @Test public void costfactorTest() {
      SharedCloud c3 = new SharedCloud("c3", 10.0, 18.0, 20.0);
   
      Assert.assertEquals(1.0, c3.getCostFactor(), .001);
   }
   
   /**
   tests the data overage calculation.
   */
   @Test public void dataOverageTest() {
      SharedCloud c4 = new SharedCloud("c4", 10.0, 18.0, 20.0);
      SharedCloud c5 = new SharedCloud("c5", 10.0, 21.0, 20.0);
   
      Assert.assertEquals(1.0, c5.dataOverage(), .001);
   
      Assert.assertEquals(0.0, c4.dataOverage(), .001);
   
   }
   
   /**
   tests the monthly cost calculation.
   */
   @Test public void monthlyCostTest() {
      SharedCloud c6 = new SharedCloud("c6", 10.0, 21.0, 20.0);
   
      Assert.assertEquals(11.0, c6.monthlyCost(), .001);
   }
   
   /**
   tests the tostring method.
   */
   @Test public void toStringTest() {
      SharedCloud c7 = new SharedCloud("c7", 10.0, 18.0, 20.0);
      String c7string = c7.toString();
   
      Assert.assertEquals(c7string, c7.toString());
   
   }
}
