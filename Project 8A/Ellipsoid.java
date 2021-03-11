import java.text.DecimalFormat;
/**
 Program has various "getter" and "setter" methods that
 can be used for any object in class Ellipsoid.
 
 Project 08B
 @author James Barras comp 1210 LLB 010
 @version March 25 2020
*/
public class Ellipsoid {
   private String label = "";
   private double a = 0.0;
   private double b = 0.0;
   private double c = 0.0;
   private static int count = 0;
/**
Constructs an object in class Ellipsoid.

@param labelIn to determine label
@param aIn to determine a axis
@param bIn to determine b axis
@param cIn to determine c axis
*/
   public Ellipsoid(String labelIn, double aIn, double bIn, double cIn) {
      setLabel(labelIn);
      setA(aIn);
      setB(bIn);
      setC(cIn);
      count++;
   }

/**
Is a getter method for the label.

@return String
*/
   public String getLabel() {
      return label;
   }
   
  /**
  Is a setter method for the label.
  
  @return boolean
  @param labelin to determine whether null or not.
  */ 
   public boolean setLabel(String labelin) {
      if (labelin != null) {
         label = labelin.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
  /**
  Is a getter method for axis a.
  
  @return double
  */ 
   public double getA() {
      return a;
   }
  
  /**
  Is a setter method for the a axis.
  
  @return boolean
  @param ain to determine whether positive or not.
  */ 
   public boolean setA(double ain) {
      if (ain > 0) {
         a = ain;
         return true;
      }
      else {
         return false;
      }
   }
   
  /**
  Is a getter method for axis b.
  
  @return double
  */ 
   public double getB() {
      return b;
   }
   
  /**
  Is a setter method for axis b.
  
  @return boolean
  @param bin to determine wheter positive or not.
  */ 
   public boolean setB(double bin) {
      if (bin > 0) {
         b = bin;
         return true;
      }
      else {
         return false;
      }
   }
   
  /**
  Is a getter method for axis c.
  
  @return double
  */ 
   public double getC() {
      return c;
   }

  /**
  Is a setter method for axis c.
  
  @return boolean
  @param cin to determine whether positive or not.
  */
   public boolean setC(double cin) {
      if (cin > 0) {
         c = cin;
         return true;
      }
      else {
         return false;
      }
   }
   
  /**
  Calculates volume.
  
  @return double
  */ 
   public double volume() {
      double numerator = 4 * Math.PI * a * b * c;
      double denominator = 3;
      double volume = numerator / denominator;
      return volume;
   }
   
  /**
  Calculates surfacearea.
  
  @return double
  */ 
   public double surfaceArea() {
      double numerator = Math.pow((a * b), 1.6) + Math.pow((a * c), 1.6) 
            + Math.pow((b * c), 1.6);
      double denominator = 3;
      double parenthesise = Math.pow((numerator / denominator), (1 / 1.6));
      double surfacearea = (4 * Math.PI) * parenthesise;
      return surfacearea;
   }
   
  /**
  Converts the string to text including 
  the axis and other calculations.
  
  @return String
  */  
   public String toString() {
      DecimalFormat stringform = new DecimalFormat("#,##0.0###");
      
      String output = "Ellipsoid " + "\"" + label + "\" " + "with axes a = " 
            + a + ", b = " + b + ", c = " + c + " units has:"
            + "\n\tvolume = " + stringform.format(volume()) + " cubic units"
            + "\n\tsurface area = " + stringform.format(surfaceArea()) 
            + " square units";
      return output;
   }

/**
returns the value of count.

@return int
*/
   public static int getCount() {
      return count;
   }
   
   /**
   resets the value of count.
   */
   public static void resetCount() {
      count = 0;
   }
   
   /**
   checks to see if the inputted object. 
   is an existing ellipsoid
   
   @return boolean
   @param obj is the object inputted by the user
   */
   public boolean equals(Object obj) {
      if (!(obj instanceof Ellipsoid)) {
         return false;
      }
      else {
         Ellipsoid e = (Ellipsoid) obj;
         return (label.equalsIgnoreCase(e.getLabel())
            && Math.abs(a - e.getA()) < .000001
            && Math.abs(b - e.getB()) < .000001
            && Math.abs(c - e.getC()) < .000001);
      }
   }
   
   
   /**
   I'm not entirely sure what this one is for.
   
   @return int
   */
   public int hashCode() {
      return 0;
   }

}