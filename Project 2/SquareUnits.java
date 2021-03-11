import java.util.Scanner;
/**
 Program that calculates inches to various other measurements.

 Project 02
 @author James Barras comp 1210 LLB 010
 @version January 22 2020
 */
public class SquareUnits  {
   /**
   Program that converts inches to many other measurements.
   
   @param args Command line arguments – not used.
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      int acres = 6272640;
      int yards = 1296;
      int feet = 144;
      int inches = 1;
   
      System.out.print("Enter the area in square inches: ");
      inches = userInput.nextInt();
   
      if (inches > 1000000000) {
         System.out.println("Limit of 1,000,000,000 square inches exceeded!");
      }
      else {
         System.out.println("Number of Units: ");
         
         System.out.println("\tAcres: " + (inches / acres));
         int remainder1 = inches % acres;
         
         System.out.println("\tSquare Yards: " + (remainder1 / yards));
         int remainder2 = remainder1 % yards;
         
         System.out.println("\tSquare Feet: " + (remainder2 / feet));
         int remainder3 = remainder2 % feet;
         
         System.out.println("\tSquare Inches: " + (remainder3));
      }
   }
}