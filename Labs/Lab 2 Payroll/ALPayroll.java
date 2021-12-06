// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : July 8th, 2020
// Assignment : Lab 2 Payroll
/* Purpose : This program will use nested ifElse and while loops to create an interactive
             payroll where users can prompt in their datas*/
             
import java.util.Scanner; //program imports Scanner from the library   
   
          
public class ALPayroll {
   public static void main(String[] args) {
   //Create a Scanner to obtain input from the command window
   Scanner input = new Scanner(System.in);
   
      int employeeCounter = 1;
      int Totalemployee = 5; // change constant here according to number of employees 
      
      
      while (employeeCounter <= Totalemployee) { 
      //Type in employee's name
      System.out.println("Please enter employee name :");
         String name = input.next();
         
         //Select if employee is paid salary (1) or hourly (2)
         System.out.printf("%s%n", "Select 1 if Salaried or select 2 if Hourly: ");
            int select = input.nextInt();
            
         // Error message if user does not select either 1 or 2, then prompting to input again
         while (select > 2) {
            System.out.printf("%s%n", "Selection invalid; Please Select 1 if Salaried or select 2 if Hourly: ");
               select = input.nextInt();
         }
         if (select == 1) { //if employee is salaried
            double gross = 400.00;
            double tax = 0.087 * gross;
            double net = gross - tax;
            
            System.out.printf("%s%n%s%.2f%n", "Your Gross Pay is","$   ", gross);
            System.out.printf("%s%n%s%.2f%n", "Tax Deductions","$   ", tax);
            System.out.println("=================================");
            System.out.printf("%s%n%s%.2f%n", "Your Net Payment is","$   ", net);
         } else { //if employee is working hourly
            System.out.print("How many hours have you worked this week (including overtime if necessary): \n");
              int hour = input.nextInt();
            
            //variables for hourly payroll
            double hourly = 13.50;
            double grosstotal = hourly * hour;
            double taxes = 0.087 * grosstotal;
            double netpayment = grosstotal - taxes;
            double bonus = 2.0;
            double bonuspaymentgross = grosstotal + (2.0 * (hour - 40));
            double bonustaxes = 0.087 *bonuspaymentgross;
            double bonusnet = bonuspaymentgross - bonustaxes;
            
                  if (hour <= 40) { // if employee works less than or equal to 40 hours
                     System.out.printf("%s%n%s%.2f%n", "Your Gross Pay is","$   ", grosstotal);
                     System.out.printf("%s%n%s%.2f%n", "Tax Deductions","$   ", taxes);
                     System.out.println("=================================");
                     System.out.printf("%s%n%s%.2f%n", "Your Net Payment is","$   ", netpayment);
                  } else { // if employee works overtime (more than 40 hours
                     System.out.printf("%s%n", "Congratulations you got a 2.0 bonus for working overtime");
                     System.out.printf("%s%n%s%.2f%n", "Your Gross Pay is","$   ", bonuspaymentgross);
                     System.out.printf("%s%n%s%.2f%n", "Tax Deductions","$   ", bonustaxes);
                     System.out.println("=================================");
                     System.out.printf("%s%n%s%.2f%n", "Your Net Payment is","$   ", bonusnet);
                     
                  
               }
                      
               
         }
         System.out.println("-------------------------------------------");
         
         employeeCounter = employeeCounter + 1;
         
         
      } //end of while loop
            System.out.println();
            System.out.printf("%s%n", "Thank you for using LostnFound Corporation Payroll Program");
            System.out.println("Have a wonderful day!");
      
   } //end of main method
   
} //end of ALPayroll class