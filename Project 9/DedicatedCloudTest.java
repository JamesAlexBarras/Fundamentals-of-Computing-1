import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
Tests the DedicatedCloud class.

  Project 09
 @author James Barras comp 1210 LLB 010
 @version April 1st 2020
*/
public class DedicatedCloudTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

/**
tests the server cost setter and getter method.
*/
   @Test public void servercostTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
   
      Assert.assertEquals(11.0, c1.getServerCost(), .0001);
   
      c1.setServerCost(12.0);
      Assert.assertEquals(12.0, c1.getServerCost(), .001);
   }
   
   /**
   tests the monthly cost calculation.
   */
   @Test public void monthlycostTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
   
      Assert.assertEquals(21.0, c1.monthlyCost(), .001);
   
   }
   
   /**
   tests the toString method.
   */
   @Test public void toStringTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
   
      String c1string = c1.toString();
      Assert.assertEquals(c1string, c1.toString());
   
   
   }
   
   /**
   tests the base storage amount getter.
   and setter as well as the getter and
   setter for the name methods.
   */
   @Test public void baseStorageandNameTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
   
      Assert.assertEquals("c1", c1.getName());
   
      Assert.assertEquals(10.0, c1.getBaseStorageCost(), 0.01);
      
      c1.setName("c2");
      Assert.assertEquals("c2", c1.getName());
      
      c1.setBaseStorageCost(11.0);
      Assert.assertEquals(11.0, c1.getBaseStorageCost(), 0.01);
   }
   /**
   tests the get count and reset count methods.
   */
   @Test public void countTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
      c1.resetCount();
      DedicatedCloud c2 = new DedicatedCloud("j", 1.0, 1.0);
      Assert.assertEquals(1, c2.getCount());
   
   }
   
   
}
   
