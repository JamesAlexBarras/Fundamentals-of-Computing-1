/**
is a class that creates a new exception.
called invalid category exception.

Project 11
 @author James Barras comp 1210 LLB 010
 @version April 15 2020

*/
public class InvalidCategoryException extends Exception {
/**
is the constructor for this new exception.

@param categoryIn is the inputted category
*/
   public InvalidCategoryException(String categoryIn) {
      super("For category: " + categoryIn);
   
   }


}