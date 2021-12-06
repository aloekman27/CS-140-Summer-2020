// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : July 30th, 2020
// Assignment : Lab 4 Guessing Game
/* Purpose : This program will be able to produce a random number within a range and 
             the user will try to guess that number. The program will be able to tell
             whether the number the user chooses is correct, above or lower than the 
             correct number. Users could opt to play again. When finished, the program 
             will show a summary. */
             
import java.util.*; //imports scanner from java library

public class ALGuess {
   // max number is the range of the number the program will guess ( 1 - maxNumber)
   public static final int maxNumber = 100;
   
   public static void main(String[] args) {
      //Create a Scanner to obtain input from the command window
      Scanner input = new Scanner(System.in);
      //initiate variables
      int bestGame = 100;
      int totalGuess = 0;
      int totalGames = 0;
      int end = 0;
      
      // call instructions method to main
      instructions();
      
      while (end == 0) {
         int numGuess = playOneGame(input);
         totalGames += 1;
         totalGuess += numGuess;
            if (numGuess < bestGame) {
               bestGame = numGuess;
            } // end of if else
            boolean reply = playAgain(input);
               if (reply == false) {
                  end++;
               } //end of if else
      } // end of while loop
      
      //Gives out the game report
      report(totalGames, totalGuess, bestGame);
                   
   
   } //end of main method
   
   public static void instructions() {
      //Give an intro about the program and explain instructions to users.
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will Think of a number between 1 and ");
      System.out.println(maxNumber + " and will allow you to guess it until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
    
   } //end of instructions method
   
   public static int playOneGame(Scanner console) {
      //initiate random number generator and variables
      Random rand = new Random();
      int randNum = rand.nextInt(maxNumber) + 1;
      int end = 0;
      int numGuess = 0;
      
      System.out.println("I am thinking of a number between 1 and " + maxNumber + " ...");
      while (end != randNum) {
         System.out.print("Your Guess? ");
         //prompts user to input (guess) a number
         int guessNum = console.nextInt();
         if (guessNum == randNum && numGuess == 0) {
            numGuess++;
            System.out.println("AMAZING! You got it right in " + numGuess + " guess!");
            end += guessNum;
         } else if (guessNum < randNum) {
            System.out.println("It's Higher");
            numGuess++;
         } else if (guessNum > randNum) {
            System.out.println("It's Lower");
            numGuess++;
         } else if (guessNum == randNum) {
            numGuess++;
            System.out.println("Congratulations! You got it right in " + numGuess + " guesses!");
            end += guessNum;
         } // end of if else
      } //end of while loop
       
      return numGuess;
       
   
   } //end of playOneGame method
   
   public static boolean playAgain(Scanner console) {
      //initiates variables
      boolean continueGame = true;
      boolean fixed = true;
      
      System.out.println();
      System.out.println("Do you want to play again? type 'y' for yes or 'n' for no");
      while (fixed) {
         //prompts user to type in either y or n and will start new game if y or show report if n
         String userInput = console.next();
         if (userInput.charAt(0) == 'y') {
            System.out.println();
            continueGame = true;
            fixed = false;
         } else if (userInput.charAt(0) == 'n') {
            System.out.println();
            continueGame = false;
            fixed = false;
         } else {
            System.out.println("ERROR! Please type in a valid command (y / n)");
            System.out.println();
         } //end of if else
      } //end of while loop
         
      return continueGame;
   
   
   } //end of playAgain method
      
   public static void report(int totalGames, int totalGuess, int bestGame) {
      //calculates the average of guesses/game
      double average = (Math.round((double) totalGuess / totalGames * 10)) / 10.0;
      //prints out game report from the game
      System.out.println("\t +++GAME REPORT+++");
      System.out.println("\t Total Games : " + totalGames);
      System.out.println("\t Total Guesses : " + totalGuess);
      System.out.println("\t Guesses / Game : " + average);
      System.out.println("\t Best Game : " + bestGame);
      System.out.println();
      System.out.println("Thank you for playing!");
      
   } // end of report method 


} //end of ALGuessingGame class