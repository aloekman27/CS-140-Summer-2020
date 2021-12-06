// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : August 12th, 2020
// Assignment : Calendar Assignment Part 3
/* Purpose : Creates a calender which shows events every month (US Calendar).
             Users could also add an event to the calendar and it will be shown
             on the graphic calendar. Other things the calendar could do are 
             show today's date, next month, previous month, and enter a date  */
   
import java.util.*;
import java.io.*;
   
public class ALCalendarPart3 {
   //introduces constants necessary for the program
   public static final int HEIGHT= 5; 
   public static final int DATE_ROW = 7;
   public static final int FIRST_DAY = 4;
   public static final int LEAP_DAY = 0;
   public static String[][] CalendarEvent = new String[12][];
      
   public static void main(String[] args) throws FileNotFoundException {
      //introduces scanner to program
      Scanner console = new Scanner(System.in);
      Calendar today = Calendar.getInstance();
      int[] date = new int[2];
      boolean[] check = new boolean[2];
      jArray();
      readFile(date, check, "calendarEvents.txt");
      
      while (true) {
         //prints main menu and prompts user to input a choice
         mainMenu();
         String choice = console.next().toLowerCase();
         if(choice.length() > 2) {
            System.out.println("Please don't put more thatn two characters \n");
         } else {
            if (choice.equals("e")) { //prompts user to input a date and displays it
               check[0] = true;
               while (!check[1]) {
                  System.out.println("What date would you like to see: (MM/DD)");
                  String input = console.next();
                  date = dateToMonthAndDay(input, date);
                  check[1] = checkMonthAndDay(date);
               } //end of while loop
               check[1] = false;
               drawMonth(date);
               displayDate(date);
                  
            //show calendar for today
            } else if(choice.equals("t")) { //will print today's date
               check[0] = true;
               System.out.println("\nToday: ");
               date[0] = today.get(Calendar.MONTH);
               date[1] = today.get(Calendar.DATE)-1;
               drawMonth(date);
               displayDate(date);
                      
            
            } else if(choice.equals("n")) {//calendar will show next month, else show error message
               if(check[0]) {
                  System.out.println("\nNext Month: ");
                  date[0] += 1;
                  date[1] = 0;
                  if (date[0] > 11) {
                     date[0] = 0;
                  }
                  drawMonth(date);
               } else {
                  System.out.println("You have not displayed a calendar yet");
               } //end of if else
                  
            
            } else if (choice.equals("p")) { //shows previous month, else show error message
               if (check[0]) {
                  System.out.println("\nPrevious Month: ");
                  date[0] -= 1;
                  date[1] = 0;
                  if (date[0] < 0) {
                     date[0] = 11;
                  }
                  drawMonth(date);
               } else {
                  System.out.println("You have not displayed a calendar yet");
               } //end of if else
            
            //let users create new event
            } else if (choice.equals("ev")) {//prompts user to input a date and event that will be noted
               while (!check[1]) {
                  System.out.println("Please add an event: (MM/DD event_title)");
                  String input = console.next();
                  String toFile = input;
                  date = dateToMonthAndDay(input, date);
                  check[1] = checkMonthAndDay(date);
                  input = console.next();
                  if (check[1]) {
                     toFile += " " + input;
                     CalendarEvent[date[0]][date[1]] = input;
                     System.out.println("Event has been noted");
                     readFile(toFile);
                  } else {
                     System.out.println("Wrong input");
                  } //end of if else
               } //end of while loop
               check[1] = false;
            
            
            } else if (choice.equals("uf")) { // adding events to user file
               boolean bool = true;
               //check the format of the file
               System.out.println("Please enter in format of (MM/DD event_name)");
               System.out.println("Type \"y\" to proceed");
               String yes = console.next().toLowerCase();
               if (yes.equals("y")) {
                  bool = false;
               } //end of if else
               
               while (bool==false) {
                  System.out.println("Please type in file name: (file_name.txt)");
                  String input = console.next();//read the file 
                  bool = readFile(date, check, input);
                  System.out.println("File read successfully");
               } //end of while loop
               System.out.println("File read failed");
               
            
            } else if (choice.equals("fp")) { //print date to external file
               while (!check[1]) {
                  
                  System.out.println("What date do you want to print (MM/DD)");
                  String input = console.next();
                  date = dateToMonthAndDay(input, date);
                  check[1] = checkMonthAndDay(date);
               }
               //prints it to output file or creates an output file
               System.out.println("Please enter an output file name: (output_name.txt)");
               String outName = console.next();
               PrintStream out = new PrintStream(new File(outName));
               PrintStream ps = System.out;
               System.setOut(out);
               drawMonth(date);
               displayDate(date);
               System.setOut(ps);
               System.out.println("Calendar Printed successful");
               
            }else if(choice.equals("q")){ //quit program
               break;
                        
            }else{
               System.out.println("Wrong input. Please Try again");//if user types in other than prompted
            } //end of if sle
            
            
            System.out.println("\"y\" to Back to main menu");
            System.out.println("\"q\" to quit the program");
            char yes = console.next().toLowerCase().charAt(0);
            if (yes == 'q') {
               break;
            } else if (yes != 'y') {
               System.out.println("Wrong input, continuing program");
            } //end of if else
         } //end of if else
      } //end of while loop
   } //end of main method
      
      
      
   
      
   public static void mainMenu() {
      //gives intro and instructions to users
      System.out.println("Please type a command");
      System.out.println("\t\"e\" to enter a date and display the corresponding calendar");
      System.out.println("\t\"t\" to get todays date and display the today's calendar");
      System.out.println("\t\"n\" to display the next month");
      System.out.println("\t\"p\" to display the previous month");
      System.out.println("\t\"ev\" to create a new event");
      System.out.println("\t\"uf\" to add events from user file");
      System.out.println("\t\"fp\" to print a certain month to a file");
      System.out.println("\t\"q\" to quit the program");
   } //end of mainMenu method
      
   public static void jArray() {
      //this method uses jagged array to determine the number of days for each month
      for (int i = 0; i < CalendarEvent.length; i++) {
         if ( i == 3 || i == 5 || i == 8 || i == 10) { // months 4, 6, 9, 11
            CalendarEvent[i] = new String[30];
         } else if (i == 1) {
            CalendarEvent[i] = new String[28 + LEAP_DAY]; //month 2
         } else {
            CalendarEvent[i] = new String[31]; //month 1, 3, 5, 7, 8, 10, 12
         } //end of if else
            
      }//end of for loop
      
   } //end of JArray method
      
   public static boolean readFile (int[] date, boolean[] check, String file) throws FileNotFoundException {
      //reads file, which is the events file
      File f = new File(file);
         
      if (f.exists()) {
         Scanner console = new Scanner(f);
         
         while (console.hasNextLine()) {
            String event = console.nextLine();
            String eventDate = event.substring(0, event.indexOf(" "));
            date = dateToMonthAndDay(eventDate, date);
            check[1] = checkMonthAndDay(date);
               
            if (check[1]) {
               CalendarEvent[date[0]][date[1]] = event.substring(event.indexOf(" ") + 1);
            }//end of if
            check[1] = false;
            
         } //end of while loop
         return true;
         
      }//end of if
      return false;
   } //end of readFile method
      
   public static void drawMonth(int[] date) {
      //draws the month of the calendar as well as the top of the graphic calendar
      int numCol = (int)Math.ceil((daysInMonth(date[0]) + startOfMonth(date)) / (double) DATE_ROW);
         
      for (int j = 1; j <= (HEIGHT * DATE_ROW - 6) / 2; j++) {
         System.out.print(" ");
      }//end of for loop
         
      for (int j = 1; j <= (HEIGHT * DATE_ROW - 13) / 2; j++) {
         System.out.print(" ");
      }//end of for loop
      System.out.println();
      drawDay();
         
      for (int i = 0; i < numCol; i++) {
         for (int j = 1; j <= DATE_ROW * HEIGHT; j++) {
            System.out.print("=");
         } //end of for loop
            
         System.out.println("=");
         drawRow(i, date);
      } //end of for loop
      
      for (int i = 1; i <= DATE_ROW * HEIGHT; i++) {
         System.out.print("=");
      } // end of for loop
         
      System.out.println("=");
      
   } //end of drawMonth method
      
   public static void drawRow(int row, int[] date) {
      //draws the rows of the calendar as well as the dates that correspond to each month
      int startDate = 1 + row * DATE_ROW - startOfMonth(date);
      int dayMonth = daysInMonth(date[0]);
         
      for (int j = 1; j <= DATE_ROW; j++) {
         System.out.print("|");
            
         if (startDate < 10 || startDate > dayMonth) {
            System.out.print(" ");
         } if (startDate > dayMonth || startDate < 1) {
            System.out.print(" ");
         } else {
            System.out.print(startDate);
         } if (startDate == date[1] + 1) {
            for (int k = 1; k <= HEIGHT - 3; k++) {
               System.out.print("#"); //indicates today's date
            } //end of for loop
         } else {
            for (int k = 1; k <= HEIGHT - 3; k++) {
               System.out.print(" ");
            }//end of for loop
         } //end of if else
         startDate++;
      } //end of for loop
      System.out.println("|");
         
      for (int j = 1; j <= HEIGHT / 2 - 1; j++) {
         startDate = 1 + row * DATE_ROW - startOfMonth(date) - 1;
         
         for (int f = 1; f <= DATE_ROW; f++) {
            System.out.print("|");
               
            if (startDate > -1 && startDate < daysInMonth(date[0]) && j == 1) {
               String event = CalendarEvent[date[0]][startDate];
                  
               if (event == null) {
                  event = "";
                  for (int k = 1; k <= HEIGHT; k++) {
                     event += " ";
                  } //end of for loop
               } else if (event.length() > HEIGHT - 1) {
                  event = event.substring(0, HEIGHT - 1);
               } else if (event.length() < HEIGHT - 1) {
                  while (event.length() < HEIGHT - 1) { 
                     event += " ";
                  } //end of while loop
               } //end of if else
               System.out.print(event);
            } else {
               for (int k = 1; k <= HEIGHT - 1; k++) {
                  System.out.print(" ");
               } //end of for loop
            } //end of if else
            startDate += 1;
         } //end of for loop
         System.out.println("|");
      } //end of for loop            
               
   }//end of drawRow method
      
   public static void displayDate(int[] date) {
      //displays month and day on the bottom of the graphic calendar
      System.out.println("Month : " + (date[0] + 1));
      System.out.println("Day : " + (date[1] + 1));
   } //end of displayDate method
      
   public static void drawDay() {
      //displays 7 days in a week on the top of the calendar and position it correctly
      String[] dayIndicator = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
      int indicator = 0;
         
      for (int i = 0; i <= (HEIGHT - 3) / 2; i++) {
         System.out.print(" ");
      } //end of for loop
         
      while (indicator <= 6) {
         System.out.print(dayIndicator[indicator]);
         indicator++;
            
         for (int i = 1; i <= HEIGHT - 3; i++) {
            System.out.print(" ");
         } //end of for loop
      } //end of while loop
      System.out.println();
      
   } //end of drawDay method
      
   public static int[] dateToMonthAndDay(String input, int[] date) {
      //changes the month inputted by user into an integer
      String month = input.substring(0, input.indexOf("/"));
      date[0] = Integer.parseInt(month) - 1;
      //changes the day inputted by user into an integer
      String day = input.substring(input.indexOf("/") + 1);
      date[1] = Integer.parseInt(day) - 1;
      return date;
        
      
   }//end of dateToMonthAndDay method
      
   public static int daysInMonth(int month) {
      //prints the correct amount of days in each month
      if (month == 3 || month == 5 || month == 8 || month == 10) {
         return 30;
      } else if (month == 1) {
         return 28 + LEAP_DAY;
      } return 31;
        
                  
   } //end of daysInMonth method
      
   public static boolean checkMonthAndDay(int[] date) {
      //checks if date inputted by user is correct
      if (date[0] >= 0 && date[0] < 12) {
         if (date[0] == 3 || date[0] == 5 || date[0] == 8 || date[0] == 10) {
            if (date[1] < 30) {
               return true;
            }//end of if else
            
         } else if (date[0] == 1) { 
            if (date[1] < 28 + LEAP_DAY) {
               return true;
            }
         } else if (date[1] < 31) {
            return true;
         }
      } //end of if else
      System.out.println("Wrong input, please check if date exists");
      return false;
      
   } //end of checkMonthAndDay method
      
   public static int startOfMonth(int[] date) {
      //indicates the day the month starts with
      int dayNum = 0;
         
      for (int i = 0 ; i < date[0]; i++) {
         dayNum = dayNum + daysInMonth(i);
      } //end of for loop
         
      int workDay = dayNum % 7 + FIRST_DAY;
         
      if (workDay > 6) {
         workDay = workDay - 7;
      } 
      return workDay;
   } //end of startOfMonth method
      
   public static void readFile(String toFile) throws FileNotFoundException {
      //reads file that could print important dates in the graphic calendar
      File f = new File("calendarEvents.txt");
      Scanner sc = new Scanner(f);
      String events = "";
         
      while (sc.hasNextLine()) {
         events = events + sc.nextLine();
         events = events + "skip";
      } //end of while loop
         
      events = events + toFile + "skip";
         
      Scanner out = new Scanner(events).useDelimiter("skip");
      PrintStream ps = new PrintStream(f);
         
      while(out.hasNext()) {
         ps.append(out.next());
         ps.println();
      } //end of while loop
   } //end of readFile method
               
   
}//end oc ALCalendarPart3 class