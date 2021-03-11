import java.util.Scanner;
import java.text.DecimalFormat;
/**
Program takes a user-inputted expression, and breaks it down
into several different categories.
 
 Project 03
 @author James Barras comp 1210 LLB 010
 @version January 28 2020
*/ 
public class Event {
/**
Program takes a user input and translates it into several
different categories.

@param args Command line arguments – not used.
*/
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);        
      
      System.out.print("Enter your event code: ");
      String eventcode1 = userInput.nextLine();
      String eventcode = eventcode1.trim();
      
      int length = eventcode.length();
      if (length < 26) {
         System.out.println(" ");
         System.out.println("Invalid Event Code.");
         System.out.println("Event code must have at least 26 characters.");
      }
      else {
         String date1 = eventcode.substring(0, 2);
         String date2 = eventcode.substring(2, 4);
         String date3 = eventcode.substring(4, 8);
         String time1 = eventcode.substring(8, 10);
         String time2 = eventcode.substring(10, 12);
         String price1 = eventcode.substring(12, 17);
         String discount1 = eventcode.substring(17, 19);
         String section = eventcode.substring(19, 21);
         String row = eventcode.substring(21, 23);
         String seat = eventcode.substring(23, 25);
         String description = eventcode.substring(25, eventcode.length());
         
         System.out.println(" ");
         
         System.out.print("Event: " + description);
         System.out.print("   Date: " + date1 + "/" + date2 + "/" + date3);
         System.out.println("   Time: " + time1 + ":" + time2);
         
         System.out.print("Section: " + section);
         System.out.print("   Row: " + row);
         System.out.println("   Seat: " + seat);
         
         Double price = Double.parseDouble(price1);
         DecimalFormat priceform = new DecimalFormat("$##0.00");
         
         Double discount = Double.parseDouble(discount1);
         DecimalFormat discountform = new DecimalFormat("00.#%");
         
         Double eqprice = price / 100;
         Double eqdiscount = discount / 100;
         Double takeoffprice = eqprice * eqdiscount;
         Double cost = eqprice - takeoffprice;
         String formattedcost = priceform.format(cost);
         String formattedprice = priceform.format(eqprice);
         String formatteddiscount = discountform.format(eqdiscount);
         
         System.out.print("Price: " + formattedprice);
         System.out.print("   Discount: " + formatteddiscount);
         System.out.println("   Cost: " + formattedcost);
         
         int prizenumber = (int) (Math.random() * 9998) + 1;
         System.out.print("Prize Number: " + prizenumber);
         
      }
   }
}
