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
public class CloudStorageTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void baseStorageandNameTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
   
      Assert.assertEquals("c1", c1.getName());
   
      Assert.assertEquals(10.0, c1.getBaseStorageCost(), 0.01);
      
      c1.setName("c2");
      Assert.assertEquals("c2", c1.getName());
      
      c1.setBaseStorageCost(11.0);
      Assert.assertEquals(11.0, c1.getBaseStorageCost(), 0.01);
   }
   
   @Test public void countTest() {
      DedicatedCloud c1 = new DedicatedCloud("c1", 10.0, 11.0);
      c1.resetCount();
      DedicatedCloud c2 = new DedicatedCloud("j", 1.0, 1.0);
      Assert.assertEquals(1, c2.getCount());
   
   }
  
}
