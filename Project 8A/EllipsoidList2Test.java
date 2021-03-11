import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;
  /**
tests the ellipsoidlist2 program.

Project 08B
 @author James Barras comp 1210 LLB 010
 @version March 25th 2020
*/

public class EllipsoidList2Test {
   
   /**
   tests the getters in the ellipsoidlist2 class.
   */
   @Test public void gettersTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 3, 4);
      earray[2] = new Ellipsoid("e3", 3, 4, 5);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 3);
      //get name test
      Assert.assertEquals("elist", elist.getName());
      //number of ellipsoids test
      Assert.assertEquals(3, elist.numberOfEllipsoids(), 0.01);
      
      Ellipsoid[] emptyarray = new Ellipsoid[20];
      EllipsoidList2 emptylist = new EllipsoidList2("emptylist", emptyarray, 0);
      
      //num of ellipsoids when list is empty
      Assert.assertEquals(0, emptylist.numberOfEllipsoids(), 0.01);
      
      //getlist() test
      
      Assert.assertArrayEquals(earray, elist.getList());
   
   }
   
   /**
   tests the volume and surface area calculations.
   */
   @Test public void totalcalculationsTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 3, 4);
      earray[2] = new Ellipsoid("e3", 3, 4, 5);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 3);
      
      Ellipsoid[] emptyarray = new Ellipsoid[20];
      EllipsoidList2 emptylist = new EllipsoidList2("emptylist", emptyarray, 0);
      //total volume when list is empty
      Assert.assertEquals(0, emptylist.totalVolume(), .001);
      //total volume test
      Assert.assertEquals(376.9911184, elist.totalVolume(), .000001);
      
      //total surface area test
      Assert.assertEquals(359.9767706, elist.totalSurfaceArea(), .000001);
      //total surface area when list is empty
      Assert.assertEquals(0, emptylist.totalSurfaceArea(), 0.001);
   }
   
/**
tests the average volume and surface area calculations.
*/
   @Test public void averagecalculationsTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 3, 4);
      earray[2] = new Ellipsoid("e3", 3, 4, 5);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 3);
      
      Ellipsoid[] emptyarray = new Ellipsoid[20];
      EllipsoidList2 emptylist = new EllipsoidList2("emptylist", emptyarray, 0);
      
      //average volume and surface area when list is empty
      Assert.assertEquals(0, emptylist.averageVolume(), .001);
      Assert.assertEquals(0, emptylist.averageSurfaceArea(), .001);
      
      //average volume and surface area test
      Assert.assertEquals(125.6637061, elist.averageVolume(), .000001);
      Assert.assertEquals(119.9922569, elist.averageSurfaceArea(), .000001);
      
   }
  
  /**
  tests the tostring method.
  */ 
   @Test public void toStringTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 4, 4);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 2);
   
      Assert.assertEquals("elist" + "\n" 
            + "\nEllipsoid \"e1\" with axes a = 1.0,"
            + " b = 2.0, c = 3.0 units has:"
            + "\n\tvolume = 25.1327 cubic units"
         	+ "\n\tsurface area = 48.9366 square units"
            + "\n"
            + "\nEllipsoid \"e2\" with axes a = 2.0,"
            + " b = 4.0, c = 4.0 units has:"
            + "\n\tvolume = 134.0413 cubic units"
            + "\n\tsurface area = 138.8853 square units\n", elist.toString());
   
   }
  
  /**
  tests the summaryinfo method.
  */ 
   @Test public void summaryinfoTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 4, 4);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 2);
   
      Assert.assertEquals("----- Summary for elist -----"
         + "\nNumber of Ellipsoid Objects: 2"
         + "\nTotal Volume: 159.174 cubic units"
         + "\nTotal Surface Area: 187.822 square units"
         + "\nAverage Volume: 79.587 cubic units"
         + "\nAverage Surface Area: 93.911 square units\n", 
         elist.summaryInfo());
   }

/**
tests the readfile method.
@throws IOException for reading a file
*/
   @Test public void readFileTest() throws IOException {
   
      Ellipsoid[] eArray = new Ellipsoid[20];
      eArray[0] = new Ellipsoid("e1", 3, 4, 5);
      eArray[1] = new Ellipsoid("e2", 3, 5, 5);
      eArray[2] = new Ellipsoid("e3", 3, 3, 3);
      
      EllipsoidList2 eList = new EllipsoidList2("Test List", null, 0);
      eList = eList.readFile("Ellipsoid_data_1.txt");
      
      Assert.assertEquals("readFile Test",
                           "Ellipsoid Test List", 
                           eList.getName());
   }
   
   /**
   tests the add ellipsoid method.
   */
   @Test public void addellipsoidTest() {
   
      Ellipsoid[] eArray = new Ellipsoid[20];
      eArray[0] = new Ellipsoid("e1", 1, 2, 3);
      eArray[1] = new Ellipsoid("e2", 2, 3, 4);
      
      EllipsoidList2 eList = new EllipsoidList2("elist", eArray, 2);
      
      Ellipsoid e = new Ellipsoid("e3", 7, 7, 7);
      eList.addEllipsoid("e3", 7, 7, 7);
      Ellipsoid[] eA = eList.getList();
         
      Assert.assertEquals(e, eA[2]);
   }
   
   /**
   tests the find ellipsoid method.
   */
   @Test public void findEllipsoidTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 4, 4);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 2);
   
   //if null
      Assert.assertEquals(null, elist.findEllipsoid("e3"));
   
   //if found
      Assert.assertEquals(earray[0], elist.findEllipsoid("e1"));
   }
   
   /**
   tests teh delete ellipsoid method.
   */
   @Test public void deleteellipsoidtest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 4, 4);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 2);
      //if there is not one at that index
      Assert.assertEquals(null, earray[4]);
      
   //if found
      elist.deleteEllipsoid("e2");
      Assert.assertEquals(elist.findEllipsoid("e1"), earray[0]);
      Assert.assertEquals(null, earray[1]);
   }
   
   /**
   tests the edit ellipsoid method.
   */
   @Test public void editEllipsoidTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 4, 4);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 2);
      //if none are found with the specific label
      Assert.assertEquals(null, elist.editEllipsoid("e5", 1, 1, 1));
      
      //if found successfully
      Ellipsoid e = new Ellipsoid("e2", 5, 5, 5);
      elist.editEllipsoid("e2", 5, 5, 5);
      Assert.assertEquals(e, earray[1]);
      
   }
   
   /**
   tests the methods that find the smallest/largest.
   volume/surface area.
   */
   @Test public void surfaceareAndVolumeOutliersTest() {
      Ellipsoid[] earray = new Ellipsoid[20];
      earray[0] = new Ellipsoid("e1", 1, 2, 3);
      earray[1] = new Ellipsoid("e2", 2, 4, 4);
      earray[2] = new Ellipsoid("e3", 1, 1, 1);
   
      EllipsoidList2 elist = new EllipsoidList2("elist", earray, 3);
   
      Ellipsoid[] emptyarray = new Ellipsoid[0];
      EllipsoidList2 emptylist = new EllipsoidList2("emptylist", emptyarray, 0);
      
      //if the list is empty in all 4 calculations
      Assert.assertEquals(null, 
         emptylist.findEllipsoidWithSmallestVolume());
      Assert.assertEquals(null, 
         emptylist.findEllipsoidWithLargestVolume());
      Assert.assertEquals(null, 
         emptylist.findEllipsoidWithSmallestSurfaceArea());
      Assert.assertEquals(null, 
         emptylist.findEllipsoidWithLargestSurfaceArea());
      
      //if the list has objects in it
      Assert.assertEquals(earray[2], 
         elist.findEllipsoidWithSmallestVolume());
      Assert.assertEquals(earray[2], 
         elist.findEllipsoidWithSmallestSurfaceArea());
      Assert.assertEquals(earray[1], 
         elist.findEllipsoidWithLargestVolume());
      Assert.assertEquals(earray[1],
          elist.findEllipsoidWithLargestSurfaceArea());
   
   }
   
   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
   */
}
