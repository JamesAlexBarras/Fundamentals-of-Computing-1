import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
/**
is a class that provides methods for the.
CloudStoragePart2 driver class.

Project 11
 @author James Barras comp 1210 LLB 010
 @version April 15 2020

*/
public class CloudStorageList {
   private CloudStorage[] cstorageArray;
   private String[] stringArray;
/**
is the constructor of the class.
*/
   public CloudStorageList() {
      cstorageArray = new CloudStorage[0];
      stringArray = new String[0];
   
   }
   /**
   returns the array.
   
   @return CloudStorage[]
   */
   public CloudStorage[] getCloudStorageArray() {
      return cstorageArray;
   }
   
   /**
   returns the invalid records array.
   
   @return String[]
   */
   public String[] getInvalidRecordsArray() {
      return stringArray;
   }
   
   /**
   adds an object to the CloudStorage[] array.
   
   @param objin is the inputted object
   */
   public void addCloudStorage(CloudStorage objin) {
      cstorageArray = Arrays.copyOf(cstorageArray, cstorageArray.length + 1);
      cstorageArray[cstorageArray.length - 1] = objin;
   
   }
   
   /**
  adds an invalid record.
   
  @param stringin is the inputted string 
   */
   public void addInvalidRecord(String stringin) {
      stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
      stringArray[stringArray.length - 1] = stringin;
   }
   
   /**
   reads in a file and adds objects to the array.
   
   
   @param filenamein is the inputted file name
  @throws FileNotFoundException if the file cannot be opened.
   */
   public void readFile(String filenamein) 
            throws FileNotFoundException {
            
      Scanner filescan = new Scanner(new File(filenamein));
      char identifier;
      
      while (filescan.hasNext()) {
         String theline = filescan.nextLine();
         try {
            //String theline = filescan.nextLine();
            Scanner linescan = new Scanner(theline);
            linescan.useDelimiter(",");
         
            identifier = linescan.next().charAt(0);
         
            switch(identifier) {
               case 'D':
                  String name = linescan.next();
                  double bstorage = Double.parseDouble(linescan.next());
                  double servercost = Double.parseDouble(linescan.next());
               
                  CloudStorage dfile = new DedicatedCloud(name, 
                                       bstorage, servercost);
                  addCloudStorage(dfile);
                  break;
               
               case 'S':
                  String name1 = linescan.next();
                  double bstorage1 = Double.parseDouble(linescan.next());
                  double stored = Double.parseDouble(linescan.next());
                  double limit = Double.parseDouble(linescan.next());
               
                  CloudStorage sfile = new SharedCloud(name1, 
                                 bstorage1, stored, limit);
                  addCloudStorage(sfile);
                  break;
               
               case 'C':
                  String name2 = linescan.next();
                  double bstorage2 = Double.parseDouble(linescan.next());
                  double stored1 = Double.parseDouble(linescan.next());
                  double limit1 = Double.parseDouble(linescan.next());
               
                  CloudStorage cfile = new PublicCloud(name2, 
                              bstorage2, stored1, limit1);
                  addCloudStorage(cfile);
                  break;
               
               case 'P':
                  String name3 = linescan.next();
                  double bstorage3 = Double.parseDouble(linescan.next());
                  double stored2 = Double.parseDouble(linescan.next());
                  double limit2 = Double.parseDouble(linescan.next());
               
                  CloudStorage pfile = new PersonalCloud(name3, 
                                 bstorage3, stored2, limit2);
                  addCloudStorage(pfile);
                  break;
               
               default:
                  String stringin = Character.toString(identifier);
                  throw new InvalidCategoryException(stringin);
                  //break;
            }
         }
         catch (InvalidCategoryException e) {
            String inv1 = theline + "\n" + e;
            addInvalidRecord(inv1);
         }
         catch (NumberFormatException e) {
            String inv2 = theline + "\n" + e;
            addInvalidRecord(inv2);
         }
         catch (NoSuchElementException e) {
            String inv3 = theline + "\n" + e
                  + ": For missing input data";
            addInvalidRecord(inv3);
         
         }
      }
      
      /**catch (InvalidCategoryException e) {
         String inv1 = theline + "\n" + e.getMessage();
      
      } */
   }
   
   /**
   generates a report based on the order of the array.
   
   @return String
   */
   public String generateReport() {
      String obs2 = "";
      for (int i = 0; i < cstorageArray.length; i++) {
         obs2 += cstorageArray[i] + "\n\n";
      }
      
      
      String report = "-------------------------------" 
                  + "\nMonthly Cloud Storage Report" 
                  + "\n-------------------------------"
                  + "\n" + obs2;
      return report;
   
   }
   
   
   /**
   generates a report based on the names of objects.
   
   @return String
   */
   public String generateReportByName() {
      Arrays.sort(getCloudStorageArray());
      String obs = "";
      
      for (int i = 0; i < cstorageArray.length; i++) {
         obs += cstorageArray[i] + "\n\n"; 
      
      }
      
      
      String namereport = "-----------------------------------------" 
                        + "\nMonthly Cloud Storage Report (by Name)"
                        + "\n-----------------------------------------"
                        +  "\n" + obs;
      return namereport;
   
   }
   
   /**
   generates a report based on monthly cost.
   
   @return String
   */
   public String generateReportByMonthlyCost() {
      Arrays.sort(getCloudStorageArray(), new MonthlyCostComparator());
   
      String obs1 = "";
      for (int i = 0; i < cstorageArray.length; i++) {
         obs1 += cstorageArray[i] + "\n\n";
      
         
         
      }
   
   
      String costreport = "-------------------------------------------------"
                        + "\nMonthly Cloud Storage Report (by Monthly Cost)"
                        + "\n-------------------------------------------------"
                        + "\n" + obs1;
      return costreport;
   
   }
   /**
   generates report of invalid records.
   
   @return String
   */
   public String generateInvalidRecordsReport() {
      String obs3 = "";
      for (int i = 0; i < stringArray.length; i++) {
         obs3 += stringArray[i] + "\n\n";
      }
      
      
      String report2 = "----------------------" 
                  + "\nInvalid Records Report" 
                  + "\n----------------------"
                  + "\n" + obs3;
      return report2;
   
   }
   
   
}