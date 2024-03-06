import java.util.Scanner;

public class ShampooMethod {

   /* Your solution goes here  */
   public static void printShampooInstructions(int numCycles) {
      
      
      if (numCycles < 1) {
         System.out.println("Too few");
      }
      else if (numCycles > 4) {
         System.out.println("Too many");
      }
      else {
         for (int x = 1; x < numCycles; x++){
            System.out.println(x + ": Lather and rinse.");
         }
      }
   }
   
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int userCycles;

      userCycles = scnr.nextInt();
      printShampooInstructions(userCycles);
   }
}