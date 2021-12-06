// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : July 13th, 2020
// Assignment : Lab 3 Cafe Wall
// Reference Materials : Chapter 3G textbook and PowerPoint
// Purpose : Creating a Cafe Wall illusion using Drawing panel

//importing graphics from the Java library
import java.awt.*;

public class ALCafeWall {
   // Constant to create a gap between each row, changing the constant is possible
   public static final int mortar = 2; // 2 means 2 pixels
   
   public static void main(String[] args) {
      // Draw the drawing panel, (width, height)
      DrawingPanel panel = new DrawingPanel(650,400);
      // Set Color to the Background
      panel.setBackground(Color.GRAY);
      // Access to be able to draw graphics such as lines and shapes
      Graphics g = panel.getGraphics();
      
      
      
      // Draws the first two graphics, we can use drawRows because it only has 1 row
      drawRows(0, 0, 4, 20, g);
      drawRows(50, 70, 5, 30, g);
      
      // Draws the rest of the graphics, use drawGrids because it contains multiple rows
      drawGrids(10, 150, 4, 25, 0, 8, g);
      drawGrids(250, 200, 3, 25, 10, 6, g);
      drawGrids(425, 180, 5, 20, 10, 10, g);
      drawGrids(400, 20, 2, 35, 35, 4, g);
      
   } //end of main method
   
   // method to draw each row
   public static void drawRows(int x, int y, int pairs, int size, Graphics g) {
      // the for loop so that I only need to draw 2 squares and lines and just have it repeated
      for(int i = 0; i < 2*pairs; i=i+2) {
         g.setColor(Color.BLACK);
         g.fillRect ( x + size*i , y , size, size);
         
         g.setColor (Color.BLUE);
         g.drawLine ( x + size*i , y,  x + size*(i+1), y + size);
         g.drawLine ( x + size*(i+1) , y,  x + size*i, y + size);
         
         g.setColor (Color.WHITE);
         g.fillRect (x + size*(i + 1), y, size, size);         
      } //end of 1st forloop
   } //end of drawRows method
   
   
   /* this method is used to draw multiple rows, offset by how many pixels the next row is shifted to 
      the right */
   public static void drawGrids(int x, int y, int pairs, int size, int offset, int rows, Graphics g){
     for(int i = 0; i < rows; i++) {
         // we recall drawRows but with slightly different variables
         drawRows(x + offset * (i%2), y + i*size + mortar*i, pairs, size, g);
      } // end of 2nd forloop
   }  //end of drawGrids Method
   
   
} //end of ALCafeWall Class  