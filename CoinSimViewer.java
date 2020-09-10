import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;
/**
 * CoinSimViewer class
 * Draw a bar graph in a window to show the results of tossing a pair of coins some number of times.
 * Include the main Function.
 */
public class CoinSimViewer
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter number of trials: ");
      int numTrials = in.nextInt();
      
      if (numTrials <= 0){
         System.out.println("ERROR: Number entered must be greater than 0.");
         numTrials = in.nextInt();
      }
      
      CoinTossSimulator CTS = new CoinTossSimulator();
      CTS.run(numTrials);
      
      JFrame frame = new JFrame();
      frame.setTitle("CoinSim");
      frame.setSize(800, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      CoinSimComponent component = new CoinSimComponent(CTS);
      
      frame.add(component);
      frame.setVisible(true);
   }
}