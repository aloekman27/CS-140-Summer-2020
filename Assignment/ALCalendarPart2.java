// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : July 27th, 2020
// Assignment : Calender Part 2
/* Purpose : Creating a simple calender showing month and date as well as 
             the calender itself. Part 2 will show a menu where users could
             choose what wants to be viewed and each month will be adjusted 
             according to the true number of days with the correct days shown.
             The calendar also shows the graphic calendar of a month and date
             inputted by the user. */

import java.util.*;//program imports Scanner from the library 

public class ALCalendarPart2 {
   //constants to adjust graphic calendar size
   public static final int FIRSTDAY = 3;
   public static final int SIZE = 5;
   

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Calendar today = Calendar.getInstance();
      menuChoice(input, today);


   }//end of main method
   
   public static void menuCommand() {
      //prints instructions for users to read and follow.
      System.out.println("Please type a command");
      System.out.println("\t \"e\" to enter a date and display the corresponding calendar");
      System.out.println("\t \"t\" to get todays date and display the today's calendar");
      System.out.println("\t \"n\" to display the next month");
      System.out.println("\t \"p\" to display the previous month");
      System.out.println("\t \"q\" to quit the program");
      
   }//end of menuCommand method
   
   public static void menuChoice(Scanner input, Calendar today) {
      //creates an interactive menu where users could type in a command they want
      int month = 0;
      int day = 0;
      int userDecision = 0;
   
      String userChoice = "";
      
      while(!userChoice.contains("q")) {
         menuCommand();
         userChoice = input.next();
         //if user types e
         if (userChoice.contains("e")) {
            userDecision = 1;
            int text = 1; 
            
            while (text == 1) {
               System.out.println("What date would you like to see? (mm/dd)");
               String date = input.next();
               month = monthFromDate(date);
               day = dayFromDate(date);
               text = userInput(month, day);
            } //end of while loop
            drawMonth(month, day);
            displayDate(month, day);
            //if user types t
         } else if (userChoice.contains("t")) {
            userDecision = 1;
            System.out.println("\n Today : ");
            month = today.get(Calendar.MONTH) + 1;
            day = today.get(Calendar.DATE);
            drawMonth(month, day);
            displayDate(month, day);
            //if user types n
         } else if (userChoice.contains("n")) {
            if (userDecision == 1) {
               System.out.println("\n Next Month : ");
               month += 1;
               if (month > 12) {
                  month = 1;
               }//end of if else
               drawMonth(month, 100);
         } else {
            System.out.println("Please display a calendar first");
         } // end of if else n
         //if user types p
         } else if (userChoice.contains("p")) {
            if (userDecision == 1) {
               System.out.println("\n Previous Month : ");
               month -= 1;
               if (month < 1) {
                  month = 12;
               }//end of if else
               drawMonth(month, 100);
         } else {
            System.out.println("Please display a calendar first");
         } //end of if else p
         //if user types other than e, t, n, p, or q
         } else if (!userChoice.contains("q")) {
            System.out.println("Please enter a valid command");
         } //ens of if else
         System.out.println();
      } //end of while loop
               
   }//end of menuChoice method
   
   public static String displayMonth(int month) {
      //displays the month above the calendar as inputted by the user
      if (month == 1) {
         return "January";
      } else if (month == 2) {
         return "February";
      } else if (month == 3) {
         return "March";
      } else if (month == 4) {
         return "April"; 
      } else if (month == 5) {
         return "May";  
      } else if (month == 6) {
         return "June";
      } else if (month == 7) {
         return "July";
      } else if (month == 8) {
         return "August";
      } else if (month == 9) {
         return "September";
      } else if (month == 10) {
         return "October";
      } else if (month == 11) {
         return "November";
      } else {
         return "December";
      } //end of if else
   
   }//end of displayMonth method
   
   public static void daysAbove() {
      //prints the days from sunday - saturday above the calendar
      int dayName = 1;
      while (dayName <= 7) {
         if (dayName == 1) {
            for (int i = 1; i <= SIZE - 3; i++) {
               System.out.print(" ");
            }
            System.out.print("MON"); //prints Sunday
         } if (dayName == 2) {
            System.out.print("TUE"); //prints Monday
         } if (dayName == 3) {
            System.out.print("WED"); //prints Tuesday
         } if (dayName == 4) {
            System.out.print("THU"); //prints Wednesday
         } if (dayName == 5) {
            System.out.print("FRI"); //prints Thursday
         } if (dayName == 6) {
            System.out.print("SAT"); //prints Friday
         } if (dayName == 7) {
            System.out.print("SUN"); //prints Saturday
         } // end of if 
         dayName++;
         for (int i = 1; i <= SIZE - 3; i++) {
            System.out.print(" ");
         }
      } //end of while loop
      System.out.println();
            
   }//end of days above method
   
   public static void drawMonth(int month, int day) {
      //this method will display the month and days of the week for the graphic calendar
      for (int space = 1; space <= (SIZE * 7 - 6) / 2; space++) {
         System.out.print(" ");
      } //end of for loop
      System.out.println(displayMonth(month));
      daysAbove();
      //draws the frame of the calendar
      for (int row = 1; row <= 5; row++) {
         for (int column = 1; column <= SIZE * 7 + 1; column++) {
            System.out.print("=");
         } //end of for loop
         System.out.println();
         drawRow(row, day, month);
      } //end of for loop
      for (int column = 1; column <= SIZE * 7 + 1; column++) {
         System.out.print("=");
      } //end of for loop
      
   }//end of drawMonth method
   
   public static void drawRow (int row, int day, int month) {
      //draws the graphic calendar per row for 5 times
      int date = 1 + row * 7 - beginningMonth(month) - 7;
      int dayMonth = datesEachMonth(month);
      
      for (int firstRow = 1; firstRow <= 7; firstRow++) {
         String dated = Integer.toString(date);
         if (date < 1) {
            dated = "  ";
         } 
         System.out.print("| ");
         for(int i = date; i <= dayMonth; i = dayMonth + 1) {
            System.out.print(dated);
         } //end of for loop
         for (int i = date; i >= dayMonth + 1; i = 0) {
            System.out.print("  ");
         } //end of for loop
         date++;
         for (int space = 1; space <= SIZE - 2 - dated.length(); space++) {
            if (day == date - 1) {
               System.out.print("#");
            } else {
               System.out.print(" ");
            }// end of if else
         } //end of for loop
      } //end of for loop
      System.out.println("|");
      
      
      for (int secondRow = 1; secondRow <= (3 * SIZE / 5) - 2; secondRow++) {
         for (int below = 1; below <= 7; below++) {
            System.out.print("|");
            for (int space = 1; space<= SIZE - 1; space ++) {
               System.out.print(" ");
            } //end of for loop
         }//end of for loop
         System.out.println("|");
      }//end of for loop
      
   } //end of drawRow method
   
   public static void displayDate(int month, int day) {
      //Shows the month and date from the user's input and similar to the graphic calendar
      System.out.println();
      System.out.println("Month : " + month);
      System.out.println("Day : " + day);
   
   }//end of displayDate Method
         

   public static int monthFromDate(String date) {
      //gets month from user input and change it into an integer
      String monthTemp = date.substring(0, 2);
      int month = Integer.parseInt(monthTemp);
      return month;
      
   }//end of monthFromDate method  
   
   public static int dayFromDate (String date) {
      //gets day from user input and change it into an integer
      String dayTemp = date.substring(3, 5);
      int day = Integer.parseInt(dayTemp);
      return day;
   }//end of dayFromDate method 
   
    public static int beginningMonth(int month){
      //determines the starting day for each month to be exact with the date
      int numberDay = 0;
         for(int i = 1; i < month; i++){
            numberDay = numberDay + datesEachMonth(i);
         } 
         int dayInWeek = numberDay % 7 + FIRSTDAY;
         if(dayInWeek > 6){
            dayInWeek = dayInWeek - 7;
         } 
         return dayInWeek; 
    } //end of beginningMonth method
         
      public static int userInput(int month, int day){
         //checks user input for each month, if it does not match then will print an error message
         if(month > 0 && month < 13) {
            if(month == 4 || month == 6 || month == 9 || month == 11) {
               if(day < 31) { 
                  return 0; 
               }
            } else if(month == 2) { 
                if(day < 29) {
                   return 0; 
                }
            } else if(day < 32) { 
                return 0; 
            }
         }
            System.out.println("Wrong input, please check if date is real");
            return 1;
      } //end of UserInputMethod (extra credit)
   
      public static int datesEachMonth(int month){
         //determines the number of days for each month
         if(month == 4 || month == 6 || month == 9 || month == 11) {
           return 30;
         }else if(month == 2){
            return 28;
         }
         return 31;
      } //end of datesEachMonth method
   


}//end of ALCalendarPart2 class