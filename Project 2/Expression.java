import java.util.Scanner;
/**
 Program that calculates a given function, and returns a
 number or "undefined".
 Project 02
 @author James Barras comp 1210 LLB 010
 @version January 22 2020
 */
public class Expression {
   /**
   Program that calculates the given function.
   @param args Command line arguments – not used.
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      double x = 0.0;
      double y = 0.0;
      double result;
      String result1;
      
      System.out.println("result = (10x + 32.6) (5y - 1.567) / xy");
      
      System.out.print("\tx = ");
      x = userInput.nextDouble();
      
      System.out.print("\ty = ");
      y = userInput.nextDouble();
      
      System.out.print("result ");
      if (x * y == 0) {
         result1 = ("is \"undefined\"");
         System.out.println(result1);
      }
      else {
         result = ((10 * x + 32.6) * (5 * y - 1.567)) / (x * y);
         System.out.println("= " + result);
      }
     
   }
}