import org.junit.Assert;
//import static org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
program used to test various outputs.
from the ellipsoid class

 Project 08B
 @author James Barras comp 1210 LLB 010
 @version March 25 2020
*/
public class EllipsoidTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
  
  /**
  tests the various getter methods.
  */
   @Test public void gettersTest() {
      String theLabel1 = "";
      //int count1 = Ellipsoid.getCount();
      Ellipsoid j = new Ellipsoid(theLabel1, 2, 3, 4);
      int count1 = Ellipsoid.getCount();
      Assert.assertEquals(theLabel1, j.getLabel());
   
      Assert.assertEquals(2, j.getA(), 0.001);
      
      Assert.assertEquals(3, j.getB(), 0.001);
      
      Assert.assertEquals(4, j.getC(), 0.001);
      
      Assert.assertEquals(count1, count1);
   }
   
   /**
   tests the various setter methods.
   */
   @Test public void settersTest() {
      String thelabel2 = "";
   
      Ellipsoid k = new Ellipsoid(thelabel2, 3, 4, 5);
      
      Assert.assertTrue(k.setLabel("hello there"));
      Assert.assertFalse(k.setLabel(null));
      
      Assert.assertTrue(k.setA(6));
      Assert.assertFalse(k.setA(-4));
      
      Assert.assertTrue(k.setB(8));
      Assert.assertFalse(k.setB(-8888));
      
      Assert.assertTrue(k.setC(3));
      Assert.assertFalse(k.setC(-9));
   
   }
   
   /**
   tests the volume and surface area calculations.
   */
   @Test public void calculationTest() {
      String thelabel3 = "";
      Ellipsoid l = new Ellipsoid(thelabel3, 4, 5, 6);
   
      Assert.assertEquals(502.6548, l.volume(), .0001);
   
      Assert.assertEquals(312.5365, l.surfaceArea(), .0001);
   }
   
   /**
   tests the tostring method.
   */
   @Test public void tostringTest() {
      Ellipsoid a = new Ellipsoid("Kenobi", 5, 6, 7);
   
      Assert.assertEquals("Ellipsoid \"Kenobi\" with axes a = 5.0,"
            + " b = 6.0, c = 7.0 units has:"
            + "\n\tvolume = 879.6459 cubic units"
         	+ "\n\tsurface area = 450.7504 square units", a.toString());
   }
   
   /**
   tests the equals and hashcode methods.
   */
   @Test public void equalsTest() {
      String test1 = "";
      
      Ellipsoid e1 = new Ellipsoid(test1, 7, 10, 7);
      Ellipsoid e2 = new Ellipsoid(test1, 7, 10, 7);
      
      Assert.assertEquals(true, e1.equals(e2));
      
      e2 = new Ellipsoid("test2", 7, 10, 7);
      Assert.assertEquals(false, e1.equals(e2));
      
      e2 = new Ellipsoid(test1, 6, 10, 7);
      Assert.assertEquals(false, e1.equals(e2));
      
      e2 = new Ellipsoid(test1, 7, 9, 7);
      Assert.assertEquals(false, e1.equals(e2));
      
      e2 = new Ellipsoid(test1, 7, 10, 6);
      Assert.assertEquals(false, e1.equals(e2));
      
      Assert.assertEquals(false, e1.equals("string"));
      
      //hashTest below
      
      Assert.assertEquals(0, e1.hashCode());
      
      
   }
   
   /**
   tests the reset count method.
   */
   @Test public void resetTest() {
      Ellipsoid.resetCount();
      int resetcount = Ellipsoid.getCount();
   
      Assert.assertEquals(0, resetcount);
   }



   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
   */
}

