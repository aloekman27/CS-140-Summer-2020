// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : June 30th, 2020
// Assignment : Lab 1 Business Report
/* Purpose : This program will show the business report such as income and expenses
             by a person */
             
public class AdrianLoekmanBusinessReport { // the start of class AdrianLoekmanBusinessReport
   public static void main(String[] args) { // start of main metod
      
      
      //Creating variables and constants that will be calculated in the business report
      int income = 5000;
      double tuition = 2059.90;
      double rent = 700.35;
      double fandb = 870.88;
      double gas = 120.47;
      double total = tuition+rent+fandb+gas;
      double balance = income-total;
      
      
      //Creating the opening paragraph for the Business Report
      System.out.printf("%s%n%s%n","Dear Mr. John Doe", "Saturday, 4th July 2020");
      System.out.println();
      System.out.println("Here is your monthly business report, brought to you by \"WHATCOM COMMUNITY COLLEGE\"\n");
      System.out.println("Details are listed below");
      System.out.println("--------------------------------"); // This is a section divider to make viewers see the program better
      
      //Starts the data for the Business Report
      System.out.printf("%s%n%s%d%n","Here is your income this month: ","$\t", income);
      System.out.printf("%s%n", "********************************"); //This is also a section divider
      
      System.out.print("Here are your expenses for this month: \n");
      System.out.printf("%s%.2f%n", "Tuition: $\t", tuition);
      System.out.printf("%s%.2f%n", "Rent\t : $ \t ", rent);
      System.out.printf("%s%.2f%n", "F and B: $ \t ", fandb);
      System.out.printf("%s%.2f%n", "Gas\t : $ \t ", gas);
      System.out.println("=====");
      System.out.printf("%s%.2f%n", "Total Expense: $\t", total);
      System.out.print("\n");
      System.out.printf("%s%.2f%n", "Your account balance is $\t", balance);
      System.out.printf("%s%s%n", "Would you like to make a withdrawal?", "(Y/N)");
      System.out.println();
      System.out.printf("%40s%n%37s", "Your Budget Buddy,", "Emil Paxton");
      
   }// end of main method
   
}// end of AdrianLoekmanBusinessReport class