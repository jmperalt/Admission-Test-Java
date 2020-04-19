/*
  Jayson Peralta
  Homework #2
  Due October 31st, 2018
  This program is a recursive function that reads an integer array and an integer n and 
  replaces all the even numbers with n. This program will return the sum of the modified array.
 */
public class RecursiveFunction {
	public static void main(String[] args) {
		
		int [] intArray1 = {1,2,3}; // The even number replaces to n and add it all together
		int [] intArray2 = {1,7,3,2}; // The even number replaces to n and add it all together
		int [] intArray3 = {1,3,4,6,2,5}; // The even number replaces to n and add it all together
		
		System.out.println("The sum of intArray1 is " + replaceEvenSum(intArray1, 5) + "\n"); // In this case, n is 5
		System.out.println("The sum of intArray2 is " + replaceEvenSum(intArray2, 2) + "\n"); // In this case, n is 2
		System.out.println("The sum of intArray3 is " + replaceEvenSum(intArray3, 3) + "\n"); // In this case, n is 3
		
	}
	// Helper Function that replaces all even number to n
	public static int replaceEvenSum(int[] inputArray, int n) {
		return replaceEvenSum(inputArray, n, 0);
	}
	
	
	public static int replaceEvenSum(int[] inputArray, int n, int index) {
		// Transformation
		int value = inputArray[index]; // Make a variable that hold value of the index of the array
		if(value % 2 == 0) { // if the value is even, then assign n to value
			value = n;
		}
		// Base
		if(index == inputArray.length -1) { // if the n is equal to size of the array minus one because we want the index start at one
			return value;               // then return that value.
		
		}
		// Recursive call
		return value += replaceEvenSum(inputArray, n, index + 1); // Sum up all the value by calling the function recursively
														          // Increase n by one, so that it will move to another index and check again 
															      // If met all the condition above.
		
	}
	
	
}
