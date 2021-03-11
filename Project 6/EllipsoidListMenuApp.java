import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
/**
Uses methods from ellipsoidlist and ellipsoid.
in order to execute various menu options. 

Project 06
 @author James Barras comp 1210 LLB 010
 @version February 19 2020
*/
public class EllipsoidListMenuApp {
/**
is the main method that gives the user an input.
and then executes the various menu choices.

@param args - is not used.
@throws FileNotFoundException if the file cannot be opened.
*/
   public static void main(String[] args) throws FileNotFoundException {
      Scanner userInput = new Scanner(System.in);
      String input = "";
      ArrayList<Ellipsoid> fullarray = new ArrayList<Ellipsoid>();
      EllipsoidList fulllist = new EllipsoidList(input, fullarray);
   
   
      System.out.print("Ellipsoid List System Menu"
         + "\nR - Read File and Create Ellipsoid List"
         + "\nP - Print Ellipsoid List"
         + "\nS - Print Summary"
         + "\nA - Add Ellipsoid"
         + "\nD - Delete Ellipsoid"
         + "\nF - Find Ellipsoid"
         + "\nE - Edit Ellipsoid"
         + "\nQ - Quit");
     
      do {
         System.out.print("\nEnter Code [R, P, S, A, D, F, E, or Q]: ");
         input = userInput.nextLine();
         
         if (input.length() == 0) {
            continue;
         }
         input = input.toUpperCase();
         char menuchoice = input.charAt(0);
         
         switch (menuchoice) {
            case 'R': 
               System.out.print("\tFile Name: ");
               String filename = userInput.nextLine();
               
               fulllist = fulllist.readFile(filename);
               
               System.out.println("\tFile read in "
                  + "and Ellipsoid List created");
               break;
               
            case 'P':
               System.out.print(fulllist);
               break;
            
            case 'S':
               System.out.print("\n" + fulllist.summaryInfo());
               break;
            
            case 'A':
               System.out.print("\tlabel: ");
               String label1 = userInput.nextLine();
               System.out.print("\ta: ");
               double axisa = Double.parseDouble(userInput.nextLine());
               System.out.print("\tb: ");
               double axisb = Double.parseDouble(userInput.nextLine());
               System.out.print("\tc: ");
               double axisc = Double.parseDouble(userInput.nextLine());
            
               fulllist.addEllipsoid(label1, axisa, axisb, axisc);
               System.out.print("\t*** Ellipsoid added ***" + "\n");
            
               break;
               
            case 'D':
               System.out.print("\tlabel: ");
               String label = userInput.nextLine();
               
               if (fulllist.findEllipsoid(label) != null) {
                  Ellipsoid saved = fulllist.findEllipsoid(label);
                  String savedlabel = saved.getLabel();
               
                  fulllist.deleteEllipsoid(label);
                  System.out.println("\t\"" + savedlabel + "\" deleted");
               } 
               else {
                  System.out.println("\t\"" + label + "\" not found");
                  break;
               }
               break;
            
            case 'F':
               System.out.print("\tlabel: ");
               String label45 = userInput.nextLine();
               if (fulllist.findEllipsoid(label45) == null) {
                  System.out.println("\t\"" + label45 + "\" not found");
               }
               else {
                  Ellipsoid foundellip = fulllist.findEllipsoid(label45);
                  String printed = foundellip.toString();
               
                  System.out.print(printed + "\n");
               }
               break;
            
            case 'E':
               System.out.print("\tlabel: ");
               String labelf = userInput.nextLine();
               System.out.print("\ta: ");
               double axisaf = Double.parseDouble(userInput.nextLine());
               System.out.print("\tb: ");
               double axisbf = Double.parseDouble(userInput.nextLine());
               System.out.print("\tc: ");
               double axiscf = Double.parseDouble(userInput.nextLine());
            
               if (fulllist.editEllipsoid(labelf, axisaf, axisbf, axiscf)
                  == null) {
                  System.out.println("\t\"" + labelf + "\" not found");
               }
               else {
                  Ellipsoid foundellip = fulllist.findEllipsoid(labelf);
                  String saved = foundellip.getLabel();
               
                  fulllist.editEllipsoid(labelf, axisaf, axisbf, axiscf);
               
                  System.out.println("\t\"" + saved + "\" successfully edited");
               }
            
            case 'Q':
               break;
            default:
               System.out.print("\t*** invalid code ***" + "\n");
         }
      } while (!input.equalsIgnoreCase("Q"));
   }
}