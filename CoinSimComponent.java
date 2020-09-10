import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.lang.Math;
import java.awt.geom.Rectangle2D;

/**
   This component draws three bars.
*/
public class CoinSimComponent extends JComponent
{  

   private final int bw = 60;
   private final int vb = 100;
   private CoinTossSimulator cts;
   
   public CoinSimComponent(CoinTossSimulator CTS) {
      this.cts = CTS;
       
   }
   
   @Override
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      
      int partsofheads = (int) Math.round((double) cts.getTwoHeads() * 100.0/(double) cts.getNumTrials()); //The number of the percentage.
      int partsoftails = (int) Math.round((double) cts.getTwoTails() * 100.0/(double) cts.getNumTrials());
      int partsofheadtails = (int) Math.round((double) cts.getHeadTails() * 100.0/(double) cts.getNumTrials());
      
      String label1 = "Two Heads: " + cts.getTwoHeads() + "(" + partsofheads + "%)";
      String label2 = "A Head and a Tail: " + cts.getHeadTails() + "(" + partsofheadtails + "%)";
      String label3 = "Two Tails: " + cts.getTwoTails() + "(" + partsoftails + "%)";
      
      // to get the width and height of the label.
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label1, context);
      int widthOfLabel = (int) labelBounds.getWidth(); //Get the width of the rectangle of the label.
      int heightOfLabel = (int) labelBounds.getHeight(); //Get the height of the rectangle of the label.
      
      int x = getWidth(); //Get the width of the current window.
      int y = getHeight(); //Get the height of the current window.
      
      int spacewidth = (x - 180)/4; // Calculate the width of the gaps.
      double scale = (y - 2 * vb - heightOfLabel)/100.0; //Calculate the scale.
      
      Bar bar1 = new Bar(y - vb, spacewidth, bw, (int) Math.round(partsofheads * scale),
                         scale, Color.RED, label1);
      Bar bar2 = new Bar(y - vb, 2 * spacewidth + bw, bw, (int) Math.round(partsofheadtails * scale),
                         scale, Color.GREEN, label2);
      Bar bar3 = new Bar(y - vb, 3 * spacewidth + 2 * bw, bw, (int) Math.round(partsoftails * scale),
                         scale, Color.BLUE, label3);
      
      bar1.draw(g2);
      bar2.draw(g2);
      bar3.draw(g2);
   }
}
