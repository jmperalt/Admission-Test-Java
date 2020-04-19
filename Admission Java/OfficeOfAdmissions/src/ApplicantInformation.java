
/* 
  Jayson Peralta
  Homework #2
  Due October 31st, 2018
  Description: This program read and write a student applicant file. Also, we check all the data fields if is in valid
  range, if not, then, we keep the user to re-enter a valid range data.
 
  */
import java.util.*;
import java.io.*;

public class ApplicantInformation {
	
	// Private that is Constant for exit
	private static final int EXIT = 3;
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int selection = 0;
		while (selection != EXIT) { // It will not stop the program until you enter 3 which is the exit.
			// Print the Header and promptUserDisplay
			printHeader();
			promptUserDisplay();
			// User enter a selection 1 to 3
			selection = input.nextInt();
			switch (selection) {
			case 1:
				writeFile(); // writeFile() Method
				break;
			case 2:
				readFile(); // readFile() Method
				break;
			case 3:
				exit(); // exit() Method
				break;
			default:
				System.out.println("Your choice doesn't exist ");
			}
			System.out.println("*************************");
		}

	}

	public static void writeFile() throws Exception {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter a file name
		System.out.println("Enter file name:");
		String fileName = input.next();

		// Assign output to null
		PrintWriter output = null;

		// Prompt the user how many scores do they want to enter
		System.out.println("How many scores do you want to enter?");
		int numOfScores = input.nextInt();
		try {
			output = new PrintWriter(new FileWriter(fileName + ".txt", true)); // PrintWriter that writes a file and
			// assign it to output
			// How many score you want to enter and store it to the file.
			for (int i = 0; i < numOfScores; i++) {

				Applicant applicant = new Applicant(input, true); // Make a applicant object and take all the input and
																	// output it to the file

				output.print(applicant.getLastName() + " "); // Get the last name of the applicant and write it in the
																// file
				output.print(applicant.getFirstName() + " "); // Get the first name of the applicant and write it in the
																// file
				output.print(applicant.getMathSATScore() + " "); // Get the math SAT score and write it in the file
				output.print(applicant.getWritingSATScore() + " "); // Get the writing SAT Score and write it in the
																	// file
				output.print(applicant.getVerbalSATScore() + " "); // Get the verbal SAT Score and write it into the
																	// file
				output.print(applicant.getGPA() + " "); // Get the GPA and write it into the file
				output.print(applicant.getDecision() + " "); // Get the decision and write it in the file
				output.println(" ");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (null != output) // If the null is not equal to the output, then close
				output.close();
		}
	}

	public static void readFile() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		Scanner fileRead = null; // A assign fileRead to null

		// Prompt the user to enter a file name that exist
		System.out.println(
				"Enter the file name that you want to read the applicant data. For example: Appliccant or ApplicantData.txt ");
		String fileName = input.next();
		File inFile = new File(fileName + ".txt");

		/*
		 * Check the file exist, if it is exist then prompt the user to enter the last
		 * name; however, if matches the last name of the previous file, then display
		 * that student information
		 */
		try {
			if (inFile.exists()) {
				// Prompt the user to enter a last name
				System.out.println("Enter your last name");
				String Lname = input.next();
				// Read the file
				fileRead = new Scanner(inFile);
				while (fileRead.hasNext()) {
					Applicant applicant = new Applicant(fileRead, false); // Create a applicant object that take an
																			// Scanner filrRead
					if (Lname.equals(applicant.getLastName())) { // and we want to set to false because we are reading
																	// the input
						System.out.println(applicant.toString()); // from the file
					} // Use the the toString Method to get all the information
				}
			} else {
				System.out.println("File does not exist!! "); // If the file not exist
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (null != fileRead) { // if null is not equal to fileRead, then close the fileRead
				fileRead.close();
			}
		}
	}

	// Method that exit the program
	public static void exit() {
		System.out.println("Thank you! Have a great day! ");
		System.exit(0);
	}

	// Method that print the Header
	public static void printHeader() {
		System.out.println("Main Menu");
		System.out.println("---------");
	}

	// Method that print the prompt user display
	public static void promptUserDisplay() {
		System.out.println("Enter 1 to write a data to a file");
		System.out.println("Enter 2 to read data from a file");
		System.out.println("Enter 3 to exit");
		System.out.println("Enter your choice");
	}
}
