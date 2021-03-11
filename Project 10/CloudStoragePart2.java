import java.io.FileNotFoundException;
/**
 is the main driver class for printing reports.
 of a CloudList object.

Project 10
 @author James Barras comp 1210 LLB 010
 @version April 10 2020
*/
public class CloudStoragePart2 {
/**
is the main method for the class.

@param args is the inputted argument
@throws FileNotFoundException if the file cannot be opened.
*/
   public static void main(String[] args) throws FileNotFoundException {
      
      if (args.length > 0) {
         String filenamein = args[0];
         CloudStorageList listobject1 = new CloudStorageList();
         listobject1.readFile(filenamein);
      
         String report1 = listobject1.generateReport();
         String report2 = listobject1.generateReportByName();
         String report3 = listobject1.generateReportByMonthlyCost();
         
         System.out.print(report1 + report2 + report3);
      }
      else {
         System.out.print("File name expected as command line argument."
                  + "\nProgram ending." + "\n");
      
      }
      
   
   
   }



}