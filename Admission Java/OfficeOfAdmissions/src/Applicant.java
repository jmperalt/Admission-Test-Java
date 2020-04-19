import java.util.InputMismatchException;
import java.util.Scanner;

public class Applicant {
	// Create a private data (CONSTANT) that assigns minimum and maximum value of Math SAT Score
	private static final int MIN_SAT_MATH = 0;
	private static final int MAX_SAT_MATH = 800;
	
	// Create a private data (CONSTANT) that assigns minimum and maximum value of Verbal SAT Score
	private static final int MIN_SAT_VERBAL = 0;
	private static final int MAX_SAT_VERBAL = 400;

	// Create a private data (CONSTANT) that assigns minimum and maximum value of Writing SAT Score
	private static final int MIN_SAT_WRITING = 0;
	private static final int MAX_SAT_WRITING = 400;

	// Create a private data (CONSTANT) that assigns specific character letter to make a decisions 
	private static final char ACCEPTED = 'A';
	private static final char REJECTED = 'R';
	private static final char WAITING_LIST = 'W';
	private static final char NO_DECISION = 'N';

	// Create a private data (CONSTANT) that assigns minimum and maximum value of GPA
	private static final double MIN_GPA = 0.0;
	private static final double MAX_GPA = 4.0;

	// Private Data Fields
	private String lastName;
	private String firstName;
	private int mathSAT_Score;
	private int verbalSAT_Score;
	private int writingSAT_Score;
	private double gpa;
	private char decision;

	// Applicant Constructor that takes input (Scanner) and promptUser as a argument parameter (True or False)
	public Applicant(Scanner input, boolean promptUser) {
		
		// Prompt the user to enter Last Name
		if (promptUser) {
			System.out.print("Enter Last Name: ");
		}
		lastName = input.next();
		
		// Prompt the user to enter First Name
		if (promptUser) {
			System.out.print("Enter First Name: ");
		}
		firstName = input.next();
		
		/* Check the data if valid. If not, keep prompting the user until the user enters valid data 
		 	Use try and catch exception to find the error and catch it. Set isValid to false before each while condition.
		 */
		boolean isValid = false; // Set the isValid to false
		while (!isValid) {       // Now isValid is true
			if (promptUser) {
				System.out.print("Enter math SAT: ");
			}
			try {
				mathSAT_Score = input.nextInt();
				isValid = mathSAT_Score >= MIN_SAT_MATH && mathSAT_Score <= MAX_SAT_MATH; // Check the condition
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
			if (!isValid) {
				System.out.println(
						"Math SAT Score not Valid!  The valid range must be (between 0-800) " + "\nTry again!! ");
			}
		}

		isValid = false;   // Set the isValid to false
		while (!isValid) { // isValid is now true, then prompt the user to enter valid data, if not valid, then Try again
			if (promptUser) {
				System.out.print("Enter verbal SAT: ");
			}
			try {
				verbalSAT_Score = input.nextInt();
				isValid = verbalSAT_Score >= MIN_SAT_VERBAL && verbalSAT_Score <= MAX_SAT_VERBAL; // Check the valid range
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
			if (!isValid) {
				System.out.println(
						"Verbal SAT Score is inValid! The valid range must be (between 0-400) " + "\nTry again!! ");
			}
		}

		isValid = false;  // Set the isValid to false
		while (!isValid) { // isValid is now true, then prompt the user to enter valid data, if not valid, then Try again
			if (promptUser) {
				System.out.print("Enter writing SAT: ");
			}
			try {
				writingSAT_Score = input.nextInt();
				isValid = writingSAT_Score >= MIN_SAT_WRITING && writingSAT_Score <= MAX_SAT_WRITING; // Check the valid range
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
			if (!isValid) {
				System.out.println(
						"Writing SAT Score is inValid!  The valid range must be (between 0-400) " + "\nTry again!! ");
			}
		}

		isValid = false; // Set the isValid to false
		while (!isValid) { // isValid is now true, then prompt the user to enter valid data, if not valid, then Try again
			if (promptUser) {
				System.out.print("Enter gpa: ");
			}
			try {
				gpa = input.nextDouble();
				isValid = gpa >= MIN_GPA && gpa <= MAX_GPA;
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
			if (!isValid) {
				System.out.println("GPA is inValid!  The valid range must be (between 0.0-4.0 " + "\nTry again!! ");
			}
		}
		isValid = false;
		while (!isValid) {
			if (promptUser) {
				System.out.print("Current decision: 'A' - accepted;"
						+ " 'R' - rejected; 'W' - waiting list; 'N' - no decision yet ");
			}
			try {
				decision = input.next().charAt(0);
				isValid = (decision == ACCEPTED) || (decision == REJECTED) || (decision == WAITING_LIST)
						|| (decision == NO_DECISION);
			} catch (InputMismatchException e) {
				e.printStackTrace();
			}
			if (!isValid) {
				System.out.println("Character Not Valid! Try again!! ");
			}
		}
	}

	// Public Method that return String lastName
	public String getLastName() {
		return lastName;
	}
	// Public Method that return String firstName
	public String getFirstName() {
		return firstName;
	}
	// Public Method the return integer mathSAT_Score
	public int getMathSATScore() {
		return mathSAT_Score;
	}
	// Public Method that return integer verbalSAT_Score
	public int getVerbalSATScore() {
		return verbalSAT_Score;
	}
	// Public Method that return integer writingSAT_Score
	public int getWritingSATScore() {
		return writingSAT_Score;
	}
	// Public Method that return double gpa
	public double getGPA() {
		return gpa;
	}
	// Public Method that return character decision
	public char getDecision() {
		return decision;
	}
	// Public Method toString that return String
	public String toString() {
		return "Here is the student record" + "\r\n--------------------------" + "\r\nLast Name: " + this.lastName
				+ "\r\nFirst Name: " + this.firstName + "\r\nMath SAT Score: " + this.mathSAT_Score
				+ "\r\nVerbal SAT Score: " + this.verbalSAT_Score + "\r\nWriting SAT Score: " + this.writingSAT_Score
				+ "\r\nGPA: " + this.gpa + "\r\nDecision: " + this.decision + "\n";
	}

}
