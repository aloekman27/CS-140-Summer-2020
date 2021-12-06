// Programmer : Adrian Loekman
// Class : CS 140 OL1
// Date : August 10th, 2020
// Assignment : Lab 6 DNA
/* Purpose : Create a program which would be able to identify whether a 
             specific substance is protein. Using arrays, we will be able 
             to count each nucleotides, the mass percentage, and the count 
             of pairs inside the protein. */
             
import java.util.*; // imports scanner from library
import java.io.*; // imports file processing from the library(PrintStream, etc.)

public class ALDNA {
   //introduce constants that are involved
   public static final int NUMBER_OF_CODONS = 5; 
   public static final double PERCENTAGE_MASS = 30.00;
   public static final int UNIQUE_NUCLEOTIDES = 4;
   public static final int NUCS_CODON = 3;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner in = new Scanner(System.in);
      intro();
      String inputName = in.next();
      enterMenu(in, inputName);
   
   
   }//end of main method
   
   public static void intro() {
      //gives description and instructions to users
      System.out.println("This program reports information about DNA"); 
      System.out.println("nucleotide sequences that may encode ");
      System.out.print("proteins. Input file name? ");
   
   }//end of intro method
   
   public static void enterMenu(Scanner in, String inputName) throws FileNotFoundException {
      //prompts user to input files
      File fileInput = new File(inputName);//input file
      
      while (!fileInput.exists()) {
         System.out.print("File Not Found. Try Again");
         inputName = in.next();
         fileInput = new File(inputName);
      } //end of while loop
      
      if (fileInput.exists()) {
         System.out.println();
         System.out.print("Output file name? "); //output file
         String outputFile = in.next();
         PrintStream output = new PrintStream(new File(outputFile));
         printOutput(output,inputName);
      } //end of if
         
   }//end of enterMenu method
   
   public static void printOutput(PrintStream output, String inputName) throws FileNotFoundException {
      Scanner console = new Scanner(new File(inputName));
      
      while (console.hasNextLine()) {
         output.print("Region Name : "); //prints region name (or the name itself)
         String regionName = console.nextLine();
         output.println(regionName);
         
         output.print("Nucleotides : "); //prints the long line of nucleotides
         String nucleotideSequence = console.nextLine();
         output.println(nucleotideSequence);
         
         int dash = 0;
         int[] nuc = new int[UNIQUE_NUCLEOTIDES];
         String upperNucleotides = nucleotideSequence.toUpperCase();
         
         for (int i = 0; i < upperNucleotides.length(); i++) {
            if (upperNucleotides.charAt(i) == 'A') {
               nuc[0]++;
            } else if (upperNucleotides.charAt(i) == 'C') {
               nuc[1]++;
            } else if (upperNucleotides.charAt(i) == 'G') {
               nuc[2]++;
            } else if (upperNucleotides.charAt(i) == 'T') {
               nuc[3]++;
            } else {
               dash++;
            } //end of if else
            
         } //end of for loop
         output.println(Arrays.toString(nuc));
         
         output.print("Total Mass %: "); //figures out the total mass % and for each nucleotide
         double[] mass = {135.128, 111.103, 151.128, 125.107, 100.000};
         double[] totalMass = {nuc[0]*mass[0], nuc[1]*mass[1], nuc[2]*mass[2], nuc[3]*mass[3], dash * mass[4]};
         double sum = totalMass[0] + totalMass[1] + totalMass[2] + totalMass[3] + totalMass[4];
         double[] massPercent = {Math.round(totalMass[0] / sum * 1000.0) / 10.0, Math.round(totalMass[1] / sum * 1000.0) / 10.0, 
         Math.round(totalMass[2] / sum * 1000.0) / 10.0, Math.round(totalMass[3] / sum * 1000.0) / 10.0};
         output.println(Arrays.toString(massPercent) + " of " + Math.round(sum * 10.0) / 10.0); 
 
         output.print("Codons List: ");
         //prints out codons list of 3 letters seperated by a comma
         String[] codons = new String[upperNucleotides.length() / NUCS_CODON];
         
         for (int i = 0; i < upperNucleotides.length() / NUCS_CODON; i++) {           
            if (i > 0) {
               codons[i] = upperNucleotides.substring(NUCS_CODON*i, NUCS_CODON*i+NUCS_CODON);           
            } else { 
               codons[i] = upperNucleotides.substring(0,NUCS_CODON);
            }//end of if else
            
         } //end of for loop
         
         output.println(Arrays.toString(codons));
         output.println();
         
         output.print("Is Protein?: ");
         // checks whether the nucleotide is in fact a protein
         String proteinCheck = "NO";
         if (codons[0].equals("ATG")) {
            if (codons[nucleotideSequence.length() / NUCS_CODON - 1].equals("TAA") || 
               codons[nucleotideSequence.length() / NUCS_CODON - 1].equals("TAG") || 
               codons[nucleotideSequence.length() / NUCS_CODON - 1].equals("TGA")) {
                  if (nucleotideSequence.length() / NUCS_CODON >= NUMBER_OF_CODONS) {
                     if (massPercent[1] + massPercent[2] >= PERCENTAGE_MASS) {
                        proteinCheck = "YES";
                  }
               }
            }
         } //end of ifs
         output.println(proteinCheck);
         output.println();
      }//end of while loop


   }//end of printOutput method
      
   
}//end of ALDNA class
