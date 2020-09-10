import java.util.Scanner;

/**
 * CoinTossSimulatorTester class
 * This is a console-based program
 * Serve to figure out what other classes are used in the program and compiles those as well.  
 * This class tests every method multiple times, printing informative output to the console with the results of each operation.
 */
public class CoinTossSimulatorTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int exp = 0;
      Boolean bool;
      
      CoinTossSimulator CTS = new CoinTossSimulator();
      
      System.out.println("After constructor:");
      System.out.println("Number of trials [exp:" + exp + "]: " + CTS.getNumTrials());
      System.out.println("Two-head tosses: " + CTS.getTwoHeads());
      System.out.println("Two-tail tosses: " + CTS.getTwoTails());
      System.out.println("One-head one-tail tosses: " + CTS.getHeadTails());
      bool = (exp == CTS.getNumTrials());
      System.out.println("Tosses add up correctly? " + bool);
      System.out.println();
      for(int i = 0; i < 3; i++){
         System.out.print("Enter number of trials: ");
         int numTrials = in.nextInt();
         while (numTrials <= 0){
               System.out.println("ERROR: Number entered must be greater than 0.");
               System.out.print("Enter number of trials: ");
               numTrials = in.nextInt();
         }
         
         exp += numTrials;
         CTS.run(numTrials);
         System.out.println("After run(" + numTrials + "):");
         System.out.println("Number of trials [exp:" + exp + "]: " + CTS.getNumTrials());
         System.out.println("Two-head tosses: " + CTS.getTwoHeads());
         System.out.println("Two-tail tosses: " + CTS.getTwoTails());
         System.out.println("One-head one-tail tosses: " + CTS.getHeadTails());
         bool = (exp == CTS.getNumTrials());
         System.out.println("Tosses add up correctly? " + bool);
         System.out.println();
      }
      exp = 0;
      CTS.reset();
      System.out.println("After reset:");
      System.out.println("Number of trials [exp:" + exp + "]: " + CTS.getNumTrials());
      System.out.println("One-head one-tail tosses" + CTS.getHeadTails());
      System.out.println("Two-tail tosses: " + CTS.getTwoTails());
      System.out.println("One-head one-tail tosses" + CTS.getHeadTails());
      bool = (exp == CTS.getNumTrials());
      System.out.println("Tosses add up correctly? " + bool);
      System.out.println();
      
      System.out.print("Enter number of trials: ");
      int numTrials = in.nextInt();
      if (numTrials <= 0){
            System.out.println("ERROR: Number entered must be greater than 0.");
            System.out.print("Enter number of trials: ");
            numTrials = in.nextInt();
      }
      while (numTrials > 0){
         exp += numTrials;
         CTS.run(numTrials);
         System.out.println("After run(" + numTrials + "):");
         System.out.println("Number of trials [exp:" + exp + "]: " + CTS.getNumTrials());
         System.out.println("Two-head tosses: " + CTS.getTwoHeads());
         System.out.println("Two-tail tosses: " + CTS.getTwoTails());
         System.out.println("One-head one-tail tosses: " + CTS.getHeadTails());
         bool = (exp == CTS.getNumTrials());
         System.out.println("Tosses add up correctly? " + bool);
         System.out.println();
         System.out.print("Enter number of trials: ");
         numTrials = in.nextInt();
         if (numTrials <= 0){
               System.out.println("ERROR: Number entered must be greater than 0.");
               System.out.print("Enter number of trials: ");
               numTrials = in.nextInt();
         }
      }
   }
}