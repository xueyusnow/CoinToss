// Name:Xueyu Wang
// USC NetID: 2670589054
// CS 455 PA1
// Fall 2019
import java.util.Random;
/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {

   private Random generator;
   private int twoHeads;
   private int twoTails;
   private int headTails;
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      generator = new Random();
      twoHeads = 0;
      twoTails = 0;
      headTails = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   /**
      Coins just have two sides;
    */
   public void run(int numTrials) {
      for (int i = 0; i < numTrials; i++)
      {
         int faceofcoin1 = generator.nextInt(2);
         int faceofcoin2 = generator.nextInt(2);
         if (faceofcoin1 == 0 && faceofcoin2 == 0){
            this.twoHeads++;
         }
         else if (faceofcoin1 == 1 && faceofcoin2 == 1){
            this.twoTails++;
         }
         else {
            this.headTails++;
         }
      }
   }


   /**
      Get number of trials performed since last reset.
      @return the number of trials performed since last reset.
   */
   public int getNumTrials() {
       return twoHeads + twoTails + headTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
      @return number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return this.twoHeads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
     @return number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return this.twoTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
     @return number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return this.headTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      this.twoHeads = 0;
      this.twoTails = 0;
      this.headTails = 0;
   }

}
