import java.util.Scanner;
import java.text.DecimalFormat;
/**
Program takes a user-inputted value, runs it through an expression, and 
displays the results in various ways.
 
 Project 03
 @author James Barras comp 1210 LLB 010
 @version January 28 2020
*/ 
public class Solver {
/**
Program takes a user-inputted value, runs it through an expression, and 
displays the results in various ways.

@param args Command line arguments – not used.
*/
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      double x;
      double result;
      double totalpowerof;
      double squareroot;
      double fourthpower;
      double cubepower;
      double squarepower;
      double absvalue;
   
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      fourthpower = Math.pow(x, 4);
      cubepower = Math.pow(x, 3);
      squarepower = Math.pow(x, 2);
      totalpowerof = (11 * fourthpower) + (9 * cubepower)
             + (7 * squarepower) + (5 * x) + 4;
      absvalue = Math.abs(totalpowerof);
      squareroot = Math.sqrt(absvalue);
      result = squareroot / (2 * x + 4);
      System.out.println("Result: " + result);
      
      String stringresult = Double.toString(result);
      int length = stringresult.length();
      int decimalloc = stringresult.indexOf(".");
      
      String left = stringresult.substring(0, decimalloc);
      String right = stringresult.substring(decimalloc + 1, 
            +stringresult.length());
      
      int length1 = left.length();
      int length2 = right.length();
      
      System.out.println("# of characters to left of decimal point: " 
               + length1);
      System.out.println("# of characters to right of decimal point: " 
               + length2);
     
      DecimalFormat format = new DecimalFormat("#,##0.0####");
      String formatfinal = format.format(result);
      System.out.println("Formatted Result: " + formatfinal);
   }
   
}