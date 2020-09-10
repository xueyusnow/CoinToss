// Name: Xueyu Wang
// USC NetID: 2670589054
// CS 455 PA1
// Fall 2019

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   

   private int bottom;
   private int left;
   private int width;
   private int barHeight;
   private double scale;
   private Color color;
   private String label;
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
      this.bottom = bottom;
      this.left = left;
      this.width = width;
      this.barHeight = barHeight;
      this.scale = scale;
      this.color = color;
      this.label = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      String label_demensions = label;
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label_demensions, context);
      int widthOfLabel = (int) labelBounds.getWidth(); //Get the width of the rectangle of the label.
      int heightOfLabel = (int) labelBounds.getHeight(); //Get the height of the rectangle of the label.
      
      Rectangle rect = new Rectangle(left, bottom-heightOfLabel-barHeight, width, barHeight);     
      
      if (barHeight != 0){
         g2.setColor(color); // The color of the rectangle.
         g2.draw(rect);
         g2.fill(rect);
      }
      
      g2.setColor(Color.BLACK); //The font color of the label.
      g2.drawString(label_demensions, left + 30 - widthOfLabel/2, bottom); //Draw the label.
   }
}
