// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : August 4th, 2020
// Assignment : Lab 5 Mad Libs
/* Purpose : Create a creative mad libs where users could input words and the program
             will create a story based on the words the user has put in. This program will
             use  file processing as a base file where the story is put. the story will use 
             a .txt file.*/
             
import java.io.*; //imports file from the java library
import java.util.*; //imports scanner from the java library
             
public class ALMadLibs {
   public static void main(String[] args)throws FileNotFoundException {
      //Create a Scanner to obtain input from the command window
      Scanner console = new Scanner(System.in);
      boolean playOneGame = true;
      
      //calls instructions into main method
      intro();
      System.out.println();
      while (playOneGame == true) {
         playOneGame = mainMenu(console);
      } //end of while 
      System.out.println("Thanks for playing!");
      
   
   
   } //end of main method
   
   public static void intro() { //gives explanation of the rules to user
      System.out.println("Welcome to the game of MAD LIBS.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
   
   }//end of intro method
   
   public static boolean mainMenu(Scanner console) throws FileNotFoundException {
      //prints out the interactive main menu where users could choose what they want to do
      System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit ");
      String choice = console.next();
      //prompts user to input either c, v, q (case insensitive). else input again
      if (choice.charAt(0) == 'c' || choice.charAt(0) == 'C') {
         createGame(console);
         return true;
      } if (choice.charAt(0) == 'v' || choice.charAt(0) == 'V') {
         viewGame(console);
         return true;
      } if (choice.charAt(0) == 'q' || choice.charAt(0) == 'Q') {
         return false;
      } else {
         System.out.println("Invalid answer. Please type a valid answer"); 
         return true;
      } //end of if else 
      
   } //end of mainMenu method
   
   public static void createGame(Scanner console) throws FileNotFoundException {
      System.out.print("Please input file name : "); //file name should be mymadlib.txt
      String fileName = console.next();
      File f1 = new File(fileName);
      
      while (!f1.exists()) {
         System.out.println("File not found. Please try again.");
         fileName = console.next();
      } //end of while loop
      
      System.out.print("Type in Output file name : "); //output file could be named anything
      String nameOut = console.next();
      File out = new File(nameOut);
      PrintStream output = new PrintStream(out);
      
      //scanner for words user will be prompted to input
      Scanner input = new Scanner(f1);
      
      
      while(input.hasNextLine()) {
         String text = input.next();
           
         
      
         //prompts user to input words that replace a certain type of word
         if(text.startsWith("<") && text.endsWith(">")) {
            char a = text.charAt(1);
            String aeiou = vowels(a);
            text = text.replace('<', ' ');
            text = text.replace('>', ' ');
            text = text.replace('-', ' ');
            System.out.println("Please type" + aeiou + text);
            String in = console.next();
            output.print(" " + in + " ");
         } else {
            output.print(" " + text + " ");
         } //end of if else
         
      } //end of while loop
      
   }// end of createGame method
   
   public static void viewGame(Scanner console) throws FileNotFoundException {
      //view the story that the user has created into the program
      Scanner viewFile = new Scanner (new File("ALmymadlib.txt"));
      
      while(viewFile.hasNextLine()) {
         String text = viewFile.nextLine();
      } //end of while loop
      System.out.println();
      
   } //end of viewGame method
   
   public static String vowels (char check) {
      //switches direction for vowels so that it starts with an instead of a
      String a;
      if(check == 'a' || check == 'A' || check == 'i' || check == 'I' 
         || check == 'e' || check == 'E' || check == 'o' || check == 'O' 
         || check == 'u' || check == 'U') {
         a = " an";
      } else {
         a = " a";
      }
      return a;
   
   }//end of vowels method
   
   	
} //end of ALMadLibs class  