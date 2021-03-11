import java.io.FileNotFoundException;
/**
is the main driver class for this project.

Project 11
 @author James Barras comp 1210 LLB 010
 @version April 15 2020

*/
public class CloudStoragePart3 {
/**
is the main method of this class.

@param args is the argument line used for the file name
*/
   public static void main(String[] args) {
   
      try {
      
         if (args.length > 0) {
            CloudStorageList cList = new CloudStorageList();
            
            String file = args[0];
            cList.readFile(file);
            String report1 = cList.generateReport();
            String report2 = cList.generateReportByName();
            String report3 = cList.generateReportByMonthlyCost();
            String report4 = cList.generateInvalidRecordsReport();
         
            System.out.print(report1 + report2 + report3 + report4);
         }
         else {
            System.out.print("File name expected as command line"
                        + " argument." + "\nProgram ending.\n");
         
         }
      
      }
      catch (FileNotFoundException e) {
         System.out.print("***Attempted to read file: " 
                        + e.getMessage() + "\n");
      
      }
      
      
      
      
      
   
   
   
   
   
   
   
   }


}