// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : July 13th, 2020
// Assignment : Lab 3 Doodle
// Reference Materials : Chapter 3G textbook and PowerPoint
// Purpose : Creating a Doodle using DrawingPanel and Java Graphics.

//importing graphics from the Java library
import java.awt.*;


public class ALDoodle {
   public static void main(String[] args) {
      // Draw the drawing panel, (width, height)
      DrawingPanel panel = new DrawingPanel(500,300);
      // color of the background
      panel.setBackground(Color.CYAN);
      // Access to be able to draw graphics such as lines and shapes
      Graphics g = panel.getGraphics();
      
      // Drawing the flagpole
      g.drawLine(50, 50, 50, 200);
      
      // Drawing the top of the flag
      g.setColor(Color.WHITE);
      g.fillOval(45, 40, 10, 10);
      g.setColor(Color.BLACK);
      g.drawOval(45, 40, 10, 10);
      
      //Drawing the flag
      g.setColor(Color.RED);
      g.fillRect(50, 50, 100, 30);
      g.setColor(Color.WHITE);
      g.fillRect(50, 80, 100, 30);
      
      //The base of the house
      g.setColor(Color.BLUE);
      g.fillRect(300, 150, 100, 100);
      
      //The roof of the house
      g.setColor(Color.ORANGE);
      Polygon poly = new Polygon();
      poly.addPoint(400, 150);
      poly.addPoint(350, 70);
      poly.addPoint(300, 150);
      g.fillPolygon(poly);
      
      //The door of the house
      g.setColor(Color.GRAY);
      g.fillRect(320, 200, 30, 50);
      
      //The doorknob
      g.setColor(Color.BLACK);
      g.fillOval(320, 220, 5, 5);

      

      
   } //end of main method
   
} //end of ALDoodle Class
