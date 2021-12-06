// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : July 13th, 2020
// Assignment : Calender Part 1
/* Purpose : Creating a simple calender showing month and date as well as 
             the calender itself. */

import java.util.*;//program imports Scanner from the library 

public class ALCalendarPart1 {
   public static void main(String[] args) {
   //Create a Scanner to obtain input from the command window
   Scanner input = new Scanner(System.in);
   
   
   
  
      //Calls the methods below to the main method
      drawMonth();
      
      System.out.println();
      
      
      todayDate();
      
    
      
      
   } // end of main method
   // This method draws the asciiArt 
   public static void asciiArt() {
      // this is for spacing so that the art is in the middle of the calendar
      for (int i = 1; i<=13; i++) {
         System.out.print(" ");
      }
         System.out.println("o(^^o)(o^^o)(o^^o)(o^^)o");
      
   } // end of asciiArt method
   
   //
   public static void drawMonth() {
   
    
      Calendar today = Calendar.getInstance();
      //Create a Scanner to obtain input from the command window
      Scanner input = new Scanner(System.in);
      //Prompts user to put in month and date using the format 
       System.out.println("What date would you like to look at? (mm/dd)");
         String date = input.next();
         
         char firstMonth = date.charAt(0);
         char secondMonth = date.charAt(1);
         char firstDay = date.charAt(3);
         char secondDay = date.charAt(4);
            //Displays asciiArt at the top of the calendar
            asciiArt();
   
         //Displays the month inputted by user at the top of the graphic calendar
         if (firstMonth == '0') {
            for(int i = 1; i <= 25; i++) {
               System.out.print(" ");
            }
               System.out.print(secondMonth);
         } else if (firstMonth == '1') {
             for(int i = 1; i <= 24; i++) {
                System.out.print(" ");
             } 
                System.out.print(firstMonth);
                System.out.print(secondMonth);
           }
           System.out.println();
           //prompts to draw the graphic calendar
           drawRow(5);
           //prints the month which the user has inputted from the prompt
           if (firstMonth == '0') {
         System.out.print("Month: " + secondMonth);
           } else if (firstMonth == '1') {
         System.out.print("Month: " + firstMonth + secondMonth);
          }
         System.out.println();
      
         //prints the month which the user has inputted from the prompt
           if (firstDay == '0') {
                System.out.print("Day: " + secondDay);
           } else if (firstDay == '1' || firstDay == '2' || firstDay == '3') {
                System.out.print("Day: " + firstDay + secondDay);
           }
            System.out.println();
           
                 
   } // end of drawMonth method
   
   
   public static void drawRow(int row) { // method to draw the graphic calendar
      int day = 1;
   
      for (int rows = 1; rows <= row; rows++) {
      
      for (int i = 1; i <= 50; i++) {
         System.out.print("=");
      } 
      System.out.println();
      for (int j = 1; j <= 7; j++) {
         if (day < 10) {
            System.out.print("|" + day +"     ");
            day++;
         }else if (day >= 10) {
            System.out.print("|" + day + "    ");
            day++;
         }
      }           
      
      System.out.println("|");
      for(int l = 1; l <= 2; l++) {
         for(int k = 1; k <= 7; k++) {
            System.out.print("|      ");
            
         }
         System.out.println("|");
     }
     }
     for (int i = 1; i <= 50; i++) {
         System.out.print("=");
      }
      System.out.println();
         
   } //end of drawRow method
   
  
  
   public static void todayDate() { // for extra credit, I printed out the graphic calendar and data for today's month and date
      // Gets information for today's date
      Calendar today = Calendar.getInstance();
      
      //Get's today's date and month
      int todayDate = today.get(Calendar.DATE);
      int todayMonth = today.get(Calendar.MONTH) + 1;
      asciiArt();
      // Draws spacing so the art and month would show in the middle above the calendar
      for(int i = 1; i <= 25; i++) {
               System.out.print(" ");
            }
      System.out.println(todayDate);
      
      drawRow(5);
   System.out.println("Month : " + todayMonth);
   System.out.println("Day : " + todayDate);
   
   }  // end of todayDate method
   
   
} // end of ALCalendarPart1 class
      