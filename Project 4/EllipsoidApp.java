import java.util.Scanner;

/**
Allows the user to input values for axis a, b, and c,
as well as allowing them to input a label. Program
then ouptus the results of the toString() method.

 Project 04
 @author James Barras comp 1210 LLB 010
 @version February 2020
*/
public class EllipsoidApp {
/**
Is the main method that runs the program.

@param args Command line arguments – not used.
*/
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String label;
      Double a;
      Double b;
      Double c;
   
      System.out.println("Enter label and axes a, b, c for an ellipsoid.");
   
      System.out.print("\tlabel: ");
      label = input.nextLine();
      
      System.out.print("\ta: ");
      a = Double.parseDouble(input.nextLine());
      if (a <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
      
      System.out.print("\tb: ");
      b = Double.parseDouble(input.nextLine());
      if (b <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
      
      System.out.print("\tc: ");
      c = Double.parseDouble(input.nextLine());
      if (c <= 0) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
      
      Ellipsoid myObj = new Ellipsoid(label, a, b, c);
      System.out.print("\n" + myObj);
     
   
   
   }
}